<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!-- /.navbar-header -->
<ul class="nav navbar-top-links navbar-right">
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-tasks fa-fw"></i>  
            <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-tasks">
            <c:if test="${fn:length(allGrids) gt 0}">
                <c:forEach items="${allGrids}" var="grids">
                    <li>
                        <c:set var="rand">${random.nextInt(100)}</c:set>
                        <a href="${pageContext.request.contextPath}/grids/${grids.gridName}.html">
                            <div>
                                <p>
                                    <strong>${grids.gridName}</strong>
                                    <span class="pull-right text-muted">${rand}% 负载</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${rand}" aria-valuemin="0" aria-valuemax="100" style="width: ${rand}%">
                                        <span class="sr-only">${rand}% </span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                </c:forEach>
                <li>
                    <a class="text-center" href="${pageContext.request.contextPath}/detailView.html">
                        <strong>查看所有网格状态</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </c:if>
            <c:if test="${fn:length(allClusters) gt 0}">
                <c:forEach items="${allClusters}" var="clusters">
                    <li>
                        <c:set var="rand">${random.nextInt(100)}</c:set>
                        <c:set var="status"></c:set>
                        <a href="${pageContext.request.contextPath}/clusters/${clusters.clusterName}.html">
                            <div>
                                <p>
                                    <strong>${clusters.clusterName}</strong>
                                    <span class="pull-right text-muted">${rand}% 负载</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${rand}" aria-valuemin="0" aria-valuemax="100" style="width: ${rand}%">
                                        <span class="sr-only">${rand}% 负载 (success)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                </c:forEach>
                <li>
                    <a class="text-center" href="${pageContext.request.contextPath}/detailView.html">
                        <strong>查看所有集群信息</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </c:if>
            <c:if test="${fn:length(allHosts) gt 0}">
                <c:forEach items="${allHosts}" var="hosts">
                    <li>
                        <c:set var="rand">${random.nextInt(100)}</c:set>
                        <a href="${pageContext.request.contextPath}/hosts/${hosts.hostName}.html">
                            <div>
                                <p>
                                    <strong>${hosts.hostName}</strong>
                                    <span class="pull-right text-muted">${rand}% 负载</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${rand}" aria-valuemin="0" aria-valuemax="100" style="width: ${rand}%">
                                        <span class="sr-only">${rand}% 负载 (success)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                </c:forEach>
                <li>
                    <a class="text-center" href="${pageContext.request.contextPath}/detailView.html">
                        <strong>查看所有主机信息</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </c:if>
            <c:if test="${fn:length(allMetrics) gt 0}">
                <c:forEach items="${allMetrics}" var="metrics">
                    <li>
                        <c:set var="rand">${random.nextInt(100)}</c:set>
                        <a href="${pageContext.request.contextPath}/metrics/${metrics.metricName}.html">
                            <div>
                                <p>
                                    <strong>${metrics.metricName}</strong>
                                    <span class="pull-right text-muted">${rand}% 使用率</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${rand}" aria-valuemin="0" aria-valuemax="100" style="width: ${rand}%">
                                        <span class="sr-only"> ${rand} ${metrics.unit})</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                </c:forEach>
                <li>
                    <a class="text-center" href="${pageContext.request.contextPath}/detailView.html">
                        <strong>查看主机详细信息</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </c:if>
            <c:if test="${fn:length(allGrids) == 0 && fn:length(allClusters) == 0 && fn:length(allHosts) == 0 && fn:length(allMetrics) == 0}">
                <li class="divider"></li>
                <li>
                    <p class="text-danger text-center">
                        <strong>没有可以显示的信息</strong>
                    </p>
                </li>
            </c:if>
        </ul>
        <!-- /.dropdown-tasks -->
    </li>
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-alerts">
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-warning fa-fw"></i> 集群1 发生故障
                        <span class="pull-right text-muted small">4 分钟前</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-bolt fa-fw"></i> 集群3 负载较高
                        <span class="pull-right text-muted small">12 分钟前</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="glyphicon glyphicon-hdd"></i> 服务器3 硬盘占用过高
                        <span class="pull-right text-muted small">4 分钟前</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-level-down fa-fw"></i> 服务器4 下线
                        <span class="pull-right text-muted small">4 分钟前</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a class="text-center" href="notification.html">
                    <strong>查看所有通知消息</strong>
                    <i class="fa fa-angle-right"></i>
                </a>
            </li>
        </ul>
        <!-- /.dropdown-alerts -->
    </li>
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="${pageContext.request.contextPath}/userProfile.html"><i class="fa fa-user fa-fw"></i> 用户管理</a>
            </li>
            <li><a href="${pageContext.request.contextPath}/settings.html"><i class="fa fa-gear fa-fw"></i> 设置</a>
            </li>
            <li class="divider"></li>
            <li><a href="${pageContext.request.contextPath}/login.html"><i class="fa fa-sign-out fa-fw"></i> 注销 </a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>
<!-- /.navbar-top-links -->