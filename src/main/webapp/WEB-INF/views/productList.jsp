<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%-- Header  files included in header.jsp--%>
<div class="container-wrapper container">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Checkout all the awesome products available now!!</p>
        </div>
        <table class="table table-hover table-stripped">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td width="25%"><img src="<c:url value="/static/images/${product.productId}.png"/> "
                             style="width: 100%";
                             class="img-thumbnail img-responsive"  alt="${product.productName}"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<c:url value="/viewProducts/${product.productId}"/>">
                        <span class="glyphicon glyphicon-info-sign btn-sm btn-success"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- /.container -->

<%--footer files included in footer.jsp--%>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
