<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<c:if test="${ edit == false }">
		<title><s:message code="title.register.registration" /></title>
	</c:if>
	<c:if test="${ edit == true }">
		<title><s:message code="title.register.editinfo" /></title>
	</c:if>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
	
	<style type="text/css">
		body {
		     background: url('https://static-communitytable.parade.com/wp-content/uploads/2014/03/rethink-target-heart-rate-number-ftr.jpg') fixed;
		    background-size: cover;
		}
		
		*[role="form"] {
		    max-width: 550px;
		    padding: 15px;
		    margin: 0 auto;
		    border-radius: 0.3em;
		    background-color: #f2f2f2;
		}
		
		*[role="form"] h2 { 
		    font-family: 'Open Sans' , sans-serif;
		    font-size: 40px;
		    font-weight: 600;
		    color: #000000;
		    margin-top: 5%;
		    text-align: center;
		    text-transform: uppercase;
		    letter-spacing: 4px;
		}
		.error{
         color: red;
      }
	</style>
</head>
<body>
	<c:set var="rootName" value="${ pageContext.servletContext.contextPath }" />
	<div class="container">
	<a href="${ rootName }/">
		 <s:message code="title.backtohome" />
	</a>
	    <form:form class="form-horizontal" name="f" modelAttribute="newUser" action="${ rootName }/sign-up/register" method="POST" role="form">
	    		<c:if test="${ edit == false }">
		        <h2><s:message code="title.register.registration" /></h2>	        
	        </c:if>
	        <c:if test="${ edit == true }">
		        <h2><s:message code="title.register.editinfo" /></h2>	        
	        </c:if>
	        ${ message }
	        <div class="form-group">
	        		<spring:bind path="firstName">
		            <label for="firstName" class="col-sm-3 control-label"><s:message code="title.register.firstname" /></label>
		            <div class="col-sm-9">
		            		<form:input path="userId" type="hidden" />
		                <form:input type="text" path="firstName" placeholder="First Name" class="form-control" />
		                <form:errors path="firstName" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
		        <spring:bind path="lastName">
		            <label for="lastName" class="col-sm-3 control-label"><s:message code="title.register.lastname" /></label>
		            <div class="col-sm-9">
		                <form:input type="text" path="lastName" placeholder="Last Name" class="form-control" />
		                <form:errors path="lastName" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
		        <spring:bind path="email">
		            <label for="email" class="col-sm-3 control-label">Email </label>
		            <div class="col-sm-9">
		                <form:input type="email" path="email" placeholder="Email" class="form-control" name= "email" />
		                <form:errors path="email" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
		        <spring:bind path="password">
		            <label for="password" class="col-sm-3 control-label"><s:message code="title.register.password" /></label>
		            <div class="col-sm-9">
		                <form:input type="password" path="password" placeholder="Password" value="" class="form-control" />
		                <form:errors path="password" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
		        <spring:bind path="password">
		            <label for="password" class="col-sm-3 control-label"><s:message code="title.register.confirmpassword" /></label>
		            <div class="col-sm-9">
		                <form:input type="password" path="confirmPassword" placeholder="Confirm Password" class="form-control" />
		                <form:errors path="confirmPassword" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
		        <spring:bind path="birthday">
		            <label for="birthDate" class="col-sm-3 control-label"><s:message code="title.register.birthday" /></label>
		            <div class="col-sm-9">
		                <form:input type="date" path="birthday" class="form-control" />
		                <form:errors path="birthday" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
	        		<spring:bind path="phoneNumber">
		            <label for="phoneNumber" class="col-sm-3 control-label"><s:message code="title.register.phonenumber" /></label>
		            <div class="col-sm-9">
		                <form:input type="phoneNumber" path="phoneNumber" placeholder="Phone number" class="form-control" />
		                <form:errors path="phoneNumber" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        <div class="form-group">
	        		<spring:bind path="address">
		            <label for="address" class="col-sm-3 control-label"><s:message code="title.register.address" /></label>
		            <div class="col-sm-9">
		                <form:input type="text" path="address" placeholder="Address" class="form-control" />
		                <form:errors path="address" cssClass="error" />
		            </div>
	            </spring:bind>
	        </div>
	        
	        <!-- <div class="form-group">
	                <label for="Height" class="col-sm-3 control-label">Height* </label>
	            <div class="col-sm-9">
	                <input type="number" id="height" placeholder="Please write your height in centimetres" class="form-control">
	            </div>
	        </div>
	         <div class="form-group">
	                <label for="weight" class="col-sm-3 control-label">Weight* </label>
	            <div class="col-sm-9">
	                <input type="number" id="weight" placeholder="Please write your weight in kilograms" class="form-control">
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="control-label col-sm-3">Gender</label>
	            <div class="col-sm-6">
	                <div class="row">
	                    <div class="col-sm-4">
	                        <label class="radio-inline">
	                            <input type="radio" id="femaleRadio" value="Female">Female
	                        </label>
	                    </div>
	                    <div class="col-sm-4">
	                        <label class="radio-inline">
	                            <input type="radio" id="maleRadio" value="Male">Male
	                        </label>
	                    </div>
	                </div>
	            </div>
	        </div> /.form-group -->
	        <!-- <div class="form-group">
	            <div class="col-sm-9 col-sm-offset-3">
	                <span class="help-block">*Required fields</span>
	            </div>
	        </div> -->
	        <button type="submit" class="btn btn-primary btn-block"><s:message code="title.register.submit" /></button>
	    </form:form> <!-- /form -->
	</div> <!-- ./container -->
</body>
</html>