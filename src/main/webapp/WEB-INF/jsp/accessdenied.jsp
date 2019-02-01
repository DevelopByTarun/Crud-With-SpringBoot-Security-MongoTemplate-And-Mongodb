<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>AccessDenied.Jsp</title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#">Hello&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
<ul class="nav navbar-nav">
  <li>
  	<c:url var="getHomeUrl" value="/"/>
    <a href="${getHomeUrl}">Home</a>
  </li>
   <li>
   	<c:url var="addCAUrl" value="/welcome-customer-account"/>
   	<a href="${addCAUrl}">Add Customer Account Details</a>
  </li>
  <li>
  	<c:url var="getCAUrl" value="/fetch-customer-account"/>
  	<a href="${getCAUrl}">Fetch Customer Account details</a>
  </li>
</ul>
<ul class="nav navbar-nav navbar-right">
		<li class="active">
			<c:url var="outUrl" value="/logout"/>
			<a href="${outUrl}">Logout</a>
		</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
		<br/><br/><br/>
			<h1 id="banner">Unauthorized Access !!</h1>
		<hr />
		<c:if test="${not empty error}">
			<div style="color:red">
				<h3>
				Your fake login attempt was bursted, try again !!<br /> 
				Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</h3>
			</div>
		</c:if>
		<br/>
		<h4 class="message">Access denied!</h4>
		</div>
	</div>
</div>
</body>
</html>