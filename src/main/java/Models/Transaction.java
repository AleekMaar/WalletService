package Models;

import Models.Enum.TransactionType;

/**
 * Класс Transaction представляет собой объект транзакции с определенным идентификатором, типом и суммой.
 */
public class Transaction {
    private int id;
    private TransactionType type;
    private double amount;

    /**
     * Конструктор класса Transaction.
     *
     * @param id     Идентификатор транзакции.
     * @param type   Тип транзакции (например, покупка, продажа и т. д.).
     * @param amount Сумма транзакции.
     */
    public Transaction(int id, TransactionType type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Получает тип транзакции.
     *
     * @return Тип транзакции.
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Получает сумму транзакции.
     *
     * @return Сумма транзакции.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Получает идентификатор транзакции.
     *
     * @return Идентификатор транзакции.
     */
    public int getId() {
        return id;
    }


    /**
     * Устанавливает новый идентификатор транзакции.
     *
     * @param id Новый идентификатор транзакции.
     */
    public void setId(int id) {
        this.id = id;
    }
}