var app = angular.module('login', []);
app.controller('loginCtrl', function($scope, $http) {
    vm = $scope;
    vm.identify = 0;
    $scope.isSelected = false;
    var url;
    vm.login = function() {
    	console.log(vm.identify);
    	if (vm.identify == 0) {
    		url = 'student/login.do';
    	} else {
    		url = 'user/login.do';
    	}
    	console.log (url);
    	$http({
    	    method: 'post',
    	    url: url,
    	    data: {
    	    	"username": vm.username,
    	    	"password": vm.password,
    	    }
    	}).then(function successCallback(response) {
    		console.log(response.data.status);
		    if (response.data.status == 0) {
		    	addCookie("user",response.data.data.username,2);
		    	if (vm.identify == 0) {
		    		window.location.href = "http://localhost:8088/parttimes/job-list.html";
		    	} else {
		    		window.location.href = "http://localhost:8088/parttimes/job-list2.html";
		    	}
			} else {
				alert("用户名或者密码错误！");
			}
    	}, function errorCallback(response) {
	        // 请求失败执行代码
    		alert ('服务器开小差了！');
    	});
    }
    
    vm.chanageStatus = function() {
    		$scope.isSelected = false;
    }
    
    vm.ffchanageStatus = function() {
    		$scope.isSelected = true;
    }
    
    vm.register = function() {
    	window.location.href = "http://localhost:8088/parttimes/StudentRegister.html";
    }
});
