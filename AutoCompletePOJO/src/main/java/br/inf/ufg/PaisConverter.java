package br.inf.ufg;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("pais")
public class PaisConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		Integer codigo = null;
		try {
			codigo = Integer.valueOf(arg2);
		} catch (NumberFormatException e){}
		
		if(arg2 != null) {
			for (Pais pais : PerfilUsuarioBean.PAISES) {
				
				if (codigo.equals(pais.getCodigo())) {
				
					return pais;
				}
			}
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 != null && !arg2.equals("")){
			Pais pais = (Pais) arg2;
			return String.valueOf(pais.getCodigo());
			
		}
		return null;
	}
	
	
}
