/*
 * INICIO - validações de listar curso
 */

//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio){
	var formulario = document.getElementById('formulario');
	var campo;
	for(var item=0; item<formulario.length; item++){
    	campo = formulario[item];
        if(campo.type=='radio' && campo.name!=radio.name){    
        	campo.checked = false;
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
	var formulario = document.getElementById('formulario');
	var campo;
	for(var item=0; item<formulario.length; item++){
    	campo = formulario[item];
        if(campo.type=='radio' && campo.checked){    
        	return true;
    	}
    }
    alert('ï¿½ necessï¿½rio selecionar um item da lista.');
    return false;
}

//valida o formulario
function validarFormulario(){
	alert('a');
	var formulario = document.getElementById('formulario');
	if(formulario.nome.value.lenght()<0){
		alert('O campo nome deve ser preenchido').
		formulario.nome.focus();
		return false;
	}
	
	return true;
}

/*
 * FIM - validações de listar curso
 */

/*
 * INICIO - validações de editar curso
 */
//valida o formulario
function validarFormulario(){
	var campoNome = document.getElementById('formulario:nome');
	var campoDescricao = document.getElementById('formulario:descricao');
	
	if(campoNome.value.length==0 || campoDescricao.value.length==0){
		alert('O campo nome ou descricao deve ser preenchido.');
		campoNome.focus();
		return false;
	}
	
	return true;
}

function fctValidaData(obj){
    var data = obj.value;
    var dia = data.substring(0,2);
    var mes = data.substring(3,5);
    var ano = data.substring(6,10);
    
    //Criando um objeto Date usando os valores ano, mes e dia.
    var dataDigitada = new Date(ano,(mes-1),dia);
 
    var mesmoDia = parseInt(dia,10) == parseInt(dataDigitada.getDate());
    var mesmoMes = parseInt(mes,10) == parseInt(dataDigitada.getMonth())+1;
    var mesmoAno = parseInt(ano) == parseInt(dataDigitada.getFullYear());
 
    if (!((mesmoDia) && (mesmoMes) && (mesmoAno))){
        alert('Data Validade é invalida! Tente Novamente\nFORMATO DA DATA(DD/MM/AAAA)'); 
        obj.focus();   
        return false;                            
    } 
    
    if(dataDigitada.getTime() < new Date().getTime()){
    	alert("Data de Validade não pode ser MENOR ou IGUAL a Atual");
    	form.dtNascimento.value = "";
    	obj.focus();  
    	return false;
    }
    
    return true;
}
/*
 * FIM - validações de editar curso
 */

/*
 * INICIO - validações de criar curso
 */
function validarFormulario(){
	var campoNome = document.getElementById('formulario:nome');
	var campoDescricao = document.getElementById('formulario:descricao');
	
	if(campoNome.value.length==0 || campoDescricao.value.length==0){
		alert('O campo nome ou descricao deve ser preenchido.');
		campoNome.focus();
		return false;
	}
	
	return true;
}

function fctValidaData(obj){
    var data = obj.value;
    var dia = data.substring(0,2);
    var mes = data.substring(3,5);
    var ano = data.substring(6,10);
    
    //Criando um objeto Date usando os valores ano, mes e dia.
    var dataDigitada = new Date(ano,(mes-1),dia);
 
    var mesmoDia = parseInt(dia,10) == parseInt(dataDigitada.getDate());
    var mesmoMes = parseInt(mes,10) == parseInt(dataDigitada.getMonth())+1;
    var mesmoAno = parseInt(ano) == parseInt(dataDigitada.getFullYear());
 
    if (!((mesmoDia) && (mesmoMes) && (mesmoAno))){
        alert('Data Validade é invalida! Tente Novamente\nFORMATO DA DATA(DD/MM/AAAA)'); 
        obj.focus();   
        return false;                            
    } 
    
    if(dataDigitada.getTime() < new Date().getTime()){
    	alert("Data de Validade não pode ser MENOR ou IGUAL a Atual");
    	form.dtNascimento.value = "";
    	obj.focus();  
    	return false;
    }
    
    return true;
}
/*
 * FIM - validações de criar curso
 */

