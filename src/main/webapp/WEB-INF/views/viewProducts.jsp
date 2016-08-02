<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12 page-header">
            <h1>Product Details</h1>
            <p class="lead">Here is the detail information of the product</p>
        </div>
    </div>
    <div class="row" ng-app="cartApp">
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
            <c:set var="role" scope="page" value="${param.role}"/>
            <c:set var="url" scope="page" value="/products/productList"/>
            <c:if test="${role = 'admin'}" >
                <c:set var="url" scope="page" value="/admin/productInventory"/>
            </c:if>

            <p ng-controller="cartCtrl" >
                <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                <a href="#" class="btn btn-warning" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                <a href="<c:url value="/cart"/>" class="btn btn-default"/><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
            </p>
        </div>
    </div>
</div>
<script src="<c:url value="/static/js/controller.js"/>"></script>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
