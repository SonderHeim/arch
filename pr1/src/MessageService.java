public class MessageService {
    public synchronized void print(String message) {
        System.out.print(message);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
