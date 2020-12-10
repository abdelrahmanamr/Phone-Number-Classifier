var app = angular.module('app',[]);
 
app.controller('angularcontroller', function($scope, $http, $location) {
  $scope.submitForm = function(){
    var url = $location.absUrl() + "/api/v1/customer/"+$scope.country;
    
    $http.get(url).then(function (response) {
      $scope.response = response.data
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
  }
});

app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "/api/v1/customer";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});