'use strict';

var AngularSpringApp = {};

var nlight = angular.module('nlight', ['ngRoute','ngTable','ngFacebook','ui.bootstrap']);

// Declare app level module which depends on filters, and services
nlight.config(['$routeProvider','$facebookProvider', function ($routeProvider,$facebookProvider) {
	$facebookProvider.setAppId('1516003982007229');
    $routeProvider.when('/login', {
        templateUrl: 'templates/login.html',
        controller: LoginController
    });

   $routeProvider.when('/home', {
        templateUrl: 'templates/home.html',
        controller: HomeController
    });
   
   $routeProvider.when('/reports', {
       templateUrl: 'templates/reports.html',
       controller: ReportController
   });
    

    /*$routeProvider.when('/mainpage', {
        templateUrl: 'templates/mainpage.html',
        controller: MainPageController
    });*/

    $routeProvider.otherwise({redirectTo: '/login'});
}])
.run( function( $rootScope ) {
	// Load the facebook SDK asynchronously
	  (function(){
	     // If we've already installed the SDK, we're done
	     if (document.getElementById('facebook-jssdk')) {return;}

	     // Get the first script element, which we'll use to find the parent node
	     var firstScriptElement = document.getElementsByTagName('script')[0];

	     // Create a new script element and set its id
	     var facebookJS = document.createElement('script'); 
	     facebookJS.id = 'facebook-jssdk';

	     // Set the new script's source to the source of the Facebook JS SDK
	     facebookJS.src = '//connect.facebook.net/en_US/all.js';

	     // Insert the Facebook JS SDK into the DOM
	     firstScriptElement.parentNode.insertBefore(facebookJS, firstScriptElement);
	   }());

	});
