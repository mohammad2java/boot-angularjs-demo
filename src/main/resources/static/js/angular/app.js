var myApp = angular.module('myApp',[]);
myApp.controller('myController',function($scope,$log,$http){

	$http.get("http://dummy.restapiexample.com/api/v1/employees")
	.then(function(result){
		console.log(result);
	},function(data){
		console.log(data);
	});
	//$scope.visibleSection=false;
	$scope.cities =['mumbai','pune','kolkata'];
	$scope.doColor = function() {
		//$scope.visibleSection=true;
		//console.log($scope.myfo);
		console.log("hELLO")
		return true;
		
	}
	
	$scope.testHello = function() {
		console.log('testHello');
	}
	
});
