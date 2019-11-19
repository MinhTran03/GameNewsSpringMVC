<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>${ message }</title>
	
	<script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

	<!-- Custom Theme files -->
	<link href="<c:url value="/lib/login/css/style.css" />" rel="stylesheet" type="text/css" media="all" />
	<link href="<c:url value="/lib/login/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
	<!-- //web font -->
	
	<base href="${ pageContext.servletContext.contextPath }/" />
	<style>
      .error{
         color: red;
      }
   </style>
</head>
<body>
	<c:set var="rootName" value="${ pageContext.request.contextPath }"></c:set>
	<div class="w3layouts-main">
	<div class="bg-layer">
	<a href="${ rootName }/" style="margin-left: 200px !important">
		 <s:message code="title.backtohome" />
	</a>
		<h1><s:message code="title.loginform" /></h1>
			
			<div class="header-main">
				<div class="main-icon">
					<span class="fa fa-eercast"></span>
				</div>
				<div class="header-left-bottom">
					${ message }
					<form:form name="f" modelAttribute="userLogin" action="login" method="POST">
						<div class="icon1">
							<s:message code="title.emailaddress" var="emailaddr"/>
							<spring:bind path="email">
								<span class="fa fa-user"></span>
								<form:input path="email" type="email" placeholder="${ emailaddr }" required=""/>
								<form:errors path="email" cssClass="error" />
							</spring:bind>
						</div>
						<div class="icon1">
							<s:message code="title.register.password" var="pwd"/>
							<spring:bind path="password">
								<span class="fa fa-lock"></span>
								<form:input path="password" type="password" placeholder="${ pwd }" required=""/>
								<form:errors path="password" cssClass="error" />
							</spring:bind>
						</div>
						<div class="login-check">
							 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i><s:message code="title.savepassword" /></label>
						</div>
						<div class="bottom">
							<button class="btn"><s:message code="title.login" /></button>
						</div>
						<div class="links">
							<p><a href="#"><s:message code="title.forgetpass" /></a></p>
							<p class="right"><a href="${ rootName }/sign-up/"><s:message code="title.newuser" /></a></p>
							<div class="clear"></div>
						</div>
					</form:form>	
				</div>
				<div class="social">
					<ul>
						<li><s:message code="title.loginwith" /> : </li>
						<li><a href="#" class="facebook"><span class="fa fa-facebook"></span></a></li>
						<li><a href="#" class="twitter"><span class="fa fa-twitter"></span></a></li>
						<li><a href="#" class="google"><span class="fa fa-google-plus"></span></a></li>
					</ul>
				</div>
			</div>
			
		<!-- copyright -->
		<div class="copyright">
			<p>© 2019 Slide Login Form . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
		</div>
		<!-- //copyright --> 
	</div>
</div>	

</body>
</html>