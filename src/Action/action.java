/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;
import Card.Card;
import Deck.*;
import Hand.*;
import game.*;
import Card.*;

/**
 *
 * @author nickchang244
 */
public class action {
    
    
    public static int hit(BlackjackHand person, Deck card){
            int playerCardVal=0;
            
                 
                
                     Card oneCard=card.dealCard();
                     person.addCard(oneCard);
                     System.out.println(" player hit card, card is: "+ oneCard);
                     playerCardVal = person.getBlackjackValue();

                     System.out.println("player now has : "+ playerCardVal);
                     
                   
                    
        
             return playerCardVal;
    }
    
    
    public static void stand(){
        
            
    }
    
     public static BlackjackHand split(BlackjackHand playerhand , Deck card){
            
               
                    BlackjackHand splitHand = new BlackjackHand();
                    
                    splitHand.addCard(playerhand.getCard(1));
                    splitHand.addCard(card.dealCard());
                    return splitHand;
               
               
            
     }
     
     public static int Double(BlackjackHand player, Deck card){
                
                     int playerCardVal=0;
                     Card oneCard=card.dealCard();
                     player.addCard(oneCard);
                     System.out.println(" player hit card, card is: "+ oneCard);
                     playerCardVal = player.getBlackjackValue();

                     System.out.println("player now has : "+ playerCardVal);
                     
                   
                    
        
             return playerCardVal;
     }
    
}
