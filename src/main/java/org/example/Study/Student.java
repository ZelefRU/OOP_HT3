package org.example.Study;

public class Student {
    protected String firstName;
    protected String lastName;

    /**
     * Конструктор для создания студента с указанными именем и фамилией.
     *
     * @param firstName Имя студента.
     * @param lastName  Фамилия студента.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Получает имя студента.
     *
     * @return Имя студента.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Получает фамилию студента.
     *
     * @return Фамилия студента.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Получает полное имя студента, составленное из имени и фамилии.
     *
     * @return Полное имя студента.
     */
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * Возвращает строковое представление студента в формате "Имя Фамилия".
     *
     * @return Строковое представление студента.
     */
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
