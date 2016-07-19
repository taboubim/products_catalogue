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
        binder.install(new JpaPersistModule("manager1"));
        binder.bind(PersistenceInitializer.class).asEagerSingleton();
    }
}