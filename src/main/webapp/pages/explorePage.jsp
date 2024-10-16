<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.EcommerceWebsite.models.Product" %>

<html>
<head>
    <title>Explore Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/explorePage.css">
</head><body>
           <header>
           <h1>Explore Products</h1>
           <div class="header-right">
               <form action="/readCartByUserId" method="post" class="header-form">
                   <button type="submit">Go to Cart</button>
               </form>
               <form action="/userProfile" method="get" class="header-form">
                    <button type="submit">Profile</button>
               </form>
               <form action="/userLogout" method="get" class="header-form">
                   <button type="submit">Logout</button>
               </form>
           </header>
           </div>

           <div class="forms-container">
               <!-- Search Form -->
               <div class="form-row">
                   <form action="/search" method="post" class="search-sort-form">
                       <label>Search By</label>
                       <select id="keyword" name="keyword">
                           <option value="category">Category</option>
                           <option value="name">Name</option>
                           <option value="availability">Availability</option>
                       </select>
                       <input type="text" placeholder="Enter to Search" name="value"/>
                       <button type="submit">Search</button>
                   </form>
                   <!-- Sort Form -->
                   <form action="/sort" method="post" class="search-sort-form">
                       <label>Sort By</label>
                       <select id="keyword" name="keyword">
                           <option value="priceascending">Price (Low to High)</option>
                           <option value="pricedescending">Price (High to Low)</option>
                       </select>
                       <button type="submit">Sort</button>
                   </form>
               </div>
           </div>

           <!-- Product List -->
           <div class="product-list">
               <ul>
                   <%
                       List<Product> productList = (List<Product>) request.getAttribute("products");
                       if (productList != null && !productList.isEmpty()) {
                           for (Product product : productList) {
                   %>
                           <li class="product-card" onclick="window.location.href='/productDetails?id=<%=product.getId()%>';">
                               <div class="product-content">
                                   <h3><%= product.getName() %></h3>
                                   <p>Rs.<%= product.getPrice() %></p>
                                   <p>
                                       <% if (product.getQuantity() > 0) { %>
                                           <%= product.getQuantity() %> units available
                                       <% } else { %>
                                           <span class="sold-out">Sold Out</span>
                                       <% } %>
                                   </p>
                               </div>
                           </li>
                   <%
                           }
                       } else {
                   %>
                           <li>No products available.</li>
                   <%
                       }
                   %>
               </ul>
           </div>
       </body>
</html>