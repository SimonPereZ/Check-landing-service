if (!landing) {
    var landing = {};
}

if (!landing.first) {
    landing.header = {};
}
landing.header.HeaderServiceProvider = function () {

    this.$get = ['$q', function ($q) {
        return new landing.header.HeaderService($q);
    }];
};

landing.header.HeaderService = function ($q) {
    var vm = this;
    vm.getLogo = getLogo;

    function getLogo(company) {
        return company;
    }


};

module.exports = landing.header.HeaderServiceProvider;