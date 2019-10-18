import java.util.Stack;
import java.lang.Math; 
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class testes{
    public static void main(String[] args){
        List<Integer> exp = new ArrayList<Integer>();
        int elem, previous=-1, next=-1;

        for(int i=35;i<50;i++){
            exp.add(i);
        }
        ListIterator<Integer> litr = exp.listIterator();

        while(litr.hasNext()){
            elem = litr.next();
            if(elem==41){
                litr.remove();
                litr.next();
                litr.set(4);
            }
        }

        for(int aaaa : exp){
            System.out.println(aaaa);
        }
    }
}
