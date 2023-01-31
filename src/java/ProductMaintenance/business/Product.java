package ProductMaintenance.business;

import java.beans.*;
import java.io.Serializable;

public class Product implements Serializable {
    
    private String productCode;
    
    private String productDescription;

    private double price;
    
    public Product() {

    }

    public Product(String value1, String value2, Double value3) {
        productCode = value1;
        productDescription = value2;
        price = value3;
    }
    
    public String getProductCode() {
        return productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Double getPrice() {
        return price;
    }
    
    public void setProductCode(String value) {
        productCode = value;
    }
    
    public void setProductDescription(String value) {
        productDescription = value;
    }

    public void setPrice(Double value) {
        price = value;
    }
    
}
