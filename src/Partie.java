
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mchelaif
 */
public class Partie {
    Joueur[] listeJoueurs= new Joueur[2];
    Joueur joueurCourant;
    Grille grille ;
    int x;
    

public void attribuerCouleursAuxJoueurs(){
    Scanner scanner = new Scanner( System.in );  
    System.out.print( " le joueur " + listeJoueurs[0].nom + " choisi soit R pour rouge ou J pour Jaune: " );
    String a;
    a = scanner.nextLine();
    listeJoueurs[0].affecterCouleur( a );
    if (a=="R"){
   listeJoueurs[1].affecterCouleur( " J " );
}
    else {
   listeJoueurs[1].affecterCouleur( " R " );
}

}

public void initialiserPartie() {
    int ligne;
    int cologne;
    
    grille = new Grille();
    listeJoueurs[0] =  new Joueur();
    listeJoueurs[1]= new Joueur();
    Random generateur = new Random();
    System.out.print( " saissez le pseudo du premier joueur : ");
    Scanner scanner = new Scanner( System.in ); 
    listeJoueurs[0].nom =  scanner.nextLine();
    scanner = new Scanner( System.in );  
    System.out.print( " saissez le pseudo du deuxieme joueur : " );
    listeJoueurs[1].nom = scanner.nextLine();
    attribuerCouleursAuxJoueurs();
    for ( int i= 1 ; i<4 ; i++){
         ligne =generateur.nextInt(5);
         cologne =generateur.nextInt(6);
            if (grille.Cellules[ligne][cologne].desintegrateur== false){
                   grille.Cellules[ligne][cologne].placerdesintegrateur() ;
}
            else {
                   i=i-1 ;
}
            
}
  for ( int i= 1 ; i<5 ; i++){
         ligne =generateur.nextInt(5);
         cologne =generateur.nextInt(6);
            if (grille.Cellules[ligne][cologne].trouNoir== false){
                   grille.Cellules[ligne][cologne].placerTrouNoir() ;
}
            else {
                   i=i-1 ;
}
              
            
}
  for ( int i= 1 ; i<21 ; i++){
      listeJoueurs[0].ajouterJeton(new Jeton(listeJoueurs[0].couleur));
      listeJoueurs[1].ajouterJeton(new Jeton(listeJoueurs[1].couleur));  
            
}
  
 
}
public void debuterPartie(){
    
initialiserPartie();
joueurCourant= listeJoueurs[0];
int action; 
int cologne;
Scanner scanner;
Jeton le_desintegrer ;

le_desintegrer= new Jeton("");

do {
    grille.afficherGrilleSurConsole();
    scanner = new Scanner( System.in );  
    System.out.print(  joueurCourant.nom +" c'est a ton tour tu a 2 option " );
    System.out.print(  "\n tu peux soit : \n 1/ placer un jeton \n 2/ utilisez un desintegarteur " );
    System.out.print( "\n"+ joueurCourant.nom +" n'oublie pas tu a : " + joueurCourant.nombreDesintegrateur +" \n et aussi : " +joueurCourant.nombreJetonRestant + "jeton ");
    System.out.print("alors : ");
    action = scanner.nextInt();
    switch (action){
        case 1:
             if (joueurCourant.nombreJetonRestant== 0){
        System.out.println(joueurCourant.nom +" vous n'avez pas de jetons utilisez une autre option ");
        break;
    }
             System.out.println(joueurCourant.nom +" saissisez la cologne ou voulez mettre un jetton : ");
             scanner = new Scanner( System.in ); 
              cologne = scanner.nextInt();
              if (cologne > 7  || cologne == 0){
        System.out.println(joueurCourant.nom +" cette cologne n'existe pas ");
        break;
    }
                     if (grille.cologneRemplie( cologne -1)==true){
        System.out.println(joueurCourant.nom +" cette cologne est remplie réessayer ");
        break;
    }
                     grille.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestant -1], cologne -1);
                     joueurCourant.nombreJetonRestant = joueurCourant.nombreJetonRestant -1;
                        if (joueurCourant== listeJoueurs[0]){
        joueurCourant=listeJoueurs[1];
        
    }
                           else{
        joueurCourant= listeJoueurs[0];
        
    }
              
      
        case 2:
              if (joueurCourant.nombreDesintegrateur== 0){
        System.out.println(joueurCourant.nom +" vous n'avez pas de desintegrateur utilisez une autre option ");
        break;
    }
               System.out.println(joueurCourant.nom +" saissisez la cologne ou voulez desintegrer un jeton ");
               scanner = new Scanner( System.in ); 
               cologne = scanner.nextInt();
                if (cologne > 7  || cologne < 0){
        System.out.println(joueurCourant.nom +" cette cologne n'existe pas ");
        break;
    }
                joueurCourant.utiliserDesintegrateur();
                le_desintegrer.couleur=grille.Cellules[0][cologne].jetonCourant.couleur;
                grille.tasserGrille(cologne);
                                  if (le_desintegrer.couleur== listeJoueurs[0].couleur){
                                       joueurCourant.ListeJetons[joueurCourant.nombreJetonRestant + 1]= listeJoueurs[0].ListeJetons[listeJoueurs[0].nombreJetonRestant]; 
                                       listeJoueurs[0].ListeJetons[listeJoueurs[0].nombreJetonRestant]= null; 
  listeJoueurs[0].nombreJetonRestant= listeJoueurs[0].nombreJetonRestant - 1  ;
        
    }
                           else{
                                      joueurCourant.ListeJetons[joueurCourant.nombreJetonRestant + 1]=listeJoueurs[1].ListeJetons[listeJoueurs[1].nombreJetonRestant];
          listeJoueurs[1].ListeJetons[listeJoueurs[1].nombreJetonRestant]= null; 
  listeJoueurs[1].nombreJetonRestant= listeJoueurs[1].nombreJetonRestant - 1  ;
        
    }
        if (joueurCourant== listeJoueurs[0]){
        joueurCourant=listeJoueurs[1];
        
    }
                           else{
        joueurCourant= listeJoueurs[0];
        
    }
             
        
      }      
}while ( grille.etreGagnantePourJoueur(listeJoueurs[0])== false || grille.etreGagnantePourJoueur(listeJoueurs[1])== false
        || listeJoueurs[0].nombreJetonRestant== 0 && listeJoueurs[1].nombreJetonRestant== 0 && listeJoueurs[1].nombreDesintegrateur==0 && listeJoueurs[0].nombreDesintegrateur==0 );
    if (grille.etreGagnantePourJoueur(listeJoueurs[0])== true){
        System.out.println(listeJoueurs[0].nom +" a gagné la partie ");
    }
if (grille.etreGagnantePourJoueur(listeJoueurs[1])== true){
        System.out.println(listeJoueurs[1].nom +" a gagné la partie ");
    }
grille.viderGrille();

    
}
    
    
}

