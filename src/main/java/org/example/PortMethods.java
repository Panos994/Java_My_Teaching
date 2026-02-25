package org.example;

import java.util.Scanner;

public class PortMethods {
    public static void print(String tempMsg){
        System.out.println(tempMsg);
    }
    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static String getAnswer(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    public static void costProcess(int x, double c){
        if(x <=500){
            c = (x) * 0.5;
        } else if(x <=1500){
            c = 500 * 0.5 + ((x) - 500) * 0.3;

        } else {
            c = 500 * 0.5 + 1000 * 0.3 + ((x) - 1500)*0.1;
        }
        System.out.println(c);
    }

    public static void main(String[] args){
        int weightThreshold = 0;
        int weightOfPackages = 0;
        int stillCanBeLoaded = 0;
        String answer = "";
        int extraPackage = 0;
        int extraPackageCannotBeLoaded = 0;
        double cost = 0.0;
        int totalPackagesMoreThanThousand = 0;
        do{
            if(weightOfPackages > weightThreshold){
                print("Your packages are weighing more than weight threshold. Please remove some of them for proceed with the loading");
            }
            print("Please tell me the weight threshold:");
            weightThreshold = getUserInput();
            System.out.println("\n");
            print("Please tell me the weight of the current packages: ");
            weightOfPackages = getUserInput();
            if(weightOfPackages > 1000){
                totalPackagesMoreThanThousand++;
            }
        } while(weightThreshold < weightOfPackages);
        do{
            if(weightThreshold > weightOfPackages){
                stillCanBeLoaded = weightThreshold - weightOfPackages;
                System.out.println("There is more free space " + stillCanBeLoaded + ". Would you like to load the package (Yes/No) ?");
                answer = getAnswer();

                if(answer.equals("Yes")){
                    System.out.println("Deal. How much more space would you need? ");
                    extraPackage = getUserInput();
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
                    answer = getAnswer();
                }
                if(extraPackage > 1000){
                    totalPackagesMoreThanThousand++;
                }
            }
        } while (answer.equals("Yes"));

        System.out.println("Extra packages that could not be loaded: " + extraPackageCannotBeLoaded);
        System.out.println("\n");
        System.out.println("The cost is: ");
        costProcess(weightOfPackages, cost);
        System.out.println("\n");
        System.out.println("Packages that was loaded more than 1000 kg: " + totalPackagesMoreThanThousand);
    }
}
