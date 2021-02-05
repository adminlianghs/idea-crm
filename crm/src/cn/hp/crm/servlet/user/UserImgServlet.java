package cn.hp.crm.servlet.user;

import cn.hp.crm.model.User;
import cn.hp.crm.service.UserService;
import cn.hp.crm.service.impl.UserServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/user/userImg.do")
@MultipartConfig  // 使当前servlet类 可以进行处理图片
public class UserImgServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取上传的图片
        Part userImg = req.getPart("userImg");
//        System.out.println(userImg);
//        获取当前登录的用户
        User user = (User)req.getSession().getAttribute(SessionKey.USER_KEY);
        //        获取存储图片的文件夹 保存在服务器中单独的文件夹进行保存， 相当于在项目中获取了一个userImg文件夹
        String userImgPath = req.getServletContext().getRealPath("images/userImg");
        //        D:/project/crm_01/out/artifacts/crm_01_war_exploded/userImg  服务器运行程序的路径  就相当于发布到服务器中的内容
//        System.out.println(userImgPath);
//       用户上传的图片 保存在哪个位置  这个必须保存在编译文件中， 项目在发布的时候编译，
//        获取图片名 为了获取图片的后缀名   减少服务器中保存的图片数量，减少压力 使用登录用户的用户id作为图片名称
        String fileName = userImg.getSubmittedFileName();  // 获取用户提交的图片原始名称
//        设置新的图片名称
        int i = fileName.lastIndexOf(".");
        String  suffix = fileName.substring(i);
        String imgName = user.getUserId() +  suffix ;
//        System.out.println(imgName);
//        将文件夹和图片名称合并 组成新的文件全路径     File.separator 根据当前系统自动设置 文件分隔符
        userImgPath = userImgPath + File.separator + imgName ;
//        D:/project/crm_01/out/artifacts/crm_01_war_exploded/ =  /
//              userImg/id.png  保存图片路径
        userImg.write(userImgPath); // 将上传的图片保存在一个路径中
        System.out.println(userImgPath);
//        String benDi = "G:\\workspace\\crm\\web\\images\\userImg\\" + imgName;
//        System.out.println(benDi);
//        userImg.write(benDi); //将图片保存在本地文件夹下，保证不会在清除out缓存时图片丢失
//        将图片路径保存至数据库
        String url = "images/userImg/" +imgName ;
        UserService userService = new UserServiceImpl();
        ResultData resultData = userService.updateImg(user.getUserId(),url);
//        如果业务层 处理成功  ,将新的图片地址保存到当前登录的用户中
        if (resultData.getCode()== 200){
            user.setUserImg(url);
            req.getSession().setAttribute(SessionKey.USER_KEY,user);
        }
        resp.getWriter().println(JSONUtil.parseObj(resultData));
    }
}
