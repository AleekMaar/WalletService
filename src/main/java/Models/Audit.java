package Models;

import Models.Enum.AuditType;

/**
 * Класс, предоставляющий аудиторскую запись о действиях игрока
 */
public class Audit {
    private int id;
    private AuditType type;

    /**
     * Создает новую аудиторскую запись с указанным типом.
     *
     * @param type Тип аудиторской записи.
     */
    public Audit(AuditType type) {
        this.type = type;
    }

    /**
     * Возвращает идентификатор аудиторской записи.
     *
     * @return Идентификатор аудиторской записи.
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор аудиторской записи.
     *
     * @param id Новый идентификатор аудиторской записи.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает тип аудиторской записи.
     *
     * @return Тип аудиторской записи.
     */
    public AuditType getType() {
        return type;
    }

    /**
     * Устанавливает тип аудиторской записи.
     *
     * @param type Новый тип аудиторской записи.
     */
    public void setType(AuditType type) {
        this.type = type;
    }
}
