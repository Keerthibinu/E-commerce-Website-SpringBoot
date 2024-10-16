<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Update Category</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/createCategory.css">
</head>
<body>
    <h2>Add or Update Category Details</h2>
    <form action="createCategory" method="post">
        <table>
            <tr>
                <td><label>Name</label></td>
                <td><input type="text" name="name" required/></td>
            </tr>
            <tr>
                <td><input type="submit" name="Submit" value="Create"/></td>
                <td><input type="submit" name="Submit" value="Update" formaction="updateCategory"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
