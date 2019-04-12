<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <title>医院分诊管理系统首页</title>
    <style type="text/css">
        th {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="" method="post" id="formId1">
    <div class="container-fluid">
        <div class="row">
            <iframe src="${pageContext.request.contextPath}/iframe/nav.jsp" width="100%" frameborder="0"></iframe>
        </div>

        <!--按钮工具栏-->
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-2">
                <%-- <form action="${pageContext.request.contextPath}/dept/select.do"  >--%>
                <input type="text" class="form-control" placeholder="请输入科室名" name="name" id="name"/>
                <span class="input-group-btn"><input type="submit" class="btn btn-success" value="搜索" id="but1"/></span>
            </div>
            <div class="col-md-3"></div>

            <div class="col-md-2">
                <!--按钮组-->
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/manager/department/AddDepartment.jsp"
                       class="btn btn-info btn-sm"><span class="glyphicon glyphicon-plus"></span> 添加科室</a>
                    <input type="submit" class="btn btn-danger btn-sm" value="删除选中" id="but2"/>
                </div>
            </div>
            <div class="col-md-5"></div>
        </div>
        <div class="row">
            <div class="col-md-12"></div>
        </div>
        <!--信息管理table-->
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-bordered table-condensed table-hover">
                    <thead>
                    <tr class="bg-info text-capitalize">
                        <th class="">
                            <input type="checkbox" id=/>
                        </th>
                        <th>编号</th>
                        <th>名称</th>
                        <th>办公室电话</th>
                        <th>所在区域</th>
                        <th style="width: 20%;">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${requestScope.list}" varStatus="st">
                        <tr>
                            <td style="text-align: center;"><input type="checkbox" name="ids" value="${list.id}"/></td>
                            <td>${st.count}</td>
                            <td>${list.name}</td>
                            <td>${list.telephone}</td>
                            <td>${list.area}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/dept/delete.do?id=${list.id}"
                                   class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-trash"></span> 删除</a>
                                <a href="${pageContext.request.contextPath}/dept/selectOne.do?id=${list.id}"
                                   class="btn btn-xs btn-info"><span class="glyphicon glyphicon-edit"></span> 修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-2"></div>
        </div>

        <!--分页-->
        <div class="row">
            <div class="col-md-4"></div>

            <div class="col-md-4">
                <ul class="pager">
                    <c:if test="${pageIndex>1}">
                        <li class="previous"><a
                                href="${pageContext.request.contextPath}/dept/select.do?pageIndex=${pageIndex-1}"
                                class="btn btn-default">上一页</a></li>
                    </c:if>
                    <li><a href="#" class="btn btn-default active disabled">第${requestScope.pageIndex}页</a></li>
                    <c:if test="${pageIndex < totalPage}">
                        <li class="next"><a
                                href="${pageContext.request.contextPath}/dept/select.do?pageIndex=${pageIndex+1}"
                                class="btn btn-default">下一页</a></li>
                    </c:if>
                </ul>

            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</form>
</body>
<script>

    document.getElementById('but1').onclick = function () {
        document.getElementById('formId1').setAttribute("action", "${pageContext.request.contextPath}/dept/select.do");
    }
    document.getElementById('but2').onclick = function () {
        document.getElementById('formId1').removeAttribute("action", "${pageContext.request.contextPath}/dept/select.do")
        document.getElementById('formId1').setAttribute("action", "${pageContext.request.contextPath}/dept/deleteMany.do");
    }
</script>
</html>

