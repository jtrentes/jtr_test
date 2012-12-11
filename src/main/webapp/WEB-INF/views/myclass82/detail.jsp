<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>View MyClass82</h1>
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
					<span class="input-large uneditable-input">${myClass82.attribute}</span>
					<form:errors class="help-inline" path="attribute" />
					
				</div>
				
			</div>
			<c:set var="attribute2error">
				<form:errors path="attribute2" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute2error}">error</c:if> span6">
				<label class="control-label" for="attribute2input">attribute2</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute2}</span>
					<form:errors class="help-inline" path="attribute2" />
					
				</div>
				
			</div>
			<c:set var="attribute3error">
				<form:errors path="attribute3" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute3error}">error</c:if> span6">
				<label class="control-label" for="attribute3input">attribute3</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute3}</span>
					<form:errors class="help-inline" path="attribute3" />
					
				</div>
				
			</div>
			<c:set var="attribute4error">
				<form:errors path="attribute4" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute4error}">error</c:if> span6">
				<label class="control-label" for="attribute4input">attribute4</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute4}</span>
					<form:errors class="help-inline" path="attribute4" />
					
				</div>
				
			</div>
			<c:set var="attribute5error">
				<form:errors path="attribute5" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute5error}">error</c:if> span6">
				<label class="control-label" for="attribute5input">attribute5</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute5}</span>
					<form:errors class="help-inline" path="attribute5" />
					
				</div>
				
			</div>
			<c:set var="attribute6error">
				<form:errors path="attribute6" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute6error}">error</c:if> span6">
				<label class="control-label" for="attribute6input">attribute6</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute6}</span>
					<form:errors class="help-inline" path="attribute6" />
					
				</div>
				
			</div>
			<c:set var="attribute7error">
				<form:errors path="attribute7" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute7error}">error</c:if> span6">
				<label class="control-label" for="attribute7input">attribute7</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute7}</span>
					<form:errors class="help-inline" path="attribute7" />
					
				</div>
				
			</div>
			<c:set var="attribute8error">
				<form:errors path="attribute8" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute8error}">error</c:if> span6">
				<label class="control-label" for="attribute8input">attribute8</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute8}</span>
					<form:errors class="help-inline" path="attribute8" />
					
				</div>
				
			</div>
			<c:set var="attribute9error">
				<form:errors path="attribute9" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute9error}">error</c:if> span6">
				<label class="control-label" for="attribute9input">attribute9</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute9}</span>
					<form:errors class="help-inline" path="attribute9" />
					
				</div>
				
			</div>
			<c:set var="attribute10error">
				<form:errors path="attribute10" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute10error}">error</c:if> span6">
				<label class="control-label" for="attribute10input">attribute10</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute10}</span>
					<form:errors class="help-inline" path="attribute10" />
					
				</div>
				
			</div>
			<c:set var="attribute11error">
				<form:errors path="attribute11" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute11error}">error</c:if> span6">
				<label class="control-label" for="attribute11input">attribute11</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute11}</span>
					<form:errors class="help-inline" path="attribute11" />
					
				</div>
				
			</div>
			<c:set var="attribute12error">
				<form:errors path="attribute12" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute12error}">error</c:if> span6">
				<label class="control-label" for="attribute12input">attribute12</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute12}</span>
					<form:errors class="help-inline" path="attribute12" />
					
				</div>
				
			</div>
			<c:set var="attribute13error">
				<form:errors path="attribute13" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute13error}">error</c:if> span6">
				<label class="control-label" for="attribute13input">attribute13</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute13}</span>
					<form:errors class="help-inline" path="attribute13" />
					
				</div>
				
			</div>
			<c:set var="attribute14error">
				<form:errors path="attribute14" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute14error}">error</c:if> span6">
				<label class="control-label" for="attribute14input">attribute14</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute14}</span>
					<form:errors class="help-inline" path="attribute14" />
					
				</div>
				
			</div>
			<c:set var="attribute15error">
				<form:errors path="attribute15" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute15error}">error</c:if> span6">
				<label class="control-label" for="attribute15input">attribute15</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute15}</span>
					<form:errors class="help-inline" path="attribute15" />
					
				</div>
				
			</div>
			<c:set var="attribute16error">
				<form:errors path="attribute16" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute16error}">error</c:if> span6">
				<label class="control-label" for="attribute16input">attribute16</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute16}</span>
					<form:errors class="help-inline" path="attribute16" />
					
				</div>
				
			</div>
			<c:set var="attribute17error">
				<form:errors path="attribute17" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute17error}">error</c:if> span6">
				<label class="control-label" for="attribute17input">attribute17</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute17}</span>
					<form:errors class="help-inline" path="attribute17" />
					
				</div>
				
			</div>
			<c:set var="attribute18error">
				<form:errors path="attribute18" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty attribute18error}">error</c:if> span6">
				<label class="control-label" for="attribute18input">attribute18</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.attribute18}</span>
					<form:errors class="help-inline" path="attribute18" />
					
				</div>
				
			</div>
			<c:set var="iderror">
				<form:errors path="id" />
				
			</c:set>
			<div class="control-group <c:if test="${not empty iderror}">error</c:if> span6">
				<label class="control-label" for="idinput">id</label>
				<div class="controls">
					<span class="input-large uneditable-input">${myClass82.id}</span>
					<form:errors class="help-inline" path="id" />
					
				</div>
				
			</div>
			
		</div>
		<div class="form-actions">
			<a class="btn btn-primary" id="edit" href="<c:url value="/myclass82/edit/${myclass82.id}"/>">Edit</a>
			<a class="btn" id="cancel" href="<c:url value="/myclass82/list"/>">Back</a>
			
		</div>
		
	</div>
	
</fieldset>

