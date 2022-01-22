package beans;

import java.util.Date;

public class Crenom {
	 
	    private int id;
	    private String date ; 
		private String heureDebut;
	    private String heureFin;
	    private Salle salle ; 
	    private Client client ;
	    

	    public  Crenom(String heureDebut, String heureFin, Salle salle,Client client,String date) {
	        this.heureDebut = heureDebut;
	        this.heureFin = heureFin;
	        this.salle = salle;
	        this.client = client ;
	        this.date = date;
	    }

	    public  Crenom(int id, String heureDebut, String heureFin, Salle salle,Client client,String date) {
	        this.id = id;
	        this.heureDebut = heureDebut;
	        this.heureFin = heureFin;
	        this.salle = salle;
	        this.client = client ;
	        this.date = date;
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getHeureDebut() {
	        return heureDebut;
	    }

	    public void setHeureDebut(String heureDebut) {
	        this.heureDebut = heureDebut;
	    }

	    public String getHeureFin() {
	        return heureFin;
	    }

	    public void setHeureFin(String heureFin) {
	        this.heureFin = heureFin;
	    }
	    public Salle getSalle() {
			return salle;
		}

		public void setSalle(Salle salle) {
			this.salle = salle;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		

	    public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Override
	    public String toString() {
	        return "Crénom{" + "id=" + id + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + '}';
	    }
	    
	 

}
