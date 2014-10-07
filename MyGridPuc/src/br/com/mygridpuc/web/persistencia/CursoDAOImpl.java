package br.com.mygridpuc.web.persistencia;

import org.springframework.stereotype.Repository;
import br.com.mygridpuc.web.entidade.Curso;

/**
 * Classe que define as operacoes da camada de persistencia de Curso
 * @author David Rodrigues
 *
 */
@Repository
public class CursoDAOImpl extends GenericoDAOImpl<Curso, Integer> implements CursoDAO{

}
