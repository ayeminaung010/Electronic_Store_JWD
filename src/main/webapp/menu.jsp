	<%-- <div>
		<a href="home">Home</a>| <a href="user">User Management</a>|
		<!-- <a href="class">Class</a>|
		<a href="feedback">FeedBack</a>| -->
		<a href="logout">LogOut</a>
		<div style="text-align: right;">Login Date Time -
			${sessionScope.loginDateTime }</div>
	</div> --%>

	<%
	String currentPath = request.getServletPath();
	%>
	<nav class="navbar navbar-expand-lg bg-danger py-4">
		<div class="container">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto me-auto mb-2 mb-lg-0">
					<li class="nav-item "><a
						class="nav-link <%=currentPath.equals("/home") ? "active" : ""%>  text-uppercase text-white"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item ms-5"><a
						class="nav-link <%=currentPath.equals("/user") ? "active" : ""%> text-uppercase text-white"
						href="user">User Management</a></li>
					<li class="nav-item ms-5"><a
						class="nav-link <%=currentPath.equals("/products") ? "active" : ""%> text-uppercase text-white"
						href="products">Products Management</a></li>
					<li class="nav-item ms-5"><a
						class="nav-link <%=currentPath.equals("/printers") ? "active" : ""%> text-uppercase text-white"
						href="printers">Printer Management</a></li>
					<li class="nav-item ms-5"><a
						class="nav-link <%=currentPath.equals("/computers") ? "active" : ""%> text-uppercase text-white"
						href="computers">Computer Management</a></li>
				</ul>
				<a href="logout" class="btn btn-warning">LogOut</a>
			</div>
		</div>
	</nav>