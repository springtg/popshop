package com.poprlz.unit.service.security;

import org.easymock.classextension.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UsernameNotFoundException;
import com.poprlz.dao.security.UserDao;
import com.poprlz.entity.security.Authority;
import com.poprlz.entity.security.Role;
import com.poprlz.entity.security.User;
import com.poprlz.service.security.UserDetailServiceImpl;
import org.springside.modules.utils.ReflectionUtils;

/**
 * UserDettailServiceImpl的单元测试用例. 
 * 
 * 使用EasyMock对UserManager进行模拟.
 * 
 * @author calvin
 */
public class UserDetailServiceImplTest extends Assert {
	private UserDetailServiceImpl userDetailService = new UserDetailServiceImpl();
	private UserDao userDao = null;

	@Before
	public void setUp() {
		//创建mock对象
		userDao = EasyMock.createMock(UserDao.class);
		ReflectionUtils.setFieldValue(userDetailService, "userDao", userDao);
	}

	@After
	public void tearDown() {
		//确认的脚本都已执行
		EasyMock.verify(userDao);
	}

	@Test
	public void loadUserExist() {
		//准备数据
		String loginName = "user";
		String passwd = "userPass";
		String authName = "A_aaa";

		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(passwd);
		Role role = new Role();
		user.getRoles().add(role);
		Authority auth = new Authority();
		auth.setName(authName);
		role.getAuthorities().add(auth);

		//录制脚本
		EasyMock.expect(userDao.findByUnique("loginName", loginName)).andReturn(user);
		EasyMock.replay(userDao);

		//执行测试
		UserDetails userDetails = userDetailService.loadUserByUsername(loginName);

		//校验结果
		assertEquals(loginName, userDetails.getUsername());
		assertEquals(passwd, userDetails.getPassword());
		assertEquals(1, userDetails.getAuthorities().length);
		assertEquals(new GrantedAuthorityImpl(authName), userDetails.getAuthorities()[0]);
	}

	@Test(expected = UsernameNotFoundException.class)
	public void loadUserNotExist() {
		//录制脚本
		EasyMock.expect(userDao.findByUnique("loginName", "userNameNotExist")).andReturn(null);
		EasyMock.replay(userDao);
		//执行测试
		userDetailService.loadUserByUsername("userNameNotExist");
	}
}