<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="edit-portfolio">
<c:set var="portfolio" scope="session" value="${user.getPortfolio()}"/>
		<h3>
		<button id="occupation-edit-btn" type="button" class="btn btn-default" aria-label="Left Align">
					  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
		</button>
		<button id="occupation-confirm-btn" type="button" class="btn btn-default" style="display:none;" aria-label="Left Align">
					  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
		</button>
		My occupation:</h3>
		<div class="widget hotel-type-filter-widget" id="occupation-edit-list" style="display:none;">
			<ul  >
					<li><input type="checkbox" name="photorgapher"><label>photographrer</label></li>
					<li><input type="checkbox" name="guide"><label>guide</label></li>
					<li><input type="checkbox" name="transporter"><label>transporter</label></li>
			</ul>
		</div>
		<h3>

		<ul id="occupation-list" >
				<c:if test="${portfolio.isPhotographer()}">
					<li><h4><span class="glyphicon glyphicon-camera" aria-hidden="true"></span> photographrer</h4></li>
				</c:if>
				<c:if test="${portfolio.isGuide()}">
					<li><h4><span class="glyphicon glyphicon-flag" aria-hidden="true"></span> guide</h4></li>
				</c:if>
				<c:if test="${portfolio.isCarrier()}">
					<li><h4><span class="glyphicon glyphicon-road" aria-hidden="true"></span> transporter</h4></li>
				</c:if>
		</ul>
		<button id="about-edit-btn" type="button" class="btn btn-default" aria-label="Left Align">
					  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
		</button>
		<button id="about-confirm-btn" type="button" class="btn btn-default" style="display:none;" aria-label="Left Align">
					  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
		</button>
		About me:</h3>
		<p>${portfolio.getDescription()}</p>
		<br>
		 <ul class="row user-gallery">
		 <c:forEach var="userPhoto" items="${userPhotos}">
          <li class="col-lg-4 col-md-4 col-sm-6 col-xs-9"><img src="${initParam['imagesPath']}${userPhoto.getPhotolink()}"/></li>
			</c:forEach>
          </ul>


          <div class="modal fade autoModal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		      <div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-body">
		          </div>
		        </div><!-- /.modal-content -->
		      </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->
</div>
<script>
	$(function(){
		$("#occupation-edit-btn").click(function(e){
			$(this).hide();
			$("#occupation-list").hide();
			$("#occupation-confirm-btn").show();
			$("#occupation-edit-list").show();
		});
		$('ul.user-gallery li img').on('click',function(){
            var src = $(this).attr('src');
            var img = '<img src="' + src + '" class="img-responsive"/>';
            $('#myModal').modal();
            $('#myModal').on('shown.bs.modal', function(){
                $('#myModal .modal-body').html(img);
            });
            $('#myModal').on('hidden.bs.modal', function(){
                $('#myModal .modal-body').html('');
            });
       });
	});
</script>

