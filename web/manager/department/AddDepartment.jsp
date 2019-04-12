<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"
            charset="utf-8"></script>
    <title>医院分诊管理系统首页</title>
    <style type="text/css">
        th {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <iframe src="../../iframe/nav.html" width="100%" frameborder="0"></iframe>
    </div>

    <div class="row">
        <div class="col-md-12"></div>
    </div>
    <!--信息管理table-->
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="text-align: center;">
            <form class="form-inline" action="${pageContext.request.contextPath}/dept/insert.do" method="get">
                <table class="table  table-bordered" style="width:100%;">
                    <tr class="bg-info">
                        <td style="text-align: center;" colspan="2"><span style="font-size: 20px;font-weight: bold;">科室添加</span>
                        </td>
                    </tr>
                    <tr class="active">
                        <td style="width: 180px; vertical-align: middle">科室名称</td>
                        <td><input type="text" style="width: 100%;" placeholder="请输入科室名称" class="form-control"
                                   name="name"></td>
                    </tr>
                    <tr class="active">
                        <td style="width: 180px; vertical-align: middle">办公室电话</td>
                        <td><input type="text" style="width: 100%;" placeholder="请输入办公室电话" class="form-control"
                                   name="telephone"></td>
                    </tr>
                    <tr class="active">
                        <td style="width: 180px; vertical-align: middle">所在区域</td>
                        <td><input type="text" style="width: 100%;" placeholder="请输入所在区域" class="form-control"
                                   name="area"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" style="width: 200px;" class="btn btn-success" value="添加">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
    <!--底部-->
</div>
</body>
</html>

