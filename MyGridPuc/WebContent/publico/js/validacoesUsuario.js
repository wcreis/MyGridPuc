//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio){
	var formularioUsuario = document.getElementById('formularioUsuario');
	var campo;
	for(var item=0; item<formularioUsuario.length; item++){
    	campo = formularioUsuario[item];
        if(campo.type=='radio' && campo.name!=radio.name){    
        	campo.checked = false;
    	}
    }
}

//Limpa todos os Campos do Formulario
function limpaForm(){
	var formularioUsuario = document.getElementById('formularioUsuario');
	var campo;
	for(var item=0; item<formularioUsuario.length; item++){
    	campo = formularioUsuario[item];
        if(campo.type=='radio'){    
        	campo.checked = false;
    	}
        if(campo.type=='text'){    
        	campo.value = "";
    	}

    }
}

//armazena o identificador do item escolhido
function selecionarItem(campoHidden,radioSelecionado){
	document.getElementById(campoHidden).value = radioSelecionado.value;
	desmarcar(radioSelecionado);
}

//verifica se algum item esta selecionado
function validarSelecionado(){
	var formularioUsuario = document.getElementById('formularioUsuario');
	var campo;
	
	for(var item=0; item<formularioUsuario.length; item++){
    	campo = formularioUsuario[item];
        if(campo.type=='radio' && campo.checked){
        	return true;
    	}
    }
    alert('É Necessario selecinar um item da Tela!!!');
    return false;
}

//valida o formularioUsuario
function validarFormulario(){
	
	var formularioUsuario = document.getElementById('formularioUsuario');
	if(formularioUsuario.email.value.lenght()<0){
		alert('O campo E-mail deve ser preenchido').
		formularioUsuario.nome.focus();
		return false;
	}
	
	return true;
}


function retornaIdUsuario(){
	return document.getElementById('formularioUsuario:idUsuario').value;
}