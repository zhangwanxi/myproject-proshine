package cls.webmgr.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cls.webmgr.dao.RoleMapper;
import cls.webmgr.dao.RolePrivilMapper;
import cls.webmgr.pojo.Role;
import cls.webmgr.pojo.RoleExample;
import cls.webmgr.pojo.RolePrivil;

/**
 * <p>Title: RoleServiceImpl</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:33:10
 *
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	@Autowired
	RoleMapper roleDAO = null;
	@Autowired
	RolePrivilMapper rolePrivilegeDAO = null;
	@Autowired(required=false)

	public List<Role> getRoleList(RoleExample example){
		return roleDAO.getRoleList(example);
	}
	
	public List<Role> getRoleByUserId(Long adminId){
		return roleDAO.getRoleByUserId(adminId);
	}
	
	public int getRoleCount(RoleExample example){
		return roleDAO.getRoleCount(example);
	}
	
	public List<Role> getAllRole(){
		return roleDAO.getAllRole();
	}
	
	public void saveRole(Role Role){
		 roleDAO.saveRole(Role);
	}
	
	public Role getRoleById(Long roleId){
		return roleDAO.getRoleById(roleId);
	}
	
	public void updateRole(Role Role){
		roleDAO.updateRole(Role);
	}
	
	public List<Role> getRoleByName(String roleName){
		return roleDAO.getRoleByName(roleName);
	}
	
	
	public RoleMapper getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleMapper roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	@Transactional(value="transaction1",propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void savaeRolePrivil(List<RolePrivil> privilList){
		rolePrivilegeDAO.deleteByRoleIdRolePrivil(privilList.get(0).getRoleId());
		for(RolePrivil record:privilList){
			rolePrivilegeDAO.insertSelectiveRolePrivil(record);
		}
	}

	public RolePrivilMapper getRolePrivilegeDAO() {
		return rolePrivilegeDAO;
	}

	public void setRolePrivilegeDAO(RolePrivilMapper rolePrivilegeDAO) {
		this.rolePrivilegeDAO = rolePrivilegeDAO;
	}
	
	
}
