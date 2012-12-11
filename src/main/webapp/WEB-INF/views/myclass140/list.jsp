<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass140</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass140Criteria">
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
		<c:set var="myclass97error">
			<form:errors path="myclass97" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass97error}">error</c:if> ">
			<label class="control-label" for="myclass97input">myclass97</label>
			<div class="controls">
				<form:select id="myclass97input" path="myclass97.id">
					<form:options items="${myClass97s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass97" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass140/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass140List}" var="myClass140">
		<tr>
			<td>${myClass140.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass140/detail/${myClass140.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass140/edit/${myClass140.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

