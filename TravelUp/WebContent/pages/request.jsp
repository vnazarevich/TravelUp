<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="/vendor/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
	<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
	<script src="//oss.maxcdn.com/momentjs/2.8.2/moment.min.js"></script>
	<script src="/vendor/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<style type="text/css">
	#datetimeForm .has-feedback .form-control-feedback {
	    top: 0;
	    right: -15px;
	}
	</style>
	
	<title>Insert title here</title>
</head>
<body>
<b>
<b><big>            Tour request</big></b>
	<form id="containerForm" class="form-horizontal">
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter group capacity </label>
        <div class="col-xs-1">
            <input type="text" class="form-control" name="minCapas" placeholder="min" />
        </div>
        <div class="col-xs-1">
            <input type="text" class="form-control" name="maxCapas" placeholder="max" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter tour duration in days:</label>
        <div class="col-xs-1">
            <input type="text" class="form-control" name="minDuration" placeholder="min" />
        </div>
        <div class="col-xs-1">
            <input type="text" class="form-control" name="maxDuration" placeholder="max" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter max price by tour (uah):</label>
        <div class="col-xs-2">
            <input type="text" class="form-control" name="maxPrice"  />
        </div>
    </div>
</form>
<script src="//oss.maxcdn.com/momentjs/2.8.2/moment.min.js"></script>
<script src="/vendor/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

<form id="datetimeForm" class="form-horizontal">
    <div class="form-group">
        <label class="col-xs-3 control-label">DateTime Picker</label>
        <div class="col-xs-2">
            <div class="input-group date" id="datetimePicker">
                <input type="text" class="form-control" name="datetimePicker" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
</form>

<script>
$(document).ready(function() {
    $('#datetimePicker').datetimepicker();

    $('#datetimeForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            datetimePicker: {
                validators: {
                    notEmpty: {
                        message: 'The date is required and cannot be empty'
                    },
                    date: {
                        format: 'MM/DD/YYYY h:m A'
                    }
                }
            }
        }
    });

    $('#datetimePicker')
        .on('dp.change dp.show', function (e) {
            // Revalidate the date when user change it
            $('#datetimeForm').formValidation('revalidateField', 'datetimePicker');
        });
});
</script>
</body>
<script>
$(document).ready(function() {
    $('#containerForm').formValidation({
        framework: 'bootstrap',
        err: {
            container: 'tooltip'
        },
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	minCapas: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
            maxCapas: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            minDuration: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
            maxDuration: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            maxPrice: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            phone: {
                validators: {
                    digits: {
                        message: 'The phone number can contain digits only'
                    },
                    notEmpty: {
                        message: 'The phone number is required'
                    }
                }
            }
        }
    });
});
</script>

</html>