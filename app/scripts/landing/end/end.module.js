if (!landing) {
    var landing = {};
}
if (!landing.end) {
    landing.end = {};
}

landing.end.EndController = require("./end.controller.js");

angular.module('landing.end', []);

module.exports = landing.end;