<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.models.Cart" %>
<%@ page import="com.project.EcommerceWebsite.models.Payment" %>
<%@ page import="com.project.EcommerceWebsite.services.ProductService" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>

<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userProfile.css">
</head>
<body>
    <header>
            <h1>User Profile</h1>
            <div class="header-right">
            <form action="/explorePage" method="get">
                <button type="submit">Go Back</button>
            </form>
        </header>
    <h3>User Details</h3>
    <p><strong>Username:</strong> ${user.username}</p>
    <p><strong>Email:</strong> ${user.email}</p>
    <p><strong>Address:</strong> ${user.address}</p>

    <h3>Items in Cart</h3>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <%
                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
                ProductService service = context.getBean(ProductService.class);
                List<Cart> cartItems = (List<Cart>) request.getAttribute("cartItems");
                if (cartItems != null && !cartItems.isEmpty()) {
                    for (Cart item : cartItems) {
                        String productName = service.getname(item.getProductid());
            %>
            <tr>
                <td><%= productName%></td>
                <td><%= item.getPrice() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">Your cart is empty.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <h3>Previous Payments</h3>
    <table>
        <thead>
            <tr>
                <th>Payment ID</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Payment> paymentHistory = (List<Payment>) request.getAttribute("paymentHistory");
                if (paymentHistory != null && !paymentHistory.isEmpty()) {
                    for (Payment payment : paymentHistory) {
            %>
            <tr>
                <td><%= payment.getId() %></td>
                <td><%= payment.getTotal() %></td>
                <td><%= payment.getDatepaid() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">No previous payments found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>