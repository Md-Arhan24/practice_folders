class AssingmentDp{
    public static void main(String[] args) {
        int n = 2;
        printPara(n ,"",0,0);
    }
    public static void printPara(int n,String str,int op,int cl){
        if(op == cl && cl == n){
            System.out.println(str);
            return;
        }

        if(op < n){
            printPara(n, str+"(", op+1, cl);
        }
        if(cl < op){
            printPara(n, str+")", op, cl+1);
        }
    }
}