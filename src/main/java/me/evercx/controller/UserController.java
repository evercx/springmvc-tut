package me.evercx.controller;


import me.evercx.domain.User;
import me.evercx.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("exc...");

        User user =  new User();
        user.setUsername("mm");
        user.setPassword("123");
        user.setAge(30);

        model.addAttribute("user",user);

        return "success";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("exc...");

        // 编写请求转发的程序
        // request.getRequestDispatcher("").forward(request,response);

        // 重定向
        // System.out.println(request.getContextPath());
        // response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接进行响应
        response.getWriter().print("hello你");
    }



    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        ModelAndView mv = new ModelAndView();

        System.out.println("exc...");
        User user =  new User();
        user.setUsername("xf");
        user.setPassword("456");
        user.setAge(30);

        // 把user对象存储到mv对象中，会把user对象存入到request对象
        mv.addObject("user",user);

        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }


    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(Model model){
        System.out.println("exc...");

        // 请求转发
        // return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
    }


    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){

        System.out.println("ajax......");
        // 客户端发送ajax的请求 传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        user.setUsername("haha");
        user.setAge(40);
        // 做响应

        return user;
    }

    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request)throws Exception{
        System.out.println("file upload");

        // 使用fileupload组件完成文件上传

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file =  new File(path);

        if(!file.exists()){
            file.mkdirs();
        }

        // 解析request对象 获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload =  new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);

        for(FileItem item:items){
            if(item.isFormField()){
                // 说明普通表单项
            }else {
                // 上传文件项
                String filename = item.getName();
                // 把文件名称设置唯一值
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid + "_" + filename;
                item.write(new File(path,filename));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }


    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload)throws Exception{
        System.out.println("spring mvc file upload");

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file =  new File(path);

        if(!file.exists()){
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;

        // 完成文件上传
        upload.transferTo(new File(path,filename));

        return "success";
    }


    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException exc...");


        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();

            throw new SysException("error out");
        }


        return "success";
    }


}
