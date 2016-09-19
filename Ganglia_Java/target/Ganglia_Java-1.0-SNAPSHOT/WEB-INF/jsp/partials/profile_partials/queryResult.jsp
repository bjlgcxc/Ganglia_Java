<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--查询操作--%>
    <!-- /.panel-body -->
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="item">
                    <tr>
                        <td>${item.userId}</td>
                        <td>${item.userName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /.table-responsive -->
    </div>
    <!-- /.panel-footer -->