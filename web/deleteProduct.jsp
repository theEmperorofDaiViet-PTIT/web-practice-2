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
        <h1>Are you sure want to delete this product?</h1>
        
        <% Product delProduct = (Product) request.getAttribute("delProduct"); %>
        
            <table>
                <tr>
                    <td>Product Code:</td>
                    <td>${delProduct.productCode}</td>

                </tr>
                <tr>
                    <td>Product Description:</td>
                    <td>${delProduct.productDescription}</td>
                </tr>
                <tr>
                    <td>Product Price:</td>
                    <td>${delProduct.price}</td>
                </tr>
            </table>
            </br>
        <form action="deleteProduct" method="post">
            <input type="submit" value="Yes"></input>
            <input type="hidden" name="action" value="Yes">
            <input type="hidden" name="productCode" value="<%=request.getParameter("productCode")%>">
        </form>
        <form action="deleteProduct" method="post">
            <input type="submit" value="No"></input>
            <input type="hidden" name="action" value="No">
        </form>
    </body>
</html>
