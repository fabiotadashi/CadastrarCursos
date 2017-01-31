package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", catalog = "dbcursos", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id")} )
@NamedQueries({
    @NamedQuery(name="Usuario.findProfessores",
                query="SELECT u FROM Usuario u where u.perfil = br.com.fiap.entity.Perfil.PROFESSOR"),
    @NamedQuery(name="Usuario.findAlunos",
    		query="SELECT u FROM Usuario u where u.perfil = br.com.fiap.entity.Perfil.ALUNO"),
}) 
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "NOME", nullable = false, length=45)
	private String nome;
	
	@Column(name = "SENHA", nullable = false, length=10)
	private String senha;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "aluno")
	private Set<AlunoDisciplina> alunoDisciplina = new HashSet<>();
	
	public Usuario() {
	}

	public float getMediaGeral(){
		float mediaGeral = 0;
		if(alunoDisciplina != null){
			Iterator<AlunoDisciplina> iterator = alunoDisciplina.iterator();
			int i = 0;
			float media = 0;
			while(iterator.hasNext()){
				i++;
				media += iterator.next().getMedia();
			}
			mediaGeral = media / i;
		}
		return mediaGeral;
		
	}
	
	public String getAprovacao(){
		return getMediaGeral() >= 7 ? "aprovado" : "reprovado";
	}
	
	public Usuario(int id) {
		this.id = id;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<AlunoDisciplina> getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(Set<AlunoDisciplina> alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

}