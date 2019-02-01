<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>AddCustomerAccount.Jsp</title>
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
   <li class="active">
   	<c:url var="addCAUrl" value="/welcome-customer-account"/>
   	<a href="${addCAUrl}">Add Customer Account Details</a>
  </li>
  <li>
  	<c:url var="getCAUrl" value="/fetch-customer-account"/>
  	<a href="${getCAUrl}">Fetch Customer Account details</a>
  </li>
</ul>
<ul class="nav navbar-nav navbar-right">
		<li>
			<c:url var="outUrl" value="/logout"/>
			<a href="${outUrl}">Logout</a>
		</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br/><br/>
			<h1 class="idx">Add Customer Account Details</h1>
<br/>
<c:url var="addUrl" value="/add-customer-account"/>
<form action="${addUrl}" method="post">

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>FirstName&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerFirstName" class="form-control" id="inputEmail3" placeholder="Enter Customer FirstName">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>LastName&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerLastName" class="form-control" id="inputEmail3" placeholder="Enter Customer LastName">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>Address&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerAddress" class="form-control" id="inputEmail3" placeholder="Enter Customer Address">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>AccountType&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="accountType" class="form-control" id="inputEmail3" placeholder="Enter Account Type">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>AccountStatus&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="accountStatus" class="form-control" id="inputEmail3" placeholder="Enter Account Status">
    </div>
  </div>
      
  <div class="form-group row">
  	<label for="inputPassword3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary btn3d btn-lg"><span class="glyphicon glyphicon-cloud"></span> CustomerAccount</button>
    </div>
  </div>
</form>
		</div>
	</div>
</div>
</body>
</html>