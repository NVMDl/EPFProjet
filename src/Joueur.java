/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mchelaif
 */
import java.util.Scanner;
public class Joueur {
    String nom;
    String couleur;
     Jeton [] ListeJetons= new Jeton [20];
     int nombreDesintegrateur=0 ;
     int nombreJetonRestant = 0;
     
     
 public Joueur()  {
 Scanner sc = new Scanner (System.in);
 nom=sc.next();
 
}


public String affecterCouleur( String couleurChoisie){
   couleur = couleurChoisie;
   return couleur ;   
}
public int ajouterJeton(Jeton  jetonAjouter){
  ListeJetons[nombreJetonRestant]= jetonAjouter; 
  nombreJetonRestant= nombreJetonRestant + 1 ; 
  return nombreJetonRestant ;
}
public int obtenirDesintegrateur(){
nombreDesintegrateur=nombreDesintegrateur +1;
  return nombreDesintegrateur ;
}
public boolean utiliserDesintegrateur(){
if ( nombreDesintegrateur==0){
return false;
}
else {
    nombreDesintegrateur=nombreDesintegrateur -1;
  return true ;
}
}
}


