<jsp:include page="html/header.jsp" />
<jsp:include page="html/navbar_registered.jsp" />

<script type="text/javascript">form_upload_software();</script>
<script type="text/javascript">form_upload_rapport();</script>

<form method="post" action="Reman/file/upload" enctype="multipart/form-data" class="upload_form">
    <div class="container"> <br />
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading"><strong>Upload files</strong></div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="form-group col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-pencil color-blue"></i></span>
                                    <input id="software_name" name="software_name" placeholder="Software name" class="form-control" type="text" required>
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-bookmark color-blue"></i></span>
                                    <input id="software_version" name="software_version" placeholder="Software version" class="form-control" type="text" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-5 col-md-offset-1">
                                <div class="input-large">
                                    <select class="form-control" name="team">
                                        <option value="">Software qualified</option>
                                        <option value="no">No</option>
                                        <option value="yes">Yes</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <div class="input-large">
                                    <select class="form-control" name="team">
                                        <option value="">Software status</option>
                                        <option value="stable">Stable</option>
                                        <option value="alpha">Alpha</option>
                                        <option value="beta">Beta</option>
                                        <option value="debug">Debug</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-10 col-md-offset-1">
                                    <div class="input-group">
                                        <input placeholder="Rapport of qualification" type="text" class="form-control filename_rapport" disabled>
                                        <span class="input-group-btn">
                                        <div class="btn btn-default file_input_rapport"> <span class="glyphicon glyphicon-folder-open"></span>
                                            <span class="file_input_title"> Browse</span>
                                            <input type="file" name="file" accept=".rar,.zip,.7z,.jar"/>
                                        </div>
                                    </span>
                                    </div>
                                </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-10 col-md-offset-1">
                                <div class="input-group">
                                    <input placeholder="Name of Uploaded File" type="text" class="form-control filename_software" disabled>
                                    <span class="input-group-btn">
                                        <div class="btn btn-default file_input_software"> <span class="glyphicon glyphicon-folder-open"></span>
                                            <span class="file_input_title"> Browse</span>
                                            <input type="file" name="file" id="file" accept=".rar,.zip,.7z,.jar"/>
                                        </div>
                                        <button type="submit" class="btn btn-labeled btn-primary">
                                            <span class="btn-label"><i class="glyphicon glyphicon-upload"></i></span> Upload</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<jsp:include page="html/footer.jsp" />