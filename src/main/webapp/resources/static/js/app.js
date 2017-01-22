

var app = angular.module('friendFinder', [
    'ngRoute',
    'ngResource',
    'facebook',
    'routes'
])

app.config(function($httpProvider,FacebookProvider) {
    FacebookProvider.init({appId      : '135324250306699',
        xfbml      : true,
        version    : 'v2.8'});
});

