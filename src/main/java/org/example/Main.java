package org.example;
import homework_05.AuthorHelper;
import homework_05.BookHelper;
import homework_05.entity.Author;
import homework_05.entity.Book;
/*
Задание 2+
Настроить логирование для проекта с дополнительным заданием.
 */

/*
Задание 4+
К дополнительному заданию добавить метод обновления имени автора по id.
(То, что было на уроке, только реализовать это правильно).
Аналогично сделать и в классе BookHelper с предыдущего ДЗ
 */

/*
Задание 5+
В классе BookHelper создать метод, который получает название книг и имя автора.
*/

/*
Задание 6+
Из пакета ex_002_insert_and_update создайте в цикле 200 объектов author
и сохраните в БД. Значения полей могут быть любыми.
Используйте метод flush для каждых 10 объектов. Метод сommit выполняйте один раз в конце.
 */
public class Main {


    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        BookHelper bH = new BookHelper();

        // Задание 4
        Author authorUpdate = ah.getAuthorById(2);
        authorUpdate.setName("Kvitka");
        authorUpdate.setLastName("Osnovyanenko");
        ah.updateAuthor(authorUpdate);

        Book bookUpdate = bH.getBookById(1);
        bookUpdate.setName("Test Book Name");
        bookUpdate.setAuthorId(2);
        bH.updateBook(bookUpdate);

        // Задание 5
        Book bookId = bH.getBookById(1);
        Author authorID = ah.getAuthorById( bookId.getAuthorId() );
        System.out.println("ID book = " + bookId.getId() + " Название Книги "
                + bookId.getName() + " Автор Книги " + authorID.getName() + " " + authorID.getLastName());

        // Задание 6
        ah.addAuthorAutoGeneration(10);






    }

}