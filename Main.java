package Practice.whatsapp;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WhatsAppService service = new WhatsAppService();

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Send Message");
            System.out.println("3. View Messages");
            System.out.println("4. Post Story");
            System.out.println("5. View Stories");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    if (service.registerUser(username, password)) {
                        System.out.println("✅ User registered successfully!");
                    } else {
                        System.out.println("❌ Registration failed.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Sender ID: ");
                    int senderId = scanner.nextInt();
                    System.out.print("Enter Receiver ID: ");
                    int receiverId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Message: ");
                    String message = scanner.nextLine();
                    if (service.sendMessage(senderId, receiverId, message)) {
                        System.out.println("✅ Message sent successfully!");
                    } else {
                        System.out.println("❌ Failed to send message.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Your User ID: ");
                    int userId = scanner.nextInt();
                    System.out.println(" Your Messages:");
                    service.viewMessages(userId);
                    break;

                case 4:
                    System.out.print("Enter Your User ID: ");
                    int storyUserId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Story: ");
                    String story = scanner.nextLine();
                    if (service.postStory(storyUserId, story)) {
                        System.out.println("✅ Story posted successfully!");
                    } else {
                        System.out.println("❌ Failed to post story.");
                    }
                    break;
                case 5:
                    System.out.println("📸 Recent Stories:");
                    service.viewStories();
                    break;

                case 6:
                    System.out.println("👋 Exiting WhatsApp...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}

