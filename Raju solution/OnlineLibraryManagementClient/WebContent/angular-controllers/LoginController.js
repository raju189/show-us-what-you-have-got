/**
 * 
 */
rootModule.controller("LoginController", [ '$scope', 'globalService',
		function(scope, globalService) {
			scope.global = globalService;
			scope.logIn = function() {
				globalService.isLogin = true;
			}
			scope.logout = function() {
				globalService.isLogin = false;
			}
		} ]);
