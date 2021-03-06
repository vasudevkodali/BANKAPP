<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>V K Bank</title>
</head>
<body>
  	<div class="container">
  	<%@ include file="header.jsp" %>
  	
  	<div class="row">
  		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
  			<div class="jumbotron">
  				<h1 class="display-4">Welcome to V K Bank</h1>	
  				<p class="lead">
  				Happiness = A Good Bank Account,A Good Cook and a Good Digestion - Jean
  				</p>
  				<a href="user/new" class="btn btn-lg btn-success">Register Here</a>
  				<p><br>Existing Users : <a href="user/login">Login Here</a>
  			</div>
  		</div>
  	</div>
  	
  	<div class="row">
  		<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
  			<div class="card" style="height: 200px">
  				<div class="card-header">Online</div>
  				<img src="<spring:url value='/resources/images/stay-online.png' />" class="card-img-top" alt="Online" />
  				<div class="card-body">
  					<p class="card-text">200+ Transactions via NetBanking</p>
  				</div>
  			</div>
  		</div>
  		
  		<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
  			<div class="card" style="height: 200px">
  				<div class="card-header">Phone</div>
  				<img src="<spring:url value='/resources/images/stay-phone.jpg' />" class="card-img-top" alt="Phone" />
  				<div class="card-body">
  					<p class="card-text">75+ Transactions on your mobile</p>
  				</div>
  			</div>
  		</div>
  		
  		<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
  			<div class="card" style="height: 200px">
  				<div class="card-header">Social Media</div>
  				<img src="<spring:url value='/resources/images/stay-social.png' />" class="card-img-top" alt="Social" />
  				<div class="card-body">
  					<p class="card-text">Social Media Sharing + Banking</p>
  				</div>
  			</div>
  		</div>
  		
  		<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
  			<div class="card" style="height: 200px">
  				<div class="card-header">Watch</div>
  				<img src="<spring:url value='/resources/images/stay-watch.png' />" class="card-img-top" alt="Online" />
  				<div class="card-body">
  					<p class="card-text">Banking at the flick of a wrist now</p>
  				</div>
  			</div>
  		</div>
  		
  	</div>
  	<%@include file="footer.jsp" %>
  	
  	</div>
</body>
</html>