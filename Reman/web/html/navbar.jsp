<nav class="navbar navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="padding-left: 120px" href="../index.jsp">Reman</a>
        </div>
        <!-- Menu button -->
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="../index.jsp">Home</a></li>
                <li><a href="#">Lastest Version</a></li>
                <li><a href="#">All</a></li>
            </ul>
            <!-- Window login -->
            <ul class="nav navbar-nav navbar-right" style="padding-right: 30px">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login <b class="caret"></b></a>
                    <ul class="dropdown-menu" style="padding: 15px;min-width: 280px;">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form" role="form" method="post" action="Reman/user/login" accept-charset="UTF-8" id="login-nav">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                                <input name="username" id="CUID" placeholder="CUID" class="form-control text-uppercase" type="text" required="true" minlength="8" maxlength="8" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                                                <input name="password" id="passwordInput" placeholder="Password" class="form-control" type="password" oninvalid="setCustomValidity('Enter a password!')" onchange="try{setCustomValidity('')}catch(e){}" required="">
                                            </div>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Remember me
                                            </label>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <button type="submit" class="btn btn-custom btn-block">Login</button>
                                            <p class="help-block" style="margin-top: 5px">Forgot your password ? <a href="javascript:;" data-toggle="modal" data-target="#forgot_password_Modal">Get it</a></p>
                                            <p class="text-center text-muted h4"> or </p>
                                            <a href="../register.jsp" class="btn btn-warning btn-block">Registration</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Input Search -->
            <form class="navbar-form navbar-right" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="q">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<form id="forgotten_password_form" class="forgotten-password-form" action="" autocomplete="off" method="POST" >
<div class="modal fade" id="forgot_password_Modal" tabindex="-1" role="dialog" aria-labelledby="forgot_Password_Modal_Label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content login-modal">
            <div class="modal-header login-modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="forgot_Password_Modal_Label">Forgotten Password</h4>
            </div>
            <div class="modal-body">
                    <p>If you have forgotten your password you can reset it here.</p>
                    <fieldset>
                        <div class="row">
                            <div class="form-group" style="padding: 5px 50px;">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                    <input id="email" name="email" placeholder="Email address" class="form-control" type="email" required>
                                </div>
                            </div>
                        </div>
                            <div class="form-group" style="padding: 5px 50px;">
                                <button type="submit" class="btn btn-custom btn-block">Reset Password</button>
                            </div>
                    </fieldset>
                </div>
        </div>
    </div>
</div>
</form>

<script type="text/javascript">
    $(document).ready(function() {
        $('#forgotten_password_form').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },

            fields: {
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply your email address'
                        },
                        emailAddress: {
                            message: 'Please supply a valid email address'
                        }
                    }
                },
            }
        })
    });
</script>
