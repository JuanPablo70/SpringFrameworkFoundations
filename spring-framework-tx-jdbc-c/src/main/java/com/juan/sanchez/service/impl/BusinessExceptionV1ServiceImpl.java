package com.juan.sanchez.service.impl;

import com.juan.sanchez.exception.BusinessException;
import com.juan.sanchez.service.BusinessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("exception-checked-try-catch")
class BusinessExceptionV1ServiceImpl implements BusinessService {

    @Override
    public void doBusiness() {
        System.out.println(" [BusinessService] doBusiness Starting");
        try {
            System.out.println("  [BusinessService] Throwing Exception");
            throw new BusinessException("It is a Business Exception");
        }
        catch(Exception ex) {
            System.out.println("   [BusinessService] Catching and Handling Exception");
            System.out.println("    Type   : " + ex.getClass());
            System.out.println("    Message: " + ex.getMessage());
        }
        System.out.println(" [BusinessService] doBusiness Ending");
    }

}
