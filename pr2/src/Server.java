import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    private static String BIND_NAME = "QuadraticEquation";

    public static void main(String[] args) {
        try {
            QuadraticEquationImpl quadraticEquation = new QuadraticEquationImpl();
            QuadraticEquation stub = (QuadraticEquation) UnicastRemoteObject.exportObject(quadraticEquation, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(BIND_NAME, stub);
            System.out.println("Server ready");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
