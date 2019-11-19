<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

<title><s:message code="title.demopost" /></title>
<jsp:include page="../import/importHeader.jsp"></jsp:include>
<style>
	figure,
	figure a img,
	.blog-content p a img,
	.ql-video{
		width: 100% !important;
	}
	
	.ql-video{
		height: 466px !important;
	}
	
	
</style>
</head>
<body>
	<!-- ================================= Load header ============================================ -->
	<jsp:include page="../import/header.jsp"></jsp:include>
	<!-- ============================== End Load header =========================================== -->

	<c:set var="rootName" value="${ pageContext.request.contextPath }" />
	<div id="wrapper">
		<section class="section single-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
					</div>
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
						<div class="page-wrapper">
						
							<div class="blog-title-area text-center">
								<ol class="breadcrumb hidden-xs-down">
									<li class="breadcrumb-item"><a href="${ rootName }/">HOME</a></li>
									<li class="breadcrumb-item"><a href="${ rootName }/topic/${ topic.toLowerCase().replace(' ', '-') }">${ topic.toUpperCase() }</a></li>
									<li class="breadcrumb-item active">${ post.title.toUpperCase() }</li>
								</ol>

								<span class="color-orange"><a href="${ rootName }/topic/${ topic.toLowerCase().replace(' ', '-') }" title="">${ topic.toUpperCase() }</a></span>

								<h3>${ post.title }</h3>

								<div class="blog-meta big-meta">
									<small><a href="#" title="">${ post.stringTime }</a></small>
									<small><a href="#" title="">by ${ authorName }</a></small>
									<small><a href="#" title=""><i class="fa fa-eye"></i> ${ post.views }</a></small>
								</div>
								<!-- end meta -->

								<div class="post-sharing">
									<ul class="list-inline">
										<li><a href="#" class="fb-button btn btn-primary"><i
												class="fa fa-facebook"></i> <span class="down-mobile">Share
													on Facebook</span></a></li>
										<li><a href="#" class="tw-button btn btn-primary"><i
												class="fa fa-twitter"></i> <span class="down-mobile">Tweet
													on Twitter</span></a></li>
										<li><a href="#" class="gp-button btn btn-primary"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
								<!-- end post-sharing -->
							</div>

							<!-- <div class="single-post-media">
								<img src="upload/tech_menu_08.jpg" alt="" class="img-fluid">
							</div> -->

							<div class="blog-content">
								${ content }
							</div>

							<div class="blog-title-area">
								<div class="tag-cloud-single">
									<span>Tags</span>
									<c:if test="${ not empty listTag }">
										<c:forEach var="tag" items="${ listTag }">
											<small>
												<a href="#" title="">${ tag.name }</a>
											</small>
										</c:forEach>
									</c:if>
								</div>

								<div class="post-sharing">
									<ul class="list-inline">
										<li><a href="#" class="fb-button btn btn-primary"><i
												class="fa fa-facebook"></i> <span class="down-mobile">Share
													on Facebook</span></a></li>
										<li><a href="#" class="tw-button btn btn-primary"><i
												class="fa fa-twitter"></i> <span class="down-mobile">Tweet
													on Twitter</span></a></li>
										<li><a href="#" class="gp-button btn btn-primary"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- Core JavaScript
    ================================================== -->
    <c:if test="${ loggingIn == false }">
	    <script type="text/javascript">
	    	let a = document.getElementById("cmtLinkLogin");
	    	a.href = "/GameNews/topic/login2cmt?url=" + window.location.pathname;
	    </script>
    </c:if>
	<script src="<c:url value="/lib/js/jquery.min.js" />"></script>
	<script src="<c:url value="/lib/js/tether.min.js" />"></script>
	<script src="<c:url value="/lib/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/lib/js/custom.js" />"></script>
	<script src="<c:url value="/lib/js/script.js" />"></script>
</body>
</html>