/**
 * Created by Le on 1/11/2016.
 */

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/eMusicStore/rest/cart/'+$scope.cartId).success(function (data) {
            console.log(data);
            $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/eMusicStore/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.addToCart = function (productId) {
        console.log(productId)
        $http({
            method : 'PUT',
            url : '/eMusicStore/rest/cart/add/' + productId
        }).then(function() {
            alert(productId + "added successfully to the cart");
        })
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/eMusicStore/rest/cart/remove/'+productId).success(function () {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };
});