(function () {
    'use strict';

    angular
        .module('app.topnav')
        .directive('tmplTopnav', directiveFunction)
        .controller('TopnavController', ControllerFunction);


    // ----- directiveFunction -----
    directiveFunction.$inject = [];

    /* @ngInject */
    function directiveFunction() {

        var directive = {
            restrict: 'E',
            templateUrl: 'components/topnav/topnav.html',
            scope: {
            },
            controller: 'TopnavController',
            controllerAs: 'vm'
        };

        return directive;
    }

    // ----- ControllerFunction -----
    ControllerFunction.$inject = ['$state'];

    /* @ngInject */
    function ControllerFunction($state) {
        var vm = this;
        vm.isCollapsed = true;
        window._state = $state;

        vm.userMenuItems = [{uiSref: "users.list", text: "Users"},
            {uiSref: "users.edit", text: "Edit User"}];
    }

})();
