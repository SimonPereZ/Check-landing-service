if (!landing) {
    var landing = {};
}
if (!landing.start) {
    landing.start = {};
}

landing.start.StartController = function (startService, $stateParams, $state) {
    var vm = this;
    vm.callToRest = callToRest;
    vm.authorized = false;

    init();

    function init() {
        callToRest();
    }

    function callToRest() {

        startService.get($stateParams.cust, $stateParams.memberId).then(function (result) {
            $state.go('first', {cust: $stateParams.cust, memberId: $stateParams.memberId, offers: result});
        }, function (error) {
            $state.go('fail');
        });
    }
};

module.exports = landing.start.StartController;

