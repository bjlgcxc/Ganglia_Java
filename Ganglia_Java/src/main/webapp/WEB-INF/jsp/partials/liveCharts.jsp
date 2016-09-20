<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Morris Charts CSS -->
<link href="static/bower_components/morrisjs/morris.css" rel="stylesheet">

<!-- Flot Charts JavaScript -->
<script src="static/bower_components/flot/excanvas.min.js"></script>
<script src="static/bower_components/flot/jquery.flot.js"></script>
<script src="static/bower_components/flot/jquery.flot.pie.js"></script>
<script src="static/bower_components/flot/jquery.flot.resize.js"></script>
<script src="static/bower_components/flot/jquery.flot.time.js"></script>
<script src="static/bower_components/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">实时监控信息</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

    <jsp:include page="/WEB-INF/jsp/partials/charts_partials/${liveChartPage}" flush="true"/>

</div>
<!-- /.row -->