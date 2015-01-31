'use strict';

/**
 * HomeController
 * @constructor
 */
var HomeController = function($scope, $http,$modal,sharedservice,ngTableParams) {
	$scope.items = ['item1', 'item2', 'item3'];
	
	$scope.checkLightEn = function(status){
		if(status == "none"){
			return false;
		}else {
			return true;
		}
	}
	
	$scope.checkLightDis = function(status){
		if(status == "none"){
			return true;
		}else {
			return false;
		}
	}
	
	$scope.disableLight = function(lightid){
		var page = "/monitor/enabledisable/"+lightid+"/disable";
  	  $http.get(page).success(function(response) {
  		$scope.lightParams.reload();
  		alert("Disable Light "+lightid);
    	});
		
	}
	
	$scope.enableLight = function(lightid){
		var page = "/monitor/enabledisable/"+lightid+"/enable";
	  	  $http.get(page).success(function(response) {
	  		$scope.lightParams.reload();
	  		alert("Enable Light "+lightid);
	    	});
	}
	
	  
	 $scope.addDeviceModal = function (size) {
		    var modalInstance = $modal.open({
		      templateUrl: 'addDevice.html',
		      controller: 'AddDeviceController',
		      size: size,
		      resolve: {
		        items: function () {
		          return $scope.items;
		        }
		      }
		    });

		    modalInstance.result.then(function (selectedItem) {
		      $scope.selected = selectedItem;
		    }, function () {
		      $log.info('Modal dismissed at: ' + new Date());
		    });
		  };
		  
		  
		 $scope.addLightModal = function (size) {
			    var modalInstance = $modal.open({
			      templateUrl: 'addLight.html',
			      controller: 'AddLightController',
			      size: size,
			      resolve: {
			        items: function () {
			          return $scope.items;
			        }
			      }
			    });

			    modalInstance.result.then(function (selectedItem) {
			      $scope.selected = selectedItem;
			    }, function () {
			      $log.info('Modal dismissed at: ' + new Date());
			    });
			  };
			  
			  $scope.addActivationModal = function (size) {
				    var modalInstance = $modal.open({
				      templateUrl: 'addActivation.html',
				      controller: 'AddActivationController',
				      size: size,
				      resolve: {
				        items: function () {
				          return $scope.items;
				        }
				      }
				    });

				    modalInstance.result.then(function (selectedItem) {
				      $scope.selected = selectedItem;
				    }, function () {
				      $log.info('Modal dismissed at: ' + new Date());
				    });
				  };
	
	$scope.registerDevice = function(){
    	var page = "/user/registerdevice/"+$scope.devicename+"/"+$scope.deviceip+"/"+$scope.deviceport+"/"+sharedservice.username;
    	  $http.get(page).success(function(response) {
    		  $scope.getDevices();
    		  alert("success")
      	})
    }

	$scope.getActKey = function(){
		var page = "/user/getactkey/"+sharedservice.username;
  	  $http.get(page).success(function(response) {
  		  $scope.actkey = response.apikey;
    	})
	}
	$scope.getActKey();
	
    $scope.getDevices = function(){
    	var page = "/user/getdevices/";
    	  $http.get(page).success(function(response) {
    		  var data = response;
    		  $scope.deviceParams = new ngTableParams({
    		        page: 1,            // show first page
    		        count: 10           // count per page
    		    }, {
    		        total: data.length, // length of data
    		        getData: function($defer, params) {
    		            $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
    		        }
    		    });
      	})
    }
    $scope.getDevices();
    
    $scope.getActivationKey = function(){
    	var page = "/monitor/allactkey/";
    	  $http.get(page).success(function(response) {
    		  var data = response;
    		  $scope.activationParams = new ngTableParams({
    		        page: 1,            // show first page
    		        count: 10           // count per page
    		    }, {
    		        total: data.length, // length of data
    		        getData: function($defer, params) {
    		            $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
    		        }
    		    });
      	})
    }
    $scope.getActivationKey();
    
    
    $scope.getLights = function(){
    	var page = "/monitor/allight/sd";
    	  $http.get(page).success(function(response) {
    		  var data = response;
    		  $scope.lightParams = new ngTableParams({
    		        page: 1,            // show first page
    		        count: 10           // count per page
    		    }, {
    		        total: data.length, // length of data
    		        getData: function($defer, params) {
    		            $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
    		        }
    		    });
      	})
    }
    $scope.getLights();
    
    
    $scope.getCrime = function(){
    	var page = "/crime/alllist";
    	  $http.get(page).success(function(response) {
    		  var data = response;
    		  $scope.lightParams = new ngTableParams({
    		        page: 1,            // show first page
    		        count: 10           // count per page
    		    }, {
    		        total: data.length, // length of data
    		        getData: function($defer, params) {
    		            $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
    		        }
    		    });
      	})
    }
    $scope.getCrime();
    
    
    
    
    
    $scope.registeruser = function(){
    	
    }
    $scope.registeruser();
    
    $scope.$on('handleBroadcast',function(){
		$scope.username = sharedservice.username;
	});

};

//Please note that $modalInstance represents a modal window (instance) dependency.
//It is not the same as the $modal service used above.

angular.module('nlight').controller('AddDeviceController', function ($scope,$http, $modalInstance, items) {

	$scope.items = items;
	$scope.selected = {
			item: $scope.items[0]
	};
	
	$scope.saveDevice = function () {

    	var page = "/monitor/createDevice";
    	var requestData = $scope.newdevice;
  	  $http.post(page,requestData).success(
  			  function(data,status,headers){
  				  alert("Success");
  			  });
    	
    
		$modalInstance.close($scope.selected.item);
	};
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});

angular.module('nlight').controller('AddLightController', function ($scope,$http, $modalInstance, items) {

	$scope.items = items;
	$scope.selected = {
			item: $scope.items[0]
	};
	
	$scope.saveLight = function () {
		
		var page = "/monitor/createLight";
    	var requestData = $scope.newlight;
  	  $http.post(page,requestData).success(
  			  function(data,status,headers){
  				  alert("Success");
  			  });
  	  
		$modalInstance.close($scope.selected.item);
	};
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});

angular.module('nlight').controller('AddActivationController', function ($scope,$http, $modalInstance, items) {

	$scope.items = items;
	$scope.selected = {
			item: $scope.items[0]
	};
	
	$scope.generateActivation = function () {
		
		var page = "/monitor/deviceid/1";
    	var requestData = $scope.newlight;
  	  $http.post(page,requestData).success(
  			  function(data,status,headers){
  				  alert("Success");
  			  });
  	  
		$modalInstance.close($scope.selected.item);
	};
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});