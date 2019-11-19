<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><s:message code="title.confirmemail" /></title>
	<jsp:include page="../import/importHeader.jsp"></jsp:include>
	<base href="${ pageContext.servletContext.contextPath }/" />
</head>
<body>
	<s:message code="title.entercode" />
	<input id="code" type="text">
	${ errorCode }
	<a id="lnk" href="sign-up/confirm-email?privateCode="><s:message code="title.confirm" /></a>
	
	<script type="text/javascript">
		document.getElementById('lnk').onclick = function(event){
			let code = document.getElementById('code').value;
			event.target.href += code;
		}
	</script>
</body>
</html>