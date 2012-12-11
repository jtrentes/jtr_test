<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass43</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass43Criteria">
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
		<c:set var="myclass34error">
			<form:errors path="myclass34" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass34error}">error</c:if> ">
			<label class="control-label" for="myclass34input">myclass34</label>
			<div class="controls">
				<form:select id="myclass34input" path="myclass34.id">
					<form:options items="${myClass34s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass34" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass43/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass43List}" var="myClass43">
		<tr>
			<td>${myClass43.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass43/detail/${myClass43.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass43/edit/${myClass43.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

