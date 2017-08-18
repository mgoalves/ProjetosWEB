package br.inf.ufg.pedidovenda.util.jsf;

import org.jboss.weld.servlet.api.ServletListener;

public class AppContextListener implements ServletListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
	}

}
