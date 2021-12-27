public class Main {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();

        Thread ping = new Thread(() -> {
            while (true) {
                messageService.print("Ping ");
            }
        });

        Thread pong = new Thread(() -> {
            while (true) {
                messageService.print("Pong ");
            }
        });

        ping.start();
        pong.start();
    }
}
