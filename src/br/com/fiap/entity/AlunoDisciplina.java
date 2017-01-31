package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ALUNO_DISCIPLINA")
public class AlunoDisciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID")
	private Usuario aluno;
	
	@ManyToOne
	@JoinColumn(name="DISCIPLINA_ID")
	private Disciplina disciplina;
	
	@Column(name = "PROJETO_1")
	private int projeto1;
	
	@Column(name = "PROJETO_2")
	private int projeto2;
	
	@Column(name = "ATIVIDADE_PRATICA")
	private int atividadePratica;

	public float getMedia(){
		return ((projeto1 * 30) + (atividadePratica * 30) + (projeto2 * 40)) / 100;
	}
	
	public String getAprovacao(){
		return getMedia() >= 7? "aprovado" :"reprovado";
	}
	
	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(int projeto1) {
		this.projeto1 = projeto1;
	}

	public int getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(int projeto2) {
		this.projeto2 = projeto2;
	}

	public int getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(int atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
