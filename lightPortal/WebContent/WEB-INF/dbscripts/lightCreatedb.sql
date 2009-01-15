-- Light Portal create tables

create table light_address_book (
   id bigint not null,
   userId bigint,
   addressGroup varchar(255),
   fullName varchar(255),
   homePhone varchar(255),
   workPhone varchar(255),
   mobilePhone varchar(255),
   primaryPhone integer,
   workEmail varchar(255),
   personalEmail varchar(255),
   primaryEmail integer,
   homePage varchar(255),
   address varchar(255),
   city varchar(255),
   province varchar(255),
   country varchar(255),
   postalCode varchar(255),
   primary key (id)
)
create table light_blog (
   id bigint not null,
   userId bigint,
   orgId bigint,
   title varchar(255),
   summary text,
   content text,
   status integer,
   score integer,
   createDate datetime,
   primary key (id)
)
create table light_blog_comment (
   id bigint not null,
   blogId bigint,
   postById bigint,
   comment text,
   createDate datetime,
   primary key (id)
)
create table light_bookmark (
   id bigint not null,
   name varchar(255),
   url varchar(255),
   tagId varchar(255),
   tagName varchar(255),
   bookmarkDesc text,
   userId bigint,
   primary key (id)
)
create table light_bulletin (
   id bigint not null,
   userId bigint,
   postById bigint,
   subject varchar(255),
   content text,
   status integer,
   createDate datetime,
   primary key (id)
)
create table light_calendar (
   id bigint not null,
   userId bigint,
   startTime integer,
   endTime integer,
   intervalTime integer,
   type integer,
   state integer,
   primary key (id)
)
create table light_calendar_event (
   id bigint not null,
   name varchar(255),
   location varchar(255),
   description varchar(255),
   startDate date,
   startTime integer,
   endDate date,
   endTime integer,
   state integer,
   link varchar(255),
   parentId bigint,
   userId bigint,
   primary key (id)
)
create table light_calendar_holiday (
   id bigint not null,
   holiday varchar(255),
   name varchar(255),
   country varchar(255),
   description text,
   link varchar(255),
   primary key (id)
)
create table light_category_ad (
   id bigint not null,
   userId bigint,
   title varchar(255),
   content text,
   status integer,
   category integer,
   country varchar(255),
   province varchar(255),
   city varchar(255),
   adUrl varchar(255),
   showDate date,
   effDate date,
   endEffDate date,
   score integer,
   createDate datetime,
   primary key (id)
)
create table light_category_ad_comment (
   id bigint not null,
   categoryAdId bigint,
   postById bigint,
   comment text,
   createDate datetime,
   primary key (id)
)
create table light_channel_ref (
   id bigint not null,
   name varchar(255),
   description varchar(255),
   selected integer,
   primary key (id)
)
create table light_chat (
   id bigint not null,
   userId bigint,
   defaultStatus integer,
   currentStatus integer,
   primary key (id)
)
create table light_chat_buddy (
   id bigint not null,
   userId bigint,
   buddyUserId bigint,
   type integer,
   primary key (id)
)
create table light_chat_status_ref (
   statusId integer not null,
   statusDesc varchar(255),
   primary key (statusId)
)
create table light_chatting (
   id bigint not null,
   chatFrom bigint,
   chatTo bigint,
   status integer,
   primary key (id)
)
create table light_chatting_record (
   id bigint not null,
   chattingId bigint,
   displayName varchar(255),
   content varchar(255),
   primary key (id)
)
create table light_feedback (
   id bigint not null,
   subject varchar(255),
   content varchar(255),
   email varchar(255),
   createDate date,
   visitCount integer,
   primary key (id)
)
create table light_flash_game (
   id bigint not null,
   link varchar(255),
   title varchar(255),
   description text,
   instructions text,
   tag varchar(255),
   locale varchar(255),
   popCount integer,
   width integer,
   height integer,
   postById bigint,
   createDate datetime,
   primary key (id)
)
create table light_forum (
   id bigint not null,
   name varchar(255),
   ctgrDesc varchar(255),
   ownerId bigint,
   status integer,
   categoryId bigint,
   primary key (id)
)
create table light_forum_category (
   id bigint not null,
   name varchar(255),
   ctgrDesc varchar(255),
   language varchar(255),
   orgId bigint,
   ownerId bigint,
   status integer,
   primary key (id)
)
create table light_forum_post (
   id bigint not null,
   topic varchar(255),
   content text,
   topId bigint,
   forumId bigint,
   categoryId bigint,
   postById bigint,
   lastPostId bigint,
   lastPostById bigint,
   createDate datetime,
   lstChgTm datetime,
   primary key (id)
)
create table light_friend_request (
   id bigint not null,
   userId bigint,
   postById bigint,
   status varchar(255),
   createDate date,
   primary key (id)
)
create table light_group (
   id bigint not null,
   displayName varchar(255),
   categoryId integer,
   openJoin integer,
   hiddenGroup integer,
   memberInvite integer,
   publicForum integer,
   memberBulletin integer,
   memberImage integer,
   noPicForward integer,
   matureContent integer,
   country varchar(255),
   province varchar(255),
   city varchar(255),
   postalCode varchar(255),
   shortDesc varchar(255),
   description text,
   uri varchar(255),
   photoUrl varchar(255),
   photoWidth integer,
   photoHeight integer,
   caption varchar(255),
   songUrl varchar(255),
   ownerId bigint,
   leaderId bigint,
   orgId bigint,
   viewCount integer,
   createDate datetime,
   primary key (id)
)
create table light_group_bulletin (
   id bigint not null,
   groupId bigint,
   postById bigint,
   subject varchar(255),
   content text,
   createDate datetime,
   primary key (id)
)
create table light_group_category (
   id bigint not null,
   name varchar(255),
   primary key (id)
)
create table light_group_forum (
   id bigint not null,
   topic varchar(255),
   content text,
   topId bigint,
   groupId bigint,
   postById bigint,
   lastPostId bigint,
   lastPostById bigint,
   createDate datetime,
   lstChgTm datetime,
   primary key (id)
)
create table light_group_picture (
   id bigint not null,
   groupId bigint,
   pictureUrl varchar(255),
   pictureWidth integer,
   pictureHeight integer,
   status integer,
   caption varchar(255),
   createDate datetime,
   primary key (id)
)
create table light_horoscope (
   id bigint not null,
   name varchar(255),
   title varchar(255),
   description varchar(255),
   startDate varchar(255),
   endDate varchar(255),
   startMonth integer,
   startDay integer,
   endMonth integer,
   endDay integer,
   primary key (id)
)
create table light_horoscope_weekly (
   id bigint not null,
   horoscopeId bigint,
   language varchar(255),
   description text,
   weekNumber integer,
   primary key (id)
)
create table light_internal_news (
   id bigint not null,
   postById bigint,
   subject varchar(255),
   content text,
   createDate datetime,
   primary key (id)
)
create table light_message (
   id bigint not null,
   userId bigint,
   postById bigint,
   subject varchar(255),
   content text,
   status varchar(255),
   event integer,
   type integer,
   eventId bigint,
   createDate datetime,
   primary key (id)
)
create table light_not_keyword (
   word varchar(255) not null,
   primary key (word)
)
create table light_not_word (
   word varchar(255) not null,
   primary key (word)
)
create table light_note (
   id bigint not null,
   userId bigint,
   color varchar(255),
   bgColor varchar(255),
   content text,
   width integer,
   height integer,
   primary key (id)
)
create table light_org_profile (
   id bigint not null,
   orgId bigint,
   language varchar(255),
   title varchar(255),
   view text,
   maxView text,
   primary key (id)
)
create table light_organization (
   id bigint not null,
   webId varchar(255),
   virtualHost varchar(255),
   mx varchar(255),
   logoUrl varchar(255),
   logoIcon varchar(255),
   userId bigint,
   status integer,
   primary key (id)
)
create table light_popular_item (
   id bigint not null,
   link varchar(255),
   title varchar(255),
   itemDesc text,
   tag varchar(255),
   locale varchar(255),
   postById bigint,
   orgId bigint,
   popCount integer,
   primary key (id)
)
create table light_popular_item_comment (
   id bigint not null,
   itemId bigint,
   postById bigint,
   comments text,
   status integer,
   createDate datetime,
   primary key (id)
)
create table light_portal (
   id bigint not null,
   userId varchar(255),
   title varchar(255),
   theme varchar(255),
   bgImage varchar(255),
   bgPosition varchar(255),
   bgRepeat integer,
   headerImage varchar(255),
   headerPosition varchar(255),
   headerRepeat integer,
   showLocaleBar integer,
   headerHeight integer,
   textFont varchar(255),
   fontSize integer,
   textColor varchar(255),
   transparent integer,
   showSearchBar integer,
   defaultSearchEngine varchar(255),
   visitCount integer,
   createDate date,
   primary key (id)
)
create table light_portal_tab (
   id bigint not null,
   label varchar(255),
   url varchar(255),
   closeable integer,
   editable integer,
   moveable integer,
   allowAddContent integer,
   color varchar(255),
   defaulted integer,
   colBetween integer,
   widths varchar(255),
   portletWindowType varchar(255),
   fitScreen integer,
   userId varchar(255),
   status integer,
   parentId bigint,
   primary key (id)
)
create table light_portlet (
   id bigint not null,
   tabId bigint,
   columnNumber integer,
   rowNumber integer,
   label varchar(255),
   icon varchar(255),
   url varchar(255),
   name varchar(255),
   path varchar(255),
   closeable integer,
   refreshMode integer,
   editMode integer,
   helpMode integer,
   configMode integer,
   minimized integer,
   maximized integer,
   windowSkin varchar(255),
   autoRefreshed integer,
   periodTime integer,
   showNumber integer,
   showType integer,
   windowStatus integer,
   mode integer,
   type integer,
   allowJS integer,
   pageRefreshed integer,
   parameter varchar(255),
   barBgColor varchar(255),
   barFontColor varchar(255),
   contentBgColor varchar(255),
   textColor varchar(255),
   transparent integer,
   loadFromClient integer,
   primary key (id)
)
create table light_portlet_preferences (
   id bigint not null,
   name varchar(255),
   value varchar(255),
   status integer,
   portletId bigint,
   primary key (id)
)
create table light_portlet_ref (
   name varchar(255) not null,
   orgId bigint,
   label varchar(255),
   icon varchar(255),
   url varchar(255),
   path varchar(255),
   subTag varchar(255),
   tag varchar(255),
   language varchar(255),
   refreshMode integer,
   editMode integer,
   helpMode integer,
   configMode integer,
   minimized integer,
   maximized integer,
   windowSkin varchar(255),
   autoRefreshed integer,
   periodTime integer,
   showNumber integer,
   showType integer,
   windowStatus integer,
   mode integer,
   type integer,
   allowJS integer,
   pageRefreshed integer,
   parameter varchar(255),
   userId varchar(255),
   createdBy varchar(255),
   primary key (name)
)
create table light_recommended_item (
   id bigint not null,
   link varchar(255),
   title varchar(255),
   itemDesc text,
   tag varchar(255),
   locale varchar(255),
   weight integer,
   readStatus integer,
   userId bigint,
   createDate datetime,
   primary key (id)
)
create table light_role (
   roleId varchar(255) not null,
   allowLookAndFeel integer,
   allowLayout integer,
   allowAddTab integer,
   allowAddContent integer,
   allowSignIn integer,
   allowTurnOff integer,
   title varchar(255),
   theme varchar(255),
   primary key (roleId)
)
create table light_store (
   id bigint not null,
   name varchar(255),
   companyName varchar(255),
   description varchar(255),
   userId bigint,
   contactName varchar(255),
   contactEmail varchar(255),
   contactPhone varchar(255),
   uri varchar(255),
   link varchar(255),
   logoWidth integer,
   logoHeight integer,
   account varchar(255),
   status integer,
   viewCount integer,
   primary key (id)
)
create table light_store_catalog (
   id bigint not null,
   name varchar(255),
   description varchar(255),
   storeId bigint,
   status integer,
   primary key (id)
)
create table light_store_order (
   id bigint not null,
   userId bigint,
   addressId bigint,
   total varchar(255),
   status integer,
   createDate date,
   shippingDate date,
   deliverDate date,
   primary key (id)
)
create table light_store_order_item (
   id bigint not null,
   productId bigint,
   price varchar(255),
   quantity integer,
   orderId bigint not null,
   primary key (id)
)
create table light_store_product (
   id bigint not null,
   name varchar(255),
   description varchar(255),
   storeId bigint,
   catalogId bigint,
   price varchar(255),
   discount integer,
   quantity integer,
   link varchar(255),
   pictureWidth integer,
   pictureHeight integer,
   status integer,
   primary key (id)
)
create table light_store_shipping_address (
   id bigint not null,
   userId bigint,
   name varchar(255),
   email varchar(255),
   address1 varchar(255),
   address2 varchar(255),
   city varchar(255),
   state varchar(255),
   zip varchar(255),
   countryName varchar(255),
   phone varchar(255),
   primary key (id)
)
create table light_store_shoppingcart (
   id bigint not null,
   productId bigint,
   price varchar(255),
   quantity integer,
   userId bigint,
   primary key (id)
)
create table light_todo (
   id bigint not null,
   name varchar(255),
   description varchar(255),
   userId bigint,
   priority integer,
   status integer,
   primary key (id)
)
create table light_user (
   id bigint not null,
   orgId bigint,
   userId varchar(255),
   password varchar(255),
   displayName varchar(255),
   email varchar(255),
   birth varchar(255),
   gender varchar(255),
   language varchar(255),
   region varchar(255),
   timeZone varchar(255),
   country varchar(255),
   province varchar(255),
   city varchar(255),
   postalCode varchar(255),
   assignedUri varchar(255),
   chosedUri varchar(255),
   photoUrl varchar(255),
   photoWidth integer,
   photoHeight integer,
   caption varchar(255),
   musicUrl varchar(255),
   ringToneUrl varchar(255),
   videoUrl varchar(255),
   showFriendPicture integer,
   showGroupPicture integer,
   notification integer,
   newsLetter integer,
   fqNel integer,
   commentNeedApprove integer,
   showBirthToFriend integer,
   blogCommentFriendOnly integer,
   profileFriendViewOnly integer,
   imprivacy integer,
   noPicForward integer,
   myMusicAutoPlay integer,
   otherMusucAutoPlay integer,
   defaultPictureStatus integer,
   defaultMusicStatus integer,
   defaultFileStatus integer,
   visitCount integer,
   createDate date,
   lastLoginDate datetime,
   disabled integer,
   locked integer,
   growKeyword integer,
   showTitleToFriends integer,
   primary key (id)
)
create table light_user_block (
   id bigint not null,
   userId bigint,
   blockId bigint,
   createDate date,
   primary key (id)
)
create table light_user_comment (
   id bigint not null,
   userId bigint,
   postById bigint,
   comments text,
   status integer,
   createDate datetime,
   primary key (id)
)
create table light_user_favourite (
   id bigint not null,
   userId bigint,
   favouriteId bigint,
   createDate date,
   primary key (id)
)
create table light_user_file (
   id bigint not null,
   userId bigint,
   fileUrl varchar(255),
   caption varchar(255),
   status integer,
   createDate datetime,
   primary key (id)
)
create table light_user_group (
   id bigint not null,
   userId bigint,
   groupId bigint,
   acceptLeaderBulletin integer,
   acceptMembersBulletin integer,
   primary key (id)
)
create table light_user_invite (
   id bigint not null,
   userId bigint,
   inviteEmail varchar(255),
   status integer,
   createDate date,
   primary key (id)
)
create table light_user_keyword (
   id bigint not null,
   userId bigint,
   keyword varchar(255),
   weight integer,
   primary key (id)
)
create table light_user_music (
   id bigint not null,
   userId bigint,
   musicUrl varchar(255),
   caption varchar(255),
   status integer,
   rankable integer,
   createDate datetime,
   primary key (id)
)
create table light_user_picture (
   id bigint not null,
   userId bigint,
   pictureUrl varchar(255),
   pictureWidth integer,
   pictureHeight integer,
   caption varchar(255),
   tag varchar(255),
   status integer,
   rankable integer,
   createDate datetime,
   primary key (id)
)
create table light_user_picture_rank (
   id bigint not null,
   userId bigint,
   pictureId integer,
   rankScore integer,
   rankById varchar(255),
   createDate date,
   primary key (id)
)
create table light_user_profile (
   id bigint not null,
   userId bigint,
   firstName varchar(255),
   middleName varchar(255),
   lastName varchar(255),
   occupation varchar(255),
   ethnicity integer,
   bodyType integer,
   height integer,
   registerPurpose integer,
   maritalStatus integer,
   sexualOrientation integer,
   religion varchar(255),
   hometown varchar(255),
   smoker integer,
   drinker integer,
   childrenStatus integer,
   education integer,
   income varchar(255),
   headline varchar(255),
   aboutMe text,
   likeToMeet text,
   interests text,
   music text,
   movies text,
   television text,
   books text,
   heroes text,
   primary key (id)
)
create table light_user_role (
   id bigint not null,
   userId bigint,
   roleId varchar(255),
   primary key (id)
)
create table light_viewed_item (
   id bigint not null,
   link varchar(255),
   title varchar(255),
   itemDesc text,
   tag varchar(255),
   locale varchar(255),
   popCount integer,
   viewedDate datetime,
   primary key (id)
)
create table light_viewed_item_user (
   id bigint not null,
   itemId bigint,
   postById bigint,
   popCount integer,
   viewedDate datetime,
   primary key (id)
)
alter table light_chatting_record add index FK21639341FE20D94A (chattingId), add constraint FK21639341FE20D94A foreign key (chattingId) references light_chatting (id)
alter table light_forum add index FK7DDE7CB85F8BDF18 (categoryId), add constraint FK7DDE7CB85F8BDF18 foreign key (categoryId) references light_forum_category (id)
alter table light_portlet_preferences add index FKD2B1F8AC3D01D69 (portletId), add constraint FKD2B1F8AC3D01D69 foreign key (portletId) references light_portlet (id)
alter table light_store_order_item add index FK541BFF8BC15BBB37 (orderId), add constraint FK541BFF8BC15BBB37 foreign key (orderId) references light_store_order (id)