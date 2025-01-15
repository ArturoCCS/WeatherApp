package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));

        Pagination pagination = new Pagination();
        pagination.setPageCount(20);
        pagination.setPageFactory((pageIndex)->{
        	Parent page = createPage(pageIndex,primaryStage);
        	return page;
        });
        
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();

        double windowWidth = screenWidth * 0.8;
        double windowHeight = screenHeight * 0.8;

        Scene scene = new Scene(root, windowWidth, windowHeight);

        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(scene);

        primaryStage.setX((screenWidth - windowWidth) / 2);
        primaryStage.setY((screenHeight - windowHeight) / 2);

        primaryStage.show();
    }

    private Parent createPage(Integer pageIndex, Stage primaryStage) {
		
    	
		return null;
	}

	public static void main(String[] args) {
        launch(args);
    }
}
