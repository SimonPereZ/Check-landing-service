if (!landing) {
    var landing = {};
}

if (!landing.last) {
    landing.last = {};
}
landing.last.LastServiceProvider = function () {

    this.$get = ['$http', '$q', function ($http, $q) {
        return new landing.last.LastService($http, $q);
    }];
};

landing.last.LastService = function ($http, $q) {
    var vm = this;
};

module.exports = landing.last.LastServiceProvider;