<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClassCriteria">
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
		<c:set var="attribute2error">
			<form:errors path="attribute2" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> ">
			<label class="control-label" for="attribute2input">attribute2</label>
			<div class="controls">
				<form:input id="attribute2input" path="attribute2" disabled="false" />
				<form:errors class="help-inline" path="attribute2" />
				
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
		<c:set var="myclass2error">
			<form:errors path="myclass2" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass2error}">error</c:if> ">
			<label class="control-label" for="myclass2input">myclass2</label>
			<div class="controls">
				<form:select id="myclass2input" path="myclass2.id">
					<form:options items="${myClass2s}" itemValue="id" itemLabel="attribute" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass2" />
				
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
		<th>id</th>
		<th>
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClassList}" var="myClass">
		<tr>
			<td>${myClass.attribute}</td>
			<td>${myClass.attribute2}</td>
			<td>${myClass.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass/detail/${myClass.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass/edit/${myClass.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

