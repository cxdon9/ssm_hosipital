<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <!--font-awesome字体图标库-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"
            charset="utf-8"></script>
    <title>患者管理</title>
    <style type="text/css">
        th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <iframe src="${pageContext.request.contextPath}/iframe/nav.jsp" width="100%" frameborder="0"></iframe>
    </div>
    <!--按钮工具栏-->
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-2">
            <!--按钮组-->
            <div class="btn-group">
                <a href="${pageContext.request.contextPath}/manager/patient/AddPatient.jsp" class="btn btn-info btn-sm"><span
                        class="glyphicon glyphicon-plus"></span> 添加患者</a>
            </div>
        </div>
        <div class="col-md-3">
            <form action="${pageContext.request.contextPath}/patient/select.do" class="form form-inline input-group"
                  method="post">
                <input type="text" class="form-control" placeholder="请输入患者姓名" name="name" id="name"/>
                <span class="input-group-btn"><input type="submit" class="btn btn-success" value="搜索"/></span>
            </form>
        </div>
        <div class="col-md-5"></div>
    </div>
    <div class="row">
        <div class="col-md-12"></div>
    </div>
    <!--信息管理table-->
    <form action="${pageContext.request.contextPath}/patient/deleteMany.do" method="post">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">

                <table class="table table-bordered table-condensed table-hover">
                    <thead>
                    <tr class="bg-info text-capitalize">
                        <th><input type="checkbox"></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>身份证号</th>
                        <th>出生年月日</th>
                        <th>电话</th>
                        <th style="width: 30%;">操作</th>
                    </tr>
                    </thead>
                    <tbody style="text-align: center;">
                    <c:forEach var="list" items="${requestScope.list}" varStatus="st">
                        <tr>
                            <td style="text-align: center;"><input type="checkbox" name="ids" value="${list.id}"/></td>
                            <td>${st.count}</td>
                            <td>${list.name}</td>
                            <td><c:if test="${list.sex==0}">男</c:if>
                                <c:if test="${list.sex==1}">女</c:if></td>

                            <td>${list.idcard}</td>
                            <td><fmt:formatDate value="${list.birth}" pattern="yyyy-MM-dd"/></td>
                            <td>${list.mobile}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/patient/delete.do?id=${list.id}"
                                   class="btn btn-xs btn-warning"><i class="fa fa-trash"></i> 删除</a>
                                <a href="${pageContext.request.contextPath}/patient/selectOne.do?id=${list.id}"
                                   class="btn btn-xs btn-info"><i class="fa fa-edit"></i> 修改</a>
                                <a href="${pageContext.request.contextPath}/patient/selectdept.do?id=${list.id}"
                                   class="btn btn-xs btn-danger"><i class="fa fa-heart"></i> 挂号</a>
                                <a href="#" class="btn btn-xs btn-primary"><i class="fa fa-download"></i>下载诊断</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input type="submit" value="删除选中" class="btn btn-danger">
            </div>
            <div class="col-md-2"></div>
        </div>
    </form>
    <!--分页-->
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <ul class="pager">
                <c:if test="${pageIndex>1}">
                    <li class="previous"><a
                            href="${pageContext.request.contextPath}/patient/select.do?pageIndex=${pageIndex-1}"
                            class="btn btn-default">上一页</a></li>
                </c:if>
                <li><a href="#" class="btn btn-default active disabled">第${requestScope.pageIndex}页</a></li>
                <c:if test="${pageIndex < totalPage}">
                    <li class="next"><a
                            href="${pageContext.request.contextPath}/patient/select.do?pageIndex=${pageIndex+1}"
                            class="btn btn-default">下一页</a></li>
                </c:if>
            </ul>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="row">
        <div class="com-md-12">
            <!--底部-->
            <footer class="modal-footer navbar-fixed-bottom">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8" style="text-align: left;">
                        &trade;百知教育 网址:<a href="http://www.baizhiedu.com">http://www.baizhiedu.com</a>
                    </div>
                    <div class="col-md-2"></div>
                </div>
            </footer>
        </div>
    </div>
</div>
</body>
</html>
