<%@ include file="/common/taglibs.jsp"%>
<fmt:bundle basename="resourceBundle">
<textarea id="loading.view" style="display:none;">
	<font size='3'><fmt:message key="portlet.info.header1">><fmt:param value="${sessionScope.org.webId}"/></fmt:message></font><br/><br/><img src='light/images/loading.gif'/><br/>Loading...<br/>
</textarea>
<textarea id="loadingPortlet.view" style="display:none;">
<br/><span class='portlet-rss'><br/> 
<img src='<%= request.getContextPath() %>/light/images/loading.gif' border='0' />
&nbsp;&nbsp;<label>Loading...</label></span>
</textarea>
<c:if test='${requestScope.orgView != null}'>
<textarea id="infoPortlet.view" style="display:none;">
	<c:out value="${requestScope.orgView}"/>
</textarea>
</c:if>
<c:if test='${requestScope.orgMaxView != null}'>
<textarea id="infoPortlet.max.view" style="display:none;">
	<c:out value="${requestScope.orgMaxView}"/>
</textarea>
</c:if>
<c:if test='${requestScope.orgView == null}'>
<textarea id="infoPortlet.view" style="display:none;">
	<table border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td class="portlet-table-td-left"><br/><br/><font size='3'><fmt:message key="portlet.info.header1"><fmt:param value="${sessionScope.org.webId}"/></fmt:message></font></td>
	</tr>
	<tr>
	<td class="portlet-table-td-left">
	<p><br/><br/><font color='#ff6600'><b><fmt:message key="portlet.info.header2"><fmt:param value="${sessionScope.org.webId}"/></fmt:message></b></font><br/></p>
	<ul>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/recommended.gif)"><fmt:message key="portlet.info.list1"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/friend.gif)"><fmt:message key="portlet.info.list2"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/privacy.gif)"><fmt:message key="portlet.info.list3"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/group.gif)"><fmt:message key="portlet.info.list4"/></li>
	</ul>
	</td>
	</tr>    
	</table>
</textarea>
</c:if>
<c:if test='${requestScope.orgMaxView == null}'>
<textarea id="infoPortlet.max.view" style="display:none;">
	<table border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td class="portlet-table-td-left"><br/><br/><font size='3'><fmt:message key="portlet.info.header1"><fmt:param value="${sessionScope.org.webId}"/></fmt:message></font></td>
	</tr>
	<tr>
	<td class="portlet-table-td-left">
	<p><br/><br/><font color='#ff6600'><b><fmt:message key="portlet.info.header2"><fmt:param value="${sessionScope.org.webId}"/></fmt:message></b></font><br/></p>
	<ul>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/recommended.gif)"><fmt:message key="portlet.info.list1"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/friend.gif)"><fmt:message key="portlet.info.list2"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/privacy.gif)"><fmt:message key="portlet.info.list3"/></li>
	<li STYLE="padding:5px 15px 4px 6px; list-style-image:  url(light/images/group.gif)"><fmt:message key="portlet.info.list4"/></li>
	</ul>
	</td>
	</tr>    
	</table>
</textarea>
</c:if>
<textarea id="userPortlet.view" style="display:none;">
	<form name="form_${id}">
	<table border='0' cellpadding='0' cellspacing='0' width='90%'>
	<tr>
	<td class='portlet-link' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.showSignUp('${id}');" ><b><fmt:message key="portlet.label.signUp"/></b></a>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='email' ACCESSKEY='U'><fmt:message key="portlet.label.userId"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='text' name='email' value='${userId}' class='portlet-form-input-field' size='24' /> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='password' ACCESSKEY='P'><fmt:message key="portlet.label.userPassword"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='password' name='password' value='' class='portlet-form-input-field' size='24' onkeypress="return Light.keyDownLogin(event,'${id}');"/> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input TYPE='checkbox' name='rememberMe'  value='1'><label><fmt:message key="portlet.message.rememberMe"/></label></input>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input name='login' type='button' value='<fmt:message key="portlet.button.login"/>' class='portlet-form-button'
	  onclick="javascript:Light.loginPortal('${id}');" />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-link-left' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('${id}','edit','normal','type=forgot');" ><fmt:message key="portlet.label.forgotPassword"/></a>
	</td>
	</tr>
	</table>
	</form>
</textarea>
<textarea id="login.view" style="display:none;">
	<form name="form_${id}">
	<table border='0' cellpadding='0' cellspacing='0' width='90%'>
	<tr>
	<td class='portlet-link' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.showSignUp('${id}');" ><b><fmt:message key="portlet.label.signUp"/></b></a>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='email' ACCESSKEY='U'><fmt:message key="portlet.label.userId"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='text' name='email' value='${userId}' class='portlet-form-input-field' size='24' /> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='password' ACCESSKEY='P'><fmt:message key="portlet.label.userPassword"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='password' name='password' value='' class='portlet-form-input-field' size='24' onkeypress="return Light.keyDownLoginTo(event,'${id}');"/> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input TYPE='checkbox' name='rememberMe'  value='1'><label><fmt:message key="portlet.message.rememberMe"/></label></input>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input name='login' type='button' value='<fmt:message key="portlet.button.login"/>' class='portlet-form-button'
	  onclick="javascript:Light.loginToPortal('${id}');" />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-link-left' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('${id}','edit','normal','type=forgot');" ><fmt:message key="portlet.label.forgotPassword"/></a>
	</td>
	</tr>
	</table>
	</form>
</textarea>
<textarea id="loginPortal.view" style="display:none;">
	<form name="form_${id}">
	<table border='0' cellpadding='0' cellspacing='0' width='90%'>
	<tr>
	<td class='portlet-link' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.showSignUp('${id}');" ><b><fmt:message key="portlet.label.signUp"/></b></a>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='email' ACCESSKEY='U'><fmt:message key="portlet.label.userId"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='text' name='email' value='${userId}' class='portlet-form-input-field' size='24' /> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label FOR='password' ACCESSKEY='P'><fmt:message key="portlet.label.userPassword"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='password' name='password' value='' class='portlet-form-input-field' size='24' onkeypress="return Light.keyDownLogin(event,'${id}');"/> 
	</td>
	<td>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input TYPE='checkbox' name='rememberMe'  value='1'><label><fmt:message key="portlet.message.rememberMe"/></label></input>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-table-td-left'>
	<input name='login' type='button' value='<fmt:message key="portlet.button.login"/>' class='portlet-form-button'
	  onclick="javascript:Light.loginPortal('${id}');" />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'></td>
	<td class='portlet-link-left' colspan='3'>
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('${id}','edit','normal','type=forgot');" ><fmt:message key="portlet.label.forgotPassword"/></a>
	</td>
	</tr>
	</table>
	</form>
</textarea>
<textarea id="peopleDirectoryPortlet.view" style="display:none;">
	<form action="javascript:Light.executeAction('${id}',this.form,'find',null,null,'VIEW','maximized');">
	<table border='0' cellpadding='0' cellspacing='0' width='98%'>
	<tr>
	<td class='portlet-table-td-left'>
	<br/>
	<label><fmt:message key="portlet.label.findMember"/></label>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-left'>
	<br/>
	<input type='text' name='keyword' class='portlet-form-input-field-hint' size='32' value='<fmt:message key="portlet.label.findMemberBy"/>' onfocus="javascript:this.value='';"
		 onchange="javascript:this.form['input'].value='1';this.form.submit();"/> 
	<input type='hidden' name='input'  value ='0'/>
	<input name='action' type='submit' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>'/>
	</td>
	</tr>
	</table>
	</form>
</textarea>
<textarea id="registrationPortlet.view" style="display:none;">
	<form name='form_${id}' action="javascript:Light.executeAction('${id}',this.form,'step1',null,null,'VIEW','maximized');" onsubmit="javascript:return validateSignUp(this);">
	<table border='0' cellpadding='0' cellspacing='0' width='80%'>
	<tr>
	<td class='portlet-table-td-left' width='20%'>
	</td>
	<td class='portlet-table-td-left'>
	<br/>
	<p><b><fmt:message key="portlet.registration.label.signup.message1"/></b></p>
	<p><fmt:message key="portlet.registration.label.signup.message2"/></p>
	</td>
	</tr>
	</table>
	<table border='0' cellpadding='0' cellspacing='0' width='80%'>
	<tr>
	<td class='portlet-table-td-right' width='20%'>
	<img src='<%= request.getContextPath() %>/light/images/faq.gif' title='<fmt:message key="portlet.label.faq.email"/>' style='border: 0px;' width='16' height='16'/>
	<label FOR='email' ACCESSKEY='U'>*<fmt:message key="portlet.label.email"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='text' name='email' value='' class='portlet-form-input-field' size='30' onchange="validateUserId(this.value,'${id}');" AUTOCOMPLETE='OFF'/>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label>*<fmt:message key="portlet.label.userPassword"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='password' name='password' value=''
	class='portlet-form-input-field' size='30' />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label>*<fmt:message key="portlet.label.confirmPassword"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='password' name='confirmPassword' value=''
	class='portlet-form-input-field' size='30' />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label>*<fmt:message key="portlet.label.displayName"/>: </label></td>
	<td class='portlet-table-td-left'>
	<input type='text' name='displayName' value=''
	class='portlet-form-input-field' size='30' />
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'><label>*<fmt:message key="portlet.label.myUrl"/>: </label></td>
	<td class='portlet-table-td-left'>
	<label>http://www.<c:out value="${sessionScope.org.space}"/></label>
	<input type='text' name='myUri' value='' class='portlet-form-input-field' size='18' onchange="validateMyUri(this.value,'${id}');" AUTOCOMPLETE='OFF'/> 
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'></td>
	<td class='portlet-table-td-left'>
	<label><fmt:message key="portlet.message.accept1"/></label>
	<span class='portlet-item'> 
	<a href="javascript:void(0);" onclick="javascript:Light.showTerms();"><fmt:message key="portlet.message.accept2"/></a>
	</span>
	<label><fmt:message key="portlet.message.accept3"/></label>
	<span class='portlet-item'>  
	<a href="javascript:void(0);" onclick="javascript:Light.showPrivacy();"><fmt:message key="portlet.message.accept4"/></a>   
	</span>
	</input>
	</td>
	</tr>
	<tr>
	<td class='portlet-table-td-right'></td>
	<td class='portlet-table-td-left'>
	<input type='submit' name='action' value='<fmt:message key="portlet.button.register"/>' class='portlet-form-button' />
	<input type='button' name='action' onClick="javascript:Light.cancelSignUp('${id}');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
	</td>
	</tr>
	</table>
	</form>
</textarea>
<textarea id="searchBar.view" style="display:none;">
	<input type='text' id='portalSearch' class='portlet-form-input-field' size='24' value='' onchange="javascript:Light.portalSearch();"/>
	<a href="javascript:void(0);" onclick="javascript:Light.portalSearch();"><img src='<%= request.getContextPath() %>/light/images/search.gif' style='border: 0px' height='16' width='16' align='top' title='<fmt:message key="portlet.button.search"/>'/></a>
	<br/>
</textarea>
<textarea id="languages.menu" style="display:none;">
	<select name='psLanguages' size='1' class='portlet-form-select' style='width:100px;' onChange='javascript:Light.changeLanguage(this.value)'>
	<c:forEach var="language" items="${applicationScope.languages}" varStatus="status">
	<option value='<c:out value="${language.id}"/>' 
	<c:if test='${sessionScope.currentLocale == language.id}'>
	selected="selected"
	</c:if>
	>
	<c:out value="${language.desc}"/></option>
	</c:forEach>
	</select>
</textarea>
<textarea id="changeLanguagePortlet.view" style="display:none;">
<form name="form_${id}">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="language" items="${applicationScope.languages}" varStatus="status">
<c:if test='${status.index % 3 == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-left' width='33%'>
<c:if test='${language.supported}'>
<input type='radio' name='language' value='<c:out value="${language.id}"/>'
<c:if test='${sessionScope.currentLocale == language.id}'>
checked="checked"
</c:if>
>
<label><c:out value="${language.desc}"/></label></input>
</c:if>
<c:if test='${!language.supported}'>
<img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="20"/>
<label><c:out value="${language.desc}"/></label>
</c:if>
</td>
<c:if test='${status.index % 3 == 2}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${applicationScope.languageCount % 3 != 0}'>
</tr>
</c:if>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right'>
<input name='Save' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'
 onclick="javascript:Light.saveLanguage('${id}',true);" />
<input name='Cancel' type='button' value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button'
 onclick="javascript:Light.closePortlet('${id}');" />
</td>
</tr>
</table>
</form>
</textarea>

<textarea id="footer.view" style="display:none;">
<span class="portal-header-menu-item">
	<label class="portal-footer-notes"><c:out value="${sessionScope.org.webId}"/> © <c:out value="${sessionScope.org.currentYear}"/></label>
	<span class="portal-header-menu-item-separater"></span>
	<a onclick="javascript:Light.showAbout();" href="javascript:void(0)"><fmt:message key="portlet.lebel.about"/></a>
	<span class="portal-header-menu-item-separater"></span>
	<a onclick="javascript:Light.showFAQ();" href="javascript:void(0)"><fmt:message key="portlet.lebel.faq"/></a>
	<span class="portal-header-menu-item-separater"></span>
	<a onclick="javascript:Light.showTerms();" href="javascript:void(0)"><fmt:message key="portlet.lebel.terms"/></a>
	<span class="portal-header-menu-item-separater"></span>
	<a onclick="javascript:Light.showPrivacy();" href="javascript:void(0)"><fmt:message key="portlet.lebel.privacy"/></a>
	<span class="portal-header-menu-item-separater"></span>
	<a onclick="javascript:Light.showContactUs();" href="javascript:void(0)"><fmt:message key="portlet.lebel.contactUs"/></a>
	<span class="portal-header-menu-item-separater"></span>	
</span>
</textarea>

<c:forEach var="bean" items="${requestScope.list}">
<var id='<c:out value="${bean.id}"/>' title= '<c:out value="${bean.desc}"/>'/>
</c:forEach>

<var id="_VIEW_MODE" title= '<fmt:message key="_VIEW_MODE"/>'/>
<var id="_EDIT_MODE" title='<fmt:message key="_EDIT_MODE"/>'/>
<var id="_HELP_MODE" title='<fmt:message key="_HELP_MODE"/>'/>
<var id="_CONFIG_MODE" title='<fmt:message key="_CONFIG_MODE"/>'/>
<var id="_REFRESH_PORTLET" title= '<fmt:message key="_REFRESH_PORTLET"/>'/>
<var id="_MOVE_UP" title= '<fmt:message key="_MOVE_UP"/>'/>
<var id="_MOVE_DOWN" title= '<fmt:message key="_MOVE_DOWN"/>'/>
<var id="_MINIMIZED" title='<fmt:message key="_MINIMIZED"/>'/>
<var id="_RESTORE_MINIMIZED" title='<fmt:message key="_RESTORE_MINIMIZED"/>'/>
<var id="_MAXIMIZED" title='<fmt:message key="_MAXIMIZED"/>'/>
<var id="_RESTORE_MAXIMIZED" title='<fmt:message key="_RESTORE_MAXIMIZED"/>'/>
<var id="_RESTORE" title='<fmt:message key="_RESTORE"/>'/>
<var id="_CLOSE" title='<fmt:message key="_CLOSE"/>'/>
<var id="_MENU_HOME" title= '<fmt:message key="_MENU_HOME"/>''/>
<var id="_MENU_LOOK_AND_FEEL" title= '<fmt:message key="_MENU_LOOK_AND_FEEL"/>''/>
<var id="_MENU_LAYOUT" title= '<fmt:message key="_MENU_LAYOUT"/>'/>
<var id="_MENU_ADD_TAB" title= '<fmt:message key="_MENU_ADD_TAB"/>'/>
<var id="_MENU_ADD_SUBTAB" title= '<fmt:message key="_MENU_ADD_SUBTAB"/>'/>
<var id="_MENU_ADD_CONTENT" title= '<fmt:message key="_MENU_ADD_CONTENT"/>'/>
<var id="_MENU_SIGN_UP" title= '<fmt:message key="_MENU_SIGN_UP"/>'/>
<var id="_MENU_SIGN_IN" title= '<fmt:message key="_MENU_SIGN_IN"/>'/>
<var id="_MENU_SEARCH" title= '<fmt:message key="portlet.button.search"/>'/>
<var id="_MENU_MY_PROFILE" title= '<fmt:message key="_MENU_MY_PROFILE"/>'/>
<var id="_MENU_MY_PICTURE" title= '<fmt:message key="_MENU_MY_PICTURE"/>'/>
<var id="_MENU_MY_MUSIC" title= '<fmt:message key="_MENU_MY_MUSIC"/>'/>
<var id="_MENU_MY_FILE" title= '<fmt:message key="_MENU_MY_FILE"/>'/>
<var id="_MENU_MY_BLOG" title= '<fmt:message key="_MENU_MY_BLOG"/>'/>
<var id="_MENU_MY_FAVOURITE " title= '<fmt:message key="_MENU_MY_FAVOURITE"/>'/>
<var id="_MENU_MY_VIEWED" title= '<fmt:message key="_MENU_MY_VIEWED"/>'/>
<var id="_MENU_MY_RECOMMENDED" title= '<fmt:message key="_MENU_MY_RECOMMENDED"/>'/>
<var id="_MENU_RANK_ME" title='<fmt:message key="_MENU_RANK_ME"/>'/>
<var id="_MENU_MY_ACCOUNT" title= '<fmt:message key="_MENU_MY_ACCOUNT"/>'/>
<var id="_MENU_MESSAGE_INBOX" title= '<fmt:message key="_MENU_MESSAGE_INBOX"/>'/>
<var id="_MENU_MESSAGE_SENT" title= '<fmt:message key="_MENU_MESSAGE_SENT"/>'/>
<var id="_MENU_MESSAGE_SEND" title='<fmt:message key="_MENU_MESSAGE_SEND"/>'/>
<var id="_MENU_MESSAGE_FORWARD" title= '<fmt:message key="_MENU_MESSAGE_FORWARD"/>'/>
<var id="_MENU_FRIEND_REQUEST" title= '<fmt:message key="_MENU_FRIEND_REQUEST"/>'/>
<var id="_MENU_INVITE_FRIEND" title= '<fmt:message key="_MENU_INVITE_FRIEND"/>'/>
<var id="_MENU_RANK" title= '<fmt:message key="_MENU_RANK"/>'/>
<var id="_MENU_GROUP" title= '<fmt:message key="_MENU_GROUP"/>'/>
<var id="_MENU_TODO" title= '<fmt:message key="_MENU_TODO"/>'/>
<var id="_MENU_CALENDAR" title= '<fmt:message key="_MENU_CALENDAR"/>'/>
<var id="_MENU_GROUP_EDIT" title= '<fmt:message key="_MENU_GROUP_EDIT"/>'/>
<var id="_MENU_GROUP_INVITE" title= '<fmt:message key="_MENU_GROUP_INVITE"/>'/>
<var id="_MENU_GROUP_MEMBERS" title= '<fmt:message key="_MENU_GROUP_MEMBERS"/>'/>
<var id="_MENU_GROUP_BULLETIN " title= '<fmt:message key="_MENU_GROUP_BULLETIN"/>'/>
<var id="_MENU_GROUP_PICTURES" title= '<fmt:message key="_MENU_GROUP_PICTURES"/>'/>
<var id="_MENU_GROUP_UPLOAD_PICTURE " title= '<fmt:message key="_MENU_GROUP_UPLOAD_PICTURE"/>'/>
<var id="_MENU_SIGN_OUT" title= '<fmt:message key="_MENU_SIGN_OUT"/>'/>
<var id="_MENU_TURN_OFF" title= '<fmt:message key="_MENU_TURN_OFF"/>'/>
<var id="_MENU_EXPAND_ALL" title= '<fmt:message key="_MENU_EXPAND_ALL"/>'/>
<var id="_MENU_COLLAPSE_ALL" title= '<fmt:message key="_MENU_COLLAPSE_ALL"/>'/>
<var id="_MENU_ABOUT" title='<fmt:message key="_MENU_ABOUT"/>'/>
<var id="_MENU_FAQ" title='<fmt:message key="_MENU_FAQ"/>'/>
<var id="_MENU_TERMS" title='<fmt:message key="_MENU_TERMS"/>'/>
<var id="_MENU_PRIVACY" title='<fmt:message key="_MENU_PRIVACY"/>'/>
<var id="_MENU_CONTACT_US" title='<fmt:message key="_MENU_CONTACT_US"/>'/>
<var id="_LABEL_NEW_TAB" title= '<fmt:message key="_LABEL_NEW_TAB"/>'/>
<var id="_LABEL_SUBJECT" title= '<fmt:message key="_LABEL_SUBJECT"/>'/>
<var id="_LABEL_CONTENT" title= '<fmt:message key="_LABEL_CONTENT"/>'/>
<var id="_LABEL_COMMENT" title= '<fmt:message key="_LABEL_COMMENT"/>'/>
<var id="_LABEL_NAME" title='<fmt:message key="_LABEL_NAME"/>'/>
<var id="_LABEL_EMAIL" title='<fmt:message key="_LABEL_EMAIL"/>'/>
<var id="_LABEL_URL" title='<fmt:message key="_LABEL_URL"/>'/>
<var id="_BUTTON_EMAIL" title= '<fmt:message key="_BUTTON_EMAIL"/>'/>
<var id="_BUTTON_CHAT" title= '<fmt:message key="_BUTTON_CHAT"/>'/>
<var id="_BUTTON_MESSAGE" title= '<fmt:message key="_BUTTON_MESSAGE"/>'/>
<var id="_BUTTON_ADD_BUDDY" title= '<fmt:message key="_BUTTON_ADD_BUDDY"/>'/>
<var id="_BUTTON_DELETE" title= '<fmt:message key="_BUTTON_DELETE"/>'/>
<var id="_BUTTON_CANCEL" title= '<fmt:message key="_BUTTON_CANCEL"/>'/>
<var id="_BUTTON_SEND" title= '<fmt:message key="_BUTTON_SEND"/>'/>
<var id="_BUTTON_OK" title= '<fmt:message key="_BUTTON_OK"/>'/>
<var id="_BUTTON_CANCEL" title= '<fmt:message key="_BUTTON_CANCEL"/>'/>
<var id="_BUTTON_SAVE" title='<fmt:message key="_BUTTON_SAVE"/>'/>
<var id="_TITLE_CHAT" title= '<fmt:message key="_TITLE_CHAT"/>'/>
<var id="_TITLE_LANGUAGE" title= '<fmt:message key="_TITLE_LANGUAGE"/>'/>
<var id="_DELETE_BLOG" title='<fmt:message key="_DELETE_BLOG"/>'/>
<var id="_COMMAND_CLOSE_TAB" title= '<fmt:message key="_COMMAND_CLOSE_TAB"/>'/>
<var id="_COMMAND_CLOSE_PORTLET" title= '<fmt:message key="_COMMAND_CLOSE_PORTLET"/>'/>
<var id="_COMMAND_CLOSE_POPUP_PORTLET" title= '<fmt:message key="_COMMAND_CLOSE_POPUP_PORTLET"/>'/>
<var id="_COMMAND_DELETE_CALENDAR_EVENT" title= '<fmt:message key="_COMMAND_DELETE_CALENDAR_EVENT"/>'/>
<var id="_COMMAND_DELETE_CALENDAR_EVENTS" title= '<fmt:message key="_COMMAND_DELETE_CALENDAR_EVENTS"/>'/>
<var id="_ERROR_PASSWORD_NOT_EQUAL" title= '<fmt:message key="_ERROR_PASSWORD_NOT_EQUAL"/>'/>
<var id="_ERROR_FIELDS_REQUIRED" title= '<fmt:message key="_ERROR_FIELDS_REQUIRED"/>' />
<var id="_ERROR_ACCEPT_TERM_PRIVACY" title= '<fmt:message key="_ERROR_ACCEPT_TERM_PRIVACY"/>'/>
<var id="_ERROR_MINUTE_RATE" title= '<fmt:message key="_ERROR_MINUTE_RATE"/>'/>
<var id="_ERROR_EMAIL_FORMAT" title= '<fmt:message key="_ERROR_EMAIL_FORMAT"/>'/>
<var id="_ERROR_EMAIL_DUPLICATED" title= '<fmt:message key="_ERROR_EMAIL_DUPLICATED"/>'/>
</fmt:bundle>