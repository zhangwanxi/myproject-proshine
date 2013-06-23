package cls.webmgr.system.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import cls.webmgr.dao.PrivilegeMapper;
import cls.webmgr.dao.UserMapper;
import cls.webmgr.dao.UserRoleMapper;

import cls.webmgr.pojo.Privilege;

import cls.webmgr.pojo.User;
import cls.webmgr.pojo.UserRole;
import cls.webmgr.util.DateUtil;
import cls.webmgr.util.cache.CacheDataCenter;


/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:33:18
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	UserMapper userDAO = null;
	@Autowired
	UserRoleMapper userRoleDAO = null;
	@Autowired
	PrivilegeMapper privilegeDAO = null;
	
	
	
	



	public List<HashMap> getUserList(HashMap map){
		return userDAO.getUserList(map);
	}
	
	public List<HashMap> getUserListByRole(HashMap map){
		return userDAO.getUserListByRole(map);
	}

	public int getUserNum(HashMap map){
		return userDAO.getUserNum(map);
	}
	
	public int getUserNumByRole(HashMap map){
		return userDAO.getUserNumByRole(map);
	}
	
	
	@Transactional(value="transaction1",propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveUser(User user,String roleIds){
		userDAO.insertSelectiveUser(user);
		String [] idArray = roleIds.split(",");
	    for(int i=0;i<idArray.length;i++){
	        UserRole userRole = new UserRole();
		    userRole.setUserId(user.getUserId());
		    userRole.setRoleId(Long.valueOf(idArray[i]));
	    	userRoleDAO.insertSelectiveUserRole(userRole);
	    }
	}
	
	@Transactional(value="transaction1",propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateUser(User user,String roleIds){
		userDAO.updateByPrimaryKeySelectiveUser(user);
		userRoleDAO.deleteByUserId(user.getUserId());
		String [] idArray = roleIds.split(",");
	    for(int i=0;i<idArray.length;i++){
	        UserRole userRole = new UserRole();
		    userRole.setUserId(user.getUserId());
		    userRole.setRoleId(Long.valueOf(idArray[i]));
	    	userRoleDAO.insertSelectiveUserRole(userRole);
	    }
	}
	
	public int updateUser(User user){
	    return userDAO.updateByPrimaryKeySelectiveUser(user);
	 }
	
	public User getUserByPK(Long customusercode){
	  return userDAO.selectByPrimaryKeyUser(customusercode);
	}
	
	public User checkLogin(String adminAccount){
	  return userDAO.checkLogin(adminAccount);
	}
	
	public List<Privilege> getUserPrivilege(Long usercode){
	  return privilegeDAO.getUserPrivilege(usercode);
	}
	

	public UserRoleMapper getUserRoleDAO() {
		return userRoleDAO;
	}

	public void setUserRoleDAO(UserRoleMapper userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	


	
	
	
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
	public  List<UserRole> selectUserRoleListByUserId(Long userId){
		return userRoleDAO.selectUserRoleListByUserId(userId);
	}
	
	
	
	
	
}
