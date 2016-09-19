<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${fn:length(allGrids) gt 0}">
        <div class="row">
        <c:forEach items="${allGrids}" var="grids">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${grids.gridName}实时数据
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="flot-chart">
                            <div class="flot-chart-content" id="${grids.gridName}"></div>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                    <a href="${pageContext.request.contextPath}/grids/${grids.gridName}.html">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>

        <%--Chart Data--%>
        <script>
            //Flot Moving Line Chart
            <c:forEach items="${allGrids}" var="grids">
            $(function() {

                var container = $("#${grids.gridName}");

                // Determine how many data points to keep based on the placeholder's initial size;
                // this gives us a nice high-res plot while avoiding more than one point per pixel.

                var maximum = container.outerWidth() / 2 || 300;

                //

                var data = [];

                function getRandomData() {

                    if (data.length) {
                        data = data.slice(1);
                    }

                    while (data.length < maximum) {
                        var previous = data.length ? data[data.length - 1] : 50;
                        var y = previous + Math.random() * 10 - 5;
                        data.push(y < 0 ? 0 : y > 100 ? 100 : y);
                    }

                    // zip the generated y values with the x values

                    var res = [];
                    for (var i = 0; i < data.length; ++i) {
                        res.push([i, data[i]])
                    }

                    return res;
                }

                //

                series = [{
                    data: getRandomData(),
                    lines: {
                        fill: true
                    }
                }];

                //

                var plot = $.plot(container, series, {
                    grid: {
                        borderWidth: 1,
                        minBorderMargin: 20,
                        labelMargin: 10,
                        backgroundColor: {
                            colors: ["#fff", "#e4f4f4"]
                        },
                        margin: {
                            top: 8,
                            bottom: 20,
                            left: 20
                        },
                        markings: function(axes) {
                            var markings = [];
                            var xaxis = axes.xaxis;
                            for (var x = Math.floor(xaxis.min); x < xaxis.max; x += xaxis.tickSize * 2) {
                                markings.push({
                                    xaxis: {
                                        from: x,
                                        to: x + xaxis.tickSize
                                    },
                                    color: "rgba(232, 232, 255, 0.2)"
                                });
                            }
                            return markings;
                        }
                    },
                    xaxis: {
                        tickFormatter: function() {
                            return "";
                        }
                    },
                    yaxis: {
                        min: 0,
                        max: 110
                    },
                    legend: {
                        show: true
                    }
                });

                // Update the random dataset at 25FPS for a smoothly-animating chart

                setInterval(function updateRandom() {
                    series[0].data = getRandomData();
                    plot.setData(series);
                    plot.draw();
                }, 40);

            });
            </c:forEach>
        </script>
    </c:when>

    <c:otherwise>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    无数据
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <p class="text text-danger">没有可以显示的网格</p>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </c:otherwise>
</c:choose>


