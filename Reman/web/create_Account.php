<?php require("html/header.php"); ?>
<!-- Fixed navbar -->
<?php require("html/navbar.php"); ?>

<div class="container_registrer">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1>Registration forms</h1>
                <form class="omb_loginForm" action="" autocomplete="off" method="POST" >
                        <div class="col-md-6" style="padding-left: 0px; padding-right: 5px;">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                <input id="first_name" placeholder="First name" class="form-control" type="text" minlength="1" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                                <input id="last_name" placeholder="Last name" class="form-control" type="text" minlength="1" required>
                            </div>
                        </div>
                    <div class="form-group">
                        <div class="col-md-6" style="padding-left: 0px; padding-right: 5px;">
                            <div class="selectContainer">
                                <select class="form-control" name="team">
                                    <option value="">Choose your team</option>
                                    <option value="reader">Reader</option>
                                    <option value="card">Card</option>
                                    <option value="mobile">Mobile</option>
                                    <option value="test_physics">Test Physics</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                            <input id="new_CUID" placeholder="CUID" class="form-control" type="text" minlength="8" maxlength="8" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                            <input id="email_Input" placeholder="Email address" class="form-control" type="email" oninvalid="setCustomValidity('Enter a valid email address!')" onchange="try{setCustomValidity('')}catch(e){}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                            <input id="new_password" placeholder="Password" class="form-control" type="password" minlength="8" required>
                        </div>
                        <span class="help-block">Minimum of 8 characters</span>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                            <input id="confirm_Password" placeholder="Confirm Password" class="form-control" type="password" minlength="8" required>
                        </div>
                        <div class="help-block with-errors"></div>
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
<?php require("html/footer.php"); ?>


