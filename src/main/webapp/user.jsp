
<%@ page import="com.ace.ai.web.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<%@ include file="css.jsp"%>

</head>
<body>
	<%@ include file="menu.jsp"%>

	<!--Create Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add New
						User Modal</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="user/add" method="post">
					<div class="modal-body">

						<div class="form-floating mb-3">
							<input type="text" name="name" class="form-control"
								id="floatingInput" placeholder="name"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="email" name="email" class="form-control"
								id="floatingInput" placeholder="name@example.com"> <label
								for="floatingInput">Email address</label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" name="phone_number" class="form-control"
								id="floatingInput" placeholder="09xxxxx"> <label
								for="floatingInput">Phone Number</label>
						</div>
						<div class="form-floating">
							<input type="password" name="password" class="form-control"
								id="floatingPassword" placeholder="Password"> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="form-floating">
							<input type="password" name="confirm_password"
								class="form-control" id="floatingPassword"
								placeholder="Password"> <label for="floatingPassword">Confirm
								Password</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="container">
	
		<div class="text-center">
				<%@ include file="contextText.jsp"%>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">Add user</button>
		</div>
		
		<div class=" mx-5 px-5 mt-4 d-flex  justify-content-center ">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">User-Name</th>
						<th scope="col">Phone Number</th>
						<th scope="col">Email</th>
						<th scope="col">update</th>
						<th scope="col">delete</th>
						<th scope="col">Change Password</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<User> users = (List<User>) request.getAttribute("users");
					for (User user : users) {
					%>
					<tr>
						<td><%=user.getName()%></td>
						<td><%=user.getPhoneNumber()%></td>
						<td><%=user.getEmail()%></td>
						<td>
							<button type="button" class=" btn btn-info"
								data-name="<%=user.getName()%>"
								data-email="<%=user.getEmail()%>"
								data-phone="<%=user.getPhoneNumber()%>"
								onclick="openUpdateModal('<%=user.getId()%>','<%=user.getName()%>','<%=user.getPhoneNumber()%>','<%=user.getEmail()%>')">Update</button>
							<form method="post"></form>
						</td>

						<td>
							<button type="button" class=" btn btn-danger"
								onclick="openDeleteModal('<%=user.getId()%>')">Delete</button>
						</td>
						<td>
							<form action="changePassword">
								<input type="hidden" name="user_id" value="<%=user.getId()%>" />
								<button type="submit" class=" btn btn-warning">Change
									Password</button>
							</form>

						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Delete
						User</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Are you sure to delete this user : ?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<form action="user/delete" method="post">
						<input type="hidden" id="delete_user_id" name="user_id" />
						<button type="submit" class="btn btn-primary">Delete it</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateModal" tabindex="-1"
		aria-labelledby="updateModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Update
						User Modal</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="user/update" method="post">
					<div class="modal-body">
						<input type="hidden" name="user_id" id="update_user_id" />
						<div class="form-floating mb-3">
							<input type="text" name="name" class="form-control"
								id="update_name" placeholder="name" value=""> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="email" name="email" class="form-control"
								id="update_email" placeholder="name@example.com" value="">
							<label for="floatingInput">Email address</label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" name="phone_number" class="form-control"
								id="update_phone" placeholder="09xxxxx" value=""> <label
								for="floatingInput">Phone Number</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>



<script>
	function openDeleteModal(id) {
		$('#delete_user_id').val(id);
		$('#deleteModal').modal('show');
	}

	function openUpdateModal(id, name, phone, email) {
		$('#update_user_id').val(id);
		$('#update_name').val(name);
		$('#update_email').val(email);
		$('#update_phone').val(phone);
		$('#updateModal').modal('show');
	}
</script>
</html>