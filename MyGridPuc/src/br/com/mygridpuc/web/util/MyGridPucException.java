/**
 * 
 */
package br.com.mygridpuc.web.util;

/**
 * Classe responsavel pelas exceções.
 * 
 * @author DavidRodrigues
 *
 */
public class MyGridPucException extends Exception {
	private static final long serialVersionUID = 8479561261834501637L;
	private Exception ex;
	private String msg;

	/**
	 * Método com exceção padrão
	 * 
	 * @param e
	 */
	public MyGridPucException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	/**
	 * Método com exceção e mensagem editavel
	 * 
	 * @param e
	 * @param mensagem
	 */
	public MyGridPucException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
}
