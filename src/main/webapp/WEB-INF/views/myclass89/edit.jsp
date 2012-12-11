<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass89</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass89">
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
		<c:set var="myclass124error">
			<form:errors path="myclass124.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass124error}">error</c:if> ">
			<label class="control-label" for="myclass124input">myclass124</label>
			<div class="controls">
				<form:select id="myclass124input" path="myclass124.id">
					<form:options items="${myClass124s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass124.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass89/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

