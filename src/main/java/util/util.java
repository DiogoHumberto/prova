package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class util {
	
	public static String getMensagemErro (Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		String retorno = e.getMessage();
		if (retorno.contains("viola restri��o de chave estrangeira")) {
			retorno = "Registro n�o pode ser exclu�do por possuir refer�ncia em outros "+"locais do sistema";
			
		}
		return retorno;
	}
	
	public static void mensagemInformacao(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "");
		contexto.addMessage(null, msg);
	}
	
	public static void mensagemErro(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "");
		contexto.addMessage(null, msg);
	}

}
