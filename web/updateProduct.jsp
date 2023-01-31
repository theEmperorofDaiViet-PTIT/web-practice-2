<%@page import="ProductMaintenance.business.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Product</h1>
        <p><i>${message}</i></p>
            
        <form action="updateProduct" method="post">
            <table>
                <tr>
                    <td>Product Code:</td>
                    <% if(request.getParameter("action") == null){
                    %>
                        <td><input type="text" name="code" value="${editProduct.productCode}" required></input></td>
                    <% }else if(request.getParameter("action").equals("update")){ %> 
                        <td><input type="text" name="code" value="${userInput.productCode}" required></input></td>                        
                    <% }else{ %> 
                        <td><input type="text" name="code" required></input></td>
                    <% } %>
                </tr>
                <tr>
                    <td>Product Description:</td>
                    <% if(request.getParameter("action") == null){
                    %>
                        <td><input type="text" name="description" style="width:400px;"  value="${editProduct.productDescription}" required></input></td>
                    <% }else if(request.getParameter("action").equals("update")){ %> 
                        <td><input type="text" name="description" style="width:400px;"  value="${userInput.productDescription}" required></input></td>
                    <% }else{ %> 
                        <td><input type="text" name="description" style="width:400px;"  required></input></td>
                    <% } %> 
                </tr>
                <tr>
                    <td>Product Price:</td>
                    <% if(request.getParameter("action") == null){
                    %>
                        <td><input type="text" name="price" value="${editProduct.price}" required></input></td>
                    <% }else if (request.getParameter("action").equals("update")){ %> 
                        <td><input type="text" name="price" value="" required></input></td>
                    <% }else{ %> 
                        <td><input type="text" name="price" required></input></td>
                    <% } %> 
                </tr>
            </table>
            </br>
            <% if(request.getParameter("action") == null){
            %>
               <input type="hidden" name="action" value="update">
               <input type="hidden" name="productCode" value="<%=request.getParameter("productCode")%>">
            <% }else{ %>              
               <input type="hidden" name="action" value="update">
            <% } %> 
            <input type="submit" value="Update Product"></input>        
        </form>
        <form action="displayProducts" method="post">
            <input type="submit" value="View Products"></input>
        </form>
    </body>
</html>