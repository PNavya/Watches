<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
					</li>
			<ul class="dropdown-menu">
						<li><a href="addProduct">ADD</a></li>
						<li><a href="deleteProduct">DELETE</a></li>
						<li><a href="updateProduct">EDIT</a></li>
						<li><a href="#">View ALL</a></li>
						
					</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
					</li>
			<ul class="dropdown-menu">
						<li><a href="category">ADD</a></li>
						<li><a href="deleteCategory">DELETE</a></li>
						<li><a href="updateCategory">EDIT</a></li>
						<li><a href="viewcategory">View ALL</a></li>
						
					</ul></li>
					
			<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
					</li>
			<ul class="dropdown-menu">
						<li><a href="addSupplier">ADD</a></li>
						<li><a href="remove">DELETE</a></li>
						<li><a href="updateSupplier">EDIT</a></li>
						<li><a href="viewsuppliers">View ALL</a></li>
						
					</ul></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="Logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
	</div>
	</nav>