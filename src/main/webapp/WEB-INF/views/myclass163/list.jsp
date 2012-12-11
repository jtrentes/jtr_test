<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass163</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass163Criteria">
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
		<c:set var="myclass28error">
			<form:errors path="myclass28" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass28error}">error</c:if> ">
			<label class="control-label" for="myclass28input">myclass28</label>
			<div class="controls">
				<form:select id="myclass28input" path="myclass28.id">
					<form:options items="${myClass28s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass28" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass163/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass163List}" var="myClass163">
		<tr>
			<td>${myClass163.attribute}</td>
			<td>${myClass163.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass163/detail/${myClass163.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass163/edit/${myClass163.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

