package lky.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lky.dao.PermissionDao;
import lky.entity.Permission;
import lky.service.PermissionService;

import java.util.List;
import java.util.Map;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	@Resource
	private PermissionDao permissionDao;

	@Override
	public void createPermission(Permission permission) {
		permissionDao.createPermission(permission);
		
	}

	@Override
	public void deletePermission(Long permissionId) {
		permissionDao.deletePermission(permissionId);
	}

	@Override
	public List<Permission> listPermission() {
		return  permissionDao.listPermissions();
	}

}
