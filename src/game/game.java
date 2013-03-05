/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Deck.*;
import Hand.*;
import Card.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




/**
 *
 * @author nickchang244
 */
public class game {
    
    
    
    private int playerCardVal=0;
    
    private int dealerCardVal=0;
    
    private BlackjackHand dealer = new BlackjackHand();
    
    private BlackjackHand player = new BlackjackHand();
    
    private BlackjackHand splitHand = new BlackjackHand();
    
    public game(){
        
    }
    
    
    
    
    public void newHand(Deck card){
        
        
        
        
        
        player.addCard(card.dealCard());
        
        dealer.addCard(card.dealCard());
        
        
          
        player.addCard(card.dealCard());
        
        dealer.addCard(card.dealCard());
        
        System.out.println("player has: "+ player.getCard(0)+" and "+player.getCard(1));
        
        System.out.println("Dealer's up card: "+ dealer.getCard(0));
    }
    
  
    
    public int playerRound(Deck card) throws Exception{
        
        
        System.out.println("H / W ? ");
 
	
                 BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                 String s = bufferRead.readLine();
            
                 int playerCardVal=0;
            
                 while(s.equals("h")||s.equals("H") ){
                
                     Card oneCard=card.dealCard();
                     player.addCard(oneCard);
                     System.out.println(" player hit card, card is: "+ oneCard);
                     playerCardVal = player.getBlackjackValue();

                     System.out.println("player now has : "+ playerCardVal);
                     
                    if(playerCardVal>21){
                         System.out.println("Player busted ");
                        break;
                    }
                     System.out.println("H / W ? ");
                     s = bufferRead.readLine();
                    }
        
        return playerCardVal;
        
    }
    
    public void dealerRound(Deck card ){
        
        
        
            while(dealer.getBlackjackValue()<17 ){
                   
                this.showDealerCards();
                         
                Card oneCard=card.dealCard();
                dealer.addCard(oneCard);
                System.out.println(" dealer hit card, card is: "+ oneCard);
                System.out.println("dealer total is: "+ dealer.getBlackjackValue());
                    
              }
        
        
    }
    
    public void endOfHand(){
        player.clear();
        
        dealer.clear();
        
        
    }
    
    public void showDealerCards(){
        String dealerHand;
        int i=dealer.getCardCount();
        
        
        while(i>0){
             
            System.out.println(" dealer now has "+ dealer.getCard(dealer.getCardCount()-i));
            i--;
        }
        
    }
    
    public int getPlayerVal(){
        return player.getBlackjackValue();
    }
    
    public int getDealerVal(){
        return dealer.getBlackjackValue();
    }
            
    
    public void result(BlackjackHand player){
        
        if(player.getBlackjackValue()>21){
            System.out.println("player busted Dealer wins! Player vs dealer: "+ player.getBlackjackValue()+" vs "+ dealer.getBlackjackValue());
            
        }
        
        else if(dealer.getBlackjackValue()>21){
            System.out.println("Player wins! Player vs dealer: "+ player.getBlackjackValue()+" vs "+ dealer.getBlackjackValue());
            
        }
        
        else if(player.getBlackjackValue()>dealer.getBlackjackValue() ){
            System.out.println(" player wins !Player vs dealer: "+ player.getBlackjackValue()+" vs "+ dealer.getBlackjackValue());
        }
        
        else if(player.getBlackjackValue()<dealer.getBlackjackValue() ){
            System.out.println( "Dealer wins !Player vs dealer: "+ player.getBlackjackValue()+" vs "+ dealer.getBlackjackValue());
        }
        
        else if(player.getBlackjackValue()== dealer.getBlackjackValue())
            System.out.println(" it's a tie !Player vs dealer: "+ player.getBlackjackValue()+" vs "+ dealer.getBlackjackValue());
    }
    
    public boolean CheckdealerBJ() throws Exception{
        
       // if(dealer.getCard(0).getValueAsString()=="Ace" ||dealer.getCard(0).getValue()==10){
             
        
            // BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
             //String s = bufferRead.readLine();
            
            if(dealer.getBlackjackValue()==21)
                return true;
            
            
        
            else
                return false;
        
    }
    
    public boolean CheckplayerBJ(){
            if(player.getBlackjackValue()==21)
                return true;
            
            
        
            else
                return false;
    }
    
    public void split(Deck card) throws Exception{
         
        if(player.getCard(0)==player.getCard(1)){
           
            System.out.println("Spliting hands");
 
                
                BlackjackHand splitHand = new BlackjackHand();
                splitHand.addCard(player.getCard(1));
                player.removeCard(1);
                
                player.addCard(card.dealCard());
                
                
                
                splitHand.addCard(card.dealCard());
                
                
                
        }
        
            
    }
    
    public boolean checkifBeginOfHand(){
         if(player.getCard(2)==null){
             return true;
             
         }
         
         else
             return false;
    }
    
    public BlackjackHand getAfterSplit(){
            
            return splitHand;
    }
    
    public BlackjackHand getPlayerHand(){
            
            return player;
    }
    
    public BlackjackHand getDealerHand(){
        
            return dealer;
    }
    
    public void Double(){
        
    }
}
    
   