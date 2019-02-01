<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>UpdateCustomerAccount.Jsp</title>
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
  <li class="active">
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
			<h1 class="idx">Update Customer Account Details</h1>
<br/>
<c:url var="updateUrl" value="/update-customer-account"/>
<form action="${updateUrl}" method="post">

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>Id&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerId" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerId() %>" class="form-control" id="inputEmail3" readonly>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>FirstName&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerFirstName" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerFirstName() %>" class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>LastName&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerLastName" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerLastName() %>" class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>Address&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="customerAddress" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerAddress() %>" class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>AccountNumber&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="accountNumber" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerAccount().getAccountNumber() %>" class="form-control" id="inputEmail3" readonly>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>AccountType&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="accountType" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerAccount().getAccountType() %>" class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>AccountStatus&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="accountStatus" value="<%= ((CustomerDTO)request.getAttribute("values")).getCustomerAccount().getAccountStatus() %>" class="form-control" id="inputEmail3">
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