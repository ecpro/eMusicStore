<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12 page-header">
            <h1>Product Details</h1>
            <p class="lead">Here is the detail information of the product</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-1 col-md-5">
            <img src="<c:url value="/static/images/${product.productId}.png"/>"  class="img-responsive center-block img-rounded img-thumbnail" alt="Responsive image">
        </div>
        <div class="col-md-5">
            <dl class="dl-horizontal">
                <dt>Product Name</dt>
                <dd>${product.productName}</dd>
                <dt>Description</dt>
                <dd>${product.productDescription}</dd>
                <dt>Manufacturer</dt>
                <dd>${product.productManufacturer}</dd>
                <dt>Category</dt>
                <dd>${product.productCategory}</dd>
                <dt>Condition</dt>
                <dd>${product.productCondition}</dd>
                <dt>Price</dt>
                <dd>${product.productPrice}</dd>
            </dl>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
