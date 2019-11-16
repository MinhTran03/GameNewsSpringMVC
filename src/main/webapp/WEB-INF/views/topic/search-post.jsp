<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Video Game News, Game News, Entertainment News - Game Sport</title>
	<jsp:include page="../import/importHeader.jsp"></jsp:include>
</head>
<body>
	<div class="wrapper">
		<c:set var="rootName" value="${ pageContext.request.contextPath }" />

		<jsp:include page="../import/header.jsp"></jsp:include>

		<div class="page-title lb single-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
						<h2>
							<i class="fa fa-star bg-orange"></i>
							Search by: ${ searchBy }
						</h2>
					</div>
					<div
						class="col-lg-4 col-md-4 col-sm-12 hidden-xs-down hidden-sm-down">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item"><a href="#">Search</a></li>
							<li class="breadcrumb-item active">${ searchBy }</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<section class="section">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
						<div class="page-wrapper">
							<div class="blog-top clearfix">
								<h4 class="pull-left">
									Recent News <a href="#"><i class="fa fa-rss"></i></a>
								</h4>
							</div>

							<div class="blog-list clearfix">
								<c:if test="${ not empty listPost }">
									<c:forEach var="post" items="${ listPost }" varStatus="status">
										<div class="blog-box row">
										
											<div class="col-md-4">
												<div class="post-media">
													<a href="${ rootName }/articles/<c:out value="${ post.shortTitle }" />/<c:out value="${ post.postId }" />" title="">
														<img src="<c:url value="${ post.image }" />" alt="" class="img-fluid">
														<div class="hovereffect"></div>
													</a>
												</div>
											</div>
		
											<div class="blog-meta big-meta col-md-8">
												<h4>
													<a href="${ rootName }/articles/<c:out value="${ post.shortTitle }" />/<c:out value="${ post.postId }" />" title="">
		                                 	<c:out value="${ post.title }" />
		                                 </a>
												</h4>
												<p>${ post.description }</p>
												<!-- <small class="firstsmall"><a class="bg-orange" href="tech-category-01.html" title="">Gadgets</a></small> -->
												<small><a href="tech-single.html" title="">${ post.stringTime }</a></small>
												<small><a href="${ rootName }/topic/profile/${post.userId}" title="">by ${ authorName.get(status.index) }</a></small>
												<small><a href="tech-single.html" title=""><i class="fa fa-eye"></i>${ post.views }</a></small>
											</div>
										</div>
										
										<hr class="invis">
									</c:forEach>
								</c:if>
							</div>
						</div>

						<hr class="invis">

						<%-- <div class="row">
							<c:set var="pageLink" value="${ rootName }/topic/profile/${ listPost.get(0).userId }/?page=" />
							<div class="col-md-12">
								<nav aria-label="Page navigation">
									<ul class="pagination justify-content-start">
										<c:if test="${ currentPage > 1 }">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ currentPage - 1 }">Previous</a>
										</c:if>
										<c:forEach begin="0" end="${ pageCount }" varStatus="status">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ status.index + 1 }">${ status.index + 1 }</a></li>
										</c:forEach>
										<c:if test="${ currentPage < pageCount }">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ currentPage + 1 }">Next</a></li>
										</c:if>
									</ul>
								</nav>
							</div>
						</div> --%>
					</div>

				</div>
			</div>
		</section>

		<div class="dmtop">Scroll to Top</div>

		<jsp:include page="../import/footer.jsp"></jsp:include>

		<jsp:include page="../import/importJS.jsp"></jsp:include>
	</div>
</body>
</html>