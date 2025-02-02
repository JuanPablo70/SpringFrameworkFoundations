package com.juan.sanchez.service.impl;

import com.juan.sanchez.exception.BusinessRuntimeException;
import com.juan.sanchez.service.BusinessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("exception-unchecked-try-catch-non")
class BusinessRuntimeExceptionV2ServiceImpl implements BusinessService {

    @Override
    public void doBusiness() throws Exception {
        System.out.println(" [BusinessService] doBusiness Starting");
        System.out.println("  [BusinessService] Throwing RuntimeException");
        throw new BusinessRuntimeException("It is a Business RuntimeException");
    }

}
