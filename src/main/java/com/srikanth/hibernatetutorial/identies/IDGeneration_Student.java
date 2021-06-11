package com.srikanth.hibernatetutorial.identies;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class IDGeneration_Student implements IdentifierGenerator {
    private static int id = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        id = id + 2;
        return id;
    }
}
