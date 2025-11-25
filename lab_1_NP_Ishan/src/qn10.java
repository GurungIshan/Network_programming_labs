
// 10 . WAP to demonstrate SPAM checking. (Ishan Gurung, Roll No - 09)

import java.util.Scanner;

public class qn10 {
    private static final String[] SPAM_KEYWORDS = {
            "win", "prize", "free", "lottery", "money", "offer", "urgent"
    };
    public static boolean isSpam(String message) {
        String lowerCaseMessage = message.toLowerCase();
        for (String keyword : SPAM_KEYWORDS) {
            if (lowerCaseMessage.contains(keyword)) {
                return true; // spam detected
            }
        }
        return false; // not spam
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message to check for SPAM:");
        String message = scanner.nextLine();

        if (isSpam(message)) {
            System.out.println("This message is SPAM!");
        } else {
            System.out.println("This message is NOT spam.");
        }

        scanner.close();
    }
}
