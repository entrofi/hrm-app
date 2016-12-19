(function () {
    'use strict';
    angular.module('app.user', [ 'app.core', 'ngTouch', 'ui.grid'])
        .factory('userService', ["$http", "$q", "logger", function ($http, $q, logger) {
            var host = "http://localhost:8080/rest";
            var resourceRoot = "/users";
            var deferred = $q.defer();
            var errorHandler = function (msg, code) {
                deferred.reject(msg);
                logger.error(msg, code);
            };
            return {
                getItem: function (id) {
                    $http.get(host + resourceRoot + "/item-" + id)
                        .success(function (data) {
                            deferred.resolve(data);
                        }).error(function (msg, code) {
                            deferred.reject(msg);
                            logger.error(msg, code);
                    });
                    return deferred.promise;
                },
                getList: function (queryParams) {
                    $http.get(host + resourceRoot + "/list/")
                        .success(function (data) {
                            deferred.resolve(data);
                        }).error(function (msg, code) {
                            deferred.reject(msg);
                            logger.error(msg, code);
                    });
                    return deferred.promise;
                }

            }
        }]);
})();
