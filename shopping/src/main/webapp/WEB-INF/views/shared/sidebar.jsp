<p class="lead">Shop Name</p>

<c:if test="${empty categories}">
	<p>Hereeee testing will show when category is empty</p>
</c:if>

<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" id="a_${category.name}" class="list-group-item">${category.name}</a>
	</c:forEach>
</div>