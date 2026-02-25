package org.example;

import java.util.*;

public class Candidate {

    private int candidateId;
    private String fullName;
    private String programmingLang;

    private List<Problem> userProblems;

    public Candidate(int candidateId, String fullName, String programmingLang) {
        this.candidateId = candidateId;
        this.fullName = fullName;
        this.programmingLang = programmingLang;
        userProblems = new ArrayList<>();
    }

    public Candidate() {
        userProblems = new ArrayList<>();
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProgrammingLang() {
        return programmingLang;
    }

    public void setProgrammingLang(String programmingLang) {
        this.programmingLang = programmingLang;
    }


    public List<Problem> getUserProblems() {
        return userProblems;
    }

    public void setUserProblems(List<Problem> userProblems) {
        this.userProblems = userProblems;
    }

    public int totalScore() {
        int sum = 0;
        for (Problem p : userProblems) {
            sum += p.getGrade();
        }
        return sum;
    }

    public void printCandidateDetails() {
        System.out.println("[" + candidateId + "]\t" + fullName + " | programming Language: " + programmingLang);
        for (int i = 0; i < userProblems.size(); i++) {
            System.out.println(userProblems.get(i).getDescription() + ", and grade: " + userProblems.get(i).getGrade());
        }
        System.out.println("Total score: " + totalScore());
    }

    public void typeManually() {
        Scanner sc = new Scanner(System.in);
        List<Candidate> allCandidates = new ArrayList<>();
        String[] languages = {"Python", "C++", "Java", "C#", "Javascript", "C"};
        int langIndex = 0;
        String message = "";
        String[] categories = {"Algorithms and Complexity", "Mathematical Programming", "Telecommunications Programming", "Networks", "Artificial Intelligence", "Machine Learning"};
        List<Problem> userProbs = new ArrayList<>();
        for(String cat : categories){
            userProbs.add(new Problem(cat));
        }
        System.out.println("Manually inserion of candidates");
        int numberCandidates = 0;
        while (numberCandidates <= 0) {
            System.out.println("Ποσους θέλετε να καταχωρήσετε");
            try {
                numberCandidates = Integer.parseInt(sc.nextLine());
                if (numberCandidates <= 0) {
                    System.out.println("Number should be positive! try again...");
                }

            } catch (NumberFormatException e) {
                System.out.println("εισαγετε αριθμό");
                numberCandidates = 0;
            }
        }
        do {
            for (int i = 0; i < numberCandidates; i++) {
                List<Problem> candidateProblems = new ArrayList<>();
//                for(int j = 0;j < 6; j++){
//                    Problem temp = new Problem();
//                    temp.updateGrade(sc.nextInt());
//                    userProbs.add(temp);
//                }
                System.out.println("Εισήγαγε υποψήφιο " + (i + 1) + "," + numberCandidates);
                int candidateId = 0;
                while (candidateId <= 0) {
                    System.out.println("Candidate Id: ");
                    try {
                        candidateId = Integer.parseInt(sc.nextLine());
                        if (candidateId <= 0) {
                            System.out.println("id should be positive! try again...");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("εισαγετε ακεραιο αριθμό");
                        candidateId = 0;
                    }
                }
                System.out.println("Εισάγετε ονομα/επώνυμο");
                String name = sc.nextLine();
                System.out.println("Εισαγωγή βαθμών (0-100) για τα 6 προβλήματα");
               for(int j = 0; j < 6; j++){
                   System.out.println("Βαθμός προβλήματος: " + categories[i] + ": ");
                System.out.print("Βαθμός για πρόβλημα " + (j + 1) + ": ");
                // Χρησιμοποιούμε nextLine() και Integer.parseInt() για να αποφύγουμε
                // προβλήματα με τον Scanner (nextInt/nextLine mix).
                int grade = Integer.parseInt(sc.nextLine());

                Problem problem = new Problem(categories[j]);
                problem.updateGrade(grade);

                // Προσθέτουμε στη λίστα του ΤΡΕΧΟΝΤΟΣ υποψηφίου
                candidateProblems.add(problem);
            }
                System.out.println("Εισηγαγε γλωωσα προγραμματισμου: ");
                String lang = sc.nextLine();
                Candidate temp = new Candidate(candidateId, name, lang);
                temp.setUserProblems(candidateProblems);
                allCandidates.add(temp);
                temp.printCandidateDetails();
                if (langIndex >= 5) {
                    langIndex = 0;
                }
                langIndex++;
            }
            System.out.println("---------------------------------------------------------------------------------------");
            for (Candidate cd : allCandidates) {
                cd.printCandidateDetails();
                cd.totalScore();
                System.out.println("\n");
            }
            System.out.println("Υπάρχει νέα λύση προβλήματος; ΝΑΙ / ΟΧΙ");
            message = sc.nextLine();
        } while (!(message.toUpperCase().equals("ΟΧΙ")));

        System.out.println("\n");
        HashMap<String, Integer> map = new HashMap<>();
        for (Candidate cd : allCandidates) {
            map.put(cd.getFullName(), cd.totalScore());
        }
        List<Map.Entry<String, Integer>> nameGradesList = new ArrayList<>(map.entrySet()); //https://javabeat.net/sort-map-value-java/  --> example 2
        nameGradesList.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder()).thenComparing(Map.Entry<String, Integer>::getKey)); // https://medium.com/@AlexanderObregon/javas-comparator-thencomparing-method-explained-988e8f926a64--- > Basic Usage of thenComparing()
        System.out.println("Sorted by total score grades of the candidates and names: " + nameGradesList);

        System.out.println("\n"); //
        System.out.println("Ονόματα ανά κατηγορία προβλήματος ταξινομημένων σύμφωνα με βαθμολογία σε φθίνουσα σειρά:");
        for(int i = 0; i < userProbs.size();i++) {
            final int currentIndex = i;
            Problem currentProblem = userProbs.get(i);
            List<Candidate> tempAllCandidates = new ArrayList<>(allCandidates);
            System.out.println("Ανα πρόβλημα αποτέλεσμα: " + currentProblem.getDescription());
            tempAllCandidates.sort((c1, c2) -> {  //https://www.youtube.com/watch?v=fFeEhnXlj-c --> Lambda Comparator example for Sorting List of Custom Objects
                int grade1 = c1.getUserProblems().get(currentIndex).getGrade();
                int grade2 = c2.getUserProblems().get(currentIndex).getGrade();
                int gradeComparison = Integer.compare(grade2, grade1);
                //return Integer.compare(c2.getGrades().get(currentIndex), c1.getGrades().get(currentIndex));
                if (gradeComparison != 0) {
                    return gradeComparison;
                } else {
                    return c1.getFullName().compareTo(c2.getFullName());
                }
            });

            for (Candidate cd : tempAllCandidates) {
                int score = cd.getUserProblems().get(currentIndex).getGrade();
                System.out.print(" >>>> " + cd.getFullName() + " > his/her grades " + score + " >");
            }
        }

    }


}
