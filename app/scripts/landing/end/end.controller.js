if (!landing) {
    var landing = {};
}
if (!landing.end) {
    landing.end = {};
}

landing.end.EndController = function ($stateParams, $state) {
    var vm = this;
    vm.offer = {};

    init();

    function init() {
        vm.offer = $stateParams.offer;
    }

};

module.exports = landing.end.EndController;