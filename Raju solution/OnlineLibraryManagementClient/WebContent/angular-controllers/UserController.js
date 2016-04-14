/**
 * 
 */

// User Service
rootModule
		.factory(
				'UserService',
				[
						'$resource',
						function(resource) {
							return resource(
									'http://localhost:8989/OnlineLibraryManagementService/users/:user',
									{
										user : '@user'
									}, {
										update : {
											method : 'PUT'
										}
									});
						} ]);

// User Controller
rootModule.controller("AddNewUserOrMemberController", [ '$scope',
		'globalService', 'UserService',
		function(scope, globalService, userService) {
			scope.global = globalService;
			scope.user = {};
			scope.users = [];
			scope.createUser = true;
			scope.editUser = false;
			scope.viewUser = false;

			scope.fetchAllUsers = function() {
				scope.users = userService.query();
			}
			scope.fetchAllUsers();

			scope.edit = function(model) {
				scope.user = angular.copy(model);
				scope.enbleEdit();
			}

			scope.view = function(model) {
				scope.user = {};
				scope.enbleView();
				scope.user = angular.copy(model);
			}
			scope.remove = function(id) {

				userService.remove({
					user : id
				});
				scope.fetchAllUsers();
				scope.enbleCreate();
			}

			scope.reset = function() {
				scope.user = {};
				scope.fetchAllUsers();
				scope.enbleCreate();
			}

			scope.addNewUser = function() {
				scope.user = {};
				scope.enbleCreate();
			}
			scope.save = function() {
				if (scope.user.id) {
					userService.update({
						user : scope.user.id
					}, scope.user);
					// scope.users[idx] = angular.copy(scope.user);
				} else {
					userService.save(scope.user);
				}

				scope.reset();
			}

			scope.enbleCreate = function() {
				scope.createUser = true;
				scope.editUser = false;
				scope.viewUser = false;
			}
			scope.enbleEdit = function() {
				scope.createUser = false;
				scope.editUser = true;
				scope.viewUser = false;

			}
			scope.enbleView = function() {
				scope.createUser = false;
				scope.editUser = false;
				scope.viewUser = true;
			}

		} ]);
