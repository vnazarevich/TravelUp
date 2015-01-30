<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="create-portfolio">

		<div class="widget hotel-type-filter-widget">
		<form id="cteate-portfolio-form" action="createportfolio" method="post" enctype="multipart/form-data">
			<ul>
				<li><h3>Who can you be:</h3><li>
				<li><input type="checkbox" name="photographer"><label>photographrer</label></li>
				<li><input type="checkbox" name="guide"><label>guide</label></li>
				<li><input type="checkbox" name="transporter"><label>transporter</label></li>
			</ul>
			<h3>Describe your abilities, leave contacts:</h3>
			<textarea class="form-control" form="cteate-portfolio-form" name="description" rows="5" style="resize:vertical;"></textarea>
			<h3>Add images:</h3>
			<div id="images-root">
				<div id="add-file">
					<img src="images/add-file.png" style="cursor:pointer;width:140px;height:140px;"/>
				</div>
			<br>
			</div>
			<br>
			<div class="form-group">
			<button type="submit" id=submitPortfolio class="btn btn-lg btn-success center-block green">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				Create
			</button>
			</div>
		</form>
			</div>
</div>
<script type="text/javascript">
var files=1;
function readURL(input) {
	console.log('changed');
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        	var file=$(input).val();
        	var extension=file.split('.').pop().toLowerCase();
        	if(extension.match(/(jpg|jpeg|png|gif|bmp)$/)){
	            $('#lastimage').attr('src', e.target.result);
	            $("#lastimage").removeAttr('id');
	            $("#lastinput").removeAttr("id");
        	}else{
        		$(input).parent().remove();
        	}
        }
        files++;
        reader.readAsDataURL(input.files[0]);
    }

}
function removeImage(mask){
	files--;
	$(mask).parent().remove();
}

function loadFile(){
	$("#lastinput").trigger('click');
}

$(function(){
		$("#add-file").click(function(e) {
			$('<div class="view third-effect" ><input type="file" onchange="readURL(this);" name="file'+files+'" id="lastinput" style="display:none" accept="image/*"><img src="" id="lastimage" style="cursor:pointer;height:140px;"/> <div class="mask" onclick="removeImage(this);"><a class="info" title="Remove">Remove</a></div></div>').insertBefore(this);
			loadFile();
		});

});
</script>