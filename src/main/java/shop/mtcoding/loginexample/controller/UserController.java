package shop.mtcoding.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.mtcoding.loginexample.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.loginexample.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.service.UserService;
import shop.mtcoding.loginexample.util.EncryptionUtils;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {

        if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 작성해주세요");
        }
        if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 작성해주세요");
        }

        String password = EncryptionUtils.encrypt(loginReqDto.getPassword());
        loginReqDto.setPassword(password);

        User principal = userService.로그인(loginReqDto);

        session.setAttribute("principal", principal);

        return "redirect:/";

    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 작성해주세요");
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 작성해주세요");
        }
        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("email을 작성해주세요");
        }
        String password = EncryptionUtils.encrypt(joinReqDto.getPassword());
        joinReqDto.setPassword(password);
        userService.회원가입(joinReqDto);

        return "redirect:/loginForm";
    }

    @GetMapping({ "/" })
    public String mainScreen(Model model) {

        return "user/mainScreen";
    }
}
