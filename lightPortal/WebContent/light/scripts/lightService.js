//------------------------------------------------------------ lightService.js
Light.Service  = function (){
	log("initialize Light.Service");
}
Light.Service.prototype.getPortalHeader = function(portal){
  return new LightPortalHeaderImpl().render(portal);
}
Light.Service.prototype.getPortalMenu = function(portal){
  return new LightPortalMenuImpl().render(portal);
}
Light.Service.prototype.getPortalFooter = function(portal){
  return new LightPortalFooterImpl().render(portal);
}