<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="net.suncaper.myapp.common.domain.Student" %>
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
                                        <%-- <h3 class="card-title">学员列表</h3>--%>
                                        <ul class="pagination pagination m-0">
                                            <li class="page-item"><a class="page-link" href="#">上一页</a></li>

                                            <li class="page-item"><a class="page-link" href="javascript:;">2/6</a></li>

                                            <li class="page-item"><a class="page-link" href="#">下一页</a></li>
                                        </ul>
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
                                            <%--@elvariable id="allStudent" type="java.util.List<net.suncaper.myapp.common.domain.Student>"--%>
                                            <c:forEach items="${allStudent}" var="stu" varStatus="status">
                                                <tr>
                                                    <td>
                                                            ${status.count}
                                                    </td>
                                                    <td>
                                                            ${stu.name}
                                                    </td>
                                                    <td>  ${stu.stuNo}</td>
                                                    <td> ${stu.sex}</td>
                                                    <td>
                                                        <button type="button" class="btn btn-outline-success btn-xs btn-flat">更改</button>
                                                        <button type="button" class="btn btn-outline-danger btn-xs btn-flat">删除</button>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.card-body -->

                                    <div class="card-footer clearfix">
                                        <ul class="pagination pagination-sm m-0 float-right">
                                            <li class="page-item"><a class="page-link" href="#">«</a></li>
                                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item"><a class="page-link" href="#">»</a></li>
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
    </body>
</html>
