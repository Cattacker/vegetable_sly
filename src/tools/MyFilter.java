package tools;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class MyFilter extends StrutsPrepareAndExecuteFilter {
	@Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        String url = req.getRequestURI();
        if(url.equals("/vegetable/ueditor/jsp/controller.jsp")){
            arg2.doFilter(arg0, arg1);
        }else{
            super.doFilter(arg0, arg1, arg2);
        }
    }
}
