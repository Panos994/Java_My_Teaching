package org.example;


import java.util.*;

public class Main {
    public static void insertDetails() {
        Random rand = new Random();
        final int totalContentstants = 40;
        String[] fullNames = {"Tom Robins", "Alice Smith", "Bob Johnson", "Charlie Brown", "Diana Prince",
                "Ethan Hunt", "Fiona Glenanne", "George Kirk", "Hannah Baker", "Isaac Newton",
                "Jasmine Chen", "Kevin Flynn", "Laura Croft", "Mike Ross", "Nancy Drew",
                "Oliver Queen", "Penelope Garcia", "Quentin Lance", "Rachel Zane", "Steve Rogers",
                "Tina Belcher", "Ulysses Grant", "Victoria Chase", "Walter White", "Xena Warrior",
                "Yara Greyjoy", "Zack Morris", "Amy Pond", "Ben Wyatt", "Chloe Decker",
                "David Copper", "Elena Gilbert", "Finn Hudson", "Gina Linetti", "Hank Moody",
                "Iris West", "Jake Peralta", "Kelly Kapoor", "Leslie Knope", "Michael Scott"};
        String[] categories = {"Algorithms and Complexity", "Mathematical Programming", "Telecommunications Programming", "Networks", "Artificial Intelligence", "Machine Learning"};
        String[] languages = {"Python", "C++", "Java", "C#", "Javascript", "C"};
        List<Candidate> allCandidates = new ArrayList<>();
        for (int i = 0; i < totalContentstants; i++) {
            List<Problem> userProbs = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                Problem temp = new Problem(categories[j]);
                temp.updateGrade(rand.nextInt(100));
                userProbs.add(temp);
            }
            Candidate temp = new Candidate((i + 1), fullNames[i], languages[rand.nextInt(0, languages.length)]);
            temp.setUserProblems(userProbs);
            allCandidates.add(temp);
            temp.printCandidateDetails();
            System.out.println();
        }
        System.out.println("\n");
        HashMap<String, Integer> map = new HashMap<>();
        for (Candidate cd : allCandidates) {
            map.put(cd.getFullName(), cd.totalScore());
        }
        List<Map.Entry<String, Integer>> nameGradesList = new ArrayList<>(map.entrySet()); //https://javabeat.net/sort-map-value-java/  --> example 2
        nameGradesList.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder()).thenComparing(Map.Entry<String, Integer>::getKey)); // https://medium.com/@AlexanderObregon/javas-comparator-thencomparing-method-explained-988e8f926a64--- > Basic Usage of thenComparing()
        System.out.println("Sorted by total score grades of the candidates and names: " + nameGradesList);

        System.out.println("\n"); //Δεν το κατάφερα οπως θέλει το ζητούμενο -- γίνεται στο typeManually()
        HashMap<String, List<Integer>> mapNameGrades = new HashMap<>();
        List<Map.Entry<String, List<Integer>>> namesGradesPerProblem2 = new ArrayList<>(mapNameGrades.entrySet());
        namesGradesPerProblem2.sort(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        System.out.println("Sorted by grades of the candidates and names: " + namesGradesPerProblem2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String option = "";
        //boolean testIsOn = true;
        System.out.println("Would you like to use the program automatically for testing (if yes press option 1). if you wanna manually use it press option 2. [PRESS E FOR EXIT] : ");
        option = sc.next();
        if (option.equals("1")) {
            insertDetails();
        } else if (option.equals("2")) {
            //χειροκίνητα διάβασμα και καταχώρηση των υποψηφίων βαθμών κλπ κλπ.
            Candidate cd2 = new Candidate();
            cd2.typeManually();
        }
    }
}