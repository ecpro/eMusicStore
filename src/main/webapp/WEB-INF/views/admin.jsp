<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container container-wrapper">
    <div class="page-header">
        <h1>Administrator Page</h1>
        <p class="lead">This is a administrator page</p>
        <h3><a class=" btn btn-lg btn-success" href="<c:url value="/admin/productInventory"/>">Product Inventory</a></h3>
        <h2>Welcome ${pageContext.request.userPrincipal.name} |
            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a> </h2>
        <p>Here you can view, check and modify product inventory.</p>
    </div>
</div>




<%@ include file="/WEB-INF/views/template/footer.jsp"%>