<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>客户信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<%-- 创建新增模板 不是一直显示在页面中的，是通过弹出层来进行显示的  定义一个页面 --%>
<script type="text/html" id="addForm" >
<%--  客户添加信息模板样式 from   --%>
    <div style="padding: 10px 20px ; ">
        <form class="layui-form " lay-filter="addFormFilter">
                <input type="hidden" name="customerId" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="customerName" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户住址</label>
                    <div class="layui-input-inline">
                        <input type="text" name="address" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户公司</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="company" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户职位</label>
                    <div class="layui-input-inline">
                        <input type="text" name="position" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户生日</label>
                    <div class="layui-input-inline">
                        <input type="text" name="birth" id="birth" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户分类</label>
                    <div class="layui-input-inline">
                        <select name="customerCategoryId" lay-verify="required" lay-search="">
                            <option value="">选择</option>
                            <option value="1">客户</option>
                            <option value="2">合作伙伴</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户状态</label>
                    <div class="layui-input-inline">
                        <select name="customerStateId" lay-verify="required" lay-search="">
                            <option value="">选择</option>
                            <option value="1">潜在客户</option>
                            <option value="2">意见客户</option>
                            <option value="3">交易客户</option>
                            <option value="4">成交客户</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户来源</label>
                    <div class="layui-input-inline">
                        <select name="customerSourceId" lay-verify="required" lay-search="">
                            <option value="">选择</option>
                            <option value="1">平顶山校区</option>
                            <option value="3">南阳校区</option>
                            <option value="4">信阳校区</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">负责人</label>
                    <div class="layui-input-inline">
                        <select name="userId" lay-verify="required" lay-search="">
                            <option value="">选择</option>
                            <option value="1">admin</option>
                            <option value="2">张三</option>
                            <option value="3">李四</option>
                            <option value="4">请问</option>
                        </select>
                    </div>
                </div>
                <input type="hidden" lay-submit id="submitBtn" lay-filter="submitBtnFilter" />
            </div>
        </form>
    </div>
</script>

<%-- 客户搜索模板 --%>
<form class="layui-form">
    <div class="layui-form-item" style="padding: 15px 10px ;">
        <div class="layui-inline">
            <label class="layui-form-label">客户名称</label>
            <div class="layui-input-inline">
                <input type="text" id="customerName"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户电话</label>
            <div class="layui-input-inline">
                <input type="text" id="mobile"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户地址</label>
            <div class="layui-input-inline">
                <input type="text" id="address"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户公司</label>
            <div class="layui-input-inline">
                <input type="text" id="company"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">客户职位</label>
            <div class="layui-input-inline">
                <input type="text" id="position"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">日期选择</label>
            <div class="layui-input-block">
                <input type="text" id="date1" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-inline">
                <input type="text" id="username"  placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-filter="demo1"  id="search">搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>

<table class="layui-hide" id="test" lay-filter="test" style="width: 80%"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增客户</button>

    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['table','jquery','layer','form','laydate'], function(){
        var table = layui.table
        ,$ = layui.jquery
        ,layer = layui.layer
        ,form = layui.form
        ,laydate = layui.laydate;

        //  渲染了 查询的时间选择器
        laydate.render({
            elem:"#date1"
        })

        var tab = table.render({
            elem: '#test'
            ,url:'/customer/listPage.do'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print']
            ,height:500
            ,cols: [[
                {type:"checkbox", fixed:"left"}
                ,{field:"customerId",title:"ID" ,sort:true }
                ,{field:"customerName" ,title:"客户名" ,sort:true }
                ,{field:"customerIsMale",title:"性别" ,sort:true ,templet:function (data) {
                            if (data.customerIsMale == 0)
                                return "女"
                            if (data.customerIsMale == 1)
                                return "男"
                    }}
                ,{field:"customerAddress",title:"地址" }
                ,{field:"customerMobile",title:"手机号" }
                ,{field:"customerPosition",title:"职位"  }
                ,{field:"birth",title:"生日" ,sort:true }
                ,{field:"customerCompany",title:"公司"  }
                ,{field:"customerStateName",title:"状态" ,sort:true }
                ,{field:"customerSourceName",title:"来源" ,sort:true }
                ,{field:"customerCategoryName",title:"类型" ,sort:true }
                ,{field:"username",title:"负责人" ,sort:true }
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,parseData: function(res){ //res 即为原始返回的数据 resultData
                console.log(res);
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度 总记录数
                    "data": res.data.data //解析数据列表
                };
            }
            ,response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            ,page: true // 会传递给后端两个值 ：parameter:{ page:当前页数   limit:当前页中的每页显示数量 }
        });

        // 搜索的点击事件
        $("#search").click(function () {
        //    重新加载表格
            let $customerName = $("#customerName").val();
            let $mobile = $("#mobile").val();
            let $address = $("#address").val();
            let $company = $("#company").val();
            let $position = $("#position").val();
            let $birth = $("#date1").val();
            let $username = $("#username").val();


            console.log("username");
            tab.reload({
                where:{
                   "customerName" :$customerName,
                    "mobile":$mobile ,
                    "address":$address,
                    "company":$company,
                    "position":$position,
                    "birth":$birth ,
                    "username":$username
                }
            })
            return false ; // 防止表单提交
        })


        //监听行工具事件，删除
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    del(data);
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                edit(data);
            }
        });

        // 监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            // 获取选中的 内容 id值
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
            //        弹出一个新增数据的框框  使用模块 layer
                    add(); // 创建一个页面框
            };
        });

        // 用户删除的具体方法
        function del(data) {
            $.ajax({
                url:"/customer/del.do"
                ,data:{"customerId":data.customerId}
                ,type:"post"
                ,dataType:"json"
                ,success:function (data) {
                    //    接收一个 resultData json数据
                    // console.log(data);
                    if (data.code == 200 ) {
                        layer.msg(data.msg);
                        setTimeout(function () { //定时器  timeout执行一次 setInterval 一直执行 直到设置了停止
                            $("#search").click(); //    让搜索按钮进行点击，刷新table
                        }, 1000)
                        //  弹出失败原因
                        layer.msg(data.msg);
                    }
                }
            })
        }
        // 用户编辑的具体方法
        function edit(data) {
            layer.open({
                type: 1  // 弹出页面层
                , title: "编辑"
                , content: $("#addForm").html()
                , area: ['800px', '600px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    //按钮【确定】的回调 ———— 提交数据去后端 submit 提交事件
                    $("#submitBtn").click();
                }
                , btnAlign: 'c'
                ,success:function(layero, index) {  // 跳出页面执行的方法
                    form.render(); // 渲染表单
                    // console.log(data)
                    // 设置表单初始值
                    form.val("addFormFilter", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                        "customerName": data.customerName // "name": "value"
                        ,"address": data.customerAddress
                        ,"birth": data.birth
                        ,"company": data.customerCompany
                        ,"customerCategoryId":data.customerCategoryId
                        ,"customerSourceId": data.customerSourceId
                        ,"customerStateId": data.customerStateId
                        ,"phone": data.customerMobile
                        ,"position": data.customerPosition
                        ,"userId": data.userId
                        ,"customerId":data.customerId
                    })
                //     监听点击事件
                    form.on('submit(submitBtnFilter)', function (data) {
                        // 使用ajax 进行数据的传递
                        $.ajax({
                            url:"/customer/edit.do"
                            ,data:data.field
                            ,type:"post"
                            ,dataType:"json"
                            ,success:function (data) {
                                //    接收一个 resultData json数据
                                console.log(data);
                                if (data.code == 200 ){
                                    layer.msg(data.msg);
                                    //    让搜索按钮进行点击，刷新table
                                    $("#search").click();
                                    //    关闭弹出层
                                    layer.close(index);
                                    //    阻止表单提交
                                    return false ;
                                }
                                //  弹出失败原因
                                layer.msg(data.msg);
                            }
                        });
                        return false ; // 防止表单提交
                    })
                }
            });
        }

        // 用户新增的具体方法
        function add(){
            layer.open({
                type:1  // 弹出页面层
                ,title:"新增"
                ,content:$("#addForm").html()
                ,area: ['800px', '600px']
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){
                    //按钮【确定】的回调 ———— 提交数据去后端 submit 提交事件
                    $("#submitBtn").click();
                }
                ,btnAlign: 'c'
            //    解决下拉框无法出现内容的问题 layui默认情况下表单没有进行渲染，下拉框不会显示
                ,success:function(layero, index){  // 页面弹出成功触发 index 当前是第几层弹出框
                    //  将表单进行重新渲染
                    form.render();
                    // 打开弹出框，就进行监听提交事件
                    form.on('submit(submitBtnFilter)', function (data) {
                        // 使用ajax 进行数据的传递
                        $.ajax({
                            url:"/customer/add.do"
                            ,data:data.field
                            ,type:"post"
                            ,dataType:"json"
                            ,success:function (data) {
                                //    接收一个 resultData json数据
                                console.log(data);
                                if (data.code == 200 ){
                                    layer.msg(data.msg);
                                    //    让搜索按钮进行点击，刷新table
                                    $("#search").click();
                                    //    关闭弹出层
                                    layer.close(index);
                                //    阻止表单提交
                                    return false ;
                                }
                                //  弹出失败原因
                                layer.msg(data.msg);
                            }
                        });
                        return false ; // 防止表单提交
                    })
                }
            })
        }

    });
</script>

</body>
</html>
