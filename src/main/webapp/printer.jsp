<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ace.ai.web.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Printer Management</title>
<%@ include file="css.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<div class="text-center">
			<%@ include file="contextText.jsp"%>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#createModal">Add Printer</button>
		</div>

		<div class=" mx-5 px-5 mt-4 d-flex  justify-content-center ">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Model</th>
						<th scope="col">Color</th>
						<th scope="col">Price</th>
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="printer" items="${printers}">
						<tr>
							<td>${printer.id }</td>
							<td>${printer.makeName }</td>
							<td>${printer.modelName}</td>
							<td>${printer.color }</td>
							<td>${printer.price }</td>
							<td>
								<button type="button"
									onclick="openUpdateModal(${printer.id },${printer.product_id },${printer.price},`${printer.color}`)"
									class="btn btn-info">Update</button>
							</td>
							<td>
								<button type="button" onclick="openDeleteModal(${printer.id })"
									class="btn btn-danger">Delete</button>
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
							Printer Modal</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="printers/add" method="post">
						<div class="modal-body">
							<div class="form-floating mb-3">

								<select name="product_id" class="form-select">
									<option value="" disabled selected>Select One</option>
									<c:forEach var="product" items="${products}">
										<option value="${product.id}">${product.model}-
											${product.make}</option>
									</c:forEach>
								</select> <label for="floatingInput">Product</label>
							</div>

							<div class="form-floating mb-3">
								<input type="text" name="color" class="form-control"
									id="floatingInput" placeholder="Enter color"> <label
									for="floatingInput">Enter Color</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" name="price" class="form-control"
									id="floatingInput" placeholder="Enter price"> <label
									for="floatingInput">Enter Price</label>
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
							printer</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">Are you sure to delete this printer ?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<form action="printers/delete" method="post">
							<input type="hidden" id="delete_printer_id" name="printer_id" />
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
							Printer Modal</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="printers/update" method="post">
						<div class="modal-body">
							<input type="hidden" name="printer_id" id="update_printer_id" />
							<div class="form-floating mb-3">
								<select name="product_id" id="update_printer_product_id"
									class="form-select">
									<option value="" disabled selected>Select One</option>
									<c:forEach var="product" items="${products}">
										<option value="${product.id}">${product.model}-
											${product.make}</option>
									</c:forEach>
								</select> <label for="floatingInput">Product</label>
							</div>

							<div class="form-floating mb-3">
								<input type="text" name="color" class="form-control"
									id="update_printer_color" placeholder="Enter color"> <label
									for="floatingInput">Enter Color</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" name="price" class="form-control"
									id="update_printer_price" placeholder="Enter price"> <label
									for="floatingInput">Enter Price</label>
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
		$('#delete_printer_id').val(id);
		$('#deleteModal').modal('show');
	}
	
	function openUpdateModal(id,product_id,price,color) {
		$('#update_printer_id').val(id);
		$('#update_printer_product_id').val(product_id);
		$('#update_printer_color').val(color);
		$('#update_printer_price').val(price);
		$('#updateModal').modal('show');
	}

</script>
</html>