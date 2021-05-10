<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/7/3
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../jsp/common/head.jsp"%>

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
        <span>日程管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/event/findByScheduleName">
            <input name="student_id"  id="student_id" class="input-text" type="hidden">
<%--            日程管理对应类型2 --%>
            <input name="type" value="2" class="input-text" type="hidden">
            <span>日程名称关键字：</span>
            <input name="event" type="text" >

<%--            <span>发布者：</span>--%>
<%--            <select name="queryProviderId">--%>
<%--                <c:if test="${providerList != null }">--%>
<%--                    <option value="0">--请选择--</option>--%>
<%--                    <c:forEach var="provider" items="${providerList}">--%>
<%--                        <option <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>--%>
<%--                                value="${provider.id}">${provider.proName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </c:if>--%>
<%--            </select>--%>

<%--            <span>是否过期：</span>--%>
<%--            <select name="queryIsPayment">--%>
<%--                <option value="0">--请选择--</option>--%>
<%--                <option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未过期</option>--%>
<%--                <option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已过期</option>--%>
<%--            </select>--%>

            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/jsp/billadd.jsp">添加日程</a>
        </form>
    </div>
    <!--账单表格 样式和供应商公用-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">序号</th>
            <th width="20%">创建时间</th>
            <th width="40%">日程</th>
            <th width="10%">状态</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach var="schedules" items="${schedules}" varStatus="status">
            <tr>
                <td>
					<span>
					${status.index+1}
					</span>
                </td>
                <td>
					<span>
					<fmt:formatDate value="${schedules.date}" pattern="yyyy-MM-dd"/>
					</span>
                </td>
                <td>
                    <span>${schedules.event}</span>
                </td>
                <td>
					<span>
						<c:if test="${schedules.done == 0}">未到期</c:if>
						<c:if test="${schedules.done == 1}">已过期</c:if>
					</span>
                </td>
                <td>
                    <span><a class="modifyBill" href="javascript:;" event="${schedules.event}"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteBill" href="javascript:;" event="${schedules.event }" ><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该日程吗？</p>
            <a href="#"  id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="../../jsp/common/foot.jsp" %>
<script type="text/javascript" src="../../js/billlist.js"></script>



