package org.example;

public class Room {

    // 1. Είναι προσπελάσιμο; (Αν είναι F / Νερό, αυτό θα είναι false)
    private boolean isWalkable;

    // 2. Πόσο χρυσό έχει μέσα; (Για το D - Αν δεν έχει, θα είναι 0)
    private int goldAmount;

    // 3. Έχει χάρτη θησαυρού; (Για το E)
    private boolean hasTreasureMap;

    // 4. Είναι περιοχή που προκαλεί μάχη; (Για το G)
    private boolean isCombatZone;

    // 5. Ποιος στέκεται πάνω σε αυτό το κουτί αυτή τη στιγμή;
    // Μπορεί να είναι Player, Monster, ή NPS (Αν είναι άδειο, θα είναι null)
    private Character occupant;

    // Constructor
    public Room(boolean isWalkable, int goldAmount, boolean hasTreasureMap, boolean isCombatZone) {
        this.isWalkable = isWalkable;
        this.goldAmount = goldAmount;
        this.hasTreasureMap = hasTreasureMap;
        this.isCombatZone = isCombatZone;
        this.occupant = null; // Όταν φτιάχνεται το κουτί, συνήθως είναι άδειο από χαρακτήρες
    }

    public boolean isWalkable() {
        return isWalkable;
    }

    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public boolean isHasTreasureMap() {
        return hasTreasureMap;
    }

    public void setHasTreasureMap(boolean hasTreasureMap) {
        this.hasTreasureMap = hasTreasureMap;
    }

    public boolean isCombatZone() {
        return isCombatZone;
    }

    public void setCombatZone(boolean combatZone) {
        isCombatZone = combatZone;
    }

    public Character getOccupant() {
        return occupant;
    }

    public void setOccupant(Character occupant) {
        this.occupant = occupant;
    }

}
