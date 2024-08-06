package org.example;

import org.example.modal.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

/*
    Hibernate:
    1. relations ( annotations), mapping
    2. HQL & HCQL
    3. inheritance mapping
    4. hibernate caching
 */


public class HibernateTest
{
    public static void main(String[] args) {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Transaction t=session.beginTransaction();

        User user1=new User();
        user1.setUsername("aman");
        user1.setEmail("aman@gmail.com");

        //session.persist(user1);

        //
        User fetchUser = session.get(User.class, 1L);
        User fetchUser1 = session.get(User.class, 1L);
        System.out.println(fetchUser.getUsername());
        System.out.println(fetchUser1.getUsername());
        //
        // hibernate query language ( HQL )
        /*
        TypedQuery query=session.createQuery("from User where username =: name");
        query.setParameter("name","aman");
        List<User> list=query.getResultList();

        Iterator<User> itr=list.iterator();
        while(itr.hasNext())
        {
            User usr=itr.next();
            System.out.println(usr.getUsername());
        }
        */
        t.commit();
        session.close();
        System.out.println("success");
    }
}
