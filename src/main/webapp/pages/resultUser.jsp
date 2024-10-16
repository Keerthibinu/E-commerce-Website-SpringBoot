<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.models.User" %>
<html>
<head>
    <title>User Table</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/result.css">
</head>
<body>
    <header>
           <h1>User Details</h1>
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
                <th>User ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Modify</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<User> userList = (List<User>) request.getAttribute("userList");
                if (userList != null) {
                    for (User user : userList) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getAddress() %></td>
                <td>
                    <form action="deleteUser" method="post">
                        <input type="hidden" name="id" value=<%= user.getId() %> />
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No users found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
