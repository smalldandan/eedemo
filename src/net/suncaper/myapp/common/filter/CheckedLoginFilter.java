package net.suncaper.myapp.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CheckedLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        boolean is = false;        //判断URL是否是登陆页面或者静态资源
        String[] exclude = new String[]{"login","css","html","jpg","png","jpeg","bmp","js"};

        for (String each : exclude) {
            if (requestURI.contains(each)){
                is = true;//放行
                break;
            }
        }
        if (requestURI.equals("/")){
            //忽略首页,直接放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if (is){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //验证是否登录
        if(request.getSession().getAttribute("currentUser")==null){
             request.setAttribute("msg","你的操作需要登录！！！");
            //跳转回登录页面
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
