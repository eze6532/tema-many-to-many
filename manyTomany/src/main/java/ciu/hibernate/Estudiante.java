package ciu.hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = {@JoinColumn(name = "estudiante_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
    private Set<Curso> cursos = new HashSet<>();
    
    public Estudiante() {
    }
    
    public Estudiante(Integer id, String nombre, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.cursos = new HashSet<>();
        this.cursos.add(curso);
    }

    /* Getters and setters */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
    /* Fin Getters and setters */
}
