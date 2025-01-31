package com.juan.sanchez.service.impl;

import com.juan.sanchez.exception.BusinessException;
import com.juan.sanchez.service.BusinessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("exception-checked-try-catch-non")
class BusinessExceptionV2ServiceImpl implements BusinessService {

    @Override
    public void doBusiness() throws Exception {
        System.out.println(" [BusinessService] doBusiness Starting");
        System.out.println("  [BusinessService] Throwing Exception");
        throw new BusinessException("It is a Business Exception");
    }

}
