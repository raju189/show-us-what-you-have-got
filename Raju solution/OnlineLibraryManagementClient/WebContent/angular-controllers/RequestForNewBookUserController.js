/**
 * 
 */
 rootModule.controller("RequestForNewBookUserController", [ '$scope',
		'globalService', function(scope,globalService) {
			scope.global = globalService;
		} ]);