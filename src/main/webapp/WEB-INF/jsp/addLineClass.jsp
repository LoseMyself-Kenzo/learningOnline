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
                        新建课时
                        <hr style="width:350px;height:1px;border:none;border-top:1px solid #555555;" />
                    </div>
                    <div class="col-md-6 col-md-offset-3">
                            <div class="control-group" style="margin-left: 125px;margin-top: 8px">
                                <label>课程名称</label>
                                <c:if test="${!empty classHeadName}">
                                    <input readonly class="form-control" style="width: 150px;" type="text" value="${classHeadName}">
                                </c:if>
                                <span class="help-inline"></span>
                            </div>
                            <div class="get" style="margin-left: 125px;margin-top: 10px">
                                <c:forEach items="${list}" var ="l">
                                    <form id="up" method="post" enctype="multipart/form-data" style="border: solid lightgray 2px;width: 300px;margin-top: 20px">
                                        <input hidden id="Id${l.number}" value="${l.classLineId}">
                                        <label>第${l.number}小节&nbsp;&nbsp;小节名称</label><input style="width: 150px;" id="name${l.number}" class="form-control"name="classLineName" onblur="isNull(this)">
                                        <input type="file" name="myfile" id="myfile" style="float: left;margin-top: 5px"/>
                                        <input type="button" value="上传选中视频" class="btn btn-primary" id="${l.number}" onclick="up(this)" style="margin-top: 10px">
                                        <input hidden type="text" disabled id="url${l.number}">
                                        <button disabled="disabled" class="btn btn-primary" type="button" id="${l.number}${l.number}" onclick="commit(this)" style="margin-top:10px;width: 300px">创建课时</button>
                                    </form>
                                </c:forEach>
                            </div>
                            <script>
                                var id = 0;
                                function isNull(obj) {
                                    var v = obj.value;
                                    var str = obj.id;
                                    var s = str.charAt(str.length-1);
                                    console.log(v)
                                    if(v == null || v == ""){
                                        $("#"+s+s).attr({"disabled":"disabled"});
                                        alert("请输入课程名称!");
                                    }else{
                                        $("#"+s+s).removeAttr("disabled")
                                    }
                                }
                                function commit(obj) {
                                    var classLineId = $("#Id"+id).val();
                                    var classLineName = $("#name"+id).val();
                                    var url = $("#url"+id).val();
                                    $.ajax({
                                        type: "POST",
//                                        contentType: "application/json",
                                        async: false,
                                        url: "${base.contextPath}/upLine",
                                        data:{classLineId:classLineId,classLineName:classLineName,url:url},
                                        success: function (data) {
                                            alert("update "+data.message);
                                        }
                                    })
                                }

                                function up(obj) {
                                    id = obj.id;
                                    var formData  = new FormData();
                                    formData.append("myfile", document.getElementById("myfile").files[0]);
                                    $.ajax({
                                        type: "POST",
//                                        contentType: "application/json",
                                        async: false,
                                        url: "${base.contextPath}/addVideo",
                                        // 告诉jQuery不要去设置Content-Type请求头
                                        contentType: false,
                                        /**
                                         * 必须false才会避开jQuery对 formdata 的默认处理
                                         * XMLHttpRequest会对 formdata 进行正确的处理
                                         */
                                        processData: false,
                                        beforeSend:function(){
                                            console.log("正在进行，请稍候");
                                        },
                                        data:formData,
                                        success: function (data) {
                                            console.log(data)
                                            console.log(id)
                                            $("#url"+id).val(data.message);
                                        }
                                    })
                                }
                            </script>
                            <a id="b" class="btn btn-primary" href="${base.contextPath}/index" style="margin-top:10px;margin-left:125px;width: 300px">创建完成,返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
