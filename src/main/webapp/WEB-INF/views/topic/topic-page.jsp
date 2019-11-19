<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../import/importHeader.jsp"></jsp:include>
	<style type="text/css">
	</style>
</head>
<body>
	<div class="wrapper">
		<c:set var="rootName" value="${ pageContext.request.contextPath }" />
		
		<jsp:include page="../import/header.jsp"></jsp:include>

		<section class="section first-section">
         <div class="container-fluid">
            <div class="masonry-blog clearfix">

               <div class="first-slot">
                  <div class="masonry-box post-media">
                     <img src="<c:url value="${ topPost.get(0).image }" />" alt="" class="img-fluid" style="height: 370px">
                     <div class="shadoweffect">
                        <div class="shadow-desc">
                           <div class="blog-meta">
                              <h4>
                                 <a href="${ rootName }/articles/<c:out value="${ topPost.get(0).shortTitle }" />/<c:out value="${ topPost.get(0).postId }" />" title="">
                                 	<c:out value="${ topPost.get(0).title }" />
                                 </a>
                              </h4>
                              <small>
                              	<a href="" title=""> <c:out value="${ topPost.get(0).stringTime }" /></a>
                              </small>
                              <small>
                              	<a href="${ rootName }/topic/profile/${topAuthorId.get(0)}" title="">by <c:out value="${ topAuthorName.get(0) }" /></a>
                             	</small>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="second-slot">
                  <div class="masonry-box post-media">
                     <img src="<c:url value="${ topPost.get(1).image }" />" alt="" class="img-fluid" style="height: 370px">
                     <div class="shadoweffect">
                        <div class="shadow-desc">
                           <div class="blog-meta">
                              <h4>
                                 <a href="${ rootName }/articles/<c:out value="${ topPost.get(1).shortTitle }" />/<c:out value="${ topPost.get(1).postId }" />" title="">
                                 	<c:out value="${ topPost.get(1).title }" />
                                 </a>
                              </h4>
                              <small><a href="" title="">
                                    <c:out value="${ topPost.get(1).stringTime }" /></a></small> <small><a
                                    href="${ rootName }/topic/profile/${topAuthorId.get(1)}" title="">by <c:out value="${ topAuthorName.get(1) }" /></a></small>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="last-slot">
                  <div class="masonry-box post-media">
                     <img src="<c:url value="${ topPost.get(2).image }" />" alt="" class="img-fluid" style="height: 370px">
                     <div class="shadoweffect">
                        <div class="shadow-desc">
                           <div class="blog-meta">
                              <h4>
                                 <a href="${ rootName }/articles/<c:out value="${ topPost.get(2).shortTitle }" />/<c:out value="${ topPost.get(2).postId }" />" title="">
                                 	<c:out value="${ topPost.get(2).title }" />
                                 </a>
                              </h4>
                              <small><a href="" title="">
                                    <c:out value="${ topPost.get(2).stringTime }" /></a></small> <small><a
                                    href="${ rootName }/topic/profile/${topAuthorId.get(2)}" title="">by <c:out value="${ topAuthorName.get(2) }" /></a></small>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

            </div>
         </div>
      </section>
		
		<section class="section">
			<div class="container">
				<div class="row">
					
					<div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
					</div>
					
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
						<div class="page-wrapper">
							<div class="blog-top clearfix">
								<h4 class="pull-left">
									<s:message code="title.recent" /> <a href="#"><i class="fa fa-rss"></i></a>
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
												<small><a href="${ rootName }/topic/profile/${ post.userId }" title="">by ${ listAuthorName[status.index] }</a></small>
												<small><a href="tech-single.html" title=""><i class="fa fa-eye"></i>${ post.views }</a></small>
											</div>
										</div>
										
										<hr class="invis">
									</c:forEach>
								</c:if>
							</div>
						</div>

						<hr class="invis">

						<div class="row">
							<c:set var="pageLink" value="${ rootName }/topic/${ topic }/?page=" />
							<div class="col-md-12">
								<nav aria-label="Page navigation">
									<ul class="pagination justify-content-start">
										<c:if test="${ currentPage > 1 }">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ currentPage - 1 }"><s:message code="title.pervious" /></a>
										</c:if>
										<c:forEach begin="0" end="${ pageCount }" varStatus="status">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ status.index + 1 }">${ status.index + 1 }</a></li>
										</c:forEach>
										<c:if test="${ currentPage <= pageCount }">
											<li class="page-item"><a class="page-link" href="${ pageLink }${ currentPage + 1 }"><s:message code="title.next" /></a></li>
										</c:if>
									</ul>
								</nav>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>


		<div class="dmtop">Scroll to Top</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript">
			document.getElementsByClassName('dmtop')[0].onclick = function(){
				$('html, body').animate({ scrollTop: 0 }, 'medium');
			}
		</script>

		<jsp:include page="../import/footer.jsp"></jsp:include>

		<jsp:include page="../import/importJS.jsp"></jsp:include>
	</div>
</body>
</html>