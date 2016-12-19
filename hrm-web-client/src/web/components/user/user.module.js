(function() {
    'use strict';
    angular.module('app.user', [])
        .factory('userService', ["$http",function($http) {
            var host = "http://localhost:8080/rest";
            var resourceRoot = "/users";

            return {
                getItem : function(id) {
                    $http.get(host + resourceRoot + "/item-" + id)
                        .then(
                        function (response) {
                            return response.data;
                        },
                        function (httpError) {
                            //error translation
                            throw httpError.status + ": " + httpError.data;
                        });
                },
                getList: function(queryParams) {
                    $http.get(host + resourceRoot + "/list/" )
                        .then(
                        function (response) {
                            return {page: response.data.totalElements, content: response.data.content};
                        },
                        function (httpError) {
                            //error translation
                            throw httpError.status + ": " + httpError.data;
                        });
                }
            }
        }]);
})();
