<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>View MyClass76</h1>
<bR />
<fieldset>
	<div class="form-horizontal">
		<div class="row">
			<c:set var="attributeerror">
				<form:errors path="attribute" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attributeerror}">error</c:if> span6">
				<label class="control-label" for="attributeinput">attribute</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute}</span>
					<form:errors class="help-inline" path="attribute" />
					
				</div>
				
			</div>
			<c:set var="attribute2error">
				<form:errors path="attribute2" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> span6">
				<label class="control-label" for="attribute2input">attribute2</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute2}</span>
					<form:errors class="help-inline" path="attribute2" />
					
				</div>
				
			</div>
			<c:set var="attribute3error">
				<form:errors path="attribute3" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute3error}">error</c:if> span6">
				<label class="control-label" for="attribute3input">attribute3</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute3}</span>
					<form:errors class="help-inline" path="attribute3" />
					
				</div>
				
			</div>
			<c:set var="attribute4error">
				<form:errors path="attribute4" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute4error}">error</c:if> span6">
				<label class="control-label" for="attribute4input">attribute4</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute4}</span>
					<form:errors class="help-inline" path="attribute4" />
					
				</div>
				
			</div>
			<c:set var="attribute5error">
				<form:errors path="attribute5" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute5error}">error</c:if> span6">
				<label class="control-label" for="attribute5input">attribute5</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute5}</span>
					<form:errors class="help-inline" path="attribute5" />
					
				</div>
				
			</div>
			<c:set var="attribute6error">
				<form:errors path="attribute6" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute6error}">error</c:if> span6">
				<label class="control-label" for="attribute6input">attribute6</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute6}</span>
					<form:errors class="help-inline" path="attribute6" />
					
				</div>
				
			</div>
			<c:set var="attribute7error">
				<form:errors path="attribute7" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute7error}">error</c:if> span6">
				<label class="control-label" for="attribute7input">attribute7</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.attribute7}</span>
					<form:errors class="help-inline" path="attribute7" />
					
				</div>
				
			</div>
			<c:set var="iderror">
				<form:errors path="id" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty iderror}">error</c:if> span6">
				<label class="control-label" for="idinput">id</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass76.id}</span>
					<form:errors class="help-inline" path="id" />
					
				</div>
				
			</div>
			
		</div>
		<div class="form-actions">
			<a class="btn btn-primary" id="edit" href="<c:url value="/myclass76/edit/${myclass76.id}"/>">Edit</a>
			<a class="btn" id="cancel" href="<c:url value="/myclass76/list"/>">Back</a>
			
		</div>
		
	</div>
	
</fieldset>

