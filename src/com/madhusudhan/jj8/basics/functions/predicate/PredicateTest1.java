/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jj8.basics.functions.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author mkonda
 */
public class PredicateTest1 {

    Predicate<String> emptyStringChecker = s -> s.isEmpty();
//    Predicate<Employee> isExec = emp -> emp.isExec();

    Predicate<Trade> bigTrade = (t) -> t.isBigTrade();
    Predicate<Trade> cancelledTrade = (t) -> t.isCancelledTrade();

    // using method reference
    Predicate<Trade> cancelledTrade2 = Trade::isCancelledTrade;

    Predicate<Trade> isEqualsTrade = (t) -> {
        return t.equals(this);
    };

    //OR
    Predicate<Trade> bigORCancelledTrade = bigTrade.or(cancelledTrade);
    
    Predicate<Trade> cancelledBigTrade = bigTrade.and(cancelledTrade);

    private String ISSUER = "GOOG";
    Predicate<Trade> ibmTrades = t -> t.getIssuer().equals(ISSUER);

    Predicate<Trade> cancelledBigIBMTrades = cancelledBigTrade.and(ibmTrades);

    BiPredicate<Trade, Trade> isBig = (t1, t2) -> t1.getQuantity() > t2.getQuantity();

    private List<Trade> createTrades() {
        List<Trade> tradesList = new ArrayList<>();

        Trade t = null;

        t = new Trade();
        t.setQuantity(100000);
        t.setState("CANCEL");
        tradesList.add(t);

        t = new Trade();
        t.setQuantity(200000);
        t.setState("CANCEL");
        t.setIssuer("IBM");
        tradesList.add(t);

        t = new Trade();
        t.setQuantity(300000);
        t.setState("NEW");
        tradesList.add(t);

        return tradesList;
    }

    private void bigTradeTest(Trade t) {

        boolean tr = bigTrade.test(t);
        System.out.println("Trade 1: " + tr);

        bigTrade = bigTrade.negate();
        tr = bigTrade.test(t);
        System.out.println("Trade 2: " + tr);
    }

    private void cancelledTradeTest(Trade t) {
        boolean tr = cancelledTrade.test(t);
        System.out.println("Trade cancelled?: " + tr);
    }

    private void testBigAndCancelledTrades() {
        System.out.println("Cancelled Big Trade: " + cancelledBigTrade.toString());

        findBigAndCancelledTrades(createTrades(), cancelledBigTrade);
    }

    private void testIBMBigAndCancelledTrades() {
        System.out.println("Cancelled Big Trade: " + cancelledBigTrade.toString());

        findIBMBigAndCancelledTrades(createTrades(), cancelledBigTrade);
    }

    private void testEquals(Trade tt) {
        Trade t = new Trade();
        Predicate<Trade> eq = Predicate.isEqual(tt);
    }

    public static void main(String[] args) {
        PredicateTest1 test = new PredicateTest1();

        new PredicateTest1().bigTradeTest(test.createBigTrade());

        new PredicateTest1().cancelledTradeTest(test.createCancelledTrade());
        new PredicateTest1().testBigAndCancelledTrades();
        new PredicateTest1().testIBMBigAndCancelledTrades();
    }

    private Trade createBigTrade() {
        Trade t = new Trade();
        t.setQuantity(100000);
        return t;
    }

    private Trade createCancelledTrade() {
        Trade t = new Trade();
        t.setState("CANCEL");
        return t;
    }

    private void findBigAndCancelledTrades(List<Trade> createTrades, Predicate<Trade> cancelledBigTrade) {
        for (Trade trade : createTrades) {
            if (cancelledBigTrade.test(trade)) {
                System.out.println("Trade is big and cancelled: " + trade);
            }
        }
//        createTrades.stream().filter(cancelledBigTrade).forEach(printTrade);
    }

    //AND
    private void findBigAndCancelledTrade(Trade trade, Predicate<Trade> cancelledBigTrade) {
        if (cancelledBigTrade.test(trade)) {
            System.out.println("Trade is big and cancelled: " + trade);
        }
    }
    
    
    private void findBigAndCancelledIssuerTrade(Trade trade, Predicate<Trade> cancelledBigIBMTrades) {
        if (cancelledBigIBMTrades.test(trade)) {
            System.out.println("Trade is big and cancelled: " + trade);
        }
    }

    //OR
    private void findBigORCancelledTrade(Trade trade, Predicate<Trade> predicate) {
        if (bigORCancelledTrade.test(trade)) {
            System.out.println("Trade is big and cancelled: " + trade);
        }
    }
    

    private void findIBMBigAndCancelledTrades(List<Trade> createTrades, Predicate<Trade> cancelledBigIBMTrades) {
        for (Trade trade : createTrades) {
            if (cancelledBigIBMTrades.test(trade)) {
                System.out.println("Trade is IBM+ big and cancelled: " + trade);
            }
        }
    }

    private void andTest() {
        bigTrade.and(cancelledTrade).test(null);
    }

    class Trade {

        @Override
        public String toString() {
            return "Trade{" + "quantity=" + quantity + ", state=" + state + '}';
        }

        private int quantity = 0;
        private String state = null;

        private String issuer = null;

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public String getState() {
            return state;
        }

        public void setState(String STATE) {
            this.state = STATE;
        }

        public boolean isBigTrade() {
            if (quantity > 10000) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isCancelledTrade() {
            if (getState().equals("CANCEL")) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isIssuer() {
            String s = "IBM";
            if (s.equalsIgnoreCase(issuer)) {
                return true;
            }
            return false;
        }
        
        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
