<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/7/4
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统注册 - 学生信息单管理系统</title>
    <link type="text/css" rel="stylesheet" href="../../css/register.css" />
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script>
        /* if(top.location!=self.location){
              top.location=self.location;
         } */
        $(function () {
            $("#back").click(function () {
                history.back(-1)
            })
        })

    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>学生信息管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/student/register"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${msg }</div>
            <div class="inputbox">
                <label>学号：</label>
                <input type="text" class="input-text" id="student_id" name="student_id" placeholder="学号" />
            </div>
            <div class="inputbox">
                <label>密码：</label>
                <input type="password" id="password" name="password" placeholder="请输入密码" />
            </div>
                <div class="inputbox">
                    <label>用户名：</label>
                    <input type="text" class="input-text" id="name" name="name" placeholder="请输入用户名" />
                </div>
                <div class="inputbox">
                    <label>性别：</label>
                    <input type="text" id="sex" name="sex" placeholder="请输入性别" />
                </div>
                <div class="inputbox">
                    <label>班级：</label>
                    <input type="text" class="input-text" id="class_grade" name="class_grade" placeholder="请输入班级" />
                </div>
                <div class="inputbox">
                    <label>专业：</label>
                    <input type="text" class="input-text" id="major" name="major" placeholder="请输入专业" />
                </div>
                <div class="inputbox">
                    <label>电话：</label>
                    <input type="text" class="input-text" id="phone" name="phone" placeholder="请输入电话" />
                </div>
            <div class="subBtn">
                <input type="submit" value="注册"/>
                <input type="reset".preventDefault() id="back"  value="返回"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>
