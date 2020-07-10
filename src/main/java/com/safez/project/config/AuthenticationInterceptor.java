package com.safez.project.config;

import com.safez.project.util.ApiToken;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        String sessionId = request.getSession ().getId ();
        if(sessionId == null){
            log.info("sessionId 已失效");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null ;
            JSONObject res = new JSONObject ();
            res.put("resultCode",302);
            res.put("message","sessionId 已失效");
            out = response.getWriter();
            out.append(res.toString());
            return false;
        }

        String token = request.getParameter ("token");
        log.info("Token:{" + token + "}; 请求路径:{" + request.getRequestURI() + "}");
        if (method.isAnnotationPresent(ApiToken.class)) {
            if (token != null) {
                if(sessionId.equals(token)){
                    return true;
                }else{
                    log.info("token不可用");
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter out = null ;
                    JSONObject res = new JSONObject ();
                    res.put("code",300);
                    res.put("message","token不可用");
                    out = response.getWriter();
                    out.append(res.toString());
                    return false;
                }
            }else{
                log.info("token不可为空");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = null ;
                JSONObject res = new JSONObject ();
                res.put("code",301);
                res.put("message","token不可为空");
                out = response.getWriter();
                out.append(res.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //方法执行之后拦截
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("========方法执行之后 开始调用===============");
    }


}
