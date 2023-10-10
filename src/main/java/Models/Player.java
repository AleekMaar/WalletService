package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий игрока в системе.
 */
public class Player {
    private int id;
    private String name;
    private double balance;
    private Map<Integer, Transaction> transactions;
    private List<Audit> audit;

    /**
     * Создает нового игрока с указанным идентификатором и именем.
     *
     * @param id   Идентификатор игрока.
     * @param name Имя игрока.
     */
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 100;
        this.transactions = new HashMap<>();
        this.audit = new ArrayList<>();
    }

    /**
     * Увеличивает баланс игрока на указанную сумму.
     *
     * @param amount Сумма для увеличения баланса.
     */
    public void increaseBalance(double amount) {
        balance += amount;
    }

    /**
     * Уменьшает баланс игрока на указанную сумму.
     *
     * @param amount Сумма для уменьшения баланса.
     */
    public void decreaseBalance(double amount) {
        balance -= amount;
    }

    /**
     * Добавляет транзакцию в список транзакций игрока.
     *
     * @param id          Идентификатор транзакции.
     * @param transaction Объект транзакции для добавления.
     */
    public void addTransaction(int id, Transaction transaction) {
        transactions.put(id, transaction);
    }

    /**
     * Возвращает идентификатор игрока.
     *
     * @return Идентификатор игрока.
     */
    public int getId() {
        return id;
    }


    /**
     * Устанавливает идентификатор игрока.
     *
     * @param id Новый идентификатор игрока.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Возвращает имя игрока.
     *
     * @return Имя игрока.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя игрока.
     *
     * @param name Новое имя игрока.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает текущий баланс игрока.
     *
     * @return Текущий баланс игрока.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс игрока.
     *
     * @param balance Новый баланс игрока.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Возвращает список транзакций игрока.
     *
     * @return Список транзакций игрока.
     */
    public Map<Integer, Transaction> getTransactions() {
        return transactions;
    }


    /**
     * Устанавливает список транзакций игрока.
     *
     * @param transactions Новый список транзакций игрока.
     */
    public void setTransactions(Map<Integer, Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Возвращает список аудиторских записей для игрока.
     *
     * @return Список аудиторских записей для игрока.
     */
    public List<Audit> getAudit() {
        return audit;
    }


    /**
     * Устанавливает список аудиторских записей для игрока.
     *
     * @param audit Новый список аудиторских записей для игрока.
     */
    public void setAudit(List<Audit> audit) {
        this.audit = audit;
    }
}