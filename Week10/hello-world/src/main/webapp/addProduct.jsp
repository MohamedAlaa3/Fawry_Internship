<!-- addProduct.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>

    <!-- Display error message if price input is invalid -->
    <c:if test="${param.error == 'invalid_price'}">
        <p style="color: red;">Invalid price. Please enter a valid number.</p>
    </c:if>

    <form method="POST" action="products/add">
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" required><br>

        <input type="submit" value="Add">
    </form>
    <a href="products/list">Back to Product List</a>
</body>
</html>
