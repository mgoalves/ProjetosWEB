package br.inf.ufg.pedidovenda.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.inf.ufg.pedidovenda.service.NegocioException;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	// Instancia o log para salvar os dados de erro que o sistema gera.
	private static Log log = LogFactory.getLog(CustomExceptionHandler.class);
	
	private ExceptionHandler wrapped;

	// Construtor da classe
	public CustomExceptionHandler(ExceptionHandler wrapped) {
		super();
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			boolean handled = false;
			Throwable exception = context.getException();
			NegocioException negocioException = getNegocioException(exception);

			try {
				if (exception instanceof ViewExpiredException) {

					handled = true;
					redirect("/");
				} else if (negocioException != null) {

					handled = true;
					FacesUtil.addErrorMessage(negocioException.getMessage());
				} else {
					handled = true;
					log.error("Erro de Sistema: " + exception.getMessage(), exception);
					redirect("/Erro.xhtml");
				}
			} finally {

				if (handled) {
					events.remove();
				}
			}
		}

		getWrapped().handle();
	}

	// Função responsável por vasculhar a exceção e decompola
	// para ver se é uma exceção do tipo NegocioException usando
	// a recursividade
	private NegocioException getNegocioException(Throwable exception) {

		if (exception instanceof NegocioException) {

			return (NegocioException) exception;
		} else if (exception.getCause() != null) {

			return getNegocioException(exception.getCause());
		}
		return null;
	}

	/*
	 * Função usada para redirecionar o usuário para a home page quando houve o
	 * erro ViewExpiredException
	 */
	private void redirect(String page) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();

			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

}
