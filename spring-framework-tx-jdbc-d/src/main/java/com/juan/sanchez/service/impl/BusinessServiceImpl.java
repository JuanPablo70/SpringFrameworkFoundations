package com.juan.sanchez.service.impl;

import com.juan.sanchez.service.BusinessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("exception-non")
class BusinessServiceImpl implements BusinessService {

    @Override
    public void doBusiness() throws Exception {
        System.out.println(" [BusinessService] doBusiness Starting");
        System.out.println(" [BusinessService] doBusiness Ending");
    }

}
