package cls.webmgr.system.service;

import java.util.List;

import cls.webmgr.pojo.Role;
import cls.webmgr.pojo.RoleExample;
import cls.webmgr.pojo.RolePrivil;

/**
 * <p>Title: IRoleService</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:32:32
 *
 */
public interface IRoleService {
	
	/** 
	* @Title: getRoleList 
	* @Description: 根据条件查询角色列表
    * @throws 
	*/
	public List<Role> getRoleList(RoleExample example);
	/** 
	* @Title: getRoleByUserId 
	* @Description: 根据用户ID查询角色
	* @param userId 用户ID
    * @throws 
	*/
	public List<Role> getRoleByUserId(Long userId);
	/** 
	* @Title: getRoleCount 
	* @Description: 查询角色数目
    * @throws 
	*/
	public int getRoleCount(RoleExample example);
	/** 
	* @Title: getAllRole 
	* @Description: 查询所有角色
    * @throws 
	*/
	public List<Role> getAllRole();
	/** 
	* @Title: saveRole 
	* @Description: 保存角色
    * @throws 
	*/
	public void saveRole(Role Role);
	/** 
	* @Title: getRoleById 
	* @Description: 根据角色ID查询角色
	* @param roleId 角色ID
    */
	public Role getRoleById(Long roleId);
	/** 
	* @Title: updateRole 
	* @Description: 更新角色
    * @throws 
	*/
	public void updateRole(Role Role);
	/** 
	* @Title: getRoleByName 
	* @Description: 根据角色名称查询角色
    * @throws 
	*/
	public List<Role> getRoleByName(String roleName);
	/** 
	* @Title: savaeRolePrivil 
	* @Description: 保存角色的权限
    * @throws 
	*/
	public void savaeRolePrivil(List<RolePrivil> privilList);
	
	
}
