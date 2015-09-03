package lky.service;

import lky.entity.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
	public void createPermission(Permission permission);
	public void deletePermission(Long permissionId);
	public List<Permission> listPermission();
}
