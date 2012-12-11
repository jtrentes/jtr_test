<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>List MyClass62</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass62Criteria">
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
		<c:set var="myclass63error">
			<form:errors path="myclass63" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass63error}">error</c:if> ">
			<label class="control-label" for="myclass63input">myclass63</label>
			<div class="controls">
				<form:select id="myclass63input" path="myclass63.id">
					<form:options items="${myClass63s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass63" />
				
			</div>
			
		</div>
		<c:set var="myclass35error">
			<form:errors path="myclass35" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass35error}">error</c:if> ">
			<label class="control-label" for="myclass35input">myclass35</label>
			<div class="controls">
				<form:select id="myclass35input" path="myclass35.id">
					<form:options items="${myClass35s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass35" />
				
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
			<a class="btn btn-primary pull-right" href="<c:url value="/myclass62/edit"/>">New</a>
			
		</th>
		
	</tr>
	<c:forEach items="${myClass62List}" var="myClass62">
		<tr>
			<td>${myClass62.id}</td>
			<td>
				<a class="btn" href="<c:url value="/myclass62/detail/${myClass62.id}"/>">View</a>
				<a class="btn" href="<c:url value="/myclass62/edit/${myClass62.id}"/>">Edit</a>
				
			</td>
			
		</tr>
		
	</c:forEach>
	
</table>

