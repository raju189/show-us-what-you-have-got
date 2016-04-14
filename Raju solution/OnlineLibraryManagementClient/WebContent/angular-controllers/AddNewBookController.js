/**
 * 
 */

rootModule.controller("AddNewBookController", [ '$scope', 'globalService',
		'BookService', function(scope, globalService, bookService) {
			scope.global = globalService;
			scope.book = {};
			scope.save = function() {
				alert(scope.book);
				bookService.save(scope.book);
				scope.reset();
			}

			scope.reset = function() {
				scope.book = {};
			}
		} ]);