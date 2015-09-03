package lky.dao;

import lky.entity.Permission;

import java.util.List;

public interface PermissionDao {
	public void createPermission(Permission permission);
	public void deletePermission(Long permissionId);
	List<Permission> listPermissions();
}
