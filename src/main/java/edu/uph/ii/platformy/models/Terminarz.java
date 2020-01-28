package edu.uph.ii.platformy.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "terminarze")

public class Terminarz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu VehicleType wraz z obiektem Vehicle.
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu VehicleType wraz z obiektem Vehicle.
    @JoinColumn(name="wizyta_id", nullable = false)
    private Wizyta wizyta;

    public Terminarz(User user, Wizyta wizyta){
        this.user = user;
        this.wizyta = wizyta;
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

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }
}
