<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div id="portfolio">
		<c:choose>
			<c:when test="${sessionScope.user.getPortfolio()!=null}">
				dklajf
			</c:when>
			<c:otherwise>
				<button id=createBtn class="btn btn-lg btn-success center-block">

				<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
				Create portfolio
				</button>

			</c:otherwise>
		</c:choose>
	</div>
	<script>
		$(function(){
			$("#createBtn").click(function(e){
				$(this).remove();
				$("#portfolio").load('pages/createPortfolio.jsp');
			});
		});
	</script>