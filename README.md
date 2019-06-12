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
	
	
	
--------------------
List of directive and used
-----------------------------
ng-app
ng-init
ng-controller
ng-model
ng-if
ng-show
ng-hide
ng-class
ng-repeat

	