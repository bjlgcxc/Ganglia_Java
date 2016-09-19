<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="static/bower_components/moment/min/moment-with-locales.min.js"></script>
<script src="static/bower_components/bootstrap/js/transition.js"></script>
<script src="static/bower_components/bootstrap/js/collapse.js"></script>
<script src="static/bower_components/bootstrap-datetimepicker/src/js/bootstrap-datetimepicker.js"></script>
<script src="static//bower_components/flot/excanvas.min.js"></script>
<script src="static//bower_components/flot/jquery.flot.js"></script>
<script src="static//bower_components/flot/jquery.flot.pie.js"></script>
<script src="static//bower_components/flot/jquery.flot.resize.js"></script>
<script src="static//bower_components/flot/jquery.flot.time.js"></script>
<script src="static//bower_components/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
<link rel="stylesheet" href="../static/bower_components/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">历史数据查询</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <c:if test="${result == false}">
                <form:form action="history.html" modelAttribute="history" method="post">
                	<div class="panel-heading">
                                                选择你要查询的历史数据的时间段
                	</div>
                	<div class="panel-body">
                    	<div class='col-lg-6'>
                        	<div class="form-group input-group date" id="datetimepicker1">
                            	<form:input path="beginTime" type='text' class="form-control"/>
                            	<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-calendar"></i>
                                </span>
                        	</div>
                   		</div>
                    	<div class='col-lg-6'>
                        	<div class="form-group input-group date" id="datetimepicker2">
                            	<form:input path="stopTime" type='text' class="form-control"/>
                            	<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-calendar"></i>
                                </span>
                        	</div>
                    	</div>
                    <script type="text/javascript">
                        $(function () {
                            $('#datetimepicker1').datetimepicker({
                                locale: 'zh-cn',
                                format: 'YYYY-MM-DD HH:mm:ss'
                            });
                            $('#datetimepicker2').datetimepicker({
                                useCurrent: false ,//Important! See issue #1075
                                locale: 'zh-cn',
                                format: 'YYYY-MM-DD HH:mm:ss'
                            });
                            $("#datetimepicker1").on("dp.change", function (e) {
                                $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
                            });
                            $("#datetimepicker2").on("dp.change", function (e) {
                                $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
                            });
                        });
                    </script>
                	</div>
	                <!-- panel body end -->
	                <div class="panel-footer">
	                    <input type="submit" class="btn btn-outline btn-primary" value="确定">
	                </div>
	            </form:form>
	            </c:if>

                <c:if test="${result == true}">
                    <div class="panel-heading">
                                               历史数据
                    </div>
                    <div class="panel-body">
                        <%--<div class="flot-chart">--%>
                            <%--<div class="flot-chart-content" id="flot-line-chart-multi"></div>--%>
                        <%--</div>--%>
                        <p class="text-success">${msg}</p>
                    </div>
                    <div class="panel-footer">
                        <a href="history.html" class="btn btn-outline btn-success">返回</a>
                    </div>
                </c:if>
                
            </div>
            <!-- panel end -->
        </div>
        <!-- col-lg-6 -->
    </div>
    <!-- row end-->
</div>