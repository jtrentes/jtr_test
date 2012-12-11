<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass74</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass74Criteria">
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
		<c:set var="myclass117error">
			<form:errors path="myclass117" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass117error}">error</c:if> ">
			<label class="control-label" for="myclass117input">myclass117</label>
			<div class="controls">
				<form:select id="myclass117input" path="myclass117.id">
					<form:options items="${myClass117s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass117" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass74/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass74List}" var="myClass74">
		<tr>
			<td>${myClass74.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass74/detail/${myClass74.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass74/edit/${myClass74.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

