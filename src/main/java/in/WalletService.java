package in;

import Models.*;
import Models.Enum.AuditType;
import Models.Enum.TransactionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Основной класс WalletService, в котором происходит выполнение всей программы
 * @author Alexander Mar
 */
public class WalletService {

    private Player player;

    private Map<Integer, Player> players;

    public WalletService() {
        this.players = new HashMap<>();
    }

    /**
     * Регистрирует нового игрока и добавляет его в список игроков.
     */
    public void registerPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Чтобы зарегистрироваться, введите имя пользователя!");

        String playerName = scanner.nextLine();

        int playerId = randomIdGenerator();

        if (!players.containsKey(playerId)) {
            Player player = new Player(playerId, playerName);
            players.put(playerId, player);
            this.player = player;
            player.getAudit().add(new Audit(AuditType.REG));
            System.out.println("Игрок " + playerName + " успешно зарегистрирован! Вот ваш идентификатор: " + playerId +
                    "\n Он понадобится для последующего входа в систему");
            menu();
        } else {
            System.out.println("Игрок с таким идентификатором уже существует.");
        }
    }

    /**
     * Входит в систему игрока с указанным идентификатором.
     */
    public void loginPlayer() {
        System.out.println("Введите свой идентификатор:");

        Scanner scanner = new Scanner(System.in);
        int playerId = scanner.nextInt();

        if (players.containsKey(playerId)) {
            player = players.get(playerId);
            player.getAudit().add(new Audit(AuditType.LOG));

            menu();
        } else {
            System.out.println("Игрок с таким идентификатором не найден.");
            start();
        }
    }

    /**
     * Выводит баланс игрока
     * @param player Игрок, для которого нужно вывести баланс
     */
    public void getPlayerBalance(Player player) {
        System.out.println("Ваш баланс: " + player.getBalance());

        this.player.getAudit().add(new Audit(AuditType.CHECK_BALANCE));

        menu();
    }

    /**
     * Совершает операцию дебита
     * @param player Игрок, для которого нужно совершить операцию дебита
     */
    public void debitTransaction(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной.");
            debitTransaction(this.player);
        }

        if (player.getBalance() >= amount) {
            System.out.println("Придумайте и введите номер транзакции");
            int transactionId = scanner.nextInt();

            if(transactionId < 0) {
                System.out.println("Идентификатор должен быть положительным");
                debitTransaction(this.player);
            }

            if(player.getTransactions().containsKey(transactionId)) {
                System.out.println("Такой идентификатор уже существует! Введите другой.");
                debitTransaction(this.player);
            }

            Transaction transaction = new Transaction(transactionId, TransactionType.DEBIT, amount);
            player.addTransaction(transactionId,transaction);
            player.decreaseBalance(amount);
            System.out.println("Дебетовая транзакция выполнена успешно.");
            this.player.getAudit().add(new Audit(AuditType.DEBIT));

            menu();
        } else {
            System.out.println("Недостаточно средств на балансе игрока.");
            menu();
        }
    }

    /**
     * Совершает операцию кредита
     * @param player Игрок, для которого нужно совершить операцию кредита
     */
    public void creditTransaction(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной.");
            creditTransaction(this.player);
        }

        System.out.println("Придумайте и введите номер транзакции");
        int transactionId = scanner.nextInt();

        if(transactionId < 0) {
            System.out.println("Идентификатор должен быть положительным");
            debitTransaction(this.player);
        }
        if(player.getTransactions().containsKey(transactionId)) {
            System.out.println("Такой идентификатор уже существует! Введите другой.");
            creditTransaction(this.player);
        }

        Transaction transaction = new Transaction(transactionId, TransactionType.CREDIT, amount);
        player.addTransaction(transactionId,transaction);
        player.increaseBalance(amount);

        System.out.println("Кредитная транзакция выполнена успешно.");

        this.player.getAudit().add(new Audit(AuditType.CREDIT));

        menu();
    }

    /**
     * Выводит историю всех транзакций игрока
     * @param player Игрок, для которого нужно вывести историю всех транзакций
     */
    public void viewTransactionHistory(Player player) {
        System.out.println("История транзакций:");

        for (Transaction transaction : player.getTransactions().values()) {
            System.out.println("ID: " + transaction.getId());
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("------------------------");
        }

        this.player.getAudit().add(new Audit(AuditType.CHECK_TRANS));
        menu();
    }

    /**
     * Выводит аудит
     * @param player Игрок, для которого нужно вывести аудит
     */
    public void viewAuditHistory(Player player) {
        this.player.getAudit().add(new Audit(AuditType.CHECK_AUDIT));

        for(int i = 0; i < player.getAudit().size(); i++)
            for(int j = 0; j < player.getAudit().size() - i - 1; j++)
                if(player.getAudit().get(j).getId() > player.getAudit().get(j + 1).getId()) {
                    Audit temp = player.getAudit().get(j);
                    player.getAudit().set(j, player.getAudit().get(j + 1));
                    player.getAudit().set(j+1, temp);
                }

        for(Audit audit : player.getAudit()) {
            System.out.println(audit.getType());
        }
        menu();
    }

    /**
     * Создает случайный идентификатор пользователя в диапазоне от 1 до 100
     */
    public int randomIdGenerator() {
        Random random = new Random();

        int randomNumber = random.nextInt();

        int min = 1;
        int max = 100;

        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Функция меню. Является основным способом взаимодействия с приложением
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Выберите действие:
                1) Мой баланс
                2) Дебит
                3) Кредит
                4) История моих транзакций
                5) Аудит
                6) Выход
                """);
        int chose = scanner.nextInt();

        switch (chose) {
            case 1: getPlayerBalance(player);
            case 2: debitTransaction(player);
            case 3: creditTransaction(player);
            case 4: viewTransactionHistory(player);
            case 5: viewAuditHistory(player);
        }

        if(chose == 6) {
            this.player.getAudit().add(new Audit(AuditType.EXIT));
            start();
        }
    }
    /**
     * Функция, которая выводится в самом начале при запуске. Нужен для регистрации и входа игрока
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Выберите действие:
                1) Войти
                2) Зарегистрироваться
                """);
        int chose = scanner.nextInt();
        switch (chose) {
            case 1: loginPlayer();
            case 2: registerPlayer();
        }
    }
}