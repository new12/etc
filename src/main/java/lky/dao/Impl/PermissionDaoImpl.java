package lky.dao.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import lky.dao.PermissionDao;
import lky.entity.Permission;

import javax.annotation.Resource;
import java.util.List;

@Component("permissionDao")
public class PermissionDaoImpl implements PermissionDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void createPermission(Permission permission) {
		this.sqlSession.insert("lky.dao.Impl.createPermission", permission);
	}

	@Override
	public void deletePermission(Long permissionId) {
		this.sqlSession.delete("lky.dao.Impl.deletePermission",permissionId);
	}

	@Override
	public List<Permission> listPermissions(){
		return this.sqlSession.selectList("lky.dao.Impl.selectPermissions");
	}

}
