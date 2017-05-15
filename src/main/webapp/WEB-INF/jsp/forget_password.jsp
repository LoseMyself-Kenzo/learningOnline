<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<link rel="shortcut icon" href="jpg/school.ico">
<%--<link rel="stylesheet" href="https://static.shiyanlou.com/static/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script>
    var countdown=60;
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value="获取验证码";
            countdown = 60;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value="重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {
                settime(obj) }
            ,1000)
    }
    function showMsg() {
        var email = $("#email").val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            async: false,
            url: "${base.contextPath}/getIC?email="+ email,
            success: function (data) {
                console.log(data)
            }
        });
        alert("验证码已发送到对应邮箱,请输入收到的验证码.");
    }
</script>
<body>
<c:if test="${!empty msg}">
    <input type="hidden" id="msg" value="${msg}"/>
    <input type="hidden" id="em" value="${email}"/>
    <script>
        var msg = $("#msg").val();
        var em = $("#em").val();
    </script>
</c:if>
<div class="container layout-margin-top layout-noside">
    <div class="row">
        <div class="col-md-12 layout-body">
            <div class="content">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3" style="font-size: 20px;margin-top: 6%;" align="center">
                        重置密码
                        <hr style="width:350px;height:1px;border:none;border-top:1px solid #555555;" />
                    </div>
                    <div class="col-md-6 col-md-offset-3">
                        <div class="change-email" style="margin-left: 125px;font-size: 16px">
                            通过邮箱重置密码
                        </div>
                        <form class="" method="GET" action="${base.contextPath}/reset_password">
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>你的邮箱</label>
                                <input class="form-control" style="width: 300px;" id="email" name="email" type="text" placeholder="example@qq.com">
                                <script>
                                    if(em != null){
                                        $("#email").val(em);
                                    }
                                    if(msg != null){
                                        alert(msg);
                                    }
                                </script>
                                <span class="help-inline"></span>
                            </div>
                            <div class="get" style="margin-left: 125px;margin-top: 10px">
                                <label>验证码</label>
                                <input style="width: 150px" name="ic" id="ic" class="form-control" placeholder="请输入验证码">
                                <input type="button" class="btn btn-primary" style="width: 100px;margin-left: 200px;margin-top: -55px" value="获取验证码" onclick="settime(this);showMsg()"/>
                            </div>
                            <button class="btn btn-primary" type="submit" style="margin-left:125px;width: 300px">确定</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
