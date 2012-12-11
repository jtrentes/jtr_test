<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass51</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass51">
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
		<c:set var="myclass17error">
			<form:errors path="myclass17.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass17error}">error</c:if> ">
			<label class="control-label" for="myclass17input">myclass17</label>
			<div class="controls">
				<form:select id="myclass17input" path="myclass17.id">
					<form:options items="${myClass17s}" itemValue="id" itemLabel="attribute" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass17.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass51/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

