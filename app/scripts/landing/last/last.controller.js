if (!landing) {
    var landing = {};
}
if (!landing.last) {
    landing.last = {};
}

landing.last.LastController = function ($stateParams, $state, lastService) {
    var vm = this;
    vm.goToEnd = goToEnd;
    vm.back = back;
    vm.offer = {};

    init();

    function init() {
        vm.offer = $stateParams.offer;
    }

    function back() {
        $state.go('first', {cust: $stateParams.cust, memberId: $stateParams.memberId, offer: vm.offer});
    }

    function goToEnd() {
        $state.go('end', {cust: $stateParams.cust, memberId: $stateParams.memberId, offer: vm.offer});
    }
};

module.exports = landing.last.LastController;
