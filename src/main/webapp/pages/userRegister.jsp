<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginRegister.css">
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <h3>${message}</h3>
        <form action="createUser" method="post">
            <table>
                <tr>
                    <td><label>Id</label></td>
                    <td><input type="number" name="id" required/></td>
                </tr>
                <tr>
                    <td><label>Name</label></td>
                    <td><input type="text" name="username" required/></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><input type="text" name="email" required/></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input type="password" name="password" required/></td>
                </tr>
                <tr>
                    <td><label>Address</label></td>
                    <td><input type="textarea" name="address" required/></td>
                </tr>
            </table>
            <input type="submit" name="Submit" value="Register"/>
        </form>
    </div>
</body>
</html>
