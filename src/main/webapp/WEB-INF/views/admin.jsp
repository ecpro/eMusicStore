<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container container-wrapper">
    <div class="page-header">
        <h1>Administrator Page</h1>
        <p class="lead">This is a administrator page</p>
        <h3><a class=" btn btn-lg btn-success" href="<c:url value="/admin/productInventory"/>">Product Inventory</a></h3>

        <p>Here you can view, check and modify product inventory.</p>
    </div>
</div>




<%@ include file="/WEB-INF/views/template/footer.jsp"%>