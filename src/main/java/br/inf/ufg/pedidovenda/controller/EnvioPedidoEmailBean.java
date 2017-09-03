package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.util.jsf.FacesUtil;
import br.inf.ufg.pedidovenda.util.mail.Mailer;
import br.inf.ufg.pedidovenda.validation.PedidoEdicao;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable{

	private static final long serialVersionUID = 1L;

	
	//Injeções
	@Inject
	private Mailer mailer;	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	public void enviarPedido() {
		
		MailMessage message = mailer.novaMensagem();
		
		message.to(this.pedido.getCliente().getEmail())
		.subject("Seu pedido de venda: " + this.pedido.getId())
		.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/pedido.template")))
		.put("pedido", this.pedido)
		.put("numberTool", new NumberTool())
		.put("locale", new Locale("pt", "BR"))
		.send();
		
		FacesUtil.addInfoMessage("Envio enviado por email com sucesso.");
	}
	
}
