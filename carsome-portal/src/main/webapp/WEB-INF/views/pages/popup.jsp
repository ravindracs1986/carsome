<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>CarSome</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="modal fade message-modal ${mainMessageType}" tabindex="-1" id="message_modal" role="dialog" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
				<div class="modal-header">
					 <c:choose>
					  <c:when test="${mainMessageType == 'success'}">
					     <button type="button" class="close" data-dismiss="modal" onclick="location.href='${pageContext.request.contextPath}/${redirectLink}'">&times;</button>
					  </c:when>
					  
					</c:choose>
					<h4 class="modal-title">
						<c:choose>
						  <c:when test="${mainMessageType == 'success'}">
						    <i class="glyphicon glyphicon-ok-sign"></i>
						 	Success
						  </c:when>
						  <c:when test="${mainMessageType == 'info'}">
						     <i class="glyphicon glyphicon-ok-sign"></i>
						 	Information
						  </c:when>
						  <c:when test="${mainMessageType == 'warning'}">
						    <i class="glyphicon glyphicon-ok-sign"></i>
						 	warning
						  </c:when>
						  <c:when test="${mainMessageType == 'danger'}">
						     <i class="glyphicon glyphicon-ok-sign"></i>
						 	Information
						  </c:when>
						  <c:otherwise>
						    ${mainPopupTitle}
						  </c:otherwise>
						</c:choose>
						</h4>
				</div>
				<div class="modal-body">
				<div id="mainMessageId">${mainMessage}</div>
				</div>
				<c:if test="${redirectLink != null or mainMessageType == 'success'}">
				   <div class="modal-footer">
				   		<c:choose>
						  <c:when test="${mainMessageType == 'confirm'}">
						    <button data-dismiss="modal" type="button" class="btn btn-default" value="No">Ok</button>
							<button type="button" class="btn btn-info" value="Yes" onclick="location.href='${pageContext.request.contextPath}/${redirectLink}'">Ok</button>
						  </c:when>
						  <c:otherwise>
						    <button type="button" class="btn btn-success" value="Ok" onclick="location.href='${pageContext.request.contextPath}/${redirectLink}'">Ok</button>
						    
						  </c:otherwise>
						</c:choose>
				   
						<%-- <button type="button" class="btn btn-info" value="Close" onclick="location.href='${pageContext.request.contextPath}/${redirectLink}'"></button> --%>
					</div>
				</c:if>
				
				
				
				
		</div>
	
	</div>
</div>
</div>

<script>
$(document).ready(function(){
   $("#message_modal").modal();
});
//made by csandreas1 for Stackoverflow
</script>

</body>
</html>