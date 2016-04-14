/**
 * 
 */

rootModule.controller("RequestForBookController", [ '$scope', 'globalService',
		'BookService','UserService', function(scope, globalService, bookService,userService) {
			scope.global = globalService;
			scope.bookRequest = {};
			scope.availBooks = [];
			scope.librarianList=[];

			scope.getAllAvailableBook = function() {
				scope.availBooks = bookService.query();
			}
			scope.getAllLibrarians = function(){
				scope.librarianList = userService.query();
			}
			scope.getAllAvailableBook();
			scope.getAllLibrarians();

		} ]);