/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jj8.basics.functions.predicate;

import com.madhusudhan.jj8.domain.Trade;
import com.madhusudhan.jj8.util.TradeUtil;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author mkonda
 */
public class ChainedPredicatesTest {

//    //OR
//    Predicate<Trade> bigORCancelledTrade = bigTrade.or(cancelledTrade);
//    BiPredicate<Trade, Trade> isBig = (t1, t2) -> t1.getQuantity() > t2.getQuantity();
    private void testAnd(Trade trade) {

        Predicate<Trade> bigTrade = t -> t.isBigTrade();
        Predicate<Trade> cancelledTrade = t -> t.isCancelledTrade();

        // Composed logical AND predicate
        // If trade is cancelled AND is big
        Predicate<Trade> cancelledBigTrade = cancelledTrade.and(bigTrade);

        

        if(check(cancelledBigTrade, trade)){
            System.out.println("Trade is CANCELLED and BIG"+trade);
        }
        
        /* 
        * Chained ANDs 
        */
        String ISSUER = "GOOG";
        Predicate<Trade> issuerTrade = t -> t.getIssuer().equals(ISSUER);

        // This is a predicate with already composed cancelledBigTrade
        Predicate<Trade> cancelledBigTradeByIssuer = cancelledBigTrade.and(issuerTrade);
        
        if(check(cancelledBigTradeByIssuer, trade)){
            System.out.printf("Trade is CANCELLED and BIG and by %s,%s \n",ISSUER,trade);
        }
        
        /*
        * Combined OR and ANDs
        */
        
        Predicate<Trade> newTrade = t -> t.getStatus().equals("NEW");
        Predicate<Trade> pendingTrade = t -> t.getStatus().equals("PENDING");
        
        Predicate<Trade> newOrPendingButBigTrade = newTrade.or(pendingTrade).and(bigTrade);
        
        if(check(newOrPendingButBigTrade, trade)){
            System.out.printf("Trade is NEW or PENDING but BIG %s\n",trade);
        }
        
    }

    private boolean check(Predicate<Trade> tradePredicate, Trade t) {
        return tradePredicate.test(t);
    }

    public static void main(String[] args) {
        ChainedPredicatesTest test = new ChainedPredicatesTest();

        List<Trade> trades = TradeUtil.createTrades();

        for (Trade t : trades) {
            test.testAnd(t); 
        }
    }

}
