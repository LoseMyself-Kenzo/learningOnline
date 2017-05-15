<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>注册</title>
</head>
<link rel="shortcut icon" href="jpg/school.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
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
                        注册账号
                        <hr style="width:350px;height:1px;border:none;border-top:1px solid #555555;" />
                    </div>
                    <div class="col-md-6 col-md-offset-3">
                        <form class="" method="POST" action="${base.contextPath}/signUp">
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>邮箱</label>
                                <input class="form-control" style="width: 300px;" id="email" name="email" type="text" placeholder="example@qq.com" autocomplete="new-password">
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
                                <label>密码</label>
                                <input style="display: none;">
                                <input style="width: 300px" type="password" name="password" id="password" class="form-control" placeholder="请输入密码" autocomplete="new-password">
                            </div>
                            <div class="get" style="margin-left: 125px;margin-top: 10px">
                                <label>验证码</label>
                                <input style="width: 125px" type="text" name="yzm" id="yzm" class="form-control">
                                <img id="getYzm" name="yzm" src="${base.contextPath}/getYzm" style="margin-left:150px;margin-top: -55px" onclick="showYzm(this)"/>
                            </div>
                            <script>
                                function showYzm(obj) {
                                    //获取当前的时间作为参数，无具体意义
                                    var timenow = new Date().getTime();
                                    //每次请求需要一个不同的参数，否则可能会返回同样的验证码
                                    //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
                                    obj.src="${base.contextPath}/getYzm?d="+timenow;
                                }
                            </script>
                            <button class="btn btn-primary" type="submit" style="margin-left:125px;width: 300px">注册</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
