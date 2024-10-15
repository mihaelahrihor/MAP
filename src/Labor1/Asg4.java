package Labor1;

public class Asg4 {
    //a)
    public static int cheapestKeyboard(int[] keyboards) {
        int minPrice = Integer.MAX_VALUE;
        for (int price : keyboards) {
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice;
    }

    //b)
    public static int mostExpensiveItem(int[] keyboards, int[] usbDrives) {
        int maxPrice = Integer.MIN_VALUE;

        for (int price : keyboards) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }

        for (int price : usbDrives) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }

        return maxPrice;
    }
    //c)
    public static int withinBudget(int[] usbDrives, int budget) {
        int maxAffordable = -1;
        for (int price : usbDrives) {
            if (price <= budget && price > maxAffordable) {
                maxAffordable = price;
            }
        }
        return maxAffordable;
    }
//d)

    public static int budgetSpending(int budget, int[] keyboards, int[] usbDrives) {
        int maxSpent = -1;

        for (int keyboardPrice : keyboards) {
            for (int usbPrice : usbDrives) {
                int total = keyboardPrice + usbPrice;
                if (total <= budget && total > maxSpent) {
                    maxSpent = total;
                }
            }
        }
        return maxSpent;
    }


    public static void main(String[] args) {
        int[] keyboards = new int[]{40, 50, 60};
        System.out.println("the Cheapest Keyboard is: "+cheapestKeyboard(keyboards));

        int[] usbDrives = new int[]{8, 12};
        System.out.println("most epensive item is: "+mostExpensiveItem(usbDrives, keyboards));

        int budget= 60;
        System.out.println("USB within budget: "+ withinBudget(usbDrives, budget));

        System.out.println("has Spent: " + budgetSpending(budget, keyboards, usbDrives));


    }

}
