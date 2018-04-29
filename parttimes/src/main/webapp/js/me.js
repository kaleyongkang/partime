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
			url: 'user/getUser.do?useranme=' + getCookie("user"),
			data: {
			
			}
		}).then(function successCallback(response) {
			vm.isShow = false;
			data = response.data.data;
			console.log(data);
			vm.username = data.username;
			vm.introduce = data.introduce;
			vm.skill = data.skill;
			vm.advantage = data.advantage;
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
			url: 'user/editInfo.do',
			data: {
				"advantage": vm.advantage,
				"introduce": vm.introduce,
				"skill": vm.skill
			}
		}).then(function successCallback(response) {
			vm.isShow = false;
		}, function errorCallback(response) {
			// 请求失败执行代码
			alert ('服务器开小差了！');
		});   
	}
	vm.uploadFile = function() {
        var form = new FormData();
        var file = document.getElementById("fileUpload").files[0];
        if (file == null) {
        	alert ("请选择文件！");
        	return;
        }
        form.append('file', file);
        $http({
            method: 'POST',
            url: 'user/upload.do',
            data: form,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).success(function (data) {
            alert("上传成功！");
        }).error(function (data) {
        	alert("上传成功！");
        })
	}
});