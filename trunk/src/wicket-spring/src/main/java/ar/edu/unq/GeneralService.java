package ar.edu.unq;

import org.apache.log4j.Logger;

public class GeneralService {

    protected static final Logger LOG = Logger.getLogger(GeneralService.class);

    public GeneralService() {
        if (true) {
            LOG.info("se crea");
        }

    }

    public void test() {
        LOG.info("test");
    }

}
