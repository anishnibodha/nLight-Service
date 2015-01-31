'use strict';

/**
 * LoginController
 * @constructor
 */
var LoginController = function($scope, $http, $location,sharedservice,$facebook) {
	$scope.showsignup = false;
	$scope.showsignin = true;
	$scope.loginmainshow = true;
	$scope.mainpagething = false;
	
	$scope.loginWithFB = function(){
		$facebook.login().then(function() {
		      $scope.loginCheck();
		    });
	}
	
	$scope.loginCheck = function(){
		 $facebook.api("/me").then( 
			      function(response) {
			    	  alert("Login success");
			        window.location = "#/home";
			      },
			      function(err) {
			        alert("Please login Again");
			      });
	}
    
    $scope.registerDevice= function(){
    	
    	  $http.post(page,requestData).success(
    			  function(data,status,headers){
    				  alert(data);
    			  });
    }
    
    
    $scope.registerNow = function(){
    	var page = "/user/registeruser";
    	var requestData = $scope.form;
  	  $http.post(page,requestData).success(
  			  function(data,status,headers){
  				  alert(data);
  			  });
    	
    }
    
    $scope.loginNow = function(){
    	var page = "/user/login/"+$scope.siuser+"/"+$scope.sipassword;
  	  $http.get(page).success(function(response) {
    	if(response.result == "success"){
    		/*$scope.username = $scope.siuser;
    		$scope.getDevices();*/
    			//$scope.$apply( $location.path( '#/home' ) );
    		/*$scope.$on("handleBroadcast",function(){
    			
    		})*/
    		sharedservice.shareusername($scope.siuser);
    		window.location = "#/home";
    			
    		
    		  //$scope.changeRoute('#/home');
    	}
    	})
    }
    
    $scope.showSignupBox = function(){
    	$scope.showsignup = true;
    	$scope.showsignin = false;
    }
    
    $scope.showSignInBox = function(){
    	$scope.showsignup = false;
    	$scope.showsignin = true;
    }
    
    
    

};