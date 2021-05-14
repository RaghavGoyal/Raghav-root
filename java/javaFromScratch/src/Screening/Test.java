package Screening;
import java.util.*;

public class Test {
        // DO NOT write a main method

    public static String productValues (Inventory[] items) {
        Map<String, Integer>    invCountByCode = new TreeMap<String, Integer> ();
        StringBuffer            result = new StringBuffer ();

        for (Inventory item : items)
        {
            if (!invCountByCode.containsKey(item.product))
            {
                invCountByCode.put(item.product, 0);
            }

            int prevLevel = invCountByCode.get(item.product);

            invCountByCode.put(item.product, prevLevel + item.qty);
        }

        for (String prodId : invCountByCode.keySet())
        {
            result.append(prodId).append(",").append(invCountByCode.get(prodId));
        }

        return result.toString() ;
    }


    public static class Inventory {
        public String   product;
        public int      qty;

        public Inventory(String product, int qty) {
            this.product = product;
            this.qty = qty;
        }


        @Override
        public String toString() {
            return qty + " * " + product;
        }
    }
}
