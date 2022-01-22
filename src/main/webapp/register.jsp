<!DOCTYPE html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>register</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <link href="assets/css/style.css" rel="stylesheet">

</head>

<body class="h-100">
    <div class="authincation h-100">
        <div class="container-fluid h-100">
            <div class="row justify-content-center h-100 align-items-center">
                <div class="col-md-6">
                    <div class="authincation-content">
                        <div class="row no-gutters">
                            <div class="col-xl-12">
                                <div class="auth-form">
                                    <h4 class="text-center mb-4">Sign up your account</h4>
                                    <form id="form1" action = "login.jsp">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label><strong>first name</strong></label>
                                            <input type="text" class="form-control" placeholder="username" id="firstName">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label><strong>last name</strong></label>
                                            <input type="text" class="form-control" placeholder="username" id="lastName">
                                        </div>
                                        </div>
                                        <div class="form-row">
                                        <div class="form-group col-md-6 ">
                                            <label><strong>Email</strong></label>
                                            <input type="email" class="form-control" placeholder="hello@example.com" id="mail">
                                        </div>
                                        <div class="form-group col-md-6 ">
                                            <label><strong>Phone number</strong></label>
                                            <input type="text" class="form-control" placeholder="0648791658" id="phone">
                                        </div>
                                        </div>
                                          <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label><strong>Password</strong></label>
                                            <input type="password" class="form-control" placeholder="Password" id="password">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label><strong> Confirm Password</strong></label>
                                            <input type="password" class="form-control" placeholder="Password" id="ConfirmPassword">
                                        </div>
                                        </div>
                                        <div class="text-center mt-4">
                                            <button type="submit" class="btn btn-primary btn-block" id="signup"  >Sign me up</button>
                                        </div>
                                    </form>
                                    <div class="new-account mt-3">
                                        <p>Already have an account? <a class="text-primary" href="login.jsp">Sign in</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    

    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="assets/vendor/global/global.min.js"></script>
    <script src="assets/js/quixnav-init.js"></script>
    <script src="scriptjs/scripts.js" type="text/javascript"></script>
    <!--endRemoveIf(production)-->
</body>


</html>