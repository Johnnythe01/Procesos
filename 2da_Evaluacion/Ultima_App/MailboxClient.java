import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class MailboxClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5555);
            MailboxInterface mailbox = (MailboxInterface) registry.lookup("MailboxService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce tu nombre: ");
            String username = scanner.nextLine();

            mailbox.registerUser(username);
            System.out.println("Usuario registrado correctamente!");

            while (true) {
                System.out.println("\nOpciones:");
                System.out.println("1. Enviar mensaje");
                System.out.println("2. Leer mensaje");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("¿A quién quieres enviar el mensaje? ");
                        String recipient = scanner.nextLine();
                        System.out.print("Escribe tu mensaje: ");
                        String message = scanner.nextLine();
                        mailbox.sendMessage(recipient, message);
                        System.out.println("Mensaje enviado!");
                        break;
                    case 2:
                        List<String> messages = mailbox.getMessages(username);
                        if (messages.isEmpty()) {
                            System.out.println("No tienes mensajes.");
                        } else {
                            System.out.println("Mensajes recibidos:");
                            for (String msg : messages) {
                                System.out.println("- " + msg);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Vuelve a intentarlo.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
