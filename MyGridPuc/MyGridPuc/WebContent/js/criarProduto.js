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