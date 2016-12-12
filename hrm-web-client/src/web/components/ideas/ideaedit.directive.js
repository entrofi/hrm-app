(function () {

    'use strict';

    angular.module('app.ideaedit')
        .directive('tmplIdeaedit', directiveFunction)
        .controller('IdeaEditController', ControllerFunction);


    // ----- directiveFunction -----
    directiveFunction.$inject = [];

    /* @ngInject */
    function directiveFunction() {

        var directive = {
            restrict: 'E',
            templateUrl: 'components/ideas/idea-edit.html',
            scope: {
            },
            controller: 'IdeaEditController',
            controllerAs: 'vm'
        };

        return directive;
    }


    // ----- ControllerFunction -----
    ControllerFunction.$inject = ['logger'];

    /* @ngInject */
    function ControllerFunction(logger) {
        activate();

        function activate() {
            logger.log('Activated IdeaEdit View');
        }
    }

})();
