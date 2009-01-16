//------------------------------------------------------------ lightUtil.js
Light.setCookie = function (name, value, expires, path, domain, secure)
{
    document.cookie= name + "=" + escape(value) +
        ((expires) ? "; expires=" + expires.toGMTString() : "") +
        ((path) ? "; path=" + path : "; path= /") +
        ((domain) ? "; domain=" + domain : "") +
        ((secure) ? "; secure" : "");
}

Light.getCookie = function (name)
{
    var dc = document.cookie;
    if(dc == null) return null;
    var prefix = name + "=";
    var begin = dc.indexOf("; " + prefix);
    if (begin == -1)
    {
        begin = dc.indexOf(prefix);
        if (begin != 0) return null;
    }
    else
    {
        begin += 2;
    }
    var end = document.cookie.indexOf(";", begin);
    if (end == -1)
    {
        end = dc.length;
    }
    return unescape(dc.substring(begin + prefix.length, end));
}

Light.deleteCookie = function(name, path, domain)
{
    if (Light.getCookie(name))
    {
        document.cookie = name + "=" + 
            ((path) ? "; path=" + path : "; path= /") +
            ((domain) ? "; domain=" + domain : "") +
            "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    }
}

function log(message) {
}

function logDebug(message) {
    if (!log.window_ || log.window_.closed) {
        var win = window.open("", null, "width=400,height=200," +
                              "scrollbars=yes,resizable=yes,status=no," +
                              "location=no,menubar=no,toolbar=no");
        if (!win) return;
        var doc = win.document;
        doc.write("<html><head><title>Debug Log</title></head>" +
                  "<body></body></html>");
        doc.close();
        log.window_ = win;
    }
    var logLine = log.window_.document.createElement("div");
    logLine.appendChild(log.window_.document.createTextNode(message));
    log.window_.document.body.appendChild(logLine);
    logLine = null;
    
}

String.prototype.isDigit = function() {
	if (this.length>1){return false;}
	var string="1234567890";
	if (string.indexOf(this)!=-1){return true;}
	return false;
}

String.prototype.trim = function () {
    return this.replace(/^\s+|\s+$/g, "");
}

String.prototype.startsWith = function(str){
	//return (this.match("^"+str)==str)
	return this.substring(0,str.length) == str;
}

String.prototype.endsWith = function(str){
	return (this.match(str+"$")==str)
}

function isIE()
{
	return /msie/i.test(navigator.userAgent) && !/opera/i.test(navigator.userAgent);
}

function getX( oElement ){
	var iReturnValue = 0;
	if(!isIE()){
	while( oElement != null ) {
		iReturnValue += oElement.offsetLeft;
			oElement = oElement.offsetParent;
		}
	}else{
		var obj = oElement.getBoundingClientRect();		
		iReturnValue = obj.left;
	}
	return iReturnValue;
}

function getY( oElement ){
	var iReturnValue = 0;
	if(!isIE()){
	while( oElement != null ) {
		iReturnValue += oElement.offsetTop;
			oElement = oElement.offsetParent;
		}
	}else{
		var obj = oElement.getBoundingClientRect();		
		iReturnValue = obj.top;
	}
	return iReturnValue;
}

initMap = function (id) {
  if (GBrowserIsCompatible()) {
    var divMap =document.getElementById("map");
    divMap.style.width= 280;
    divMap.style.height = 300;
    var portlet = Light.getPortletById(id);
    Light.portal.tabs[portlet.tIndex].rePositionPortlets(portlet);
    map = new GMap2(document.getElementById("map"));
    map.addControl(new GSmallMapControl());
	map.addControl(new GMapTypeControl());
    map.setCenter(new GLatLng(37.4419, -122.1419), 13);
    geocoder = new GClientGeocoder();
  }
}

showAddress = function (address,id) {
  initMap(id);
  if (geocoder) {
    geocoder.getLatLng(
      address,
      function(point) {
        if (!point) {
          alert(address + " not found");
        } else {
          map.setCenter(point, 13);
          var marker = new GMarker(point);
          map.addOverlay(marker);
          marker.openInfoWindowHtml(address);
        }
      }
    );
  }
}

initMaxMap = function () {
  if (GBrowserIsCompatible()) {
    map = new GMap2(document.getElementById("map"));
    map.addControl(new GSmallMapControl());
	map.addControl(new GMapTypeControl());
    map.setCenter(new GLatLng(37.4419, -122.1419), 13);
    geocoder = new GClientGeocoder();
  }
}

showMaxAddress = function (address) {
  initMaxMap();
  if (geocoder) {
    geocoder.getLatLng(
      address,
      function(point) {
        if (!point) {
          alert(address + " not found");
        } else {
          map.setCenter(point, 13);
          var marker = new GMarker(point);
          map.addOverlay(marker);
          marker.openInfoWindowHtml(address);
        }
      }
    );
  }
}

/**
*
*  AJAX IFRAME METHOD (AIM)
*  http://www.webtoolkit.info/
*
**/

AIM = {
    portletId : null
    ,
	frame : function(c) {
		var n = 'f' + Math.floor(Math.random() * 99999);
		var d = document.createElement('DIV');
		d.innerHTML = '<iframe style="display:none" src="about:blank" id="'+n+'" name="'+n+'" onload="AIM.loaded(\''+n+'\')"></iframe>';
		document.body.appendChild(d);

		var i = document.getElementById(n);
		if (c && typeof(c.onComplete) == 'function') {
			i.onComplete = c.onComplete;
		}

		return n;
	},

	form : function(f, name) {
		f.setAttribute('target', name);
	},

	submit : function(f, c,portletId) {
	    AIM.portletId = portletId;
		AIM.form(f, AIM.frame(c));
		if (c && typeof(c.onStart) == 'function') {
			return c.onStart(portletId);
		} else {
			return true;
		}
	},

	loaded : function(id) {
		var i = document.getElementById(id);
		if (i.contentDocument) {
			var d = i.contentDocument;
		} else if (i.contentWindow) {
			var d = i.contentWindow.document;
		} else {
			var d = window.frames[id].document;
		}
		if (d.location.href == "about:blank") {
			return;
		}

		if (typeof(i.onComplete) == 'function') {
			i.onComplete(AIM.portletId);
		}
	}

}