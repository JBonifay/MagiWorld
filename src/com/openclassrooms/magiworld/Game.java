package com.openclassrooms.magiworld;

import com.openclassrooms.magiworld.personnage.Guerrier;
import com.openclassrooms.magiworld.personnage.Mage;
import com.openclassrooms.magiworld.personnage.Personnage;
import com.openclassrooms.magiworld.personnage.Rodeur;

import java.util.Scanner;

public class Game {

  private Personnage player1 = null;
  private Personnage player2 = null;
  private Scanner sc = new Scanner(System.in);


  /**
   * Game start here
   * With the creation of both player1 & player2
   */
  public void Game(){
    player1 = createPlayer(1);


  }

  /**
   * Method used for ask the parameter of the actual concerned personnage
   * Use a scanner for ask the value
   */
  public Personnage createPlayer(int playerNumber){
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

  public Personnage instanciationPersonnage(int classe, int niveau, int force, int agilite, int intelligence, int playerNumber) {
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
    return temp;
  }

}
