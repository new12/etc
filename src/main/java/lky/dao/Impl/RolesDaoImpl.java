package lky.dao.Impl;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import lky.dao.RoleDao;
import lky.entity.Role;

import javax.annotation.Resource;

@Component("roleDao")
public class RolesDaoImpl implements RoleDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void createRole(Role role) {
		this.sqlSession.insert("lky.dao.Impl.createRole", role);
		
	}

	@Override
	public void deleteRole(Long roleId) {
		this.sqlSession.delete("lky.dao.Impl.deleteRole",roleId);
		
	}

	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		for (Long permissionId:permissionIds) {
			Map<String,Long> map= new HashMap<String, Long>();
			map.put("role_id", roleId);
			map.put("permission_id", permissionId);
			this.sqlSession.insert("lky.web.Impl.singleRoleCorrelation",map);
		}
	}

	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		for(Long permissionId:permissionIds){
			Map<String,Long> map= new HashMap<String, Long>();
			map.put("role_id", roleId);
			map.put("permission_id", permissionId);
			this.sqlSession.insert("lky.web.Impl.singleRoleUnCorrelation",map);
		}
	}

}
