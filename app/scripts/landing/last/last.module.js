if (!landing) {
    var landing = {};
}
if (!landing.last) {
    landing.last = {};
}

landing.last.LastServiceProvider = require("./last.service.js");
landing.last.LastController = require("./last.controller.js");


angular.module('landing.last', [])
    .provider('lastService', landing.last.LastServiceProvider);


module.exports = landing.last;