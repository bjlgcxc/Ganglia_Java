<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">集群详细信息</h1>
        </div>

        <jsp:include page="${pageContext.request.contextPath}detail_partials/${detailPage}" flush="true"/>


    </div>
</div>