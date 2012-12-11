<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass63</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass63">
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
		<c:set var="myclass8error">
			<form:errors path="myclass8.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass8error}">error</c:if> ">
			<label class="control-label" for="myclass8input">myclass8</label>
			<div class="controls">
				<form:select id="myclass8input" path="myclass8.id">
					<form:options items="${myClass8s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass8.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass63/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

