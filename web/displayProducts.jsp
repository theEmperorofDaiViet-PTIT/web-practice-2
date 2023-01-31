<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
        <style>
            /*table {border-collapse: collapse; }*/
            table, tr, th, td {border: 1px solid black; }
        </style>
    </head>
    <body>
        <h1>Products</h1>
        ${displayProducts}
        </br>
        <form action="updateProduct" method="post">
            <input type="hidden" name="action" value="updateRequest">
            <input type="submit" value="Add Product"></input>
        </form>
    </body>
</html>
