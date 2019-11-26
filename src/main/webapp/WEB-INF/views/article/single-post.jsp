<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../import/importHeader.jsp"></jsp:include>
<title>${ post.title }</title>
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
	
	img{
		width: 100%;
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
									<small><a href="${ rootName }/topic/profile/${authorId}" title="">by ${ authorName }</a></small>
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
												<a href="${ rootName }/topic/tag/${ tag.name }" title="">${ tag.name }</a>
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

							<div class="row">
								<div class="col-lg-12">
									<div class="banner-spot clearfix">
										<div class="banner-img">
											<!-- <img src="upload/banner_01.jpg" alt="" class="img-fluid"> -->
										</div>
									</div>
								</div>
							</div>

							<hr class="invis1">

							<%-- <div class="custombox authorbox clearfix">
								<h4 class="small-title">About author</h4>
								<div class="row">
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
										<img src="<c:url value="/lib/upload/author.jpg" />" alt="" class="img-fluid rounded-circle">
									</div>

									<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
										<h4>
											<a href="#">Jessica</a>
										</h4>
										<p>
											Quisque sed tristique felis. Lorem <a href="#">visit my
												website</a> amet, consectetur adipiscing elit. Phasellus quis mi
											auctor, tincidunt nisl eget, finibus odio. Duis tempus elit
											quis risus congue feugiat. Thanks for stop Tech Blog!
										</p>

										<div class="topsocial">
											<a href="#" data-toggle="tooltip" data-placement="bottom"
												title="Facebook"><i class="fa fa-facebook"></i></a> <a
												href="#" data-toggle="tooltip" data-placement="bottom"
												title="Youtube"><i class="fa fa-youtube"></i></a> <a
												href="#" data-toggle="tooltip" data-placement="bottom"
												title="Pinterest"><i class="fa fa-pinterest"></i></a> <a
												href="#" data-toggle="tooltip" data-placement="bottom"
												title="Twitter"><i class="fa fa-twitter"></i></a> <a
												href="#" data-toggle="tooltip" data-placement="bottom"
												title="Instagram"><i class="fa fa-instagram"></i></a> <a
												href="#" data-toggle="tooltip" data-placement="bottom"
												title="Website"><i class="fa fa-link"></i></a>
										</div>

									</div>
								</div>
							</div> --%>

							<!-- <hr class="invis1"> -->

							<%-- <div class="custombox clearfix">
								<h4 class="small-title">You may also like</h4>
								<div class="row">
									<div class="col-lg-6">
										<div class="blog-box">
											<div class="post-media">
												<a href="tech-single.html" title=""> <img
													src="<c:url value="/lib/upload/tech_menu_04.jpg" />" alt="" class="img-fluid">
													<div class="hovereffect">
														<span class=""></span>
													</div>
												</a>
											</div>
											<div class="blog-meta">
												<h4>
													<a href="tech-single.html" title="">We are guests of ABC Design Studio</a>
												</h4>
												<small><a href="blog-category-01.html" title="">Trends</a></small>
												<small><a href="blog-category-01.html" title="">21
														July, 2017</a></small>
											</div>
										</div>
									</div>

									<div class="col-lg-6">
										<div class="blog-box">
											<div class="post-media">
												<a href="tech-single.html" title=""> <img
													src="<c:url value="/lib/upload/tech_menu_06.jpg" />" alt="" class="img-fluid">
													<div class="hovereffect">
														<span class=""></span>
													</div>
												</a>
											</div>
											<div class="blog-meta">
												<h4>
													<a href="tech-single.html" title="">Nostalgia at work
														with family</a>
												</h4>
												<small><a href="blog-category-01.html" title="">News</a></small>
												<small><a href="blog-category-01.html" title="">20
														July, 2017</a></small>
											</div>
										</div>
									</div>
								</div>
							</div> --%>

							<hr class="invis1">

							<div class="custombox clearfix">
								<h4 class="small-title commen-count">${ listComment.size() } <s:message code="title.comment" /></h4>
								<div class="row">
									<div class="col-lg-12">
										<div class="comments-list">
											<c:forEach var="list" items="${ listComment }" varStatus="status">
												<div class="media">
													<a class="media-left" href="#">
														<img src="<c:url value="${ listUser[status.index].image }" />" alt="" class="rounded-circle">
													</a>
													<div class="media-body">
														<h4 class="media-heading user_name">
															${ listUser[status.index].fullName }
															<small>${ list.stringTime }</small>
														</h4>
														<p>${ list.content }</p>
														<a href="#" class="btn btn-primary btn-sm"><s:message code="title.replycomment" /></a>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>

							<hr class="invis1">

							<div class="custombox clearfix">
								<h4 class="small-title"><s:message code="title.leavereplycomment" /></h4>
								<div class="row">
									<div class="col-lg-12">
										<div class="form-wrapper">
											<c:if test="${ loggingIn == false }">
												<!-- <input id="input-name" type="text" class="form-control" placeholder="Your name" />
												<input id="input-email" type="text" class="form-control" placeholder="Email address" /> -->
												<a id="cmtLinkLogin" href="${ rootName }/login2cmt"><s:message code="title.loginforcomment" /></a>
												
											</c:if>
											<c:if test="${ loggingIn == true }">
												<textarea class="form-control comment-content" placeholder="Your comment"></textarea>
												<button type="submit" class="btn btn-primary post-comment"><s:message code="title.submitcomment" /></button>												
											</c:if>
										</div>
									</div>
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