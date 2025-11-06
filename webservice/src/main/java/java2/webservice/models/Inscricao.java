package java2.webservice.models;

import jakarta.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String dataInscricao;
    private String status;
    private String mensagemApresentacao;

    @ManyToOne
    private Estudante estudante;

    @ManyToOne
    private Vaga vaga;

    public Inscricao() {
    }

    public Inscricao(long id, String dataInscricao, String status, String mensagemApresentacao, Estudante estudante,
            Vaga vaga) {
        this.id = id;
        this.dataInscricao = dataInscricao;
        this.status = status;
        this.mensagemApresentacao = mensagemApresentacao;
        this.estudante = estudante;
        this.vaga = vaga;
    }

    public Inscricao(String dataInscricao, String status, String mensagemApresentacao, Estudante estudante, Vaga vaga) {
        this.dataInscricao = dataInscricao;
        this.status = status;
        this.mensagemApresentacao = mensagemApresentacao;
        this.estudante = estudante;
        this.vaga = vaga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagemApresentacao() {
        return mensagemApresentacao;
    }

    public void setMensagemApresentacao(String mensagemApresentacao) {
        this.mensagemApresentacao = mensagemApresentacao;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}