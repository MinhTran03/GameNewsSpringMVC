<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>
		<s:message code="title.confirmemail" />
	</title>
	<link rel="stylesheet" href="<c:url value="/lib/css/app.css" />" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<base href="${ pageContext.servletContext.contextPath }/" />
</head>
<body class="h-100 my-color">
	<main class="container h-100">
		<div class="row justify-content-center align-image-center">
			<div class="col-md-4">
				<div class="row justify-content-center align-image-center">
					<a href="${pageContext.request.contextPath}/">
						<img width="300" height="200px"
							src="http://pluspng.com/img-png/avengers-logo-png-avengers-transparent-background-1107.png"
							alt="avenger" />
					</a>
				</div>
				<div class="row justify-content-center align-image-center">
					<strong class="title mb-3"><s:message code="title.resetpw" /></strong>
				</div>
				<c:if test="${ regis == false }">
					<div class="col border forget-password">
						<div class="container forget-password">
							<form class="p-1" action="change-pass" method="post">
								<div class="form-group">
									<label class="email" for="code">
										<s:message code="title.entercode" />:</label>
									<input class="form-control" aria-describedby="codeHelp" name="privateCode" id="code" type="text"
										placeholder="Enter code">
									<span>${ errorCode }<span>
								</div>
								<button type="submit" class="btn btn-primary btn-block mb-3">
									<s:message code="title.confirm" /></button>
							</form>
						</div>
					</div>
				</c:if>
				<c:if test="${ regis != false }">
					<div class="col border forget-password">
						<div class="container forget-password">
							<form class="p-1" action="/GameNews/sign-up/confirm-email" method="post">
								<div class="form-group">
									<label class="email" for="code">
										<s:message code="title.entercode" />:</label>
									<input class="form-control" aria-describedby="codeHelp" name="privateCode" id="code" type="text"
										placeholder="Enter code">
									<span>${ errorCode }<span>
								</div>
								<button type="submit" class="btn btn-primary btn-block mb-3">
									<s:message code="title.confirm" /></button>
							</form>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</main>
</body>

</html>