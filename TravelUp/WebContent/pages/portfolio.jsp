<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div id="portfolio">
		<c:choose>
			<c:when test="${sessionScope.user.getPortfolio()!=null}">
				<jsp:include page="/pages/showPortfolio.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="/pages/createPortfolio.jsp"/>
				<button id=createBtn class="btn btn-lg btn-success center-block green">

				<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
				Create portfolio
				</button>

			</c:otherwise>
		</c:choose>
	</div>
	<script>
		$(function(){
			$("#create-portfolio").hide();
			$("#createBtn").click(function(e){
				$(this).remove();
				$("#create-portfolio").show();
			});
		});
	</script>