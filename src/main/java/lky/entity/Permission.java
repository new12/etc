package lky.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Permission implements Serializable {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	private Long id;
	@NotNull
	private String permission;
	@NotNull
	private String description;
	private Boolean available = Boolean.FALSE;
	private String name;
	public Permission(){}
	public Permission(String permission,String description,Boolean available){
		this.permission=permission;
		this.description=description;
		this.available=available;
	}
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if(getClass()!=obj.getClass()){return false;}
		Permission o = (Permission)obj;
		if (id!=null?!id.equals(o.id):o.id!=null) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		
		return id!=null?id.hashCode():0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
