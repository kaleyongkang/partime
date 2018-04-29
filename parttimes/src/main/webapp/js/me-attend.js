var app = angular.module('meAttendList',["ngTable"]);
app.controller('meAttendListCtrl',["NgTableParams",'$scope','$http', 
   function(NgTableParams, $scope, $http) {
	var vm = this;
	vm.user = "";
	vm.data = [];
	function init() {
		$scope.user = getCookie("user");
	   getUser();
	}
	getUser = function() {
		$http({
			method: 'get',
			url: 'job/myFindJoinList.do?username=' + $scope.user,
			data: {
			
			}
		}).then(function successCallback(response) {
			data = response.data.data;
			vm.tableParams = new NgTableParams({}, {
				counts: [],
				dataset : data
			});
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	init();
}
]);