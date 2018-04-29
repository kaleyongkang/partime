var app = angular.module('joblist', ["ngTable","ui.bootstrap"]);
app.controller('jobListCtrl',["NgTableParams","$http","$scope", "$rootScope", "$modal",
  function(NgTableParams, $http, $scope, $rootScope, $modal) {
	var vm = this;
	vm.user = ''
	vm.data = [];
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
			vm.data = response.data.data;
			vm.tableParams = new NgTableParams({}, {
				counts: [],
				dataset : data
			});
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	
	vm.showDetail = function (id) {
		var data = {
				"id": id,
				"user": $scope.user 
		};
        var modalInstance = $modal.open({
            templateUrl : 'modal.html',//script标签中定义的id
            controller : 'modalCtrl',//modal对应的Controller
            resolve : {
                data : function() {//data作为modal的controller传入的参数
                     return data;//用于传递数据
                }
            }
        });
	}
	
	vm.joinIn = function (id) {
		$http({
			method: 'post',
			url: 'job/joinIn.do',
			data:{"jobId": id,
				  "userName": $scope.user
			}
		}).then(function successCallback(response) {
			if (response.data.status == 0) {
				alert("参加成功！");
			} else {
				alert("你已经参加过了！");
			}
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		}); 
	}
	
	init();
}
]);

app.controller('modalCtrl',
	["$scope","$modalInstance", "data", "$http",
	function($scope, $modalInstance, data, $http) {
	    $scope.data = data;
		$http({
			method: 'get',
			url: 'job/findOne.do?id=' + $scope.data.id,
		}).then(function successCallback(response) {
			$scope.job = response.data.data;
			$http({
				method: 'get',
				url: 'job/findOne.do?id=' + $scope.data.id,
			}).then(function successCallback(response) {
				$scope.job = response.data.data;
				console.log ($scope.job)
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
		
		$scope.attend = function() {
			$http({
				method: 'post',
				url: 'job/joinIn.do',
				data:{"jobId": $scope.data.id,
					  "userName": $scope.data.user
				}
			}).then(function successCallback(response) {
				$modalInstance.close();
				if (response.data.status == 0) {
					alert("参加成功！");
				} else {
					alert("你已经参加过了！");
				}
			}, function errorCallback(response) {
				// 请求失败执行代码
				alert ('服务器开小差了！');
			}); 
		}
		
	}
]);