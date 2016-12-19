(function() {
    'use strict';

    var appUserModule = angular.module('app.user');

    function UserListController(userService,logger) {
        var vm = this;
        vm.userList = {};

        activate();


        function activate() {
            vm.userList = getList();
        }

        function getList() {
            return userService.getList();
        }
    }

    UserListController.$inject = ['userService','logger'];

    appUserModule.controller('UserListController', UserListController);

})();
