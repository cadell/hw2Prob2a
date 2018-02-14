/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepain;

/**
 *
 * @author cadelmonterde
 */
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;

public class ThePain
{

    /**
     * @param args the command line arguments
     */
    public static <AnyType extends Comparable<? super AnyType>> void main(String[] args)
    {

        // List<AnyType> lol = new LinkedList<>();
        List<AnyType> L1 = new LinkedList<>();
        List<AnyType> L2 = new LinkedList<>();
        List<AnyType> Difference = new LinkedList<>();
        List<AnyType> same = new LinkedList<>();
        L1.add((AnyType) new Integer(1));
        L1.add((AnyType) new Integer(2));
        L1.add((AnyType) new Integer(3));
        L1.add((AnyType) new Integer(4));
        L1.add((AnyType) new Integer(5));
        L1.add((AnyType) new Integer(8));
        L1.add((AnyType) new Integer(10));
        

        L2.add((AnyType) new Integer(2));
        L2.add((AnyType) new Integer(6));
        L2.add((AnyType) new Integer(7));
        L2.add((AnyType) new Integer(8));
        L2.add((AnyType) new Integer(9));
        difference(L1, L2, Difference);
        System.out.println("");
        interception(L1, L2, same);
    }

    public static <AnyType extends Comparable<? super AnyType>> void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference)
    {
        AnyType itemL1 = null;
        AnyType itemL2 = null;

        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        if (iterL1.hasNext() && iterL2.hasNext())
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        
        int counter =0;
        int amount  =0;
        while(counter < L1.size())
        {
            int comp = itemL1.compareTo(itemL2);
            if(iterL2.hasNext())itemL2 = iterL2.next();
            if(comp != 0) amount+=1;
             
            if(!iterL2.hasNext())
            {
                comp = itemL1.compareTo(itemL2);
                if(comp != 0) amount+=1;
                if(amount == L2.size()) Difference.add(itemL1);
                counter++;
                amount =0;
                itemL1 = iterL1.hasNext()?iterL1.next():null;
                iterL2 = L2.listIterator();
                itemL2 = iterL2.next();
            }
        }
        
        for (AnyType s : Difference)
        {
            System.out.println(s);
        }
    }
}
