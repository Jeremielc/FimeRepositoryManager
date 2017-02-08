<?php require("html/header.php"); ?>
<!-- Fixed navbar -->
<?php require("html/navbar.php"); ?>

<div class="container_registrer">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1>Registration forms</h1>
                <form class="omb_loginForm" action="" autocomplete="off" method="POST">
                    <div class="input-group group-register">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                        <input id="newCUID" placeholder="CUID" class="form-control" type="text" required="true" minlength="8" maxlength="8" >
                    </div>
                    <div class="input-group group-register">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                        <input id="emailInput" placeholder="Email address" class="form-control" type="email" oninvalid="setCustomValidity('Enter a valid email address!')" onchange="try{setCustomValidity('')}catch(e){}" required="true">
                    </div>
                    <div class="input-group group-register">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                        <input id="newPassword" placeholder="Password" class="form-control" type="password" minlength="8" required="true">
                    </div>
                    <div class="input-group group-register">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                        <input id="verifyPassword" placeholder="Password" class="form-control" type="password" minlength="8" required="true">
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">Register</button></p>
                </form>
            </div>
        </div>
</div>
<?php require("html/footer.php"); ?>


