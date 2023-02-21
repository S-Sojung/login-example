package shop.mtcoding.loginexample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.model.User;

public class WebInterceptor implements HandlerInterceptor {

    // 요청 들어가기 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("================ URL 요청 전 인터셉터 ==================");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            throw new CustomException("인증이 되지 않았습니다.", HttpStatus.FORBIDDEN);
        }
        request.setAttribute("user", user);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    // 요청 완료 후
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        System.out.println("================ URL 요청 후 인터셉터 ==================");
    }

}
