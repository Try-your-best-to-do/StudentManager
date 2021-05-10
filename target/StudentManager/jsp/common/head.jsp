<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学生信息管理系统</title>
    <link type="text/css" rel="stylesheet" href="../../css/style.css" />
    <link type="text/css" rel="stylesheet" href="../../css/public.css" />
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //获取cookie
            function getCookie(key){
                var lists = document.cookie.split(";");
                for(var i = 0;i<lists.length;i++){
                    if(lists[i].includes(key)){
                        var value =  lists[i].split("=")[1]
                        return value;
                    }
                }
            }

            $("#name").text(decodeURI(getCookie("name")))

            $("#schedule").attr("href","/event/findAllSchedule?student_id="+getCookie("student_id"))
            $("#homework").attr("href","/homework/findAllHomework?student_id="+getCookie("student_id"))
            $("#message").attr("href","/message/findAllMessage?student_id="+getCookie("student_id"))
            $("#out").attr("href","/student/login")
        })
    </script>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>学生信息管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span id="name" style="color: #000000"></span> , 欢迎你！</p>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">${date}</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
              <li><a id="schedule" href="">日程管理</a></li>
              <li><a id="message" href="">通知管理</a></li>
              <li><a  id="homework" href="">作业管理</a></li>
              <li><a  id="out" href="">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>