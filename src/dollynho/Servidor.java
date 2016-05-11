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
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("Dollynho Airlines Server");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        server = new ServImpl();
        int port = 6789;
        //Cria o servidor de nomes
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(port);
        referenciaServicoNomes.bind("Dollynho", server);
        System.out.println("Iniciado server RMI");
        launch(args); //inicializa interface gráfica JavaFX
    }
}
