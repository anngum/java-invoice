package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    //private List<Product> products = new ArrayList<>();

    private final Map<Product, Integer> products = new HashMap<>();



    public void addProduct(Product product) {
        this.addProduct(product,1);
    }

    public void addProduct(Product product, Integer quantity) {

        if (quantity.intValue() <= 0) {
            throw new IllegalArgumentException("quantity cannot be less than or equal to zero");
        }
        this.products.put(product,quantity);
    }

    public BigDecimal getSubtotal() {
        BigDecimal value = BigDecimal.ZERO;

                for(Product product : this.products.keySet() ){
                    Integer quantity = this.products.get(product);
                    BigDecimal qualityAsBigDecimal = BigDecimal.valueOf(quantity);
                                value = value.add(product.getPrice().multiply(qualityAsBigDecimal));


        }

        return value;
    }

    public BigDecimal getTax() {
        BigDecimal value = BigDecimal.ZERO;
        for(Product product : this.products.keySet() ){
            Integer quantity = this.products.get(product);
            BigDecimal qualityAsBigDecimal = BigDecimal.valueOf(quantity);
            BigDecimal taxOfProduct = product.getPrice().multiply(qualityAsBigDecimal).multiply(product.getTaxPercent());

            value = value.add(taxOfProduct);

            }

        return value;
    }

    public BigDecimal getTotal() {
        BigDecimal value = BigDecimal.ZERO;
        for(Product product : this.products.keySet() ){
            Integer quantity = this.products.get(product);
            BigDecimal qualityAsBigDecimal = BigDecimal.valueOf(quantity);
            //value = value.add(product.getPriceWithTax());
            value = value.add(product.getPriceWithTax().multiply(qualityAsBigDecimal));

        }
        return value;
    }
}
