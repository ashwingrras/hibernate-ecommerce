package org.example;
/*

    relations:
    1. one to one
    2. one to many
    3. many to one
    4. many to many

    1. User : userId, name, mobileNo, emailId
    2. Product: productId, name, description, price
    3. Order: orderId, userId, orderDate, status
    4. OrderItem: orderItemId, orderId, productId

    Tasks:

    Product:
    1. productId
    2. name
    3. description
    4. price
    5. colors : Set [red, green, blue, orange, yellow]
       color: id, name
       productColors; productId, colorId
    6. sizes : Set [L, XL, M, XXL, S]
       size: id, value
       productSizes: productId, sizeId
    7. category :
    8. stock: productId, colorId, sizeId, qty
        stock: productId, productSizeId, productColorId, quantity
    9. discount: [ color, size, discountPercentage]



 */


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainEcommerceTest
{
    public static void main(String[] args)
    {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        session.close();
        System.out.println("success");
    }
}
