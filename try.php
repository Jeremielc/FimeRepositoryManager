<?php require("html/header.php"); ?>
    <!-- Fixed navbar -->
<?php require("html/navbar.php"); ?>
<div class="hero-unit">
    <h1>Contact Form</h1>
    </br>
    <form method="POST" action="contact-form-submission.php" class="form-horizontal" id="contact-form">
        <div class="control-group">
            <label class="control-label" for="name">Name</label>
            <div class="controls">
                <input type="text" name="name" id="name" placeholder="Your name">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="email">Email Address</label>
            <div class="controls">
                <input type="text" name="email" id="email" placeholder="Your email address">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="subject">Subject</label>
            <div class="controls">
                <select id="subject" name="subject">
                    <option value="na" selected="">Choose One:</option>
                    <option value="service">Feedback</option>
                    <option value="suggestions">Suggestion</option>
                    <option value="support">Question</option>
                    <option value="other">Other</option>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="message">Message</label>
            <div class="controls">
                <textarea name="message" id="message" rows="8" class="span5" placeholder="The message you want to send to us."></textarea>
            </div>
        </div>
        <div class="form-actions">
            <input type="hidden" name="save" value="contact">
            <button type="submit" class="btn btn-success">Submit Message</button>
            <button type="reset" class="btn">Cancel</button>
        </div>
    </form>
</div>
<?php require("html/footer.php"); ?>
