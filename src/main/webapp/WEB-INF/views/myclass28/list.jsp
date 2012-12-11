<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass28</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass28Criteria">
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
		<c:set var="myclass25error">
			<form:errors path="myclass25" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass25error}">error</c:if> ">
			<label class="control-label" for="myclass25input">myclass25</label>
			<div class="controls">
				<form:select id="myclass25input" path="myclass25.id">
					<form:options items="${myClass25s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass25" />
				
			</div>
			
		</div>
		<c:set var="myclass115error">
			<form:errors path="myclass115" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass115error}">error</c:if> ">
			<label class="control-label" for="myclass115input">myclass115</label>
			<div class="controls">
				<form:select id="myclass115input" path="myclass115.id">
					<form:options items="${myClass115s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass115" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass28/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass28List}" var="myClass28">
		<tr>
			<td>${myClass28.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass28/detail/${myClass28.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass28/edit/${myClass28.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

