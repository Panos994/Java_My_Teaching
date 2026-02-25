package org.example;

import java.util.Arrays;

public class Stack {
    private int[] arr;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int num) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            arr[top] = num;
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int poppedElement = arr[top];
            top--;
            return poppedElement;
        }
    }

    // Method to get the top element of the stack
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return arr[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) { // LIFO γιαυτό έχω και i > =0 ----> ουσιαστικά το top είναι το τελευταίο στοιχείο που προστέθηκε/ κορυφή στοιβας ! Ετσι, όταν βαζω το i >= 0 θα ληξει όταν ειναι μεγαλύτερο ή ισο με 0. Αυτο εξασφαλιζει οτι θα εκτυπωθει όλο το περιόχομενο της στοιβας μεχρι το 0 και μετα κανω i-- αφου η μέτρηση γινεται προς τα πίσω
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void sort(){
        if(top == -1){
            System.out.println("Stack is empty");
            return;
        }
        Stack tempStack = new Stack(arr.length);
        while(!isEmpty()){
            int temp = pop(); // το temp είναι το pop() στοιχειο του main Stack
            while(!tempStack.isEmpty() && tempStack.peek() > temp){ //οσο το tempStack δεν ειναι αδειο ΚΑΙ tempStack κορυφη του μεγαλύτερο απο το temp --> pop() στοιχειο του main Stack
                push(tempStack.pop());    //τότε θα γίνει push στην mainStack πάλι πίσω το στοιχείο του tempStack Που βγηκε λόγω επειδη πχ το 4 στοιχειο ειναι μεγαλυτερο απο το 1 στοιχειο αρα γυρναει πισω
            }
            tempStack.push(temp);  //Ειδάλλως αν πχ εχω το 2 και το στοιχειο στην tempStack ήταν το 1 τοτε κανονικα θα Pushάρω στην tempStack το στοιχείο του pop() της main Stack
        }
       while(!tempStack.isEmpty()){
           push(tempStack.pop());
       }
    }
    public static void main(String[] args) {
        System.out.println("Initialize a stack:");
        Stack stack = new Stack(5);
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("\nInput some elements on the stack:");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("\nTop element of the stack: " + stack.peek());
        System.out.println("\nRemove two element from the stack:");
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println("\nTop element of the stack after popping: " + stack.peek());
        System.out.println("\nIs the stack empty? " + stack.isEmpty());

        System.out.println("\nSort the elements of the stack in ascending order:");
        stack.sort();
        stack.display();
    }
}
