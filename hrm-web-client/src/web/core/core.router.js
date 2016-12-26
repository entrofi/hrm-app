(function () {
    'use strict';

    var core = angular.module('app.core');

    core.config(configFunction);

    configFunction.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];

    /* @ngInject */
    function configFunction($locationProvider, $stateProvider, $urlRouterProvider) {

        $locationProvider.html5Mode(true);

        $urlRouterProvider.otherwise('/');





        $stateProvider
            .state('dashboard', {
                url: '/',
                template: '<tmpl-dashboard></tmpl-dashboard>'
            })
            .state('idea', {
                url: '/idea',
                template: '<tmpl-ideaedit></tmpl-ideaedit>'
            })
            .state('users', {
                url: "/users",
                views: {
                    'rootView@': {
                        templateUrl: 'components/user/user.html',
                        controller: 'UserListController',
                        controllerAs: 'vm'
                    }
                }
            })
            .state('users.list', {
                url: '/list',
                views: {
                    'rootView@': {
                        templateUrl: 'components/user/userlist.html',
                        controller: 'UserListController',
                        controllerAs: 'vm'
                    }
                }
            })
            .state('users.edit', {
                url: '/{id}',
                views: {
                    'rootView@' : {
                        templateUrl: 'components/user/useredit.html',
                        controller: 'UserEditController',
                        controllerAs: 'vm'
                    }
                }
            });
    }
})();
