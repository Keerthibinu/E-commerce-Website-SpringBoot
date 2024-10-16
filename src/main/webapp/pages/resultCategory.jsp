<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.models.Category" %>
<html>
<head>
    <title>Category Table</title>
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
        <h1>Category Details</h1>
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
                <th>Category ID</th>
                <th>Name</th>
                <th>Modify</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
                if (categoryList != null) {
                    for (Category category : categoryList) {
                        int rowId = category.getId(); // Use category ID as row identifier
            %>
            <tr id="row<%= rowId %>">
                <td><%= category.getId() %></td
                <td>
                    <div class="button-container">
                        <form id="updateForm<%= rowId %>" action="updateCategory" method="post">
                            <input type="hidden" name="id" value="<%= category.getId() %>" />
                            <td><input type="text" class="editable" name="name" value="<%= category.getName() %>" readonly /></td>
                            <td>
                                <button type="button" id="updateButton<%= rowId %>" class="button-update" onclick="enableEdit(<%= rowId %>)">Update</button>
                        </form>
                        <form action="deleteCategory" method="post" style="display: inline;">
                            <input type="hidden" name="id" value=<%= category.getId() %> />
                            <button type="submit" class="btn-delete">Delete</button>
                        </form>
                    </div>
                </td>

            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No categories found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
