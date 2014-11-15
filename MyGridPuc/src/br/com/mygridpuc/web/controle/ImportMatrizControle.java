package br.com.mygridpuc.web.controle;

import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.entidade.MatrizDisciplinaId;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.negocio.DisciplinaService;
import br.com.mygridpuc.web.negocio.MatrizDisciplinaService;
import br.com.mygridpuc.web.negocio.MatrizService;
import br.com.mygridpuc.web.util.MyGridPucException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@ManagedBean
@ViewScoped
@Controller
public class ImportMatrizControle {

	@Autowired
	private CursoService cursoService;
	@Autowired
	private DisciplinaService disciplinaService;
	@Autowired
	private MatrizService matrizService;
	@Autowired
	private MatrizDisciplinaService matrizDisciplinaService;

	private Workbook workbook;

	private UploadedFile file;

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() throws MyGridPucException {
		if(file != null) {
			FacesMessage message = new FacesMessage();
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		InputStream input = null;
		try {
			input = file.getInputstream();
		} catch (IOException e1) {
			System.out.println("Erro ao Converter de UploadedFile para InputStream!!!");
		}
		if(importDisciplinas(input)){
			FacesMessage message = new FacesMessage("Dados Importados da Planilha: ", file.getFileName() + ", com Sucesso!!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public DisciplinaService getDisciplinaService() {
		return disciplinaService;
	}

	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	public MatrizService getMatrizService() {
		return matrizService;
	}

	public void setMatrizService(MatrizService matrizService) {
		this.matrizService = matrizService;
	}

	public MatrizDisciplinaService getMatrizDisciplinaService() {
		return matrizDisciplinaService;
	}

	public void setMatrizDisciplinaService(
			MatrizDisciplinaService matrizDisciplinaService) {
		this.matrizDisciplinaService = matrizDisciplinaService;
	}

	/**
	 * Inclui as disciplinas e os relacionamentos das Mesmas com as Matrizes, no banco de dados.
	 * @return
	 * @throws MyGridPucException 
	 */
	public Boolean importDisciplinas(InputStream input) throws MyGridPucException{

		try {
			this.workbook = Workbook.getWorkbook(input);
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
			return false;
		}

		for(int j=0;j<3;j++){
			Sheet sheetCurso = this.workbook.getSheet(j);
			Curso curso = getCursoService().consultar((j+1));

			System.out.println(curso.getNomeCurso());
			Matriz matriz = getMatrizService().listar(j+1).get(0);
			System.out.println(matriz.getAnoSemestreMatriz());
			int linhas = sheetCurso.getRows();
			System.out.println(linhas);
			for(int i = 1; i < linhas;i++){

				Cell celula1 = sheetCurso.getCell(0, i);//Periodo

				Cell celula2 = sheetCurso.getCell(1, i);//codDisciplina

				Cell celula3 = sheetCurso.getCell(2, i);//Nome Disciplina

				Cell celula4 = sheetCurso.getCell(3, i);//Qtde Creditos

				Disciplina disciplina = new Disciplina();
				disciplina.setCodigo(celula2.getContents().toUpperCase());
				disciplina.setNome(celula3.getContents().toUpperCase());
				disciplina.setCredito(Integer.parseInt(celula4.getContents()));


				try {
					Disciplina disciplinaSalva=null;
					if(getDisciplinaService().consultar(disciplina.getCodigo())==null){
						disciplinaSalva = getDisciplinaService().incluir(disciplina);
					}else{
						disciplinaSalva = getDisciplinaService().consultar(disciplina.getCodigo());
					}

					MatrizDisciplinaId mdId = new MatrizDisciplinaId();
					mdId.setIdDisciplina(disciplinaSalva.getIdDisciplina());
					mdId.setIdMatriz(matriz.getIdMatriz());

					MatrizDisciplina md = new MatrizDisciplina();
					md.setIdMatrizDisciplina(mdId);
					md.setPeriodo(Integer.parseInt(celula1.getContents()));
					getMatrizDisciplinaService().incluir(md);

				} catch (MyGridPucException e) {
					FacesMessage message = new FacesMessage("Erro ao Gravar a Disciplina!!!");
					FacesContext.getCurrentInstance().addMessage(null, message);
					System.out.println("Erro ao Gravar a Disciplina!!!");
					return false;
				}

			}
			FacesMessage message = new FacesMessage("Fim da Inclusão das Discplinas do Curso: \n"+curso.getNomeCurso()+".");
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("Fim da Inclusão das Discplinas \ndo Curso: "+curso.getNomeCurso());

		}return true;
	}
}
