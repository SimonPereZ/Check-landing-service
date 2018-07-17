if (!landing) {
    var landing = {};
}

if (!landing.start) {
    landing.start = {};
}
landing.start.StartServiceProvider = function () {

    this.$get = ['$http', '$q', function ($http, $q) {
        return new landing.start.StartService($http, $q);
    }];
};

landing.start.StartService = function ($http, $q) {
    var vm = this;
    vm.get = get;


    function get(cust, memberId) {

        var deferral = $q.defer();
        var url = "check/landing/" + cust + "/" + memberId;

        $http.get(url, cust, memberId)
            .then(function (response) {
                deferral.resolve(response.data);
            }, function (error) {
                deferral.reject(error);
            });
        return deferral.promise;
    }


};

module.exports = landing.start.StartServiceProvider;
