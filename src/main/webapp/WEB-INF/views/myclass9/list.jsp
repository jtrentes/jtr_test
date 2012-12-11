<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass9</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass9Criteria">
	<div class="row">
		<c:set var="attributeerror">
			<form:errors path="attribute" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attributeerror}">error</c:if> ">
			<label class="control-label" for="attributeinput">attribute</label>
			<div class="controls">
				<form:input id="attributeinput" path="attribute" disabled="false" />
				<form:errors class="help-inline" path="attribute" />
				
			</div>
			
		</div>
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
		<c:set var="myclass81error">
			<form:errors path="myclass81" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass81error}">error</c:if> ">
			<label class="control-label" for="myclass81input">myclass81</label>
			<div class="controls">
				<form:select id="myclass81input" path="myclass81.id">
					<form:options items="${myClass81s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass81" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Search" />
		
	</div>
	
</form:form>
<table class="table table-striped table-bordered table-condensed">
	<tr>
		<th>attribute</th>
		<th>id</th>
		<th>
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass9/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass9List}" var="myClass9">
		<tr>
			<td>${myClass9.attribute}</td>
			<td>${myClass9.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass9/detail/${myClass9.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass9/edit/${myClass9.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

