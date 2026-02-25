package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //2o βήμα
        Samurai samurai1 = new Samurai("Akechi Mitsuhide", WeaponType.katana, true, false, true, Type.military, 20.0, 100.0);
        //3o βήμα
        Samurai samurai2 = new Samurai("Date Masamune", WeaponType.yumi, false, true, false, Type.military, 10.0, 55.0);
        //4ο βήμα
        Samurai samurai3 = new Samurai("Hattori Hanzō", WeaponType.naginata, false, false, true, Type.military, 20.0, 100.0);

        //2η Ronin ομάδα Samurai
        //5ο βήμα
        Samurai oda = new Samurai("Oda Nobunaga", WeaponType.wakizashi, true, true, true, Type.ronin, 20.0, 100.0);
        //6ο βήμα
        Samurai takeda = new Samurai("Takeda Nobunaga", WeaponType.katana, false, true, true, Type.ronin, 20.0, 100.0);

        List<Samurai> roninList = new ArrayList<>();
        roninList.add(oda);

        roninList.add(takeda);
        List<Samurai> militaryList = new ArrayList<>();
        militaryList.add(samurai1);
        militaryList.add(samurai2);
        militaryList.add(samurai3);
        do {
            System.out.println("=======>>>>>>> ΓΥΡΟΙ ΜΟΝΟΜΑΧΙΩΝ SAMURAI <<<<<<========");
            //7ο βήμα
            double attackPowTakeda = 0.0;
            if (takeda.getLife() > 0) {
                attackPowTakeda = takeda.attack() + takeda.getWeaponPower();
            }
            System.out.println("Samurai " + takeda.getName() + " attacks");
            //takeda.attack();
            samurai1.reveiveDamage(attackPowTakeda);
            samurai2.reveiveDamage(attackPowTakeda); //μπαίνει η επίθεση του Akechi (επιθεση και δυναμη του οπλου)
            Thread.sleep(1000);
            samurai1.print();
            Thread.sleep(1000);
            samurai2.print();
            Thread.sleep(1000);
            takeda.print();
            //8ο βήμα
            double attackPowOda = 0.0;
            if (oda.getLife() > 0) {
                attackPowOda = oda.attack() + oda.getWeaponPower();
            }
            samurai3.reveiveDamage(attackPowOda);
            //9ο βήμα
            double attackPowHatori = 0.0;
            if (samurai3.getLife() > 0) {
                attackPowHatori = samurai3.attack() + samurai3.getWeaponPower();
            }
            oda.reveiveDamage(attackPowHatori);
            Thread.sleep(1000);
            samurai3.print();
            Thread.sleep(1000);
            oda.print();
            //10ο βήμα
            double attackPowDate = 0.0;
            if (samurai2.getLife() > 0) {
                attackPowDate = samurai2.attack() + samurai2.getWeaponPower();
            }
            takeda.reveiveDamage(attackPowDate);
            Thread.sleep(1000);
            samurai2.print();
            Thread.sleep(1000);
            takeda.print();
            //11ο βήμα
            double attackPowAkechi = 0.0;
            if (samurai1.getLife() > 0) {
                attackPowAkechi = samurai1.attack() + samurai1.getWeaponPower();
            }
            takeda.reveiveDamage(attackPowAkechi);
            Thread.sleep(1000);
            samurai1.print();
            Thread.sleep(1000);
            takeda.print();
            //12ο βήμα
            samurai1.reveiveDamage(attackPowTakeda);
            samurai1.reveiveDamage(attackPowTakeda);
            Thread.sleep(1000);
            samurai1.print();
            Thread.sleep(1000);
            takeda.print();
            //13ο βήμα
            samurai1.reveiveDamage(attackPowOda);
            Thread.sleep(1000);
            samurai1.print();
            //14ο βήμα
            oda.reveiveDamage(attackPowDate);
            takeda.reveiveDamage(attackPowHatori);
            Thread.sleep(1000);
            oda.print();
            Thread.sleep(1000);
            takeda.print();
            //15ο
            samurai2.reveiveDamage(attackPowOda);
            Thread.sleep(1000);
            samurai2.print();
            //16ο
            oda.reveiveDamage(attackPowHatori);
            takeda.reveiveDamage(attackPowHatori);
            Thread.sleep(1000);
            oda.print();
            Thread.sleep(1000);
            takeda.print();
            //17ο
            oda.reveiveDamage(attackPowHatori);
            Thread.sleep(1000);
            oda.print();

        } while ((roninList.get(0).getLife() > 0.0 || roninList.get(1).getLife() > 0.0) && (militaryList.get(0).getLife() > 0 || militaryList.get(1).getLife() > 0 || militaryList.get(2).getLife() > 0));

        //B)
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        List<SamuraiExtended> mil = new ArrayList<>();
        List<SamuraiExtended> ron = new ArrayList<>();
        String name = "";
        String weaponType = "";
        boolean doubleWeap = false;
        boolean hasHors = false;
        boolean hasArm = false;
        String samuraiType = "";
        double hit = 0.0;
        double life = 0.0;
        System.out.println("Please type your samurai details (Name, WeaponType [katana, yumi, wakizashi, naginata], doubleWeapon false or true, hasHorse false or true, hasArmor false or true, Type of samura [ military or ronin ], hitPower [10.0 - 20.0]. life [0.0 - 100.0]): ");
        WeaponType weaponType1 = null;
        Type samuraiType1 = null;
        boolean isValid = false;
        String wType = "";
        String sType = "";
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter Samurais: " + (i + 1) + " ---> hit enter to start typing ");
            if (i > 0) sc.nextLine();
            System.out.println("Give name: ");
            name = sc.nextLine();

            System.out.println("Please enter correct weapon from the list[yumi,katana,wakizashi, naginata]!");

            do {
                System.out.println("Give weaponType: ");
                wType = sc.nextLine();
            } while (!wType.equals("yumi") && !wType.equals("katana") && !wType.equals("wakizashi") && !wType.equals("naginata"));

            System.out.println("Please type if you have double weapons (true/false): ");
            String userInput = "";
            do {
                System.out.println("Please enter true or false as inputs: ");
                userInput = sc.nextLine();
            } while (!userInput.equals("true") && !userInput.equals("false"));

            String userInput2 = "";
            System.out.println("Please type if you have horse (true/false): ");
            do {
                System.out.println("Please enter true or false as inputs: ");
                userInput2 = sc.nextLine();
            } while (!userInput2.equals("true") && !userInput2.equals("false"));

            String userInput3 = "";
            System.out.println("Please type if you have armor (true/false): ");
            do {
                System.out.println("Please enter true or false as inputs: ");
                userInput3 = sc.nextLine();
            } while (!userInput3.equals("true") && !userInput3.equals("false"));

            System.out.println("Give samurai type (ronin or military): ");
            do {
                System.out.println("Give samurai Type: ");
                sType = sc.nextLine();
            } while (!sType.equals("ronin") && !sType.equals("military"));

            System.out.println("Randomly will be added hit power (10 - 20): ");
            hit = rand.nextDouble(10, 20);
            //hit = sc.nextDouble();
            System.out.println("Randomly will be added life (50.0 - 100.0): ");
            life = rand.nextDouble(50, 100);
            //sc.nextLine();

            WeaponType temp;
            if (wType.equals("yumi")) {
                temp = WeaponType.yumi;
            } else if (wType.equals("naginata")) {
                temp = WeaponType.naginata;
            } else if (wType.equals("wakizashi")) {
                temp = WeaponType.wakizashi;
            } else {
                temp = WeaponType.katana;
            }
            SamuraiExtended sam1 = new SamuraiExtended(name, temp, (userInput.equals("true") ? true : false), (userInput2.equals("true") ? true : false), (userInput3.equals("true") ? true : false), (sType.equals("military") ? Type.military : Type.ronin), hit, life);
            if (sType.equals("military")) {
                mil.add(sam1);
            } else {
                ron.add(sam1);
            }
        }
//        for(SamuraiExtended elem : mil){
//            System.out.println(elem.getName() + " " + elem.getHitpower() + " " + elem.getLife() + " " + elem.getHitpower() + " " + elem.getWeaponPower() + " " + elem.getWeaponType());
//        }

        do {
            SamuraiExtended military = mil.get(rand.nextInt(mil.size()));
            SamuraiExtended ronin = ron.get(rand.nextInt(ron.size()));
            double attackersHit = 0.0;
            String inputEnter = "";
            if (military.getLife() > 0) {
                if (inputEnter.equals(sc.nextLine())) {
                    System.out.println(Message.getCriticalHitMessages());
                    attackersHit = military.criticalHit();
                    ronin.agility(attackersHit);
                    System.out.println(Message.getAgilityMessages());
                }

            }
            if (military.getLife() == 0.0 || ronin.getLife() == 0.0) {
                mil.remove(military);
                ron.remove(ronin);
            }
            Thread.sleep(1000);
        } while (!mil.isEmpty() && !ron.isEmpty());

        if (mil.isEmpty()) {
            System.out.println("Military has died and RONIN WON!!!!");
        } else {
            System.out.println("Ronin has died and MILITARY WON!!!!");
        }
    }
}