<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass51</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass51Criteria">
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
		<c:set var="myclass17error">
			<form:errors path="myclass17" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass17error}">error</c:if> ">
			<label class="control-label" for="myclass17input">myclass17</label>
			<div class="controls">
				<form:select id="myclass17input" path="myclass17.id">
					<form:options items="${myClass17s}" itemValue="id" itemLabel="attribute" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass17" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass51/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass51List}" var="myClass51">
		<tr>
			<td>${myClass51.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass51/detail/${myClass51.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass51/edit/${myClass51.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

