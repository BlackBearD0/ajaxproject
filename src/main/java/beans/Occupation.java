package beans;

import java.util.Date;
import beans.Crenom;
public class Occupation {
	 
	    private int id;
	    private Date date;
	    private Crenom crenom;
	    private Salle salle;

	    public Occupation(int id, Date date, Crenom crenom, Salle salle) {
	        this.id = id;
	        this.date = date;
	        this.crenom = crenom;
	        this.salle = salle;
	    }

	    public Occupation(Date date, Crenom c, Salle salle) {
	        this.date = date;
	        this.crenom = crenom;
	        this.salle = salle;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public Crenom getCrénom() {
	        return crenom;
	    }

	    public void setCrénom(Crenom crenom) {
	        this.crenom = crenom;
	    }

	    public Salle getSalle() {
	        return salle;
	    }

	    public void setSalle(Salle salle) {
	        this.salle = salle;
	    }

	    @Override
	    public String toString() {
	        return "Occupation{" + "id=" + id + ", date=" + date + ", crÃ©nom=" + crenom + ", salle=" + salle + '}';
	    }
	    
	 

}
