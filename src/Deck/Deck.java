/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deck;

import Card.*;
import Hand.*;

/**
 *
 * @author nickchang244
 */
/* 
    An object of type Deck represents an ordinary deck of 52 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
*/

public class Deck {

    private Card[] deck;   // An array of 52 Cards, representing the deck.
    private int cardsUsed; // How many cards have been dealt from the deck.
    
    public Deck() {
           // Create an unshuffled deck of cards.
       deck = new Card[104];
       int cardCt = 0; // How many cards have been created so far.
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck[cardCt] = new Card(value,suit);
             cardCt++;
          }
       }
       
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck[cardCt] = new Card(value,suit);
             cardCt++;
          }
       }
       cardsUsed = 0;
    }
    
    public void shuffle() {
          // Put all the used cards back into the deck, and shuffle it into
          // a random order.
        for ( int i = 103; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }
    
    public int cardsLeft() {
          // As cards are dealt from the deck, the number of cards left
          // decreases.  This function returns the number of cards that
          // are still left in the deck.
        return 52 - cardsUsed;
    }
    
    public Card dealCard() {
          // Deals one card from the deck and returns it.
        if (cardsUsed == 104)
           shuffle();
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
    
    public void statistic(BlackjackHand player)  throws Exception{
         
        int intendVal=21-player.getBlackjackValue();
         
        int counter =0 ;
        
        for(int i=cardsUsed; i<104;i++){
            int c= deck[i].getValue();
            if(c>10){
                c=10;
            }
            if(c<=intendVal){
           //  System.out.println("hit");
                counter++;
            }
            
            
            
        }
       // for(int i= cardsUsed; i<104 ; i++){
       //    System.out.println(deck[i]);
        //}
                
                 double result = ((double)counter/(double)(104-cardsUsed)) * 100;
                
                
                 
                 
                 System.out.println("Statistic : the presentage not to be bust is: "+ result+" % ");
              //   System.out.println("intendVal is  "+ intendVal);
                // System.out.println("Counter  and  cardsleft :" + counter+"  "+ (104-cardsUsed));

    }

} // end class Deck
