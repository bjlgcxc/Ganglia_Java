<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--删除用户--%>
    <!-- /.panel-body -->
    <div class="panel-body">
        <form:form modelAttribute="deleteForm" action="/userProfile/deleteUser.html" method="post">
            <div class="form-group">

                <label>请选择要删除的用户</label>

                    <form:select path="userName" class="form-control">
                        <c:forEach items="${listUsers}" var="item">
                            <form:option value="${item.userName}">${item.userName}</form:option>
                        </c:forEach>
                    </form:select>

                <label>请输入要删除的用户的密码</label>
                <form:input path="userPassword" type="password" class="form-control"
                            onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
            </div>
            <input type="submit" class="btn btn-outline btn-primary" value="确定">
        </form:form>
    </div>