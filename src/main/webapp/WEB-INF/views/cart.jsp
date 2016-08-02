<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class=""><br><br><br>
</div>
<div class="container jumbotron" ng-app="cartApp" ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
    <div class="row">
        <div class="col-sm-10">
            <h1><small>all the items in your cart</small></h1>
            <p class="lead">you can add or remove items</p>
        </div>
        <div class="col-sm-2">
            <a style="margin-top:60px" class="btn btn-block btn-lg btn-danger pull-left" href="#" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>&nbsp;Clear Cart</a>
        </div>
    </div>
    <div class="row">
        <div class="">
            <table class="table table-responsive table-hover">
                <thead class="active">
                <tr class="success">
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody class="">
                <tr ng-repeat ="item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"><span class="glyphicon glyphicon-remove"></span> remove</a></td>
                </tr>
                <tr class="active warning">
                    <td colspan="3">Grand Total</td>
                    <td colspan="2">{{cart.grandTotal}}</td>
                </tr>
                </tbody>
            </table>
            </table>
            <a href="<c:url value="/products/productList"/>" class="btn btn-info">Continue shopping</a>
        </div>
    </div>
    <script src="<c:url value="/static/js/controller.js"/>"></script>

</div>




<%@include file="/WEB-INF/views/template/footer.jsp" %>
