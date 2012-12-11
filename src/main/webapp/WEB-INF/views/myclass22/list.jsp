<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass22</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass22Criteria">
	<div class="row">
		<c:set var="attributeerror">
			<form:errors path="attribute" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attributeerror}">error</c:if> span6">
			<label class="control-label" for="attributeinput">attribute</label>
			<div class="controls">
				<form:input id="attributeinput" path="attribute" disabled="false" />
				<form:errors class="help-inline" path="attribute" />
				
			</div>
			
		</div>
		<c:set var="attribute2error">
			<form:errors path="attribute2" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> span6">
			<label class="control-label" for="attribute2input">attribute2</label>
			<div class="controls">
				<form:input id="attribute2input" path="attribute2" disabled="false" />
				<form:errors class="help-inline" path="attribute2" />
				
			</div>
			
		</div>
		<c:set var="attribute3error">
			<form:errors path="attribute3" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute3error}">error</c:if> span6">
			<label class="control-label" for="attribute3input">attribute3</label>
			<div class="controls">
				<form:input id="attribute3input" path="attribute3" disabled="false" />
				<form:errors class="help-inline" path="attribute3" />
				
			</div>
			
		</div>
		<c:set var="attribute4error">
			<form:errors path="attribute4" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute4error}">error</c:if> span6">
			<label class="control-label" for="attribute4input">attribute4</label>
			<div class="controls">
				<form:input id="attribute4input" path="attribute4" disabled="false" />
				<form:errors class="help-inline" path="attribute4" />
				
			</div>
			
		</div>
		<c:set var="attribute5error">
			<form:errors path="attribute5" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute5error}">error</c:if> span6">
			<label class="control-label" for="attribute5input">attribute5</label>
			<div class="controls">
				<form:input id="attribute5input" path="attribute5" disabled="false" />
				<form:errors class="help-inline" path="attribute5" />
				
			</div>
			
		</div>
		<c:set var="attribute6error">
			<form:errors path="attribute6" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute6error}">error</c:if> span6">
			<label class="control-label" for="attribute6input">attribute6</label>
			<div class="controls">
				<form:input id="attribute6input" path="attribute6" disabled="false" />
				<form:errors class="help-inline" path="attribute6" />
				
			</div>
			
		</div>
		<c:set var="attribute7error">
			<form:errors path="attribute7" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute7error}">error</c:if> span6">
			<label class="control-label" for="attribute7input">attribute7</label>
			<div class="controls">
				<form:input id="attribute7input" path="attribute7" disabled="false" />
				<form:errors class="help-inline" path="attribute7" />
				
			</div>
			
		</div>
		<c:set var="attribute8error">
			<form:errors path="attribute8" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute8error}">error</c:if> span6">
			<label class="control-label" for="attribute8input">attribute8</label>
			<div class="controls">
				<form:input id="attribute8input" path="attribute8" disabled="false" />
				<form:errors class="help-inline" path="attribute8" />
				
			</div>
			
		</div>
		<c:set var="attribute9error">
			<form:errors path="attribute9" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute9error}">error</c:if> span6">
			<label class="control-label" for="attribute9input">attribute9</label>
			<div class="controls">
				<form:input id="attribute9input" path="attribute9" disabled="false" />
				<form:errors class="help-inline" path="attribute9" />
				
			</div>
			
		</div>
		<c:set var="iderror">
			<form:errors path="id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty iderror}">error</c:if> span6">
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
		<th>attribute</th>
		<th>attribute2</th>
		<th>attribute3</th>
		<th>attribute4</th>
		<th>attribute5</th>
		<th>attribute6</th>
		<th>attribute7</th>
		<th>attribute8</th>
		<th>attribute9</th>
		<th>id</th>
		<th>
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass22/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass22List}" var="myClass22">
		<tr>
			<td>${myClass22.attribute}</td>
			<td>${myClass22.attribute2}</td>
			<td>${myClass22.attribute3}</td>
			<td>${myClass22.attribute4}</td>
			<td>${myClass22.attribute5}</td>
			<td>${myClass22.attribute6}</td>
			<td>${myClass22.attribute7}</td>
			<td>${myClass22.attribute8}</td>
			<td>${myClass22.attribute9}</td>
			<td>${myClass22.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass22/detail/${myClass22.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass22/edit/${myClass22.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

