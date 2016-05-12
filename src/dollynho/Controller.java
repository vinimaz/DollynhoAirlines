package dollynho;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;


public class Controller implements Initializable {
    public JFXPanel jfxPanelDummy;
    public int controlIndex;

    public Button startBt;
    public Pane introPane;
    public Pane serverPane;
    public Pane painelCadastroPassagem;
    public Pane painelCadastroHospedagem;
    public TabPane tabPaneGeral;
//    public TableView tabelaPassagens;

    //Table Passagem
    public ObservableList<Passagem>             passagemList;
    public TableView<Passagem>                  tabelaPassagens;
    public TableColumn<Passagem, String>        origemPasColumn;
    public TableColumn<Passagem, String>        destinoPasColumn;
    public TableColumn<Passagem, LocalDate>     dataIdaPasColumn;
    public TableColumn<Passagem, Number>        precoPasColumn;
    public TableColumn<Passagem, Number>        quantidadePasColumn;

    //TextField Passagem
    public TextField inputPasDataIda;
    public TextField inputPasOrigem;
    public TextField inputPasDestino;
    public TextField inputPasPreco;
    public TextField inputPasQuantidade;

    //Table Hospedagem
    public TableView<Hospedagem>                tabelaHospedagem;
    public ObservableList<Hospedagem>           hospedagemList;
    public TableColumn<Hospedagem, String>      cidadeHospColumn;
    public TableColumn<Hospedagem, String>      hotelHospColumn;
    public TableColumn<Hospedagem, Number>      precoHospColumn;
    public TableColumn<Hospedagem, Number>      quantidadeHospColumn;

    //TextField Hospedagem
    public TextField inputHospCidade;
    public TextField inputHospHotel;
    public TextField inputHospPreco;
    public TextField inputHospQuantidade;

    //Table Usuario
    public TableView<Usuario>                   tabelaUsuario;
    public static ObservableList<Usuario>              usuarioList;
    public TableColumn<Usuario, String>         usuarioName;
    public TableColumn<Usuario, String>         usuarioDescricao;
    public TableColumn<Usuario, Number>         usuarioPedidoId;
    public TableColumn<Usuario, Number>         usuarioPrecoAnterior;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jfxPanelDummy = new JFXPanel();

        controlIndex    = 100;
        passagemList    = FXCollections.observableArrayList();
        hospedagemList  = FXCollections.observableArrayList();
        LocalDate datain    = LocalDate.of(2016, 01, 01);
        passagemList.add(new Passagem("Curitiba", "Miami", datain, (float) 99.90, 1, 1));

        //Iniciando colunas da tabela de Passagens
        origemPasColumn.setCellValueFactory(cellData -> cellData.getValue().origemProperty());
        destinoPasColumn.setCellValueFactory(cellData -> cellData.getValue().destinoProperty());
        dataIdaPasColumn.setCellValueFactory(cellData -> cellData.getValue().dataIdaProperty());
        precoPasColumn.setCellValueFactory(cellData -> cellData.getValue().precoProperty());
        quantidadePasColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());

        tabelaPassagens.setItems(passagemList);

        //Iniciando colunas da tabela de Hospedagem
        cidadeHospColumn.setCellValueFactory(cellData -> cellData.getValue().getCidadeProperty());
        hotelHospColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelProperty());
        precoHospColumn.setCellValueFactory(cellData -> cellData.getValue().getPrecoQuartoProperty());
        quantidadeHospColumn.setCellValueFactory(cellData -> cellData.getValue().getQuartosProperty());

        tabelaHospedagem.setItems(hospedagemList);

        //Iniciando colunas da tabela de Usuario
        usuarioName.setCellValueFactory(cellData -> cellData.getValue().getRefCli());
        usuarioDescricao.setCellValueFactory(cellData -> cellData.getValue().getDescricao());
        usuarioPedidoId.setCellValueFactory(cellData -> cellData.getValue().getId());
        usuarioPrecoAnterior.setCellValueFactory(cellData -> cellData.getValue().getPrecoAnterior());

        tabelaUsuario.setItems(usuarioList);

    }

    public void clicou(){
        introPane.setVisible(false);
        serverPane.setVisible(true);
    }


    /*=======
     PASSAGEM
     =======*/
    public void abrirPaneCadastroPassagem(){
        tabPaneGeral.setVisible(false);
        painelCadastroPassagem.setVisible(true);
    }

    public void cancelarCadastroPassagens(){
        inputPasDataIda.clear();
        inputPasDestino.clear();
        inputPasOrigem.clear();
        inputPasPreco.clear();
        inputPasQuantidade.clear();

        tabPaneGeral.setVisible(true);
        painelCadastroPassagem.setVisible(false);
    }

    public void addPassagem(){
        String origem       = inputPasOrigem.getText();
        String destino      = inputPasDestino.getText();
        String[] parts      = inputPasDataIda.getText().split("/");
        int idaDia          = Integer.parseInt(parts[0]);
        int idaMes          = Integer.parseInt(parts[1]);
        int idaAno          = Integer.parseInt(parts[2]);
        float preco         = Float.parseFloat(inputPasPreco.getText());
        int qtd             = Integer.parseInt(inputPasQuantidade.getText());
        System.out.println("---->>> "+ idaDia + "/" + idaMes +"/" + idaAno);
        LocalDate aux       = LocalDate.of(idaAno, idaMes, idaDia);

        passagemList.add(new Passagem(origem, destino, aux, preco, qtd, controlIndex));
        controlIndex++;

        inputPasDataIda.clear();
        inputPasDestino.clear();
        inputPasOrigem.clear();
        inputPasPreco.clear();
        inputPasQuantidade.clear();

        tabPaneGeral.setVisible(true);
        painelCadastroHospedagem.setVisible(false);
    }


    /*=========
     HOSPEDAGEM
     =========*/
    public void abrirPaneCadastroHospedagem(){
        tabPaneGeral.setVisible(false);
        painelCadastroHospedagem.setVisible(true);
    }

    public void cancelarCadastroHospedagem(){
        inputHospCidade.clear();
        inputHospHotel.clear();
        inputHospPreco.clear();
        inputHospQuantidade.clear();

        tabPaneGeral.setVisible(true);
        painelCadastroHospedagem.setVisible(false);
    }

    public void addHospedagem(){
        String hotel        = inputHospHotel.getText();
        String cidade       = inputHospCidade.getText();
        float preco         = Float.parseFloat(inputHospPreco.getText());
        int qtd             = Integer.parseInt(inputHospQuantidade.getText());

        hospedagemList.add(new Hospedagem(cidade, hotel, qtd, preco, controlIndex));
        controlIndex++;

        inputHospCidade.clear();
        inputHospHotel.clear();
        inputHospPreco.clear();
        inputHospQuantidade.clear();

        tabPaneGeral.setVisible(true);
        painelCadastroPassagem.setVisible(false);
    }


    /*==================
     METODOS DO SERVIDOR
     =================*/

    public void addRegistroUsuario(int idTransacao, InterfaceCli refCli,
                                                       float precoAnterior, String descricao) throws RemoteException{
        jfxPanelDummy = new JFXPanel();
        System.out.println("Recebido um pedido de registro de notificacao");
        Usuario auxUsuario = new Usuario(idTransacao,refCli,precoAnterior,descricao);
        System.out.println("Passou do auxUsuario");



        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        //Background work
                        final CountDownLatch latch = new CountDownLatch(1);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    //FX Stuff done here
                                    usuarioList.add(auxUsuario);
                                }finally{
                                    latch.countDown();
                                }
                            }
                        });
                        latch.await();
                        //Keep with the background work
                        return null;
                    }
                };
            }
        };
        service.start();






        System.out.println("ID: " + idTransacao + " Preco: " + precoAnterior + " Descricao: " + descricao);
    }

}
