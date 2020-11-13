/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mchelaif
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    Joueur joueurCourant;
    
    
    
 public void Cellule(){
   jetonCourant= null;
   trouNoir= false;
   desintegrateur= false;
 }   
 
  public boolean affecterJeton(Jeton jetonAjout){
 if ( jetonCourant==null){
     jetonCourant= jetonAjout;
 
return true;
}
else {
  return false ;
 }   
}
 public Jeton recupererJeton(){
   return jetonCourant;
 }   
   public boolean supprimerJeton(){
 if ( jetonCourant==null){
return false;
}
else {
    jetonCourant=null; 
  return true;
 }   
}
public boolean placerTrouNoir(){
 if ( trouNoir==true){
return false;
}
else {
    trouNoir=true; 
  return true;
 }   
} 
public boolean placerdesintegrateur(){
 if (desintegrateur==true){
return false;
}
else {
    desintegrateur=true; 
  return true;
 }   
} 
public boolean presenceTrouNoir(){
        return trouNoir;   
} 
public boolean presenceDesintegrateur(){
        return desintegrateur;   
} 
public String lireCouleurDuJeton(){
        return jetonCourant.couleur;   
} 
public boolean recupererdesintegrateur(){
 if (desintegrateur==false){
return false;
}
else {
    desintegrateur=false; 
    joueurCourant.nombreDesintegrateur= joueurCourant.nombreDesintegrateur + 1 ;
  return true;
 }   
} 
public boolean activerTrouNoir(){
 if ( trouNoir==false){
return false;
}
else {
    trouNoir=false; 
    jetonCourant=null;
  return true;
 }   
} 
}