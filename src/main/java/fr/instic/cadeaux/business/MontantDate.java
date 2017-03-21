package fr.instic.cadeaux.business;

import java.util.Date;

/**
 * Created by AUBERT954 on 21/03/2017.
 */
public class MontantDate
{
    private Date date;
    private float montant;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public MontantDate(Date date,float montant)
    {
     this.date=date;
     this.montant=montant;
    }

}
