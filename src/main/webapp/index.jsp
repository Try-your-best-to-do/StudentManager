﻿<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 学生信息管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script>
	/* if(top.location!=self.location){
	      top.location=self.location;
	 } */

    $(function () {

        $("#register").click(function(){
            window.parent.location.href="/student/toRegister"
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
	        <form class="loginForm" action="${pageContext.request.contextPath }/student/login"  name="actionForm" id="actionForm"  method="post" >
                <div class="info">${msg}</div>
				<div class="inputbox">
                    <label id="lab_stu">学号：</label>
					<input type="text" class="input-text" id="student_id" name="student_id" placeholder="请输入用户名" />
				</div>	
				<div class="inputbox">
                    <label id=""lab_pw>密码：</label>
                    <input type="password" id="password" name="password" placeholder="请输入密码" />
                </div>	
				<div class="subBtn">
                    <input type="submit" value="登录"/>
                    <input type="reset".preventDefault()  id="register" value="注册"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
