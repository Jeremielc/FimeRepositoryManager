<!-- Look for word in the home page -->
function search_word() {
    jQuery(document).ready(function($){

        $('.table-condensed tr').each(function(){
            $(this).attr('data-search-term', $(this).text().toLowerCase());
        });

        $('.search').on('keyup', function(){

            var searchTerm = $(this).val().toLowerCase();

            $('.table-condensed > tbody > tr').each(function(){

                if ($(this).filter('[data-search-term *= ' + searchTerm + ']').length > 0 || searchTerm.length < 1) {
                    $(this).show();
                } else {
                    $(this).hide();
                }

            });

        });

    });
}

<!-- Check the parameter entered in the input in forgotten password form-->
function form_forgotten_password_validation() {
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
}

<!-- Check the parameter entered in the input in register form-->
function form_register_validation() {
        $(document).ready(function() {
            $('#register_form').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },

                fields: {
                    firstname: {
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
                    lastname: {
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
                    }
                }
            })
        });

}