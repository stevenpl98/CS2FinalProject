package finalProject;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application 
{

	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{	
			Parent root = FXMLLoader.load(getClass().getResource("MyGUI.fxml"));
			Scene scene = new Scene(root);
			primaryStage.getIcons().add(new Image("http://2.bp.blogspot.com/-Ol8pLJcc9oo/TnZY6R8YJ5I/AAAAAAAACSI/YDxcIHCZhy4/s150/duke_44x80.png"));
			primaryStage.setTitle("Googlr");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		launch(args);
	}
}
