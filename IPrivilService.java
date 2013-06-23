package cls.webmgr.system.service;

import java.util.List;

import cls.webmgr.pojo.Privilege;

/**
 * <p>Title: IPrivilService</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:32:25
 *
 */
public interface IPrivilService {
  
   /** 
	* @Title: getAllPrivilege 
	* @Description: 查询所有权限列表
    * @throws 
	*/
	public List<Privilege> getAllPrivilege();
	/** 
	* @Title: getPrivilegeByRole 
	* @Description: 根据角色ID查询权限列表
    * @throws 
	*/
	public List<Privilege> getPrivilegeByRole(Long roleId);
}
