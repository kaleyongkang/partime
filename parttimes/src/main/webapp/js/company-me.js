var app = angular.module('meList',[]);
app.controller('meCtrl', function($scope, $http) {
	var vm = this;
	vm.user = "";
	function init() {
		$scope.user = getCookie("user");
	   getUser();
	}
	getUser = function() {
		$http({
			method: 'get',
			url: 'user/getUser.do?useranme=' + $scope.user,
			data: {
			
			}
		}).then(function successCallback(response) {
			vm.isShow = false;
			data = response.data.data;
			console.log(data);
			vm.companyName = data.companyName;
			vm.companyIntroduce = data.companyIntroduce;
			vm.username = data.username;
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	init();
	vm.toEdit = function() {
		vm.isShow = true;
	}
	vm.editInfo = function() {
		console.log (vm.advantage);
		$http({
			method: 'post',
			url: 'user/editCompany.do',
			data: {
				"companyIntroduce": vm.companyIntroduce,
			}
		}).then(function successCallback(response) {
			vm.isShow = false;
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		});   
	}
});