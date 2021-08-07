import java.util.Scanner;

class Functionnality{

    /*
     *  cette méthode permet de nous fournir des cartes de jeu par lesquelles on va jouer,
     *  elle privée parce qu'elle ne s'utilise que dans cette classe.
     */

    private static Card[] provideCardsGame( int n ){
        Card [] cardsMixedUp = Card.mixUp( Card.provideCards() ) ,
                cardsGame    = new Card[n] ;
        for( int i = 0 ; i < n ; i++ ) 
            cardsGame[i] = new Card( cardsMixedUp[i] ) ;        
        return cardsGame ;
    } 
    
    /*
     *  cette méthode permet de diviser une serie de cartes en 3 groupes, 
     */

    private static Card[][] divideCardsToGroups( Card cardsGame[] ){
        int n = (cardsGame.length)/3 , k = 0 ;
        Card[][] cardsGroups = new Card[3][n] ;
        for( int j = 0 ; j < n ; j++ )
            for( int i = 0 ; i < 3 ; i++ ){
                cardsGroups[i][j] = new Card( cardsGame[k] ) ;
                k++ ;
            }
        return cardsGroups ;
    }

    /*
     *  cette méthode permet de retourner les entrées de l'utilisateur
     */
    
    private static String userValue( Scanner keyboard ) {
        return keyboard.nextLine() ;
    }
    
    /*
     *  cette méthode permet de dessiner des points avec un peu de retard
     */
    
    private static void waitDot( int n , boolean newLine ) {
        try{
            for( int i = 0 ; i<n ; i++ ){
                Thread.sleep(100); System.out.print(".") ;
            }
            if( newLine ) System.out.println() ;
            Thread.sleep(200) ;
        } catch( InterruptedException e){
        }
    }
    
    /*
     *  cette méthode contient le code complet de jeu,
     *  on la lissé avec un modificateur de visibilité par défaut 
     *  parce que la classe qui va l'utiliser et est dans le meme package que celle-ci...
     */
    
    static void play( int n ){
        Scanner keyboard = new Scanner(System.in) ;

        System.out.print( "DEBUT DE JEU" ); 

        waitDot(3 , true) ;

        Card [] cardsGame = provideCardsGame( n ) ;

        System.out.println( "Veuillez choisir une carte parmis ces cartes suivantes :" );
        
        waitDot(18 , false) ; System.out.print( " LES " + n + " CARTES " ); waitDot(18 , true) ;

        Card.displayCards( cardsGame );
        System.out.println( "avez vous choisi une carte? Vous vous le souvenez bien (Y/N) ? " );
        if( !(userValue(keyboard).trim().equalsIgnoreCase("Y")) ){
            System.out.println( "Veuillez vous souvenir une carte afin de pouvoir continuer le jeu, bonne chance pour le prochain essai!" );
            keyboard.close();
            return ;
        }             

        Card [][] cardsGroups ;
        int nGroup ;
        String line ;

        for( int i = 0 ; i < 3 ; i++ ){
            System.out.println( "Veuillez choisir le groupe ou se trouve la carte que vous avez choisie" );
            cardsGroups = divideCardsToGroups(cardsGame) ;
            displayCardsGroups( cardsGroups ) ;
            
            line = userValue(keyboard) ;
            
            nGroup = Integer.parseInt(line.trim()) ;
            if( nGroup < 1 || nGroup > 3 ){
                System.out.println( "Les nombres permis sont 1 - 2 - 3" );
                keyboard.close();
                return;
            }
            for( int j = 0 ; j < n ; j++ )
                cardsGame[j] = new Card( mergeGroups(cardsGroups, nGroup)[j]) ;
        }
        keyboard.close();
        waitDot(20 , false) ; System.out.print( " RESULTAT " ); waitDot(20 , true) ;
        System.out.println( "La partie est finie, la carte que vous avez choisie est : " + cardsGame[cardsGame.length/2] );
    }

    /*
     *  cette méthode permet de fusionner des groups passées en paramettre afin de les assembler en un seul groupe de n cards...
     */

    private static Card[] mergeGroups( Card cards[][] , int nGroup ) {
        int firstGroup , thirdGroup , n = cards[0].length ;
        Card mergedCards [] = new Card [ n*3 ] ;
        
        if( nGroup == 2 ) {  firstGroup = 0 ; thirdGroup = 2 ;  }
        else {  firstGroup = (nGroup)%3 ; thirdGroup = (nGroup+1)%3 ;  }

        nGroup-- ; 
        for( int i = 0 ; i < n ; i++ ){
            mergedCards[i] = new Card( cards[firstGroup][i] ) ;
            mergedCards[n + i] = new Card( cards[nGroup][i] ) ;
            mergedCards[2*n + i] = new Card( cards[thirdGroup][i] ) ;
        }
        return mergedCards ;
    }

    /*
     *  cette méthode permet d'afficher les cartes de chaque groupes ...
     */

    private static void displayCardsGroups( Card[][] cardsGroups ){
        for( int i = 0 ; i < 3 ; i++ ){
            System.out.println( "************ GROUPE " + (i+1) + " ***********" );
            Card.displayCards( cardsGroups[i] );
        }
    }
}