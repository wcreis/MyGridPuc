package br.com.mygridpuc.web.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.negocio.DisciplinaService;
import br.com.mygridpuc.web.negocio.MatrizDisciplinaService;
import br.com.mygridpuc.web.negocio.MatrizService;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe responsavel pela matriz view
 * 
 * @author David Rodrigues
 *
 */
@ManagedBean(name="controlerMatriz")
@RequestScoped
@Controller
public class MatrizDropDownView implements Serializable {
	private static final long serialVersionUID = 6690525261613611937L;
	
	private Map<String,CursoBeanDropDown> mapCursos;
	
	private Map<String,MatrizBean> mapMatrizes;
	
	private Map<CursoBeanDropDown,Map<String,MatrizBean>> dataMatriz = new HashMap<CursoBeanDropDown, Map<String,MatrizBean>>();
	
	private Map<String,MatrizDisciplinaBean> mapMatrizDisciplinas;
	
	private Map<MatrizBean,Map<String,MatrizDisciplinaBean>> dataPeriodo = new HashMap<MatrizBean, Map<String,MatrizDisciplinaBean>>();

	//-------------Cursos
	@Autowired
	private CursoBeanDropDown cursoBeanDropDown;
	@Autowired
	private List<CursoBeanDropDown> listCursoBeanDropDown;
	@Autowired
	private CursoService cursoService;	
	//-------------Matrizes
	@Autowired
	private MatrizBean matrizBean  = new MatrizBean();
	@Autowired
	private List<MatrizBean> listMatrizBean;
	@Autowired
	private MatrizService matrizService;
	//-------------MatrizDisciplina
	@Autowired
	private MatrizDisciplinaBean matrizDisciplinaBean = new MatrizDisciplinaBean();
	@Autowired
	private List<MatrizDisciplinaBean> listMatrizDisciplinaBean;
	@Autowired
	private MatrizDisciplinaService matrizDisciplinaService;
	
	//-------------Disciplinas
	@Autowired
	private DisciplinaBean disciplinaBean = new DisciplinaBean();
	@Autowired
	private List<DisciplinaBean> listDisciplinaBean;
	@Autowired
	private DisciplinaService disciplinaService;

	@PostConstruct
	public void init() {

		/*
		 * Primeiro Localiza-se o Curso, depois carrega as Matrizes, depois os Periodos e Por
		 * Fim as Disciplinas por periodo
		 */
		List<Curso> listCursos = new ArrayList<>();
		try{
			listCursos = getCursoService().listar();
			if(listCursos == null || listCursos.size() == 0){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nada no Banco de Dados", "Nenhum registro encontrado."); 
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
			mapCursos = new HashMap<>();
			//preenche a lista de cursos na tela
			listCursoBeanDropDown = new ArrayList<CursoBeanDropDown>();
			for(Curso curso: listCursos){
				//System.out.println(curso.getNomeCurso());
				CursoBeanDropDown cursoBean = new CursoBeanDropDown();
				cursoBean.setId(curso.getIdCurso());
				cursoBean.setNomeCurso(curso.getNomeCurso());
				
				mapCursos.put(cursoBean.getNomeCurso(), cursoBean);
				listCursoBeanDropDown.add(cursoBean);
				
			}
			
		}catch(Exception e){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Banco de Dados", "Erro ao Recuperar as Informações no Banco de Dados."); 
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void onLimparChange(){
		cursoBeanDropDown = new CursoBeanDropDown();
		listMatrizBean = new ArrayList<MatrizBean>();
		matrizBean = new MatrizBean();
		listMatrizDisciplinaBean = new ArrayList<MatrizDisciplinaBean>();
		mapMatrizes = new HashMap<String, MatrizBean>();
		init();
	}
	
	public void onCursoChange() throws MyGridPucException {
		
		getListMatrizBean(cursoBeanDropDown);
		
		if(cursoBeanDropDown !=null && !cursoBeanDropDown.equals(""))
			mapMatrizes = dataMatriz.get(cursoBeanDropDown);
		else
			mapMatrizes = new HashMap<String, MatrizBean>();
	}

	public void onMatrizChange() throws MyGridPucException {
		
		getListMatrizDisciplinaBean(matrizBean);
		
		if(matrizBean !=null && !matrizBean.equals(""))
			mapMatrizDisciplinas = dataPeriodo.get(matrizBean);
		else
			mapMatrizDisciplinas = new HashMap<String, MatrizDisciplinaBean>();
	}
	
	/*List de Beans*/
	public void getListMatrizBean(CursoBeanDropDown cursoBean) throws MyGridPucException {
		
		cursoBean.setListMatriz(new ArrayList<MatrizBean>());
		mapMatrizes = new HashMap<>();

		List<Matriz> listMatriz = new ArrayList<>();
		listMatriz = getMatrizService().listar(cursoBean.getId());
		for(Matriz matriz : listMatriz){
			MatrizBean matrizBean = new MatrizBean();
			matrizBean.setId(matriz.getIdMatriz());
			matrizBean.setAnoSemestreMatriz(matriz.getAnoSemestreMatriz());
			
			cursoBean.getListMatriz().add(matrizBean);
			mapMatrizes.put(matrizBean.getAnoSemestreMatriz(), matrizBean);
		}
		dataMatriz.put(cursoBean, mapMatrizes);

	}

	public void getListMatrizDisciplinaBean(MatrizBean matrizBean) throws MyGridPucException {
		
		matrizBean.setListMatrizDisciplina(new ArrayList<MatrizDisciplinaBean>());
		mapMatrizDisciplinas = new HashMap<String, MatrizDisciplinaBean>();
		listMatrizDisciplinaBean = new ArrayList<>();
		
		List<MatrizDisciplina> listMatrizDisciplina = new ArrayList<>();
		listMatrizDisciplina = getMatrizDisciplinaService().listarPorMatriz(matrizBean.getId());
		
		
		for(MatrizDisciplina matrizDisciplina : listMatrizDisciplina){
			MatrizDisciplinaBean mdBean = new MatrizDisciplinaBean();
			mdBean.setPeriodo(matrizDisciplina.getPeriodo());
			DisciplinaBean discBean = new DisciplinaBean();
			discBean.setId(matrizDisciplina.getDisciplina().getIdDisciplina());
			discBean.setCodigo(matrizDisciplina.getDisciplina().getCodigo());
			discBean.setNome(matrizDisciplina.getDisciplina().getNome());
			discBean.setCredito(matrizDisciplina.getDisciplina().getCredito());
			mdBean.setDisciplinaBean(discBean);
			listMatrizDisciplinaBean.add(mdBean);
			mapMatrizDisciplinas.put(""+mdBean.getPeriodo(), mdBean);

		}
		
	}

	public List<CursoBeanDropDown> getListCursoBeanDropDown() {
		
		return listCursoBeanDropDown;
	}

	public List<DisciplinaBean> getListDisciplinaBean() {
		return listDisciplinaBean;
	}

	public void setListDisciplinaBean(List<DisciplinaBean> listDisciplinaBean) {
		this.listDisciplinaBean = listDisciplinaBean;
	}

	public void setListMatrizBean(List<MatrizBean> listMatrizBean) {
		this.listMatrizBean = listMatrizBean;
	}

	public List<MatrizDisciplinaBean> getListMatrizDisciplinaBean() {
		Collections.sort(listMatrizDisciplinaBean);
		return listMatrizDisciplinaBean;
	}

	public void setListMatrizDisciplinaBean(List<MatrizDisciplinaBean> listMatrizDiciplinaBean) {
		this.listMatrizDisciplinaBean = listMatrizDiciplinaBean;
	}

	/*Beans*/
	public CursoBeanDropDown getCursoBeanDropDown() {
		return cursoBeanDropDown;
	}

	public void setCursoBeanDropDown(CursoBeanDropDown cursoBean) {
		this.cursoBeanDropDown = cursoBean;
	}

	public DisciplinaBean getDisciplinaBean() {
		return disciplinaBean;
	}

	public void setDisciplinaBean(DisciplinaBean disciplinaBean) {
		this.disciplinaBean = disciplinaBean;
	}

	public MatrizBean getMatrizBean() {
		return matrizBean;
	}

	public void setMatrizBean(MatrizBean matrizBean) {
		this.matrizBean = matrizBean;
	}

	public MatrizDisciplinaBean getPeriodoBean() {
		return matrizDisciplinaBean;
	}

	public void setPeriodoBean(MatrizDisciplinaBean periodoBean) {
		this.matrizDisciplinaBean = periodoBean;
	}
	
	/*Maps*/
	
	public Map<CursoBeanDropDown, Map<String, MatrizBean>> getData() {
		return dataMatriz;
	}

	public Map<String, CursoBeanDropDown> getMapCursos() {
		return mapCursos;
	}

	public void setMapCursos(Map<String, CursoBeanDropDown> mapCursos) {
		this.mapCursos = mapCursos;
	}

	public Map<String, MatrizBean> getMapMatrizes() {
		return mapMatrizes;
	}

	public void setMapMatrizes(Map<String, MatrizBean> mapMatrizes) {
		this.mapMatrizes = mapMatrizes;
	}

	public Map<String, MatrizDisciplinaBean> getMapPeriodos() {
		return mapMatrizDisciplinas;
	}

	public void setMapPeriodos(Map<String, MatrizDisciplinaBean> mapPeriodos) {
		this.mapMatrizDisciplinas = mapPeriodos;
	}
	
		/*Classes de Serviços*/
	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
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

	public void setMatrizDisciplinaService(MatrizDisciplinaService matrizDisciplinaService) {
		this.matrizDisciplinaService = matrizDisciplinaService;
	}
	

}