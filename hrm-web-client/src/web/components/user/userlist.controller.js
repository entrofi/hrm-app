(function() {
    'use strict';

    var appUserList = angular.module('app.userList');

    function UserListController(logger) {
        var vm = this;
        vm.userList = {};

        activate();


        function activate() {
            return getList().then(function () {
                logger.info("Activated user list view");
            })
        }

        function getList() {
            var userPromise = new Promise(function(resolve, reject) {
                vm.userList = [{name: 'Hasan', surname: 'comak', username: 'hasancomak', email: 'hasan.comak@monitise.com'},
                    {name: 'Hasan1', surname: 'comak', username: 'hasancomak', email: 'hasan.comak@monitise.com'},
                    {name: 'Hasan2', surname: 'comak', username: 'hasancomak', email: 'hasan.comak@monitise.com'},
                    {name: 'Hasan3', surname: 'comak', username: 'hasancomak', email: 'hasan.comak@monitise.com'}
                    ];

                resolve(vm.userList);
            });
            return userPromise;
        }
    }

    UserListController.$inject = ['logger'];
    appUserList.controller('UserListController', UserListController);

})();
