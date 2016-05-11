package dollynho;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by vinimaz on 5/5/16.
 */
public interface InterfaceCli extends Remote {
    public void notificaHospedagem() throws RemoteException;
    public void notificaPassagem() throws RemoteException;
}
