<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Material Design Bootstrap</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/lib/css/bootstrap.min.css" />" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="<c:url value="/lib/css/mdb.min.css" />" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="<c:url value="/lib/css/style.min.css" />" rel="stylesheet">
  <style>
    .map-container {
      overflow: hidden;
      padding-bottom: 56.25%;
      position: relative;
      height: 0;
    }

    .map-container iframe {
      left: 0;
      top: 0;
      height: 100%;
      width: 100%;
      position: absolute;
    }
  </style>
  <style type="text/css">
   	body {
		   color: #566787;
		   background: #f5f5f5;
		   font-family: 'Varela Round', sans-serif;
		   font-size: 13px;
		}
		.table-wrapper {
		   background: #fff;
		   padding: 20px 25px;
		   margin: 30px 0;
		   border-radius: 3px;
		   box-shadow: 0 1px 1px rgba(0,0,0,.05);
		}
		.table-title {
		   padding-bottom: 15px;
		   background: #299be4;
		   color: #fff;
		   padding: 16px 30px;
		   margin: -20px -25px 10px;
		   border-radius: 3px 3px 0 0;
		}
		.table-title h2 {
		   margin: 5px 0 0;
		   font-size: 24px;
		}
		.table-title .btn {
		   color: #566787;
		   float: right;
		   font-size: 13px;
		   background: #fff;
		   border: none;
		   min-width: 50px;
		   border-radius: 2px;
		   border: none;
		   outline: none !important;
		   margin-left: 10px;
		}
		.table-title .btn:hover, .table-title .btn:focus {
		   color: #566787;
		   background: #f2f2f2;
		}
		.table-title .btn i {
		   float: left;
		   font-size: 21px;
		   margin-right: 5px;
		}
		.table-title .btn span {
		   float: left;
		   margin-top: 2px;
		}
		table.table tr th, table.table tr td {
		   border-color: #e9e9e9;
		   padding: 12px 15px;
		   vertical-align: middle;
		}
		table.table tr th:first-child {
		   width: 60px;
		}
		table.table tr th:last-child {
		   width: 100px;
		}
		table.table-striped tbody tr:nth-of-type(odd) {
		   background-color: #fcfcfc;
		}
		table.table-striped.table-hover tbody tr:hover {
		   background: #f5f5f5;
		}
		table.table th i {
		   font-size: 13px;
		   margin: 0 5px;
		   cursor: pointer;
		}	
		table.table td:last-child i {
		   opacity: 0.9;
		   font-size: 22px;
		   margin: 0 5px;
		}
		table.table td a {
		   font-weight: bold;
		   color: #566787;
		   display: inline-block;
		   text-decoration: none;
		}
		table.table td a:hover {
		   color: #2196F3;
		}
		table.table td a.settings {
		   color: #2196F3;
		}
		table.table td a.delete {
		   color: #F44336;
		}
		table.table td i {
		   font-size: 19px;
		}
		table.table .avatar {
		   border-radius: 50%;
		   vertical-align: middle;
		   margin-right: 10px;
		   width: 50px;
		}
		.status {
		   font-size: 30px;
		   margin: 2px 2px 0 0;
		   display: inline-block;
		   vertical-align: middle;
		   line-height: 10px;
		}
		.text-success {
		   color: #10c469;
		}
		.text-info {
		   color: #62c9e8;
		}
		.text-warning {
		   color: #FFC107;
		}
		.text-danger {
		   color: #ff5b5b;
		}
		.pagination {
		   float: right;
		   margin: 0 0 5px;
		}
		.pagination li a {
		   border: none;
		   font-size: 13px;
		   min-width: 30px;
		   min-height: 30px;
		   color: #999;
		   margin: 0 2px;
		   line-height: 30px;
		   border-radius: 2px !important;
		   text-align: center;
		   padding: 0 6px;
		}
		.pagination li a:hover {
		   color: #666;
		}	
		.pagination li.active a, .pagination li.active a.page-link {
		   background: #03A9F4;
		}
		.pagination li.active a:hover {        
		   background: #0397d6;
		}
		.pagination li.disabled i {
		   color: #ccc;
		}
		.pagination li i {
		   font-size: 16px;
		   padding-top: 6px
		}
		.hint-text {
		   float: left;
		   margin-top: 10px;
		   font-size: 13px;
		}
   </style>
</head>

<body class="grey lighten-3">
	<c:set var="rootName" value="${ pageContext.request.contextPath }" />
  <header>

    <!-- Sidebar -->
    <div class="sidebar-fixed position-fixed">

      <a class="logo-wrapper waves-effect">
        <img src="https://mdbootstrap.com/img/logo/mdb-email.png" class="img-fluid" alt="">
      </a>

      <div class="list-group list-group-flush">
        <a href="${ rootName }/management/dashboard" class="list-group-item list-group-item-action waves-effect">
          <i class="fas fa-chart-pie mr-3"></i><s:message code="dashboard.dashboard" /></a>
        <a href="" class="list-group-item active waves-effect">
          <i class="fas fa-table mr-3"></i><s:message code="dashboard.checkpost" /></a>
        <a href="${ rootName }/edit-user" target="_blank" class="list-group-item list-group-item-action waves-effect">
          <i class="fas fa-user mr-3"></i><s:message code="dashboard.profileuser" /></a>
      </div>

    </div>
    <!-- Sidebar -->

  </header>

  <main class="pt-5 mx-lg-5">
  
    <div class="container-fluid">

      <div class="card mb-4 wow fadeIn">

        <!--Card content-->
        <div class="card-body d-sm-flex justify-content-between">

          <h4 class="mb-2 mb-sm-0 pt-1">
            <a href="/GameNews/topic/game-home" target="_blank"><s:message code="dashboard.home" /></a>
            <span>/</span>
            <span><s:message code="dashboard.checkpost" /></span>
          </h4>

          <form class="d-flex justify-content-center">
            <!-- Default input -->
            <input type="search" placeholder="Type your query" aria-label="Search" class="form-control">
            <button class="btn btn-primary btn-sm my-0 p" type="submit">
              <i class="fas fa-search"></i>
            </button>

          </form>

        </div>

      </div>

      <div class="row wow fadeIn">

        <div class="col-md-12 mb-4">

          <div class="card">

            <div class="card-body">

              <table class="table table-striped table-hover">
	            <thead>
	               <tr>
	                  <th><s:message code="dashboard.post.id" /></th>
	                  <th><s:message code="dashboard.post.title" /></th>
	                  <th><s:message code="dashboard.post.topic" /></th>
	                  <th><s:message code="dashboard.post.author" /></th>
	                  <th><s:message code="dashboard.post.date" /></th>
	                  <th></th>
	                  <th></th>
	                  <th></th>
	               </tr>
	            </thead>
	            <tbody>
	            	<c:if test="${ not empty listPost }">
	            		<c:forEach var="post" items="${ listPost }" varStatus="status">
			               <tr>
			                  <td>${ post.postId }</td>
			                  <td>${ post.title }</td>
			                  <td>${ listTopicName.get(status.index) }</td>
			                  <td id="${ listAuthorId.get(status.index) }">${ listAuthorName.get(status.index) }</td>
			                  <td>${ post.stringTime }</td>
			                  <td><a href="demo/${ post.postId }" style="color: blue"><s:message code="dashboard.post.demo" /></a></td>
			                  <td>Delete</td>
			                  <td><a class="acceptPost" id="${ listAuthorId.get(status.index) }" style="color: blue"><s:message code="dashboard.post.accept" /></a></td>
			               </tr>
		               </c:forEach>
	               </c:if>
	            </tbody>
	         </table>

            </div>

          </div>

        </div>

      </div>

    </div>
  </main>
  <!--Main layout-->

  <!--Footer-->
  <footer class="page-footer text-center font-small primary-color-dark darken-2 mt-4 wow fadeIn">

    <!--Call to action-->
    <div class="pt-4">
      <a class="btn btn-outline-white" href="https://mdbootstrap.com/docs/jquery/getting-started/download/"
        target="_blank" role="button">Download
        MDB
        <i class="fas fa-download ml-2"></i>
      </a>
      <a class="btn btn-outline-white" href="https://mdbootstrap.com/education/bootstrap/" target="_blank"
        role="button">Start
        free tutorial
        <i class="fas fa-graduation-cap ml-2"></i>
      </a>
    </div>
    <!--/.Call to action-->

    <hr class="my-4">

    <!-- Social icons -->
    <div class="pb-4">
      <a href="https://www.facebook.com/mdbootstrap" target="_blank">
        <i class="fab fa-facebook-f mr-3"></i>
      </a>

      <a href="https://twitter.com/MDBootstrap" target="_blank">
        <i class="fab fa-twitter mr-3"></i>
      </a>

      <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
        <i class="fab fa-youtube mr-3"></i>
      </a>

      <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
        <i class="fab fa-google-plus mr-3"></i>
      </a>

      <a href="https://dribbble.com/mdbootstrap" target="_blank">
        <i class="fab fa-dribbble mr-3"></i>
      </a>

      <a href="https://pinterest.com/mdbootstrap" target="_blank">
        <i class="fab fa-pinterest mr-3"></i>
      </a>

      <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
        <i class="fab fa-github mr-3"></i>
      </a>

      <a href="http://codepen.io/mdbootstrap/" target="_blank">
        <i class="fab fa-codepen mr-3"></i>
      </a>
    </div>
    <!-- Social icons -->

    <!--Copyright-->
    <div class="footer-copyright py-3">
      © 2019 Copyright:
      <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> MDBootstrap.com </a>
    </div>
    <!--/.Copyright-->

  </footer>
  <!--/.Footer-->
	
	<script type="text/javascript" src="<c:url value="/lib/dashboard/js/index.js" />" ></script>
  <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="<c:url value="/lib/js/jquery-3.4.1.min.js" />" ></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="<c:url value="/lib/js/popper.min.js" />" ></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="<c:url value="/lib/js/bootstrap.min.js" />" ></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="<c:url value="/lib/js/mdb.min.js" />" ></script>
  <!-- Initializations -->
  <script type="text/javascript">
    // Animations initialization
    new WOW().init();

  </script>

  <!-- Charts -->
  <script>
    // Line
    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
          label: '# of Votes',
          data: [12, 19, 3, 5, 2, 3],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });

    //pie
    var ctxP = document.getElementById("pieChart").getContext('2d');
    var myPieChart = new Chart(ctxP, {
      type: 'pie',
      data: {
        labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
        datasets: [{
          data: [300, 50, 100, 40, 120],
          backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
          hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
        }]
      },
      options: {
        responsive: true,
        legend: false
      }
    });


    //line
    var ctxL = document.getElementById("lineChart").getContext('2d');
    var myLineChart = new Chart(ctxL, {
      type: 'line',
      data: {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [{
          label: "My First dataset",
          backgroundColor: [
            'rgba(105, 0, 132, .2)',
          ],
          borderColor: [
            'rgba(200, 99, 132, .7)',
          ],
          borderWidth: 2,
          data: [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label: "My Second dataset",
          backgroundColor: [
            'rgba(0, 137, 132, .2)',
          ],
          borderColor: [
            'rgba(0, 10, 130, .7)',
          ],
          data: [28, 48, 40, 19, 86, 27, 90]
        }
        ]
      },
      options: {
        responsive: true
      }
    });


    //radar
    var ctxR = document.getElementById("radarChart").getContext('2d');
    var myRadarChart = new Chart(ctxR, {
      type: 'radar',
      data: {
        labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
        datasets: [{
          label: "My First dataset",
          data: [65, 59, 90, 81, 56, 55, 40],
          backgroundColor: [
            'rgba(105, 0, 132, .2)',
          ],
          borderColor: [
            'rgba(200, 99, 132, .7)',
          ],
          borderWidth: 2
        }, {
          label: "My Second dataset",
          data: [28, 48, 40, 19, 96, 27, 100],
          backgroundColor: [
            'rgba(0, 250, 220, .2)',
          ],
          borderColor: [
            'rgba(0, 213, 132, .7)',
          ],
          borderWidth: 2
        }]
      },
      options: {
        responsive: true
      }
    });

    //doughnut
    var ctxD = document.getElementById("doughnutChart").getContext('2d');
    var myLineChart = new Chart(ctxD, {
      type: 'doughnut',
      data: {
        labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
        datasets: [{
          data: [300, 50, 100, 40, 120],
          backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
          hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
        }]
      },
      options: {
        responsive: true
      }
    });

  </script>

  <!--Google Maps-->
  <script src="https://maps.google.com/maps/api/js"></script>
  <script>
    // Regular map
    function regular_map() {
      var var_location = new google.maps.LatLng(40.725118, -73.997699);

      var var_mapoptions = {
        center: var_location,
        zoom: 14
      };

      var var_map = new google.maps.Map(document.getElementById("map-container"),
        var_mapoptions);

      var var_marker = new google.maps.Marker({
        position: var_location,
        map: var_map,
        title: "New York"
      });
    }

    new Chart(document.getElementById("horizontalBar"), {
      "type": "horizontalBar",
      "data": {
        "labels": ["Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Grey"],
        "datasets": [{
          "label": "My First Dataset",
          "data": [22, 33, 55, 12, 86, 23, 14],
          "fill": false,
          "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
            "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"
          ],
          "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
            "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)",
            "rgb(201, 203, 207)"
          ],
          "borderWidth": 1
        }]
      },
      "options": {
        "scales": {
          "xAxes": [{
            "ticks": {
              "beginAtZero": true
            }
          }]
        }
      }
    });

  </script>
</body>

</html>