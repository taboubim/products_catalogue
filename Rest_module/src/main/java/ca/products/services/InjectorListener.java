package ca.products.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;


/**
 * Created by mtaboubi on 16-07-17.
 */
public class InjectorListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {

        return Guice.createInjector(
                new PersistenceModule(),
                new GuiceModule(),
                new RestModule());
    }
}