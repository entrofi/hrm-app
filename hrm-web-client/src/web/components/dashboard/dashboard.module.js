(function() {
    'use strict';

    var appDashboard = angular.module('app.dashboard', [
        'app.core'
    ]);

    function CollapseDemoCtrl($scope) {
        $scope.isNavCollapsed = true;
        $scope.isCollapsed = false;
        $scope.isCollapsedHorizontal = false;
    }

    CollapseDemoCtrl.$inject = ["$scope"];

    appDashboard.controller('CollapseDemoCtrl', CollapseDemoCtrl);

})();
