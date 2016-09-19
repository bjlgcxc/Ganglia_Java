<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${fn:length(allMetrics) gt 0}">
        <div class="row">
            <div class="col-lg-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        详细信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive table-bordered">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>参数名</th>
                                    <th>参数类型</th>
                                    <th>参数单位</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${allMetrics}" var="items">
                                    <tr>
                                        <td>${items.metricName}</td>
                                        <td>${items.type}</td>
                                        <td>${items.unit}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
            </div>
        </div>


    </c:when>

    <c:otherwise>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    无数据
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <p class="text text-danger">没有可以显示的数据</p>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </c:otherwise>
</c:choose>
