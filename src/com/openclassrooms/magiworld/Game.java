package com.openclassrooms.magiworld;

import com.openclassrooms.magiworld.personnage.Guerrier;
import com.openclassrooms.magiworld.personnage.Mage;
import com.openclassrooms.magiworld.personnage.Personnage;
import com.openclassrooms.magiworld.personnage.Rodeur;

import java.util.Scanner;

public class Game {

  private Personnage player1;
  private Personnage player2;
  private Scanner sc = new Scanner(System.in);


  /**
   * Game start here
   * With the creation of both player1 & player2
   */
  public Game(){
    player1 = createPlayer(1);

    player2 = createPlayer(2);

    Start();

  }

  // ---- Personnage création ----

  /**
   * Method used for ask the parameter of the actual concerned personnage
   * Use a scanner for ask the value
   */
  private Personnage createPlayer(int playerNumber){
    System.out.println("Création du personnage du Joueur " + playerNumber);
    System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage");
    int classe = sc.nextInt();
    System.out.println("Niveau du personnage ?");
    int niveau = sc.nextInt();
    System.out.println("Force du personnage ?");
    int force = sc.nextInt();
    System.out.println("Agilité du personnage ?");
    int agilite = sc.nextInt();
    System.out.println("Intelligence du personnage ?");
    int intelligence = sc.nextInt();

    return instanciationPersonnage(classe, niveau, force, agilite, intelligence, playerNumber);
  }

  /**
   * Method used for instanciate the personnage with the good value
   */
  private Personnage instanciationPersonnage(int classe, int niveau, int force, int agilite, int intelligence, int playerNumber) {
    Personnage temp = null;
    switch (classe) {
      case 1:
        temp = new Guerrier(niveau, force, agilite, intelligence, playerNumber);
        break;
      case 2:
        temp = new Rodeur(niveau, force, agilite, intelligence, playerNumber);
        break;
      case 3:
        temp = new Mage(niveau, force, agilite, intelligence, playerNumber);
        break;
    }
    System.out.println(temp);
    return temp;
  }

  // ---- Game turn ----

  /**
   * Method for start the fight
   * We use a modulo for the pair and impair turn
   */
  private void Start(){
    int turn = 1;

    while (player1.getVie() > 0 && player2.getVie() > 0){

      if(turn % 2 == 1){
        Turn(player1, player2);
      }else{
        Turn(player2, player1);
        }
        turn++;
      }
    if (player1.getVie() <= 0){
      System.out.println("Joueur 1 à perdu !");
    }else{
      System.out.println("Joueur 2 à perdu !");
    }
    }

  /**
   * Method used for a turn of the game
   * @param attack the personnage who attack
   * @param defend the personnage who defend
   */
  private void Turn(Personnage attack, Personnage defend){
      System.out.println("Joueur " + attack.getPlayerNumber() + " (" + attack.getVie() + " de vitalité) veuillez choisir " +
              "votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
      int choix = sc.nextInt();
      if (choix == 1)
        attack.attack1(defend);
      else
        attack.attack2(defend);
  }



}

