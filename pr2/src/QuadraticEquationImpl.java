import java.rmi.RemoteException;

public class QuadraticEquationImpl implements QuadraticEquation {
    @Override
    public Double[] calc(double a, double b, double c) throws RemoteException {
        double determinant = Math.pow(b, 2) - 4 * a * c;

        if (determinant < 0) {
            return null;
        }

        return new Double[] {
                (-b + Math.sqrt(determinant)) / (2 * a),
                (-b - Math.sqrt(determinant)) / (2 * a)
        };
    }
}
