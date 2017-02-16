<jsp:include page="html/header.jsp" />
<jsp:include page="html/navbar.jsp" />

<div class="container_registrer">
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Registration Form</strong>
                    <br>Please fill in the form below.
                </div>
                <div class="panel-body">
                    <form id="register_form" class="register-form" action="Reman/register/new" autocomplete="off" method="POST" style="padding-left: 15px; padding-right: 15px;">
                        <div class="row">
                            <div class="form-group col-md-6" style="padding-left: 0; padding-right: 15px;">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                    <input id="firstname" name="firstname" placeholder="First name" class="form-control" type="text" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                    <input id="lastname" name="lastname" placeholder="Last name" class="form-control" type="text" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6" style="padding-left: 0; padding-right: 15px;">
                                <select title="group selection" class="form-control" name="team">
                                    <option value="">Choose your team</option>
                                    <option value="Reader">Reader</option>
                                    <option value="Card">Card</option>
                                    <option value="Mobile">Mobile</option>
                                    <option value="Test physics">Test Physics</option>
                                </select>
                            </div>
                            <div class="col-md-6" style="padding: 0;">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                        <input id="CUID" name="CUID" placeholder="CUID" class="form-control text-uppercase" type="text" minlength="8" maxlength="8" required>
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
                        <div class="col-md-4 col-md-offset-4" style="padding-right: 0;">
                            <button class="btn btn-custom btn-block" type="submit">Register</button>
                        </div>
                        <div class="col-md-4" style="padding-right: 0;">
                            <a href="index.jsp" class="btn btn-warning btn-block">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
<script type="text/javascript">form_register_validation();</script>

<jsp:include page="html/footer.jsp" />


