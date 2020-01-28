package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;

import java.util.List;

public interface RefundacjaService {

    List<Refundacja> getAllRefundacja();
    Refundacja getRefundacja(long id);
    void deleteRefundacja(long id);
    void saveRecepta(Refundacja refundacja);
}
