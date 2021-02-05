package cn.hp.crm.test;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.lang.Console;

public class Test01 {

    public static void main(String[] args) {

        int i = "1.23.4.png".lastIndexOf(".");
        String substring = "1.23.4.png".substring(i);
        System.out.println(substring);
//        String bir = "2020-10-01";
//        System.out.println(bir.substring(5));
//        String str = "abc";
//        String str2 = " abc  ";
//        System.out.println(str.equals(str2.trim()));

//        String str = "123";
//        String str2 = new String("123");
//        System.out.println(str.equals(str2));
//        System.out.println(str == str2);
//
//        System.out.println("作家".hashCode());
//        System.out.println("酱油".hashCode());

        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
//        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(300, 100, 6, 4);
//ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
//图形验证码写出，可以写出到文件，也可以写出到流
//        captcha.write("d:/shear.png");
//验证图形验证码的有效性，返回boolean值
//        captcha.verify("1234");


        //定义图形验证码的长和宽
//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

//图形验证码写出，可以写出到文件，也可以写出到流
//        lineCaptcha.write("d:/line.png");
//输出code
//        Console.log(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");
//
////重新生成验证码
//        lineCaptcha.createCode();
//        lineCaptcha.write("d:/line.png");
////新的验证码
//        Console.log(lineCaptcha.getCode());
////验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");
    }
}
