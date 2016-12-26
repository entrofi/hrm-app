(function() {
    'use strict';

    var appUserModule = angular.module('app.user');

    function UserEditController($scope, logger, userService, $stateParams) {
        var vm = this;
        vm.user = {};

        activate();



        function activate() {
            var userId = $stateParams.id

            return getUser(userId).then(function () {
                logger.info("Activated user edit view");
            })
        }

        function getUser(id) {
           var userPromise = new Promise(function then(){}, function(){} );
            if(id !== "") {
               userPromise = userService.getItem(id).then(
                    function (payload) {
                        vm.user = payload;
                        logger.info('Loaded user: ' + vm.user.name );
                        logger.debug('Loaded edit payload:' + payload)
                    },
                    function (errorPayload) {
                        logger.error("Unable to find user with id: " + id);
                    }
                )
            }

            return userPromise;
        }

        function saveUser() {
            return userService.save(vm.user)
                .then(function(payload) {
                    vm.user = payload;
                    logger.info("User saved successfully");
                }),
                function(errorPayload) {
                    logger.warn("Unable to save user");
                }
        }

        $scope.saveUser = function() {
            return userService.save(vm.user)
                .then(function (payload) {
                    vm.user = payload;
                    logger.info("User saved successfully");
                }),
                function (errorPayload) {
                    logger.warn("Unable to save user");
                }
        };
    }//End controller


    UserEditController.$inject = ['$scope', 'logger', 'userService', '$stateParams'];
    appUserModule.controller('UserEditController', UserEditController);

})();
