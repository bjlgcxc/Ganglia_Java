<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<c:choose>
    <c:when test="${fn:length(allHosts) gt 0}">
        <c:forEach items="${allHosts}" var="hosts">
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-tasks fa-5x"></i>
                            </div>
                            <c:set var="rand">${random.nextInt(100)}</c:set>
                            <div class="col-xs-9 text-right">
                                <div class="huge">${rand}%</div>
                                <div class="large">负载</div>
                                <div>${hosts.hostName}</div>
                            </div>
                        </div>
                    </div>
                    <a href="${pageContext.request.contextPath}/hostsDetail/${hosts.hostName}.html">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    无数据
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <p class="text text-danger">没有可以显示的主机</p>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </c:otherwise>
</c:choose>