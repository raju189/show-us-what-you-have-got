/**
 * 
 */

rootModule.controller("ShowAllRequestsController", [ '$scope',
		'globalService', function(scope,globalService) {
			scope.global = globalService;
		} ]);