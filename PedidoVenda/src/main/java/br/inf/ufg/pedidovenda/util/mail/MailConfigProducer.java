package br.inf.ufg.pedidovenda.util.mail;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.SimpleMailConfig;

public class MailConfigProducer {

	@Produces
	@ApplicationScoped
	public SessionConfig getMailConfig() throws IOException {
		
		Properties props = new Properties();
		
		
		//Configuração para ambiente de desenvovimento
		props.load(getClass().getResourceAsStream("../../../../../ProjetosWEB/mail.properties"));
		/**
		 * Configuração para quando em produção
		 * props.load(getClass().getResourceAsStream("/mail.properties"));
		 */
		
		SimpleMailConfig config =  new SimpleMailConfig();
		
		config.setServerHost(props.getProperty("mail.server.host"));
		config.setServerPort(Integer.parseInt(props.getProperty("mail.server.port")));
		config.setEnableSsl(Boolean.parseBoolean(props.getProperty("mail.enable.ssl")));
		config.setAuth(Boolean.parseBoolean(props.getProperty("mail.auth")));
		config.setUsername(props.getProperty("mail.username"));
		config.setPassword(props.getProperty("mail.passsword"));
		
		return config;
	}
	
}
