import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Top Navigation Bar
        HBox topNav = new HBox();
        topNav.setPadding(new Insets(10));
        topNav.setSpacing(20);
        topNav.setStyle("-fx-background-color: #e8e8e8;");

        Label appName = new Label("Tasky APP");
        appName.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button projectsButton = new Button("Projects");
        Button reportsButton = new Button("Reports");
        Button contactButton = new Button("Contact Us");

        Label userName = new Label("fira");
        userName.setStyle("-fx-font-size: 14px;");

        topNav.getChildren().addAll(appName, spacer, projectsButton, reportsButton, contactButton, userName);

        // Sidebar
        VBox sidebar = new VBox();
        sidebar.setPadding(new Insets(10));
        sidebar.setSpacing(15);
        sidebar.setStyle("-fx-background-color: #2d3e50;");
        sidebar.setPrefWidth(200);

        Label allTasksLabel = new Label("All Tasks");
        Label completedTasksLabel = new Label("Completed Tasks");
        Label incompleteTasksLabel = new Label("Incomplete Tasks");
        Button addTaskButton = new Button("+ Add Task");
        addTaskButton.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white;");

        allTasksLabel.setStyle("-fx-text-fill: white;");
        completedTasksLabel.setStyle("-fx-text-fill: white;");
        incompleteTasksLabel.setStyle("-fx-text-fill: white;");

        sidebar.getChildren().addAll(allTasksLabel, completedTasksLabel, incompleteTasksLabel, addTaskButton);

        // Task Cards Container
        GridPane taskCardsContainer = new GridPane();
        taskCardsContainer.setPadding(new Insets(20));
        taskCardsContainer.setHgap(20);
        taskCardsContainer.setVgap(20);

        // Sample Task Cards
        for (int i = 0; i < 6; i++) {
            VBox taskCard = createTaskCard("Task Name: Task " + (i + 1),
                    "Details: Task details go here.",
                    "Deadline: 2024-09-" + (10 + i),
                    "Priority: High",
                    "Dependencies: None");
            taskCardsContainer.add(taskCard, i % 3, i / 3);
        }

        // Main Content Area
        VBox mainContent = new VBox();
        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        dashboardLabel.setPadding(new Insets(10, 0, 20, 10));

        mainContent.getChildren().addAll(dashboardLabel, taskCardsContainer);

        // Layout
        BorderPane layout = new BorderPane();
        layout.setTop(topNav);
        layout.setLeft(sidebar);
        layout.setCenter(mainContent);

        // Scene
        Scene scene = new Scene(layout, 1200, 700);
        primaryStage.setTitle("Task Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createTaskCard(String taskName, String details, String deadline, String priority, String dependencies) {
        VBox card = new VBox();
        card.setPadding(new Insets(10));
        card.setSpacing(10);
        card.setStyle("-fx-border-color: #ccc; -fx-border-radius: 5px; -fx-background-color: #f9f9f9;");

        Label taskNameLabel = new Label(taskName);
        taskNameLabel.setStyle("-fx-font-weight: bold;");

        Label detailsLabel = new Label(details);
        Label deadlineLabel = new Label(deadline);
        Label priorityLabel = new Label(priority);
        Label dependenciesLabel = new Label(dependencies);

        CheckBox completeCheckBox = new CheckBox("Mark as Complete");

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER_LEFT);
        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: white;");
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;");

        buttons.getChildren().addAll(editButton, deleteButton);

        card.getChildren().addAll(taskNameLabel, detailsLabel, deadlineLabel, priorityLabel, dependenciesLabel, completeCheckBox, buttons);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
