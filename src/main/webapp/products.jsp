<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ace.ai.web.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<%@ include file="css.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">

		<div class="text-center">
			<%@ include file="contextText.jsp"%>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#createModal">Add Product</button>
		</div>

		<div class=" mx-5 px-5 mt-4 d-flex  justify-content-center ">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Make</th>
						<th scope="col">Model</th>
						<th scope="col">update</th>
						<th scope="col">delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.make}" /></td>
							<td><c:out value="${product.model}" /></td>
							<td>
								<button type="button" class="btn btn-info"
									onclick="openUpdateModal('<c:out value="${product.id}" />',
                '<c:out value="${product.make}" />',
                '<c:out value="${product.model}" />',
                '<c:out value="${product.maker_id}" />'
                )
                ">Update</button>
							</td>
							<td>
								<button type="button" class="btn btn-danger"
									onclick="openDeleteModal('<c:out value="${product.id}" />')">Delete</button>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

		<!--Create Modal -->
		<div class="modal fade" id="createModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Add New
							Product Modal</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="products/add" method="post">
						<div class="modal-body">
							<div class="form-floating mb-3">
								<select name="maker_id" class="form-select">
									<option value="" disabled selected>Select One</option>
									<c:forEach var="make" items="${makes}">
										<option value="${make.id}">${make.name}</option>
									</c:forEach>
								</select> <label for="floatingInput">Make</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" name="model" class="form-control"
									id="floatingInput" placeholder="Enter Modal Name"> <label
									for="floatingInput">Enter Modal Name</label>
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

		<!-- delete modal  -->
		<div class="modal fade" id="deleteModal" tabindex="-1"
			aria-labelledby="deleteModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Delete
							Product</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">Are you sure to delete this product ?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<form action="products/delete" method="post">
							<input type="hidden" id="delete_product_id" name="product_id" />
							<button type="submit" class="btn btn-primary">Delete it</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- update modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Update
							Product Modal</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="products/update" method="post">
						<div class="modal-body">
							<input type="hidden" name="product_id" id="update_product_id" />
							<div class="form-floating mb-3">
								<select name="maker_id" id="maker_id" class="form-select">
									<c:forEach var="make" items="${makes}">
										<option value="${make.id}">${make.name}</option>
									</c:forEach>
								</select> <label for="floatingInput">Make</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" name="model" class="form-control"
									id="update_model" placeholder="Enter Modal Name"> <label
									for="update_model">Model</label>
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

	</div>

</body>

<script>
	function openDeleteModal(id) {
		$('#delete_product_id').val(id);
		$('#deleteModal').modal('show');
	}

	function openUpdateModal(id, make, model,maker_id) {
		$('#update_product_id').val(id);
		$('#maker_id').val(maker_id)
		$('#update_model').val(model);
		$('#updateModal').modal('show');
	}
</script>
</html>