<%@ page import="cn.hp.crm.util.SessionKey" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
  <meta charset="utf-8">
  <title>客户关系管理系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- CSS -->
  <link rel="stylesheet" href="css/supersized.css">
  <link rel="stylesheet" href="css/login.css">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <script src="js/html5.js"></script>
  <script src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="js/jquery.form.js"></script>
  <script type="text/javascript" src="js/tooltips.js"></script>
  <script type="text/javascript" src="js/login.js"></script>
</head>

<body>

<div class="page-container">
  <div class="main_box">
    <div class="login_box">
      <div class="login_logo">
        <img src="images/logo.png" >
      </div>

      <div class="login_form">
        <form action="index.html" id="login_form" method="post">
          <div class="form-group">
            <label for="j_username" class="t">账　号：</label>
            <input id="j_username"  name="username" type="text" value="admin" class="form-control x319 in"
                   autocomplete="off">
          </div>
          <div class="form-group">
            <label for="j_password" class="t">密　码：</label>
            <input id="j_password"  name="password" type="password" value="123456"
                   class="password form-control x319 in">
          </div>
          <div class="form-group">
            <label for="j_captcha" class="t">验证码：</label>
            <input id="j_captcha" name="code" value="" type="text" class="form-control x164 in">
            <img id="captcha_img" alt="点击更换" title="点击更换"  src="user/getCode" onclick="changeCode()" class="m">
          </div>

          <div class="form-group space">
            <label class="t"></label>　　　
            <button type="button"  id="submit_btn"
                    class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
            <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
          </div>
        </form>
      </div>
    </div>

  </div>
</div>

<!-- Javascript -->

<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<script src="js/scripts.js"></script>

<script>
  function changeCode(){
//	1.验证用户账号、密码的格式
    let $jUsername = $("#j_username").val();
    let $jPassword = $("#j_password").val();
//	判断非空
    if ($jUsername != "" && $jPassword != ""){
      //   请求路径中  /  表示是 当前项目  http://localhost:8080/crm/user/getCode
      //      http://localhost:8080/
      $("#captcha_img").attr("src","user/getCode?date="+ new Date().getTime());
      //  设置为session中的code值
      // $("#captcha_img").val()
    }else{
      alert("请先输入账号、密码！")
    }
  }

</script>
</body>
</html>