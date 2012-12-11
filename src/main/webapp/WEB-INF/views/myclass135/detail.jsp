<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>View MyClass135</h1>
<bR />
<fieldset>
	<div class="form-horizontal">
		<div class="row">
			<c:set var="iderror">
				<form:errors path="id" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty iderror}">error</c:if> ">
				<label class="control-label" for="idinput">id</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass135.id}</span>
					<form:errors class="help-inline" path="id" />
					
				</div>
				
			</div>
			
		</div>
		<div class="form-actions">
			<a class="btn btn-primary" id="edit" href="<c:url value="/myclass135/edit/${myclass135.id}"/>">Edit</a>
			<a class="btn" id="cancel" href="<c:url value="/myclass135/list"/>">Back</a>
			
		</div>
		
	</div>
	
</fieldset>

