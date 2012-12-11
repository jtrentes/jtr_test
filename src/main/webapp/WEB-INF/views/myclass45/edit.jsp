<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit MyClass45</h1>
<bR />
<form:form class="form-horizontal" method="POST" modelAttribute="myClass45">
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
		<c:set var="myclass54error">
			<form:errors path="myclass54.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass54error}">error</c:if> ">
			<label class="control-label" for="myclass54input">myclass54</label>
			<div class="controls">
				<form:select id="myclass54input" path="myclass54.id">
					<form:options items="${myClass54s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass54.id" />
				
			</div>
			
		</div>
		<c:set var="myclass46error">
			<form:errors path="myclass46.id" />
			
		</c:set>
		<div class="control-group <c:if test="${not empty myclass46error}">error</c:if> ">
			<label class="control-label" for="myclass46input">myclass46</label>
			<div class="controls">
				<form:select id="myclass46input" path="myclass46.id">
					<form:options items="${myClass46s}" itemValue="id" itemLabel="id" />
					<form:option value="0" label="------------------" />
					
				</form:select>
				<form:errors class="help-inline" path="myclass46.id" />
				
			</div>
			
		</div>
		
	</div>
	<div class="form-actions">
		<input class="btn btn-primary" id="save" type="submit" value="Save" />
		<a class="btn" id="cancel" href="<c:url value="/myclass45/edit/cancel"/>">Cancel</a>
		
	</div>
	
</form:form>

