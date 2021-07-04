package com.eVida.Conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.eVida.Recursos.animal;
import com.eVida.Recursos.persona;
import com.mysql.cj.protocol.Resultset;

public class controllerBBDD {
    private String BBDD = "jdbc:mysql://petproject.ctmt0n66m49y.eu-west-2.rds.amazonaws.com";
    private String USER = "petUser";
    private String PASS = "petPass2021";
    private String DATABSE = "PetProject";

    public controllerBBDD() {
        consultaPrueba();
    }

    private Connection conexion() {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
            Connection conexion = DriverManager.getConnection(BBDD + "/" + DATABSE, USER, PASS);
            return conexion;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String consultaPrueba() {
        String sql = "select * from Prueba";
        String salida = "";
        Connection con = conexion();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // System.out.println(rs.getString(1) + " " + rs.getString(2));
                salida += "|" + rs.getString(1) + "," + rs.getString(2);
            }
            con.close();
            salida += "|";
            return salida;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    protected boolean verificarUsuario(String apodo, String contrasenia) {
        // TODO
        if (apodo != "" && contrasenia != "") {
            Connection con = conexion();
            String sql = "select * from usuarios where apodo = ? and contrasenia = ?";
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, apodo);
                stmt.setString(2, contrasenia);
                ResultSet rs = stmt.executeQuery();
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 1) {
                    i = 0;
                    con.close();
                    return true;
                } else {
                    i = 0;
                    con.close();
                    return false;
                }

            } catch (SQLException e) {
                System.out.println(e);
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                return false;
            }
        } else {
            return false;
        }
    }

    protected boolean grabarUsuario(persona p) {
        if (p != null) {
            Connection con = conexion();
            String sql = "INSERT INTO usuarios VALUES (0 , ? , ? , ? , ? , ? , ?)";
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, p.getNombre());
                stmt.setString(2, p.getApellidos());
                stmt.setString(3, p.getDni());
                stmt.setString(4, p.getCorreo());
                stmt.setString(5, p.getApodo());
                stmt.setString(6, p.getContrasenia());

                int respose = stmt.executeUpdate();
                if (respose == 0) {
                    con.close();
                    return false;
                } else {
                    con.close();
                    return true;
                }

            } catch (SQLException e) {
                System.out.println(e);
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                return false;
            }
        } else {
            return false;
        }

    }
    public String recuperarUsuario(String apodo , String contrasenia) {
    	if(apodo != "" && contrasenia != "") {
    		String sql = "select * from usuarios where apodo = ? and contrasenia = ?";
    		try {
    			Connection con = conexion();
    			PreparedStatement stmt = con.prepareStatement(sql);
    			stmt.setString(1, apodo);
    			stmt.setString(2, contrasenia);
    			ResultSet rs = stmt.executeQuery();
    			int i = 0;
    			String persona = "";
    			while(rs.next()) {
    				i++;
    				persona = rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," +
    						rs.getString(6) + "," + rs.getString(7);
    			}			
    			if(i == 1) {
    				return persona;
    			}else {
    				return "";
    			}
    		}catch (Exception e) {
    			System.out.println(e);
    			e.printStackTrace();
    			return "";
    		}
    	}else {
    		return "";
    	}
    }
    
    public String recuperarAnimal(int user) {
    	String animales = "";
    	if(user > 0) {
    		String sql = "select * from animales where idUsuario = ?";
    		try {
				Connection conn = conexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, user);
				
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					animales += rs.getString(1) + "," + rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+
							","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(9)+","+rs.getString(8)+"-";
				}
				return animales;
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				return null;
			}
    	}else {
    		return null;
    	}
    }
    
    public String getRazasPerros() {
    	String sql = "select nombre from razasPerros";
    	String razas ="";
    	try {
            Connection con = conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	razas += rs.getString(1) + ",";
            }
            con.close();
            return razas;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return razas;
		}
    }
    
    public String getTiposDeAnimales() {
    	String sql = "select nombre from tiposDeAnimales";
    	String tipos ="";
    	try {
            Connection con = conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	tipos += rs.getString(1) + ",";
            }
            con.close();
            return tipos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return tipos;
		}
    }
    public String getCellId(String tabla , String valor) {
    	String sql = "select id from "+tabla+" where nombre = '"+valor+"'";
    	String tipos ="";
    	try {
            Connection con = conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            //tabla = tabla.replaceAll("\\s*", ""); tabla = tabla.trim();
            //valor = valor.replaceAll("\\s*", ""); valor = valor.trim();
            //stmt.setString(1, tabla);
            //stmt.setString(2, valor);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	tipos = rs.getString(1) ;
            }
            con.close();
            return tipos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return tipos;
		}
    }
    
    public String getPerro(String id) {
    	String sql = "select * from animales where id = ?";
    	String animal = "";
    	try {
    		Connection conn = conexion();
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, id);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			for(int i = 1 ; i<10 ; i++) {
    				animal += rs.getString(i) + ",";
    			}
    		}
    		conn.close();
    		return animal;
    		
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
    }
    
    public boolean agregarAnimal(animal a) {
    	String sql = "insert into animales values ('0' , ? , ? , ? , ? , ? , ? , ? , ?)";
    	try {
			Connection conn = conexion();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getApodo());
			stmt.setString(2, a.getTipo());
			stmt.setString(3, a.getRaza());
			stmt.setString(4, a.getPeso());
			stmt.setString(5, a.getTipoSangre());
			stmt.setString(6, a.getFechaNacimiento());
			stmt.setInt(7, a.getIdUsuario());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDateTime now = LocalDateTime.now();  
			stmt.setString(8, dtf.format(now));
			
			int i = stmt.executeUpdate();
			
			if(i == 0) {
				conn.close();
				return false;
			}else {
				conn.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
    	
    }
    
    public String getRegistros(String idPerro , String idUsuario) {
    	
    	String sql = "select * from mediciones where idPerro = ? and idDueño = ?";
    	String mediciones = "";
    	try {
			Connection con = conexion();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, idPerro);
			stmt.setString(2, idUsuario);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				for(int i = 1 ; i<5 ; i++) {
					mediciones += rs.getString(i) + ",";
				}
				mediciones += "|";
				
			}
			con.close();
			return mediciones;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
    	
    }
    
    public String getTiposDeSangreAnimales() {
    	String sql = "select nombre from tiposDeSangreAnimales";
    	String tipos ="";
    	try {
            Connection con = conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	tipos += rs.getString(1) + ",";
            }
            return tipos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return tipos;
		}
    }

    public static void main(String[] args) {
        controllerBBDD c = new controllerBBDD();
    }
}
