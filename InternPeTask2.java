import java.util.*;

public class InternPeTask2 {

        static String[] options = {"rock", "paper", "scissor"};
        static int userScore = 0;
        static int compScore = 0;

    public static void showWinner(boolean userWin, String userChoice, String comChoice){
        if(userWin) {
            userScore++;
            System.out.println("You win! your " + userChoice + " beats computer's " + comChoice);
        }else{
            compScore++;
            System.out.println("You loss! computer's " + comChoice + " beats your " + userChoice);
        }
    }
    
    public static void playGame(String userChoice){
        String compChoice = genComChoice();
    
        if(userChoice.equals(compChoice)){
            drawGame();
        }else{
            boolean userWin;

            if(userChoice.equalsIgnoreCase("rock")){
                userWin = !compChoice.equals("paper");
            }else if(userChoice.equalsIgnoreCase("paper")){
                userWin = !compChoice.equalsIgnoreCase("scissor");
            }else{
                userWin = !compChoice.equalsIgnoreCase("rock");
            }
    
            showWinner(userWin, userChoice, compChoice);
        }
    }
    
    public static String genComChoice(){
        Random randNum = new Random();
        int randIdx = randNum.nextInt(3);
        return options[randIdx];
    }

    public static void drawGame() {
        System.out.println("Your game was draw. Play again to win");
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Let's play the Game");
            System.out.println("Enter rock, paper, or scissor (or 'exit' to quit game):");
            
            String userChoice = sc.next().toLowerCase();
            
            if(userChoice.equals("exit")){
                System.out.println("Final Score - you: " + userScore + ", Computer: " + compScore);
                break;
            }

            if(Arrays.asList(options).contains(userChoice)){
                playGame(userChoice);
            }else{
                System.out.println("Invalid choice. Please enter rock, paper, or scissor.");
            }
            
        }

        sc.close();

    }
}