package br.inf.ufg.pedidovenda.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void addErrorMessage(String message) {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));

	}

	public static boolean isPostBack() {

		return FacesContext.getCurrentInstance().isPostback();
	}

	public static boolean isPostNotBack() {

		return !isPostBack();
	}
}
