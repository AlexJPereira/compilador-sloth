import java.util.Stack;

public class testes{
    public static void main(String[] args){
        Stack<Integer> numLocalVar = new Stack<Integer>();
        numLocalVar.push(0);
        numLocalVar.push(numLocalVar.pop()+1);
        numLocalVar.push(numLocalVar.pop()+1);
        System.out.println(numLocalVar.pop());
    }
}