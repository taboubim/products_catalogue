package ca.products.services;

import ca.products.repositories.*;
import com.google.inject.AbstractModule;

/**
 * Created by mtaboubi on 16-07-17.
 */
public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(MemberRepository.class).to(MemberRepositoryImp.class);
        bind(ProductRepository.class).to(ProductRepositoryImpl.class);
        bind(ShoppingBagRepository.class).to(ShoppingBagRepositoryImpl.class);
    }
}
