package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private static final int MAX_INVOICE_NUMBER = 100;
    private String number = (int) (MAX_INVOICE_NUMBER * Math.random()) + "/2022";
    private LinkedHashMap<Product, Integer> products = new LinkedHashMap<Product, Integer>();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }


    public String getNumber() {
        return number;
    }

    public String printInvoice() {
        String print = this.getNumber() + "\r\n";
        int n = 0;
        for (Product product : products.keySet()) {
            print += product.getName() + "\t";
            print += products.get(product) + "\t";
            print += product.getPrice() + "\r\n";

            n++;


        }
        print += "Liczba pozycji: " + n;
        return print;
    }
}
