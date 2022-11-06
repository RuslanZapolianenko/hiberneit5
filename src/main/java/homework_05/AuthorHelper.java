package homework_05;
import homework_05.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();
        // этап подготовки запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)


        cq.select(root);// необязательный оператор, если просто нужно получить все значения


        //этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
        return author;
    }

    public void addAuthorAutoGeneration(int number){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(int i = 0; i < number; i++){
            session.save(new Author("Name_" + i,"lastName_" + i));

            if(i % 200 == 0){
                System.out.println("___________Метод flush()___________");
                session.flush();
            }
        }
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
    }

    public Author updateAuthor(Author author){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Здесь происходит команда select
        Author author1 = session.get(Author.class, author.getId());

        // Данная часть должна отработать для выполнения операции update, если будет обращение к существующей записи
        // Мы получаем данные входящего параметра и обновляем данные записи
        author1.setName(author.getName());
        author1.setLastName(author.getLastName());
        session.save(author1);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
        return author;
    }

}

