<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass97</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass97">
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
		<c:set var="myclass133error">
			<form:errors path="myclass133.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass133error}">error</c:if> ">
			<label class="control-label" for="myclass133input">myclass133</label>
			<div class="controls">
				<form:select id="myclass133input" path="myclass133.id">
					<form:options items="${myClass133s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass133.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass97/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

