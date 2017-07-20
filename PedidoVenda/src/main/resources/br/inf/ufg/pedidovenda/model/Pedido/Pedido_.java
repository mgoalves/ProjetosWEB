package br.inf.ufg.pedidovenda.model.Pedido;

import br.inf.ufg.pedidovenda.model.Usuario;
import br.inf.ufg.pedidovenda.model.cliente.Cliente;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-07-20T09:07:11.668-0300")
@StaticMetamodel(Pedido.class)
public class Pedido_ {
	public static volatile SingularAttribute<Pedido, Long> id;
	public static volatile SingularAttribute<Pedido, Date> dataCriacao;
	public static volatile SingularAttribute<Pedido, String> Observacao;
	public static volatile SingularAttribute<Pedido, Date> dataEntrega;
	public static volatile SingularAttribute<Pedido, BigDecimal> valorFrete;
	public static volatile SingularAttribute<Pedido, BigDecimal> valorDesconto;
	public static volatile SingularAttribute<Pedido, BigDecimal> valorTotal;
	public static volatile SingularAttribute<Pedido, StatusPedido> status;
	public static volatile SingularAttribute<Pedido, FormaPagamento> formaPagamento;
	public static volatile SingularAttribute<Pedido, Usuario> vendedor;
	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile SingularAttribute<Pedido, EnderecoEntrega> enderecoEntrega;
}
