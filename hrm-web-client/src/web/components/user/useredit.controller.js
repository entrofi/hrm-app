(function() {
    'use strict';

    var appUserEdit = angular.module('app.useredit');

    function UserEditController(logger) {
        var vm = this;
        vm.user = {};

        activate();


        function activate() {
            return getUser().then(function () {
                logger.info("Activated user edit view");
            })
        }

        function getUser() {
            var userPromise = new Promise(function(resolve, rejedct) {
                vm.user = {name: 'Hasan', surname: 'comak', username: 'hasancomak', email: 'hasan.comak@monitise.com'};
               resolve(vm.user);
            });
            return userPromise;
        }
    }

    UserEditController.$inject = ['logger'];
    appUserEdit.controller('UserEditController', UserEditController);

})();