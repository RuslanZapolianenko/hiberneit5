package homework_05;
import homework_05.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id); // получение объекта по id
        session.close();
        return book;
    }

    public Book updateBook (Book book){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Здесь происходит команда select
        Book book1 = session.get(Book.class, book.getId());

        // Данная часть должна отработать для выполнения операции update, если будет обращение к существующей записи
        // Мы получаем данные входящего параметра и обновляем данные записи
        book1.setName(book.getName());
        book1.setAuthorId(book.getAuthorId());
        session.save(book1);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
        return book;
    }


}

