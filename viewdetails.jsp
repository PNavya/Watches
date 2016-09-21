<%@ include file="header.jsp" %>
 
   <div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">
   <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  
   <table class="table table-bordered table-striped">
             
    <thead>
      <tr>       
        <td>
          <a href="#" ng-click="sortType = 'name'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'image'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'image' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'image' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          More
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="product in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
                
           		<td>{{product.name}}</td>
           		<td>{{product.price}}</td>
           		<td><img src="resources/images/{{ product.prodid}}.jpg" style="width:100px;height:100px"></td>
           		<td><a href="viewproducts?prodid={{product.prodid}}">View</a></td>
   
           	
      </tr>
    </tbody>
    
  </table>
  
</div>

    
    <%@ include file="footer.jsp" %>