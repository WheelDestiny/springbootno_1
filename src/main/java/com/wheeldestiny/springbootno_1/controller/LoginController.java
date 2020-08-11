package com.wheeldestiny.springbootno_1.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.wheeldestiny.springbootno_1.bean.User;
import com.wheeldestiny.springbootno_1.interceptor.loginTest;
import com.wheeldestiny.springbootno_1.service.PeopleService;
import com.wheeldestiny.springbootno_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //验证码工具
    @Autowired
    DefaultKaptcha defaultKaptcha;

    //生成验证码
    @RequestMapping(value = "/defaultKaptcha")
    public void defaultKaptcha(HttpServletResponse response,HttpServletRequest request) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            //生产正确验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("rightCode",createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",outputStream);
            //
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //定义response输出类型为image/jpg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = outputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(captchaChallengeAsJpeg);
        servletOutputStream.flush();
        servletOutputStream.close();
    }
    /*校对验证码
    * */
    @ResponseBody
    @RequestMapping(value = "/testCode", method = RequestMethod.POST)
    public Boolean testCode(@RequestBody String verificationCode,HttpSession session){
        String rightCode = (String)session.getAttribute("rightCode");
        String inputCode = verificationCode.substring(1,verificationCode.length()-1);
        Boolean res = false;
        if (rightCode.equals(inputCode)){
            res = true;
        }
        return res;
    }

    //跳转主页
    //如果尚未登录将跳转登录页
    @loginTest
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String showIndex(Model model,HttpSession session){
        return "/production/tables_dynamic2";
    }
    //跳转登录页
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(){
        return "/production/login";
    }

    //登录
    //登录成功：将用户信息存入session，跳转主页
    //登录失败：返回失败信息
    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public Map login(@RequestBody User user,HttpSession session) {
        HashMap<String,Object> resMap = new HashMap<>();
        User userBean = userService.login(user.getUsername(),user.getPassword());
        Boolean result = false;
        if(userBean!=null){
//            System.out.println("账号密码正确");
            result = true;
            session.setAttribute("user",userBean);
        }else{
//            System.out.println("账号密码有误");
        }
        resMap.put("result",result);
        return resMap;
    }
    //注册
    //如果注册成功，将用户信息存入session并直接跳转首页
    //注册失败。。。还没想好，暂时只有提示
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map addUser(@RequestBody User user,HttpSession session) {
        HashMap<String,Object> resMap = new HashMap<>();
        Long res = userService.addUser(user.getUsername(),user.getPassword());
        User userBean = new User();
        Boolean result = false;
        if (res>0){
            userBean = userService.login(user.getUsername(),user.getPassword());
            session.setAttribute("user",userBean);
            result = true;
        }
        resMap.put("result",result);
        return resMap;
    }
    //校验用户名是否存在
    @ResponseBody
    @RequestMapping(value = "/queryByname", method = RequestMethod.POST)
    public Boolean queryByname(@RequestBody User user) {
        User userBean = userService.queryByName(user.getUsername());
        Boolean result = true;
        if(userBean!=null){
            System.out.println("用户名存在");
            result = false;
        }else{
            System.out.println("用户名不存在，可以使用");
        }
        return result;
    }
    //退出登录longOut
    //跳转登录页
    @loginTest
    @RequestMapping(value = "/longOut",method = RequestMethod.GET)
    public String longOut(HttpSession session){
        //清除session域中的内容
        session.invalidate();
        return "/production/login";
    }
}
