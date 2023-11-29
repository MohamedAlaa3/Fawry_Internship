<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="org.example.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <ul>
        <% for (Product product : products) { %>
            <li>
                <%= product.getName() %> - $<%= product.getPrice() %>
                <form method="POST" action="products/delete/<%= product.getId() %>">
                    <input type="submit" value="Delete">
                </form>
            </li>
        <% } %>
    </ul>
    <a href="products/add">Add Product</a>
</body>
</html>
