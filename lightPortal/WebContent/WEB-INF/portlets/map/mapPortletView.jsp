<%@ include file="/common/taglibs.jsp"%>
<html>
  <head>  
  </head>
    <body>
    <fmt:bundle basename="resourceBundle">
    <form name='<c:out value="${requestScope.responseId}"/>' onsubmit="showAddress(this.address.value,this.name); return false;">
      <table border='0' cellpadding='0' cellspacing='0'>
		<tr>
		<td class='portlet-table-td-left'>
        <input type="text" size="24" name="address" value="" class='portlet-form-input-field' />
        <input type="submit" value='<fmt:message key="portlet.button.go"/>' class='portlet-form-button'/>
        </td>
        </tr>
      </table>
      <div id="map"></div>
    </form>
    </fmt:bundle>
  </body>
</html>