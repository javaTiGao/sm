package org.sm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.sm.bean.Students;

/**
 * Created by Gell on 2016/12/28.
 */
public class SessionUtils {
    Configuration config;
    ServiceRegistry serviceRegistry;

    public SessionUtils(){
        // 加载配置文件
        config = new Configuration().configure( "/src/main/java/hello.cfg.xml");
        // 初始化所有需要的服务
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        // 在完成 sessionFactory 的创建之前，可以通过 config.addXXX 的方式，动态添加实体类的映射信息
        config.addAnnotatedClass(Students.class);


    }

    public Session getSession(){
        // 创建 sessionFactory 对象

         SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        return session;
    }
}
