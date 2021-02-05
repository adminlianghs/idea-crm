<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>客户来源</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<%-- 创建新增模板 不是一直显示在页面中的，是通过弹出层来进行显示的  定义一个页面 --%>
<script type="text/html" id="addForm">
    <%--  客户添加信息模板样式 from   --%>
    <div style="padding: 10px 20px ; ">
        <form class="layui-form " lay-filter="addFormFilter">
            <input type="hidden" name="customerSourceId">
            <div class="layui-form-item">
                <label class="layui-form-label">客户来源</label>
                <div class="layui-input-block">
                    <input type="text" name="customerSourceName" lay-verify="title" autocomplete="off"
                           placeholder="客户来源" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">来源说明</label>
                <div class="layui-input-block">
                    <textarea placeholder="来源说明" class="layui-textarea" name="customerSourceDesc"></textarea>
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

<%-- 搜索模块 --%>
<form class="layui-form">
    <div class="layui-form-item" style="padding: 15px 10px ;">
        <div class="layui-inline">
            <label class="layui-form-label">客户来源ID</label>
            <div class="layui-input-inline">
                <input type="text" id="customerSourceId" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户来源</label>
            <div class="layui-input-inline">
                <input type="text" id="customerSourceName" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">来源描述</label>
            <div class="layui-input-inline">
                <input type="text" id="customerSourceDesc" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="search">搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <%--        <div class="layui-inline">--%>
        <%--            <label class="layui-form-label">评语</label>--%>
        <%--            <div class="layui-input-inline">--%>
        <%--                <input type="text" name="remark"  placeholder="请输入" autocomplete="off" class="layui-input">--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>

    <%--    <div class="layui-form-item">--%>
    <%--        <div class="layui-inline">--%>
    <%--            <label class="layui-form-label">添加时间</label>--%>
    <%--            <div class="layui-input-inline">--%>
    <%--                <input type="text" name="createTime"  placeholder="请输入" autocomplete="off" class="layui-input">--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div class="layui-inline">--%>
    <%--            <label class="layui-form-label">添加人</label>--%>
    <%--            <div class="layui-input-block">--%>
    <%--                <input type="text" name="creater" id="date1" autocomplete="off" class="layui-input">--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <%--        <div class="layui-inline">--%>
    <%--            <label class="layui-form-label">修改人</label>--%>
    <%--            <div class="layui-input-inline">--%>
    <%--                <input type="text" name="updater"  placeholder="请输入" autocomplete="off" class="layui-input">--%>
    <%--            </div>--%>
    <%--        </div>--%>

    </div>

</form>

<table class="layui-hide" id="test" lay-filter="test" style="width: 80%"></table>

<%--表单左上角工具栏--%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增来源</button>
    </div>
</script>

<%--操作（编辑、修改）--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['table', 'jquery', 'layer', 'form'], function () {
        var table = layui.table
            , $ = layui.jquery
            , layer = layui.layer
            , form = layui.form

        var tab = table.render({
            elem: '#test'
            , url: '/customer/source.do'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            // ,defaultToolbar: ['filter', 'exports', 'print']
            , height: 500
            , cols: [[
                {type: "checkbox", fixed: "left"}
                , {field: "customerSourceId", title: "客户来源ID", sort: true}
                , {field: "customerSourceName", title: "客户来源"}
                , {field: "customerSourceDesc", title: "来源描述"}
                , {field: "updateTime", title: "更新时间"}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
            , parseData: function (res) { //res 即为原始返回的数据 resultData
                console.log(res);
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度 总记录数
                    "data": res.data.data //解析数据列表
                };
            }
            , response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            , page: true
        });
        // $(".layui-table-box").css("height", $(".layui-table-box").css("height"));

        //头工具栏事件
        // table.on('toolbar(test)', function(obj){
        //     var checkStatus = table.checkStatus(obj.config.id);
        //     switch(obj.event){
        //         case 'getCheckData':
        //             var data = checkStatus.data;
        //             layer.alert(JSON.stringify(data));
        //             break;
        //         case 'getCheckLength':
        //             var data = checkStatus.data;
        //             layer.msg('选中了：'+ data.length + ' 个');
        //             break;
        //         case 'isAll':
        //             layer.msg(checkStatus.isAll ? '全选': '未全选');
        //             break;
        //         //自定义头工具栏右侧图标 - 提示
        //         case 'LAYTABLE_TIPS':
        //             layer.alert('这是工具栏右侧自定义的一个图标按钮');
        //             break;
        //     };
        // });
        //监听行工具事件 ,删除数据

        // 搜索的点击事件
        $("#search").click(function () {
            // 重新加载表格
            let $customerSourceId = $("#customerSourceId").val();
            let $customerSourceName = $("#customerSourceName").val();
            let $customerSourceDesc = $("#customerSourceDesc").val();
            tab.reload({
                where: {
                    "customerSourceId": $customerSourceId,
                    "customerSourceName": $customerSourceName,
                    "customerSourceDesc": $customerSourceDesc
                }
            })

            return false;
        })
        // 操作的点击（编辑，删除）
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    // obj.del();
                    del(data);
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                edit(data);
            }
        });
        // 左侧工具栏  新增的点击事件
        table.on('toolbar(test)', function (obj) {
            switch (obj.event) {
                case 'add':
                    add();
            }
        })

        // 新增的具体方法
        function add() {
            layer.open({
                type: 1 // 弹出页面层
                , title: '新增'
                , content: $("#addForm").html()
                , area: ['600px', '500px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    // 按钮 确定 的回调
                    $("#submitBtn").click();
                }
                , btnAlign: 'c'
                // 解决下拉框无法出现的问题 layui默认情况下表单没有进行渲染，下拉框不会显示
                , success: function (layero, index) {
                    // 将表单进行重新渲染
                    form.render();
                    //
                    form.on('submit(submitBtnFilter)', function (data) {

                        $.ajax({
                            url: "/customer/sourceAdd.do"
                            , data: data.field
                            , type: "post"
                            , dataType: "json"
                            , success: function (data) {
                                console.log(data);
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

        // 编辑的具体方法
        function edit(data) {
            layer.open({
                type: 1
                ,title: "编辑"
                ,content: $("#addForm").html()
                ,area:['600px','500px']
                ,btn: ['确定','取消']
                ,yes: function (index,layero) {
                    $('#submitBtn').click();
                }
                ,btnAlign: 'c'
                ,success: function (layero,index) {
                    form.render();
                    form.val("addFormFilter",{
                        "customerSourceName":data.customerSourceName
                        ,"customerSourceDesc":data.customerSourceDesc
                        ,"remark": data.remark
                        ,"customerSourceId":data.customerSourceId
                    })
                    form.on('submit(submitBtnFilter)',function (data) {
                        $.ajax({
                            url:"/customer/sourceEdit.do"
                            ,data: data.field
                            ,type: "post"
                            ,dataType: "json"
                            ,success: function (data) {
                                if(data.code == 200){
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
                url:"/customer/sourceDel.do"
                ,data: {"customerSourceId" : data.customerSourceId}
                ,type: "post"
                ,dataType: "json"
                ,success:function (data) {
                    if(data.code == 200){
                        layer.msg(data.msg);
                        setTimeout(function () {
                            $("#search").click();
                        },1000)
                        layer.msg(data.msg);
                    }
                }
            });
        }
    });
</script>
</body>
</html>