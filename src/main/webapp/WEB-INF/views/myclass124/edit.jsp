<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass124</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass124">
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
		<c:set var="myclass140error">
			<form:errors path="myclass140.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass140error}">error</c:if> ">
			<label class="control-label" for="myclass140input">myclass140</label>
			<div class="controls">
				<form:select id="myclass140input" path="myclass140.id">
					<form:options items="${myClass140s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass140.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass124/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

