//here we are implementing chess player , where every chess character like horse,king ,queen will be classes.
public class Interfaces{
    public static void main(String[] args) {
        Queen q = new Queen();//right new keyword, i have forgotten to do so.
        q.moves();
        Bear b = new Bear();
        b.eat();
    }
}
interface ChessPlayer{//first letter must be capital
    void moves();//its public(and see we dont use public keyword) and abstract

}
class Queen implements ChessPlayer{
    public void moves(){//but here we have to use public keyword to make it public 
        System.out.println("up,down,right,left,diagnoal(all four directions)");
    }
}
class Ele_rook implements ChessPlayer{
    public void moves(){//but here we have to use public keyword to make it public 
        System.out.println("up,dowm,left,right");
    }
}
class King implements ChessPlayer{
    public void moves(){//but here we have to use public keyword to make it public 
        System.out.println("up,dowm,left,right,diagnoal (by one step)");
    }
}
interface Herbivore{
    void eat();
}
interface Carnivoue{
    void eat();
}
class Bear implements Herbivore,Carnivoue{
    public void eat(){
        System.out.println("eat both grass and meat");
    }
}
