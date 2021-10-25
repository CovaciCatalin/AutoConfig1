package App.GUI;

import App.Database.Database;
import App.Database.Order;
import App.Categoie1.Part2;
import App.Categoie1.Dealer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmGUI {
    private JPanel masterPanel;
    private JPanel mainPanel;
    private JTextPane optionsTextPane;
    private JButton confirmButton;
    private JButton cancelButton;
    private JPanel confirmPanel;
    private JLabel priceLabel;
    StringBuilder text = new StringBuilder();
    private String customer;
    private Dealer dealer;
    private double price;

    public ConfirmGUI(Dealer dealer, String customer, double price){
        this.customer = customer;
        this.dealer = dealer;
        this.price = price;
        setOptions(dealer);
        createCancelButtonListeners();
        createConfirmButtonListeners();
        priceLabel.setText("Pret total: EUR"+ dealer.getPrice());


    }
    private void setOptions(Dealer dealer){
        for(Part2 part2 : dealer.getIngredients()){
            if(part2.getName().startsWith("Servicii bonus")){
                populate(part2);
                text.append("----------------------\n");
            }
        }
        for(Part2 part2 : dealer.getIngredients()){
            if(!part2.getName().startsWith("Servicii bonus")){
                populate(part2);
                }
        }
        optionsTextPane.setText(text.toString());

    }
    private void populate(Part2 part2){
        text.append(part2.getName());

        text.append(" - "+ part2.getAmount()* part2.getPrice() + " EUR");
        text.append("\n");
    }
    private void createConfirmButtonListeners(){
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.addDatabase(new Order(customer, dealer, price));
                JButton button = (JButton)e.getSource();
                Window window = SwingUtilities.windowForComponent( button );
                window.dispose();
            }
        });

    }
    private void createCancelButtonListeners(){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                Window window = SwingUtilities.windowForComponent( button );
                window.dispose();
            }
        });
    }
    public JPanel getMasterPanel(){
        return masterPanel;
    }
}