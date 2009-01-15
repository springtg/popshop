/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.util;


/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 4, 2006
 **/
public final class Constants {
	
	public static final String _PORTL_SERVER_INFO 	    = "Light Portal Version 1.0.0";	
	public static final String _LIGHT_PORTAL			= "LightPortal";
	public static final String _LIGHT_PORTAL_USER_ID	= "light_portal_user_id";
	public static final String _PORTAL_TITLE_DEFAULT_KEY= "portal.title.default";
	public static final String _PORTAL_TITLE_LOGIN_KEY  = "portal.title.login";
	
	public static final String _ORGANIZATION			= "org";	
	public static final String _USER					= "user";	
	public static final String _VISITED_USER			= "visitedUser";
	public static final String _VISITED_PAGE			= "visitedPage";
	public static final String _VISITED_GROUP			= "visitedGroup";
	public static final String _VISITED_STORE			= "visitedStore";
	public static final String _VISITED_PORTAL			= "visitedPortal";
	public static final String _GROUP_PREFIX			= "group_";

	public static final String _DEFAULT_THEME           = PropUtil.getString("default.theme");//"theme5";
	public static final String _DEFAULT_MALE_THEME      = PropUtil.getString("default.theme.male");//"theme4";
	public static final String _DEFAULT_FEMALE_THEME    = PropUtil.getString("default.theme.female");//"theme3";
	public static final String _DEFAULT_SPACE_PREFIX    = PropUtil.getString("default.space.prefix");
	public static final String _DEFAULT_GROUP_PREFIX    = PropUtil.getString("default.group.prefix");
	
	public static final String _CURRENT_TAB				= "LightPortalCurrentTab";
	public static final String _REMEMBER_LOCALE         = "LightPortalUserLocale";
	public static final String _REMEMBER_USER_ID        = "LightPortalRememberedUserId";
	public static final String _REMEMBER_USER_PASSWORD  = "LightPortalRememberedUserPassword";
	public static final String _IS_SIGN_OUT				= "LightPortalIsSignOut";
	public static final String _DEFAULT_LANGUAGE        = PropUtil.getString("default.language");//"en";
	public static final String _DEFAULT_LOCALE          = PropUtil.getString("default.locale");//"en";
	public static final String _CURRENT_LOCALE          = "currentLocale";
	public static final String _DEFAULT_RESOURCE_BUNDLE = "resourceBundle";
	public static final String _APPLICATION_CONFIG      = "applicationConfig";
	
	public static final String _DEFAULT_ORG_WEBID       = PropUtil.getString("default.org.webId");
	public static final String _DEFAULT_ORG_VIRTUALHOST = PropUtil.getString("default.org.virtualHost");
	public static final String _DEFAULT_ORG_MX          = PropUtil.getString("default.org.mx");
	public static final String _DEFAULT_ORG_LOGO        = PropUtil.getString("default.org.logo");
	public static final String _DEFAULT_ORG_LOGOICON    = PropUtil.getString("default.org.logoIcon");	
	public static final String _DEFAULT_ORG_USER_PREFIX = PropUtil.getString("default.org.user.prefix");
	public static final String _DEFAULT_ORG_ADMIN_PREFIX= PropUtil.getString("default.org.admin.prefix");
	
	public static final String _DEFAULT_USER_MALE_PORTRAIT    	= "default.user.male.portrait";
	public static final String _DEFAULT_USER_FEMALE_PORTRAIT    = "default.user.female.portrait";
	
	public static final String _DEFAULT_USER            = PropUtil.getString("default.user");//"default";
	public static final String _DEFAULT_ROLE            = PropUtil.getString("default.role");//"role_guest";
	public static final String _ROLE_GUEST    		    = "role_guest";
	public static final String _ROLE_USER    		    = "role_user";
	public static final String _ROLE_MEMBER    		    = "role_member";
	public static final String _ROLE_GROUP    		    = "role_group";
	public static final String _ROLE_STORE    		    = "role_store";
	public static final String _ROLE_ADMIN              = "role_admin";
	public static final String _ROLE_PROFILE			= "role_profile";
	public static final String _ROLE_NO_PROFILE			= "role_noprofile";
	
	public static final String _CHANNEL_FORUM           = "channel_forum";
	public static final String _CHANNEL_AD           	= "channel_ad";
	public static final String _CHANNEL_SEARCH          = "channel_search";
	public static final String _CHANNEL_NEWS           	= "channel_news";
	public static final String _CHANNEL_CULTURE        	= "channel_culture";
	public static final String _CHANNEL_RECIPE        	= "channel_recipe";
	public static final String _CHANNEL_GAME        	= "channel_game";
	public static final String _CHANNEL_ET        		= "channel_entertainment";
	
	public static final String _PORTLET_MODE_CONFIG              = "config";
	public static final String _PORTLET_MODE_CHANGE_POSITION     = "changePosition";
	public static final int	   _PORTLET_ASYN_LOAD 		= 0;
	public static final int	   _PORTLET_SYNC_LOAD 		= 1;
	
	public static final String _DEFAULT            = "default";
	public static final String _LANGUAGE_EN   	   = "en";
	public static final String _LANGUAGE_ALL   	   = "all";
	public static final String _DEFAULT_COUNTRY	   = "US";
	public static final String _DEFAULT_TIME_ZONE  = "PST";
	
	public static final String _MY_FEED            = "portlet.tag.title.myfeed";
	public static final String _FEATURED     	   = "portlet.tag.title.featured";
	
	public static final String _CHARSET_UTF		   = "UTF-8";
	public static final String _CHARSET_CHINESE	   = "gb2312";
	public static final String _CHARSET_8859	   = "8859_1";
	
	public static final String _PORTLET_WINDOW_CLASSIC		   		= "PortletWindow";
	public static final String _PORTLET_WINDOW_TRADITIONAL		    = "PortletWindow2";
	
	public final static String SERVLET_REQUEST = "httpServletRequest";
	public final static String SERVLET_RESPONSE = "httpServletResponse";
	public final static String ACTION_RESPONSE = "javax.portlet.action.response";
	public final static String PORTLET_REQUEST = "javax.portlet.request";
    public final static String PORTLET_RESPONSE = "javax.portlet.response";
    public final static String PORTLET_CONFIG = "javax.portlet.config";
    
    public final static String _JAVASCRIPT_LIBRARYS	 = PropUtil.getString("javascript.library.list");
	public final static String _PORTLET_JSP_PATH	 = "/WEB-INF/portlets";
	public final static String _USER_FILE_PATH		 = "/WEB-INF/user/";
	public final static String _GROUP_FILE_PATH		 = "/WEB-INF/grp/";
	public final static String _FILE_PATH		 	 = (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") == -1) ? PropUtil.getString("file.root") : PropUtil.getString("file.root.windows");
	public final static String _INDEX_PATH 			 = PropUtil.getString("file.index.path");
	public static final String _MY_IMAGE_PATH   	 = PropUtil.getString("file.my.images.path");
	public static final String _MY_MUSIC_PATH   	 = PropUtil.getString("file.my.musics.path");
	public static final String _MY_FILE_PATH   		 = PropUtil.getString("file.my.files.path");
	
    public final static String METHOD_ID = "org.light.portal.core.method";
    public final static Integer METHOD_RENDER = new Integer(1);
    public final static Integer METHOD_ACTION = new Integer(3);
    public final static Integer METHOD_NOOP = new Integer(5);
	public static final  int NumberOfKnownMimetypes = 15;
	
	public final static int _MESSAGE_EVENT_GROUP = 1;
	public final static int _MESSAGE_EVENT_CALENDAR = 2;
	public final static int _MESSAGE_EVENT_COMMENT = 3;
	public final static int _MESSAGE_EVENT_FORUM_CATEGORY = 4;
	public final static int _MESSAGE_EVENT_FORUM_SUB_CATEGORY = 5;
	
	public final static int _MESSAGE_EVENT_TYPE_INVITE = 1;
	public final static int _MESSAGE_EVENT_TYPE_REQUEST = 2;
	
	public final static String _FORUM_CATEGORY_PROFIX = "forum.category.";
	public final static String _FORUM_CATEGORY_DESC_PROFIX = "forum.category.desc.";
	public final static String _FORUM_CATEGORY_SUB_PROFIX = "forum.category.sub.";
	public final static String _FORUM_CATEGORY_SUB_DESC_PROFIX = "forum.category.sub.desc.";
	
	public static final int _DEFAULT_USER_SEARCHBAR_SHOW = Integer.parseInt(PropUtil.getString("default.user.searchBar.show")); 
	public static final String _DEFAULT_SEARCH_ENGINE = PropUtil.getString("default.search.engine");
	public static final int _DEFAULT_USER_MAX_TABS_SHOW = Integer.parseInt(PropUtil.getString("default.user.maxShowTabs"));
	
	public static final String _GLOBAL_STARTUP_EVENTS = PropUtil.getString("global.startup.events");
	public static final String _GLOBAL_SHUTDOWN_EVENTS = PropUtil.getString("global.shutdown.events");
	
	public final static int _MAX_ROW_PER_PAGE = 20;
	
	public final static int _CALENDAR_START_TIME = 800; //8:00 AM
	public final static int _CALENDAR_END_TIME = 1700; // 5:00 PM
	public final static int _CALENDAR_INTERVAL = 60; //1 hour ( 30 is half hours)
	public final static int _CALENDAR_EVENT_STATE = 0; //private event

}
