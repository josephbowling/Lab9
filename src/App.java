import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private final int WIDTH = 600, HEIGHT = 200;
	private DistanceConverter distance;
	
	public void start(Stage stage) {
		distance = new DistanceConverter();
		VBox root = new VBox(distance);
		
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
