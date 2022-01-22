package beans;

public class Client {
	 
	 	
	    private int id;
	    private String nom;
		private String prenom;
	    private String phone ; 
	    private String status ; 

	    public Client(int id, String nom, String prenom,String phone, String status) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.phone = phone;
	        this.status = status;
	    }

	    public Client(String nom, String prenom,String phone, String status) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.phone = phone;
	        this.status = status;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }
	    public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	    @Override
	    public String toString() {
	        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + '}';
	    }
	    
	 
}
