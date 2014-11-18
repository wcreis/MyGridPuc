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
import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.entidade.MatrizDisciplinaId;
import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.negocio.DisciplinaService;
import br.com.mygridpuc.web.negocio.LocalService;
import br.com.mygridpuc.web.negocio.MatrizDisciplinaService;
import br.com.mygridpuc.web.negocio.MatrizService;
import br.com.mygridpuc.web.negocio.TurmaService;
import br.com.mygridpuc.web.util.Format;
import br.com.mygridpuc.web.util.MyGridPucException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Classe responsavel pela importação 
 * 
 * @author David Rodrigues
 *
 */
@ManagedBean
@ViewScoped
@Controller
public class ImportProgAcad {

	@Autowired
	private CursoService cursoService;
	@Autowired
	private DisciplinaService disciplinaService;
	@Autowired
	private MatrizService matrizService;
	@Autowired
	private MatrizDisciplinaService matrizDisciplinaService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private LocalService localService;

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
			FacesMessage message = new FacesMessage("O arquivo", file.getFileName() + ", foi recebido com Sucesso!!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		InputStream input = null;
		try {
			input = file.getInputstream();
		} catch (IOException e1) {
			FacesMessage message = new FacesMessage("Erro ao Converter o arquivo para InputStream!!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		importDisciplinas(input);

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

	public TurmaService getTurmaService() {
		return turmaService;
	}

	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	public LocalService getLocalService() {
		return localService;
	}

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}

	/**
	 * Inclui as disciplinas e os relacionamentos das Mesmas com as Matrizes, no banco de dados.
	 * @return
	 * @throws MyGridPucException 
	 */
	public void importDisciplinas(InputStream input) throws MyGridPucException{

		try {
			this.workbook = Workbook.getWorkbook(input);
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}

		Sheet plan1 = this.workbook.getSheet(0);

		int linhas = plan1.getRows();
		String codCurso = "";
		String strMmatriz="";
		String codDisciplina="";
		String codTurma="";
		Curso cursoSalvo = null;
		Matriz matrizSalva = null;
		Disciplina disciplinaSalva=null;
		Turma turmaSalva=null;

		for(int i=1; i<linhas;i++){

			Cell celCodCurso = plan1.getCell(0, i);//codCurso
			Cell celNomeCurso = plan1.getCell(1, i);//NomeCurso
			Cell celAnoMatriz = plan1.getCell(2, i);//Matriz
			Cell celPerDiscMatr = plan1.getCell(3, i);//PeriodoDisciplina
			Cell celCodDisciplina = plan1.getCell(4, i);//codDisciplina
			Cell celNomeDisciplina = plan1.getCell(5, i);//NomeDisciplina
			Cell celQtdeCreditos = plan1.getCell(6, i);//QtdeCreditos
			Cell celTurmaDisciplina = plan1.getCell(7, i);//Turma
			Cell celDiaSemana = plan1.getCell(8, i);//DiaSemana
			Cell celHorario = plan1.getCell(9, i);//Horario
			Cell celArea = plan1.getCell(10, i);//Área
			Cell celSala = plan1.getCell(11, i);//Sala
			Cell celBloco = plan1.getCell(12, i);//Bloco

			if((celCodCurso.getContents().compareToIgnoreCase(codCurso)!=0) || (getCursoService().consultar(codCurso)==null)){
				Curso curso = new Curso();
				curso.setCodigoCurso(celCodCurso.getContents());
				curso.setNomeCurso(celNomeCurso.getContents().toUpperCase());
				getCursoService().incluir(curso);
				cursoSalvo = getCursoService().consultar(curso.getCodigoCurso());
				codCurso = cursoSalvo.getCodigoCurso();
				if((celAnoMatriz.getContents().compareToIgnoreCase(strMmatriz)!=0)){
					Matriz matriz = new Matriz();
					matriz.setAnoSemestreMatriz(celAnoMatriz.getContents());
					matriz.setCurso(cursoSalvo);
					getMatrizService().incluir(matriz);
					matrizSalva = getMatrizService().consultarPorIdCursoAnoMatriz(cursoSalvo.getIdCurso(), celAnoMatriz.getContents());
					strMmatriz = matrizSalva.getAnoSemestreMatriz();
				}
			}else{
				if((celAnoMatriz.getContents().compareToIgnoreCase(strMmatriz)!=0)){
					Matriz matriz = new Matriz();
					matriz.setAnoSemestreMatriz(celAnoMatriz.getContents());
					matriz.setCurso(cursoSalvo);
					getMatrizService().incluir(matriz);
					matrizSalva = getMatrizService().consultarPorIdCursoAnoMatriz(cursoSalvo.getIdCurso(), celAnoMatriz.getContents());
					strMmatriz = matrizSalva.getAnoSemestreMatriz();
				}
			}
			if((celCodDisciplina.getContents().compareToIgnoreCase(codDisciplina)!=0)){
				Disciplina disciplina = new Disciplina();
				disciplina.setCodigo(celCodDisciplina.getContents());
				disciplina.setNome(celNomeDisciplina.getContents());
				disciplina.setCredito(Integer.parseInt(celQtdeCreditos.getContents()));
				codDisciplina = celCodDisciplina.getContents();
				try {
					if(getDisciplinaService().consultar(disciplina.getCodigo())==null){
						disciplinaSalva = getDisciplinaService().incluir(disciplina);
					}else{
						disciplinaSalva = getDisciplinaService().consultar(disciplina.getCodigo());
					}

					MatrizDisciplinaId mdId = new MatrizDisciplinaId();
					mdId.setIdDisciplina(disciplinaSalva.getIdDisciplina());
					mdId.setIdMatriz(matrizSalva.getIdMatriz());

					MatrizDisciplina md = new MatrizDisciplina();
					md.setIdMatrizDisciplina(mdId);
					md.setPeriodo(Integer.parseInt(celPerDiscMatr.getContents()));
					getMatrizDisciplinaService().incluir(md);
				} catch (MyGridPucException e) {
					FacesMessage message = new FacesMessage("Erro ao Gravar a Disciplina!!!");
					FacesContext.getCurrentInstance().addMessage(null, message);
					System.out.println("Erro ao Gravar a Disciplina!!!");
				}

			}
			if((celTurmaDisciplina.getContents().compareToIgnoreCase(codTurma)!=0)){
				Turma turma = new Turma();
				turma.setCodTurma(celTurmaDisciplina.getContents());
				turma.setDisciplina(disciplinaSalva);
				getTurmaService().incluir(turma);
				turmaSalva = getTurmaService().consultarPorIdDisciplinaETurma(disciplinaSalva.getIdDisciplina(), turma.getCodTurma());
				codTurma = celTurmaDisciplina.getContents();
				

				Local local = new Local();
				local.setArea(Integer.parseInt(celArea.getContents()));
				local.setBloco(celBloco.getContents());
				local.setDia_semana(Format.strDiaSemanaToInt(celDiaSemana.getContents()));

				String strHorarios[] = celHorario.getContents().split("-");
				local.setHora_ini(strHorarios[0]);
				local.setHora_fim(strHorarios[1]);

				local.setSala(Integer.parseInt(celSala.getContents()));

				local.setTurma(turmaSalva);

				getLocalService().incluir(local);
			}else{
				Local local = new Local();
				local.setArea(Integer.parseInt(celArea.getContents()));
				local.setBloco(celBloco.getContents());
				local.setDia_semana(Format.strDiaSemanaToInt(celDiaSemana.getContents()));

				String strHorarios[] = celHorario.getContents().split("-");
				local.setHora_ini(strHorarios[0]);
				local.setHora_fim(strHorarios[1]);

				local.setSala(Integer.parseInt(celSala.getContents()));

				local.setTurma(turmaSalva);

				getLocalService().incluir(local);
			}
		}
		FacesMessage message = new FacesMessage("Fim da Importação!!!\nTodos os dados Inseridos no Banco de Dados com Sucesso!!!");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
