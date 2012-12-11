<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass34</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass34Criteria">
	<div class="row">
		<c:set var="iderror">
			<form:errors path="id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty iderror}">error</c:if> ">
			<label class="control-label" for="idinput">id</label>
			<div class="controls">
				<form:input id="idinput" path="id" disabled="false" />
				<form:errors class="help-inline" path="id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Search" />
		
	</div>
	
</form:form>
<table class="table table-striped table-bordered table-condensed">
	<tr>
		<th>id</th>
		<th>
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass34/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass34List}" var="myClass34">
		<tr>
			<td>${myClass34.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass34/detail/${myClass34.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass34/edit/${myClass34.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

