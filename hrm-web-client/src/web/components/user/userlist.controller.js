(function() {
    'use strict';

    var appUserModule = angular.module('app.user');

    function UserListController(userService,logger) {
        var vm = this;
        vm.userList = [];
        vm.gridOptions = {
            enableSorting: true,
            data: vm.userList,
            columnDefs: [
                {field: "id"},
                {field: "name", displayName: "Name", cellTemplate: "<a ui-sref=\"users.edit({'id': '{{row.entity.id}}' })\" >{{row.entity.name}}</a> "},
                {field: "lastName", displayName: 'Surname'},
                {field: "email", displayName: 'Email'}

            ]
        };
        activate();


        function activate() {
            return userService.getList().then(
                function (payload) {
                    logger.info("Activated user list view");
                    vm.userList = payload.content;
                    vm.gridOptions.data = vm.userList;
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
