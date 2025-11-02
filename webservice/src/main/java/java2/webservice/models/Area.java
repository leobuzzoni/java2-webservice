package java2.webservice.models;

import jakarta.persistence.*;

@Entity
public class Area {

    @Id
    @GeneratedValue
    private long id;
    private String nome;

    public Area() {
    }

    public Area(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Area(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
