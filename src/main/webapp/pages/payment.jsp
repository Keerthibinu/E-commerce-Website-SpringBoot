<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/payment.css">
</head>
<body>
    <header>
        <form action="/readCartByUserId" method="post" class="header-form">
            <button type="submit">Go to Cart</button>
        </form>
    </header>
    <div class="container">
        <h2>Payment</h2>
        <p class="username">Username: ${username}</p>
        <p class="total">Total Price: Rs.${total}</p>

        <form action="/paid" method="post" class="payment-form">
            <table>
                <tr>
                    <td><label for="username">Name</label></td>
                    <td><input type="text" id="username" name="username" required/></td>
                </tr>
                <tr>
                    <td><label for="methodpaid">Payment Method</label></td>
                    <td><input type="text" id="methodpaid" name="methodpaid" required/></td>
                </tr>
                <tr>
                    <td><label for="address">Address</label></td>
                    <td><textarea id="address" name="address" required></textarea></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit Payment"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
