package TaskTracker;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) {

        User[] userArray = new User[5];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to task manager");
            System.out.println("Enter your username");
            boolean isExistingUser = false;
            int currentUserPosition = 0;

            String username = sc.nextLine();
            for (int count = 0; count < userArray.length; count++) {

                if (userArray[count] == null) {
                    continue;
                }

                User user = userArray[count];
                String name = user.getUserName();

                if (name.equals(username)) {
                    isExistingUser = true;
                    currentUserPosition = count;
                    break;

                }
            }

            User currentUser;
            if (isExistingUser == false) {
                currentUser = new User(username);
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;

                    }
                    userArray[count] = currentUser;
                    break;

                }

            } else {
                currentUser = userArray[currentUserPosition];
            }

            Integer choice = 0;
            while (choice != 3) {
                System.out.print("Welcome");
                System.out.println(currentUser.getUserName());
                System.out.println("1. Add Task");
                System.out.println("2.List all the item");
                System.out.println("3.Exit");
                System.out.println("Enter your choice");
                choice = new Integer(sc.nextLine());

                if (choice == 1) {
                    System.out.println("Enter your task Description");
                    String taskDescription = sc.nextLine();
                    Task userTask = new Task(taskDescription);
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] == null) {
                            currentUser.getTaskArray()[count] = userTask;
                            break;
                        }
                    }
                    currentUser.getTaskArray()[0] = userTask;
                    System.out.println("Task added successfully");
                } else if (choice == 3) {
                    System.out.println("Thanks for Using us!");
                } else if (choice == 2) {
                    boolean isThereAnyTask=false;
                    for(int count=0;count<currentUser.getTaskArray().length;count++) {
                        if(currentUser.getTaskArray()[count] !=null){
                        String taskDescription = currentUser.getTaskArray()[count].getTaskDescription();
                        System.out.println(taskDescription);
                        isThereAnyTask = true;
                    }

                        }
                    if(isThereAnyTask==false){
                        System.out.println("There is no task at this moment,please create a task");

                    }

                }


            }
        }
    }
}


