<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <script src="/layui/layui.js"></script>
</head>
<body>

    <div class="layui-upload" style="margin: 50px ">
        <div class="layui-upload-list">
            <c:choose>
                <c:when test="${user.userImg != null }">
                    <img id="demo1" src="/${user.userImg }" style="width:250px ;height:250px;" class="layui-upload-img">
                </c:when>
                <c:otherwise>
                    <img id="demo1" src="http://t.cn/RCzsdCq" style="width:250px ;height:250px;" class="layui-upload-img">
                </c:otherwise>
            </c:choose>
        </div>
        <button type="button" class="layui-btn" id="test1">提交</button>
    </div>
</body>
    <script >
        layui.use(['upload','jquery','layer'],function () {
            let upload = layui.upload,
             $ = layui.jquery
            ,layer = layui.layer ;

            //普通图片上传
            upload.render({
                elem: '#demo1'
                ,auto:false
                ,bindAction: '#test1'
                ,url: '/user/userImg.do' //改成您自己的上传接口
                ,field:"userImg" // 上传给后端时，这个图片的参数的名称
                ,choose: function(obj){  // 选择文件之后执行
                    //预读本地文件示例，不支持ie8
                    obj.preview(function(index, file, result){
                        $('#demo1').attr('src', result); //图片链接（base64）
                    });
                }
                ,done: function(data){
                    if (data.code == 200){
                        //上传成功
                        var imgSrc = data.data ;
                        // 获取父页面中，设置图片的标记对象 dom对象
                        layer.msg(data.msg)
                        window.parent.document.getElementById("userImg").src = "/"+imgSrc+"?" + new Date().getTime();
                        return false ;
                    }
                    //如果上传失败
                    layer.msg(data.msg)
                }

            });
        })

    </script>
</html>
