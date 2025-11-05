package java2.webservice.models;

import jakarta.persistence.*;

@Entity
public class Vaga {

    @Id
    @GeneratedValue
    private long id;

    private String titulo;
    private String descricao;
    private String publicacao;
    private boolean ativo;

    @ManyToOne
    private Empresa empresa;

    public Vaga() {
    }

    public Vaga(long id, String titulo, String descricao, String publicacao, boolean ativo, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.empresa = empresa;
    }

    public Vaga(String titulo, String descricao, String publicacao, boolean ativo, Empresa empresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public long getIdEmpresa() {
        return this.empresa != null ? this.empresa.getId() : 0;
    }
}