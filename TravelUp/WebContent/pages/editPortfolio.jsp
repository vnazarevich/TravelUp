<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="edit-portfolio">

		<div class="widget hotel-type-filter-widget">
		<form id="edit-portfolio-form" action="editportfolio" method="post" enctype="multipart/form-data">
			<ul>
				<li><h3>Who can you be:</h3><li>
				<li><input id="photographer" type="checkbox" name="photographer"><label>photographrer</label></li>
				<li><input id="guide" type="checkbox" name="guide"><label>guide</label></li>
				<li><input id="transporter" type="checkbox" name="transporter"><label>transporter</label></li>
			</ul>
			<h3>Describe your abilities, leave contacts:</h3>
			<textarea id="description" class="form-control" form="edit-portfolio-form" name="description" rows="5" style="resize:vertical;"></textarea>
			<h3>Change your gallery:</h3>
			<div id="images-root">
				<c:forEach var="userPhoto" items="${userPhotos}">
				<div class="existing-image">
					<input type="hidden" name="photo${userPhoto.getId()}" value="exist">
					<div class="view third-effect" >
					<img src="${initParam['imagesPath']}${userPhoto.getPhotolink()}" style="cursor:pointer;height:140px;"/>
					<div class="mask" onclick="removeExistingImage(this);">
					<a class="info" title="Remove">Remove</a>
					</div>
					</div>
				</div>
				</c:forEach>
				<div id="add-file">
					<img src="images/add-file.png" style="cursor:pointer;width:140px;height:140px;"/>
				</div>
			<br>
			</div>
			<br>
			<div class="form-group">
			<button type="submit" id=submitPortfolio class="btn btn-lg btn-success center-block green">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				Save changes
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

function removeExistingImage(mask){
	$(mask).parent().parent().find("input[type='hidden']").val("deleted");
	$(mask).parent().remove();
}

function loadFile(){
	$("#lastinput").trigger('click');
}

$(function(){
	var guide = "${portfolio.isGuide()}";
	var transporter="${portfolio.isCarrier()}";
	var photographer = "${portfolio.isPhotographer()}";

	if(guide=="true"){
		$("#guide").prop("checked","true");
		$("#guide").parent().css("background-position","0px -16px");
	}
	if(transporter=="true"){
		$("#transporter").prop("checked","true");
		$("#transporter").parent().css("background-position","0px -16px");

	}

	if(photographer=="true"){
		$("#photographer").prop("checked","true");
		$("#photographer").parent().css("background-position","0px -16px");
	}

	$("#description").val("${portfolio.getDescription()}");

		$("#add-file").click(function(e) {
			$('<div class="view third-effect" ><input type="file" onchange="readURL(this);" name="file'+files+'" id="lastinput" style="display:none" accept="image/*"><img src="" id="lastimage" style="cursor:pointer;height:140px;"/> <div class="mask" onclick="removeImage(this);"><a class="info" title="Remove">Remove</a></div></div>').insertBefore(this);
			loadFile();
		});

});
</script>