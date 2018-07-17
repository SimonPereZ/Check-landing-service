'use strict';

require("angular");
require("angular-animate");
require("angular-aria");
require("@uirouter/angularjs");
require("angular-material");
require("angular-messages");

var landing = {};

landing.header = require("./landing/header/header.module");
landing.start = require("./landing/start/start.module.js");
landing.first = require("./landing/first/first.module.js");
landing.last = require("./landing/last/last.module.js");
landing.end = require("./landing/end/end.module.js");

angular.module("landing", ['ui.router', 'ngMaterial', 'landing.header', 'landing.start', 'landing.first', 'landing.last', 'landing.end'])
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider','$mdThemingProvider', function ($stateProvider, $urlRouterProvider, $locationProvider, $mdThemingProvider) {
        // $urlRouterProvider.otherwise("/");
        $stateProvider
            .state('start', {
                url: '/:cust/:memberId',
                templateUrl: 'check/js/landing/start/start.html',
                controller: landing.start.StartController,
                controllerAs: 'vm'
            })
            .state('first', {
                url: '/bonus/:cust/:memberId',
                templateUrl: 'check/js/landing/first/first.html',
                params: {
                    offers: []
                },
                controller: landing.first.FirstController,
                controllerAs: 'vm'
            })
            .state('last', {
                url: '/success/:cust/:memberId',
                templateUrl: 'check/js/landing/last/last.html',
                params: {
                    offer: {}
                },
                controller: landing.last.LastController,
                controllerAs: 'vm'
            })
            .state('end', {
                url: '/end/:cust/:memberId',
                templateUrl: 'check/js/landing/end/end.html',
                params: {
                    offer: {}
                },
                controller: landing.end.EndController,
                controllerAs: 'vm'
            })
            .state('fail', {
                url: '/unsuccessful',
                templateUrl: 'check/js/landing/unsuccessful/unsuccessful.html'
            });
        $mdThemingProvider.definePalette('relevateGreen', {
            '50': '408682',
            '100': '408682',
            '200': '408682',
            '300': '408682',
            '400': '408682',
            '500': '408682',
            '600': '408682',
            '700': '408682',
            '800': '408682',
            '900': '408682',
            'A100': '408682',
            'A200': '408682',
            'A400': '408682',
            'A700': '408682',
            'contrastDefaultColor': 'light',  // whether, by default, text (contrast)
            // on this palette should be dark or light

            'contrastDarkColors': undefined, //hues which contrast should be 'dark' by default

            'contrastLightColors': undefined    // could also specify this if default was 'dark'
        });
        // $locationProvider.html5Mode(true);
        $mdThemingProvider.theme('default')
            .primaryPalette('relevateGreen');
        // .warnPalette('black')
        // .backgroundPalette('white');
        $locationProvider.hashPrefix('app');

    }]);



