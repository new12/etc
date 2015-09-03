package lky.service.Impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lky.dao.UserDao;
import lky.entity.User;
import lky.service.UserService;
import lky.util.PasswordHelper;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	@Override
	public void createUser(User user) {
		PasswordHelper.encryptPassword(user);
		userDao.createUser(user);
	}

	@Override
	public String changePassword(String loginName,String oldPwd, String newPwd) {
		User user = userDao.findByUsername(loginName);
		if (PasswordHelper.validatePwd(oldPwd,user)) {
			user.setPassword(newPwd);
			PasswordHelper.encryptPassword(user);
			userDao.updateUser(user);
			return "success";
		}else{
			return "error";
		}
	}

	@Override
	public void corraltionRoles(Long userId, Long... rolesIds) {
		userDao.correlationRoles(userId, rolesIds);
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... rolesIds) {
		userDao.correlationRoles(userId, rolesIds);
		
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

	@Override
	public List<String> findPermission(String username) {
		return userDao.findPermissions(username);
	}

	@Override
	public void getLoginUserName() {
		Subject subject = SecurityUtils.getSubject();
		subject.getPrincipal();
	}

}
