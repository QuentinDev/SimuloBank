package fr.instic.cadeaux.business;

import java.util.Date;

/**
 * Created by AUBERT954 on 21/03/2017.
 */
public class MontantDate
{
    private Date date;



    private float montant;

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }


    public Date getDate() {
        return date;
    }




    public MontantDate(long date,float montant)
    {
     this.date=new Date(date);
     this.montant=montant;
    }

}
