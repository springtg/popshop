<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table border="0" cellpadding="0" cellspacing="0">
<tr>
<td class="portlet-table-td-left"><BR/><b><c:out value="${sessionScope.org.webId}"/> is an online community and a web 2.0 home page. </b></td>
</tr>
<tr>
<td class="portlet-table-td-left">
<BR/>
Create a private account on <c:out value="${sessionScope.org.webId}"/> and you can customize your page according your needs and interests. 
You can read all kinds of the news RSS feeds from your favor websites within one page. 
You also can manage Calendar, photos, journals, interests, group and share them with your friends! 
<BR/><BR/><FONT color='#ff6600'><B><c:out value="${sessionScope.org.webId}"/> is for everyone:</B></FONT><BR/>
<UL>
<LI>Anyone looking for personalized Page</LI>
<LI>Friends who want to share infomation e.g. talk Online, share Calendar etc.</LI>
<LI>Create a group for all kind of purposes</LI>
</UL>
We are a new site, developing new features as fast as we can. This service is still beta, if you have suggestions or comments, please <A href="javascript:void(0)" onclick="javascript:Light.portal.showContact();">contact us</A><BR/>
<P/>
<FONT color='#ff6600'><B> How Do I Use <c:out value="${sessionScope.org.webId}"/>? </B></FONT>
<OL>
<LI><B>Sign Up</B> and Create a Profile<BR/><BR/>(Your Profile is Your Space on the Web, where you can describe yourself, hobbies and interests. You can even upload pics and write journals.)<BR/><BR/></LI>
<LI><B>Invite</B> your Friends to join Your Personal Network.<BR/><BR/>OR, <B>Search</B> the site for your Friends who are already Members of <c:out value="${sessionScope.org.webId}"/>.<BR/><BR/></LI>
<LI>Browse, modify, and import your RSS feeds with our integrated RSS/ATOM feedreader, send your favourite news to public or friends or save to your personal bookmarks. You can easily import an OPML file as well.<BR/><BR/></LI>
<LI>To check your POPS/IMAP email or gmail account, to stick webnotes, weather, calendar, blog and many more to come !</LI>
<LI>Upload your photo and music !</LI>
<LI>Create your own group or join other groups as many as you want !</LI>
</OL>
</td>
</tr>    
<tr>
<td class="portlet-table-td-left">
<BR/><BR/>
<c:out value="${sessionScope.org.webId}"/> is a start up company created in 2006 based in North America and specialized in Web 2.0 applications. We are open to all business opportunities, please contact us at : business@<c:out value="${sessionScope.org.webId}"/> 
</td>
</tr>
<tr>
<td class="portlet-table-td-right">
<input type='button' name='action' onClick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>