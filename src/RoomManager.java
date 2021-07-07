import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoomManager extends Remote {
    String list() throws RemoteException;
    String reserve(int tipoDoQuarto, String nameGuests) throws RemoteException;
    String guests() throws RemoteException;
}
