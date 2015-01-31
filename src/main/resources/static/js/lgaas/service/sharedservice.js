nlight.factory("sharedservice", function($rootScope){
	
	var sharedservice = {};
	sharedservice.username = "";
	sharedservice.shareusername = function(msg){
		this.username = msg;
		this.broadcastItem();
	};
	
	sharedservice.broadcastItem = function(){
		$rootScope.$broadcast('handleBroadcast');
	};
	
	return sharedservice;
});

/*LoginController.$inject = ['$scope','sharedservice'];
LoginController.$inject = ['$scope','sharedservice'];*/