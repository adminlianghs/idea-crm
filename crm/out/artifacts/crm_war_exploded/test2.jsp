<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户状态表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="x-ua-compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=deice-width,initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="UTF-8"></script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test" style="width:80% "></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-even="add">新增</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table','jquery','layer','form','laydaate'],function () {
        let table = layui.table
        ,$ = layui.jquery
        ,layer = layui.layer
        ,laydate = layui.laydate;

        var tab = table.render({
            elem: '#test'
            ,url: '/customer/state.do'
            ,toolbar: '#toolbarDemo'
            ,height: 500
            ,cols:[[
                {type:"checkbox",fixed: "left"}
                ,{field:"customerStateId",title:"序号"}
                ,{field:"customerStateName",title:"状态名称"}
                ,{field:"customerStateDesc",title:"状态描述"}
                ,{field:"updateTime",title:"更新时间"}
                ,{fixed:"right",title:"操作",toolbar: "#barDemo",width: 150}
            ]]
            ,parseData: function (res) {
                console.log(res)
                return{
                    "code": res.code,
                    "msg": res.msg,
                    "count": res.data.total,
                    "data": res.data.data
                };
            }
            ,response: {
                statusCode: 200
            }
            ,page: true
        });

    })
</script>
</body>
</html>
