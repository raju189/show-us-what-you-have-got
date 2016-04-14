/**
 * 
 */
// All Global required Variables
rootModule.factory('globalService', function() {
	return {
		isMember : true,
		isLogin : false,
		username : 'Guest',
		showSearch : false,
		showRequestFor : false,
		showRequestForAddNewBook : false,
		showAddNewBook : false,
		showAllRequests : false,
		showAddNewUser : false,
		showAll : true,
	}
});

rootModule.controller("CommonController", [ '$scope', 'globalService',
		function(scope, globalService) {
			scope.global = globalService;

			scope.backtohome = function() {
				globalService.showSearch = false;
				globalService.showRequestFor = false;
				globalService.showRequestForAddNewBook = false;
				globalService.showAddNewBook = false;
				globalService.showAllRequests = false;
				globalService.showAddNewUser = false;
				globalService.showAll = true;
			}
		} ]);
