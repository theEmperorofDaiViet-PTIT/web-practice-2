package ProductMaintenance.DB;

import java.sql.*;

public class SQLUtility {

    public static String getHTMLTable(ResultSet products) throws SQLException{
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = products.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlTable.append("<table>");
 
        htmlTable.append("<tr>");
        for(int i = 1; i <= columnCount; i++){
            htmlTable.append("<th>");
            htmlTable.append(metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append("<th></th><th></th>");
        htmlTable.append("</tr>");

        while(products.next()){
            htmlTable.append("<tr>");
            String code = products.getString(1);
            String price = products.getString(3);
            for(int i = 1; i <= columnCount - 1; i++){
                htmlTable.append("<td>");
                htmlTable.append(products.getString(i));
                htmlTable.append("</td>");
            }
            htmlTable.append("<td>");
            htmlTable.append("$" + products.getDouble(columnCount));
            htmlTable.append("</td>");
            htmlTable.append("<td><a href = \"/ProductMaintenance/updateProduct?productCode=" + code +"\">Edit</a></td>");
            htmlTable.append("<td><a href = \"/ProductMaintenance/deleteProduct?productCode=" + code +"\">Delete</a></td>");
        htmlTable.append("</tr>");
        }
        
        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}
