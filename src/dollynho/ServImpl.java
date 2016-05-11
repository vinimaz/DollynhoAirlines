package dollynho;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vinimaz on 5/5/16.
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {



    public ServImpl() throws RemoteException {
    }

    @Override
    public synchronized ArrayList<Passagem> getPassagens() throws RemoteException {
        return null;
    }

    @Override
    public synchronized ArrayList<Passagem> getTodasPassagens() throws RemoteException {
        return null;
    }

    @Override
    public synchronized ArrayList<Hospedagem> getTodasHospedagens() throws RemoteException {
        return null;
    }

    @Override
    public synchronized ArrayList<Passagem> getSearchPassagens(String origem, String destino, Date ida, Date volta, int numAdultos, int numCriancas) throws RemoteException {
        return null;
    }

    @Override
    public synchronized ArrayList<Hospedagem> getSearchHospedagem(String cidade, String hotel, LocalDate inicio, LocalDate fim, int qtdQuartos, int numPessoas) throws RemoteException {
        return null;
    }

    @Override
    public synchronized void cadastraNotificacao(InterfaceCli cliente, int id,
                                                 float preco, String descricao) throws RemoteException {
        System.out.println("Cliente passou por aqui");
        Controller.addRegistroUsuario(id, cliente, preco, descricao);
    }

    public void echoTest(){
        System.out.println("Cliente passou pelo echoTest");
    }
}
