<%@ include file="/common/taglibs.jsp"%>
<fmt:bundle basename="resourceBundle">
<textarea id="sessionTimeoutWarning.jst" style="display:none;">
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-center' style="color:red;">
        Warning! Due to inactivity, your session will expire in 00:00:${timeLeft}. To extend your session another 10 minute(s), please press the "Extend" button
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-center' >
      <input name='reactive' type='button' value='<fmt:message key="portlet.button.extend"/>' onclick="javascript:Light.refreshSessionTiimeout();" />
    </td>
    </tr>
  </table>
</textarea>

<textarea id="addFeed.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hideTopPopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myFeedForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Add My Feed
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Enter a URL (RSS/ATOM or autodiscovery):
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-left' >
      <input type='text' name='pcFeed' value='' size='30' />
      <input name='AddFeed' type='button' value='Add' onclick="javascript:addFeed('${id}');" />
    </td>
    </tr>
  </table>
</form>
<form name='myFeedFileForm' enctype='multipart/form-data' method='post'
  action ='<%= request.getContextPath() %>/uploadOpml.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '${id}')" >
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Or import an OPML file:
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <input type='file' name='file' />
        <input type='submit' value='Upload' />
      </td>
    </tr>
    <tr>
  </table>
</form>
</textarea>

<textarea id="addAllFeed.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hideTopPopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='allFeedFileForm' enctype='multipart/form-data' method='post'
  action ='<%= request.getContextPath() %>/uploadAllOpml.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '${id}')" >
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Import an OPML file:
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <input type='file' name='file' />
        <input type='submit' value='Upload' />
      </td>
    </tr>
    <tr>
  </table>
</form>
</textarea>

<textarea id="addFeaturedFeed.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hideTopPopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myFeaturedFeedForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Add Feed
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Enter a URL (RSS/ATOM or autodiscovery):
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-left' >
      <input type='text' name='pcFeed' value='' size='30' />
      <input name='AddFeaturedFeed' type='button' value='Add' onclick="javascript:addFeaturedFeed('${id}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="addCategoryFeed.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hideTopPopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myCategoryFeedForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Add Feed
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Enter a URL (RSS/ATOM or autodiscovery):
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-left' >
      <input type='text' name='pcFeed' value='' size='30' />
      <input name='AddCategoryFeed' type='button' value='Add' onclick="javascript:addCategoryFeed('${id}','${tag}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="addSubCategoryFeed.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hideTopPopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='mySubCategoryFeedForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Add Feed
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Enter a URL (RSS/ATOM or autodiscovery):
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-left' >
      <input type='text' name='pcFeed' value='' size='30' />
      <input name='AddSubCategoryFeed' type='button' value='Add' onclick="javascript:addSubCategoryFeed('${id}','${tag}','${subtag}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="editProfilePhoto.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick='javascript:hideEditProfilePhoto();'>
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<br/>
<span>
Share your photos to let friends and other members see who you are.<br/> 
Photos may not contain nudity, sexually explicit content, violent or offensive material, or copyrighted images. Do not load images of other people without their permission.
</span>
<form name='editProfilePhotoForm' enctype='multipart/form-data' method='post'
  action ='<%= request.getContextPath() %>/uploadProfilePhoto.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '${id}')">
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Upload Photo :
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <input type='file' name='file' size='30' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-right' >
        <input type='submit' value='${ok}' class='portlet-form-button' />
      </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="editMyUrl.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick='javascript:hideEditMyUrl();'>
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='editMyUrlForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        URI :
      </td>    
      <td class='portlet-table-td-left' >
      <input type='text' name='uri' value='' size='18' />     
      </td>
    </tr>
    <tr>
	<td class='portlet-table-td-right' colspan='2' >
	<input type='button' onClick="javascript:saveMyUrl('${id}');"  value='${ok}' class='portlet-form-button' />
	<input type='button' onClick='javascript:hideEditMyUrl();' value='${cancel}' class='portlet-form-button' />
	</td>
	</tr>
  </table>
</form>
</textarea>

<textarea id="uploadPictures.jst" style="display:none;">	
	<table width="640" cellspacing="0" border="0">   
    <tr valign="top">
        <td colspan="2" align="center"><br/>
        <applet code="wjhk.jupload2.JUploadApplet"
            archive="wjhk.jupload.jar" width="640" height="400" alt=""
            mayscript>
            <param name="postURL" value="http://www.<c:out value="${sessionScope.org.webId}"/>/uploadPictures.lp" />
            <param name="maxChunkSize" value="3000000" />
			<param name="maxFileSize" value="3000000" />
            <param name="uploadPolicy" value="PictureUploadPolicy" />
            <param name="nbFilesPerRequest" value="1" />    
            <param name="allowedFileExtensions" value="gif/jpg/jpeg/png"/>    
            <param name="afterUploadURL" value="javascript:Light.closeUploader('${id}','${popupName}');" /> 
            <param name="showLogWindow" value="false" />    
            <!-- Optionnal, see code comments -->
            <param name="debugLevel" value="1" />
            <!-- Optionnal, see code comments --> 
			Java 1.5 or higher plugin required. 
	  	</applet>        
        </td>
        <td class='portlet-table-td-right'>
        	<a href='javascript:void(0);' onclick="javascript:Light.closeUploader('${id}','${popupName}');">
			<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>	
        </td>
    </tr>   
  	</table>
</textarea>

 <textarea id="uploadMusics.jst" style="display:none;">	
	<table width="640" cellspacing="0" border="0">   
    <tr valign="top">
        <td colspan="2" align="center"><br/>
        <applet code="wjhk.jupload2.JUploadApplet"
            archive="wjhk.jupload.jar" width="640" height="400" alt=""
            mayscript>
            <param name="postURL" value="http://www.<c:out value="${sessionScope.org.webId}"/>/uploadMusics.lp" />
            <param name="maxChunkSize" value="5000000" />
			<param name="maxFileSize" value="5000000" />
            <param name="uploadPolicy" value="DefaultUploadPolicy" />
            <param name="nbFilesPerRequest" value="1" />    
            <param name="allowedFileExtensions" value="mp3/mp4/wav/wma"/>    
            <param name="afterUploadURL" value="javascript:Light.closeUploader('${id}','${popupName}');" /> 
            <param name="showLogWindow" value="false" />    
            <!-- Optionnal, see code comments -->
            <param name="debugLevel" value="1" />
            <!-- Optionnal, see code comments --> 
			Java 1.5 or higher plugin required. 
	  	</applet>        
        </td>
        <td class='portlet-table-td-right'>
        	<a href='javascript:void(0);' onclick="javascript:Light.closeUploader('${id}','${popupName}');">
			<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>	
        </td>
    </tr>   
  	</table>
</textarea> 

<%
java.util.List<org.light.portal.util.LabelBean> bgImages = org.light.portal.util.ConfigurationUtil.getSupportedBgImages();
request.setAttribute("bgImages",bgImages);
request.setAttribute("bgColumn",5);
request.setAttribute("bgImagesCount",bgImages.size());
%>
<textarea id="moreBgImage.jst" style="display:none;">
<form name='form_moreBgImage'>
<table border='0' cellpadding='0' cellspacing='0'>
<c:forEach var="image" items="${requestScope.bgImages}" varStatus="status">
<c:if test='${status.index % bgColumn == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-left'><image height='40' width='200' src='<%= request.getContextPath() %><c:out value="${image.id}"/>' style='border: 0px' />
<input type='radio' name='ptBg' value='<c:out value="${image.id}"/>' {if bgImage == '<c:out value="${image.id}"/>'}checked='true'{/if}/>
</td>
<c:if test='${status.index % bgColumn == bgColumn - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.bgImagesCountt % bgColumn != 0}'>
</tr>
</c:if>

<tr>
<td class='portlet-table-td-right' colspan='5'>
<input type='button' value='${ok}' onclick="javascript:saveBgImage('${id}');" class='portlet-form-button'/>
<input type='button' value='${cancel}' onclick='javascript:cancelBgImage();' class='portlet-form-button'/>
</td>
</tr>

</table>
</form>
</textarea>

<%
java.util.List<org.light.portal.util.LabelBean> headerImages = org.light.portal.util.ConfigurationUtil.getSupportedHeaderImages();
request.setAttribute("headerImages",headerImages);
request.setAttribute("headerColumn",2);
request.setAttribute("headerImagesCount",headerImages.size());
%>
<textarea id="moreHeaderImage.jst" style="display:none;">
<form name='form_moreHeaderImage'>
<table border='0' cellpadding='0' cellspacing='0'>
<c:forEach var="image" items="${requestScope.headerImages}" varStatus="status">
<c:if test='${status.index % headerColumn == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-left'><image height='40' width='200' src='<%= request.getContextPath() %><c:out value="${image.id}"/>' style='border: 0px' />
<input type='radio' name='ptHeader' value='<c:out value="${image.id}"/>' {if headerImage == '<c:out value="${image.id}"/>'}checked='true'{/if}/>
</td>
<c:if test='${status.index % headerColumn == headerColumn - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.headerImagesCount % headerColumn != 0}'>
</tr>
</c:if>

<tr>
<td class='portlet-table-td-right' colspan='2'>
<input type='button' value='${ok}' onclick="javascript:saveHeaderImage('${id}');" class='portlet-form-button'/>
<input type='button' value='${cancel}' onclick='javascript:cancelHeaderImage();' class='portlet-form-button'/>
</td>
</tr>
</table>
</form>
</textarea>


<textarea id="replyForum.jst" style="display:none;">
<span title='${title}'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideForumReply();'><img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a></span>
<form name='forumReplyForm'>
<input type='hidden' name='parentId' value='${parentId}'/>
<input type='hidden' name='topId' value='${topId}'/>
<table border='0' cellpadding='0' cellspacing='0' >
<tr>
<td class='portlet-table-td-left'>
${labelSubject}:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='subject' value='${subject}' class='portlet-form-input-field' size='50' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
${labelContent}:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='60' />
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='button' onClick="javascript:saveForumReply('${portletId}');"  value='${ok}' class='portlet-form-button' />
<input type='button' onClick='javascript:hideForumReply();' value='${cancel}' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</textarea>		

<textarea id="instantMessage.jst" style="display:none;">
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        ${user} want to IM you.<br/>Would you like to accept?
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input name='yes' type='button' value='Yes' onclick="javascript:acceptChat('${param}');" />
      <input name='no' type='button' value='No' onclick="javascript:refuseChat('${param}');" />
    </td>
    </tr>
  </table>
  <embed src='<%= request.getContextPath() %>${ringTone}' autostart="true" loop="false" width="2" height="0">
  </embed>
</textarea>

<textarea id="addToFriend.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to add <b>
       	<c:if test='${sessionScope.visitedUser != null}'>
        <c:out value="${sessionScope.visitedUser.displayName}"/>
        </c:if>
        <c:if test='${sessionScope.visitedUser == null}'>
        ${buddyName}
        </c:if>
        </b> as a friend?<br/>Click "${ok}" only if you reallly what to add <b><c:out value="${sessionScope.visitedUser.displayName}"/></b> as a friend.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:Light.saveAddToFriend('${id}','${buddyId}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="responseAddToFriend.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        A email has been sent to the user for your request to add this user as friend.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<pre id="sendMessage.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
	<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
		<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/>
	</a>
</span>
<form id='sendMessageForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
     	<td class='portlet-table-td-left' width='15%'>
			<fmt:message key="portlet.label.to"/>:
		</td>
		<td class='portlet-table-td-left'>
			${buddyName}
		</td>
    </tr> 
    <tr>
		<td class='portlet-table-td-left' width='15%'>
			<fmt:message key="portlet.label.subject"/>:
		</td>
		<td class='portlet-table-td-left'>
			<input type='text' name='subject' value='' class='portlet-form-input-field' size='40' /> 
		</td>
	</tr>
	<tr>
		<td class='portlet-table-td-left' colspan='2'>
			<fmt:message key="portlet.label.content"/>:
		</td>
	</tr>
	<tr>
		<td class='portlet-table-td-left' colspan='2'>
			<textarea name='content' class='portlet-form-textarea-field' rows='4' cols='42'></textarea>
		</td>
	</tr>   
    <tr>
    <td class='portlet-table-td-center' colspan='2'>
      <input type='button' value='${ok}' onclick="javascript:Light.sendMessageAction('${id}','${buddyId}','${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</form>
</pre>

<textarea id="responseSendMessageAction.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        {if value == 0}
        	Please login first.
        	<input type='button' value='${ok}' onclick="javascript:Light.login();hidePopupDiv('${popupName}');" class='portlet-form-button'/>
        {elseif value == -1}
        	Error, please try to send message again.
        {else}
        	This Message has been sent successfully.
        {/if}
      </td>
    </tr>   
    {if value != 0} 
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
    {/if}
  </table>
</textarea>

<textarea id="forwardToFriends.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to forward <b><c:out value="${sessionScope.visitedUser.displayName}"/></b> to your friends?<br/>Click "${ok}" only if you reallly what to forward <b><c:out value="${sessionScope.visitedUser.displayName}"/></b> to your friends.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:Light.saveForwardToFriends('${id}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="responseForwardToFriends.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        This user has been forwarded to your Friends.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="addToFavorites.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to add <b><c:out value="${sessionScope.visitedUser.displayName}"/></b> to your favourites?<br/>Click "${ok}" only if you reallly what to add <b><c:out value="${sessionScope.visitedUser.displayName}"/></b> to your favourites.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:Light.saveAddToFavorites('${id}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="responseAddToFavorites.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        This user has been added to your Favorites.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="blockUser.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to block <b><c:out value="${sessionScope.visitedUser.displayName}"/></b>?<br/>Click "${ok}" only if you reallly what to block <b><c:out value="${sessionScope.visitedUser.displayName}"/></b>.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:Light.saveBlockUser('${id}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="responseBlockUser.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        This user has been blocked.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="isBlockUser.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        ${userName} has blocked you, so you cannot Instant Message to ${userName}.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <br/><br/>
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>


<textarea id="noIM.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        ${userName} don't accept anyone's Instant Message.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <br/><br/>
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="friendOnlyIM.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        ${userName} only accept friend's Instant Message.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <br/><br/>
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="joinToGroup1.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        You have joined to this group successfully.
      </td>
    </tr>        
  </table>
</textarea>

<textarea id="joinToGroup2.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        You are a member of this group already.<br/><br/>
      </td>
    </tr>        
  </table>
</textarea>

<textarea id="joinToGroup3.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        You need to be approved to become a member of this group.<br/>
        A message has been sent to this group's owner to approve your request.<br/>
      </td>
    </tr>        
  </table>
</textarea>

<textarea id="joinToGroup0.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        This group was deleted by Owner.<br/><br/>
      </td>
    </tr>        
  </table>
</textarea>
<textarea id="joinToGroup9.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Please login first, then click join button again.<br/><br/>
      </td>
    </tr>        
  </table>
</textarea>

<textarea id="inviteToGroup.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        You have invited the following friends to this group:<br/>${friendsName}
      </td>
    </tr> 
    <tr>
    <td class='portlet-table-td-right' >
      <br/><br/>
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>       
  </table>
</textarea>

<textarea id="resign.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to resign from group <b><c:out value="${sessionScope.visitedGroup.displayName}"/></b>?<br/><br/>Click "${ok}" only if you reallly what to resign from group <b><c:out value="${sessionScope.visitedUser.displayName}"/></b>.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <br/><br/>
      <input type='button' value='${ok}' onclick="javascript:resignGroup('${groupId}','${responseId}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>

<textarea id="groupPrivacy.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='form_groupPrivacy'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        <input TYPE='checkbox' name='lBulletin' value='1' {if acceptLeaderBulletin == 1}checked='true'{/if}>Check here to display bulletins from this moderator in my bulletin space</input>        
      </td>
    </tr>  
    <tr>
      <td class='portlet-table-td-left' >
        <input TYPE='checkbox' name='mBulletin' value='1' {if acceptMembersBulletin == 1}checked='true'{/if}>Check here to display bulletins from members of this group in my bulletin space</input>
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <input type='button' value='${ok}' onclick="javascript:saveGroupPrivacy('groupPrivacy','${groupId}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="savePrivacy.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        You have changed your privacy of group<b><c:out value="${sessionScope.visitedGroup.displayName}"/></b>.<br/><br/>
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-right' >
      <input type='button' value='${ok}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
  </table>
</textarea>


<textarea id="deleteGroupProfile.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='form_groupPrivacy'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Do you reallly what to delete the Group <b>${groupName}</b>?<br/>Click "${delete}" only if you reallly what to delete the Group <b>${groupName}</b>.
      </td>
    </tr>    
    <tr>
    <td class='portlet-table-td-left' >
      <input type='button' value='${delete}' onclick="javascript:confirmDeleteGroupProfile('${groupId}','${id}');hidePopupDiv('${popupName}');" class='portlet-form-button'/>
      <input type='button' value='${cancel}' onclick="javascript:hidePopupDiv('${popupName}');" class='portlet-form-button'/>
    </td>
    </tr>
    
  </table>
</form>
</textarea>

<textarea id="viewMaxPicture.jst" style="display:none;">
<img src='${url}' style='cursor: url(<%= request.getContextPath() %>/light/images/zoomout.cur), pointer;' align="middle" height='${height}' width='${width}' onclick="javascript:hidePopupDiv('${popupName}');"/>
<br/><span style="align:center;" width='100%'>${caption}</span>
</textarea>

<textarea id="viewPicture.jst" style="display:none;">
<img id='currentMyPicture_${id}' src='${url}' class='portlet'  align="middle" height='${height}' width='${width}'/>
<br/>${caption}
{if caption == ""}<br/>{/if}
</textarea>

<textarea id="slidePicture.jst" style="display:none;">
<img src='${url}' class='portlet'  align="middle" height='${height}' width='${width}'/>
<br/>${caption}
{if caption == ""}<br/>{/if}
</textarea>

<textarea id="refreshPicture.jst" style="display:none;">
<img id='currentMyPicture_${id}'  src='${url}' class='portlet'  align="middle" height='${sheight}' width='${swidth}' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'   
onclick="javascript:viewMaxPictureAtClient(event,'${id}','${pictureId}','${url}','${caption}','${lwidth}','${lheight}');"
onmouseover="javascript:this.style.border='2px solid #83C2CD';"
onmouseout="javascript:this.style.border='';"
/>
<br/>${caption}
</textarea>

<textarea id="showTheme.jst" style="display:none;">
<img src='<%= request.getContextPath() %>${theme}' align="middle" />
<br/>${caption}
{if caption == ""}<br/>{/if}
</textarea>

<textarea id="popItem.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block;
text-align:right;'>
<a href='javascript:void(0);'
onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif'
style='border: 0px;'/></a>
</span>
<table border='0' cellpadding='0' cellspacing='0' >
   <tr>
     <td class='portlet-table-td-left' >
       <br/>
       You have recommended this link to other members successfully.
       <br/>
     </td>
   </tr>
   <tr>
   <td class='portlet-table-td-right' >
     <input type='button' value='${ok}'
onclick="javascript:hidePopupDiv('${popupName}');"
class='portlet-form-button'/>
   </td>
   </tr>
 </table>
</textarea>

<textarea id="forwardToFriend.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block;
text-align:right;'>
<a href='javascript:void(0);'
onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif'
style='border: 0px;'/></a>
</span>
<table border='0' cellpadding='0' cellspacing='0' >
   <tr>
     <td class='portlet-table-td-left' >
       <br/>
       You have fowarded this link to your friends successfully.
       <br/>
     </td>
   </tr>
   <tr>
   <td class='portlet-table-td-right' >
     <input type='button' value='${ok}'
onclick="javascript:hidePopupDiv('${popupName}');"
class='portlet-form-button'/>
   </td>
   </tr>
 </table>
</textarea>

<textarea id="saveToBookmark.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block;
text-align:right;'>
<a href='javascript:void(0);'
onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif'
style='border: 0px;'/></a>
</span>
<table border='0' cellpadding='0' cellspacing='0' >
   <tr>
     <td class='portlet-table-td-left' >
       <br/>
       You have saved this link to your Bookmarks successfully.
       <br/>
     </td>
   </tr>
   <tr>
   <td class='portlet-table-td-right' >
     <input type='button' value='${ok}'
onclick="javascript:hidePopupDiv('${popupName}');"
class='portlet-form-button'/>
   </td>
   </tr>
 </table>
</textarea>

<textarea id="saveToPicture.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block;
text-align:right;'>
<a href='javascript:void(0);'
onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif'
style='border: 0px;'/></a>
</span>
<table border='0' cellpadding='0' cellspacing='0' >
   <tr>
     <td class='portlet-table-td-left' >
       <br/>
       You have saved this picture to your picture list successfully.
       <br/>
     </td>
   </tr>
   <tr>
   <td class='portlet-table-td-right' >
     <input type='button' value='${ok}'
onclick="javascript:hidePopupDiv('${popupName}');"
class='portlet-form-button'/>
   </td>
   </tr>
 </table>
</textarea>

<textarea id="addKeywords.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myKeywordsForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' colspan='4'>
        Add My Keywords
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 1:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword1' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 2:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword2' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 3:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword3' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 4:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword4' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 5:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword5' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 6:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword6' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 7:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword7' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 8:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword8' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 9:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword9' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 10:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword10' value='' size='16' />
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-right' >
      <input name='Add' type='button' value='Add' onclick="javascript:saveKeywords('${id}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="addNotKeywords.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myNotKeywordsForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' colspan='4'>
        Add Not Keywords
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 1:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword1' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 2:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword2' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 3:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword3' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 4:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword4' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 5:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword5' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 6:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword6' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 7:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword7' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 8:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword8' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 9:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword9' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 10:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword10' value='' size='16' />
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-right' >
      <input name='Add' type='button' value='Add' onclick="javascript:saveNotKeywords('${id}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>

<textarea id="addNotWords.jst" style="display:none;">
<span title='${title}' width='100%' style='clear: both;display: block; text-align:right;'>
<a href='javascript:void(0);' onclick="javascript:hidePopupDiv('${popupName}');">
<img src='<%= request.getContextPath() %>/light/images/close_on.gif' style='border: 0px;'/></a>
</span>
<form name='myNotWordsForm'>
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' colspan='4'>
        Add Not Keywords
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 1:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword1' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 2:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword2' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 3:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword3' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 4:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword4' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 5:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword5' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 6:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword6' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 7:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword7' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 8:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword8' value='' size='16' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        Keywords 9:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword9' value='' size='16' />
      </td>
      <td class='portlet-table-td-left' >
        Keywords 10:
      </td>
      <td class='portlet-table-td-left' >
      <input type='text' name='keyword10' value='' size='16' />
      </td>
    </tr>
    <tr>
    <td class='portlet-table-td-right' >
      <input name='Add' type='button' value='Add' onclick="javascript:saveNotWords('${id}');" />
    </td>
    </tr>
  </table>
</form>
</textarea>
<%
java.util.List<org.light.portal.util.LabelBean> windowSkins = org.light.portal.util.ConfigurationUtil.getSupportedWindowSkins();
String locale = (String)request.getSession().getAttribute(org.light.portal.util.Constants._CURRENT_LOCALE);
String[] localeParams = locale.split("_");
java.util.Locale currentLocale = null;
if(localeParams.length > 1)
	 currentLocale = new java.util.Locale(localeParams[0],localeParams[1]);
else
	 currentLocale = new java.util.Locale(localeParams[0]);
for(org.light.portal.util.LabelBean bean : windowSkins){
	bean.setDesc(org.light.portal.util.MessageUtil.getMessage(bean.getDesc(),currentLocale));
}
request.setAttribute("windowSkins",windowSkins);
%>
<textarea id="configMode.jst" style="display:none;">
<form name="form_${id}">
<table border='0' cellpadding='0' cellspacing='0' width="95%" >
<tr>
<td colspan='2'>
<img src='<%= request.getContextPath() %>/light/images/spacer.gif' height='10' style='border: 0px' width='200' alt='' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width="50%"><fmt:message key="portlet.label.title"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='pcTitle' value='${title}' class='portlet-form-input-field' size='24' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.titleBgColor"/>:
</td>
<td class='portlet-table-td-left'>
<div class='color-block' style='background-color:red;' onclick="javascript:setColor('${id}',1,'red');"> </div>
<div class='color-block' style='background-color:orange;' onclick="javascript:setColor('${id}',1,'orange');"> </div>
<div class='color-block' style='background-color:yellow;' onclick="javascript:setColor('${id}',1,'yellow');"> </div>
<div class='color-block' style='background-color:green;' onclick="javascript:setColor('${id}',1,'green');"> </div>
<div class='color-block' style='background-color:blue;' onclick="javascript:setColor('${id}',1,'blue');"> </div>
<div class='color-block' style='background-color:black;' onclick="javascript:setColor('${id}',1,'black');"> </div>
<div class='color-block' style='background-color:white;' onclick="javascript:setColor('${id}',1,'white');"> </div>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.titleColor"/>:
</td>
<td class='portlet-table-td-left'>
<div class='color-block' style='background-color:red;' onclick="javascript:setColor('${id}',2,'red');"> </div>
<div class='color-block' style='background-color:orange;' onclick="javascript:setColor('${id}',2,'orange');"> </div>
<div class='color-block' style='background-color:yellow;' onclick="javascript:setColor('${id}',2,'yellow');"> </div>
<div class='color-block' style='background-color:green;' onclick="javascript:setColor('${id}',2,'green');"> </div>
<div class='color-block' style='background-color:blue;' onclick="javascript:setColor('${id}',2,'blue');"> </div>
<div class='color-block' style='background-color:black;' onclick="javascript:setColor('${id}',2,'black');"> </div>
<div class='color-block' style='background-color:white;' onclick="javascript:setColor('${id}',2,'white');"> </div>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.contentBgColor"/>:
</td>
<td class='portlet-table-td-left'>
<div class='color-block' style='background-color:red;' onclick="javascript:setColor('${id}',3,'red');"> </div>
<div class='color-block' style='background-color:orange;' onclick="javascript:setColor('${id}',3,'orange');"> </div>
<div class='color-block' style='background-color:yellow;' onclick="javascript:setColor('${id}',3,'yellow');"> </div>
<div class='color-block' style='background-color:green;' onclick="javascript:setColor('${id}',3,'green');"> </div>
<div class='color-block' style='background-color:blue;' onclick="javascript:setColor('${id}',3,'blue');"> </div>
<div class='color-block' style='background-color:black;' onclick="javascript:setColor('${id}',3,'black');"> </div>
<div class='color-block' style='background-color:white;' onclick="javascript:setColor('${id}',3,'white');"> </div>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.textColor"/>:
</td>
<td class='portlet-table-td-left'>
<div class='color-block' style='background-color:red;' onclick="javascript:setColor('${id}',4,'red');"> </div>
<div class='color-block' style='background-color:orange;' onclick="javascript:setColor('${id}',4,'orange');"> </div>
<div class='color-block' style='background-color:yellow;' onclick="javascript:setColor('${id}',4,'yellow');"> </div>
<div class='color-block' style='background-color:green;' onclick="javascript:setColor('${id}',4,'green');"> </div>
<div class='color-block' style='background-color:blue;' onclick="javascript:setColor('${id}',4,'blue');"> </div>
<div class='color-block' style='background-color:black;' onclick="javascript:setColor('${id}',4,'black');"> </div>
<div class='color-block' style='background-color:white;' onclick="javascript:setColor('${id}',4,'white');"> </div>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input type='checkbox' name='transparent' value='${transparent}' class='portlet-form-checkbox' onchange="javascript:setTransparent('${id}',this);" 
{if transparent == 1}
checked="checked"
{/if}
>
<fmt:message key="portlet.label.transparentPortlet"/></input> 
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-left">Content Skin:</td>
<td class="portlet-table-td-left">
<select name="windowSkin" size="1" class="portlet-form-select">
<c:forEach var="windowSkin" items="${requestScope.windowSkins}" varStatus="status">
<option value='<c:out value="${windowSkin.id}"/>'>
<c:out value="${windowSkin.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='cright' colspan='2'>
<input name='save' type='button' value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button'
 onclick="javascript:configPortlet('${id}');" />
<input name='default' type='button' value='<fmt:message key="portlet.button.default"/>' class='portlet-form-button'
 onclick="javascript:defaultConfigPortlet('${id}');" />
<input type='button' name='action' onClick="javascript:Light.executeRender('${id}','','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>

</textarea>

<textarea id="showLinkAction.jst" style="display:none;">

<table border='0' cellpadding='0' cellspacing='0' width="95%" >
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','pop','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','forward','${popupName}');"/>
</td>
</tr>
<tr>
<td>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','bookmark','${popupName}');"/>
</td>
</tr>
<tr>
<td>
<a href='http://digg.com/submit?phase=2&url=${itemLink}&topic=world_news' target='_blank' onClick="javascript:hidePopupDiv('${popupName}');"><img src="<%= request.getContextPath() %>/light/images/digg.gif" title="digg it!" alt="digg it!" border="0" height='16' width='16'/></a>
</td>
</tr>
<light:authenticateOwner>   
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' onClick="javascript:Light.doLinkAction('${id}','${itemId}','delete','${popupName}');"/>
</td>
</tr>
</light:authenticateOwner>  
</table>

</textarea>

<textarea id="showNewsAction.jst" style="display:none;">
<table border='0' cellpadding='0' cellspacing='0' width="95%" >   
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','pop','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','forward','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','bookmark','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<a href='http://digg.com/submit?phase=2&url=${itemLink}&topic=world_news' target='_blank'><img src="<%= request.getContextPath() %>/light/images/digg.gif" title="digg it!" alt="digg it!" border="0" height='16' width='16' onClick="javascript:hidePopupDiv('${popupName}');"/></a>
</td>
</tr>
<light:authorize role="ROLE_ADMIN">   
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' onClick="javascript:Light.doLinkAction('${id}','${itemId}','delete','${popupName}');"/>
</td>
</tr>
</light:authorize>  
</table>

</textarea>

<textarea id="showBlogAction.jst" style="display:none;">

<table border='0' cellpadding='0' cellspacing='0' width="95%" >
<light:authenticateUser>   
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','pop','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','forward','${popupName}');"/>
</td>
</tr>
</light:authenticateUser>
<tr>
<td>
	<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:Light.doLinkAction('${id}','${itemId}','bookmark','${popupName}');"/>
</td>
</tr>
<tr>
<td>
	<a href='http://blog.<c:out value="${sessionScope.org.webId}"/>/${uri}/entry/${anchor}' target="_blank"><img src='<%= request.getContextPath() %>/light/images/blog.gif' style='border: 0px;' height='16' width='16' title='<fmt:message key="portlet.label.gotoBlog"/>'/></a>
</td>
</tr>
<tr>
<td>
	<a href='http://digg.com/submit?phase=2&url=http://blog.<c:out value="${sessionScope.org.webId}"/>/${uri}/entry/${anchor}&title=${itemTitle}&bodytext=${itemTitle}&topic=world_news' target='_blank'><img src="<%= request.getContextPath() %>/light/images/digg.gif" title="digg it!" alt="digg it!" border="0" height='16' width='16' onClick="javascript:hidePopupDiv('${popupName}');"/></a>
</td>
</tr>
<light:authenticateUser>   
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.button.edit"/>' src="<%= request.getContextPath() %>/light/images/edit.gif" style='border: 0px;' height='11' width='11' onClick="javascript:Light.executeRender('${id}','edit','normal','blogId=${itemId}');hidePopupDiv('${popupName}');"/>
</td>
</tr>
<tr>
<td> 
    <input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' onClick="javascript:Light.doLinkAction('${id}','${itemId}','delete','${popupName}');"/>
</td>
</tr>
</light:authenticateUser>  
</table>
</textarea>
</fmt:bundle>