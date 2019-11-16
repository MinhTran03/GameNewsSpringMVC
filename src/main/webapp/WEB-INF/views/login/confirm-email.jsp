<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<jsp:include page="../import/importHeader.jsp"></jsp:include>
	<base href="${ pageContext.servletContext.contextPath }/" />
</head>
<body>
	Nhập code của bạn
	<input id="code" type="text">
	${ errorCode }
	<a id="lnk" href="sign-up/confirm-email?privateCode=">Confirm</a>
	
	<script type="text/javascript">
		document.getElementById('lnk').onclick = function(event){
			let code = document.getElementById('code').value;
			event.target.href += code;
		}
	</script>
</body>
</html>