package edu.sakp.service;


import edu.sakp.pojo.Role;

import java.util.List;

public interface RoleService {

	List<Role> getAllRole();

	String addRole(String name);

	boolean delRoleById(Integer id);

	int updateRoleById(Integer id, String name);

}
