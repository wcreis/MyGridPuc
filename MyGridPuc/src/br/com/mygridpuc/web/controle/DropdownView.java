package br.com.mygridpuc.web.controle;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.negocio.MatrizService;
import br.com.mygridpuc.web.negocio.PeriodoService;
import br.com.mygridpuc.web.util.MyGridPucException;


@RequestScoped
@Controller
public class DropdownView implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6690525261613611937L;
	
	
	
	private Map<String,CursoBeanDropDown> mapCursos;
	
	private Map<String,MatrizBean> mapMatrizes;
	
	private Map<CursoBeanDropDown,Map<String,MatrizBean>> dataMatriz = new HashMap<CursoBeanDropDown, Map<String,MatrizBean>>();
	
	private Map<String,PeriodoBean> mapPeriodos;
	
	private Map<MatrizBean,Map<String,PeriodoBean>> dataPeriodo = new HashMap<MatrizBean, Map<String,PeriodoBean>>();

	//-------------Cursos
	@Autowired
	private CursoBeanDropDown cursoBeanDropDown;
	
	private List<CursoBeanDropDown> listCursoBeanDropDown;
	@Autowired
	private CursoService cursoService;	
	//-------------Matrizes
	@Autowired
	private MatrizBean matrizBean  = new MatrizBean();
	
	@SuppressWarnings("unused")
	private List<MatrizBean> listMatrizBean;
	@Autowired
	private MatrizService matrizService;
	//-------------Periodos
	@Autowired
	private PeriodoBean periodoBean = new PeriodoBean();
	@Autowired
	private List<PeriodoBean> listPeriodoBean;
	@Autowired
	private PeriodoService periodoService;

	@PostConstruct
	public void init() {
		/**
		countries  = new HashMap<String, String>();
		countries.put("USA", "USA");
		countries.put("Germany", "Germany");
		countries.put("Brazil", "Brazil");

		Map<String,String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
		data.put("USA", map);

		map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
		data.put("Germany", map);

		map = new HashMap<String, String>();
		map.put("Sao Paolo", "Sao Paolo");
		map.put("Rio de Janerio", "Rio de Janerio");
		map.put("Salvador", "Salvador");
		data.put("Brazil", map);
		 */
		/*
		 * Primeiro Localiza-se o Curso, depois carrega as Matrizes, depois os Periodos e Por
		 * Fim as Disciplinas por
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
				System.out.println(curso.getNomeCurso());
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

	public Map<CursoBeanDropDown, Map<String, MatrizBean>> getData() {
		return dataMatriz;
	}

	public void onLimparChange(){
		cursoBeanDropDown = new CursoBeanDropDown();
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


	public void displayLocation() {
		/**
		FacesMessage msg;
		
		if(city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 

		FacesContext.getCurrentInstance().addMessage(null, msg); 
		*/ 
		
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public MatrizService getMatrizService() {
		return matrizService;
	}

	public void setMatrizService(MatrizService matrizService) {
		this.matrizService = matrizService;
	}

	public PeriodoService getPeriodoService() {
		return periodoService;
	}

	public void setPeriodoService(PeriodoService periodoService) {
		this.periodoService = periodoService;
	}

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



	public List<CursoBeanDropDown> getListCursoBeanDropDown() {
		
		return listCursoBeanDropDown;
	}

	public void setListMatrizBean(List<MatrizBean> listMatrizBean) {
		this.listMatrizBean = listMatrizBean;
	}

	public List<PeriodoBean> getListPeriodoBean() {
		return listPeriodoBean;
	}

	public void setListPeriodoBean(List<PeriodoBean> listPeriodoBean) {
		this.listPeriodoBean = listPeriodoBean;
	}


	public CursoBeanDropDown getCursoBeanDropDown() {
		return cursoBeanDropDown;
	}

	public void setCursoBeanDropDown(CursoBeanDropDown cursoBean) {
		this.cursoBeanDropDown = cursoBean;
	}

	public MatrizBean getMatrizBean() {
		return matrizBean;
	}

	public void setMatrizBean(MatrizBean matrizBean) {
		this.matrizBean = matrizBean;
	}

	public PeriodoBean getPeriodoBean() {
		return periodoBean;
	}

	public void setPeriodoBean(PeriodoBean periodoBean) {
		this.periodoBean = periodoBean;
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

	public Map<String, PeriodoBean> getMapPeriodos() {
		return mapPeriodos;
	}

	public void setMapPeriodos(Map<String, PeriodoBean> mapPeriodos) {
		this.mapPeriodos = mapPeriodos;
	}
	
	
	

}