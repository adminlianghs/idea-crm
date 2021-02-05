<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>客户关系管理系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">客户关系管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">来碗汤</a></li>
            <li class="layui-nav-item"><a href="">报表</a></li>
            <li class="layui-nav-item"><a href="/customer/listView.do" target="content">客户信息</a></li>
            <li class="layui-nav-item"><a href="">员工信息</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">公告管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
<%--             如果这个用户没有设置头像 则用网图 ，设置了则使用自己的头像        --%>
                <c:choose>
                    <c:when test="${user.userImg != null }">
                        <img id="userImg" src="/${user.userImg }" class="layui-nav-img">
                    </c:when>
                    <c:otherwise>
                        <img id="userImg" src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    </c:otherwise>
                </c:choose>
                    ${sessionScope.user.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="/user/userImgView.do" target="content">修改头像</a></dd>
                    <dd><a href="/user/changePasswordView.do" target="content">安全设置</a></dd>
                </dl>
            </li>
<%--           跳转到servlet中，将保存的session中登录用户进行清空  --%>
            <li class="layui-nav-item"><a href="/user/loginOut.do">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">客户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/customer/listView.do" target="content">客户信息</a></dd>
                        <dd><a href="javascript:;" >客户分配</a></dd>
                        <dd><a href="javascript:;">客户关怀</a></dd>
                        <dd><a href="/customer/categoryView.do" target="content">客户分类</a></dd>
                        <dd><a href="/customer/stateView.do" target="content">客户状态</a></dd>
                        <dd><a href="/customer/sourceView.do" target="content">客户来源</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">内部信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">通知公告</a></dd>
                        <dd><a href="javascript:;">员工信息</a></dd>
                        <dd><a href="">部门信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">站内邮件</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">写邮件</a></dd>
                        <dd><a href="javascript:;">收件箱</a></dd>
                        <dd><a href="javascript:;">发件箱</a></dd>
                        <dd><a href="javascript:;">草稿箱</a></dd>
                        <dd><a href="javascript:;">垃圾箱</a></dd>
                        <dd><a href="">部门信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">管理员</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">公告管理</a></dd>
                        <dd><a href="javascript:;">部门管理</a></dd>
                        <dd><a href="javascript:;">用户管理</a></dd>
                        <dd><a href="javascript:;">角色管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->

        <iframe name="content" style="width: 100%;height: 100%;border: 0px" scrolling="no" src="https://8zt.cc/"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © hopu.cn - 版权所有 2021
    </div>
</div>
<script src="/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>