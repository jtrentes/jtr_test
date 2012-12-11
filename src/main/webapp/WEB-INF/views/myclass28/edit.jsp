<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass28</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass28">
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
		<c:set var="myclass25error">
			<form:errors path="myclass25.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass25error}">error</c:if> ">
			<label class="control-label" for="myclass25input">myclass25</label>
			<div class="controls">
				<form:select id="myclass25input" path="myclass25.id">
					<form:options items="${myClass25s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass25.id" />
				
			</div>
			
		</div>
		<c:set var="myclass115error">
			<form:errors path="myclass115.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass115error}">error</c:if> ">
			<label class="control-label" for="myclass115input">myclass115</label>
			<div class="controls">
				<form:select id="myclass115input" path="myclass115.id">
					<form:options items="${myClass115s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass115.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass28/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

