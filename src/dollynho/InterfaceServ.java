package dollynho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vinimaz on 5/5/16.
 */
public interface InterfaceServ extends Remote {
    ArrayList<Passagem> getPassagens() throws RemoteException;

    public ArrayList<Passagem> getTodasPassagens() throws RemoteException;
    public ArrayList<Hospedagem> getTodasHospedagens() throws RemoteException;
    public ArrayList<Passagem> getSearchPassagens(String origem, String destino, Date ida, Date volta,
                                                  int numAdultos, int numCriancas) throws RemoteException;
    public ArrayList<Hospedagem> getSearchHospedagem(String cidade, String hotel, LocalDate inicio, LocalDate fim,
                                                     int qtdQuartos, int numPessoas) throws RemoteException;
    public void cadastraNotificacaoHospedagem(InterfaceCli cliente, int idHosp, float preco) throws RemoteException;
    public void cadastraNotificacaoPassagem(InterfaceCli cliente, int idPas, float preco) throws RemoteException;

}
