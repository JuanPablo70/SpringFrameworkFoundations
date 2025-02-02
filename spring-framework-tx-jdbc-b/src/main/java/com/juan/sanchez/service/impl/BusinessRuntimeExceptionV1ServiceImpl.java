package com.juan.sanchez.service.impl;

import com.juan.sanchez.exception.BusinessRuntimeException;
import com.juan.sanchez.service.BusinessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("exception-unchecked-try-catch")
class BusinessRuntimeExceptionV1ServiceImpl implements BusinessService {

    @Override
    public void doBusiness() {
        System.out.println(" [BusinessService] doBusiness Starting");
        try {
            System.out.println("  [BusinessService] Throwing RuntimeException");
            throw new BusinessRuntimeException("It is a Business RuntimeException");
        }
        catch(RuntimeException ex) {
            System.out.println("   [BusinessService] Catching and Handling RuntimeException");
            System.out.println("    Type   : " + ex.getClass());
            System.out.println("    Message: " + ex.getMessage());
        }
        System.out.println(" [BusinessService] doBusiness Ending");
    }

}
