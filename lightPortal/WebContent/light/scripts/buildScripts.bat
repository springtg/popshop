set version=1.0

del ../../cache/init/*.js
jsmin <prototype.js> ../../cache/init/prototype.js
jsmin <template.js> ../../cache/init/template.js
FOR %%1 in (../../cache/init/*.js) do type %%1 >> ../../cache/init/tmp.js
jsmin <../../cache/init/tmp.js> ../../cache/init/all%version%.js

del ../../cache/portal/*.js
jsmin <light.js> ../../cache/portal/light.js
jsmin <lightAjax.js> ../../cache/portal/lightAjax.js
jsmin <lightPortal.js> ../../cache/portal/lightPortal.js
jsmin <lightPortalFooter.js> ../../cache/portal/lightPortalFooter.js
jsmin <lightPortalHeader.js> ../../cache/portal/lightPortalHeader.js
jsmin <lightPortalMenu.js> ../../cache/portal/lightPortalMenu.js
jsmin <lightPortalTab.js> ../../cache/portal/lightPortalTab.js
jsmin <lightPortlet.js> ../../cache/portal/lightPortlet.js
jsmin <lightService.js> ../../cache/portal/lightService.js
jsmin <lightUtil.js> ../../cache/portal/lightUtil.js
jsmin <lightWindow.js> ../../cache/portal/lightWindow.js
FOR %%1 in (../../cache/portal/*.js) do type %%1 >> ../../cache/portal/tmp.js
jsmin <../../cache/portal/tmp.js> ../../cache/portal/all%version%.js

del ../../cache/portalMobile/*.js
jsmin <light.js> ../../cache/portalMobile/light.js
jsmin <lightAjax.js> ../../cache/portalMobile/lightAjax.js
jsmin <lightPortal.js> ../../cache/portalMobile/lightPortal.js
jsmin <lightportalMobile.js> ../../cache/portalMobile/lightportalMobile.js
jsmin <lightPortalFooter.js> ../../cache/portalMobile/lightPortalFooter.js
jsmin <lightPortalHeaderView.js> ../../cache/portalMobile/lightPortalHeader.js
jsmin <lightPortalMenuMobile.js> ../../cache/portalMobile/lightPortalMenuMobile.js
jsmin <lightPortalTab.js> ../../cache/portalMobile/lightPortalTab.js
jsmin <lightPortlet.js> ../../cache/portalMobile/lightPortlet.js
jsmin <lightService.js> ../../cache/portalMobile/lightService.js
jsmin <lightUtil.js> ../../cache/portalMobile/lightUtil.js
jsmin <lightWindow.js> ../../cache/portalMobile/lightWindow.js
FOR %%1 in (../../cache/portalMobile/*.js) do type %%1 >> ../../cache/portalMobile/tmp.js
jsmin <../../cache/portalMobile/tmp.js> ../../cache/portalMobile/all%version%.js

del ../../cache/portalGroup/*.js
jsmin <light.js> ../../cache/portalGroup/light.js
jsmin <lightAjax.js> ../../cache/portalGroup/lightAjax.js
jsmin <lightPortal.js> ../../cache/portalGroup/lightPortal.js
jsmin <lightPortalGroup.js> ../../cache/portalGroup/lightPortalGroup.js
jsmin <lightPortalFooter.js> ../../cache/portalGroup/lightPortalFooter.js
jsmin <lightPortalHeaderView.js> ../../cache/portalGroup/lightPortalHeaderView.js
jsmin <lightPortalMenuView.js> ../../cache/portalGroup/lightPortalMenuView.js
jsmin <lightPortalTab.js> ../../cache/portalGroup/lightPortalTab.js
jsmin <lightPortlet.js> ../../cache/portalGroup/lightPortlet.js
jsmin <lightService.js> ../../cache/portalGroup/lightService.js
jsmin <lightUtil.js> ../../cache/portalGroup/lightUtil.js
jsmin <lightWindow.js> ../../cache/portalGroup/lightWindow.js
FOR %%1 in (../../cache/portalGroup/*.js) do type %%1 >> ../../cache/portalGroup/tmp.js
jsmin <../../cache/portalGroup/tmp.js> ../../cache/portalGroup/all%version%.js

del ../../cache/portalPage/*.js
jsmin <light.js> ../../cache/portalPage/light.js
jsmin <lightAjax.js> ../../cache/portalPage/lightAjax.js
jsmin <lightPortal.js> ../../cache/portalPage/lightPortal.js
jsmin <lightPortalPage.js> ../../cache/portalPage/lightPortalPage.js
jsmin <lightPortalFooter.js> ../../cache/portalPage/lightPortalFooter.js
jsmin <lightPortalHeaderView.js> ../../cache/portalPage/lightPortalHeaderView.js
jsmin <lightPortalMenuView.js> ../../cache/portalPage/lightPortalMenuView.js
jsmin <lightPortalTab.js> ../../cache/portalPage/lightPortalTab.js
jsmin <lightPortlet.js> ../../cache/portalPage/lightPortlet.js
jsmin <lightService.js> ../../cache/portalPage/lightService.js
jsmin <lightUtil.js> ../../cache/portalPage/lightUtil.js
jsmin <lightWindow.js> ../../cache/portalPage/lightWindow.js
FOR %%1 in (../../cache/portalPage/*.js) do type %%1 >> ../../cache/portalPage/tmp.js
jsmin <../../cache/portalPage/tmp.js> ../../cache/portalPage/all%version%.js

del ../../cache/portalView/*.js
jsmin <light.js> ../../cache/portalView/light.js
jsmin <lightAjax.js> ../../cache/portalView/lightAjax.js
jsmin <lightPortal.js> ../../cache/portalView/lightPortal.js
jsmin <lightPortalView.js> ../../cache/portalView/lightPortalView.js
jsmin <lightPortalFooter.js> ../../cache/portalView/lightPortalFooter.js
jsmin <lightPortalHeaderView.js> ../../cache/portalView/lightPortalHeaderView.js
jsmin <lightPortalMenuView.js> ../../cache/portalView/lightPortalMenuView.js
jsmin <lightPortalTab.js> ../../cache/portalView/lightPortalTab.js
jsmin <lightPortlet.js> ../../cache/portalView/lightPortlet.js
jsmin <lightService.js> ../../cache/portalView/lightService.js
jsmin <lightUtil.js> ../../cache/portalView/lightUtil.js
jsmin <lightWindow.js> ../../cache/portalView/lightWindow.js
FOR %%1 in (../../cache/portalView/*.js) do type %%1 >> ../../cache/portalView/tmp.js
jsmin <../../cache/portalView/tmp.js> ../../cache/portalView/all%version%.js

del ../../cache/lazyLoading/*.js
jsmin <lightFunctions.js> ../../cache/lazyLoading/lightFunctions.js
jsmin <lightPortletChat.js> ../../cache/lazyLoading/lightPortletChat.js
FOR %%1 in (../../cache/lazyLoading/*.js) do type %%1 >> ../../cache/lazyLoading/tmp.js
jsmin <../../cache/lazyLoading/tmp.js> ../../cache/lazyLoading/all%version%.js
