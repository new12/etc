package lky.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import lky.dao.UserDao;
import lky.entity.User;


import javax.annotation.Resource;

@Component("userDao")

public class UserDaoImpl implements UserDao {

	@Resource
	private SqlSession sqlSession;
	@Override
	public void createUser(User user) {
		this.sqlSession.insert("lky.dao.Impl.createUser",user);
	}

	@Override
	public void updateUser(User user) {
		this.sqlSession.insert("lky.dao.Impl.updateUser",user);
	}

	@Override
	public void deleteUser(Long userId) {
		this.sqlSession.insert("lky.dao.Impl.deleteUser",userId);
	}

	@Override
	public void correlationRoles(Long userId, Long... rolesIds) {
		for (Long roleId:rolesIds) {
			Map<String,Long> map= new HashMap<String, Long>();
			map.put("user_id", userId);
			map.put("role_id", roleId);
			this.sqlSession.insert("lky.web.Impl.singleUserCorrelation",map);
		}
		
	}

	@Override
	public void unCorrelationRoles(Long userId, Long... rolesIds) {
		for (Long roleId:rolesIds) {
			Map<String,Long> map= new HashMap<String, Long>();
			map.put("user_id", userId);
			map.put("role_id", roleId);
			this.sqlSession.delete("lky.web.Impl.singleUserUnCorrelation",map);
		}
		
	}

	@Override
	public User findOne(Long userId) {
		return this.sqlSession.selectOne("lky.dao.Impl.findOne", userId);
	}

	@Override
	public User findByUsername(String username) {
		return this.sqlSession.selectOne("lky.dao.Impl.findByUsername", username);
	}

	@Override
	public List<String> findRoles(String username) {
		return this.sqlSession.selectList("lky.dao.Impl.findRoles",username);
	}

	@Override
	public List<String> findPermissions(String username) {
		return this.sqlSession.selectList("lky.dao.Impl.findPermissions",username);
	}

}
