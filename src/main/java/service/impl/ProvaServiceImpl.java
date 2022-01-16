package service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bean.Prova;
import dao.ProvaDao;
import service.ProvaService;

@Stateless
public class ProvaServiceImpl implements ProvaService {

	@Inject
	private ProvaDao dao;

	public ProvaServiceImpl() {
		// this.dao = new ProvaDaoImpl();

	}

	@Override
	public void addProva(Prova prova) throws Exception {
		this.dao.addProva(prova);

	}

	@Override
	public void removerProva(Prova prova) throws Exception {
		this.dao.removerProva(prova);
	}

	public Prova getObjectById(Object id) throws Exception {
		return dao.getObjectById(id);

	}

	@Override
	public List<Prova> getProvas() throws Exception {
		return this.dao.getProvas();
	}

	@Override
	public String mediaNotas(List<Prova> provas) {

		if (!provas.isEmpty()) {
			int somaNotas = 0;
			somaNotas = provas.stream().mapToInt(p -> p.getNota()).sum();
			Double media = (double) ((float) somaNotas / (float) provas.size());
			return String.format("%.2f", media);
		}

		return "sem notas";
	}

	@Override
	public String maiorNota(List<Prova> provas) {

		if (!provas.isEmpty()) {
			Optional<Integer> maiorNota = null;

			maiorNota = provas.stream().map(e -> e.getNota()).max(Comparator.naturalOrder());
			return maiorNota.get().toString();
		}
		return "sem notas";
	}

	@Override
	public String menorNota(List<Prova> provas) {

		Optional<Integer> menorNota = null;
		if (!provas.isEmpty()) {

			menorNota = provas.stream().map(e -> e.getNota()).min(Comparator.naturalOrder());
			return menorNota.get().toString();
		}
		return "sem notas";
	}

}
