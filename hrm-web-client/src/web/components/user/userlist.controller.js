(function() {
    'use strict';

    var appUserModule = angular.module('app.user');

    function UserListController(userService,logger) {
        var vm = this;
        vm.userList = {};
        vm.gridOptions = {
            enableSorting: true,
        };
        activate();


        function activate() {
            return userService.getList().then(
                function (payload) {
                    logger.info("Activated user list view");
                    vm.userList = payload.content;
                },
                function(errorPayload) {
                    logger.error("Unable to get user list properly: ", errorPayload);
                }
            )
        }

    }

    UserListController.$inject = ['userService','logger'];

    appUserModule.controller('UserListController', UserListController);

})();
