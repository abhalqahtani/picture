
(function () {
    'use strict';

    angular
        .module('app')
        .controller('PictureController', PictureController);

    PictureController.$inject = ['$http'];

    function PictureController($http) {
        var vm = this;

        vm.bookings = [];
        vm.pictures = [];
        vm.unproc = [];
        vm.getAll = getAll;
        vm.unprocessed = unprocessed;
        vm.rejectPicture = rejectPicture;
        vm.acceptPicture = acceptPicture;

        init();

        function init(){
            getAll();
            unprocessed();
        }

        function getAll(){
            var url = "pic/showac";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.pictures = response.data;
            });
        }

        function unprocessed(){
            var url = "pic/showun";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.unproc = response.data;
            });
        }

        function rejectPicture(id){
            var url = "pic/reject/id/" + id;
            console.log(url)
            $http.post(url).then(function(response){
                vm.unproc = response.data;
            });
        }
        function acceptPicture(id){
            var url = "pic/accept/id/" + id;
            console.log(url)
            $http.post(url).then(function(response){
                vm.unproc = response.data;
            });
        }
    }
})();
