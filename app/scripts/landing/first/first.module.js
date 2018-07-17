if (!landing) {
    var landing = {};
}
if (!landing.first) {
    landing.first = {};
}

landing.first.FirstServiceProvider = require("./first.service.js");
landing.first.FirstController = require("./first.controller.js");


angular.module('landing.first', [])
    .provider('firstService', landing.first.FirstServiceProvider);


module.exports = landing.first;