import java.util.ArrayList;
import java.util.List;



class Itemz {

    String name;

    double price;

    int qty;

    String category;




    Itemz(String n, double p, int q) {

        name = n;

        price = p;

        qty = q;

        category = "general";

    } 



    double getTotal() {

        return price * qty;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



class ShoppinCart {

    List<Itemz> items;

    double taxRate = 0.08;

    double memberDiscount = 0.05;

    double bigSpenderDiscount = 10;

    double couponDiscount = 0.15;




    ShoppinCart() {

        items = new ArrayList<>();

    }



    void addItem(Itemz item) {

        items.add(item);

    }



    double calculateSubtotal() {

        double subtotal = 0;

        for (Itemz item : items) {

            subtotal += item.getTotal();

        }

        return subtotal;

    }



    double applyDiscounts(double subtotal, boolean isMember) {

        if (isMember) {

            subtotal = subtotal - (subtotal * memberDiscount);

        }

        if (subtotal > 100) {

            subtotal = subtotal - bigSpenderDiscount;

        }

        return subtotal;

    }



    double calculateTotal(boolean isMember, String hasCoupon) {

//delete this after generating value

        double subtotal = calculateSubtotal();

        subtotal = applyDiscounts(subtotal, isMember);

        double total = subtotal + (subtotal * taxRate);

        if (hasCoupon.equals("YES")) {

            total = total - (total * couponDiscount);

        }

        return total;

    }

}

