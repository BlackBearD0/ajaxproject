package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Crenom;
import beans.Salle;
import connexion.Connexion;
import doa.IDao;

public class ClientService implements IDao<Client> {
	
	public boolean createC (Client o,int id) {
		String req= "insert into client  values(null,?,?,?,?,?)";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
			ps.setString(3,o.getPhone());
			ps.setInt(4,id);
			ps.setString(5,o.getStatus());
			 
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("create"+e.getMessage());
		}
		return false;
	} 
	
	
	public Client findUser (String mail ,String password) {
		
		String req= "select * from users where login=? and password=? ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,mail);
			ps.setString(2,password);	
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
		//System.out.println(rs.getString("role"));
		String role = rs.getString("role");
		//System.out.println(role);
				if(role == "client") {
					System.out.println(rs.getInt("id"));
					String req1= "select *  from client where id_user=?";
					
					try {
						PreparedStatement ps1= Connexion.getInstane().getConnection().prepareStatement(req1);
						ps1.setInt(1,rs.getInt("id")); 
						ResultSet rs1= ps1.executeQuery();
						while(rs1.next()) {
							System.out.println(rs1.getInt("id"));
							return  new Client(rs1.getInt("ID"),rs1.getString("Nom"),rs1.getString("Prenom"),rs1.getString("phone"),rs1.getString("status")) ;
						} 
							 
						 
					}catch(Exception e ) {
						System.out.println("findById "+e.getMessage());
					}
					return null;
					
				}else if(rs.getString("role") == "admin"){
					
					return  new Client(0,"admin","admin","","");
				}
			
			} 	 
		}catch (SQLException e) {
          System.out.println("findAll " + e.getMessage());
		
        }
		return   new Client(-1,"00","00","00","00");
	} 
	
	
	
	public boolean createUser(String mail , String password,Client o ) {
		
		String req= "insert into Users  values(null,?,?,?)";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,mail);
			ps.setString(2,password);
			ps.setString(3,"client");
			 
			if(ps.executeUpdate()==1) {
				String req1= "select *  from users 	  where login=?";
				
				try {
					PreparedStatement ps1= Connexion.getInstane().getConnection().prepareStatement(req1);
					ps1.setString(1,mail); 
					ResultSet rs= ps1.executeQuery();
					if(rs.next()) {
						return createC(o,rs.getInt("ID")) ;
					} 
						 
					 
				}catch(Exception e ) {
					System.out.println("findById "+e.getMessage());
				}
			}
		}catch(Exception e ) {
			System.out.println("create"+e.getMessage());
		}
		
		return false ; 
	}
	@Override
	public boolean update (Client o) {
		String req= "update clients set Nom=?,Prenom=? where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
		 
			ps.setInt(3,o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("Update"+e.getMessage());
		}
		return false;
	}
	
	public boolean delete (Client o) {
		String req= "delete from client  where ID=?";
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
	
	
	public  Client  findById (int id) {
		String req= "select *  from client 	  where ID=?";
		Salle ls= null;
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id); 
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				return  new Client(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("phone"),rs.getString("status")) ;
			} 
				 
			 
		}catch(Exception e ) {
			System.out.println("findById "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<Client>  findAll() {
		List<Client> ls= new ArrayList<Client>();
		String req= "select * from client ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				 ls.add( new Client(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("phone"),rs.getString("status"))) ;
			} 	 
		}catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
		return ls;
	}
	
	
	public boolean  accept(int id) {
		String req= "update client set status = 'Active' where id = ?";
		PreparedStatement ps;
		try {
			ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id);
			
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		 
	
		
		return false;
		
	}
	public boolean  disable(int id) {
		String req= "update client set status = 'nonActive' where id = ?";
		PreparedStatement ps;
		try {
			ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id);
			
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		 
	
		
		return false;
		
	}

	@Override
	public boolean create(Client o) {
		// TODO Auto-generated method stub
		return false;
	}
}
