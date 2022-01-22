import beans.Salle;
import service.SalleService;

public class Test {
	
	public static void main(String[] args) {
		SalleService ss = new SalleService();
		if(ss.create(new Salle("D450",45,"pratique")))
			System.out.println("creer");
		else 
			System.out.println("error");
	}
}
