package com.PrjFrame.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SuppressWarnings("all")
public class SecurityUtils {

	private static String CURRENT_USER_SESSION = "CurUser";

	public static <T> void onLogin(T user) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60);
		session.setAttribute(CURRENT_USER_SESSION, user);
	}

	public static void onLogout() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().removeAttribute(CURRENT_USER_SESSION);
		request.getSession().invalidate();
	}

	public static <T> T getCurUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return (T) request.getSession().getAttribute(CURRENT_USER_SESSION);
	}

	public static <T> void onLogin(T user, int maxSession) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(maxSession);
		session.setAttribute("sessionSec", maxSession);// session超时时间
		session.setAttribute(CURRENT_USER_SESSION, user);
	}

	/**
	 * 获取指定Session的用户
	 * 
	 * @param session
	 * @return
	 * @author XHP
	 * @date 2017年3月9日 下午4:52:28
	 */
	public static <T> T getUserBySession(HttpSession session) {
		return (T) session.getAttribute(CURRENT_USER_SESSION);
	}
}
