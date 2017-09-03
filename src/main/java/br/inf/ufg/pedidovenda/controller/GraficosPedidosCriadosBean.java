package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.inf.ufg.pedidovenda.model.Usuario;
import br.inf.ufg.pedidovenda.repository.Pedidos;
import br.inf.ufg.pedidovenda.security.UsuarioSistema;
import br.inf.ufg.pedidovenda.validation.UsuarioLogado;

@Named
@RequestScoped
public class GraficosPedidosCriadosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");
	
	@Inject
	private Pedidos pedidos;
	@Inject 
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;
	
	private CartesianChartModel model;
	
	public void preRender() {
		this.model = new CartesianChartModel();
		
		adicionarSerie("Todos os pedidos", null);
		adicionarSerie("Meus pedidos",  usuarioLogado.getUsuario());
		
	}

	private void adicionarSerie(String rotulo, Usuario criadoPor) {
		
		Map<Date, BigDecimal> valoresPorData = this.pedidos.valoresTotaisPorData(15, criadoPor);
		
		ChartSeries series = new ChartSeries(rotulo);
		
		for(Date data: valoresPorData.keySet()) {
			
			series.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}
		
		
		this.model.addSeries(series);
	}

	public CartesianChartModel getModel() {
		return model;
	}


	
	
}
