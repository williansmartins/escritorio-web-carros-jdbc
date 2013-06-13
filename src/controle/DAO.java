package controle;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Carro;

public class DAO{

	final static String driver          = "com.mysql.jdbc.Driver";
//    final static String url             = "jdbc:mysql://10.4.10.177/pwms";
//    final static String pwd             = "root376708";
    final static String url             = "jdbc:mysql:3306//www.pwms.com.br/pwmscom_pwms";
    final static String user            = "pwmscom_pwmscom";
    final static String pwd             = "csenha1";

    public static Connection con            = null;
    public static Statement  statement;
    public static ResultSet  resultset;

    public static void conecta() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.print("Driver n�o encontrado!\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.print("Erro na Conexao com Banco\n" + e.getMessage());
        }


    }

    public static void inserir(String fabricante, String modelo, String ano) {
        try {
                conecta( ) ;

                String sql = "INSERT INTO carros (fabricante, modelo, ano) VALUES ( '" + fabricante + "','" + modelo + "','" + ano + "' )";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.commit();
                con.close();
                System.out.println("Inserido com sucesso");

        } catch (SQLException ex) {
            System.out.print("Erro ao inserir: " + ex.getMessage());
        }
    }
 
    public static List<Carro> listagem() {
        //Metodo para popular a tabela com os registros que estão no banco de dados
        try {
            conecta();
            java.sql.PreparedStatement stmtQuery = DAO.con.prepareStatement("Select * from carros ");
            ResultSet resultSet = stmtQuery.executeQuery();
            resultSet.beforeFirst();       
            
            List<Carro> carros = new ArrayList<Carro>();
            
            while (resultSet.next()) {
            	Carro c = new Carro();
            	c.setId( resultSet.getInt("id"));
            	c.setFabricante( resultSet.getString("fabricante"));
            	c.setModelo( resultSet.getString("modelo"));
            	c.setAno( resultSet.getString("ano"));
            	
            	carros.add(c);
            }
            con.close();
            return carros;
            
        } catch (SQLException ex) {
            System.out.print("Erro na listagem: " + ex.getMessage());
            return null;
        }
    }
	
    public static void excluir(int id) {
	     try {
	        conecta();
        	String sql = "Delete from carros where id=" + id + "";
        	statement = (Statement) DAO.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, resultset.CONCUR_READ_ONLY);
        	statement.executeUpdate(sql);
	        
	        con.commit();
	        System.out.print("Item excluido com sucesso!");
	        statement.close();
	        }catch (SQLException ex) {
	             System.out.println("Erro ao excluir: "+ex.getMessage());
	        }
	}
    
    public static void atualizar(Carro carro) {
    	try {
    		conecta();
    		String sql = "UPDATE carros SET fabricante = '"+ carro.getFabricante() +"', modelo = '"+ carro.getModelo() +"', ano = '"+ carro.getAno() +"'   WHERE id=" + carro.getId() + "";
    		statement = (Statement) DAO.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, resultset.CONCUR_READ_ONLY);
    		statement.executeUpdate(sql);
    		
    		con.commit();
    		System.out.print("Item atualizado com sucesso!");
    		statement.close();
    	} catch (SQLException ex) {
    		System.out.println("Erro ao excluir: " + ex.getMessage());
    	}
    }

	public static Carro prepararCarro (int id){

	    	try{
	    		conecta();
	    		Statement st = con.createStatement();
	    		String sql = "select * from carros where id = "+id+" ";
	    		ResultSet rs = st.executeQuery(sql); 

	    		rs.first();

	    		Carro carro = new Carro();

	    		carro.setId(rs.getInt("id"));
	    		carro.setFabricante(rs.getString("fabricante"));
	    		carro.setModelo(rs.getString("modelo"));
	    		carro.setAno(rs.getString("ano"));
	            
	            return carro;
	        }
	        catch (SQLException ex) {
	            System.out.print("Erro ao preparar: " + ex.getMessage());
	            return null;
	        }
	        
	        
	        
	   }
}
