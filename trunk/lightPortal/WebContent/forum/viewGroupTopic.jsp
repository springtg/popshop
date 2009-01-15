<%@ include file="/common/taglibs.jsp"%>
 
<tiles:insert page="/layout/jstlLayoutAjax.jsp" flush="true">
    <tiles:put name="header" value="/layout/jstlHeader.jsp" />
    <tiles:put name="footer" value="/layout/jstlFooter.jsp" />
    <tiles:put name="menu"   value="/layout/jstlMenu.jsp" />
    <tiles:put name="body"   value="/forum/viewGroupTopicContent.jsp" />
</tiles:insert>
