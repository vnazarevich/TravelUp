<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="placeBox" tabindex="-1" role="dialog"  aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-body">
                            <form  method="POST" id="login-form" accept-charset="UTF-8">
                                <div class=" field-row" name="place-for-places" >
									<c:forEach var='tour' items='${tourList}'>
										<div class="tours-to-hide" id="${tour.id}">
										<h3>${tour.name.getName(lang.getLocale().getLanguage())}</h3>
											<c:forEach var='place' items='${tour.places}'>
												<c:out value='${place.type.getType(lang.getLocale().getLanguage())}'/>
												<c:out value='${place.info.getName(lang.getLocale().getLanguage())}'/> ;
											</c:forEach>
											
										</div>
									</c:forEach>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
<script>
$(function(){
	$(".path-button").click(function(e){
		var tourId = $(this).attr("value");
		$(".tours-to-hide").hide();
		$("#"+tourId).show();
	});
});
</script>