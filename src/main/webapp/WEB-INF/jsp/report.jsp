<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>还有很长的路要走</title>
    <link rel="shortcut icon" href="jpg/school.ico">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <link rel="stylesheet" href="css/footer.css"/>
    <link rel="stylesheet" href="css/login/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://static.shiyanlou.com/static/font-awesome//4.7.0/css/font-awesome.min.css">
</head>
<style>
    /* modal 模态框*/
    #invite-user .modal-body {
        overflow: hidden;
    }

    #invite-user .modal-body .form-label {
        margin-bottom: 16px;
        font-size: 14px;
    }

    #invite-user .modal-body .form-invite {
        width: 80%;
        padding: 6px 12px;
        background-color: #eeeeee;
        border: 1px solid #cccccc;
        border-radius: 5px;
        float: left;
        margin-right: 10px;
    }

    #invite-user .modal-body .msg-modal-style {
        background-color: #7dd383;
        margin-top: 10px;
        padding: 6px 0;
        text-align: center;
        width: 100%;
    }

    #invite-user .modal-body .modal-flash {
        position: absolute;
        top: 53px;
        right: 74px;
        z-index: 999;
    }

    /* end modal */

    .en-footer {
        padding: 30px;
        text-align: center;
        font-size: 14px;
    }
</style>
<style>
    a:hover,
    a:focus {
        text-decoration: none;
    }

    span.label {
        display: inline-block;
        margin: 10px 3px 16px 3px;
        padding: 6px 16px;
        border: none;
        font-size: 14px;
        font-weight: 100;
    }

    span.label-default {
        color: #999;
        background: none;
    }

    span.label-success {
        color: #0c9;
        background: #E7F8F2;
    }

    .userinfo-banner [data-toggle="tooltip"] {
        display: inline-block;
        border-bottom: dashed 1px #999;;
        color: #999 !important;
    }

    .certificate-item {
        padding-top: 10px;
    }

    .certificate-item a {
        color: #444;
    }
</style>
<body>
<nav class="navbar navbar-default navbar-fixed-top home-header">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#header-navbar-collapse" aria-expanded="false">
            </button>
            <a class="navbar-brand" href="#">
                <img src="jpg/school.ico" width="80" height="80">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="header-navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown " onmouseover="show1()" onmouseout="hide1()">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        课程 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" id="show1">
                        <li><a class="" href="/courses/">全部课程</a></li>
                        <li><a class="" href="/courses/?status=preview">即将上线</a></li>
                        <li><a class="" href="/developer">开发者</a></li>
                    </ul>
                    <script>
                        function show1() {
                            document.getElementById("show1").style.display = "block";
                        }
                        function hide1() {
                            document.getElementById("show1").style.display = "none";
                        }
                    </script>
                </li>
                <li class=" new-nav logo-1111">
                    <a href="javascript:alert('该功能暂未开放')">讨论区</a>
                </li>
            </ul>
            <c:if test="${empty username}">
                <ul class="nav navbar-nav navbar-right header-sign">
                    <li class="sign"><a href="javascript:void(0);" onclick="popBox()">登录</a></li>
                    <li class="sign"><a href="${base.contextPath}/sign_up">注册</a></li>
                </ul>
            </c:if>
            <c:if test="${!empty username}">
                <ul class="nav navbar-nav navbar-right header-sign">
                    <li onmouseover="show2()" onmouseout="hide2()">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">${username}<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" id="show2">
                            <li><a class="" href="javascript:void(0)" onclick="toUser()">个人主页</a></li>
                            <li><a class="" href="/profile">个人设置</a></li>
                        </ul>
                    </li>
                    <input type="hidden" id="userId" name="user_id" value="${user_id}">
                    <script>
                        var id = $("#userId").val();
                        function toUser() {
                            window.location.href = "${base.contextPath}/user?user_id=" + id;
                        }

                        function show2() {
                            document.getElementById("show2").style.display = "block";
                        }
                        function hide2() {
                            document.getElementById("show2").style.display = "none";
                        }
                    </script>


                    <li class="sign"><a href="${base.contextPath}/logout">退出</a></li>
                </ul>
                <script>
                    function logout() {
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            async: false,
                            url: "${base.contextPath}/logout",
                            success: function (data) {
                                window.location.reload();
                            }
                        })
                    }
                </script>
            </c:if>
            <form class="navbar-form navbar-right" action="/search" method="get" role="search">
                <div class="form-group">
                    <label><i class="fa fa-search"></i></label>
                    <input type="text" class="form-control" name="search" autocomplete="off" placeholder="搜索 课程/问答">
                </div>
            </form>
        </div>
    </div>
</nav>
<%--头像/用户名--%>
<div class="container layout"
     style="background-color: white;border: 0.5px solid lightgray; width: 900px;height: 100px;margin-bottom: 10px;margin-top: 70px">
    <div class="row">
        <div class="col-md-12">
            <div class="pull-left userinfo-banner-details">
                <div class="userinfo-banner-meta" style="margin-top: 10px">
                    <img src="${head}" width="60" height="60">
                    <span style="font-size: 22px;margin-left: 10px">用户名: ${username}</span>
                </div>
                <div class="userinfo-banner-status">
                </div>
            </div>
        </div>
    </div>
</div>
<%--资料显示--%>
<div class="container layout"
     style="background-color: white;border: 0.5px solid lightgray; width: 900px;height: 500px;margin-bottom: 20px">
    <div class="row">
        <div class="col-md-9 layout-body">
            <div class="content" style="margin-top: 10px">
                <ul class="nav nav-tabs" id="top">
                    <li>
                        <a href="${base.contextPath}/User">实验课程</a>
                    </li>
                    <li class="active">
                        <a href="${base.contextPath}/report">实验报告</a>
                    </li>
                    <li>
                        <a href="${base.contextPath}/profile">个人设置</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active">
                        <div class="row">
                            <div class="col-md-12">
                                <a>
                                    <span class="label label-success">已投递过</span>
                                </a>
                                <a href="/user">
                                    <span class="label label-default">已通过</span>
                                </a>
                            </div>
                            <div class="col-md-12 empty-tips">还没有上传的报告哦~</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://static.shiyanlou.com/static/ravenjs/3.7.0/raven.min.js"></script>
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-4 clearfix footer-col">
                <div class="footer-slogan" style="margin-left: -50px">
                    <img src="jpg/Head.jpg" width="100" height="100">「博观而约取，厚积而薄发。君子藏器于身，待时而动」
                </div>
                <div class="col-xs-2">
                    <div class="social-item footer-weixin-item" onmouseover="show()" onmouseout="hide()">
                        <i class="fa fa-weixin"></i>
                        <div class="footer-weixin" id="show">
                            <img src="https://static.shiyanlou.com/img/footer-weixin.png">
                        </div>
                        <script>
                            function show() {
                                document.getElementById("show").style.display = "block";
                            }
                            function hide() {
                                document.getElementById("show").style.display = "none";
                            }
                        </script>
                    </div>
                </div>
                <div class="col-xs-2">
                    <div class="social-item footer-weibo-item">
                        <a href="http://weibo.com" target="_blank">
                            <i class="fa fa-weibo"></i>
                        </a>
                    </div>
                </div>
                <div class="col-xs-2">
                    <div class="social-item footer-github-item">
                        <a href="https://github.com/LoseMyself-Kenzo" target="_blank">
                            <i class="fa fa-github"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3 col-md-2 footer-col">
                <div class="col-title">公司</div>
                <a href="/" target="_blank">关于我们</a><br>
                <a href="/" target="_blank">联系我们</a><br>
            </div>
            <div class="col-xs-6 col-sm-3 col-md-2 footer-col">
                <div class="col-title">合作</div>
                <a href="/" target="_blank">我要投稿</a><br>
                <a href="/" target="_blank">教师合作</a><br>
                <a href="/" target="_blank">高校合作</a><br>
                <a href="/" target="_blank">友情链接</a>
            </div>
            <div class="col-xs-6 col-sm-3 col-md-2 footer-col">
                <div class="col-title">服务</div>
                <a href="/" target="_blank">常见问题</a><br>
                <a href="/" target="_blank">隐私条款</a>
            </div>
            <div class="col-xs-6 col-sm-3 col-md-2 footer-col">
                <div class="col-title">学习路径</div>
                <a href="/" target="_blank">Python学习路径</a><br>
                <a href="/" target="_blank">Java学习路径</a><br>
                <a href="/" , target="_blank">全部</a>
            </div>
        </div>
    </div>
    <div class="text-center copyright">
        <font size="1px">
            <span>Copyright @2017-2020 LoseMyself在线学习</span>
            <span>|</span>
            <a href="" target="_blank">X ICP备xxxxxxxx号</a>
        </font>
    </div>
</div>
</body>
</html>