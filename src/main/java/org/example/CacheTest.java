package org.example;

import org.example.modal.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CacheTest
{
    public static void main(String[] args)
    {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session1=factory.openSession();
        User fetchUser = session1.get(User.class, 1L);
        System.out.println(fetchUser.getUsername());
        session1.close();

        Session session2=factory.openSession();
        User user2=(User)session2.load(User.class,1L);
        System.out.println(user2.getUsername());
        session2.close();
    }
}
