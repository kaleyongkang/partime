var app = angular.module('registerqq',[]);
app.controller('registerqqCtrl', function($scope, $http) {
	vm = this;
	vm.identify = 0;
	vm.isShow = true;
	var data;
	vm.register = function() {
		console.log (vm.identify == 0);
    	if (vm.identify == 0) {
    		url = 'student/register.do';
    		data =  {
    				"username": vm.username,
    				"password": vm.password,
    				"email": vm.email,
    				"phone": vm.telphone,
    				"schoolName": vm.schoolName
    			};
    	} else {
    		url = 'user/register.do';
    		data =  {
    				"username": vm.username,
    				"password": vm.password,
    				"email": vm.email,
    				"phone": vm.telphone,
    				"companyName": vm.companyName
    			};
    	}
		$http({
			method: 'post',
			url: url,
			data: data
		}).then(function successCallback(response) {
			alert(response.data.msg);
			if (response.data.status == 0) {
				window.location.href = "http://localhost:8088/parttimes/login.html";
			}
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		});   
	}
	
	vm.changRole = function() {
		if (vm.identify == 0) {
			vm.isShow = true;
		} else {
			vm.isShow = false;
		}
	}
});