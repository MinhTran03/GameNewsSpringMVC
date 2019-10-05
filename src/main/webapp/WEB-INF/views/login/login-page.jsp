<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Slide Login Form Flat Responsive Widget Template :: w3layouts</title>
	
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

	<div class="w3layouts-main"> 
	<div class="bg-layer">
		<h1>Slide Login form</h1>
		
			<div class="header-main">
				<div class="main-icon">
					<span class="fa fa-eercast"></span>
				</div>
				<div class="header-left-bottom">
					<form:form name="f" modelAttribute="userLogin" action="login/check" method="POST">
						<div class="icon1">
							<span class="fa fa-user"></span>
							<form:input path="email" type="email" placeholder="Email Address" required=""/>
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="icon1">
							<span class="fa fa-lock"></span>
							<form:input path="password" type="password" placeholder="Password" required=""/>
							<form:errors path="password" cssClass="error" />
						</div>
						<div class="login-check">
							 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i> Keep me logged in</label>
						</div>
						<div class="bottom">
							<button class="btn">Log In</button>
						</div>
						<div class="links">
							<p><a href="#">Forgot Password?</a></p>
							<p class="right"><a href="#">New User? Register</a></p>
							<div class="clear"></div>
						</div>
					</form:form>	
				</div>
				<div class="social">
					<ul>
						<li>or login using : </li>
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