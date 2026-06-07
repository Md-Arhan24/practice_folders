public class Shortestpath {
    public static int getShortestpath(String s) {
        // every time we are startig from origin
        int x = 0, y = 0;

        //know the destiation
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
        }
    
        //calculateing cordinate
        // int ans = Math.sqrt(Math.pow(x,0) + Math.pow(y, 0)); here we have to cast to double
        int xpower = x*x;
        // System.out.println(xpower);
        int ypower = y*y;
        // System.out.println(ypower);
        double ans = (double)(xpower+ypower);
        // System.out.println(ans);
        return  (int)Math.sqrt(ans);
    
    }


    public static void main(String[] args) {
        String str = "WNEENESENNN";
        int shortedPath = getShortestpath(str);
        System.out.println(shortedPath);
    }
}
