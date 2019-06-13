
var helloModule = angular.module("helloModule",[]);
var myservice = function() {
	this.hello = function() {
	console.log('sayHello is calling..');	
	}
	return this;
}
//adding myservice to module
helloModule.factory("helloservice",myservice);
