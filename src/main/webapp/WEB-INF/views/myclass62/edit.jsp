<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass62</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass62">
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
		<c:set var="myclass63error">
			<form:errors path="myclass63.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass63error}">error</c:if> ">
			<label class="control-label" for="myclass63input">myclass63</label>
			<div class="controls">
				<form:select id="myclass63input" path="myclass63.id">
					<form:options items="${myClass63s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass63.id" />
				
			</div>
			
		</div>
		<c:set var="myclass35error">
			<form:errors path="myclass35.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass35error}">error</c:if> ">
			<label class="control-label" for="myclass35input">myclass35</label>
			<div class="controls">
				<form:select id="myclass35input" path="myclass35.id">
					<form:options items="${myClass35s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass35.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass62/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

