<%@ include file="header.jsp" %>
<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">

    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Product Name</th>
    <th>Product Price</th>
    <th>Quantity</th>
     <th>Product Image</th>
    </tr>
        <tr >
             <td>${product.prodid}</td>
            <td>${product.name}</td>
             <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><img src="resources/images/${product.name}.jpg" style=height:100px;width:100px;"/></td>
            <td><a href="#">Add to Cart</a></td>
            
        </tr>    
    </table>
</div>

</body>

</html>
