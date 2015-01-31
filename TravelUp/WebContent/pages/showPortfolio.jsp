<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="show-portfolio">
<c:set var="portfolio" scope="session" value="${user.getPortfolio()}"/>
		<h3>My occupation:</h3>

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

		     <div class="modal fade autoModal" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
		      <div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-body">
		           <div class="row">
	    			<div class="span12" style="text-align: center;">
			          <h4>Are you sure, you want to delete your portfolio?</h4>
			          <button class="btn btn-md btn-success green" id="confirmDelete">
			          Yes
			          </button>
			          <button class="btn btn-md btn-link" style="vertical-align: bottom;" id="declineDelete">
			          No
			          </button>
		          	</div>
		          </div>
		          </div>
		        </div><!-- /.modal-content -->
		      </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->
		    <div class="row">
	    		<div class="span12">
					<div class="btn-toolbar" role="toolbar" aria-label="..." style="text-align: center;">
				    <button id=editPortfolioBtn class="btn btn-lg btn-success  green">

						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
						Edit portfolio
					</button>
					<button id=deletePortfolioBtn class="btn btn-lg btn-link " style="vertical-align: bottom;">
						Delete portfolio
					</button>
					</div>
				</div>
			</div>
</div>
<jsp:include page="/pages/editPortfolio.jsp"/>
<script>
	$(function(){
		$("#edit-portfolio").hide();
		$("#editPortfolioBtn").click(function(e){
			$("#edit-portfolio").show();
			$("#show-portfolio").hide();


		});

		$("#deletePortfolioBtn").click(function(e){
			$('#deleteModal').modal();
		});

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

		$('#confirmDelete').click(function(e){
			document.location.href = 'deleteportfolio';
		});

		$('#declineDelete').click(function(e){
			$('#deleteModal').modal("hide");
		});
	});
</script>

