package Models.Enum;

/**
 * Перечисление AuditType представляет различные типы аудита в системе.
 * Оно включает в себя следующие значения:
 * - CHECK_BALANCE: Проверка баланса.
 * - DEBIT: Дебетовая операция.
 * - CREDIT: Кредитовая операция.
 * - CHECK_TRANS: Проверка транзакции.
 * - CHECK_AUDIT: Проверка аудита.
 * - EXIT: Выход из системы.
 * - REG: Регистрация.
 * - LOG: Вход.
 */
public enum AuditType {
    CHECK_BALANCE,
    DEBIT,
    CREDIT,
    CHECK_TRANS,
    CHECK_AUDIT,
    EXIT,
    REG,
    LOG
}