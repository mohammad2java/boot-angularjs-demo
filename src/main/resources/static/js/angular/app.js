var myApp = angular.module('myApp',['helloModule']);
myApp.controller('myController',function($scope,$log,$http,helloservice){
	$scope.doColo='amir';
	$scope.testHell='testhello'
	//console.info($scope);
	/*$http.get("http://dummy.restapiexample.com/api/v1/employees")
	.then(function(result){
		//console.info(result);
	},function(data){
		console.info(data);
	});
*/	
	//helloservice.hello();
		
	//$scope.cities =['mumbai','pune','kolkata'];

	$scope.doColor = function() {
		console.info("hELLO")
		return true;
		
	}
	
	$scope.testHello = function() {
		console.log('testHello');
	}
	
	/*$scope.$watch('myfo.name',function(newValue,oldValue) {
		console.info("watcher called.."+newValue+" "+oldValue);
	});
	
	$scope.$watch('myfo.email',function(newValue,oldValue) {
		console.info("watcher called.."+newValue+" "+oldValue);
	});*/
});
