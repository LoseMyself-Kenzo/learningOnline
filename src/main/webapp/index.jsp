<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>还有很长的路要走</title>
    <link rel="shortcut icon" href="jpg/school.ico">
    <link rel="stylesheet" href="https://static.shiyanlou.com/static/font-awesome//4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://static.shiyanlou.com/static/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://static.shiyanlou.com/static/bootstrap-switch/3.3.2/css/bootstrap-switch.min.css">
    <link rel="stylesheet" href="https://static.shiyanlou.com/static/bootstrap-tour/0.11.0/css/bootstrap-tour.min.css">
    <link rel="stylesheet" href="https://static.shiyanlou.com/static/bootstrap-table/1.11.0/bootstrap-table.min.css">


    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <link rel="stylesheet" href="css/footer.css"/>
    <link rel="stylesheet" href="css/login/style.css"/>
</head>
<body>
<%-- login界面 --%>
<!-- 遮蔽效果层-->
<div id="popLayer"></div>
<!-- 弹窗效果层-->
<div id="popBox" class="login">
    <div><span></span>
        <a href="javascript:void(0)" onclick="closeBox()" style="margin-left: 98%;font-size: 22px">X</a>
    </div>
    <div class="login-top">
        <h1>登录</h1>
        <input type="text" placeholder="邮箱" id="email">
        <input type="password" placeholder="登录密码" id="password">
        <div class="forgot">
            <a href="/forget">忘记密码</a>
            <input type="submit" value="登录" onclick="login()">
        </div>
        <script>
            function login() {
                var email = $("#email").val();
                var password = $("#password").val();
                if (email == null || email == "") {
                    alert("登录邮箱不可为空!");
                    $("#password").val(null);
                    return false;
                } else if (password == null || password == "") {
                    alert("登录密码不可为空");
                    return false;
                } else {
                    $.ajax({
                        type: "GET",
                        contentType: "application/json",
                        async: false,
                        url: "${base.contextPath}/login_in?email=" + email + "&password=" + password,
                        success: function (data) {
                            if (data.list != null) {
                                window.location.reload();
                            } else {
                                alert(data.message);
                                $("#password").val(null);
                            }
                        }
                    })
                }
            }
        </script>
    </div>
    <div class="login-bottom">
        <h3>新用户 &nbsp;<a href="#">注册</a>&nbsp; 在这</h3>
    </div>
</div>

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
                        console.log(id);
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

<div class="layout layout-margin-top layout-fullscreen">
    <div class="container">
    </div>
    <div class="carousel slide" id="carousel-generic" data-ride="carousel">
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="jpg/indexback.jpg">
                <div class="carousel-caption carousel-intro">
                    <font size="20">
                        <div>「以大多数人的努力程度之低，</div>
                        <p>根本轮不到拼天赋」</p>
                    </font>
                    <a class="home-courses-btn" href="/courses/">开始学习</a>
                </div>
            </div>
        </div>
    </div>

    <div class="home-section learn-path" style="background:url('jpg/top.jpg')no-repeat">
        <div class="container">
            <div class="home-section-header">
                <div class="home-section-title">学习路径</div>
                <div class="home-section-desc">12条完整的职业学习路线图，带你从入门到进阶</div>
            </div>
            <div class="row learn-path-body">
                <div class="col-sm-3">
                    <a class="learn-path-item" href="#">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741005890.png">
                        <div class="learn-path-name">新手入门</div>
                        <div class="learn-path-courses">
                            6门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/python">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741028787.png">

                        <div class="learn-path-name">Python研发工程师</div>
                        <div class="learn-path-courses">
                            78门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/cpp">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741048998.png">

                        <div class="learn-path-name">C++ 研发工程师</div>
                        <div class="learn-path-courses">
                            28门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/bigdata">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741070013.png">

                        <div class="learn-path-name">大数据工程师</div>
                        <div class="learn-path-courses">
                            33门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/linuxsys">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741143862.png">
                        <div class="learn-path-name">Linux运维工程师</div>
                        <div class="learn-path-courses">
                            33门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/java">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741175055.png">
                        <div class="learn-path-name">Java研发工程师</div>
                        <div class="learn-path-courses">
                            24门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/php">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741188918.png">

                        <div class="learn-path-name">PHP研发工程师</div>
                        <div class="learn-path-courses">
                            27门课程
                        </div>
                    </a>
                </div>
                <div class="col-sm-3">
                    <a class="learn-path-item" href="/paths/web">
                        <img src="https://dn-simplecloud.shiyanlou.com/1487741210305.png">
                        <div class="learn-path-name">Web前端工程师</div>
                        <div class="learn-path-courses">
                            30门课程
                        </div>
                    </a>
                </div>
            </div>
            <div class="home-section-footer">
                <a href="/paths/">查看全部</a>
            </div>
        </div>
    </div>
    <div class="home-features">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <a><img src="https://static.shiyanlou.com/img/introduceContainer1.gif"></a>

                    <div class="home-features-text">丰富全面的计算机实验课程</div>
                </div>
                <div class="col-sm-3">
                    <a><img src="https://static.shiyanlou.com/img/introduceContainer2.gif"></a>

                    <div class="home-features-text">在线编程环境，1秒启动</div>
                </div>
                <div class="col-sm-3">
                    <a><img src="https://static.shiyanlou.com/img/introduceContainer3.gif"/></a>

                    <div class="home-features-text">每天一个项目课，丰富你的项目经验</div>
                </div>
                <div class="col-sm-3">
                    <a><img src="https://static.shiyanlou.com/img/introduceContainer4.gif"/></a>

                    <div class="home-features-text">有效学习时间，真实记录你的代码生涯</div>
                </div>
            </div>
            <div class="home-section-footer home-features-footer">
                <a class="home-courses-btn" href="/courses/">开始学习</a>
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