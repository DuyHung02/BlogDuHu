package com.example.blog.controller;

import com.example.blog.model.Account;
import com.example.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String gmail, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        Account account = accountService.checkLogin(gmail, password);
        if (account == null) {
            httpSession.setAttribute("message","Sai thông tin");
        } else {
            httpSession.setAttribute("account", account);
            httpSession.setAttribute("message", "Đăng nhập thành công");
        }
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(Account account, @RequestParam MultipartFile upImg) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        if (accountService.checkGmail(account.getGmail())) {
            httpSession.setAttribute("message", "Gmail đã tồn tại");
        } else {
            String nameFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(), new File("D:\\CODEGYM\\Modul_4\\6. JPA\\blog\\src\\main\\webapp\\WEB-INF\\image\\" + nameFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
            account.setAvatar("/image/" + nameFile);
            accountService.save(account);
            httpSession.setAttribute("message", "Tạo thành công!");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        httpSession.setAttribute("account", null);
        httpSession.setAttribute("message", "Đăng xuất thành công");
        return modelAndView;
    }
}
