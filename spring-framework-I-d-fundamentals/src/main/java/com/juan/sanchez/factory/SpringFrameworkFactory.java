package com.juan.sanchez.factory;

import com.juan.sanchez.app.config.AppImportConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringFrameworkFactory {

    public static ApplicationContext createApplicationContext() {
        String springAppCtxVersion = System.getProperty("spring.application.context.version");
        System.out.println("");
        System.out.println("***********************************************");
        System.out.println("Creating - 'Spring ApplicationContext' ");
        System.out.println(" 'spring.application.context.version'");
        System.out.println(" " + springAppCtxVersion + " ");
        System.out.println("***********************************************");
        if (springAppCtxVersion != null) {
            if (springAppCtxVersion.equals("v1cc")) {
                return createApplicationContextV1cc();
            } else if (springAppCtxVersion.equals("v1cs")) {
                return createApplicationContextV1cs();
            } else if (springAppCtxVersion.equals("v1cmr")) {
                return createApplicationContextV1cmr();
            } else if (springAppCtxVersion.equals("v1cms")) {
                return createApplicationContextV1cms();
            } else if (springAppCtxVersion.equals("v2cc-sp-pd")) {
                return createApplicationContextV2ccsppd();
            } else if (springAppCtxVersion.equals("v2cc-sp-pa")) {
                return createApplicationContextV2ccsppa();
            } else if (springAppCtxVersion.equals("v2cc-sp-pda")) {
                return createApplicationContextV2ccsppda();
            } else if (springAppCtxVersion.equals("v2cc-se-pd")) {
                return createApplicationContextV2ccsepd();
            } else if (springAppCtxVersion.equals("v2cc-se-pa")) {
                return createApplicationContextV2ccsepa();
            } else if(springAppCtxVersion.equals("v2cc-se-pda")) {
                return createApplicationContextV2ccsepda();
            } else if(springAppCtxVersion.equals("v3cs-sp-pd")) {
                return createApplicationContextV3cssppd();
            } else if(springAppCtxVersion.equals("v3cs-sp-pa")) {
                return createApplicationContextV3cssppa();
            } else if(springAppCtxVersion.equals("v3cs-sp-pda")) {
                return createApplicationContextV3cssppda();
            } else if(springAppCtxVersion.equals("v3cs-se-pd")) {
                return createApplicationContextV3cssepd();
            } else if(springAppCtxVersion.equals("v3cs-se -pa")) {
                return createApplicationContextV3cssepa();
            } else if(springAppCtxVersion.equals("v3cs-se-pda")) {
                return createApplicationContextV3cssepda();
            } else if(springAppCtxVersion.equals("v4cmr-sp-pd")) {
                return createApplicationContextV4cmrsppd();
            } else if(springAppCtxVersion.equals("v4cmr-sp-pa")) {
                return createApplicationContextV4cmrsppa();
            } else if(springAppCtxVersion.equals("v4cmr-sp-pda")) {
                return createApplicationContextV4cmrsppda();
            } else if(springAppCtxVersion.equals("v4cmr-se-pd")) {
                return createApplicationContextV4cmrsepd();
            } else if(springAppCtxVersion.equals("v4cmr-se -pa")) {
                return createApplicationContextV4cmrsepa();
            } else if(springAppCtxVersion.equals("v4cmr-se -pda")) {
                return createApplicationContextV4cmrsepda();
            } else if(springAppCtxVersion.equals("v5cms-sp-pd")) {
                return createApplicationContextV5cmssppd();
            } else if(springAppCtxVersion.equals("v5cms-sp -pa")) {
                return createApplicationContextV5cmssppa();
            } else if(springAppCtxVersion.equals("v5cms-sp -pda")) {
                return createApplicationContextV5cmssppda();
            } else if(springAppCtxVersion.equals("v5cms-se -pd")) {
                return createApplicationContextV5cmssepd();
            } else if(springAppCtxVersion.equals("v5cms-se-pa")) {
                return createApplicationContextV5cmssepa();
            } else if(springAppCtxVersion.equals("v5cms-se-pda")) {
                return createApplicationContextV5cmssepda();
            } else {
                throw new RuntimeException("'spring.application.context.version' property must be declared with a valid value");
            }
        } else {
            throw new RuntimeException("'spring.application.context.version' property must be declared");
        }
    }

    private static ApplicationContext createApplicationContextV1cc() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        return ctx;
    }

    private static ApplicationContext createApplicationContextV1cs() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV1cmr() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV1cms() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsppd() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,jpa,mysql,p1");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsppa() {
        System.setProperty("spring.profiles.active", "default,prod,log,info,jpa,mysql,p2");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsppda() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,p1");
        System.setProperty("spring.profiles.active", "jpa,mysql,p2");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsepd() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","jpa","mysql","p1");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsepa() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        ctx.getEnvironment().setActiveProfiles("default","prod","log","info","jpa","mysql","p2");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV2ccsepda() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppImportConfig.class);
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","p1");
        ctx.getEnvironment().setActiveProfiles("jpa","mysql","p2");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssppd() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,jpa,mysql,p1");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssppa() {
        System.setProperty("spring.profiles.active", "default,prod,log,info,jpa,mysql,p2");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssppda() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,p1");
        System.setProperty("spring.profiles.active", "jpa,mysql,p2");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssepd() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","jpa","mysql","p1");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssepa() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        ctx.getEnvironment().setActiveProfiles("default","prod","log","info","jpa","mysql","p2");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV3cssepda() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.juan.sanchez.config");
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","p1");
        ctx.getEnvironment().setActiveProfiles("jpa","mysql","p2");
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsppd() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,jpa,mysql,p1");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsppa() {
        System.setProperty("spring.profiles.active", "default,prod,log,info,jpa,mysql,p2");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsppda() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,p1");
        System.setProperty("spring.profiles.active", "jpa,mysql,p2");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsepd() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","jpa","mysql","p1");
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsepa() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("default","prod","log","info","jpa","mysql","p2");
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV4cmrsepda() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","p1");
        ctx.getEnvironment().setActiveProfiles("jpa","mysql","p2");
        ctx.register(AppImportConfig.class);
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssppd() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,jpa,mysql,p1");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssppa() {
        System.setProperty("spring.profiles.active", "default,prod,log,info,jpa,mysql,p2");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssppda() {
        System.setProperty("spring.profiles.default", "default,prod,log,info,p1");
        System.setProperty("spring.profiles.active", "jpa,mysql,p2");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssepd() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","jpa","mysql","p1");
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssepa() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("default","prod","log","info","jpa","mysql","p2");
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private static ApplicationContext createApplicationContextV5cmssepda() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("default","prod","log","info","p1");
        ctx.getEnvironment().setActiveProfiles("jpa","mysql","p2");
        ctx.scan("com.juan.sanchez.config");
        ctx.refresh();
        return ctx;
    }

    private SpringFrameworkFactory() {
    }

}
