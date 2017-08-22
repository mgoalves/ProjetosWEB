package br.inf.ufg.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.repository.Pedidos;
import br.inf.ufg.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter {

	// @Inject
	private Pedidos pedidos;

	public PedidoConverter() {
		// Retorna uma instancia de um BeanCdi
		pedidos = CDIServiceLocator.getBean(Pedidos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = pedidos.buscarPorId(id);
		}
		
		return retorno;
	}

	/*
	 * Método recebe um objeto do tipo categoria e retorna um texto.
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pedido pedido = (Pedido) value;
			return pedido.getId() == null ? null : pedido.getId().toString();
		}
		
		return "";
	}

}
