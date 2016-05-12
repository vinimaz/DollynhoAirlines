package dollynho;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

public class Servidor extends Application {
    static ServImpl server;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
        Parent dollRoot = loader.load();
        Controller controller = loader.getController();

//        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("Dollynho Airlines Server");
        primaryStage.setScene(new Scene(dollRoot));



        server = new ServImpl(controller);
        int port = 6789;
        //Cria o servidor de nomes
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(port);
        referenciaServicoNomes.bind("Dollynho", server);

        primaryStage.show();
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        System.out.println("Iniciado server RMI");
        launch(args); //inicializa interface gráfica JavaFX
    }
}
