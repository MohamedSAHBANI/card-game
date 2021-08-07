import java.util.Scanner;

enum CardType{
    COPAS, BASTOS, OROS, ESPADAS
}

class Card{
    private int number ;
    private CardType type ;

    int getNumber(){
        return number ;
    }
    CardType getType(){
        return type ;
    }
    void setNumber( int number ){
        this.number = number ;
    }
    void setType( CardType type ){
        this.type = type ;
    }

    Card( int number , CardType type ){
        this.number = number ;
        this.type   = type   ;
    }

    Card( Card card ){
        this.number = card.number ; 
        this.type   = card.type   ;
    }

    static Card[] mixUp( Card cards[] ){
        Card[] cardsMixedUp = new Card[cards.length] ;
    
        int index ;
        for( int i = 0 ; i<40 ; i++ ){
           do { index = (int)( Math.random()*(40-0) ); }
           while( cardsMixedUp[index] != null ) ;
         
           cardsMixedUp[ index ] = new Card( cards[ i ] ) ;
        }
        return cardsMixedUp ;
    }

    static Card[] provideCards( ){
        Card [] cards = new Card[40] ;
        int counter = 0 ;
        for( int i = 0 ; i<10 ; i++ ){
            for( CardType type : CardType.values() ){
                if( i+1 > 7 ){
                    cards[counter]  = new Card( i+3 , type ) ;
                }
                else cards[counter] = new Card( i+1 , type ) ;
                counter ++ ; 
            }
            if( counter == 40 ) break ;
        }
        return cards ; 
    }

    static void displayCards( Card[] cards ){
        int n = cards.length ;
        for( int i = 0 ; i < n ; i++ )
            System.out.println( cards[i] ) ;
    }
    
    @Override
    public String toString( ){
        switch ( this.number ) {
            case 10:
                return number + " SOTA - " + type  ;
            case 11:
                return number + " CABALLO - " + type ;
            case 12:
                return number + " REY - " + type ;
            default:
                return number + "-" + type ;
        }    
    }
}