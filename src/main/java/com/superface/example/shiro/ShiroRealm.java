package com.superface.example.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.superface.example.entity.Permission;
import com.superface.example.entity.Role;
import com.superface.example.entity.User;
import com.superface.example.repositories.PermissionReposity;
import com.superface.example.repositories.RoleReposity;
import com.superface.example.repositories.UserRepository;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ShiroRealm
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleReposity userRoleRepository;
	@Autowired
	private PermissionReposity userPermissionRepository;

	/**
	 * 获取用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String userName = user.getUserName();

		System.out.println("用户" + userName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		// 获取用户角色集
		List<Role> roleList = userRoleRepository.findByName(userName);
		Set<String> roleSet = new HashSet<String>();
		List<Permission> permissionList = userPermissionRepository.findByName(userName);
		for (Role r : roleList) {
			roleSet.add(r.getName());
			permissionList.addAll(r.getRolePermission());
		}
		simpleAuthorizationInfo.setRoles(roleSet);

		// 获取用户权限集
		Set<String> permissionSet = new HashSet<String>();
		for (Permission p : permissionList) {
			permissionSet.add(p.getName());
		}
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
		User user = userRepository.findByUserNameAndPassword(userName,password);

		if (user == null) {
			throw new UnknownAccountException("用户名或密码错误！");
		}
		if (user.getStatus().equals("0")) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

    
}