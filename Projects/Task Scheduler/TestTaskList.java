import java.util.Scanner;

/**
 * It creates a class called TestTaskList which has two data fields: TaskList<E> toDoList, Scanner scan.
 * @param <E>
 */
public class TestTaskList<E> {
    private TaskList<E> toDoList = new TaskList<>();
    private Scanner scan = new Scanner(System.in);


    /**
     * It creates a TestTaskList object and calls the printMenu method from it.
     * @param args
     */
    public static void main(String[] args) {
        TestTaskList <String> t = new TestTaskList<>();
        t.printMenu();
    }

    /**
     * It prints 8 menu items and receives a number from the user which indicates the operation user chooses.
     * Scanner object is used to read text input from the user or from a file.
     * The input received from user is stored in the choice variable
     */
    public void printMenu() {
        int choice = 0;
        boolean Cond = true;
        System.out.println("~~~ TO-DO List Program, created by truly yours ~~~");
        while (Cond) {

            if(toDoList.getActive().getSize() == 0 ){
                System.out.println("==> Currently there are NO items in the To-Do List");
            }
            else{
                System.out.println("Current TO-DO List:");
                System.out.println("-------------------");
                toDoList.showActiveTask();
            }

            System.out.println("To add a new task without priority information, press 1.");
            System.out.println("To add a new task with a priority information, press 2");
            System.out.println("To cross off the task at the top of the list, press 3.");
            System.out.println("To cross off a certain task in the list, press 4.");
            System.out.println("To see the top 3 highest priority tasks, press 5.");
            System.out.println("To see the completed tasks, press 6.");
            System.out.println("To see the all tasks that has been completed or still active, press 7.");
            System.out.println("To quit the program, press 8.");
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (IllegalArgumentException e) {
                choice = 0;
            }
            Cond = processMenuItem(choice);
        }
    }

    /**
     * Helper method that takes one input :
     * 1. operation that user chose (menuItem)
     * It calls the appropriate functions for each operation from the toDoList object.
     * @param menuItem
     */
    private boolean processMenuItem(int menuItem) {


        if (menuItem == 1) {
            System.out.println("Please enter the task description: ");
            String task = scan.nextLine();
            toDoList.createTask((E)task);
            System.out.println("Successfully entered the task to the to-do list!");
            return true;

        } else if (menuItem == 2) {
            System.out.println("Please enter the task description:");
            String task = scan.nextLine();
            // nextLine() is a methods that Scanner object provides for reading an entire line of text.
            System.out.println("Please enter a priority number (1 indicates highest priority, increasing numbers show lower priority) :");
            String prior = scan.nextLine();
            toDoList.createTask((E)task, Integer.parseInt(prior));
            System.out.println("Successfully entered the task to the to-do list!");
            return true;

        } else if (menuItem == 3) {
            ListQueue.Node<E> cur = toDoList.getActive().getFront();
            System.out.println("Task is completed and removed from the list: " + cur.getData());
            toDoList.crossOffMostUrgent();
            System.out.println("Successfully removed the most urgent task/top of the list task!");
            return true;

        } else if (menuItem == 4) {
            System.out.println("Please enter the task number you would like to cross off the list : ");
            String removeTask = scan.nextLine();
            if (Integer.parseInt(removeTask) > toDoList.getActive().getSize()){
                System.out.println("Unsuccessful operation! Please try again!");
            }
            else {
                ListQueue.Node<E> cur = toDoList.getActive().getFront();
                for(int i =1; i < Integer.parseInt(removeTask);i++){
                    cur = cur.getNext();
                }
                System.out.println("Task number " + removeTask + " is removed: " + cur.getData());
                System.out.println("Successfully removed the task number: " + removeTask);
                toDoList.crossOffTask(Integer.parseInt(removeTask));
            }
            return true;

        } else if (menuItem == 5) {
            System.out.println("Top 3 highest priority tasks:");
            System.out.println("------------------------------");
            System.out.println("Printing Top Three Tasks...");
            toDoList.printTopThreeTask();
            return true;

        } else if (menuItem == 6) {
            System.out.println("Completed Tasks:");
            System.out.println("-------------------");
            toDoList.showCompletedTask();
            return true;

        } else if (menuItem == 7) {
            System.out.println("All of the Tasks - Both completed and active:");
            toDoList.showAllTask();
            return true;

        } else if (menuItem == 8) {
            return false;

        } else {
            System.out.println("ERROR! Please enter a number between 1 and 8 (included).");
            return true;
        }
    }
}
