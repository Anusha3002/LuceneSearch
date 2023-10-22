package org.pabay.search.indexhunt.lucene.entity;


import jakarta.persistence.*;

@Entity
@Table(name="saas_index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private String id;

    @Column(name="name", unique = true, nullable = false)
    private String name;
    /**
     * Location where indexes are stored
     */
    @Column(name="path",unique = true, nullable = false)
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
