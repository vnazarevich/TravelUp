<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />	
	<title>Insert title here</title>
	<jsp:include page="/pages/scripts.jsp" />
	<jsp:include page="/pages/header.jsp" />  
    <jsp:include page="/pages/styles.jsp" />
    <link rel="stylesheet" href="inc/jquery-ui/jquery-ui.min.css"/>
	<link rel="stylesheet" href="inc/tag-it/css/jquery.tagit.css"/>
	<script type="text/javascript" src="inc/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript" src="inc/tag-it/js/tag-it.js"></script>
</head>
<body>
<form action="saverequest" method="post" id="containerForm" class="form-horizontal">
	<div class="form-group">
        <label class="lead col-xs-3 control-label"><big><p>Tour request</p></big></label>	
        <label class="lead col-xs-4 control-label"> </label>	
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Select places for travel</label>
        <div class="col-md-2 col-sm-3 col-xs-4">           
				<ul id="myTags">
				</ul>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 col-sm-3 col-xs-4 control-label">Enter group capacity </label>
        <div class="col-md-1 col-sm-3 col-xs-4">
            <input type="text" class="form-control widget-title" name="minCapas" placeholder="min" />
        </div>
        <div class="col-md-1 col-sm-3 col-xs-4">
            <input type="text" class="form-control" name="maxCapas" placeholder="max" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter tour duration in days:</label>
        <div class="col-md-1 col-sm-3 col-xs-4">
            <input type="text" class="form-control" name="minDuration" placeholder="min" />
        </div>
        <div class="col-md-1 col-sm-3 col-xs-4">
            <input type="text" class="form-control" name="maxDuration" placeholder="max" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter max price by tour (uah):</label>
        <div class="col-md-2 col-sm-3 col-xs-4">
            <input type="text" class="form-control" name="maxPrice"  />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter start date:</label>
        <div class="col-md-2 col-sm-3 col-xs-4">
            <input id="check-in-date2" class="traveline_date_input form-control " type="text" name="startDate" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">Enter start date:</label>
        <div class="col-md-2 col-sm-3 col-xs-4">
            <input id="check-in-date3" class="traveline_date_input form-control" type="text" name="endDate" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label"></label>
        <div class="col-md-2 col-sm-3 col-xs-4">
       		 <input type="submit" class="btn btn-lg btn-success green" value="Send request" name="button" id="but"/>
         </div>
    </div>
    
</form>
</body>
<script>
 $(function() {
	var places = new Array();

    <c:forEach items="${places}" var="place">
       places.push("${place.info.uaName}");
       places.push("${place.info.enName}");
    </c:forEach>
    console.log(places);

    $("#myTags").tagit({
        availableTags: places,
        autocomplete: {delay: 0},
        beforeTagAdded: function(event, ui) {
            if ($.inArray(ui.tagLabel, places) == -1) {
              return false;
            }
        },
        afterTagAdded: function(event, ui) {
        	//$(".text-icon").css("display","block");
        },
        fieldName: "places"
    });
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
                        message: 'The capacity is required'
                    }
                }
            },
            maxCapas: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The capacity is required'
                    }
                }
            },
            minDuration: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The field is required'
                    }
                }
            },
            maxDuration: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The field is required'
                    }
                }
            },
            maxPrice: {
                validators: {
                	digits: {
                        message: 'This field can contain digits only'
                    },
                    notEmpty: {
                        message: 'The field is required'
                    }
                }
            }
        }
    });
});
</script>

</html>
