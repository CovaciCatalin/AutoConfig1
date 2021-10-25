package App.Categoie1;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Dealer {
    private double price;
    private ArrayList<Part2> part2s = new ArrayList<>();
    public String getPrice() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        price= 0;
        deleteEmpty();
        for(Part2 part2 : part2s){
            price+= part2.getPrice()* part2.getAmount();
        }
        return formatter.format(price);
    }

    public void updateIngredients(String name, String price, int amount, Boolean inSandwich){
        double newPrice = Double.parseDouble(price);
        for (Part2 i: part2s){
            if(name.equals(i.getName())){
                i.setAmount(amount);
                i.setInSandwich(inSandwich);
                return;
            }
        }
        Part2 part2 = new Part2(name, newPrice);
        part2.setAmount(amount);
        part2.setInSandwich(inSandwich);
        part2s.add(part2);
    }
    public ArrayList<Part2> getIngredients(){
        return part2s;
    }

    public void deleteEmpty(){
        part2s.removeIf(part2 -> !part2.isInSandwich());
    }
}
