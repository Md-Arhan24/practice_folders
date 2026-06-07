import java.util.Scanner;
public class LinearSearch {
    public static int menuSearcher(String menu[], String dish) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equals(dish)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // here is the menu
        String menu[] = { "dosa", "idli", "vada", "puri", "samosa", "bhajji", "water bootel" };
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the dish :");
        String dish = sc.nextLine();

         int index = menuSearcher(menu, dish);
         System.out.println("the index of " + dish +" is " + index);

    }
}