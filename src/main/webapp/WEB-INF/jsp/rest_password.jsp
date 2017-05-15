<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更改密码</title>
</head>
<link rel="shortcut icon" href="jpg/school.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<body>
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
                        <form class="" method="POST" action="${base.contextPath}/changePassword">
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>新密码</label>
                                <input class="form-control" style="width: 300px;" id="rp" name="rp" type="password" placeholder="请输入新密码" onblur="isNull(this)">
                                <span class="help-inline"></span>
                            </div>
                            <script>
                                function  isNull(obj) {
                                    if(obj.value == null || obj.value == ""){
                                        alert("新密码不可为空");
                                    }else if(!(obj.value.length >= 8 && obj.value.length <= 14)){
                                        alert("密码长度为8到14位");
                                        obj.value = null;
                                    }
                                }
                            </script>
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>确认密码</label>
                                <input class="form-control" style="width: 300px;" id="password" name="password" type="password" placeholder="请输入确认密码">
                                <span class="help-inline"></span>
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
                            <button class="btn btn-primary" type="submit" style="margin-left:125px;width: 300px">确定</button>
                            <c:if test="${!empty msg}">
                                <input type="hidden" id="msg" name="msg" value="${msg}"/>
                                <script>
                                    var msg = $("#msg").val();
                                    alert(msg);
                                </script>
                            </c:if>
                            <c:if test="${!empty email}">
                                <input type="hidden" id="email" name="email" value="${email}"/>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
