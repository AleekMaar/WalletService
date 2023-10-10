import in.WalletService;

/**
 * Класс Main представляет точку входа в приложение. Он создает экземпляр класса WalletService и запускает его.
 */
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса WalletService
        WalletService walletService = new WalletService();
        // Запускаем WalletService
        walletService.start();
    }
}
