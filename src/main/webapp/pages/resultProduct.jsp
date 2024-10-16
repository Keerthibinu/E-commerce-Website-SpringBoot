<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.models.Product" %>
<html>
<head>
    <title>Product Table</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/result.css">
    <script type="text/javascript">
        function enableEdit(rowId) {
            var editFields = document.querySelectorAll("#row" + rowId + " .editable");
            var updateButton = document.getElementById("updateButton" + rowId);

            editFields.forEach(function(field) {
                field.removeAttribute("readonly");
            });

            updateButton.innerText = "Save";
            updateButton.setAttribute("onclick", "submitForm(" + rowId + ")");
        }

        function submitForm(rowId) {
            var form = document.getElementById("updateForm" + rowId);
            form.submit();
        }
    </script>
</head>
<body>
    <header>
        <h1>Product Details</h1>
        <div class="header-right">
            <form action="/admin" method="get" class="header-form">
                <button type="submit">Go Back</button>
            </form>
            <form action="/logout" method="get" class="header-form">
                <button type="submit">Admin Logout</button>
            </form>
        </div>
    </header>

    <table>
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Category ID</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Description</th>
                <th>Modify</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                if (productList != null) {
                    for (Product product : productList) {
                        int rowId = product.getId(); // Use product ID as row identifier
            %>
            <tr id="row<%= rowId %>">
                <td><%= product.getId() %></td>
                <div class="button-container">
                <form id="updateForm<%= rowId %>" action="updateProduct" method="post">
                    <input type="hidden" name="id" value="<%= product.getId() %>" />
                    <td><input type="text" class="editable" name="name" value="<%= product.getName() %>" readonly /></td>
                    <td><input type="text" class="editable" name="categoryid" value="<%= product.getCategoryid() %>" readonly /></td>
                    <td><input type="number" class="editable" name="price" value="<%= product.getPrice() %>" readonly /></td>
                    <td><input type="number" class="editable" name="quantity" value="<%= product.getQuantity() %>" readonly /></td>
                    <td><input type="text" class="editable" name="description" value="<%= product.getDescription() %>" readonly /></td>
                    <td>
                        <button type="button" id="updateButton<%= rowId %>" class="button-update" onclick="enableEdit(<%= rowId %>)">Update</button>
                </form>
                    <form action="deleteProduct" method="post">
                        <input type="hidden" name="id" value="<%= product.getId() %>" />
                        <button type="submit" class="button-delete">Delete</button>
                    </form>
                    </div>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="7">No products found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
