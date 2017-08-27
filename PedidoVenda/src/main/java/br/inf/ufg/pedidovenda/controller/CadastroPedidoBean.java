package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.inf.ufg.pedidovenda.model.Usuario;
import br.inf.ufg.pedidovenda.model.cliente.Cliente;
import br.inf.ufg.pedidovenda.model.pedido.EnderecoEntrega;
import br.inf.ufg.pedidovenda.model.pedido.FormaPagamento;
import br.inf.ufg.pedidovenda.model.pedido.ItemPedido;
import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.Clientes;
import br.inf.ufg.pedidovenda.repository.Produtos;
import br.inf.ufg.pedidovenda.repository.Usuarios;
import br.inf.ufg.pedidovenda.service.CadastroPedidoService;
import br.inf.ufg.pedidovenda.util.jsf.FacesUtil;
import br.inf.ufg.pedidovenda.validation.PedidoEdicao;
import br.inf.ufg.pedidovenda.validation.SKU;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Injeções ========================================================
	@Inject
	private Usuarios usuarios;
	@Inject
	private Clientes clientes;
	@Inject
	private CadastroPedidoService cadService;
	@Inject
	private Produtos produtos;

	// Variaveis ---------------------------------------------------------
	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private List<Usuario> vendedores;
	private Produto produtoLinhaEditavel;
	private String sku;

	// Construtor da Classe
	public CadastroPedidoBean() {

		limpar();
	}

	public void limpar() {

		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		sku = null;
	}
	
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		
		this.pedido = event.getPedido();
	}

	public void salvar() {

		this.pedido.removerItemVazio();
		
		try {
			
			this.pedido = this.cadService.salvar(this.pedido);
			FacesUtil.addInfoMessage("Pedido salvo com sucesso.");
			
		} finally {
			
			this.pedido.adicionarItemVazio();
		}
		
	}

	public void inicializar() {

		if (FacesUtil.isPostNotBack()) {

			this.pedido.adicionarItemVazio();
			this.vendedores = this.usuarios.buscarPorNome();
			this.pedido.recalcularValorTotal();
		}
	}

	// Atualiza na página as formas de Pagamento disponiveis
	public FormaPagamento[] getFormasPagamento() {

		return FormaPagamento.values();
	}

	// Busca do banco a lista de clientes para exibição na página
	public List<Cliente> completarCliente(String nome) {
		return this.clientes.buscarPorNome(nome);
	}

	// Método que verifica se existe algum pedido instanciado ou não para
	// cadastro ou edição
	public boolean isEditando() {

		return this.pedido.getId() == null;
	}

	// Método que recalcula o valor do Total baseado no frete e desconto.
	public void recalcularPedido() {

		if (this.pedido != null) {

			this.pedido.recalcularValorTotal();
		}
	}

	// Método que auto completa os produtos Digitados pelo usuário.
	public List<Produto> completarProduto(String nome) {

		return this.produtos.buscarPorNome(nome);
	}

	//
	public void carregarProdutoLinhaEditavel() {

		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {

			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {

				FacesUtil.addErrorMessage("Já existe um item no pedido com o produto informado.");
			} else {

				item.setProduto(produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;

				this.pedido.recalcularValorTotal();
			}
		}
	}

	private boolean existeItemComProduto(Produto produto) {

		boolean existeItem = false;
		
		for (ItemPedido item : this.getPedido().getItens()) {
			
			if(produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}				
		}
		
		return existeItem;
	}

	public void carregarPorSku() {

		if (StringUtils.isNotEmpty(this.sku)) {

			this.produtoLinhaEditavel = this.produtos.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha) {
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		
		this.pedido.recalcularValorTotal();
	}

	// Getter and Setters
	// =========================================================================
	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
