(function(){
    'use strict';

    angular.module('routes', [
        "ui.router",
        "friendFinder.loginController"
    ])
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider,$urlRouterProvider) {
            $urlRouterProvider.when('', "/login");

            //set up all our routes
            $stateProvider
                .state("login",{
                url: '/login',
                templateUrl: "./resources/static/js/Angular-app/templates/login.html",
                controller: "LoginController",
                controllerAs: "loginCtrl"
            })
        }])
})();