(function () {
    'use strict';

    if (!landing) {
        var landing = {};
    }
    if (!landing.start) {
        landing.start = {};
    }

    landing.start.StartServiceProvider = require("./start.service.js");
    landing.start.StartController = require("./start.controller.js");

    angular.module('landing.start', [])
        .provider('startService', landing.start.StartServiceProvider);


    module.exports = landing.start;
})();
