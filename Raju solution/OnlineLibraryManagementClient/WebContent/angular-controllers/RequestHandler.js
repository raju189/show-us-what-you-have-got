/**
 * Navigating required Positions
 */

rootModule.controller("RequestHandlerController", [ '$scope', 'globalService',
		function(scope,globalService) {
			scope.global = globalService;
			scope.searchFromUser = function() {
				globalService.showAll = false;
				globalService.showSearch = true;
			}
			scope.requestForBook = function() {
				globalService.showAll = false;
				globalService.showRequestFor = true;
			}
			scope.requestForNewBookUser = function() {
				globalService.showAll = false;
				globalService.showRequestForAddNewBook = true;
			}
			scope.addNewBook = function() {
				globalService.showAll = false;
				globalService.showAddNewBook = true;
			}
			scope.showAllRequests = function() {
				globalService.showAll = false;
				globalService.showAllRequests = true;
			}
			scope.addNewUserOrMember = function() {
				
				globalService.showAll = false;
				globalService.showAddNewUser = true;
				alert(scope.global.showAddNewUser);
			}

		} ]);
