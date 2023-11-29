package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/products/*")
public class ProductServlet2  extends HttpServlet {
    ProductRepository productRepository = new ProductRepository();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println("path: " + path);
        String[] pathParts = path.split("/");

        System.out.println(Arrays.asList(pathParts));

        String op = pathParts[1];

        if (op.equals("list")) {
            // Retrieve the list of products from the repository
            List<Product> products = productRepository.findProducts();

            // Store the products in the request attribute for the JSP
            request.setAttribute("products", products);

            // Forward the request to the productList.jsp page for rendering
            request.getRequestDispatcher("/p.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");

        if (pathParts.length == 3 && pathParts[1].equals("delete")) {
            // Get the product ID from the path
            String id = pathParts[2];

            // Perform the deletion (you need to implement this in ProductRepository)
            productRepository.deleteProductById(Integer.valueOf(id));

            // Redirect back to the product list after deletion
            response.sendRedirect(request.getContextPath() + "/products/list");
        }
        if (pathParts.length == 3 && pathParts[1].equals("add")) {
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");



            // Perform the deletion (you need to implement this in ProductRepository)
            productRepository.addProduct(new Product(productRepository.products.size(), name, Integer.valueOf(priceStr)));

            // Redirect back to the product list after deletion
            response.sendRedirect(request.getContextPath() + "/products/list");
        }
    }
}
