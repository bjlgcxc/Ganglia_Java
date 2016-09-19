<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" href="settings.html">设置</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    设置
                </div>
                <!-- /.panel-heading -->
                <c:choose>
                    <c:when test="${save == false}">
                        <form:form action="settings.html" modelAttribute="setting" method="post">
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#liveChart" data-toggle="tab">动态图表设置</a>
                                </li>
                                <li><a href="#messages" data-toggle="tab">通知消息设置</a>
                                </li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="col-lg-8">
                                <div class="tab-content">
                                    <div class="tab-pane fade in active" id="liveChart">
                                        <h4>动态图表设置</h4>
                                        <br>
                                        <div class="form-group">
                                            <label>选择每行最多显示的图表数</label>
                                            <form:select path="line_count" class="form-control">
                                                <form:option value="${setting.line_count}">${setting.line_count}</form:option>
                                                <form:option value="2">2</form:option>
                                                <form:option value="3">3</form:option>
                                                <form:option value="4">4</form:option>
                                                <form:option value="6">6</form:option>
                                            </form:select>
                                        </div>
                                        <br>
                                        <label>数据更新间隔时间</label>
                                        <div class="form-group input-group">
                                            <form:input path="update_interval" type="text" class="form-control" value="${setting.update_interval}"/>
                                            <span class="input-group-addon">毫秒</span>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="messages">
                                        <h4>通知消息设置</h4>
                                        <br>
                                        <label>设置下列参数的报警值</label>
                                            <div class="table-responsive table-bordered">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>参数名</th>
                                                        <th>报警阀值</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <form:form method="post" >
                                                    <c:forEach items="${metrics}" var="items">
                                                    <tr>
                                                        <td>${items.metricName}</td>
                                                        <td><div class="form-group input-group">
                                                            <input class="form-control" value="${items.warning}"/>
                                                            <span class="input-group-addon">${items.unit}</span>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                    </form:form>
                                                </table>
                                            </div>
                                            <!-- /.table-responsive -->
                                        <br>
                                        <label>设置接收通知消息的邮箱</label>
                                        <div class="form-group input-group">
                                            <span class="input-group-addon">@</span>
                                            <form:input path="email" type="text" class="form-control" value="${setting.email}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <input class="btn btn-outline btn-primary" type="submit" value="保存"/>
                        </div>
                        </form:form>
                    </c:when>
                    <c:otherwise>
                        <div class="panel-body">
                            <div class="panel-body">
                                <p class="text-success">保存成功</p>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <a href="settings.html" class="btn btn-outline btn-success">返回</a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <!-- /.panel -->

        </div>
        <!-- /.col-lg-6 -->
    </div>

</div>
