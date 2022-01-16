package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "prova")
public class Prova implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	//@Column(name = "ID", unique = true, nullable = false)
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_PROVA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private Long id;
	

	private String nome;
	
	
	private Integer nota;
	

	public Prova() {
	}
	
	public Prova(String nome, int nota) {
		this.nome = nome;
		this.nota = nota;
		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(int i) {
		this.id = (long) i;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNota() {
		return this.nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	

}
