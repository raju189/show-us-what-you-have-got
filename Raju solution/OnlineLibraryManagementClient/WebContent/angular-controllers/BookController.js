/**
 * 
 */

// Service
rootModule
		.factory(
				'BookService',
				[
						'$resource',
						function(resource) {
							return resource(
									'http://localhost:8989/OnlineLibraryManagementService/books/:book',
									{
										book : '@book'
									}, {
										update : {
											method : 'PUT'
										}
									});
						} ]);

// Controller
rootModule.controller("SearchController", [ '$scope', 'globalService',
		'BookService',
		function(scope,globalService, bookService) {
			scope.global = globalService;

			scope.book = {};
			scope.books = [];

			scope.fetchAllbooks = function() {
				scope.books = bookService.query();
			}
			scope.fetchAllbooks();

			scope.edit = function(model) {
				scope.book = angular.copy(model);
			}
			scope.remove = function(id) {
				bookService.remove({
					book : id
				});
				scope.fetchAllbooks();

			}
			scope.request = function(id) {
			}
			scope.save = function(idx) {
				if (scope.book.id === null|| scope.book.id ==null) {
					bookService.save(scope.book);
				} else {
					bookService.update({
						book : scope.book.id
					}, scope.book);

				}
				scope.books[idx] = angular.copy(scope.book);
				scope.reset();
			}
			scope.reset = function() {
				scope.book = {id:""};
			}
			scope.getTemplate = function(model) {
				if (model.id === scope.book.id)
					return 'bookTableEdit';
				else
					return 'bookTableView';
			}

			scope.saveAndReset = function(model) {

			}
		} ]);