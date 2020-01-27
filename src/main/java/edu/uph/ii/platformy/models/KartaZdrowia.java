package edu.uph.ii.platformy.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "karty_zdrowia")

public class KartaZdrowia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu VehicleType wraz z obiektem Vehicle.
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="data_utworzenia", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name="opis")
    @Size(min=2,max=300)
    private String opis;

    public KartaZdrowia(){
        this.creationDate = new Date();
    }

    public KartaZdrowia(User user,Date creationDate,String opis) {
        this.user = user;
        this.creationDate = creationDate;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
