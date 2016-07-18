package ca.products.services;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import java.util.Properties;

/**
 * Created by mtaboubi on 16-07-17.
 */
public class PersistenceModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder
                .install(new JpaPersistModule("manager1")
                        .properties(getPersistenceProperties()));

        binder.bind(PersistenceInitializer.class).asEagerSingleton();
    }

    private static Properties getPersistenceProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "postgres");
        properties.put("hibernate.connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "create");

        return properties;
    }
}