package ar.edu.unq.services;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

public class GeneralService {

    protected static final Logger LOG = Logger.getLogger(GeneralService.class);

    public GeneralService() {
        LOG.info("se crea");
    }

    @Transactional
    public void test() {
        LOG.info("test");
    }

}
