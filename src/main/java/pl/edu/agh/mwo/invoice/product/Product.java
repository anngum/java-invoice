package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null and cannot be empty");
        }

        this.name = name;

        if (price == null || price.compareTo(BigDecimal.valueOf(0)) == -1) {
            throw new IllegalArgumentException("Product price cannot be null and cannot be less than 0");
        }

        this.price = price;
        this.taxPercent = tax;

    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return this.price.add(this.price.multiply(this.taxPercent));
    }
}
