<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.services.ProductService" %>
<%@ page import="com.project.EcommerceWebsite.models.Cart" %>
<%@ page import="com.project.EcommerceWebsite.models.Product" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showCart.css">
</head>
<body>
    <header>
        <h1>Cart</h1>
        <div class="header-right">
        <form action="/explorePage" method="get">
            <button type="submit">Go Back</button>
        </form> &nbsp;&nbsp;
        <form action="/checkOut" method="post">
            <button type="submit">Checkout</button>
        </form>
        </div>
    </header>

    <p>${message}</p>
    <ul>
        <%
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
            ProductService service = context.getBean(ProductService.class);
            Integer userId = (Integer) session.getAttribute("userId");
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartitems");

            if (cartList != null && !cartList.isEmpty()) {
                for (Cart cart : cartList) {
                    List<Product> productList = service.read(cart.getProductid());
                    if (productList != null) {
                        for (Product product : productList) {
        %>
                    <li class="cart-item">
                        <strong>Name:</strong> <%= product.getName() %><br>
                        <strong>Price:</strong> Rs.<%= product.getPrice() %><br>
                        <strong>Description:</strong> <%= product.getDescription() %><br>
                        <form action="deleteCart" method="post">
                            <input type="hidden" name="id" value=<%= cart.getId() %> />
                            <input type="hidden" name="productid" value=<%= product.getId() %> />
                            <button type="submit">Remove from Cart</button>
                        </form>
                    </li>
        <%
                    }
                }
            }
        }
            else {
        %>
                <li class="cart-item">No products in cart.</li>
        <%
            }
        %>
    </ul>
</body>
</html>