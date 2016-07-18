package ca.products.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

/**
 * Created by mtaboubi on 16-07-17.
 */
@Singleton
public class PersistenceInitializer {
    @Inject
    public PersistenceInitializer(PersistService service) {
        service.start();
    }
}
