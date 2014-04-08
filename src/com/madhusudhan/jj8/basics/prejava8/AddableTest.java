package com.madhusudhan.jj8.basics.prejava8;

import com.madhusudhan.jj8.basics.prejava8.IAddable;
import com.madhusudhan.jj8.domain.Trade;

/**
 *
 * @author mkonda
 */
public class AddableTest {

    IAddable<String> stringConcatenator = new IAddable<String>() {
        @Override
        public String add(String s1, String s2) {
            return s1 + s2;
        }
    };

    IAddable<Trade> tradeMerger = new IAddable<Trade>() {
        @Override
        public Trade add(Trade t1, Trade t2) {
            t1.setQuantity(t1.getQuantity() + t2.getQuantity());
            return t1;
        }
    };

    IAddable<Trade> tradeAdder = (Trade t1, Trade t2) -> {
        t1.setQuantity(t1.getQuantity() + t2.getQuantity());
        return t1;
    };

    IAddable<Trade> largeTrade = (t1, t2) -> {
        if (t1.getQuantity() > 1000000) 
            return t1;
         else 
            return t2;
    };
    IAddable<Trade> encryptTrade = (t1, t2) -> encrypt(t1,t2);
    
    public Trade encrypt(Trade t1, Trade t2){
        return null;
    }

    IAddable<Trade> bigTrade = (Trade t1, Trade t2) -> {
        t1.setQuantity(t1.getQuantity() + t2.getQuantity());
        return t1;
    };

    IAddable<String> stringAdder = (s1, s2) -> s1 + s2;
    IAddable<Integer> square = (i1, i2) -> i1 * i2;

    public Trade applyBehaviour(IAddable<Trade> addable, Trade t1, Trade t2){
        return addable.add(t1, t2);
    }

    public void addStrings(String s1, String s2) {
        System.out.println("Sum of two numbers using lambda: " + stringConcatenator.add(s1, s2));
    }

    public void mergeTrades(Trade t1, Trade t2) {
        System.out.println("Before merge:" + t1.getQuantity());
        tradeMerger.add(t1, t2);
        System.out.println("After merge:" + t1.getQuantity());

    }

    public void mergeTradesUsingLambda(Trade t1, Trade t2) {
        System.out.println("Before merge (using Lambda):" + t1.getQuantity());
        tradeAdder.add(t1, t2);
        System.out.println("After merge (using Lambda):" + t1.getQuantity());

    }

    public static void main(String[] args) {
    IAddable<Trade> largeTrade = (t1, t2) -> {
        if (t1.getQuantity() > 1000000) 
            return t1;
         else 
            return t2;
    };
    
    
        AddableTest test = new AddableTest();
        test.addStrings("Just ", "java 7");
        Trade t1 = new Trade(1, "GOOG", 12000, "NEW");
        Trade t2 = new Trade(2, "GOOG", 24000, "NEW");
//        test.mergeTrades(t1, t2);
        test.mergeTradesUsingLambda(t1, t2);
        Trade t = test.applyBehaviour(largeTrade, t1, t2);
        System.out.println("Big trade: "+t);
    }
}
