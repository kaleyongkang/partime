var app = angular.module('mylist', ["ngTable","ui.bootstrap"]);
app.controller('myListCtrl',["NgTableParams", "$http", "$scope", "$rootScope", "$modal",
  function(NgTableParams, $http, $scope , $rootScope, $modal) {
	var vm = this;
	vm.user = ""
	function init() {
	   $scope.types = [
		           	    "销售",
		           	    "发送传单",
		           	    "家教",
		           	    "其它"
		           	];   
	   $scope.orderBys = [
		           	    "工资",
		           	    "发布时间"
		           	]; 
		getjobList();	
		$scope.user = getCookie("user");
	}
	
	function getjobList() {
		$http({
			method: 'get',
			url: 'job/list.do',
		}).then(function successCallback(response) {
			var data = response.data.data;
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
	
	vm.deleteJob = function (id) {
		$http({
			method: 'post',
			url: 'job/delete.do',
			data: {
				"id": id
			}
		}).then(function successCallback(response) {
			init();
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	
	vm.edit = function (id) {
		$http({
			method: 'post',
			url: 'job/edit.do',
			data: {
				"id": id
			}
		}).then(function successCallback(response) {
			init();
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	
	vm.selectPelone = function (id) {
        var modalInstance = $modal.open({
            templateUrl : 'modal.html',//script标签中定义的id
            controller : 'modalCtrl',//modal对应的Controller
            resolve : {
                data : function() {//data作为modal的controller传入的参数
                     return id;//用于传递数据
                }
            }
        });
	}
	
	$scope.clear = function() {
		$scope.title = "";
		$scope.orderBy = "";
		$scope.type = "";
		$scope.part = "";
		$scope.city = "";
		init();
	}
	
	$scope.change = function () {
		vm.title = "";
		vm.orderBy = "";
		vm.type = "";
		var s_province = $("#s_province ").val();
		var s_city = $("#s_city").val();
		if ($scope.title) {
			vm.title = $scope.title;
		}
		if ($scope.orderBy) {
			vm.orderBy = $scope.orderBy;
		}
		if ($scope.type) {
			vm.type = $scope.type;
		}
		
		if (s_province != '省份') {
			vm.part = s_province;
		} else {
			vm.part = "";
		}
		
		if (s_city != '地级市') {
			vm.city = s_city;
		} else {
			vm.city = "";
		}
		
		filter = {
				"title": vm.title,
				"orderBy": vm.orderBy,
				"type": vm.type,
				"part": vm.part,
				"city": vm.city
			}
		console.log(filter);
		$http({
			method: 'post',
			url: 'job/filterFind.do',
			data: filter
		}).then(function successCallback(response) {
			var data = response.data.data;
			vm.tableParams = new NgTableParams({}, {
				counts: [],
				dataset : data
			});
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		});
		
	}
}
]);


app.controller('modalCtrl',
["$scope","$modalInstance", "data", "$http",
	function($scope, $modalInstance, data, $http) {
		$http({
			method: 'get',
			url: 'job/findJoinList.do?id=' + data
		}).then(function successCallback(response) {
			$scope.people = response.data.data;
			console.log($scope.people);
			$http({
				method: 'get',
				url: 'student/getUser.do?useranme=' + $scope.people[0].userName
			}).then(function successCallback(response) {
				$scope.student = response.data.data;
				console.log($scope.student);
			}, function errorCallback(response) {
				// 请求失败执行代码
				alert ('服务器开小差了！');
			});
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
		
		$scope.cancel = function() {
			$modalInstance.close();
		}  
		
		$scope.getUserfr = function(name) {
			$http({
				method: 'get',
				url: 'student/getUser.do?useranme=' + name
			}).then(function successCallback(response) {
				$scope.student = response.data.data;
				console.log($scope.student);
			}, function errorCallback(response) {
				// 请求失败执行代码
				alert ('服务器开小差了！');
			});
		} 
    }
]);