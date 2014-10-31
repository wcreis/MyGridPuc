package br.com.mygridpuc.web.persistencia;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Usuario;

/**
 * Classe que define as operacoes da camada de persistencia de UsuarioCurso
 * @author Wesley Reis
 *
 */
@Repository
public class UsuarioDAOImpl extends GenericoDAOImpl<Usuario, Integer> implements UsuarioDAO{

}
