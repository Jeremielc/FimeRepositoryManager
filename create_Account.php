<?php require("html/header.php"); ?>
<!-- Fixed navbar -->
<?php require("html/navbar.php"); ?>

<div class="container_registrer">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1>Registration forms</h1>
                <form id="register_form" class="omb_loginForm" action="" autocomplete="off" method="POST" >
                    <div class="row">
                        <div class="form-group col-md-6" style="padding-left: 0px;">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                <input id="first_name" name="first_name" placeholder="First name" class="form-control" type="text" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                <input id="last_name" name="last_name" placeholder="Last name" class="form-control" type="text" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6" style="padding-left: 0px; padding-right: 15px;">
                                    <select class="form-control" name="team">
                                        <option value="">Choose your team</option>
                                        <option value="reader">Reader</option>
                                        <option value="card">Card</option>
                                        <option value="mobile">Mobile</option>
                                        <option value="test_physics">Test Physics</option>
                                    </select>
                        </div>
                        <div class="col-md-6" style="padding: 0px;">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                    <input id="CUID" name="CUID" placeholder="CUID" class="form-control text-uppercase" type="text" required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                <input id="email" name="email" placeholder="Email address" class="form-control" type="email" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                                <input id="password" name="password" placeholder="Password" class="form-control" type="password" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                                <input id="confirm_Password" name="confirm_Password" placeholder="Confirm Password" class="form-control" type="password" minlength="8" required>
                            </div>
                        </div>
                    </div>
                        <div class="col-md-4 col-md-offset-4" style="padding-right: 0px;">
                            <button class="btn btn-custom btn-block" type="submit">Register</button></p>
                        </div>
                </form>
                <div class="col-md-4" style="padding-right: 0px;">
                    <a href="index.php" class="btn btn-warning btn-block">Cancel</a>
                </div>
            </div>
        </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#register_form').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },

            fields: {
                first_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                            message: 'Minimum of 2 characters is required'
                        },
                        notEmpty: {
                            message: 'Please supply your first name'
                        }
                    }
                },
                last_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                            message: 'Minimum of 2 characters is required'
                        },
                        notEmpty: {
                            message: 'Please supply your last name'
                        }
                    }
                },
                CUID: {
                    validators: {
                        stringLength: {
                            min: 8,
                            max: 8,
                            message: '8 characters is required'
                        },
                        notEmpty: {
                            message: 'Please supply your CUID'
                        }
                    }
                },
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
                password: {
                    validators: {
                        stringLength: {
                            min: 8,
                            message: 'Minimum of 8 characters is required'
                        }
                    }
                },
                confirm_Password: {
                    validators: {
                        identical: {
                            field: 'password',
                            message: 'This password doesn\'t match'
                        }
                    }
                },
            }
        })
    });
</script>

<?php require("html/footer.php"); ?>


