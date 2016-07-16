<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%-- Header  files included in header.jsp--%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory</h1>
            <p class="lead">Here you check all your products in the inventory.</p>
        </div>
        <table class="table table-hover table-stripped">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Info</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td width="25%"><img src="<c:url value="/static/images/${product.productId}.png"/> "
                                         style="width:100%"
                                         class="img-responsive img-responsive" alt="${product.productName}"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<c:url value="/viewProducts/${product.productId}"/>">
                        <span class="glyphicon glyphicon-info-sign btn-sm btn-success"></span></a></td>
                    <td><a href="<c:url value="/admin/productInventory/deleteProduct/${product.productId}"/>">
                        <span class="glyphicon glyphicon-remove btn-sm btn-danger"></span></a></td>
                    <td><a href="<c:url value="/admin/productInventory/editProduct/${product.productId}"/>">
                        <span class="glyphicon glyphicon-pencil btn-sm btn-info"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class=" btn btn-lg btn-success" href="<c:url value="/admin/productInventory/addProduct"/>">Add Product</a>
    </div>
</div>
<!-- /.container -->

<%--footer files included in footer.jsp--%>
<br>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
