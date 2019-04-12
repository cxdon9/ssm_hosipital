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
    <title>分诊管理</title>
    <style type="text/css">
        th {
            text-align: center;
        }

        body {
            background-color: #fffff1;
        }

        html {
            margin: 1px;
        }
    </style>
</head>

<body>
<iframe src="${pageContext.request.contextPath}/iframe/nav.jsp" width="100%" frameborder="0"></iframe>
<div style="margin-bottom:30px" class="container-fluid">

    <!--统计信息-->
    <div class="row">
        <!--当前科室下，所有待诊断的患者信息：按照序号，按照未诊断优先-->

        <div class="col-md-2"></div>
        <div class="col-md-8">
            <table class="table table-bordered table-hover">
                <thead>
                <tr class="bg-primary" style="font-size: 25px;">
                    <th colspan="6">科室患者信息 · ${requestScope.deptName}</th>
                </tr>
                <tr class="bg-info">
                    <th>序号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>出生年月日</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody style="align-content: center">

                <c:forEach var="list" items="${requestScope.list}" varStatus="st">
                    <tr>
                        <td>${st.count}</td>
                        <td>${list.patient.name}</td>
                        <td><c:if test="${list.patient.sex==0}">男</c:if>
                            <c:if test="${list.patient.sex==1}">女</c:if></td>
                        <td><fmt:formatDate value="${list.patient.birth}" pattern="yyyy-MM-dd"/></td>

                        <c:choose>
                            <c:when test="${list.status==0}">
                                <td class="text-danger">待诊 <i class="fa fa-question-circle"></i></td>
                            </c:when>
                            <c:when test="${list.status==1}">
                                <td class="text-primary">诊断中 <i class="fa fa-spinner fa-spin"></i></td>
                            </c:when>
                            <c:otherwise>
                                <td class="text-success">诊断结束 <i class="fa fa-check-circle"></i></td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a href="${pageContext.request.contextPath}/triage/updateStatus.do?id=${list.id}"
                               class="btn btn-xs btn-success">叫号<i class="fa fa-user-circle"></i></a>
                            <a href="AddTriage.html" class="btn btn-xs btn-primary">诊断 <i class="fa fa-medkit"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<!--分页-->
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <ul class="pager">
            <li class="previous"><a href="#" class="btn btn-default">上一页</a></li>
            <li><a href="#" class="btn btn-default active disabled">第2页</a></li>
            <li class="next"><a href="#" class="btn btn-default">下一页</a></li>
        </ul>
    </div>
    <div class="col-md-4"></div>
</div>
<!--底部-->
<footer class="panel-footer navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8" style="text-align: left;">
                &trade;百知教育 网址:
                <a href="http://www.baizhiedu.com">http://www.baizhiedu.com</a>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>

</footer>
</body>

</html>