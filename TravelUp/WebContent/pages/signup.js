function check(element,value){
	console.log("check");
	 // var element = $(this).attr("name");
  	 // var value = $(this).val();
  	  var answer="";
  	  console.log(element);
  	  $.ajaxSetup({async: false});
  	  $.post('verifyuser',{attr:element,value:value} ,function(responseText) {
            answer=responseText;
            console.log("Answer: "+answer);
        });
  	  return answer;
}

$(function(){
	console.log("Doc ready")
  $(".form-control").val("");

  $("#login").blur(function(e){
	  console.log("login blur");
	  var element = $(this).attr("name");
	  var value = $(this).val();
	var answer=check(element,value);
	if(answer=="error"){
		console.log(answer);
		var message="${sessionScope.lang.getString('auth.message.wrong-login')}";
		$("#login-label").html(message);
	}
  });



  $('#register-form').submit(function() {
      var flag=true;
	  $(".error-label").each(function(index) {

		    if($(this).html()!=""){
		    	flag=false;
		    	return false;
		    }
	  });

      return flag;
  })



});