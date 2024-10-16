<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.EcommerceWebsite.models.Product" %>

<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/productDetails.css">
</head>
<body>
    <header>
        <form action="/explorePage" method="get">
            <button type="submit">Go Back</button>
        </form> &nbsp;&nbsp;
    </header>
    <div class="product-details">
        <% Product product = (Product) request.getAttribute("products"); %>
        <h2><%= product.getName() %></h2>
        <p>Price: Rs.<%= product.getPrice() %></p>
        <p>Category: <%= product.getCategoryid() %></p>
        <p>Description: <%= product.getDescription() %></p>
        <p>
            <% if (product.getQuantity() > 0) { %>
                Available: <%= product.getQuantity() %> units
            <% } else { %>
                <span class="sold-out">Sold Out</span>
            <% } %>
        </p>

        <% if (product.getQuantity() > 0) { %>
            <form action="/createCart" method="post">
                <input type="hidden" value="<%= product.getId() %>" name="productid">
                <button type="submit" class="add-to-cart-btn">Add to Cart</button>
            </form>
        <% } %>
    </div>
</body>
</html>
