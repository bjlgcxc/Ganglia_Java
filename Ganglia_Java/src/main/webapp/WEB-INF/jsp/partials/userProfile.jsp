<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">用户管理</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-info">
                <!-- /.panel-heading -->
                <div class="panel-heading">
                                        用户操作
                </div>
                <jsp:include page ="/WEB-INF/jsp/partials/profile_partials/${userProfilePage}" flush="true"/>

                <div class="panel-footer">
                    <a href="userProfile/selectUser.html" class="btn btn-outline btn-info">查看现有用户</a>
                    <a href="userProfile/insertUser.html" class="btn btn-outline btn-success">添加新用户</a>
                    <a href="userProfile/updateUser.html" class="btn btn-outline btn-warning">修改用户密码</a>
                    <a href="userProfile/deleteUser.html" class="btn btn-outline btn-danger">删除用户</a>
                </div>
            </div>
            <!-- /.panel -->
        </div>
        <!-- col-lg-6 -->
    </div>
</div>