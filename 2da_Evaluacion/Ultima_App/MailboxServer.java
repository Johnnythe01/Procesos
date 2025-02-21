import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailboxServer implements MailboxInterface {
    private final Map<String, List<String>> mailbox;

    public MailboxServer() {
        mailbox = new HashMap<>();
    }

    @Override
    public synchronized void registerUser(String username) throws RemoteException {
        if (!mailbox.containsKey(username)) {
            mailbox.put(username, new ArrayList<>());
            System.out.println("Usuario registrado: " + username);
        }
    }

    @Override
    public synchronized void sendMessage(String recipient, String message) throws RemoteException {
        if (!mailbox.containsKey(recipient)) {
            System.out.println("El destinatario no está registrado: " + recipient);
            return;
        }
        mailbox.get(recipient).add(message);
        System.out.println("Mensaje enviado a " + recipient);
    }

    @Override
    public synchronized List<String> getMessages(String username) throws RemoteException {
        if (!mailbox.containsKey(username)) {
            System.out.println("Usuario no registrado: " + username);
            return new ArrayList<>();
        }
        List<String> messages = new ArrayList<>(mailbox.get(username));
        mailbox.get(username).clear();
        return messages;
    }

    public static void main(String[] args) {
        try {
            MailboxServer server = new MailboxServer();
            MailboxInterface stub = (MailboxInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(5555);
            registry.rebind("MailboxService", stub);
            System.out.println("Servidor en ejecución...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
