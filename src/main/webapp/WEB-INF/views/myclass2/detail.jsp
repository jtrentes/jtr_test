<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>View MyClass2</h1>
<bR />
<fieldset>
	<div class="form-horizontal">
		<div class="row">
			<c:set var="attributeerror">
				<form:errors path="attribute" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attributeerror}">error</c:if> ">
				<label class="control-label" for="attributeinput">attribute</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass2.attribute}</span>
					<form:errors class="help-inline" path="attribute" />
					
				</div>
				
			</div>
			<c:set var="attribute2error">
				<form:errors path="attribute2" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> ">
				<label class="control-label" for="attribute2input">attribute2</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass2.attribute2}</span>
					<form:errors class="help-inline" path="attribute2" />
					
				</div>
				
			</div>
			<c:set var="attribute3error">
				<form:errors path="attribute3" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute3error}">error</c:if> ">
				<label class="control-label" for="attribute3input">attribute3</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass2.attribute3}</span>
					<form:errors class="help-inline" path="attribute3" />
					
				</div>
				
			</div>
			<c:set var="iderror">
				<form:errors path="id" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty iderror}">error</c:if> ">
				<label class="control-label" for="idinput">id</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass2.id}</span>
					<form:errors class="help-inline" path="id" />
					
				</div>
				
			</div>
			
		</div>
		<div class="form-actions">
			<a class="btn btn-primary" id="edit" href="<c:url value="/myclass2/edit/${myclass2.id}"/>">Edit</a>
			<a class="btn" id="cancel" href="<c:url value="/myclass2/list"/>">Back</a>
			
		</div>
		
	</div>
	
</fieldset>

