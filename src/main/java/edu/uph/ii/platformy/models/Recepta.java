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
@Table(name = "recepty")

public class Recepta {

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

    @Column(name="lek")
    @Size(min=2,max=300)
    private String lek;

    @Column(name="dawkowanie")
    @Size(min=2,max=300)
    private String dawkowanie;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu VehicleType wraz z obiektem Vehicle.
    @JoinColumn(name="refundacja_id", nullable = false)
    private Refundacja refundacja;

    public Recepta(){
        this.creationDate = new Date();
    }

    public Recepta(User user, Date creationDate, String lek, String dawkowanie, Refundacja refundacja){
        this.user = user;
        this.creationDate = creationDate;
        this.lek = lek;
        this.dawkowanie = dawkowanie;
        this.refundacja = refundacja;
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

    public String getLek() {
        return lek;
    }

    public void setLek(String lek) {
        this.lek = lek;
    }

    public String getDawkowanie() {
        return dawkowanie;
    }

    public void setDawkowanie(String dawkowanie) {
        this.dawkowanie = dawkowanie;
    }

    public Refundacja getRefundacja() {
        return refundacja;
    }

    public void setRefundacja(Refundacja refundacja) {
        this.refundacja = refundacja;
    }
}
