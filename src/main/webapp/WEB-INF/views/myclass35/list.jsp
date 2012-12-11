<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass35</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass35Criteria">
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
		<c:set var="myclass51error">
			<form:errors path="myclass51" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass51error}">error</c:if> ">
			<label class="control-label" for="myclass51input">myclass51</label>
			<div class="controls">
				<form:select id="myclass51input" path="myclass51.id">
					<form:options items="${myClass51s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass51" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass35/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass35List}" var="myClass35">
		<tr>
			<td>${myClass35.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass35/detail/${myClass35.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass35/edit/${myClass35.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

