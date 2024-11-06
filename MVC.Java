**Java Code for MVC Example**
-------------------------------
**Task Management System**

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Model class for task representation
class Task {
 private int id;
 private String title;
 private String description;
 private boolean isCompleted;
 public Task(int id, String title, String description) {
 this.id = id;
 this.title = title;
 this.description = description;
 this.isCompleted = false;
 }
 // Getters and Setters
 public int getId() {
 return id;
 }
 public String getTitle() {
 return title;
 }
 public String getDescription() {
 return description;
 }
 public boolean isCompleted() {
 return isCompleted;
 }
 public void setTitle(String title) {
 this.title = title;
 }
 public void setDescription(String description) {
 this.description = description;
 }
 public void setCompleted(boolean isCompleted) {
 this.isCompleted = isCompleted;
 }
 @Override
 public String toString() {
 return "ID: " + id + ", Title: " + title + ", Description: " + description
+ ", Completed: " + isCompleted;
 }
}

//View class used to display task info
class TaskView {
 public void displayTasks(List<Task> tasks) {
 if (tasks.isEmpty()) {
 System.out.println("No tasks to display.");
 } else {
 for (Task task : tasks) {
 System.out.println(task);
 }
 }
 }
 public void displayMessage(String message) {
 System.out.println(message);
 }
}
//Controller class to manage interactions
class TaskController {
 private List<Task> tasks = new ArrayList<>();
 private TaskView view;
 private int taskIdCounter = 1;
 public TaskController(TaskView view) {
 this.view = view;
 }
 public void addTask(String title, String description) {
 Task task = new Task(taskIdCounter++, title, description);
 tasks.add(task);
 view.displayMessage("Task has been added.");
 }
 public void displayAllTasks() {
 view.displayTasks(tasks);
 }
 public void markTaskAsCompleted(int id) {
 for (Task task : tasks) {
 if (task.getId() == id) {
 task.setCompleted(true);
 view.displayMessage("Task is completed.");
 return;
 }
 }
 view.displayMessage("Task with ID " + id + " not found.");
 }
}

//Controller class to manage interactions
class TaskController {
 private List<Task> tasks = new ArrayList<>();
 private TaskView view;
 private int taskIdCounter = 1;
 public TaskController(TaskView view) {
 this.view = view;
 }
 public void addTask(String title, String description) {
 Task task = new Task(taskIdCounter++, title, description);
 tasks.add(task);
 view.displayMessage("Task has been added.");
 }
 public void displayAllTasks() {
 view.displayTasks(tasks);
 }
 public void markTaskAsCompleted(int id) {
 for (Task task : tasks) {
 if (task.getId() == id) {
 task.setCompleted(true);
 view.displayMessage("Task is completed.");
 return;
 }
 }
 view.displayMessage("Task with ID " + id + " not found.");
 }
}


// Main class where controller and view are called
public class Main {
 public static void main(String[] args) {
 TaskView view = new TaskView();
 TaskController controller = new TaskController(view);
 Scanner scanner = new Scanner(System.in);
 System.out.println("Task Management Application\n");
 System.out.println("Choose one of the following options:");
 while (true) {
 System.out.println("\n1. Add a Task");
 System.out.println("2. View All Tasks");
 System.out.println("3. Mark your Task as Completed");
 System.out.println("4. Exit System\n");
 System.out.print("Enter option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 if (choice == 1) {
 System.out.print("Enter Title: ");
 String title = scanner.nextLine();
 System.out.print("Enter Description: ");
 String description = scanner.nextLine();
 controller.addTask(title, description);
 } else if (choice == 2) {
 controller.displayAllTasks();
 } else if (choice == 3) {
 System.out.print("Enter task ID to mark as completed: ");
 int id = scanner.nextInt();
 controller.markTaskAsCompleted(id);
 } else if (choice == 4) {
 System.out.println("..Exiting the system..");
 break;
 } else {
 System.out.println("Invalid Option Selection!.");
 }
 }
 scanner.close();
 }
}
