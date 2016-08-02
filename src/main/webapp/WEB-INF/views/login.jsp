<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
    <div class ="row">
        <div class="col-sm-10">

            <!-- ============== Logout and error messages ================== -->

            <div id = "messages">
                <div class="col-md-offset-4 alert hidden" role="alert">${errorMessage}</div>
                <div class="col-md-offset-4 alert hidden" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${logoutMessage}
                </div>
            </div>
            <form role="form" name="loginForm" class="form-horizontal" action="<c:url value="/j_spring_security_check" />" method="post">

                <!-- ============ username input element ================ -->

                <div class="form-group">
                    <label class="control-label col-sm-4" for="username">User Name : </label>
                    <div class="col-sm-8">
                        <input type="text" name="username" class="form-control" id="username" placeholder="Your user name here..">
                    </div>
                </div>

                <!-- ============ password input element ================ -->

                <div class="form-group">
                    <label class="control-label col-sm-4" for="password">Password : </label>
                    <div class="col-sm-8">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Your password here..">
                    </div>
                </div>

                <!-- ============ remember me checkbox ================ -->

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</label>
                        </div>
                    </div>
                </div>

                <!-- ============ submit button ================ -->

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
<script>
    $(function(){
        var errorMessage = '${errorMessage}';
        var logoutMessage = '${logoutMessage}';
        console.log("errorMessage " + errorMessage + "  "  + "logoutMessage " + logoutMessage);

        var errDiv = $("#messages").children().first();
        var logoutDiv = $("#messages").children().last();

        if(errorMessage != '') {
            errDiv.addClass("alert-danger").removeClass("hidden");
        }
        if(logoutMessage != '') {
            logoutDiv.addClass("alert-success alert-dismissible").removeClass("hidden");
        }

    });
</script>