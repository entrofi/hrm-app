(function () {
    'use strict';
    angular.module('app.user', [ 'app.core', 'ngTouch', 'ui.grid'])
        .factory('userService', ["$http", "$q", "logger", function ($http, $q, logger) {
            var host = "http://localhost:8080/rest";
            var resourcePath = "/users";
            var resourceURI = host + resourcePath;

            return {
                getItem: function (id) {
                    var deferred = $q.defer();
                    $http.get(resourceURI + "/item-" + id)
                        .success(function (data) {
                            deferred.resolve(data);
                            deferred.notify(data);
                        }).error(function (msg, code) {
                            deferred.reject(msg);
                            logger.error(msg, code);
                    });
                    return deferred.promise;
                },
                getList: function (queryParams) {
                    var deferred = $q.defer();
                    $http.get(resourceURI + "/list/")
                        .success(function (data) {
                            deferred.resolve(data);
                            deferred.notify(data);
                        }).error(function (msg, code) {
                            deferred.reject(msg);
                            logger.error(msg, code);
                    });
                    return deferred.promise;
                },
                save: function (entity) {
                    var deferred = $q.defer();
                    $http.post(resourceURI, entity)
                        .success(function(data) {
                            deferred.resolve(data);
                        }).error(function(msg, code) {
                            deferred.reject(msg);
                            logger.error(msg, code);
                        })
                    return deferred.promise;
                }

            }
        }]);
})();
