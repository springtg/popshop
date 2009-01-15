package org.light.portal.util;

import org.light.portal.model.Organization;
import static org.light.portal.util.Constants._DEFAULT_USER;
import static org.light.portal.util.Constants._DEFAULT_ORG_LOGO;
import static org.light.portal.util.Constants._DEFAULT_ORG_LOGOICON;
import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;

public class OrganizationThreadLocal {
	public static Organization getOrg() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getOrg " + org);
		}

		if (org != null) {
			return org;
		}
		else {
			return null;
		}
	}
	public static long getOrganizationId() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getOrganizationId " + org);
		}

		if (org != null) {
			return org.getId();
		}
		else {
			return 0;
		}
	}
	
	public static String getDefaultUserId() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getDefaultUserId " + org);
		}

		if (org != null) {
			return org.getDefaultUserId();
		}
		else {
			return _DEFAULT_USER;
		}
	}
	
	public static String getWebId() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getWebId " + org);
		}

		if (org != null) {
			return org.getWebId();
		}
		else {
			return "";
		}
	}
	
	public static String getLogo() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getLogo " + org);
		}

		if (org != null && !StringUtils.isEmpty(org.getLogoUrl())) {
			return org.getLogoUrl();
		}
		else {
			return _DEFAULT_ORG_LOGO;
		}
	}
	
	public static String getLogoIcon() {
		Organization org = _threadLocal.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getLogoIcon " + org);
		}

		if (org != null && !StringUtils.isEmpty(org.getLogoIcon())) {
			return org.getLogoIcon();
		}
		else {
			return _DEFAULT_ORG_LOGOICON;
		}
	}
	
	public static void setOrganization(Organization org) {
		if (_log.isDebugEnabled()) {
			_log.debug("setOrganizationId " + org.getId());
		}

		if (org != null) {
			_threadLocal.set(org);
		}
		else {
			_threadLocal.set(null);
		}
	}

	private static Logger _log = LoggerFactory.getLogger(OrganizationThreadLocal.class);
	private static ThreadLocal<Organization> _threadLocal = new ThreadLocal<Organization>();
}
