<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass7</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass7">
	<div class="row">
		<c:set var="attributeerror">
			<form:errors path="attribute" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attributeerror}">error</c:if> span6">
			<label class="control-label" for="attributeinput">attribute</label>
			<div class="controls">
				<form:input id="attributeinput" path="attribute" disabled="false" />
				<form:errors class="help-inline" path="attribute" />
				
			</div>
			
		</div>
		<c:set var="attribute2error">
			<form:errors path="attribute2" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> span6">
			<label class="control-label" for="attribute2input">attribute2</label>
			<div class="controls">
				<form:input id="attribute2input" path="attribute2" disabled="false" />
				<form:errors class="help-inline" path="attribute2" />
				
			</div>
			
		</div>
		<c:set var="attribute3error">
			<form:errors path="attribute3" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute3error}">error</c:if> span6">
			<label class="control-label" for="attribute3input">attribute3</label>
			<div class="controls">
				<form:input id="attribute3input" path="attribute3" disabled="false" />
				<form:errors class="help-inline" path="attribute3" />
				
			</div>
			
		</div>
		<c:set var="attribute4error">
			<form:errors path="attribute4" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute4error}">error</c:if> span6">
			<label class="control-label" for="attribute4input">attribute4</label>
			<div class="controls">
				<form:input id="attribute4input" path="attribute4" disabled="false" />
				<form:errors class="help-inline" path="attribute4" />
				
			</div>
			
		</div>
		<c:set var="attribute5error">
			<form:errors path="attribute5" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute5error}">error</c:if> span6">
			<label class="control-label" for="attribute5input">attribute5</label>
			<div class="controls">
				<form:input id="attribute5input" path="attribute5" disabled="false" />
				<form:errors class="help-inline" path="attribute5" />
				
			</div>
			
		</div>
		<c:set var="attribute6error">
			<form:errors path="attribute6" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute6error}">error</c:if> span6">
			<label class="control-label" for="attribute6input">attribute6</label>
			<div class="controls">
				<form:input id="attribute6input" path="attribute6" disabled="false" />
				<form:errors class="help-inline" path="attribute6" />
				
			</div>
			
		</div>
		<c:set var="attribute7error">
			<form:errors path="attribute7" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty attribute7error}">error</c:if> span6">
			<label class="control-label" for="attribute7input">attribute7</label>
			<div class="controls">
				<form:input id="attribute7input" path="attribute7" disabled="false" />
				<form:errors class="help-inline" path="attribute7" />
				
			</div>
			
		</div>
		<c:set var="iderror">
			<form:errors path="id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty iderror}">error</c:if> span6">
			<label class="control-label" for="idinput">id</label>
			<div class="controls">
				<form:input id="idinput" path="id" disabled="true" />
				<form:errors class="help-inline" path="id" />
				
			</div>
			
		</div>
		<c:set var="myclass69error">
			<form:errors path="myclass69.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass69error}">error</c:if> span6">
			<label class="control-label" for="myclass69input">myclass69</label>
			<div class="controls">
				<form:select id="myclass69input" path="myclass69.id">
					<form:options items="${myClass69s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass69.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass7/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

