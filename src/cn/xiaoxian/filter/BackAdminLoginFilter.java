package cn.xiaoxian.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BackAdminLoginFilter implements Filter {
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 处理前台用户的登录过滤
		HttpServletRequest request = (HttpServletRequest) arg0;// 类型转换
		HttpSession session = request.getSession();// 获取Session对象
		System.out.println(session.getAttribute("adminid"));
		if (session.getAttribute("adminid") != null) {
			// 用户已经登录,向下传递
			arg2.doFilter(arg0, arg1);
		} else {
			// 进行信息提示
			request.setAttribute("msg", "您还未登录，请先登录!");
			request.setAttribute("path", request.getContextPath() + "/login.jsp");
			// 进行服务器端的跳转
			request.getRequestDispatcher("/forward.jsp").forward(arg0, arg1);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
