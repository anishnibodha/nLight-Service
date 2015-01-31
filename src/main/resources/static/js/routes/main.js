
var nlight = angular.module("nlight",["ngRoute","ui.directives","nsPopover"]);
 app.config(function($routeProvider){
	$routeProvider
		.when('/nextnav-form',{templateUrl:'nextnav-form.html',controller:'nextNavFormCtrl'})
		.otherwise({redirectTo:'/nextnav-form'})
 });
 






 