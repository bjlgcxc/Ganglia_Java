<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--更新用户--%>
    <!-- /.panel-body -->
    <div class="panel-body">
        <form:form modelAttribute="updateForm" name="updateForm" action="userProfile/updateUser.html" method="post">
            <div class="form-group" >
                <label>请选择要修改密码的用户</label>
                    <form:select path="userName" class="form-control">
                        <c:forEach items="${listUsers}" var="item">
                            <form:option value="${item.userName}">${item.userName}</form:option>
                        </c:forEach>
                    </form:select>
                <label>请输入旧密码</label>

                <form:input path="userPassword" type="password" class="form-control"
                            onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>

                <label>请输入新密码</label>
                <label class="control-label" for="Pwd1">密码不能为空</label>
                <input id="Pwd1" name="updatePwd" type="password" class="form-control"
                       onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>

                <label>请再次输入新密码</label>
                <label class="control-label" for="Pwd2">两次输入密码必须一致</label>
                <form:input path="newPassword" id="Pwd2" name="updatePwdConfirm" type="password"  class="form-control"
                            onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>

            </div>
            <input type="submit" class="btn btn-outline btn-primary" value="确定">
        </form:form>

        <script>
            $(document).ready(function () {
                $('label[for="Pwd1"]').hide();
                $('label[for="Pwd2"]').hide();
                var has_error1 = false,has_error2 = false;

                $("#Pwd1").change(function () {
                    if ($(this).val() == "") {
                        $(".form-group").addClass("has-error");
                        $('label[for="Pwd1"]').show();
                        $(".btn-primary").addClass("disabled");
                        has_error1 = true;
                    }else{
                        $('label[for="Pwd1"]').hide();
                        has_error1 = false;
                    }

                    if($(this).val() != $("#Pwd2").val()){
                        $(".form-group").addClass("has-error");
                        $('label[for="Pwd2"]').show();
                        $(".btn-primary").addClass("disabled");
                        has_error2 = true;
                    }else{
                        $('label[for="Pwd2"]').hide();
                        has_error2 = false;
                    }

                    if (!has_error1 && !has_error2){
                        $(".form-group").removeClass("has-error")
                    }
                });

                $("#Pwd2").change(function () {
                    if ($(this).val() != $("#Pwd1").val()) {
                        $(".form-group").addClass("has-error");
                        $('label[for="Pwd2"]').show();
                        $(".btn-primary").addClass("disabled");
                        has_error2 = true;
                    }else{
                        $('label[for="Pwd2"]').hide();
                        has_error2 = false;
                    }
                    if (!has_error1 && !has_error2){
                        $(".form-group").removeClass("has-error");
                        $(".btn-primary").removeClass("disabled");
                    }
                });

                $("form").submit(function (event) {
                    if(has_error1 || has_error2) {
                        if(event.preventDefault) event.preventDefault();
                        else event.returnValue = false;
                    }
                });

            });
        </script>
    </div>

