<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><s:message code="title.enteremail" /></title>
</head>
<body>
	<s:message code="title.enteremail" />
	<input id="mail" type="email">
	${ errorCode }
	<a id="lnk" href="forget-pass/commit?email="><s:message code="title.confirm" /></a>
	
	<script type="text/javascript">
		document.getElementById('lnk').onclick = function(event){
			let code = document.getElementById('mail').value;
			event.target.href += code;
		}
	</script>
</body>
</html>