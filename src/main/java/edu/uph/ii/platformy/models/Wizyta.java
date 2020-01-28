package edu.uph.ii.platformy.models;

import edu.uph.ii.platformy.validators.annotations.UniqueDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wizyty")
public class Wizyta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@UniqueDate
    @Column(name="data_wizyty", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWizyty;

    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu VehicleType wraz z obiektem Vehicle.
    @JoinColumn(name="usluga_id", nullable = false)
    private Usluga usluga;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="status_id", nullable = false)
    private StatusWizyty statusWizyty;

    public Wizyta(User user, StatusWizyty statusWizyty) {
        this.user = user;
        this.statusWizyty = statusWizyty;
    }

    public Wizyta(Date dataWizyty, Usluga usluga, User user, StatusWizyty statusWizyty) {
        this.dataWizyty = dataWizyty;
        this.usluga = usluga;
        this.user = user;
        this.statusWizyty = statusWizyty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(Date dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusWizyty getStatusWizyty() {
        return statusWizyty;
    }

    public void setStatusWizyty(StatusWizyty statusWizyty) {
        this.statusWizyty = statusWizyty;
    }
}
