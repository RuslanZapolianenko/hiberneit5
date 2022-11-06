package homework_05.entity;

import javax.persistence.*;


//@DynamicUpdate обновляет записи не те, которые мы указали. а те, которые реально изменились.
//@DynamicInsert вставляет только непустые записи
@Entity
// @DynamicUpdate
// @DynamicInsert
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // Добавляем поле фамилии
    @Column(name = "last_name")
    private String lastName;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}