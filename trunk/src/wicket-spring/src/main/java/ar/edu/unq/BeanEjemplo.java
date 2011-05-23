package ar.edu.unq;

import org.apache.log4j.Logger;

public class BeanEjemplo {
	
	private static  final Logger LOG = Logger.getLogger(BeanEjemplo.class);
	
	private String show;
	
	public String getShow() {
		return show;
	}

	public void setShow(String value) {
		this.show = value;
	}

	public void test(){
		LOG.info("test");
	}

}
