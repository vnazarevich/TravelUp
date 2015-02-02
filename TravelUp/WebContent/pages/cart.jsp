<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="cart">
	<c:forEach var="order" items="${orderList}">
		<c:set var="tour" value="${order.getTourId()}"/>
                       <div class="row order">

                           <div class="content  wide">

                               <div class="inner">
                                   <div class="col-md-5 col-lg-4 no-margin-left">
                                       <a class="thumbnailz" href="#">
                                           <img src="${tour.places[0].photos[0].photolink}" alt="Your Hotel Title Here" class="responsive-image" />
                                           <span class="overlay">Details</span>
                                       </a>
                                   </div>
                                   <div class=" col-md-5 middle-column col-lg-5 no-margin">

                                       <div class="entry">

                                           <article class="entry-content select-tour">
                                           <form action="tour">
                                               <h2 class="post-title"><button type="submit" class="btn-link"><a>${tour.name.getName(lang.getLocale().getLanguage())} (<b><i>${tour.status}</i></b>)</a></button></h2>
											<input type="hidden" class="selecttour" name="selectedtour" value="${tour.id}">
										</form>

                                               <p>${lang.getString("tourpage.list.duration")}: ${tour.minDuration} ${lang.getString("tourpage.list.days")}.</p>

                                               <b>${lang.getString("tourpage.list.date")}:</b>

                                               <p>${tour.startDate} - ${tour.endDate}</p>
                                               <h5><b>Places required: </b>${order.getQuantity()}</h5>

                                           </article>





                                       </div><!-- /.entry -->
                                      </div>

                                       <div class="col-md-2 right-column col-lg-3 no-margin">
                                           <div class="right-area">
											<div class="book-holder">
							                   <span class="price">${tour.getUserCount()}/ ${tour.minCapacity} ${lang.getString("tourpage.list.people")}</span>
							                <span class="price"><span class="higlight emphasize value">${tour.minPrice} ${lang.getString("tourpage.list.money")}</span></span>

							                <c:choose>
							                <c:when test="${order.isPaid()}">
												<h4><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Tour is paid</h4>
											</c:when>
											<c:otherwise>
											<button class="button btn-block btn-success green pay-btn">
												<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>Buy now!
											</button>
											<button class="button btn-block remove-btn">
												<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Remove
											</button>
											</c:otherwise>
											</c:choose>
							                <c:set var="test1" value="${lang.getString('tourpage.list.close')}"/>
							                <c:set var="test2" value="${tour.status}"/>

							              </div>
                                        </div>
                                    </div>
                               </div>

                           </div><!-- /.content -->
							<div class="modal fade autoModal pay-modal" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
						      <div class="modal-dialog">
						        <div class="modal-content">
						          <div class="modal-body">
						           <div class="row">
					    			<div class="span12" style="text-align: center;">
							          <h4>${tour.name.getName(lang.getLocale().getLanguage())} (${tour.minPrice}${lang.getString("tourpage.list.money")})</h4>

						          	</div>
						          </div>
						          <form class="payment-form" method="POST" action="buytour">
						          		<div class="row">
						          		<div class="col-md-10 col-sm-9 col-xs-8">
							          	<div class="input-group">
							          	<span class="input-group-addon glyphicon glyphicon-credit-card" id="basic-addon2"></span>
								          	<input type="text" class="form-control" placeholder="credit card No" maxlength="12" onkeypress="validate(event)" required="required">
								          </div>
								         </div>
								         <div class="col-md-2 col-sm-3 col-xs-4">
										<input type="text" class="form-control cvv" maxlength="3" onkeypress="validate(event)" name="cvv"  placeholder="CVV" required="required">
										</div>

								          <input type="hidden" name="userId" value="${user.getId()}"/>
								          <input type="hidden" name="tourId" value="${tour.getId()}"/>
								          </div>
								          <div class="row">
											<div class="col-md-6 col-sm-6 col-xs-6">
												<input type="text" class="form-control" placeholder="Cardholder's name" required="required">
											</div>
											<div class="col-md-6 col-sm-6 col-xs-6">
												<input type="text" class="form-control" placeholder="Cardholder's surname" required="required">
											</div>

										</div>
										<div class="row">
											<div class="col-md-4 col-sm-6 col-xs-6">
												<h4>Expiration date:</h4>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-3">
												<input  type="text" name="month" class="month form-control" maxlength="2" onkeypress="validate(event)"  placeholder="MM" required="required">
											</div>
											<div class="col-md-2 col-sm-2 col-xs-3">
												<input  type="text" name="year" class="year form-control" maxlength="2" onkeypress="validate(event)"  placeholder="YY" required="required">
											</div>

										</div>

										<div class="row">
											<div class="col-md-4 col-sm-6 col-xs-6">
												<h4>Order places:</h4>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-3">
												<input  type="text" name="quantity" class="quantity form-control" maxlength="2" onkeypress="validate(event)"  placeholder="00" required="required">
											</div>

											<div class="col-md-4 col-sm-6 col-xs-12">
												<label class="payment-error" style="color:#b94a48"></label>
											</div>
										</div>
											 <div class="userCount" style="display:none">${order.getQuantity()}</div>
											 <div class="capacity" style="display:none">${tour.minCapacity}</div>
								           <button type="submit" class="btn btn-md btn-success green center-block" id="Pay">
								          	Buy now
								          </button>

							          </form>
						          </div>
						        </div><!-- /.modal-content -->
						      </div><!-- /.modal-dialog -->
						    </div><!-- /.modal -->


						     <c:if test="${!order.isPaid()}">
							 <div class="modal fade autoModal remove-modal" tabindex="-1" role="dialog"  aria-hidden="true">
						      <div class="modal-dialog">
						        <div class="modal-content">
						          <div class="modal-body">
						           <div class="row">
					    			<div class="span12" style="text-align: center;">
							          <h4>Are you sure, you want to remove the order?</h4>

								          <button class="btn btn-md btn-success green confirm-delete-order">
								          Yes
								          </button>
								          <button class="btn btn-md btn-link decline-delete-order" style="vertical-align: bottom;">
								          No
								          </button>
								          <div class="order-id" style="display:none">${order.getId()}</div>

						          	</div>
						          </div>
						          </div>
						        </div><!-- /.modal-content -->
						      </div><!-- /.modal-dialog -->
						    </div><!-- /.modal -->
                       </c:if>


                       </div><!-- /.row -->



     </c:forEach>
</div>
<script>

	function validateYear(input){
		if(input!=""){
			var year = new Date().getFullYear();
			var year2d=	String(year).substring(2);
			console.log("Current year: "+year2d);
			console.log("Input: "+input);
			if(input<year2d){
				return false;
			}
		}
		return true;
	}

	function validateMonth(input){
		if(input!=""){
			if(input>12){
				return false;
			}
		}
		return true;
	}

	function validateCVV(input){
		if(input!=""){
			if(input<100){
				return false;
			}
		}
		return true;
	}
	//digit validation
	function validate(evt) {
		  var theEvent = evt || window.event;
		  var key = theEvent.keyCode || theEvent.which;
		  console.log(key);
		  if( !((key>=48&&key<=57)||key==8||key==9||(key>=37&&key<=40))) {

		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
		  }
		}
	$(function(e){
		$(".pay-btn").click(function(e){
			$(this).parents(".order").find(".pay-modal").modal();
		});

		$(".payment-form").submit(function(){
			var year=$(this).find(".year").val();
			var month=$(this).find(".year").val();
			var cvv = $(this).find(".cvv").val();
			var orderPlaces = $(this).find(".quantity").val();
			var capacity = $(this).find(".capacity").html();
			var userCount=$(this).find(".userCount").html();
			var freePlaces=capacity-userCount;

			if(orderPlaces>freePlaces){
				$(".payment-error").html("Not enough places");
				return false;
			}

			if(validateYear(year)==false||validateMonth(month)){
				$(".payment-error").html("Wrong date format");
				return false;
			}
			if(validateCVV(cvv)==false){
				$(".payment-error").html("Wrong CVV format");
				return false;
			}



			return true;
		});

		$(".year, .month, .quantity").focus(function(e){
			$(this).parents(".payment-form").find(".payment-error").html("");
		});

		$(".remove-btn").click(function(e){
			$(this).parents(".order").find(".remove-modal").modal();


		});

		$(".confirm-delete-order").click(function(e){
			var orderId=$(this).parents(".modal").find(".order-id").html();
			$.ajaxSetup({async: false});
			 $.post('removeorder',{orderId:orderId} ,function() {
		      });
			 $(this).parents(".order").remove();
		});

		$(".decline-delete-order").click(function(e){
			$(this).parents(".modal").modal("hide");
		});
	});

</script>