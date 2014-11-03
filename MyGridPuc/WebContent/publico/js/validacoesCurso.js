// INICIO - validações de listar curso

//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio) {
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item = 0; item < formulario.length; item++) {
		campo = formulario[item];
		if (campo.type == 'radio' && campo.name != radio.name) {
			campo.checked = false;
		}
	}
}

// armazena o identificador do item escolhido
function selecionarItem(campoHidden, radioSelecionado) {
	document.getElementById(campoHidden).value = radioSelecionado.value;
	desmarcar(radioSelecionado);
}

// verifica se algum item esta selecionado
function validarSelecionado() {
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item = 0; item < formulario.length; item++) {
		campo = formulario[item];
		if (campo.type == 'radio' && campo.checked) {
			return true;
		}
	}
	alert('É necessário selecionar um item da lista.');
	return false;
}


function onlyNumber(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}

function tableIsEmpty(){
	var table = document.getElementById('formprincipal:formulario:matriz:0:idAnoSemestre');
	if(table == null){
		alert("É preciso adicionar pelo menos um ano/semestre!!!");
		return false;
	}
	return true;
}
// valida o formulario
/*
 * function validarFormulario(){ alert('a'); var formulario =
 * document.getElementById('formulario'); if(formulario.nome.value.lenght()<0){
 * alert('O campo nome deve ser preenchido'). formulario.nome.focus(); return
 * false; }
 * 
 * return true; }
 */

// FIM - validações de listar curso

// INICIO - validações de editar curso
// valida o formulario
/*
 * function validarFormulario(){ var campoNome =
 * document.getElementById('formulario:nome'); var campoDescricao =
 * document.getElementById('formulario:descricao');
 * 
 * if(campoNome.value.length==0 || campoDescricao.value.length==0){ alert('O
 * campo nome ou descricao deve ser preenchido.'); campoNome.focus(); return
 * false; }
 * 
 * return true; }
 */

// FIM - validações de editar curso
// INICIO - validações de criar curso
/*
 * function validarFormulario(){ var campoNome =
 * document.getElementById('formulario:nome'); var campoDescricao =
 * document.getElementById('formulario:descricao');
 * 
 * if(campoNome.value.length==0 || campoDescricao.value.length==0){ alert('O
 * campo nome ou descricao deve ser preenchido.'); campoNome.focus(); return
 * false; }
 * 
 * return true; }
 */

// FIM - validações de criar curso
