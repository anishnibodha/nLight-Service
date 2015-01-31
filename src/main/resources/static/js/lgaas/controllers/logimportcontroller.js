'use strict';

/**
 * LogImportController
 * @constructor
 */
var LogImportController = function($scope, $http) {
	$scope.showsignup = false;
	$scope.showsignin = true;
	$scope.loginmainshow = true;
	$scope.mainpagething = false;
    /*$scope.sampleCheck = function() {
    	var page = "../runcontroller/specificationlist/"+1;
	    $http.get(page)
	    .success(function(response) {
	    	alert(response);
	    })
    };
    
    $scope.sampleCheck();*/
    
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
    		
    		$scope.username = $scope.siuser;
    		$scope.actkey = response.addOne;
    		$scope.loginmainshow = false;
    		$scope.mainpagething = true;
    		$scope.getDevices();
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
    
    $scope.registerDevice = function(){
    	var page = "/user/registerdevice/"+$scope.devicename+"/"+$scope.deviceip+"/"+$scope.deviceport+"/"+$scope.username;
    	  $http.get(page).success(function(response) {
    		  $scope.getDevices();
    		  alert("success")
      /*	if(response == "success"){
      		
      		$scope.username = siuser;
      		$scope.actkey = response;
      		$scope.loginmainshow = false;
      		$scope.mainpagething = true;
      	}*/
      	})
    }
    
   /* $scope.loginNow = function(){
    	
      	  $http.post(page,requestData).success(
      			  function(data,status,headers){
      				  alert(data);
      			  });
    }*/
    
    $scope.getDevices = function(){
    	var page = "/user/getdevices/"+$scope.username;
    	  $http.get(page).success(function(response) {
    		  $scope.devices = response;
      /*	if(response == "success"){
      		
      		$scope.username = siuser;
      		$scope.actkey = response;
      		$scope.loginmainshow = false;
      		$scope.mainpagething = true;
      	}*/
      	})
    }
    
    $scope.getDevices();
    

};