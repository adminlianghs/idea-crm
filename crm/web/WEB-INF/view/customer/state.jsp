<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户状态表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="x-ua-compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=deice-width,initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<%--新增板块--%>
<script type="text/html" id="addForm">
    <div style="padding: 10px 20px ;">
        <form class="layui-form" lay-filter="addFormFilter">
            <input type="hidden" name="customerStateId">
            <div class="layui-form-item">
                <label class="layui-form-label">状态名称</label>
                <div class="layui-input-block">
                    <input type="text" name="customerStateName" lay-verify="title" autocomplete="off"
                           placeholder="请输入状态名称" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">状态描述</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入状态描述" class="layui-textarea" name="customerStateDesc"></textarea>
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入备注" class="layui-textarea" name="remark"></textarea>
                </div>
            </div>
            <input type="hidden" lay-submit id="submitBtn" lay-filter="submitBtnFilter"/>
        </form>
    </div>
</script>
<%--搜索--%>
<form class="layui-form">
    <div class="layui-form-item" style="padding: 15px 10px ;">
        <div class="layui-inline">
            <label class="layui-form-label">状态ID</label>
            <div class="layui-input-inline">
                <input type="number" id="customerStateId" placeholder="请输入序号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">状态名称</label>
            <div class="layui-input-inline">
                <input type="text" id="customerStateName" placeholder="请输入状态名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">状态描述</label>
            <div class="layui-input-inline">
                <input type="text" id="customerStateDesc" placeholder="请输入状态名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-filter="demo1" id="search">搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>
<table class="layui-hide" id="test" lay-filter="test" style="width:80% "></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增状态</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="/layui/layui.js" charset="UTF-8"></script>
<script>
    layui.use(['table', 'jquery', 'layer', 'form'], function () {
        let table = layui.table
            , $ = layui.jquery
            , layer = layui.layer
            , form = layui.form

        var tab = table.render({
            elem: '#test'
            , url: '/customer/state.do'
            , toolbar: '#toolbarDemo'
            , height: 500
            , cols: [[
                {type: "checkbox", fixed: "left"}
                , {field: "customerStateId", title: "序号"}
                , {field: "customerStateName", title: "状态名称"}
                , {field: "customerStateDesc", title: "状态描述"}
                , {field: "updateTime", title: "更新时间"}
                , {fixed: "right", title: "操作", toolbar: "#barDemo", width: 150}
            ]]
            , parseData: function (res) {
                console.log(res)
                return {
                    "code": res.code,
                    "msg": res.msg,
                    "count": res.data.total,
                    "data": res.data.data
                };
            }
            , response: {
                statusCode: 200
            }
            , page: true
        });

        // 搜索点击事件
        $("#search").click(function () {
            // 重新加载表格
            let $customerStateId = $("#customerStateId").val();
            let $customerStateName = $("#customerStateName").val();
            let $customerStateDesc = $("#customerStateDesc").val();

            // alert($customerStateId);
            tab.reload({
                where: {
                    "customerStateId": $customerStateId,
                    "customerStateName": $customerStateName,
                    "customerStateDesc": $customerStateDesc
                }
            })
            return false;
        })

        // 监听头工具栏事件，添加数据
        table.on('toolbar(test)', function (obj) {
            console.log(obj.data);
            switch (obj.event) {
                case 'add':
                    add();
            }
        })
        // 编辑，删除的点击事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    del(data);
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                edit(data);
            }
        });

        // 添加的具体方法
        function add() {
            layer.open({
                type: 1
                , title: "新增"
                , content: $("#addForm").html()
                , area: ['600px', '500px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    // alert("lll");
                    $("#submitBtn").click();
                }
                , btnAlign: 'c'
                , success: function (layero, index) {
                    form.render();
                    form.on('submit(submitBtnFilter)', function (data) {
                        $.ajax({
                            url: "/customer/stateAdd.do"
                            , data: data.field
                            , type: "post"
                            , dataType: "json"
                            , success: function (data) {
                                if (data.code == 200) {
                                    console.log(data);
                                    layer.msg(data.msg);
                                    $("#search").click();
                                    layer.close(index);
                                    return false;
                                }
                                layer.msg(data.msg);
                            }
                        });
                    })
                }
            })
        }

        // 编辑的具体方法
        function edit(data) {
            layer.open({
                type: 1
                , title: "编辑"
                , content: $("#addForm").html()
                , area: ['600px', '500px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $("#submitBtn").click();
                }
                , btnAlign: 'c'
                , success: function (layero, index) {
                    form.render();
                    form.val("addFormFilter", {
                        "customerStateName": data.customerStateName
                        , "customerStateDesc": data.customerStateDesc
                        , "remark": data.remark
                        , "customerStateId": data.customerStateId
                    })
                    form.on('submit(submitBtnFilter)', function (data) {
                        $.ajax({
                            url: "/customer/stateEdit.do"
                            , data: data.field
                            , type: "post"
                            , dataType: "json"
                            , success: function (data) {
                                if (data.code == 200) {
                                    layer.msg(data.msg);
                                    $("#search").click();
                                    layer.close(index);
                                    return false;
                                }
                                layer.msg(data.msg);
                            }
                        });
                        return false;
                    })
                }
            })
        }

        // 删除的具体方法
        function del(data) {
            $.ajax({
                url: "/customer/stateDel.do"
                , data: {"customerStateId": data.customerStateId}
                , type: "post"
                , dataType: "json"
                , success: function (data) {
                    if (data.code == 200) {
                        layer.msg(data.msg);
                        setTimeout(function () {
                            $("#search").click();
                        }, 1000)
                        layer.msg(data.msg);
                    }
                }
            })
        }
    })
    ;
</script>
</body>
</html>
