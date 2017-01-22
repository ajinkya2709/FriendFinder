(function(){
    'use strict';

    angular.module("friendFinder.loginController",[

    ])
        .controller('LoginController', controller);

    function controller($scope,Facebook) {
            var vm = this;
debugger;
            vm.facebook_authenticate = function(){
                debugger;
                Facebook.login(function (response) {
                    // Do something with response.
                    var auth = response.authResponse;

                    Facebook.api('/me', function (response) {
                        debugger;
                    });
                    console.log(response);
                }, {scope: 'email,user_likes'});
            }

    }

    controller.$inject = ["$scope","Facebook"]
})();



