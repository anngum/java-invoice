package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;

    public void addProduct(Product product) {
        // TODO: implement
    }

    public void addProduct(Product product, Integer quantity) {
        // TODO: implement
    }

    public BigDecimal getSubtotal() {
        BigDecimal value;
        value = BigDecimal.valueOf(0);
        if (this.products != null) {
            for (Product product : this.products) {
                value.add(product.getPrice());

            }
        }

        return value;
    }

    public BigDecimal getTax() {
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
