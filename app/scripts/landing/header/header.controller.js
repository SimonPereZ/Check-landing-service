if (!landing) {
    var landing = {};
}
if (!landing.last) {
    landing.header = {};
}

landing.header.HeaderController = function (headerService, $location) {
    var vm = this;
    vm.company = null;

    init();

    function init() {
        var path = $location.path().slice(1, $location.path().lastIndexOf("/"));
        // path = path.slice(0, path.lastIndexOf("/"));

        if (path.indexOf("/") !== -1) {
            path = path.slice(path.lastIndexOf("/") + 1);
        }

        if (angular.equals(path, "test")) {
            vm.company = "test";
        }
        if (angular.equals(path, "testlloyds")) {
            vm.company = "lloyds";
        } else {
            vm.company = path;
        }
    }
};

module.exports = landing.header.HeaderController;