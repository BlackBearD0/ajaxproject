package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.Crenom;
import beans.Salle;
import connexion.Connexion;
import doa.IDao;

public class CrenomService implements IDao<Crenom> {
	SalleService ss = new SalleService();
	ClientService cs = new ClientService();
	
	@Override
	public boolean create (Crenom o) {
		String req= "insert into reservation  values(null,?,?,?,?,?)";
		//System.out.println(o.getClient().getId());
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			
			ps.setInt(1,o.getSalle().getId());
			ps.setInt(2,o.getClient().getId());
			ps.setString(3,o.getDate());
			ps.setString(4,o.getHeureDebut());
			ps.setString(5,o.getHeureFin());
	

			 
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("create"+e.getMessage());
		}
		return false;
	} 
	@Override
	public boolean update (Crenom o) {
		String req= "update reservation set Heure_debut=?,Heure_Fin=?,dateR=? where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getHeureDebut());
			ps.setString(2,o.getHeureFin());
			ps.setString(3,o.getDate());
			ps.setInt(4,o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("Update"+e.getMessage());
		}
		return false;
	}
	
	public boolean delete (Crenom o) {
		String req= "delete from reservation  where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,o.getId()); 
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("delete"+e.getMessage());
		}
		return false;
	}
	
	
	public  Crenom  findById (int id) {
		String req= "select *  from reservation  where ID=?";
		Salle ls= null;
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id); 
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				return  new Crenom(rs.getInt("ID"),rs.getString("Heure_Debut"),rs.getString("Heure_Fin"),ss.findById(rs.getInt("salle")),cs.findById(rs.getInt("client")),rs.getString("Dater")) ;
			} 
				 
			 
		}catch(Exception e ) {
			System.out.println("findById "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<Crenom>  findAll() {
		List<Crenom> ls= new ArrayList<Crenom>();
		String req= "select * from reservation ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				 ls.add(new Crenom(rs.getInt("ID"),rs.getString("Heure_Debut"),rs.getString("Heure_Fin"),ss.findById(rs.getInt("salle")),cs.findById(rs.getInt("client")),rs.getString("Dater"))) ;
			} 	 
		}catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
		return ls;
	}
	
	public List<Crenom> findResrvationsByClient(int id ){
		List<Crenom> ls= new ArrayList<Crenom>();
		String req= "select * from reservation where client=? ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				 ls.add(new Crenom(rs.getInt("ID"),rs.getString("Heure_Debut"),rs.getString("Heure_Fin"),ss.findById(rs.getInt("salle")),cs.findById(rs.getInt("client")),rs.getString("Dater"))) ;
			} 	 
		}catch (SQLException e) {
            System.out.println("find " + e.getMessage());
        }
		return ls;
	}
	
	public List<Salle> getRoomsBeforeDate(String date){
		List<Crenom> ls= new ArrayList<Crenom>();
		List<Salle> ls1= new ArrayList<Salle>();
		List<Salle> salles1= new ArrayList<Salle>();
		SalleService salles = new SalleService();
		salles1 = salles.findAll();
		
		
		ls= findAll();
		
		  SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  
		   java.util.Date date2 = null;
		try {
			date2 = formatter2.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // System.out.println(date2);
		
		for(Salle s : salles1) {
			int comp= 0 ;
		   for(Crenom c : ls) {
			   java.util.Date date3 = null;
			try {
				date3 = formatter2.parse(c.getDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   if(s.getId() == c.getSalle().getId()) {
				   if(date3.after(date2)) {
					   comp = 1;
					  /* ls1.add(s);
					   comp=1;*/
				   }
			   }
			  
		   }
		   if(comp == 0 ) {
			   ls1.add(s);
		   }
		}
		
		
		
		
		
		
		return ls1 ;
	}
	
}
