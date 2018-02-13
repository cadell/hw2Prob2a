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
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;

public class ThePain {

    /**
     * @param args the command line arguments
     */
    public static <AnyType extends Comparable<? super AnyType>> void main(String[] args) {
        
       // List<AnyType> lol = new LinkedList<>();
        List<AnyType> L1 = new LinkedList<>();
        List<AnyType> L2 = new LinkedList<>();
        List<AnyType> Difference = new LinkedList<>();
        L1.add((AnyType) new Integer(1));
        L1.add((AnyType) new Integer(2));
        L1.add((AnyType) new Integer(3));
        L1.add((AnyType) new Integer(4));
        
        L2.add((AnyType) new Integer(2));
        L2.add((AnyType) new Integer(6));
        L2.add((AnyType) new Integer(7));
        L2.add((AnyType) new Integer(8));
        
        difference(L1,L2,Difference);
        
    }

    public static <AnyType extends Comparable<? super AnyType>> void difference(List<AnyType> L1, List<AnyType> L2,List<AnyType> Difference) {
        AnyType itemL1 = null;
        AnyType itemL2 = null;
        
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        if (iterL1.hasNext() && iterL2.hasNext()) 
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
    int count = 0;
    int inc = 0;
    boolean state = false;
    boolean did = true;
    while(count <= L1.size()-1)
    {
        
        //int inc =0;
        int comp =0;
        if(state)
        {
            itemL1 = iterL1.hasNext()?iterL1.next():null;
            count++;
            inc = 0;
            state = false;
        }
        else if(!state)
        {   
          //  System.out.println(itemL1);
            if(itemL2 != null) 
            {
                comp = itemL1.compareTo(itemL2);
                
            }
            if(comp != 0) 
            {
                //System.out.println("Here");
                if(inc ==0)
                {
                    Difference.add(itemL1);
                    inc++;
                }
                
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }
            else if(comp == 0)
            {
                state = true;
            }
            
            if(itemL2 == null) 
            {
                state = true; 
                iterL2 = L2.listIterator();
                itemL2 = iterL2.next();
                
            }
            
        }
        
    }
    
    for (AnyType s : Difference) {
         System.out.println(s);
    }
    }
}
