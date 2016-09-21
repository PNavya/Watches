<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
 
function MyController($scope, $http) {

	 $scope.sortType = 'name'; // set the default sort type
	  $scope.sortReverse = false;  // set the default sort order
	  $scope.searchBTitle = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.prod = data;  
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
};
</script>

</style>
</head>
<body>
	<h2>
		<center>
			<b>Welcome to Shopping Cart</b>
		</center>
	</h2>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WatchesShop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About US</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="viewdetails">Watches</a>


				<!-- <li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Watches <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="product">Mens Watches</a></li>
						<li><a href="#">Womens Watches</a></li>
						<li><a href="#">Smart Watches</a></li>
					</ul></li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
           <c:choose>
           <c:when test="${empty loggedInUser}">
			
				<li><a href="signup"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="Login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:when>
			
			<c:when test="${not empty loggedInUser}">
			<td>Welcome ${loggedInUser}</td>
			<li><a href="perform_logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:when>
			</c:choose>									
				<li><a href="#"><span class="glyphicon glyphicon-search"></span>
						Search</a></li>
			</ul>
		</div>
	</nav>


	
				</div>
			</div>

			
