package org.example;

import java.util.Scanner;

public class Port {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int weightThreshold = 0;
        int weightOfPackages = 0;
        int stillCanBeLoaded = 0;
        String answer = "";
        int extraPackage = 0;
        int extraPackageCannotBeLoaded = 0;
        double cost = 0.0;
        int totalPackagesMoreThanThousand = 0;
        do{
            if(weightThreshold< weightOfPackages){
                System.out.println("Your packages are weighing more than weight threshold. Please remove some of them for proceed with the loading");
            }
            System.out.println("Please tell me the weight threshold: ");
            weightThreshold = sc.nextInt();
            System.out.println("\n");
            System.out.println("Please tell me the weight of the current packages: ");
            weightOfPackages = sc.nextInt();
            if(weightOfPackages > 1000){
                totalPackagesMoreThanThousand++;
            }
            System.out.println("\n");
        } while(weightThreshold < weightOfPackages);
        do{
            if(weightThreshold > weightOfPackages){
                stillCanBeLoaded = weightThreshold - weightOfPackages;
                System.out.println("There is more free space " + stillCanBeLoaded + ". Would you like to load the package (Yes/No) ?");
                answer = sc.next();

                if(answer.equals("Yes")){
                    System.out.println("Deal. How much more space would you need? ");
                    extraPackage = sc.nextInt();
                    if(extraPackage < stillCanBeLoaded){
                        System.out.println("Extra load is fine and can be loaded with the weight of: " + extraPackage);
                        weightOfPackages+=extraPackage;
                        //weightOfPackages = stillCanBeLoaded;
                        System.out.println("Current load is: " + weightOfPackages);
                    }
                    else {
                        System.out.println("Extra load is not fine and cannot be loaded due to exceed of our current threshold");
                        extraPackageCannotBeLoaded+=extraPackage;
                        System.out.println(extraPackageCannotBeLoaded);

                    }
                    System.out.println("Are we continue with the loading process (Yes/No)");
                    answer = sc.next();
                }
                if(extraPackage > 1000){
                    totalPackagesMoreThanThousand++;
                }
            }
        } while (answer.equals("Yes"));
        //ΑΕΠΠ - να το δούμε και μαζί - κλιμακωτά εννούμε αυτό? --> https://www.bing.com/videos/search?q=%ce%ba%ce%bb%ce%b9%ce%bc%ce%b1%ce%ba%cf%89%cf%84%ce%b7+%cf%87%cf%81%ce%b5%cf%89%cf%83%ce%b7&view=detail&mid=B69A58178EA0FCB75BDCB69A58178EA0FCB75BDC&FORM=VIRE
        if(weightOfPackages <=500){
            cost = (weightOfPackages) * 0.5;
        } else if(weightOfPackages <=1500){
            cost = 500 * 0.5 + ((weightOfPackages) - 500) * 0.3;

        } else {
            cost = 500 * 0.5 + 1000 * 0.3 + ((weightOfPackages) - 1500)*0.1;
        }
        System.out.println("Extra packages that could not be loaded: " + extraPackageCannotBeLoaded);
        System.out.println("\n");
        System.out.println("The cost is: " + cost);
        System.out.println("\n");
        System.out.println("Packages that was loaded more than 1000 kg: " + totalPackagesMoreThanThousand);
    }
}
