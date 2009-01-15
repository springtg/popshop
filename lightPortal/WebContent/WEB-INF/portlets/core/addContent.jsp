<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">

<c:if test='${requestScope.addFeedError != null}'>
  <div class="portlet-msg-error"><c:out value="${requestScope.addFeedError}" /></div>
</c:if>

<form name='form_<c:out value="${requestScope.responseId}"/>' action="<portlet:actionURL />">
  <span class='portlet-rss' style='padding-top:10px;'>
    <input type='text' name='keyword' class='portlet-form-input-field' size='24' value='<c:out value="${sessionScope.keyword}"/>'/> 
	<input name='action' type='submit' class='portlet-form-button' value='<fmt:message key="portlet.button.search"/>'/>
  </span>
  <br/>
  
  <c:if test="${sessionScope.searchLists != null}">
  	<c:forEach var="default" items="${sessionScope.searchLists}" >
        <span class='portlet-rss'>
          <c:if test="${default.icon !=null && default.icon != '' && !default.needPrefix}">
            <input type="image" src="<c:out value='${default.icon}'/>" name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
          </c:if>
          <c:if test="${default.icon !=null && default.icon != '' && default.needPrefix}">
            <input type="image" src="<%= request.getContextPath() %><c:out value='${default.icon}'/>"
              name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
          </c:if>
          <c:if test="${default.icon == null || default.icon == ''}">
			<input type="image" src="<%= request.getContextPath() %>/light/images/portlet.gif" 
              name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
		  </c:if>
          <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
          <a href="javascript:void(0);" name="<c:out value='${default.name}'/>"
            onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);">
            <c:out value='${default.title}'/></a>
          <light:authorize role="ROLE_ADMIN"> 
        	<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${default.name}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='deleteSearched';document.parameter=this.name;"/>          
      	  </light:authorize>
        </span>
      </c:forEach>
  </c:if>
  
  <c:if test="${sessionScope.searchLists == null}">
  <span class='portlet-rss'>
  	<light:authorize role="ROLE_ADMIN">
  	<input type="image" src="<%= request.getContextPath() %>/light/images/add.gif" style="border:0px;" align="absmiddle" onClick="javascript:showAddAllFeed(event,'<c:out value="${requestScope.responseId}"/>'); return false;" />
    <a href="javascript:void(0);" onClick="javascript:showAddAllFeed(event, '<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.addAllFeed"/></a>
  	<a href="<%= request.getContextPath() %>/opml/allfeeds.opml" target='_blank'>Export all to OPML</a>
    </light:authorize>
    <input type="image" src="<%= request.getContextPath() %>/light/images/add.gif" style="border:0px;" align="absmiddle" onClick="javascript:showAddFeed(event,'<c:out value="${requestScope.responseId}"/>'); return false;" />
    <a href="javascript:void(0);" onClick="javascript:showAddFeed(event, '<c:out value="${requestScope.responseId}"/>');showMyFeed('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.addMyFeed"/></a>
  </span>
  <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="5" width="100%"/>
  
  <c:if test="${requestScope.show != null}">
    <!-- show : default -->
    <c:if test='${requestScope.show == "default"}'>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
          onClick="javascript:showMyFeed('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);" onclick="javascript:showMyFeed('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.myFeeds"/></a>
      </span>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
          onClick="javascript:showFeatured('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);" onclick="javascript:showFeatured('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.featured"/></a>
      </span>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
          onClick="javascript:showCategory('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);" onclick="javascript:showCategory('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.label.classifiedContent"/></a>
      </span>

      <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="5" width="100%"/>
      <c:forEach var="default" items="${requestScope.defaultLists}" >
        <span class='portlet-rss'>
          <c:if test="${default.icon !=null && default.icon != '' && !default.needPrefix}">
            <input type="image" src="<c:out value='${default.icon}'/>" name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
          </c:if>
          <c:if test="${default.icon !=null && default.icon != '' && default.needPrefix}">
            <input type="image" src="<%= request.getContextPath() %><c:out value='${default.icon}'/>"
              name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
          </c:if>
          <c:if test="${default.icon == null || default.icon == ''}">
			<input type="image" src="<%= request.getContextPath() %>/light/images/portlet.gif" 
              name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
		  </c:if>
          <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
          <a href="javascript:void(0);" name="<c:out value='${default.name}'/>"
            onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);">
            <c:out value='${default.title}'/></a>
        </span>
      </c:forEach>
    </c:if>

    <!-- show : myFeed -->
    <c:if test='${requestScope.show == "myFeed"}'>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/hideMod.gif" style="border:0px;"
          onClick="javascript:hideMyFeed('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);" onclick="javascript:hideMyFeed('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.myFeeds"/></a>
        <a href="<%= request.getContextPath() %>/opml/myfeeds.opml" target='_blank'>Export to OPML</a>
      </span>

      <c:if test='${empty requestScope.myFeedLists}'>
        <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="15"/>
        <fmt:message key="portlet.message.empty"/>
      </c:if>
      
      <c:forEach var="myFeed" items="${requestScope.myFeedLists}" >
        <span class='portlet-rss'>
        <c:if test="${myFeed.icon !=null && myFeed.icon != '' && !myFeed.needPrefix}">
          <input type="image" src="<c:out value='${myFeed.icon}'/>" name="<c:out value='${myFeed.name}'/>"
            onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name); return false;"
            style="border:0px; width:16; height:16;" />
        </c:if>
        <c:if test="${myFeed.icon !=null && myFeed.icon != '' && myFeed.needPrefix}">
          <input type="image" src="<%= request.getContextPath() %><c:out value='${myFeed.icon}'/>"
            name="<c:out value='${myFeed.name}'/>" style="border:0px; width:16; height:16;"
            onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name); return false;" />
        </c:if>
        <c:if test="${myFeed.icon ==null || myFeed.icon == ''}">
          <input type="image" src="<%= request.getContextPath() %>/light/images/feed.png"
            name="<c:out value='${myFeed.name}'/>" style="border:0px; width:16; height:16;"
            onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name); return false;"/>
        </c:if>
        <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
        <a href="javascript:void(0);" onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
          name="<c:out value='${myFeed.name}'/>"><c:out value='${myFeed.title}'/></a>
        <input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${myFeed.name}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='delete';document.parameter=this.name;"/>  
        </span>
      </c:forEach>
    </c:if>

    <!-- show : featured -->
    <c:if test='${requestScope.show == "featured"}'>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/hideMod.gif"  style="border:0px;"
          onClick="javascript:hideFeatured('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);"
          onclick="javascript:hideFeatured('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.button.featured"/></a>
        <light:authenticateUser>  
          <input type="image" title='<fmt:message key="portlet.label.addFeaturedFeed"/>' src="<%= request.getContextPath() %>/light/images/add.gif" style="border:0px;" align="absmiddle" onClick="javascript:showAddFeaturedFeed(event,'<c:out value="${requestScope.responseId}"/>'); return false;" />
        </light:authenticateUser>
      </span>

      <c:if test='${empty requestScope.featuredLists}'>
        <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="15"/>
        <fmt:message key="portlet.message.empty"/>
      </c:if>

      <c:forEach var="default" items="${requestScope.featuredLists}" >
      <span class='portlet-rss'>
        <c:if test="${default.icon !=null && default.icon != '' && !default.needPrefix}">
          <input type="image" src="<c:out value='${default.icon}'/>" name="<c:out value='${default.name}'/>"
            onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
            style="border:0px; width:16; height:16;" />
        </c:if>
        <c:if test="${default.icon !=null && default.icon != '' && default.needPrefix}">
          <input type="image" src="<%= request.getContextPath() %><c:out value='${default.icon}'/>"
            name="<c:out value='${default.name}'/>" style="border:0px; width:16; height:16;"
            onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);" />
        </c:if>
        <c:if test="${default.icon == null || default.icon == ''}">
			<input type="image" src="<%= request.getContextPath() %>/light/images/feed.png" 
              name="<c:out value='${default.name}'/>"
              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
              style="border:0px; width:16; height:16;" />
		</c:if>
        <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
        <a href="javascript:void(0);"
          onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
          name="<c:out value='${default.name}'/>"><c:out value='${default.title}'/></a>
        <light:authorize role="ROLE_ADMIN"> 
        	<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${default.name}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='deleteFeatured';document.parameter=this.name;"/>          
        </light:authorize>
        </span>
      </c:forEach>
    </c:if>

    <!-- show : category -->
    <c:if test='${requestScope.show == "category"}'>
      <span class='portlet-rss'>
        <input type="image" src="<%= request.getContextPath() %>/light/images/hideMod.gif" style="border:0px;"
          onClick="javascript:hideCategory('<c:out value="${requestScope.responseId}"/>'); return false;" />
        <a href="javascript:void(0);"
          onclick="javascript:hideCategory('<c:out value="${requestScope.responseId}"/>');"><fmt:message key="portlet.label.classifiedContent"/></a>
      </span>

      <c:if test='${empty requestScope.categories}'>
        <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="15"/>
        <fmt:message key="portlet.message.empty"/>
      </c:if>

      <c:forEach var="dic" items="${requestScope.categories}" >
        <c:if test='${dic.showed}'>        	
          <span class='portlet-rss'>
            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="10"/>
            <input type="image" src="<%= request.getContextPath() %>/light/images/hideMod.gif"
              onClick="javascript:hideCategoryContent('<c:out value="${requestScope.responseId}"/>',
                '<c:out value="${dic.name}"/>'); return false;" style="border:0px;" />
            <a href="javascript:void(0);"
              onclick="javascript:hideCategoryContent('<c:out value="${requestScope.responseId}"/>',
                '<c:out value="${dic.name}"/>');"><c:out value="${dic.title}"/></a>
            <light:authenticateUser>  
         	 <input type="image" title='<fmt:message key="portlet.label.addCategoryFeed"/>' src="<%= request.getContextPath() %>/light/images/add.gif" style="border:0px;" align="absmiddle" onClick="javascript:showAddCategoryFeed(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${dic.name}"/>'); return false;" />
       		</light:authenticateUser>
          </span>
	      <c:if test='${dic.subCategories == null}'>    
	          <c:forEach var="feed" items="${dic.feedLists}" >
	            <span class='portlet-rss'>
	              <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="25"/>
	              <c:if test="${feed.icon !=null && feed.icon != '' && !feed.needPrefix}">
	                <input type="image" src="<c:out value='${feed.icon}'/>" name="<c:out value='${feed.name}'/>"
	                  onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
	                  style="border:0px; width:16; height:16;" />
	              </c:if>
	              <c:if test="${feed.icon !=null && feed.icon != '' && feed.needPrefix}">
	                <input type="image" src="<%= request.getContextPath() %><c:out value='${feed.icon}'/>"
	                  name="<c:out value='${feed.name}'/>"
	                  onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
	                  style="border:0px; width:16; height:16;" />
	              </c:if>
	              <c:if test="${feed.icon == null || feed.icon == ''}">
					<input type="image" src="<%= request.getContextPath() %>/light/images/feed.png" 
		              name="<c:out value='${default.name}'/>"
		              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
		              style="border:0px; width:16; height:16;" />
			  	  </c:if>
	              <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
	              <a href="javascript:void(0);" name="<c:out value='${feed.name}'/>"
	                onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);">
	                <c:out value='${feed.title}'/></a>
	              <light:authorize role="ROLE_ADMIN"> 
		        	<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${feed.name}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='deleteCategoryFeed';document.parameter=this.name;"/>          
		          </light:authorize>
	            </span>
	          </c:forEach>
          </c:if>
          <c:if test='${dic.subCategories != null}'>
          		<c:forEach var="sub" items="${dic.subCategories}" >
          		<c:if test='${sub.showed}'>  
          		 	<span class='portlet-rss'>
			            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="20"/>
			            <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
			              onClick="javascript:hideSubCategory('<c:out value="${requestScope.responseId}"/>',
			                '<c:out value="${sub.name}"/>'); return false;" />
			            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
			            <a href="javascript:void(0);"
			              onclick="javascript:hideSubCategory('<c:out value="${requestScope.responseId}"/>',
		                	'<c:out value="${sub.name}"/>');"><c:out value="${sub.title}"/></a>
		                <light:authenticateUser>  
			         	 <input type="image" title='<fmt:message key="portlet.label.addSubCategoryFeed"/>' src="<%= request.getContextPath() %>/light/images/add.gif" style="border:0px;" align="absmiddle" onClick="javascript:showAddSubCategoryFeed(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${dic.name}"/>','<c:out value="${sub.name}"/>'); return false;" />
			       		</light:authenticateUser>
		        	</span>
		        	<c:forEach var="feed" items="${sub.feedLists}" >
			            <span class='portlet-rss'>
			              <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="35"/>
			              <c:if test="${feed.icon !=null && feed.icon != '' && !feed.needPrefix}">
			                <input type="image" src="<c:out value='${feed.icon}'/>" name="<c:out value='${feed.name}'/>"
			                  onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
			                  style="border:0px; width:16; height:16;" />
			              </c:if>
			              <c:if test="${feed.icon !=null && feed.icon != '' && feed.needPrefix}">
			                <input type="image" src="<%= request.getContextPath() %><c:out value='${feed.icon}'/>"
			                  name="<c:out value='${feed.name}'/>"
			                  onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
			                  style="border:0px; width:16; height:16;" />
			              </c:if>
			              <c:if test="${feed.icon == null || feed.icon == ''}">
							<input type="image" src="<%= request.getContextPath() %>/light/images/feed.png" 
				              name="<c:out value='${default.name}'/>"
				              onClick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);"
				              style="border:0px; width:16; height:16;" />
					  	  </c:if>
			              <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
			              <a href="javascript:void(0);" name="<c:out value='${feed.name}'/>"
			                onclick="javascript:addContent('<c:out value="${requestScope.responseId}"/>',this.name);">
			                <c:out value='${feed.title}'/></a>
			              <light:authorize role="ROLE_ADMIN"> 
				        	<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${feed.name}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='deleteSubCategoryFeed';document.parameter=this.name;"/>          
				          </light:authorize>
			            </span>
			          </c:forEach>
          		</c:if>
          		<c:if test='${!sub.showed}'>   
	            	<span class='portlet-rss'>
			            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="20"/>
			            <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
			              onClick="javascript:showSubCategory('<c:out value="${requestScope.responseId}"/>',
			                '<c:out value="${sub.name}"/>'); return false;" />
			            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
			            <a href="javascript:void(0);"
			              onclick="javascript:showSubCategory('<c:out value="${requestScope.responseId}"/>',
		                	'<c:out value="${sub.name}"/>');"><c:out value="${sub.title}"/></a>
		        	</span>
		        </c:if>
	          </c:forEach>
          </c:if>
        </c:if>
        <c:if test='${!dic.showed}'>
          <span class='portlet-rss'>
            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="10"/>
            <input type="image" src="<%= request.getContextPath() %>/light/images/showMod.gif" style="border:0px;"
              onClick="javascript:showCategoryContent('<c:out value="${requestScope.responseId}"/>',
                '<c:out value="${dic.name}"/>'); return false;" />
            <img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border:0px;" height="1" width="3"/>
            <a href="javascript:void(0);"
              onclick="javascript:showCategoryContent('<c:out value="${requestScope.responseId}"/>',
                '<c:out value="${dic.name}"/>');"><c:out value="${dic.title}"/></a>
          </span>
        </c:if>
      </c:forEach>
    </c:if>
  </c:if>
  </c:if>
  
  <span class='portlet-rss' style='padding-top:10px;'>
    <fmt:message key="portlet.label.addContent"/> :
    <select name="pcColumn" size="1"  class="portlet-form-select" >
      <c:forEach var="i" begin="1" end="${requestScope.columns}" step="1">
        <option value='<c:out value="${i}" />'>Column <c:out value="${i}" /></option>
      </c:forEach>
    </select>
  </span>
  
</form>
</fmt:bundle>
</body>
</html>