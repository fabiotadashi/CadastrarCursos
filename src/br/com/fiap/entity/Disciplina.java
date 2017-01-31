package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DISCIPLINA", catalog = "dbcursos", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id")} )
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "NOME", nullable = false, length=45)
	private String nome;

	@Column(name = "DESCRICAO", nullable = false, length=45)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="CURSO_ID")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name="PROFESSOR_ID")
	private Usuario professor;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "disciplina")
	private Set<AlunoDisciplina> alunoDisciplina = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public Set<AlunoDisciplina> getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(Set<AlunoDisciplina> alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

}