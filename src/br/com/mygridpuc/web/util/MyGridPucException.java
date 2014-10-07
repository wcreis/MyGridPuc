/**
 * 
 */
package br.com.mygridpuc.web.util;

/**
 * @author DavidRodrigues
 *
 */
public class MyGridPucException extends Exception {
	private static final long serialVersionUID = 8479561261834501637L;
	private Exception ex;
	private String msg;

	public MyGridPucException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

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
