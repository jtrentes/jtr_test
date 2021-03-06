<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass46</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass46Criteria">
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
		<c:set var="myclass30error">
			<form:errors path="myclass30" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass30error}">error</c:if> ">
			<label class="control-label" for="myclass30input">myclass30</label>
			<div class="controls">
				<form:select id="myclass30input" path="myclass30.id">
					<form:options items="${myClass30s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass30" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass46/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass46List}" var="myClass46">
		<tr>
			<td>${myClass46.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass46/detail/${myClass46.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass46/edit/${myClass46.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

