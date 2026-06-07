import java.util.*;
public class ChocolaProblem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            int column = sc.nextInt();//m
            int rows = sc.nextInt();//n
            //we want n X m, m is vertical lines
            int vertical [] = new int [column-1];
            for(int i = 0;i < vertical.length;i++){
                vertical[i] = sc.nextInt();
            }
            int horizontal[] = new int[rows-1];
            for(int i = 0;i < horizontal.length;i++){
                horizontal[i] = sc.nextInt();
            }
            System.out.println(getMinimumCost(vertical,horizontal));
        }
    }
    public static int getMinimumCost(int ver [],int hor []){
        //first we need two pointer and number of parts
        int verticalPointer = ver.length-1,horiPointer = hor.length-1, horiParts = 1, vertiParts = 1;

        //we have to sort in desending order
        Arrays.sort(ver);
        Arrays.sort(hor);
    
        int totalCost = 0;
        while(verticalPointer >= 0 && horiPointer >= 0){
            if(ver[verticalPointer] >= hor[horiPointer]){
                //see if we are keep veritcal cuts, then the line passing if from number of horz parts and it increse our vertical pices
                totalCost+=horiParts*ver[verticalPointer];
                verticalPointer--;
                vertiParts++;
            }else{
                totalCost+=vertiParts*hor[horiPointer];
                horiPointer--;
                horiParts++;
            }
            
        }
        //if one of the above condition fails
        while(verticalPointer >= 0){
            totalCost+=horiParts*ver[verticalPointer];
                verticalPointer--;
                vertiParts++;
                
        }
        while(horiPointer >= 0){
            totalCost+=vertiParts*hor[horiPointer];
                horiPointer--;
                horiParts++;
        }
        return totalCost;
    }
}