package cls.webmgr.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cls.webmgr.pojo.Privilege;
import cls.webmgr.pojo.User;
import cls.webmgr.pojo.UserRole;

/**
 * <p>Title: IUserService</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:32:39
 *
 */
public interface IUserService {
	/** 
	* @Title: getUserByPK 
	* @Description: 根据用户ID查询用户
    * @throws 
	*/
    public User getUserByPK(Long userId);
    /** 
	* @Title: getUserList 
	* @Description: 根据条件查询用户列表
    * @throws 
	*/
	public List<HashMap> getUserList(HashMap map);
	/** 
	* @Title: getUserNum 
	* @Description: 根据条件查询用户数目
    * @throws 
	*/
	public int getUserNum(HashMap map);
	/** 
	* @Title: saveUser 
	* @Description: 保存用户及用户角色
    * @throws 
	*/
	public void saveUser(User user,String userRole);
	/** 
	* @Title: updateUser 
	* @Description: 更新用户
    * @throws 
	*/
	public void updateUser(User user,String userRole);
	/** 
	* @Title: checkLogin 
	* @Description: 检查用户名
    * @throws 
	*/
	public User checkLogin(String loginName);
	/** 
	* @Title: getUserPrivilege 
	* @Description: 根据用户ID查询权限
    * @throws 
	*/
	public List<Privilege> getUserPrivilege(Long userId);
	/** 
	* @Title: getUserListByRole 
	* @Description: 根据用户角色查询用户列表
    * @throws 
	*/
	public List<HashMap> getUserListByRole(HashMap map);
	/** 
	* @Title: getUserNumByRole 
	* @Description: 根据用户角色查询用户数目
    * @throws 
	*/
	public int getUserNumByRole(HashMap map);


	
	public int updateUser(User user);
	
	
	
	
	
	/** 
   	 * 
   	 * @Title: selectUserRoleListByUserId
   	 * @Description: 查询该客户的所有角色信息
   	 * @author zhangwx
   	 * @date 2012.12.27
   	 * @param String
   	 * @return   List<UserRole>
   	 * @throws 
   	 */
	public  List<UserRole> selectUserRoleListByUserId(Long userId);
	
	
	
}
