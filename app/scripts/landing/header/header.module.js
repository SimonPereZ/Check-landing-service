if (!landing) {
    var landing = {};
}
if (!landing.header) {
    landing.header = {};
}

landing.header.HeaderServiceProvider = require("./header.service.js");
landing.header.HeaderController = require("./header.controller.js");

angular.module('landing.header', []).controller('headerCtrl', landing.header.HeaderController).provider('headerService', landing.header.HeaderServiceProvider);

module.exports = landing.header;