var app = angular.module('addist',[]);
app.controller('addJobCtrl', function($scope, $http) {
	var vm = this;
	vm.user = "";
	function init() {
		   vm.identify = 3;
		   $scope.types = [
			           	    "销售",
			           	    "发送传单",
			           	    "家教"
			           	];   
		   $scope.user = getCookie("user");
	}
	init();
	vm.addjob = function() {
		var startTime = $($("#date4").get(0)).html();
		var endTime = $($("#date5").get(0)).html();
		var s_province = $("#s_province ").val();
		var s_city = $("#s_city").val();
		
		if (vm.identify == 0) {
			salary = vm.salary + '/小时';
		} else if (vm.identify == 1) {
			salary = vm.salary + '/日';
		} else if (vm.identify == 2) {
			salary = vm.salary + '/月';
		} else {
			salary = '面议';
		}
		
		if (s_province != '省份') {
			vm.part = s_province;
		} else {
			s_province = "";
		}
		
		if (s_city != '地级市') {
			vm.city = s_city;
		} else {
			s_city = "";
		}
		$.ajax({
			type:"post",
			url:"job/add.do",
			data:{
				"title": vm.title,
				"type": vm.type,
				"startTime": startTime,
				"endtime": endTime,
				"needcount": vm.needcount,
				"slarry": salary,
				"description": vm.description,
				"site": vm.site,
				"city": s_province,
				"part": s_city,
				"phone": vm.phone,
				"createBy": $scope.user	
			},
			error:function(){
				// 请求失败执行代码
				alert ('服务器开小差了！');
			},
			success: function(response) {
				if (response.status == 0) {
					window.location.href = "http://localhost:8088/parttimes/job-list.html";
				}
			}
		})
	/*	$http({
			method: 'post',
			url: 'job/add.do',
			data: {
				"title": vm.title,
				"type": vm.type,
				"startTime": startTime,
				"endtime": endTime,
				"needcount": vm.needcount,
				"slarry": salary,
				"description": vm.description,
				"site": vm.site,
				"city": s_province,
				"part": s_city,
				"phone": vm.phone,
				"createBy": vm.user
			}
		}).then(function successCallback(response) {
			if (response.data.status == 0) {
				window.location.href = "http://localhost:8088/parttimes/job-list.html";
			}
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		});  */
	}
});