app.controller("nextNavFormCtrl",function($scope,$http,$timeout,$parse){
	/*$scope.refreshInterval = 4000;*/
	$scope.graphRefreshingInterval = 5000;
	function getURLParameter(name) {
		  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
		   var regexS = "[\\?&]"+name+"=([^&#]*)";
		   var regex = new RegExp( regexS );
		   var results = regex.exec( window.location.href );
		   if( results == null )
		      return "";
		   else
		      return results[1]; 
		}
	$('input').filter('.addPlotdatepicker').datepicker();
	$scope.yearList = [
	                  
	                   {value: '2014'},
	                   {value: '2015'},
	                   {value: '2016'}
	                ];
	$scope.monthList = [
	                   {value: '01'},
	                   {value: '02'},
	                   {value: '03'},
	                   {value: '04'},
	                   {value: '05'},
	                   {value: '06'},
	                   {value: '07'},
	                   {value: '08'},
	                   {value: '09'},
	                   {value: '10'},
	                   {value: '11'},
	                   {value: '12'}
	                ];
	
	$scope.dayList = [
		                   {value: '01'},
		                   {value: '02'},
		                   {value: '03'},
		                   {value: '04'},
		                   {value: '05'},
		                   {value: '06'},
		                   {value: '07'},
		                   {value: '08'},
		                   {value: '09'},
		                   {value: '10'},
		                   {value: '11'},
		                   {value: '12'},
		                   {value: '13'},
		                   {value: '14'},
		                   {value: '15'},
		                   {value: '16'},
		                   {value: '17'},
		                   {value: '18'},
		                   {value: '19'},
		                   {value: '20'},
		                   {value: '21'},
		                   {value: '22'},
		                   {value: '23'},
		                   {value: '24'},
		                   {value: '25'},
		                   {value: '26'},
		                   {value: '27'},
		                   {value: '28'},
		                   {value: '29'},
		                   {value: '30'},
		                   {value: '31'}
		                ];
	
	$scope.addPlotFlag=false;
	
	$('#addNewPlot_date').datepicker({
        format: "yyyy/mm/dd"
    }); 
	$scope.loadSelectorAction  = function(){
		$("#myModal").modal('show');
		 var page = "../generateService/getAllTemplate";
		  $http.get(page)
		    .success(function(response) {
		    	$scope.templateNames=response;
		    });
	};
	
	
	
	
    /*$scope.templateNames = [
                        {'lookupCode': 'AL', 'description': 'Alabama'},
                        {'lookupCode': 'FL', 'description': 'Florida'},
                        {'lookupCode': 'CA', 'description': 'California'},
                        {'lookupCode': 'DE', 'description': 'Delaware'}
     ];*/
    $scope.templateLoadAction = function(){
    	
    	var page = "../generateService/loadTemplate/"+$scope.currentTemplate;
		 $http.get(page)
		    .success(function(response) {
		    	//$scope.logInputDTO=response;
		    	$("#myModal").modal('toggle');
		    	//window.location.reload();
		    	
		    	var url = window.location.href;    
		    	if (url.indexOf('?') > -1){
		    	   url += '&actionType=systemreload';
		    	}else{
		    	   url += '?actionType=systemreload';
		    	}
		    	window.location.href = url;
		    });
    	//alert($scope.currentTemplate);
    };
    
	$scope.setPlotType = function(val,logInputDTO){
		for(var i=0;i<logInputDTOList.length;i++)
			{
			if($scope.logInputDTOList[i].beaconId == logInputDTO.beaconId){
				
				if(val=="aggrigate"){
					$scope.logInputDTOList[i].plotType=val;
					$scope.logInputDTOList[i].aggrigateStatus=true;
				}
				else if(val=="distinct"){
					$scope.logInputDTOList[i].plotType=val;
					$scope.logInputDTOList[i].distinctStatus=true;
				}
			}
			}
	};
	$scope.generateAction = function(beaconId,index){
		console.log(beaconId);
		console.log(index);
		var page = "../generateService/generateAction";
		/*console.log($scope.logInputDate);*/
		
		if($scope.logInputDTO[index].logFileDate ==null ||$scope.logInputDTO[index].logFileDate ==""){
			$scope.logInputDTO[index].logFileDate = document.getElementById(beaconId+"_date").value;
		}
		var requestData = $scope.logInputDTO[index];
		$http.post(page,requestData).success(
  			  function(data,status,headers){
  				  
  				  alert("Test Rule Saved Successfully");
  			  }
  	  	).error(
  	  		function(){
  	  		alert("Error happend on saving!!!!");
  	    });	
	};

	
	
	$scope.previewAction = function(logInputDTO,index){
		//console.log(beaconId);
		console.log(index);
		var page = "../generateService/previewAction";
		var divId = "#mainDiv_"+logInputDTO.beaconId+"_"+logInputDTO.logType;
		$(divId).mask("Please Wait...");
		//logInputDTO.logFileDate = logInputDTO.year+"/"+logInputDTO.month+"/"+logInputDTO.day;
		var requestData = logInputDTO;
		$http.post(page,logInputDTO).success(
  			  function(data,status,headers){
  				  $scope.resultData = data;
  				  $scope.previewClicked = "true";
  				  $scope.plotChart();
  				//$scope.loading = false;
  			  }
  	  	).error(
  	  		function(){
  	  		//$scope.loading = false;
  	  		//alert("Error happend on saving!!!!");
  	    });	
	};
	
	$scope.exportAsImage = function(logInputDTO,index){	
		var page = "../generateService/exportJPEG";
		var requestData = logInputDTO;
		$http.post(page,requestData).success(
  			  function(data,status,headers){
  				  alert("Successfully got the image!!!");
  			  }
  	  	).error(
  	  		function(){
  	  		alert("Error happend on saving!!!!");
  	    });	
	};
	
	
	$scope.addPlotAction = function(beaconId,index){
		console.log(beaconId);
		console.log(index);
		if($scope.newLongInDTO.year == undefined){
			$scope.newLongInDTO.year = '2014';
		}
		$scope.addPlotFlag=true;
		
	//	$('.remainingContents').html('<div class="row"><div class="littlePaddingLeft"></div><div class="col-md-4" ><div class="panel panel-primary"><div class="panel-heading">NextNav Log Input Form</div><div class="panel-body"><div class="form-group"><div class="row"><div class="col-md-3"><div class="label_font">Beacon ID:</div> </div><div class="col-md-5"><input type="text" ng-model="newLongInDTO.beaconId" class="small-text form-control" placeholder="Enter the Beacon ID" name="beaconID"/></div><div class="col-md-4"><button type="button" class="btn btn-success btn-xs" ng-click="loadSelectorAction()" id="remFieldValue"><span class="glyphicon glyphicon-plus"></span> LOAD</button></div>	</div></div><div class="form-group"><div class="row"><div class="col-md-3">	<div class="label_font">Log file Date: </div> 	</div> 	<div class="col-md-5"> 	 <div class="hero-unit">  <input name="logFileDate"  type="text" ng-model="newLongInDTO.logFileDate" class="small-text form-control" placeholder="click to show datepicker"  id="{{newLongInDTO.beaconId}}_date">  </div> 	</div> 	</div> 	</div> 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3"> 	<div class="label_font">Log Type: </div> 	</div> 	<div class="col-md-5"> 	<select class="small-text form-control" ng-model="newLongInDTO.logType">   <option>tx</option>   <option>pa</option>   <option>rb</option>   <option>rx</option> 	</select> 	</div> 	</div> 	</div> 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3"> 	<div class="label_font">Log extraction Regex: </div> 	</div> 	<div class="col-md-5"> <input type="text" name="logExtRegx"  class="small-text form-control" ng-model="newLongInDTO.logExtractionRegex" placeholder="Enter Log Extraction Regex"/>  	</div> 	 	</div> 	</div> 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3">  <div class="label_font">  Seperator:</div> 	</div> 	<div class="col-md-5"> <input type="text" name="seperator" class="small-text form-control" ng-model="newLongInDTO.seperator" placeholder=","/> 	</div> 	</div> 	</div> 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3"> 	<div class="label_font">Massage Output Expression:</div> 	</div> 	<div class="col-md-5"> <input type="text" name="outputExp" class="small-text form-control" ng-model="newLongInDTO.msgOpEx" placeholder="s/\*\S+$//"/> 	</div> 	<div class="col-md-4"> <div class="font_adjust">gets rid of checksum at the end</div> 	</div> 	</div> 	</div> 	 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3"> 	<div class="label_font">Field number to plot: </div> 	</div> 	<div class="col-md-5"> <input type="text" ng-model="newLongInDTO.fieldNoPlot" class="small-text form-control" placeholder="Enter Field Number"/> 	</div> 	</div> 	</div> 	 	 	 	<div class="form-group"> 	<div class="row"> 	<div class="col-md-3"> 	<div class="label_font">Plot type: </div> 	</div> 	<div class="col-md-5"> <div class="btn-group" data-toggle="buttons">   <label class="btn btn-primary btn-xs" ng-click="setPlotType("aggrigate")"> <input type="radio" ng-model="newLongInDTO.plotType"  value="aggrigate">Aggregate   </label>   <label class="btn btn-primary btn-xs" ng-click="setPlotType("distinct")" > <input type="radio" ng-model="newLongInDTO.plotType"  value="aggrigate">Distinct   </label>  </div> 	</div> 	</div> 	</div> 	 	<div class="form-group"> 	<div class="row">  	<div class="col-md-4"></div> 	<div class="col-md-4"> <button type="button" class="btn btn-success btn-xs" ng-click="savePlotToJson()" id="remFieldValue"> 	  <span class="glyphicon glyphicon-picture"></span> SAVE PLOT </button> 	</div> 	<div class="col-md-4"> </div> 	</div> 	</div> 	</div> 	</div> 	</div> 	</div>');
	};
	
	$scope.addPlotAction = function(){
		$scope.addPlotFlag=true;
	};
	
	$scope.getDataFromCSV = function(logInputDTO){
		var page = "../generateService/readFromCSV";
		var requestData = logInputDTO;
		 $http.post(page,requestData)
		    .success(function(data,status,headers) {
		    	var resultData = response;
		    	for(var eachData in resultData){
		    		console.log(resultData[eachData].date);
		    		resultData[eachData].date = new Date(resultData[eachData].date);
		    		
		    	}
		    	$scope.finalResultData = resultData;
		    	console.log(resultData);
		    }).error(
		  	  		function(){
		  	  	  		console.log("Error happend while reading");
		  	  	    });
	}
	
	
/********************Creation of Chart *******************/	
	$scope.plotChart = function(){
		
		//var chartData = generateChartData();
		//var logInputDTOResultList = $scope.logInputDTOList;
		for(var i=0;i<$scope.logInputDTOList.length;i++){
			//$scope.getDataFromCSV($scope.logInputDTOList[i]);
			/******CSV File Copy *****/
			var page = "../generateService/readFromCSV";
			$scope.logInputDTOList[i].pageToDisplay = 1;
			var requestData = $scope.logInputDTOList[i];
			var divIds = "#mainDiv_"+$scope.logInputDTOList[i].beaconId+"_"+$scope.logInputDTOList[i].logType;
			if(!($(divIds).isMasked())) {
				$(divIds).mask("Please Wait...");
			}
		//	$scope.loading = true;
				//var divIds = "#mainDiv_"+$scope.logInputDTOList[i].beaconId+"_"+$scope.logInputDTOList[i].logType;
    			//$(divIds).mask("Please Wait...");
			 $http.post(page,requestData)
			    .success(function(data,status,headers) {
			    	$scope.graphRefreshingInterval = 500000;
			    	var resultData = data;
			    	var beaconId = undefined;
			    	var logType = undefined;
			    	var secondPlotAvail = false;
			    	for(var eachData in resultData){
			    		console.log(resultData[eachData].date);
			    		resultData[eachData].date = new Date(resultData[eachData].date);
			    	}
			    	$scope.finalResultData = resultData;
			    	if(beaconId ==undefined){
		    			beaconId = resultData[1].beaconId;
		    		}
		    		if(logType ==undefined){
		    			logType = resultData[1].logType;
		    		}
		    		if(resultData[1].visit2 !=undefined){
		    			secondPlotAvail  = true;
		    		}
			    	console.log(resultData);
			    	var divId = "#mainDiv_"+beaconId+"_"+logType;
			    	var chartName = beaconId+"_"+logType+"_chart";
			    	$(divId).unmask();
			    	/***********CODE MIGRATED*****/
			    	var chartData = $scope.finalResultData;
			    //	var beaconId = beaconId;
			    	var chart = undefined;
			    	if(secondPlotAvail ==true){
			    		 chart = AmCharts.makeChart(beaconId+"_"+logType, {
						    "type": "serial",
							"theme": "none",
						    "pathToImages": "../img/",
						    "dataProvider": chartData,
						    "valueAxes": [{
						    	"id":"v1",
						    	"axisColor": "#FF6600",
						    	"axisThickness": 2,
						        "position": "left",
						        "gridAlpha": 0,
						        "axisAlpha": 1,
						        "title": "Count"
						    }
						    ,{
						        "id":"v2",
						        "axisColor": "#FCD202",
						        "axisThickness": 2,
						        "gridAlpha": 0,
						        "axisAlpha": 1,
						        "position": "right"
						    }
						    ],
						    "graphs": [{
						    	"valueAxis": "v1",
						    	"lineColor": "#FF6600",
						    	"bullet": "round",
						    	"bulletBorderThickness": 1,
						        "hideBulletsCount": 30,
						        "title": "Plot 1",
						        "valueField": "visits",
						        "fillAlphas": 0
						    },
						    {
						    	"valueAxis": "v2",
						    	"lineColor": "#FCD202",
						    	"bullet": "round",
						    	"bulletBorderThickness": 1,
						        "hideBulletsCount": 30,
						        "title": "Plot 2",
						        "valueField": "visit2",
						        "fillAlphas": 0
						    }],
						    "chartScrollbar": {},
						    "chartCursor": {
						        "categoryBalloonDateFormat": "JJ:NN:SS, DD MMMM",
						        "cursorPosition": "mouse"
						    },
						    "categoryField": "date",
						    "categoryAxis": {
						        "minPeriod": "ss",
						        "parseDates": true,
						        "title": "Time"
						    },
						    "amExport": {
				                "top": "21",
				                "right":"21"
				            }
						});

			    	}else{
			    		chart = AmCharts.makeChart(beaconId+"_"+logType, {
						    "type": "serial",
							"theme": "none",
						    "pathToImages": "../img/",
						    "dataProvider": chartData,
						    "valueAxes": [{
						    	"id":"v1",
						    	"axisColor": "#FF6600",
						    	"axisThickness": 2,
						        "position": "left",
						        "gridAlpha": 0,
						        "axisAlpha": 1,
						        "title": "Count"
						    }
						    ],
						    "graphs": [{
						    	"valueAxis": "v1",
						    	"lineColor": "#FF6600",
						    	"bullet": "round",
						    	"bulletBorderThickness": 1,
						        "hideBulletsCount": 30,
						        "title": "Plot 1",
						        "valueField": "visits",
						        "fillAlphas": 0
						    }],
						    "chartScrollbar": {},
						    "chartCursor": {
						        "categoryBalloonDateFormat": "JJ:NN:SS, DD MMMM",
						        "cursorPosition": "mouse"
						    },
						    "categoryField": "date",
						    "categoryAxis": {
						        "minPeriod": "ss",
						        "parseDates": true,
						        "title": "Time"
						    },
						    "amExport": {
				                "top": "21",
				                "right":"21"
				            }
						});
			    		
			    		
			    	}
					
					//chart.addListener("dataUpdated", zoomChart);
					// when we apply theme, the dataUpdated event is fired even before we add listener, so
					// we need to call zoomChart here
				//	zoomChart();
					// this method is called when chart is first inited as we listen for "dataUpdated" event
					/*function zoomChart() {
					    // different zoom methods can be used - zoomToIndexes, zoomToDates, zoomToCategoryValues
					    chart.zoomToIndexes(chartData.length - 250, chartData.length - 1);
					}*/
					
					// generate some random data, quite different range
					function generateChartData() {
					    var chartData = [];
					    // current date
					    var firstDate = new Date();
					    // now set 500 minutes back
					    firstDate.setMinutes(firstDate.getDate() - 1000);

					    // and generate 500 data items
					    for (var i = 0; i < 500; i++) {
					        var newDate = new Date(firstDate);
					        // each time we add one minute
					        newDate.setMinutes(newDate.getMinutes() + i);
					        // some random number
					        var visits = Math.round(Math.random() * 40 + 10 + i + Math.random() * i / 5);
					        // add data item to the array
					        chartData.push({
					            date: newDate,
					            visits: visits
					        });
					    }
					    return chartData;
					}
					// Get the model
					var model = $parse(chartName);

					// Assigns a value to it
					model.assign($scope, chart);
			    	/****************************/
					//$scope.loading = false;
			    }).error(
			  	  		function(){
			  	  		//$scope.loading = false;
			  	  	  		console.log("Error happend while reading");
			  	  	    });
			
			/******CSV File Copy *****/
			
			
		
		
	}
			
		
	};
	$scope.putDefaultValues = function(){
		
	};
	
	$scope.getLogInputDTOList = function(){
		var actionType = getURLParameter('actionType');
		if(actionType != "systemreload"){
			actionType = "userreload";
		}
		var page = "../generateService/getAllLogInputDTO/"+actionType;
		 $http.get(page)
		    .success(function(response) {
		    	$scope.logInputDTOList = response;
		    	
		    	$scope.putDefaultValues();
		    	$scope.plotChart();
		    });
	};
	
	//$scope.$watch("assignments", function (value) {//I change here
    //   alert("hi")
   // });
   $timeout(function () {

	if($scope.logInputDTOList !=null){
		for(var i=0;i<$scope.logInputDTOList.length;i++){
			   console.log("Get Into Log Input DTO");
			   	var divId = "#mainDiv_"+$scope.logInputDTOList[i].beaconId+"_"+$scope.logInputDTOList[i].logType;
				$(divId).mask("Please Wait...");
				$scope.plotChart();
			   }
	}
   
   }, 1000);
   
   $timeout(function () {
	   for(var i=0;i<$scope.logInputDTOList.length;i++){
	   console.log("Get Into Log Input DTO");
	   	var divId = "#mainDiv_"+$scope.logInputDTOList[i].beaconId+"_"+$scope.logInputDTOList[i].logType;
	   	if($(divId).isMasked()){
	   		$(divId).unmask("Please Wait...");
	   	}
		
	   }
	   }, 75000);
   
	$scope.getLogInputDTOList();
	$scope.setDistinctStatus = function(logInputDTO){
		for(var j=0;j<logInputDTOList.length;i++){
			if(logInputDTOList[j].beaconId == logInputDTO.beaconId){
				if(logInputDTOList[j].plotType == "distinct"){
					return "btn active btn-primary btn-xs";
				}else{
					return "btn btn-primary btn-xs";
				}
			}
		}
	};
	
	$scope.setAggrigateStatus = function(logInputDTO){
		for(var j=0;j<logInputDTOList.length;i++){
			if(logInputDTOList[j].beaconId == logInputDTO.beaconId){
				if(logInputDTOList[j].plotType == "aggrigate"){
					return "btn active btn-primary btn-xs";
				}else{
					return "btn btn-primary btn-xs";
				}
			}
		}
	};
	
	$scope.savePlotToJson = function(){	
		var page = "../generateService/savePlot";
		var requestData = $scope.newLongInDTO;
		$http.post(page,requestData).success(
  			  function(data,status,headers){
  				 // $scope.resultData = data;
  				//location.reload();
  				var url = window.location.href;
  				if(getURLParameter("actionType") ==null || getURLParameter("actionType") ==""){
  					if (url.indexOf('?') > -1){
  			    	   url += '&actionType=systemreload';
  			    	}else{
  			    	   url += '?actionType=systemreload';
  			    	}
  					window.location.href = url;
  				}else{
  					location.reload();
  				}
		    	
  				//$scope.addPlotFlag=false;
  				$scope.getLogInputDTOList();
  			  }
  	  	).error(
  	  		function(){
  	  		alert("Error happend on saving!!!!");
  	    });	
	};
	
	
	
/*	window.setInterval(function(){
		  console.log("Automatic Graph Updating");
		 // if($scope.previewClicked =="true"){
			  console.log("Inside the plots");
			  $scope.plotChart();
		 // }
		  
		}, $scope.graphRefreshingInterval==null?5000:$scope.graphRefreshingInterval);
	*/
	$scope.previousButtonAction = function(previewlogInputDTO){
		var page = "../generateService/readFromCSV";
		previewlogInputDTO.pageToDisplay = previewlogInputDTO.pageToDisplay-1;
		var requestData = previewlogInputDTO;
		var divId = "#mainDiv_"+previewlogInputDTO.beaconId+"_"+previewlogInputDTO.logType;
		$(divId).mask("Please Wait...");
		 $http.post(page,requestData)
		    .success(function(data,status,headers) {
		    	var divId = "#mainDiv_"+previewlogInputDTO.beaconId+"_"+previewlogInputDTO.logType;
		    	var chartName = previewlogInputDTO.beaconId+"_"+previewlogInputDTO.logType+"_chart";
		    	var chartData = $parse(chartName)($scope);
		    	chartData.dataProvider = data;
		    	chartData.validateData();
		    	$(divId).unmask();
		    });
		
	};
	
	$scope.nextButtonAction = function(nextlogInputDTO){
		var page = "../generateService/readFromCSV";
		nextlogInputDTO.pageToDisplay = nextlogInputDTO.pageToDisplay+1;
		var requestData = nextlogInputDTO;
		var divId = "#mainDiv_"+nextlogInputDTO.beaconId+"_"+nextlogInputDTO.logType;
		$(divId).mask("Please Wait...");
		$http.post(page,requestData)
	    	.success(function(data,status,headers) {
	    		var divId = "#mainDiv_"+nextlogInputDTO.beaconId+"_"+nextlogInputDTO.logType;
	    		var chartName = nextlogInputDTO.beaconId+"_"+nextlogInputDTO.logType+"_chart";
	    		var chartData = $parse(chartName)($scope);
	    		chartData.dataProvider = data;
	    		chartData.validateData();
	    		$(divId).unmask();
	    });
		$scope.populateIntervalLabel();
	}
	
	
});
