<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="<c:url value="/lib/css/app.css" />">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body class="h-100 my-color">
	<main class="container h-100">
		<div class="row justify-content-center align-image-center">
			<div class="col-md-4">
				<div class="row justify-content-center align-image-center">
					<a href="${pageContext.request.contextPath}/">
						<img width="300" height="200px"
							src="http://pluspng.com/img-png/avengers-logo-png-avengers-transparent-background-1107.png"
							alt="avenger">
					</a>
				</div>
				<div class="row justify-content-center align-image-center">
					<strong class="title mb-3"><s:message code="title.resetpw" /></strong>
				</div>
				<div class="col border forget-password">
					<div class="container forget-password">
						<c:set var="rootName" value="${ pageContext.servletContext.contextPath }" />
						<form class="p-1" action="${ rootName }/commit-pass" method="post">
							<div class="form-group">
								<label class="email" for="InputPassword"><s:message code="title.newpw" />:</label>
								<input class="form-control" id="InputPasswordConfirm" aria-describedby="passwordHelp"
									name="pass" type="password" placeholder="<s:message code="title.newpwplace" />">
							</div>
							<div class="form-group">
								<label class="email" for="InputPasswordConfirm"><s:message code="title.newpwconfirm" />:</label>
								<input class="form-control" id="InputPasswordConfirm" aria-describedby="passwordHelp"
									name="confirmPass" type="password" placeholder="<s:message code="title.newpwconfirmplace" />">
								${ errorCode }
							</div>
							<button type="submit" class="btn btn-primary btn-block mb-3"><s:message code="title.submit" /></button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>

</html>