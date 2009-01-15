package org.light.portlets.profile;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sf.acegisecurity.providers.encoding.Md5PasswordEncoder;

import org.light.portal.model.ChannelRef;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.User;
import org.light.portal.model.UserBlock;
import org.light.portal.model.UserInvite;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.CalendarUtil;
import org.light.portal.util.LocaleUtil;

public class ProfileDetailPortlet  extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
		 
		 if("name".equals(action))			 
				saveName(request);
		else if("interests".equals(action))	
			saveInterests(request);
		else if("basic".equals(action))	
			saveBasic(request);
		else if("background".equals(action))	
			saveBackgroud(request);
		else if("account".equals(action))	
			saveAccount(request);
		else if("privacy".equals(action))	
			savePrivacy(request);
		else if("channels".equals(action))	
				saveChannels(request);			
		else if("block".equals(action))	
			unBlockUser(request);			
 
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
        User user = this.getUser(request);
        UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());		        
        request.setAttribute("user", user);
		request.setAttribute("userProfile", userProfile);

		String part = request.getParameter("action");
		request.setAttribute("current",part);		
		if(part == null){
			request.setAttribute("current","name");
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailName.jsp").include(request,response);  
		}else if(part.equals("name"))	
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailName.jsp").include(request,response);
		else if(part.equals("interests"))	
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailInterests.jsp").include(request,response);
		else if(part.equals("basic")){	
			request.setAttribute("months", CalendarUtil.getMonths());
			request.setAttribute("days", CalendarUtil.getDays());
			request.setAttribute("years", CalendarUtil.getYears());
			request.setAttribute("countries", LocaleUtil.getSupportedCountry());
			request.setAttribute("provinces", LocaleUtil.getSupportedProvince());
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailBasic.jsp").include(request,response);
		}else if(part.equals("background"))	
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailBackground.jsp").include(request,response);
		else if(part.equals("account")){
			request.setAttribute("languages", LocaleUtil.getSupportedLanguages());			
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailAccount.jsp").include(request,response);
		}else if(part.equals("privacy"))	
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailPrivacy.jsp").include(request,response);
		else if(part.equals("channels")){	
			List<PortalUserRole> userChannels = this.getPortalService(request).getUserChannel(user.getId());
	        List<String> selectedChannels = new ArrayList<String>();
			 if(userChannels != null){
				for(PortalUserRole ur : userChannels){
					selectedChannels.add(ur.getRoleId());
				}
			}	
//		    List<PortletPreference> channels = new ArrayList<PortletPreference>();
//			Enumeration enumerator= request.getPreferences().getNames();
//	        int index = 0;
//			while (enumerator.hasMoreElements()){
//	            String name = (String)enumerator.nextElement();
//				String locatedName = PortalContextFactory.getPortalContext().getMessageByKey(name);
//	            String value = request.getPreferences().getValue(name,"");
//	            if(selectedChannels.contains(value))
//	            	channels.add(new PortletPreference(locatedName, value, true,index));
//	            else
//	            	channels.add(new PortletPreference(locatedName, value,index));
//				index++;
//	        }
			List<ChannelRef> channels = this.getPortalService(request).getChannelRef();
			for(ChannelRef channel : channels){
				if(selectedChannels.contains(channel.getName()))
					channel.setSelected(1);
				else
					channel.setSelected(0);
			}
			request.setAttribute("channels", channels);
			request.setAttribute("totalChannels",channels.size());
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailChannels.jsp").include(request,response);
		}else if(part.equals("block")){
			List<UserBlock> blocks = this.getUserService(request).getUserBlocks(this.getUser(request).getId());
			int blockCount = 0;
			 if(blocks != null)
				 blockCount = blocks.size();
			request.setAttribute("blockCount",blockCount);
			request.setAttribute("blocks",blocks);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailBlock.jsp").include(request,response);
		}else if(part.equals("invite")){
			List<UserInvite> invites = this.getUserService(request).getUserInvites(this.getUser(request).getId());
			int inviteCount = 0;
			 if(invites != null)
				 inviteCount = invites.size();
			request.setAttribute("inviteCount",inviteCount);
			request.setAttribute("invites",invites);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailInvite.jsp").include(request,response);
		}			
		else	
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profileDetailName.jsp").include(request,response);
	 }	

	 private void saveName(PortletRequest request) throws PortletException, java.io.IOException{
		 String displayName = request.getParameter("displayName");
		 if(displayName == null){
			 request.setAttribute("error", "please input your display name.");
			 return; 
		 }
		 String firstName = request.getParameter("firstName");
		 String middleName = request.getParameter("middleName");
		 String lastName = request.getParameter("lastName");
		 if(displayName != null) displayName = URLDecoder.decode(displayName,_CHARSET_UTF);
		 if(firstName != null) firstName = URLDecoder.decode(firstName,_CHARSET_UTF);
		 if(middleName != null) middleName = URLDecoder.decode(middleName,_CHARSET_UTF);
		 if(lastName != null) lastName = URLDecoder.decode(lastName,_CHARSET_UTF);
		 User user = this.getUser(request);		
		 user.setDisplayName(displayName);
		 this.getUserService(request).saveUser(user);
         UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());
		 if(userProfile == null){
			userProfile = new UserProfile();
		    userProfile.setUserId(user.getId());
		 }
		 userProfile.setFirstName(firstName);
		 userProfile.setMiddleName(middleName);
		 userProfile.setLastName(lastName);
		 this.getPortalService(request).save(userProfile);
		 request.setAttribute("success", "You have changed your name successfully.");
		 
	 }
	 private void saveInterests(PortletRequest request) throws PortletException, java.io.IOException{
		 String headline = request.getParameter("headline");
		 String aboutMe = request.getParameter("aboutMe");
		 String likeToMeet = request.getParameter("likeToMeet");
		 String interests = request.getParameter("interests");
		 String music = request.getParameter("music");
		 String movies = request.getParameter("movies");
		 String television = request.getParameter("television");
		 String books = request.getParameter("books");
		 String heroes = request.getParameter("heroes");
		 if(headline != null) headline = URLDecoder.decode(headline,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(aboutMe != null) aboutMe = URLDecoder.decode(aboutMe,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(likeToMeet != null) likeToMeet = URLDecoder.decode(likeToMeet,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(interests != null) interests = URLDecoder.decode(interests,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(music != null) music = URLDecoder.decode(music,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(movies != null) movies = URLDecoder.decode(movies,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(television != null) television = URLDecoder.decode(television,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(books != null) books = URLDecoder.decode(books,_CHARSET_UTF).replaceAll("\n","").trim();
		 if(heroes != null) heroes = URLDecoder.decode(heroes,_CHARSET_UTF).replaceAll("\n","").trim();
		 
		 User user = this.getUser(request);
         UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());
		 if(userProfile == null){
			userProfile = new UserProfile();
		    userProfile.setUserId(user.getId());
		 }
		 userProfile.setHeadline(headline);
		 userProfile.setAboutMe(aboutMe);
		 userProfile.setLikeToMeet(likeToMeet);
		 userProfile.setInterests(interests);
		 userProfile.setMusic(music);
		 userProfile.setMovies(movies);
		 userProfile.setTelevision(television);
		 userProfile.setBooks(books);
		 userProfile.setHeroes(heroes);
		 
		 this.getPortalService(request).save(userProfile);
		 request.setAttribute("success", "You have changed you interests successfully.");
	 }
	 private void saveBasic(PortletRequest request) throws PortletException, java.io.IOException{
		 String birth = request.getParameter("birthY")+"/"+
						request.getParameter("birthM")+"/"+
						request.getParameter("birthD");
		 String gender = request.getParameter("gender");
		 String occupation = request.getParameter("occupation");		 
		 String country = request.getParameter("country");
		 String province = request.getParameter("province");
		 String city = request.getParameter("city");
		 String postalCode = request.getParameter("postalCode");
		 String ethnicity = request.getParameter("ethnicity");
		 String bodyType = request.getParameter("bodyType");
		 String height = request.getParameter("height");
		 String registerPurpose = request.getParameter("registerPurpose");
		 String email = request.getParameter("email");
		 if(email == null){
			 request.setAttribute("error", "please input your Email address.");
			 return; 
		 }
		 if(email != null) email = URLDecoder.decode(email,_CHARSET_UTF);
		 if(email.indexOf("@") <= 0 || email.indexOf(".") <= 0){
			 request.setAttribute("error", "please input your Email address correctly.");
			 return;
		 }
		 User user = this.getUser(request);		 
		 if(!user.getEmail().equals(email)){
			 user.setEmail(email);
		 }		
		 if(occupation != null) occupation = URLDecoder.decode(occupation,_CHARSET_UTF);
		 if(country != null) country = URLDecoder.decode(country,_CHARSET_UTF);
		 if(province != null) province = URLDecoder.decode(province,_CHARSET_UTF);
		 if(city != null) city = URLDecoder.decode(city,_CHARSET_UTF);
		 if(postalCode != null) postalCode = URLDecoder.decode(postalCode,_CHARSET_UTF);
		 user.setBirth(birth);
		 user.setGender(gender);
		 user.setCountry(country);
		 user.setProvince(province);
		 user.setCity(city);
		 user.setPostalCode(postalCode);
		 
		 this.getUserService(request).saveUser(user);
         UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());
		 if(userProfile == null){
			userProfile = new UserProfile();
		    userProfile.setUserId(user.getId());
		 }
		 userProfile.setOccupation(occupation);
		 userProfile.setEthnicity(Integer.parseInt(ethnicity));
		 userProfile.setBodyType(Integer.parseInt(bodyType));
		 userProfile.setHeight(Integer.parseInt(height));
		 if(registerPurpose != null){
			 int purpose = 0;
			 try{
				 purpose = Integer.parseInt(registerPurpose);
			 }catch(NumberFormatException e){}
			 userProfile.setRegisterPurpose(purpose);		 
		 }
		 
		 this.getPortalService(request).save(userProfile);
		 request.setAttribute("success", "You have changed your basic information successfully.");
	 }
	 private void saveBackgroud(PortletRequest request) throws PortletException, java.io.IOException{
		 String maritalStatus = request.getParameter("maritalStatus");
		 String sexualOrientation = request.getParameter("sexualOrientation");
		 String religion = request.getParameter("religion");
		 String hometown = request.getParameter("hometown");
		 String smoker = request.getParameter("smoker");
		 String drinker = request.getParameter("drinker");
		 String childrenStatus = request.getParameter("childrenStatus");
		 String education = request.getParameter("education");
		 String income = request.getParameter("income");
		 
		 User user = this.getUser(request);
         UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());
		 if(userProfile == null){
			userProfile = new UserProfile();
		    userProfile.setUserId(user.getId());
		 }
		 userProfile.setMaritalStatus(Integer.parseInt(maritalStatus));
		 userProfile.setSexualOrientation(Integer.parseInt(sexualOrientation));
		 userProfile.setReligion(religion);
		 userProfile.setHometown(hometown);
		 userProfile.setSmoker(Integer.parseInt(smoker));
		 userProfile.setDrinker(Integer.parseInt(drinker));
		 userProfile.setChildrenStatus(Integer.parseInt(childrenStatus));
		 userProfile.setEducation(Integer.parseInt(education));
		 userProfile.setIncome(income);
		 
		 this.getPortalService(request).save(userProfile);
		 request.setAttribute("success", "You have changed your background information successfully.");
	 }
	 
	 private void saveAccount(PortletRequest request) throws PortletException, java.io.IOException{
		 String password = request.getParameter("password");
		 String newPassword = request.getParameter("newPassword");
		 String confirmPassword = request.getParameter("confirmPassword");
		 User user = this.getUser(request);		 
		 if(password == null){
			 request.setAttribute("error", "please input your current password.");
			 return;
		 }
		 if(password != null) password = URLDecoder.decode(password,_CHARSET_UTF); 	
		 Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
		 String ePassword = encoder.encodePassword(password, null);	
		 if(!ePassword.equals(user.getPassword())){
			 request.setAttribute("error", "please input your current password correctly.");
			 return;
		 }
		 if(newPassword == null || confirmPassword == null || !newPassword.equals(confirmPassword)){
			 request.setAttribute("error", "please input your new password correctly.");
			 return;
		 }
		
		 //String language = request.getParameter("language");
		 StringBuffer result = new StringBuffer();
//		 if(! user.getLanguage().equals(language)){
//				Portal portal = this.getPortal(request);
//				if(portal != null){ 
//					portal.setLanguage(language);
//					this.getPortalService(request).save(portal);
//					this.setPortal(request,portal);
//					this.setLocale(request,language);	
//				}
//				user.setLanguage(language);
//				result.append("You have changed language successfully, please refresh page to change to new language.<br/>");								
//			 }
		if(newPassword != null) newPassword = URLDecoder.decode(newPassword,_CHARSET_UTF); 			
		user.setPassword(newPassword);
		result.append("You have changed password successfully.<br/>");
		 
		 this.getUserService(request).saveUser(user);
		 request.setAttribute("success", result.toString());
	 }
	 
	 private void savePrivacy(PortletRequest request){
		 int notification = 0;
		 if(request.getParameter("notification") != null) notification = 1;
		 int newsLetter = 0;
		 if(request.getParameter("newsLetter")  != null) newsLetter = 1;
		 int fqNel = 0;
		 if(request.getParameter("fqNel")  != null) fqNel = 1;		 
		 int commentNeedApprove = 0;
		 if(request.getParameter("commentNeedApprove")  != null) commentNeedApprove = 1;
		 int showBirthToFriend = 0;
		 if(request.getParameter("showBirthToFriend")  != null) showBirthToFriend = 1;
		 int showTitleToFriends = 0;
		 if(request.getParameter("showTitleToFriends")  != null) showTitleToFriends = 1;
		 int blogCommentFriendOnly = 0;
		 if(request.getParameter("blogCommentFriendOnly")  != null) blogCommentFriendOnly = 1;
		 int profileFriendViewOnly = 0;
		 if(request.getParameter("profileFriendViewOnly")  != null) profileFriendViewOnly = 1;		 
		 int noPicForward = 0;
		 if(request.getParameter("noPicForward")  != null) noPicForward = 1;
		 int myMusicAutoPlay = 0;
		 if(request.getParameter("myMusicAutoPlay")  != null) myMusicAutoPlay = 1;
		 int otherMusucAutoPlay = 0;
		 if(request.getParameter("otherMusucAutoPlay")  != null) otherMusucAutoPlay = 1;
		 int imprivacy = 0;
		 if(request.getParameter("imprivacy")  != null) imprivacy = Integer.parseInt(request.getParameter("imprivacy"));
		 
		 User user = this.getUser(request);
		 		  
		 user.setNotification(notification);
		 user.setNewsLetter(newsLetter);
		 user.setFqNel(fqNel);
		 user.setCommentNeedApprove(commentNeedApprove);
		 user.setShowTitleToFriends(showTitleToFriends);
		 user.setShowBirthToFriend(showBirthToFriend);
		 user.setBlogCommentFriendOnly(blogCommentFriendOnly);
		 user.setProfileFriendViewOnly(profileFriendViewOnly);
		 user.setNoPicForward(noPicForward);
		 user.setMyMusicAutoPlay(myMusicAutoPlay);
		 user.setOtherMusucAutoPlay(otherMusucAutoPlay);
		 user.setImprivacy(imprivacy);
		 
		 this.getUserService(request).saveUser(user);
         
		 request.setAttribute("success", "You have changed your privacy information successfully.");
	 }
	 
	 private void saveChannels(PortletRequest request){
		 String channels = request.getParameter("channels");
		 User user = this.getUser(request);
		 List<PortalUserRole> userChannels = this.getPortalService(request).getUserChannel(user.getId());
		 if(userChannels != null){
			for(PortalUserRole ur : userChannels){
				this.getPortalService(request).delete(ur);
			}
		 }
		 if(channels != null){			 
			 String[] channel = channels.split(",");
			 for(int i=0;i<channel.length;i++){
				 if(channel != null && !"".equals(channel)){
					 userChannels = this.getPortalService(request).getUserRole(user.getId(),channel[i]);
					 if(userChannels == null || userChannels.size() == 0){
						PortalUserRole userRole = new PortalUserRole(user.getId(),channel[i]);
						this.getPortalService(request).save(userRole);
					 } 
				 }
			 }
		 }
		 request.setAttribute("success", "You have changed the subscribed Channels successfully, please click Done button to refresh channels.");
	 }
	 
	 private void unBlockUser(PortletRequest request){
		 String blockId = request.getParameter("blockId");
		 if(blockId == null){
			 request.setAttribute("error", "please select a user first.");
			 return;
		 }
		 UserBlock block = this.getUserService(request).getUserBlockById(Integer.parseInt(blockId));
		 this.getPortalService(request).delete(block);
		 request.setAttribute("success", "This user has been deleted from block list successfully.");
	 }
}
