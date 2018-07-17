if (!landing) {
    var landing = {};
}
if (!landing.first) {
    landing.first = {};
}

landing.first.FirstController = function ($state, $stateParams, $http, $q, firstService, $mdDialog, $scope) {
    var vm = this;
    vm.update = update;
    vm.showConfirm = showConfirm;
    vm.updateSelection = updateSelection;


    vm.$onInit = function () {
        vm.offers = [];
        vm.errorMessage = "Du har tyvärr ingen giltig bonus att utnyttja.";
        vm.offers = $stateParams.offers;
        vm.offer = null;
    };

    function updateSelection(position, offers) {
        angular.forEach(offers, function(offer, index) {
            if (position != index)
                offer.checked = false;
        });
        if (vm.offer === vm.offers[position]){
            vm.offer = null;
        }else {
            vm.offer = vm.offers[position];
        }
    }

    function update() {
        firstService.redeemCheck($stateParams.cust, vm.offer, $stateParams.memberId).then(function (result) {
            $state.go('last', {cust: $stateParams.cust, memberId: $stateParams.memberId, offer: vm.offer});
        }, function (error) {
            $state.go('fail');
        });
        startTimer()
    }

    function expired() {
        $state.go('end', {cust: $stateParams.cust, memberId: $stateParams.memberId, offer: vm.offer});
    }

    function showConfirm (ev) {
        if (vm.offer === null ) {
            $mdDialog.show(
                $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Ingen bonus vald')
                    .textContent('Du måste välja vilken bonus du vill utnyttja.')
                    .ariaLabel('Inga val')
                    .ok('Tillbaka')
                    .targetEvent(ev)
            );
        } else {
            var confirm = $mdDialog.confirm()
                .title('Är du säker du vill aktivera din bonus?')
                .textContent('Du kommer endast kunna aktivera din bonus en gång och den är giltig i 15 minuter.')
                .ariaLabel('Bekräfta Bonus')
                .targetEvent(ev)
                .ok('Aktivera')
                .cancel('Avbryt');

            $mdDialog.show(confirm).then(function() {
                $scope.status = update()
            }, function() {
                $scope.status = 'Exit';
            });
        }
    };

    function startTimer() {
        // Set the date we're counting down to
        var countDownDate = new Date();
        countDownDate.setTime(countDownDate.getTime() + 15*60*1000);

        // Update the count down every 1 second
        var x = setInterval(function() {

            // Get todays date and time
            var now = new Date().getTime();

            // Find the distance between now an the count down date
            var distance = countDownDate - now;

            // Time calculations for days, hours, minutes and seconds
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            // Output the result in an element with id="demo"
            document.getElementById("timer").innerHTML = minutes + "m " + seconds + "s ";

            // If the count down is over, write some text
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("timer").innerHTML = "EXPIRED";
                expired();
            }
        }, 1000);

    }
};

module.exports = landing.first.FirstController;

