<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ace.ai.web.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Computer Management</title>
<%@ include file="css.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">

		<div class="text-center">
			<%@ include file="contextText.jsp"%>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#createModal">Add Computer</button>
		</div>

		<div class=" mx-5 px-5 mt-4 d-flex  justify-content-center ">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Model</th>
						<th scope="col">Computer Type</th>
						<th scope="col">Speed</th>
						<th scope="col">Ram</th>
						<th scope="col">HDD</th>
						<th scope="col">Price</th>

						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="computer" items="${computers}">
						<tr>
							<td>${computer.id }</td>
							<td>${computer.makeName }</td>
							<td>${computer.modelName}</td>
							<td>${computer.computer_type}</td>
							<td>${computer.speed }</td>
							<td>${computer.ram }</td>
							<td>${computer.hd }</td>
							<td>${computer.price }</td>
							<td>
								<button type="button"
									onclick="openUpdateModal(${computer.id},${computer.product_id},${computer.type_computer_id},`${computer.speed}`,`${computer.ram}`,`${computer.hd}`,`${computer.price}`)"
									class="btn btn-info">Update</button>
							</td>
							<td>
								<button type="button" onclick="openDeleteModal(${computer.id })"
									class="btn btn-danger">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!--Create Modal -->
	<div class="modal fade" id="createModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add New
						Computer Modal</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="computers/add" method="post">
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
							<select name="type_computer_id" id="type_computer_id"
								class="form-select">
								<option value="" disabled selected>Select One</option>
								<c:forEach var="type_computer" items="${type_computers}">
									<option value="${type_computer.id}">${type_computer.name}</option>
								</c:forEach>
							</select> <label for="floatingInput">Computer Type</label>
						</div>

						<div class="form-floating mb-3">
							<input type="text" name="speed" class="form-control" id="speed"
								placeholder="Enter color"> <label for="floatingInput">Enter
								Speed</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="ram" class="form-control" id="ram"
								placeholder="Enter Ram"> <label for="floatingInput">Enter
								Ram</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="hdd" class="form-control" id="hdd"
								placeholder="Enter HDD"> <label for="floatingInput">Enter
								HDD</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="price" class="form-control" id="price"
								placeholder="Enter price"> <label for="floatingInput">Enter
								Price</label>
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
						Computer Modal</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Are you sure to delete this Computer ?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<form action="computers/delete" method="post">
						<input type="hidden" id="delete_computer_id" name="computer_id" />
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
				<form action="computers/update" method="post">
					<div class="modal-body">
						<input type="hidden" name="computer_id" id="update_computer_id" />
						<div class="form-floating mb-3">
							<select name="product_id" id="update_computer_product_id"
								class="form-select">
								<option value="" disabled selected>Select One</option>
								<c:forEach var="product" items="${products}">
									<option value="${product.id}">${product.model}-
										${product.make}</option>
								</c:forEach>
							</select> <label for="floatingInput">Product</label>
						</div>

						<div class="form-floating mb-3">
							<select name="type_computer_id" id="update_type_computer_id"
								class="form-select">
								<option value="" disabled selected>Select One</option>
								<c:forEach var="type_computer" items="${type_computers}">
									<option value="${type_computer.id}">${type_computer.name}</option>
								</c:forEach>
							</select> <label for="floatingInput">Computer Type</label>
						</div>

						<div class="form-floating mb-3">
							<input type="text" name="speed" class="form-control"
								id="update_speed" placeholder="Enter color"> <label
								for="floatingInput">Enter Speed</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="ram" class="form-control"
								id="update_ram" placeholder="Enter Ram"> <label
								for="floatingInput">Enter Ram</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="hdd" class="form-control"
								id="update_hdd" placeholder="Enter HDD"> <label
								for="floatingInput">Enter HDD</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" name="price" class="form-control"
								id="update_price" placeholder="Enter price"> <label
								for="floatingInput">Enter Price</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="button" id="updatBtn" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
<script>
	function openDeleteModal(id) {
		$('#delete_computer_id').val(id);
		$('#deleteModal').modal('show');
	}

	function openUpdateModal(id,product_id,type_id,speed,ram,hdd,price) {
		$('#update_computer_id').val(id);
		$('#update_computer_product_id').val(product_id);
		$('#update_type_computer_id').val(type_id);
		$('#update_speed').val(speed);
		$('#update_ram').val(ram);
		$('#update_hdd').val(hdd);
		$('#update_price').val(price);
		$('#updateModal').modal('show');
		
	}
	
	$("#updatBtn").click(function () {
	    var sendData = {
	        update_computer_id: $('#update_computer_id').val(),
	        update_computer_product_id: $('#update_computer_product_id').val(),
	        update_type_computer_id: $('#update_type_computer_id').val(),
	        update_speed: $('#update_speed').val(),
	        update_ram: $('#update_ram').val(),
	        update_hdd: $('#update_hdd').val(),
	        update_price: $('#update_price').val()
	    };
	    console.log(sendData);

	    // Assuming you want to make an AJAX request here
	    $.ajax({
	        url: "/SayarServlet/computers/update",
	        type: "POST",
	        data: sendData, // Pass the sendData object
	        success: function (data) {
	            console.log(data);
	            if(data?.status){
	            	$('#updateModal').modal('hide');
	            	location.reload(true);
	            }
	            
	        }
	    });
	});

	

</script>
</html>