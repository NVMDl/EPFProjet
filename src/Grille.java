/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mchelaif
 */
public class Grille {
   Cellule [][] Cellules= new Cellule[6][7] ;
   String [][] grillepres= new String [6][7];
   
 
public Grille(){
    for (int nombre=0;nombre<6;nombre++){
            for (int numero=0;numero<7;numero++){
                Cellules[nombre][numero]= new Cellule();
              
}
}
    }
public boolean ajouterJetonDansColonne(Jeton jetoncolonne, int numero){
    boolean reponse;
    int nombre1;
    reponse = false ;
    int nombre=0;
    while ( reponse == false  || nombre == 6 ){
        
             if (Cellules[nombre][numero].jetonCourant==null){
                Cellules[nombre][numero].jetonCourant=jetoncolonne;
                reponse= true ;
               
                return true;
}
  nombre= nombre + 1 ;         
}
          if (reponse== true){
                 if (Cellules[nombre][numero].desintegrateur== true){
                Cellules[nombre][numero].recupererdesintegrateur();
                
}
     if (Cellules[nombre][numero].trouNoir== true){
                Cellules[nombre][numero].activerTrouNoir();
                
}             
                

}
    return false;
    }
public boolean etreRemplie(){
    for (int nombre=0;nombre<6;nombre++){
            for (int numero=0;numero<7;numero++){
                if (Cellules[nombre][numero]==null){
                    return false;
}
}
    }
    return true;
    }
public void viderGrille(){
    for (int nombre=0;nombre<6;nombre++){
            for (int numero=0;numero<7;numero++){
                Cellules[nombre][numero].jetonCourant= new Jeton (null);
                Cellules[nombre][numero].desintegrateur=false;
                Cellules[nombre][numero].trouNoir=false;
}
}
    }
public void afficherGrilleSurConsole(){
    
    for (int nombre=0;nombre<6;nombre++){
            for (int numero=0;numero<7;numero++){
                if (Cellules[nombre][numero].jetonCourant!=null){
                    grillepres[nombre][numero]=Cellules[nombre][numero].jetonCourant.couleur;
                    
                    
}
                else {
                    if (Cellules[nombre][numero].trouNoir==true){
                    grillepres[nombre][numero]=" TN ";
                     
}
                    else{
                         grillepres[nombre][numero]=" - ";
}
                }

                }
                            System.out.println(grillepres[nombre][0] + grillepres[nombre][1] +grillepres[nombre][2] +grillepres[nombre][4] +grillepres[nombre][5]  );
    }
    }
public boolean celluleOccupee(int numero,int nombre){
 if (Cellules[nombre][numero].jetonCourant ==null){
  return false  ;  
}
 else {
     return true;
 }
 }

public String lireCouleurDuJeton(int nombre, int numero){
    return Cellules[nombre][numero].jetonCourant.couleur;
}
public boolean etreGagnantePourJoueur(Joueur Joueur1){
  for (int nombre=0;nombre<6;nombre++){
      for (int numero=0;numero<7;numero++){
          
          if(Cellules[nombre][numero].jetonCourant.couleur==Joueur1.couleur){
              
              if(Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+1][numero].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+2][numero].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+3][numero].jetonCourant.couleur){
                  return true;
                  
              }
          
            if(Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre][numero+1].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre][numero+2].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre][numero+3].jetonCourant.couleur){
                  return true;}
      
          if(Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+1][numero+1].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+2][numero+2].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre+3][numero+3].jetonCourant.couleur){
                  return true;}
          if(Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre-1][numero-1].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre-2][numero-2].jetonCourant.couleur &&
                      Cellules[nombre][numero].jetonCourant.couleur==Cellules[nombre-3][numero-3].jetonCourant.couleur){
                  return true;}
          }
  } 
} 
  return false;
}
public boolean placerTrouNoir(int numLigne, int numCologne){

if ( Cellules[numLigne][numCologne].trouNoir==true){
return false;
}
else {
    Cellules[numLigne][numCologne].trouNoir=true; 
  return true;
 }   

}
public boolean placerdesintegrateur(int numLigne, int numCologne){
 if (Cellules[numLigne][numCologne].desintegrateur==true){
return false;
}
else {
    Cellules[numLigne][numCologne].desintegrateur=true; 
  return true;
 }   
} 
   public boolean supprimerJeton(int numLigne, int numCologne){
 if ( Cellules[numLigne][numCologne].jetonCourant==null){
return false;
}
else {
    Cellules[numLigne][numCologne].jetonCourant=null; 
  return true;
 }   
}
public Jeton recupererJeton(int numLigne, int numCologne){
       Jeton jeton2 = Cellules[numLigne][numCologne].jetonCourant;
       Cellules[numLigne][numCologne].jetonCourant=null;
      return jeton2;
 }   
public void tasserGrille(int numeroCologne){
 for (int numero=0;numero<6;numero++){
  Cellules[numero][numeroCologne]=Cellules[numero+1][numeroCologne];
}
}
public boolean cologneRemplie(int numeroCologne){
if (Cellules[5][numeroCologne].jetonCourant==null){
    return false;

}
return true;
}
}