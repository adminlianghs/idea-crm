<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <script src="/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" >
    <div class="layui-form-item">
        <label class="layui-form-label">当前用户</label>
        <div class="layui-input-block">
            <input type="text" name="username" value="${user.username }" readonly  class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">原始密码</label>
        <div class="layui-input-block">
            <input type="password" id="password" name="password" lay-verify="required" placeholder="请输入原始密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-block">
            <input type="password" id="newPassword" name="newPassword" lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input type="password" id="rePassword" name="rePassword" lay-verify="required" placeholder="请确认新密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="submitBtn" class="layui-btn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
<script>

    layui.use(['jquery','form','layer'],function () {
        var $ = layui.jquery,
        form = layui.form ,
        layer = layui.layer ;

        $("#submitBtn").click(function () {
            //每次点击都 重新获取当前输入框得值
            let $password = $("#password").val();
            let $newPassword = $("#newPassword").val();
            let $rePassword = $("#rePassword").val();
            // 前端验证： 1、验证 新 旧 两次密码相同
            if ($password == $newPassword){
                layer.msg("新密码和旧密码不能相同，请重新设置");
                return false ;
            }else if($newPassword !=$rePassword){
                layer.msg("两次输入得新密码不相同， 请重新输入")
                return false;
            }else {
                //    使用ajax 向后端进行请求访问
                $.ajax({
                    url:"/user/changePassword.do"
                    ,data:{
                        "password":$password,
                        "newPassword":$newPassword
                    }
                    ,type:"post"
                    ,dataType:"json"
                    ,success:function (data) {
                        //修改成功
                        if (data.code == 200){
                            layer.msg(data.msg)
                            setTimeout(function () {
                                // 修改成功 ，重新登录
                                window.parent.location = "/user/loginOut.do"
                            },3000)
                        };
                        layer.msg(data.msg);
                        return false ;
                    }
                })
                return false ;
            }
        })

    })

</script>
</html>
