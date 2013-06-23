package cls.webmgr.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cls.webmgr.dao.PrivilegeMapper;
import cls.webmgr.pojo.Privilege;

/**
 * <p>Title: PrivilServiceImpl</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: GBICC </p>
 * @author zhangwx
 * @version 1.0
 * @createtime 2013-5-8 下午3:33:04
 *
 */
@Service("privilService")
public class PrivilServiceImpl implements IPrivilService {
	@Autowired(required=false)
	@Qualifier("privilegeDAO")
	
	private PrivilegeMapper privilegeDAO = null;
	
	public List<Privilege> getAllPrivilege(){
		return privilegeDAO.getAllPrivilege();
	}
	
	public List<Privilege> getPrivilegeByRole(Long roleId){
		return privilegeDAO.getPrivilegeByRole(roleId);
	}

	public PrivilegeMapper getPrivilegeDAO() {
		return privilegeDAO;
	}

	public void setPrivilegeDAO(PrivilegeMapper privilegeDAO) {
		this.privilegeDAO = privilegeDAO;
	}

	

}
