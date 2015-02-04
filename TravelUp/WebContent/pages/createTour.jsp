<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/pages/styles.jsp" />
<jsp:include page="/pages/scripts.jsp" />
<script type="text/javascript" src="inc/jquery-ui/jquery-ui-min.js"></script>
<script type="text/javascript" src="inc/tag-it/js/tag-it.js"></script>
<link rel="stylesheet" href="inc/jquery-ui/jquery-ui-min.css"/>
<link rel="stylesheet" href="inc/tag-it/css/jquery.tagit.css"/>
<title>Users</title>
</head>
<body>
	<div id="preloader">
		<div id="status">&nbsp;</div>
		<noscript>JavaScript is off. Please enable to view full
			site.</noscript>
	</div>
	<c:if test="${!user.isAdmin()}">
					<c:redirect url="/error"/>
	</c:if>
	<div id="site">
		<jsp:include page="/pages/header.jsp" />
		<jsp:include page="/pages/loginBox.jsp" />
		<section class="page-head-holder">
		<div class="container">
			<div class="col-xs-6">
				<h2>My page</h2>
			</div>
			<div class="col-xs-6">
				<div class="breadcrumb-holder">
					<ol class="breadcrumb">
						<li><a href="index">Home</a></li>
						<li class="active"><a href="">MyPage</a></li>
					</ol>
				</div>
			</div>
		</div>
		</section>
		<section id="user-info" class="section wide-fat page">
		<div class="container">
			<form id="tour-form"  method="post" action="submittour">
			<div id="names">
			<div class="row form-group">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<h3>English name:</h3>
					<input type="text" class="form-control" name="enName" required>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<h3>Ukrainian name:</h3>
					<input type="text" class="form-control" name="uaName" required>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<h3>Start date:</h3>
					<input class="traveline_date_input form-control" type="text" name="startDate" placeholder="${lang.getString('tourpage.filters.date.value')}" />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<h3>End date:</h3>
					<input class="traveline_date_input form-control" type="text" name="endDate" placeholder="${lang.getString('tourpage.filters.date.value')}" />
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
				<h3>Places:</h3>
				<ul id="myTags">
				</ul>
				</div>

				<div class="col-md-4 col-sm-4 col-xs-12 userInput" class="userLogin">
				<input type="hidden" name="guide" id="guide">
				<h3>Select guide:</h3>
				<div class="ui-widget">
					<select class="combobox">
					<option value="">Select one...</option>
					<c:forEach items="${guides}" var="guide">
				      <option value="${guide.login}">${guide.login}</option>
				    </c:forEach>
					</select>
					</div>
				</div>

				<div class="col-md-4 col-sm-4 col-xs-12 userInput">
				<input type="hidden" name="photographer" id="photographer" class="userLogin">
				<h3>Select photographer:</h3>
				<div class="ui-widget">
					<select class="combobox">
					<option value="">Select one...</option>
					<c:forEach items="${photographers}" var="photographer">
				      <option value="${photographer.login}">${photographer.login}</option>
				    </c:forEach>
					</select>
					</div>
				</div>

				<div class="col-md-4 col-sm-4 col-xs-12 userInput">
				<input type="hidden" name="transporter" id="transporter" class="userLogin">
				<h3>Select transporter:</h3>
				<div class="ui-widget">
					<select class="combobox">
					<option value="">Select one...</option>
					<c:forEach items="${transporters}" var="transporter">
				      <option value="${transporter.login}">${transporter.login}</option>
				    </c:forEach>
					</select>
					</div>
				</div>

				<div class="col-md-2 col-sm-6 col-xs-12 form-inline">
				<h3>Price:</h3>
				<input type="text" name="price" placeholder="UAH" class="form-control" onkeypress="validate(event)" required>
				</div>
				<div class="col-md-2 col-sm-6 col-xs-12 form-inline">
				<h3>Capacity:</h3>
				<input type="text" name="capacity" placeholder="people" class="form-control" onkeypress="validate(event)">
				</div>

				<div class="col-md-2 col-sm-6 col-xs-12 form-inline">
					<h3>Lenth:</h3>
					<input type="text" name="lenth" placeholder="KM" class="form-control" onkeypress="validate(event)">
				</div>

			</div>
			<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-6">
			<h3>Reaching start point:</h3>
				<div class="radio">
					<label><input type="radio" name="trans" value="by-foot" checked="checked">by foot</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="trans" value="train">by train</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="trans" value="bus">by bus</label>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 col-xs-6">
			<h3>Region:</h3>
				<div class="radio">
					<label><input type="radio" name="region" value="Carpathians" checked="checked">Carpathians</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="region" value="Crimea">Crimea</label>
				</div>
			</div>
			</div>

			<div class="row">
				<button type="submit" id=editPortfolioBtn class="btn btn-lg btn-success center-block green" required>

						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						Create tour
				</button>
			</div>
			</div>
			</form>
		</div>
		</section>
		</div>

<script>
function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  console.log(key);
	  if( !((key>=48&&key<=57)||key==8||key==9||(key>=37&&key<=40))) {

	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
$(function(){
	var places = new Array();

    <c:forEach items="${places}" var="place">
       places.push("${place.info.uaName}");
       places.push("${place.info.enName}");
    </c:forEach>
    console.log("${places}");

    $("#myTags").tagit({
        availableTags: places,
        autocomplete: {delay: 0},
        beforeTagAdded: function(event, ui) {
            if ($.inArray(ui.tagLabel, places) == -1) {
              return false;
            }
        },
        afterTagAdded: function(event, ui) {
        	$(".text-icon").css("display","block");
        },
        fieldName: "places"
    });
});
</script>


<script>
(function( $ ) {
$.widget( "custom.combobox", {
_create: function() {
this.wrapper = $( "<span>" )
.addClass( "custom-combobox" )
.insertAfter( this.element );
this.element.hide();
this._createAutocomplete();
this._createShowAllButton();
},
_createAutocomplete: function() {
var selected = this.element.children( ":selected" ),
value = selected.val() ? selected.text() : "";
this.input = $( "<input>" )
.appendTo( this.wrapper )
.val( value )
.attr( "title", "" )
.addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
.autocomplete({
delay: 0,
minLength: 0,
source: $.proxy( this, "_source" )
})
.tooltip({
tooltipClass: "ui-state-highlight"
});
this._on( this.input, {
autocompleteselect: function( event, ui ) {
ui.item.option.selected = true;
this._trigger( "select", event, {
item: ui.item.option
});
},
autocompletechange: "_removeIfInvalid"
});
},
_createShowAllButton: function() {
var input = this.input,
wasOpen = false;
$( "<a>" )
.attr( "tabIndex", -1 )
.attr( "title", "Show All Items" )
.tooltip()
.appendTo( this.wrapper )
.button({
icons: {
primary: "ui-icon-triangle-1-s"
},
text: false
})
.removeClass( "ui-corner-all" )
.addClass( "custom-combobox-toggle ui-corner-right" )
.mousedown(function() {
wasOpen = input.autocomplete( "widget" ).is( ":visible" );
})
.click(function() {
input.focus();
// Close if already visible
if ( wasOpen ) {
return;
}
// Pass empty string as value to search for, displaying all results
input.autocomplete( "search", "" );
});
},
_source: function( request, response ) {
var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
response( this.element.children( "option" ).map(function() {
var text = $( this ).text();
if ( this.value && ( !request.term || matcher.test(text) ) )
return {
label: text,
value: text,
option: this
};
}) );
},
_removeIfInvalid: function( event, ui ) {
// Selected an item, nothing to do
if ( ui.item ) {
return;
}
// Search for a match (case-insensitive)
var value = this.input.val(),
valueLowerCase = value.toLowerCase(),
valid = false;
this.element.children( "option" ).each(function() {
if ( $( this ).text().toLowerCase() === valueLowerCase ) {
this.selected = valid = true;
return false;
}
});
// Found a match, nothing to do
if ( valid ) {
return;
}
// Remove invalid value
this.input
.val( "" )
.attr( "title", value + " didn't match any item" )
.tooltip( "open" );
this.element.val( "" );
this._delay(function() {
this.input.tooltip( "close" ).attr( "title", "" );
}, 2500 );
this.input.autocomplete( "instance" ).term = "";
},
_destroy: function() {
this.wrapper.remove();
this.element.show();
}
});
})( jQuery );
$(function() {
$( ".combobox" ).combobox( {
	select: function( event, ui ) {
    	$(this).parents(".userInput").find(".userLogin").val(ui.item.value);
	}
});

$( "#toggle" ).click(function() {
});


});
</script>
</body>
</html>