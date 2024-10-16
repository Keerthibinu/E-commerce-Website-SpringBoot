<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginRegister.css">
</head>
<body>
    <div class="container">
        <h2>LOGIN</h2>
        <h3>${message}</h3>
        <form action="checkUser" method="post">
            <table>
                <tr>
                    <td><label>Username</label></td>
                    <td><input type="text" name="username" required/></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input type="password" name="password" required/></td>
                </tr>
            </table>
                <input type="submit" name="Submit" value="Login"/>
        </form>
    </div>
</body>
</html>
