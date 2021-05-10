<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/7/8
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

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

        function getLocalTime() {
            var time = new Date();
//    console.log(time);
            var year = time.getFullYear();
            var mon = time.getMonth()+1;
            var day = time.getDate();

            return year+"-"+mon+"-"+day
        }


        $("#student_id").val(decodeURI(getCookie("student_id")))


    })
</script>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>作业管理页面 >> 作业添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/homework/addHomework">
            <!-- 作业管理对应的type为1 -->
            <input type="hidden" name="type" value="1">
            <input type="hidden" name="student_id" id="student_id" value="">
            <div class="">
                <label for="billCode">创建时间：</label>
                <input  type="date" name="date" class="text" id="billCode" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="productUnit">发布者：</label>
                <input type="text" name="announcer" id="productUnit" value="">
                <font color="red"></font>
            </div>
            <div class="">
                <label for="productName">具体作业：</label>
                <input type="text" name="event" id="productName" value="">
                <font color="red"></font>
            </div>
            <%--             <div>--%>
            <%--                 <label for="productUnit">商品单位：</label>--%>
            <%--                 <input type="text" name="productUnit" id="productUnit" value=""> --%>
            <%--				 <font color="red"></font>--%>
            <%--             </div>--%>
            <%--             <div>--%>
            <%--                 <label for="productCount">商品数量：</label>--%>
            <%--                 <input type="text" name="productCount" id="productCount" value=""> --%>
            <%--				 <font color="red"></font>--%>
            <%--             </div>--%>
            <%--             <div>--%>
            <%--                 <label for="totalPrice">总金额：</label>--%>
            <%--                 <input type="text" name="totalPrice" id="totalPrice" value=""> --%>
            <%--				 <font color="red"></font>--%>
            <%--             </div>--%>
            <%--             <div>--%>
            <%--                 <label >供应商：</label>--%>
            <%--                 <select name="providerId" id="providerId">--%>
            <%--		         </select>--%>
            <%--				 <font color="red"></font>--%>
            <%--             </div>--%>
            <div>
                <label >作业状态：</label>
                <input type="radio" name="done" value="0" checked="checked">未完成
                <input type="radio" name="done" value="1" >已完成
            </div>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="/js/homeworkAdd.js"></script>
