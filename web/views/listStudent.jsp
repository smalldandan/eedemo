<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="net.suncaper.myapp.common.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/11
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>AdminLTE 3 | Starter</title>

        <!-- Font Awesome Icons -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    </head>
    <body class="hold-transition sidebar-mini">
        <div class="wrapper">

            <!-- Navbar -->
            <jsp:include page="/views/common/navbar.jsp"></jsp:include>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <jsp:include page="/views/common/menu.jsp"></jsp:include>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">学员列表</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body p-0">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>姓名</th>
                                                <th>学号</th>
                                                <th>性别</th>
                                                <th >操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%--@elvariable id="pageInfo" type="net.suncaper.myapp.common.utils.PageInfo"--%>
                                            <c:forEach items="${pageInfo.data}" var="stu" varStatus="status">
                                                <tr id="${stu.id}">
                                                    <td>
                                                            ${status.count}
                                                    </td>
                                                    <td>
                                                            ${stu.name}
                                                    </td>
                                                    <td>  ${stu.stuNo}</td>
                                                    <td> ${stu.sex}</td>
                                                    <td>
                                                        <a type="button" class="btn btn-outline-success btn-xs btn-flat">更改</a>
<%--                                                        <a type="button"  href="${pageContext.request.contextPath}/delStudent?id=${stu.id}&pageNo=${pageInfo.pageNo}&pageSize=10" class="btn btn-outline-danger btn-xs btn-flat">删除</a>--%>
                                                        <button class="btn btn-outline-danger btn-xs btn-flat btn_del">删除</button>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.card-body -->

                                    <div class="card-footer clearfix">
                                        <ul class="pagination pagination-sm m-0">
                                            <c:if test="${!pageInfo.first}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/listStudent?pageNo=${pageInfo.pre}&pageSize=10">上一页</a></li>
                                            </c:if>
                                            <li class="page-item"><a class="page-link" href="javascript:;">${pageInfo.pageNo}/${pageInfo.pageCount}</a></li>
                                            <c:if test="${!pageInfo.last}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/listStudent?pageNo=${pageInfo.next}&pageSize=10">下一页</a></li>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
            </div>

            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="/views/common/footer.jsp"></jsp:include>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
        <script>
            $(function () {
                $(".btn_del").click(function () {
                    var $tr = $(this).parents("tr");
                    var $tdName = $tr.find("td:eq(1)");
                    var id = $tr.attr("id");
                    var text = "确认要删除 "+$.trim($tdName.html())+" 吗?"
                    if(confirm(text)){
                        window.location.href="${pageContext.request.contextPath}/delStudent?id="+id+"&pageNo=${pageInfo.pageNo}&pageSize=10";
                    }
                });
            });
        </script>
    </body>
</html>
