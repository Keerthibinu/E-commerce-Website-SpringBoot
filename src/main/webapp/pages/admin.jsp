<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Control</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
    <h2>Admin Control</h2>
    <a href="/logout">Admin Logout</a>

    <h3>Users Management</h3>
    <a href="readAllUsers">Get User Details</a>

    <h3>Product Management</h3>
    <a href="createProduct">Add New Product</a>
    <a href="readAllProducts">Get Product Details</a>

    <h3>Category Management</h3>
    <a href="createCategory">Add New Category</a>
    <a href="readAllCategory">Get Category Details</a>
</body>
</html>
