<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass30</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass30">
	<div class="row">
		<c:set var="iderror">
			<form:errors path="id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty iderror}">error</c:if> ">
			<label class="control-label" for="idinput">id</label>
			<div class="controls">
				<form:input id="idinput" path="id" disabled="true" />
				<form:errors class="help-inline" path="id" />
				
			</div>
			
		</div>
		<c:set var="myclass31error">
			<form:errors path="myclass31.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass31error}">error</c:if> ">
			<label class="control-label" for="myclass31input">myclass31</label>
			<div class="controls">
				<form:select id="myclass31input" path="myclass31.id">
					<form:options items="${myClass31s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass31.id" />
				
			</div>
			
		</div>
		<c:set var="myclass107error">
			<form:errors path="myclass107.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass107error}">error</c:if> ">
			<label class="control-label" for="myclass107input">myclass107</label>
			<div class="controls">
				<form:select id="myclass107input" path="myclass107.id">
					<form:options items="${myClass107s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass107.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass30/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

