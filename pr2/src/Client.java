import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private static String BIND_NAME = "QuadraticEquation";

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("a*x^2 + b*x + c = 0");

            System.out.print("Enter a: ");
            double a = in.nextDouble();

            System.out.print("Enter b: ");
            double b = in.nextDouble();

            System.out.print("Enter c: ");
            double c = in.nextDouble();

            Registry registry = LocateRegistry.getRegistry(null);
            QuadraticEquation stub = (QuadraticEquation) registry.lookup(BIND_NAME);
            Double[] results = stub.calc(a, b, c);

            if (results == null) {
                System.out.println("No Ox Intersections");
                return;
            }

            System.out.println("x1: " + results[0]);
            System.out.println("x2: " + results[1]);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
