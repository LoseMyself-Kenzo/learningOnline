<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新建课程</title>
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
                        新建课程
                        <hr style="width:350px;height:1px;border:none;border-top:1px solid #555555;" />
                    </div>
                    <div class="col-md-6 col-md-offset-3">
                        <form method="GET" action="${base.contextPath}/addClass">
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>新建课程名称</label>
                                <input class="form-control" style="width: 150px;" id="name" name="classHeadName" type="text" onblur="isHave(this)">
                                <span class="help-inline"></span>
                            </div>
                            <script>
                                function  isHave(obj) {
                                    if(obj.value == null || obj.value == ""){
                                        alert("课程名不可为空");
                                    }else {
                                        $.ajax({
                                            type: "GET",
                                            contentType: "application/json",
                                            async: false,
                                            url: "${base.contextPath}/isH?name="+ obj.value,
                                            success: function (data) {
                                                if(data.total != 0){
                                                    alert("该课程名已存在，请重新输入！");
                                                    $("#b").attr({"disabled":"disabled"});
                                                    obj.value = null;
                                                }
                                                if(data.total == 0){
                                                    $("#b").removeAttr("disabled")
                                                }
                                            }
                                        });
                                    }
                                }
                            </script>
                            <div class="get" style="margin-left: 125px;margin-top: 10px">
                                <label>课节数</label>
                                <select class="form-control" style="width: 150px" name="number">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </select>
                            </div>
                            <div class="get" style="margin-left: 125px;margin-top: 10px">
                                <label>描述</label>
                                <textarea name="description" style="width: 300px" rows="5" cols="20" class="form-control">课程描述</textarea>
                            </div>
                            <button id="b" disabled="disabled" class="btn btn-primary" type="submit" style="margin-top:10px;margin-left:125px;width: 300px">确定</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
