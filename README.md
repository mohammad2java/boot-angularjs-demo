AngularJS-1.7.8(1.x)
--------------------
	This is javascript framework works based on client side MVC framework.
	this contains module ,controller, directive ,data-binding and services.
	
	->"Module" is one type of app object which can contains many controller,and extends many modules, each module having ng prefix like ngMessages etc. 
	
	->"Controller" is a function which use to make page interactive and sharing model to controller vice versa.
	
	->"Directive" is just custom html attribute that use to apply angular effect on html page. each directive having prefix of ng- or data-ng- 
		example ng-init or ng-app or ng-if etc.
	
	->"Data-Binding" is way to bind view data to $scope (predefined object) and that object can be inject-able in controller. 
		we use {{@scope object variable-name or ng-model name}} to display the content in view.
	
	->"services" is list of object and that can be inject-able in controller.each inbuilt services having $ prefix like $scope or $log etc.
	 default (ng) services list-https://docs.angularjs.org/api/ng/service
	$scope,$log,$filter,$http,$controller etc..

	$scope is prototype object/service henece most of services are singleton like $log,$http and so on.


Module or app
-------------------
	To apply angular effect on page - You must associate angular module to area of page.  
				how to create app or module using angular(inbuilt) object 
			
				var varName = angular.module('moduleName',[]);
		
		
			how to associated module to html page.
				using 'ng-app' directive
				example:
				<html ng-app="myApp"> --this will effect on whole page.
				<body ng-app="myApp">--This will effect on body area of page.	
		
		example
		-------
		
		var myApp = angular.module('myApp',[]);
		
		[] is empty array for module to extends .
		
		var myApp = angular.module('myApp',['ngMessages']);
		
		this myApp module also having the feature(services) of ngMessage module.
		

Controller
-------------
		each controller must belong to module.so controller can be created only using module object.
		
		var myApp = angular.module('myApp',[]);
		
		myApp.controller('nameOfController',function(//can be inject list of services){
		//body of controller
		}
		);
		
		example:
		
		myApp.controller('myController',function($scope){
		// here $scope object has been injected.
		// to see object content
		console.log($scope);
		}
		);

-----------------------------


How to setup angular project with webpage.
----------------------------------------

	-> Just adding js file into head section 
	
	example:
	<Head>
	<script src="https://code.angularjs.org/1.7.8/angular-messages.min.js"></script>
	<script src="/js/angular/app.js"></script>	
	</Head>
	
	
how to create service and add service
-------------------------------------
	var mainApp = angular.module("mainApp", []);
	mainApp.factory('MathService', function() {
	   var factory = {};
	   
	   factory.multiply = function(a, b) {
	      return a * b
	   }
	   
	   return factory;
	}); 	
	
	//adding service to controllers.
	
	myApp.controller('myController',function($scope,MathService){
		// here $scope object has been injected.
		// to see object content
		console.log($scope);
		}
		);
	
    -> 'return factory' is mandatory in case of used factory method to add service.	
   
	 -> if you are outofscope of mainApp object. then you can use angular object 
	   to add service(basically this is use if you are make app module in different file from service object.)
	   	
	   	angular.module('mainApp').factory('MathService', MathServiceObject);
	   
    
    

using service method of module(verified..tested..)
------------------------------------------

	var helloModule = angular.module("helloModule",[]);
	var myservice = function() {
		this.hello = function() {
		console.log('sayHello is calling..');	
		}
	}
	//adding myservice to module
	helloModule.service("helloservice",myservice);

	//added into controllers.
	var myApp = angular.module('myApp',['helloModule']);
	myApp.controller('myController',function($scope,$log,$http,helloservice){
				helloservice.hello();		
	});
		

how to include javascript/jquery code into angularjs scope
----------------------------------------------------------	
	$scope.$apply(function() {
	//write javascript/or jquery code.
	}
	);
	
	this function will tell angularjs to update dom and run digest cycle.
	
	
	
Note: (wachers and digest cycle)
---------------------------
	There few directive who attached with watcher along with field..
	like {{}},ng-if,ng-show,ng-hide which called two times on loading page .	

--------------------------------------------------------
List of directive and used
-----------------------------
	{{}}  --to display value on page.
	ng-app  --to apply angular effect on page.
	ng-init  -- to intial $scope model value.
	ng-controller  ---to attched controller function for scope and event handling.
	ng-model    ---to attach html element with scope variable called model.
	ng-if		---true/false to render inside code of ng-if.
	ng-show     ---true/false to render inside code of ng-show.
	ng-hide		-----just opposite of ng-show.
	ng-class  ----to add runtime class based on some condition true/false.  example:== 
	<div 	ng-class="'class-name':condition/function()"> </div>
	ng-repeat	--loop to repeat element based on list size.	  
	example-- <div ng-repeat="stduent in students"></div>
	
	
	
Html Hashpath and Angular-single-page application --routing(using lower version-(1.3.0-beta.18) because found issue with 1.7.8 version.)
----------------------------------------------------------------------------------------------------------------------------------------
	url looks ---templates/app/view/index.html#bookmarkId
	link tag 
	<a href ="#bookmarkId">click here to go book mark page</a>	
	bookmark point in page
	<a name="bookmarkId">This is starting point of bookmark page</a>..	

	This works like new url without page loading ..
	
	angular routing means --
	using hash(bookmark) getting content of other page and append to current page.
	1-first add <script src="https://code.angularjs.org/1.3.0-beta.18/angular-route.min.js"></script>
	2- add module as dependency in app module.
	 like var myApp = angular.module('myApp',['helloModule','ngRoute']);
	3- config the route or bookmark using hash or routepath.
	like
		myApp.config(function($routeProvider){
		$routeProvider
		.when('/bookmarkId',{
			templateUrl:'/templates/app/view/bookmark.html',
			controller: 'nameofcontroller'  //[this is optional]
		})
		.otherwise({ redirectTo: '/' });
		});
	
	4- appending page content of templateUrl into current page.
			<div ng-view></div>
	
	
	
	note-->> you call bookmark-page using angularcode.
			like $location.path('/caselist'); 
			
	
angular-route dynamic path
--------------------------------------
	you can make dynamic bookmark-path or hash
	like 
	.when('/student/:stID', {
	    	    templateUrl: 'views/stduentcontent.html',
	       }); 
	       
	    :stID with be replace by value.
	    
	    
		------angularjs end



	--thymeleaf started from here--------------------------------------------------------------------

Thymeleaf template engine framework concept
=======================================================
	This is just java template engine which expcet xHtml tag.
	xHTML means html tags standard to xml(every tag must have ending tag also like xml)
	-> it works based on tag attribute:(like angularjs directive)
	->it support all html attribute + some extra from thymeleaf.

Thymeleaf setup
---------------------
	in spring boot----just add thymeleaf dependency.
	in html   --- just add xmlns =th:http://www.thymeleaf.org with root tag
	example:
	<html xmlns:th="https://www.thymeleaf.org/">



important thymeleaf attribute and concept.
------------------------------------------
th:text
th:utext
th:each
th:if
th:switch
th:<html-attribute>
<html-attribute>  like href ,src,

th:text explanation
--------------------
	there are 2 ways to replace the value of text
	1- using #{}
	th:text="#{thy_hello}">
	thyleaf engine will check i18n properties file for key- 'thy_hello'
	
	2- using ${}
	th:text="${thy_hello}">
	thyleaf engine will check ModelMap object to find value for key- 'thy_hello'	    
	

th:utext explanation
-----------------------
	this is same as th:text explanation except 
	if you want to add html code as text then this tag can be work.	      
	
String concatenation
-------------------------
	<p th:text="|#{thy_hello} string-concat ${thy_hello}|">	
	 
	 
standard expression
------------------------
1-Simple expressions:
--------------------------
	
	Variable Expressions: ${...}
	Selection Variable Expressions: *{...}  /mostly use in html form.
	Message Expressions: #{...}
	Link URL Expressions: @{...}
	
2-Literals
-----------------	
	Text literals: 'one text', 'Another one!',…
	Number literals: 0, 34, 3.0, 12.3,…
	Boolean literals: true, false
	Null literal: null
	Literal tokens: one, sometext, main,…
	
3-Text operations:
-----------------------
	String concatenation: +
	Literal substitutions: |The name is ${name}|
	Arithmetic operations:
	Binary operators: +, -, *, /, %
	Minus sign (unary operator): -
	Boolean operations:
	Binary operators: and, or
	Boolean negation (unary operator): !, not
	
4-Comparisons and equality:
-------------------------
	Comparators: >, <, >=, <= (gt, lt, ge, le)
	Equality operators: ==, != (eq, ne)
	
5-Conditional operators:
---------------------------------
	If-then: (if) ? (then)
	If-then-else: (if) ? (then) : (else)
	Default: (value) ?: (defaultvalue)	 
	example:
<tr th:class="${row.even}? 'even' : 'odd'"></tr>
<td th:text="${prod.inStock}? #{true} : #{false}">yes</td>	

th:each
------------
	   <tr th:each="prod : ${prods}">
        <td th:text="${prod.name}">Onions</td>
        <td th:text="${prod.price}">2.41</td>
        <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
      </tr>
  	
  	
th:if
-----------
	 th:if="${not #lists.isEmpty(prod.comments)}"
	 th:if="${lists.isEmpty(prod.comments)}"

th:switch
----------
	<div th:switch="${user.role}">
	  <p th:case="'admin'">User is an administrator</p>
	  <p th:case="#{roles.manager}">User is a manager</p>
	</div>

th:object , th:field ,th:errors
------------------------------
	th:object-this use with formModel
	th:field-this use with form field
	th:errors - use for displaying validation error message.
	
	example:
	
	<form action="/thymeleafsave" method="post" th:object="${formdata}">
	UserName: <input type="text" name="username" th:field="*{username}" /><span  th:errors="*{username}">username-error</span><br/>
	Password: <input type="text" name="password" th:field="*{password}" /><span th:errors="*{password}">password-error</span><br/>
	Repeat Password: <input type="text" name="repeatpass" th:field="*{repeatpass}" /><span th:errors="*{repeatpass}">password-error</span><br/>
	
	<input type="submit" value="createUser" />
	</form>


	   