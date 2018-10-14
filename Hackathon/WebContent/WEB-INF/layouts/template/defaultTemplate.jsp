<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<!-- 
Trevor Moore
CST-341
9/22/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_navbar.asp
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://www.w3schools.com/bootstrap/bootstrap_ref_comp_glyphs.asp
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://bootsnipp.com/snippets/OORq

For boostrapping the navbar
-->

<style>

	.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	  background-color: #808080;
	}

	.errors {
		color: #ff0000;
	}

	.navbar {
    position: relative;
	}
	
	.brand {
	    position: absolute;
	    display: block;
	}

	h4, .control-label {
		color: #fff
	}

	.form-horizontal {
		min-height: 70%;
		width: 70%;
		padding: 19px;
		position: absolute;
		
		background: rgba(0, 0, 0, 0.6);
		margin-bottom: 80px;
		padding-bottom: 20px;
		border: 1px solid #464646;
		border-radius: 4px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	}

	*{
		color: #fff;
	
	}

	body {
		background: url("${pageContext.request.contextPath}/resources/images/background.jpg");
		padding: 50px;
		height: 100%;
		background-attachment: fixed;
		background-repeat: no-repeat;
		background-size: cover;
	}

	#login-dp{
		min-width: 250px;
		padding: 14px 14px 0;
		overflow:hidden;
		background-color:rgba(255,255,255,.8);
	}
	
	#login-dp .help-block{
		font-size:12px
	}
	#login-dp .bottom{
		background-color:rgba(255,255,255,.8);
		border-top:1px solid #ddd;
		clear:both;
		padding:14px;
	}
	#login-dp .social-buttons{
		margin:12px 0
	}
	#login-dp .social-buttons a{
		width: 49%;
	}
	#login-dp .form-group {
		margin-bottom: 10px;
	}
	.btn-fb{
		color: #fff;
		background-color:#3b5998;
	}
	.btn-fb:hover{
		color: #fff;
		background-color:#496ebc
	}
	.btn-tw{
		color: #fff;
		background-color:#55acee;
	}
	.btn-tw:hover{
		color: #fff;
		background-color:#59b5fa;
	}

</style>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Hackathon</title>
	<!-- This is where we define our open source resources, which we mapped in -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<c:url value="/resources/Site.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" type="text/css" id="bootstrap-css"/>
	<!-- <link href="<c:url value="/WEB-INF/scripts/bootstrap.min.css" />" rel="stylesheet"> -->
	<script src="<c:url value="/resources/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/mdb.js" />"></script>
	<script src="<c:url value="/resources/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery-1.10.2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery.unobtrusive-ajax.js" />"></script>
</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div class="container body-content" style="padding-bottom: 100px">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer -->
	<div class="footer" style="padding-top: 100px">
		<tiles:insertAttribute name="footer" />
	</div>
</body>

</html>