package org.example;

import org.example.exception.InvalidMoveException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    private Room[][] board = new Room[12][8];
    private int amountOfMonsters;
    private int[][] monsterPositions;

    private int amountOfNpc;
    private int[][] npcPositions;
    private int[][] wallsPositions;
    private Player player;

    Random rand = new Random();

    public Game() {
    }

    public Game(int amountOfMonsters, int amountOfNpc, int[][] monsterPositions, int[][] npcPositions, int[][] wallsPositions, Player player) {
        this.amountOfMonsters = amountOfMonsters;
        this.amountOfNpc = amountOfNpc;
        this.monsterPositions = monsterPositions;
        this.npcPositions = npcPositions;
        this.wallsPositions = wallsPositions;
        this.player = player;
    }

    public int getAmountOfMonsters() {
        return amountOfMonsters;
    }

    public void setAmountOfMonsters(int amountOfMonsters) {
        this.amountOfMonsters = amountOfMonsters;
    }

    public int[][] getMonsterPositions() {
        return monsterPositions;
    }

    public void setMonsterPositions(int[][] monsterPositions) {
        this.monsterPositions = monsterPositions;
    }

    public int getAmountOfNpc() {
        return amountOfNpc;
    }

    public void setAmountOfNpc(int amountOfNpc) {
        this.amountOfNpc = amountOfNpc;
    }

    public int[][] getNpcPositions() {
        return npcPositions;
    }

    public void setNpcPositions(int[][] npcPositions) {
        this.npcPositions = npcPositions;
    }

    public int[][] getWallsPositions() {
        return wallsPositions;
    }


    public void setWallsPositions(int[][] wallsPositions) {
        this.wallsPositions = wallsPositions;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean generateMonsters() {
        return false;
    }

    public boolean generateRooms() {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                boolean walkable = true;
                int gold = 0;
                boolean combat = true;
                double chance = Math.random();
               if(chance < 0.1){ // 10% πιθανότητα για τοίχο (μη προσπελάσιμο)  F - Τοίχος/Νερό
                   board[i][j] = new Room(false, 0, false, false);

               } else if(chance < 0.25){ // D - Χρυσός (τυχαία ποσότητα)
                   int goldAmt = rand.nextBoolean() ? rand.nextInt(50) + 1 : rand.nextInt(51) + 50;
                   board[i][j] = new Room(true, goldAmt, false, false);
               } else if(chance < 0.35){ //   C - NPC
                   board[i][j] = new Room(true,0,false,false);
                   NPC npc = new NPC("Merchant", true, false, 50, 50, "None", "None", "", "", 0.0f, 10, 10, 10, 1, null, new Inventory("Shop", 10), "Merchant", null, new ArrayList<>(), 100, new ArrayList<>());
                   board[i][j].setOccupant(npc);
               } else if(chance < 0.40){ //E Treasure map
                   board[i][j] = new Room(true, 0, true, false);
               }else if(chance < 0.5){ //G combat zone
                   board[i][j] = new Room(true, 0, false, true);
               } else if(chance < 0.6){ //10% πιθανότητα για εχθρό (B)
                   board[i][j] = new Room(true, 0, false, false);
                   Monster skeleton = new Monster("Skeleton", false, false, 40,0,"Bone Toss","Scratch", "", "", 1.0f, 5, 2, 8, 1, null, new Inventory("Loot", 2), "Undead", null, new ArrayList<>(), 20, "Skeleton", "Common");
                   board[i][j].setOccupant(skeleton);
               }else {
                   board[i][j] = new Room(true, 0, false, false);
               }

            }
        }
        board[0][2].setWalkable(true); // Εξασφαλίζουμε ότι η αρχική θέση του παίκτη (0,2) είναι πάντα walkable!
        board[0][2].setOccupant(null);
        return true;
    }

    public void movePlayer(String direction) throws InvalidMoveException {
        int curX = player.getPositionX();
        int curY = player.getPositionY();

        int nextX = curX;
        int nextY = curY;

        switch (direction.toLowerCase()) {
            case "u": nextY--; break;
            case "d": nextY++; break;
            case "l": nextX--; break;
            case "r": nextX++; break;
            default:
                throw new InvalidMoveException("Invalid command! Use one of the above (u,d,l,r)!");
        }

        // Έλεγχος ορίων: X (στήλες) 0-7, Y (γραμμές) 0-11
        if (nextX < 0 || nextX >= 8 || nextY < 0 || nextY >= 12) {
            throw new InvalidMoveException("You hit the edge of the world!");

        }

        // ΠΡΟΣΟΧΗ: board[Y][X] -> [γραμμή][στήλη]
        if (!board[nextY][nextX].isWalkable()) {
            throw new InvalidMoveException("There is wall or water there!");

        }

        player.setPositionX(nextX);
        player.setPositionY(nextY);
        System.out.println("Moved to Column: " + nextX + " , Row: " + nextY);
        // Καθαρισμός κονσόλας (Bonus)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        checkRoomEvents(nextX, nextY);
    }

    private void checkRoomEvents(int x, int y) {
        Room currentRoom = board[y][x]; // Χρήση y, x
        if (currentRoom.getGoldAmount() > 0) {
            int foundGold = currentRoom.getGoldAmount();
            player.setGold(player.getGold() + foundGold);
            currentRoom.setGoldAmount(0);
            System.out.println("Found " + foundGold + " gold coins!");
        }

        if(currentRoom.isCombatZone()){
            if(Math.random() < 0.5){ //50% πιθανότητα
                System.out.println("ENEMY SPOTTED! Battle started!");
                player.setHp(player.getHp() - 10);
                if(player.getHp() <=0){
                    System.out.println("Player " + player.getName() + " died!!! Game over!");
                    System.exit(0); //τερματισμος
                }
                //startBattle();
            } else {
                System.out.println(" It's quiet... Combat zone but no enemy!");
            }
        }

        if(currentRoom.getOccupant() instanceof NPC){
            NPC npc = (NPC) currentRoom.getOccupant();
            npc.interact(player);
        }

        if(currentRoom.getOccupant() instanceof Monster){
            Monster m = (Monster) currentRoom.getOccupant();
            System.out.println("You ran into a " + m.getName() + " ! ");
            player.setHp(player.getHp() - 25);
            if(player.getHp() <= 0){
                System.out.println(" you were defeated!" + player.getName() + "Game over!!!");
                System.exit(0);
            }
            currentRoom.setOccupant(null);
            System.out.println("After the battle your remaining life is " + player.getHp());
        }

        if(currentRoom.isHasTreasureMap()){
            int treasureX = (int) (Math.random() * 8);
            int treasureY = (int) (Math.random() * 12);

            board[treasureY][treasureX].setGoldAmount(500); //θησαυρός 500 $
            currentRoom.setHasTreasureMap(false); //οτι χρησιμοποιηθηε αυτος ο χαρτης για το θησαυρο αρα ειναι false πλεον
            System.out.println("You found a treasure map! It marke a spot at [" + treasureY + " , " + treasureX + "]");
        }
    }

    public boolean generateCharacters() {
        return false;
    }

    public boolean startGame() throws InvalidMoveException{
        PassiveTree startingTree = new PassiveTree(1);
        Inventory starterPack = new Inventory("Backpack", 20);
        Weapon rustySword = new Weapon(2, 10, 500, 5, 0, "Fire Damage", 1, "Sword", 1, 100);
        ArrayList<Equipment> armorSlots = new ArrayList<>();
        generateRooms();
        Player player1 = new Player(
                "Aris",           // name
                true,             // friendly
                true,             // playable
                100,              // hp
                20,               // mp
                "Slash",          // attackType1
                "Quick Shot",     // attackType2
                "Fast Learner",   // passiveSkills
                "Heal",           // activeSkills
                1.1f,             // movementSpeed
                8,                // dex
                5,                // intel
                12,               // str
                1,                // lvl
                startingTree,     // passiveTree <--- ΤΟ ΑΝΤΙΚΕΙΜΕΝΟ ΠΟΥ ΦΤΙΑΞΑΜΕ
                starterPack,      // inventory
                "Warrior",        // class1
                rustySword,       // weapon
                armorSlots,       // equipment
                50,               // gold
                0,                // positionY
                2                 // positionX
        );
        this.player = player1;



        while (true){
            dislayMap();
            System.out.println("\n--- Current Status ---");
            System.out.println("Position: [" + player.getPositionX() + "," + player.getPositionY() + "]");
            System.out.println("HP: " + player.getHp());
            System.out.println("Gold: " + player.getGold());
            System.out.print("Move (u,d,l,r) or 'exit': ");

            String input = sc.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game Over. Final Gold: " + player.getGold());
                saveProgress();
                break;
            }
            try {
                movePlayer(input);
            } catch (InvalidMoveException e){
                System.out.println(" !!! " + e.getMessage());
            }

        }
        return true;
    }

    public void dislayMap(){
        for(int i = 0; i <12; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == null){
                    System.out.println("[?]");
                    continue;
                }
                if(player.getPositionX() == j && player.getPositionY() == i){
                    System.out.print("[P]");
                } else if(!board[i][j].isWalkable()){
                    System.out.print("[~]"); //σημαινει νερο/ τοιχος αρα δεν μπορει να παει προς τα εκει ο παικτης
                } else if(board[i][j].getOccupant() instanceof NPC){
                    System.out.print("[C]"); // C για npc/merchant
                } else if(board[i][j].getOccupant() instanceof Monster){
                    System.out.print("[M]");
                } else if(board[i][j].getGoldAmount() > 0){
                    System.out.print("[$]");
                } else if(board[i][j].isHasTreasureMap()){
                    System.out.print("[E]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }


    public void saveProgress(){
        try (FileWriter writer = new FileWriter("savegame.txt")){
            writer.write("Player name " + player.getName() + "\n");
            writer.write("Level " + player.getLvl() + " \n");
            writer.write("Gold" + player.getGold() + "\n");
            System.out.println("Progress save to savegame.txt!");
        }catch (IOException e){
            System.out.println("Error saving file " + e.getMessage());
        }
    }


}
