package com.PrjFrame.base.intercepter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.opensymphony.oscache.general.GeneralCacheAdministrator;

@SuppressWarnings("rawtypes")
public class SecurityIntercepter extends HandlerInterceptorAdapter implements InitializingBean {

	final static Log log = LogFactory.getLog(SecurityIntercepter.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 获取用户
	static Map permissionMap;
	// 获取url-permission
	static Map urlMap;
	// 获取角色
	static List roleList;
	// 系统全部url-permission
	static Map urlpmsMap;
	// 获取用户权限
	Map userpms = new HashMap();
	// 获取用户权限下方法
	Map methodMap = new HashMap();

	static GeneralCacheAdministrator cacheadmin;

	@CacheEvict(value = "SecurityCache", allEntries = true)
	public void afterPropertiesSet() throws Exception {
		log.debug("拦截器SecurityIntercepter初始化");
		System.out.println("拦截器SecurityIntercepter初始化");
		System.out.println("清除所有cache缓存");
		cacheadmin = new GeneralCacheAdministrator();
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getServletPath();
		return true;
//		// System.out.println("-------------------------------------xx"+url);
//		AntPathMatcher matcher = new AntPathMatcher();
//
//		if (matcher.match("/assets/**", url)) {
//			return true;
//		}
//		if (matcher.match("/admin/login", url)) {
//			return true;
//		} else {
//			User user = SecurityUtils.getCurUser();
//			if (user == null) {
//				response.sendRedirect(request.getContextPath() + "/admin/login");
//				return false;
//			} else {
//				if (matcher.match("/", url)) {
//					response.sendRedirect(request.getContextPath() + "/admin/index");
//					return false;
//				}
//				return true;
//			}
//		}
		
	}

}
