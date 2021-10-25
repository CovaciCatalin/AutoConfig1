package App.Database;

import App.Categoie1.Dealer;

public class Order extends ImplementId {
    private int id;
    private String customer;
    private Dealer dealer;
    private double price;
    public Order(String customer, Dealer dealer, double price){
        id = super.newId();
        this.customer = customer;
        this.dealer = dealer;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getCustomer() {
        return customer;
    }

    public Dealer getSandwich() {
        return dealer;
    }

    public double getPrice() {
        return price;
    }
}
