// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int nums [] = {1,2,3};
        backtrack(nums,0,1);
    }
    public static void backtrack(int nums [],int a,int fun){
        System.out.println("fun is :"+fun);
        for(int i = a;i < nums.length;i++){
            System.out.println(i+" ");
            backtrack(nums,a+1,fun+1);
            //here we dont need to backtrack , as we just want to know how does loop work with recursion.
        }
    }
}
