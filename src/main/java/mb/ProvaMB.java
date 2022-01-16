package mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import bean.Prova;
import service.ProvaService;
import util.util;

@ManagedBean
@ViewScoped
public class ProvaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Prova prova;
	@Inject
	private ProvaService services;

	public ProvaMB() {
		this.prova = new Prova();
		// this.provas = new ArrayList<>();
		// this.provaEditar = new Prova();
	}

	public String maiorProva() {
		try {
			return services.maiorNota(getProvas());
		} catch (Exception e) {
			
			util.mensagemErro("Erro ao pegar Maior valor Nota: " + util.getMensagemErro(e));
		}
		return "-";

	}

	public String menorProva() {

		try {
			return services.menorNota(getProvas());
		} catch (Exception e) {
			util.mensagemErro("Erro ao pegar Menor valor Nota: " + util.getMensagemErro(e));

		}
		return "-";
	}

	public String mediaProva() throws Exception {

		try {
			return services.mediaNotas(getProvas());

		} catch (Exception e) {
			util.mensagemErro("Erro ao pegar Menor valor Nota: " + util.getMensagemErro(e));

		}
		return "-";
	}

	public String addProva() {

		try {
			this.services.addProva(prova);
		} catch (Exception e) {
			util.mensagemErro("Erro ao adicionar objeto: " + util.getMensagemErro(e));
		}
		// this.provaEditar = new Prova();
		return "/pages/listar"; // Arrumar Caminho }
	}

	public String removerProva(Prova p) {
		try {
			this.services.removerProva(p);
		} catch (Exception e) {
			util.mensagemErro("Erro ao remover objeto: " + util.getMensagemErro(e));
		}
		return "/pages/index?faces-redirect=true";
	}

	public void novo() {
		prova = new Prova();
	}

	public void alterar(Object id) {
		try {
			this.prova = services.getObjectById(id);
		} catch (Exception e) {
			util.mensagemErro("Erro ao alterar objeto: " + util.getMensagemErro(e));
		}

	}

	public void excluir(Object id) {
		try {
			prova = services.getObjectById(id);
			services.removerProva(prova);
			util.mensagemInformacao("Removido com sucesso");
		} catch (Exception e) {
			util.mensagemErro("Erro ao excluir objeto: " + util.getMensagemErro(e));
		}

	}

	public void Salvar() {
		try {
			services.addProva(prova);
			util.mensagemInformacao("Salvo com sucesso");
		} catch (Exception e) {
			util.mensagemErro("Erro ao salvar objeto: " + util.getMensagemErro(e));
		}
	}

	public String listar() {
		return "/pages/index?faces-redirect=true";
	}

	public List<Prova> getProvas() throws Exception {
		return services.getProvas();
	}

	public String editar() {
		// this.provaEditar = this.prova;
		return "/pages/registrar";
	}

	public String clear() {
		this.prova = new Prova();
		// this.provaEditar = new Prova();
		return "/pages/registrar";
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
}
