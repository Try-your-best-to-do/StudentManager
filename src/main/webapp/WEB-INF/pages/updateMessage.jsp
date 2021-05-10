<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/7/8
  Time: 21:52
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

        $("#student_id").val(decodeURI(getCookie("student_id")))

    })
</script>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>通知管理页面 >> 通知修改页面</span>
    </div>
    <div class="providerAdd">
        <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/message/updateMessage1">
            <!-- 通知管理对应的type为3 -->
            <input type="hidden" name="type" value="3">
            <input type="hidden" name="student_id" id="student_id" value="">
            <input type = "hidden" name="id" value="${id}">
            <div class="">
                <label for="billCode">创建时间：</label>
                <input type="date" name="date" class="text" id="billCode" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="productUnit">发布者：</label>
                <input type="text" name="announcer" id="productUnit" value="">
                <font color="red"></font>
            </div>
            <div>
            <div>
                <label for="productName">具体通知：</label>
                <input type="text" name="event" id="productName" value="">
                <font color="red"></font>
            </div>

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
                <label >通知状态：</label>
                <input type="radio" name="done" value="0" checked="checked">未过期
                <input type="radio" name="done" value="1" >已过期
            </div>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="修改">
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="/js/homeworkAdd.js"></script>
