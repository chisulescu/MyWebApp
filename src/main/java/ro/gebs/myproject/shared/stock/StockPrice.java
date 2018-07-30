package ro.gebs.myproject.shared.stock;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.IsSerializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class StockPrice implements IsSerializable {

    @Pattern(regexp = "^[0-9A-Z\\.]{1,10}$", message = "Caracter nevalid")
    private String symbol;

    @Size(min = 1, max = 100)
    private double price;

    @Size(max = 99)
    private double change;



    public StockPrice() {

    }



    public StockPrice(String symbol, double price, double change) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getPrice() {
        return this.price;
    }

    public double getChange() {
        return this.change;
    }

    public double getChangePercent() {
        return 10.0 * this.change / this.price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChange(double change) {
        this.change = change;
    }

}
