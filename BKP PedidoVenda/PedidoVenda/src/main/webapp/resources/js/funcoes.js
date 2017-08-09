/**
 * @author Alves Funções JavaScript para o sistema Pedido e Venda
 */

/*
 * Função que permite a configuração de mascara contábil
 * http://plentz.github.io/jquery-maskmoney/
 */
function configurarMoeda() {
	$(".moeda").maskMoney({
		decimal : ",",
		thousands : ".",
		allowZero : true
	});
}

$(document).ready(function() {
	configurarMoeda();
});