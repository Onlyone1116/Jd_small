package jdsmall.web;

import com.cdvtc.news.entity.User;
import com.cdvtc.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String account, String password, HttpSession session, HttpServletRequest request, Model model) {
        User user = userService.login(account, password);
        if(user != null) { //登陆成功
            session.setAttribute("user", user); //在Session中保存登陆用户信息
            session.setAttribute("ipAddress", request.getRemoteAddr());
            return "redirect:/";  //重定向至首页
        } else { //登陆失败
            model.addAttribute("error", "登陆失败");
            return "login"; // 返回登陆页面
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 销毁Session对象
        return "redirect:/"; // 重定向至首页
    }
}
