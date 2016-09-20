<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--插入操作--%>

    <!-- /.panel-body -->
    <div class="panel-body">
        <form:form modelAttribute="insertForm" name="insertForm" action="userProfile/insertUser.html" method="post">
            <div class="form-group">
            
                <label>请输入新用户名</label>
                <form:input path="userName" class="form-control"/>

                <label>请输入新密码</label>
                <label class="control-label" for="Pwd1">密码不能为空</label>
                <input id="Pwd1" name="insertPwd" type="password" class="form-control"
                       onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>

                <label>请再次输入新密码</label>
                <label class="control-label" for="Pwd2">两次输入密码必须一致</label>
                <form:input id="Pwd2" path="userPassword" name="insertPwdConfirm"  type="password" class="form-control"
                            onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
            </div>
            <input type="submit" class="btn btn-outline btn-primary" value="确定">
        </form:form>
    </div>
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
                    $(".btn-primary").removeClass("disabled");
                    $(".form-group").removeClass("has-error")
                }
            });
            $("form").submit(function (event) {
                if(has_error1 || has_error2) {
                    if(event.preventDefault) 
                    	event.preventDefault();
                    else 
                    	event.returnValue = false;
                }
            });
        });
    </script>
