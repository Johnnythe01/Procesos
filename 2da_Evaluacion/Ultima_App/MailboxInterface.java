import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MailboxInterface extends Remote {
    void registerUser(String username) throws RemoteException;
    void sendMessage(String recipient, String message) throws RemoteException;
    List<String> getMessages(String username) throws RemoteException;
}
