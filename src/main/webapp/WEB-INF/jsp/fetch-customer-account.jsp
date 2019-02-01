<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>Fetch-Customer-Account.Jsp</title>
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
			<h1 class="show">Customers Account List</h1>
<br/>
<table class="table table-striped table-bordered">
  <thead class="thead-dark">
    <tr>
      <th>CustomerId</th>
      <th>FirstName</th>
      <th>LastName</th>
      <th>Address</th>
      <th>AccountNumber</th>
      <th>AccountType</th>
      <th>AccountStatus</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody> 
  <c:forEach var="customersaccount" items="${customersAccountList}">			
	   <tr>
	   <td><c:out value="${customersaccount.customerId}"/></td>
	   <td><c:out value="${customersaccount.customerFirstName}"/></td>
	   <td><c:out value="${customersaccount.customerLastName}"/></td>
	   <td><c:out value="${customersaccount.customerAddress}"/></td>
	   <td><c:out value="${customersaccount.customerAccount.accountNumber}"/></td>
	   <td><c:out value="${customersaccount.customerAccount.accountType}"/></td>
	   <td><c:out value="${customersaccount.customerAccount.accountStatus}"/></td>
       <td>
       <button type="button" class="btn btn-warning btnOne">
       		<c:url var="editUrl" value="/edit-customer-account/${customersaccount.customerId}"/>
       		<a href="${editUrl}">Edit</a>
       	</button>
       </td>
       <td>
       <button type="button" class="btn btn-danger btnTwo">
       		<c:url var="deleteUrl" value="/delete-customer-account/${customersaccount.customerId}"/>
       		<a href="${deleteUrl}">Delete</a>
       	</button>
       </td>
    </tr>						
</c:forEach>
  </tbody>
</table>
<br/>
		</div>
	</div>
</div>
</body>
</html>