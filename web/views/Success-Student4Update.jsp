<jsp:useBean id="stu" scope="request" type="net.suncaper.myapp.common.domain.Student"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <div class="content">

                    <div class="row">
                        <div class="col-lg-6 offset-3">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">操作成功！！！以下是更改后的信息 ：</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form role="form" action="#">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="name">姓名</label>
                                            <input type="text" class="form-control" name="name" id="name"
                                                   value="${stu.name}" disabled>
                                        </div>

                                        <div class="form-group">
                                            <label for="stuNo">学号</label>
                                            <input type="text" class="form-control" name="stuNo" id="stuNo"
                                                   value="${stu.stuNo}" disabled>
                                        </div>

                                        <div class="form-group">
                                            <label for="sex">性别</label>
                                            <input type="text" class="form-control" name="stuNo" id="sex"
                                                   value="${stu.sex}" disabled>

                                        </div>
                                    </div>
                                    <!-- /.card-body -->

                                    <div class="card-footer">
                                        <input type="hidden" name="id" value="${stu.id}">
                                        <a href="${pageContext.request.contextPath}/listStudent" class="btn btn-primary">重新查询</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

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
