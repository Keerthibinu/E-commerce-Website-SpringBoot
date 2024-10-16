<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Update Product</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/createProduct.css">
</head>
<body>
    <h2>Add or Update Product Details</h2>
    <form action="createProduct" method="post">
        <table>
            <tr>
                <td><label>Name</label></td>
                <td><input type="text" name="name" required/></td>
            </tr>
            <tr>
                <td><label>CategoryId</label></td>
                <td><input type="number" name="category" required/></td>
            </tr>
            <tr>
                <td><label>Price</label></td>
                <td><input type="text" name="price" required/></td>
            </tr>
            <tr>
                <td><label>Quantity</label></td>
                <td><input type="number" name="quantity" required/></td>
            </tr>
            <tr>
                <td><label>Description</label></td>
                <td><input type="textarea" name="description" required/></td>
            </tr>
            <tr>
                <td><input type="submit" name="Submit" value="Create"/></td>
                <td><input type="submit" name="Submit" value="Update" formaction="updateProduct"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
