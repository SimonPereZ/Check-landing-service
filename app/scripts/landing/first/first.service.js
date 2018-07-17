if (!landing) {
    var landing = {};
}

if (!landing.first) {
    landing.first = {};
}
landing.first.FirstServiceProvider = function () {

    this.$get = ['$http', '$q', function ($http, $q) {
        return new landing.first.FirstService($http, $q);
    }];
};

landing.first.FirstService = function ($http, $q) {
    var vm = this;
    vm.redeemCheck = redeemCheck;

    function redeemCheck(cust, offer, memberId) {
        var deferral = $q.defer();
        var url = "check/landing/" + cust + "/redeemoffer/" + memberId;
        $http.post(url, offer).then(function (response) {
            deferral.resolve(response.data);
        }, function (error) {
            deferral.reject(error);
        });
        return deferral.promise;
    }
};

module.exports = landing.first.FirstServiceProvider;
