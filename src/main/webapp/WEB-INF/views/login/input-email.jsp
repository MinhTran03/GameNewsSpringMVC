<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">

	<link rel="stylesheet" href="<c:url value="/lib/css/app.css" />">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<title>
		<s:message code="title.forgetpass" />
	</title>
	<style type="text/css">
		#error{
			color: red !important;
		}
	</style>
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
						<form class="p-1" action="forget-pass" method="post">
							<div class="form-group">
								<label class="email" for="InputEmail"><s:message code="title.resetpwn" /></label>
								<input name="email" type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp"
									placeholder="Enter email">
								<small id="error">${ errorCode }</small>
								<small id="emailHelp" class="form-text text-muted"><s:message code="title.resetpwm" /></small>
							</div>
							<button type="submit" class="btn btn-primary btn-block mb-3"><s:message code="title.submit" /></button>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
</body>

</html>