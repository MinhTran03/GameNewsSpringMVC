<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>
<body>
	<input id="pw" type="password">
	<a id="lnk" href="forget-pass/commit?email="><s:message code="title.confirm" /></a>
	
	<script type="text/javascript">
		document.getElementById('lnk').onclick = function(event){
			let code = document.getElementById('mail').value;
			event.target.href += code;
		}
	</script>
</body>
</html>