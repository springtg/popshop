<%@ include file="/common/taglibs.jsp"%>
<html>
    <body>
    <fmt:bundle basename="resourceBundle">
    <form action="#" onsubmit="showMaxAddress(this.address.value); return false;">
      <table border='0' cellpadding='0' cellspacing='0'>
		<tr>
		<td class='portlet-table-td-left'>
        <input type="text" size="80" name="address" value="" class='portlet-form-input-field' />
        <input type="submit" value='<fmt:message key="portlet.button.go"/>' class='portlet-form-button'/>
        </td>
        </tr>
      </table>
      <div id="map" style="width: 800px; height: 800px; margin-left:5px;"></div>
    </form>
    </fmt:bundle>
  </body>
</html>