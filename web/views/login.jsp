<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/11
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 3 | Log in</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- icheck bootstrap -->
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">

    </head>
    <body class="hold-transition login-page">
        <div class="alert alert-danger alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h5><i class="icon fas fa-ban"></i> Alert!</h5>
            ${msg}
        </div>

        <div class="login-box">
            <div class="login-logo">
                <a href="#">后台登录</a>
            </div>
            <!-- /.login-logo -->
            <div class="card">
                <div class="card-body login-card-body">
                    <p class="login-box-msg">人就是那么贱,什么界面都可以适应的</p>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="用户名" name="userName">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-envelope"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" placeholder="密码" name="password">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <%--  <div class="col-8">
                                  <div class="icheck-primary">
                                      <input type="checkbox" id="remember">
                                      <label for="remember">
                                          Remember Me
                                      </label>
                                  </div>
                              </div>--%>
                            <!-- /.col -->
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block">登录</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>

                    <p class="mb-1">
                        <a href="forgot-password.html">忘记密码</a>
                    </p>
                    <%--  <p class="mb-0">
                          <a href="register.html" class="text-center">注册</a>
                      </p>--%>
                </div>
                <!-- /.login-card-body -->
            </div>
        </div>
        <!-- /.login-box -->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

    </body>
</html>
