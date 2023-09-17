package clases;

import java.sql.*;

public class DataBase {
    Connection conexion;
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "localhost";
        String puerto =  "3306";
        String user_name = "root";
        String password = "";
        String database_name = "luna_restaurante";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try {
            this.conexion = DriverManager.getConnection(url, user_name, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.println("conexion existosa");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a base de datos: "+ex.getMessage());
        }
    }
    
    public boolean insertarUsuario(String cedula, String nombres, String apellidos, String contrasenia, String rol){
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO usuarios (cedula,nombre,apellido,contrasenia,rol) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+contrasenia+"','"+rol+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if(resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());
        }
        
        return respuesta;
    }
    public ResultSet consultaGeneral(String tabla){
        ResultSet listado  = null; 
        
        try {
            String consulta = "SELECT * FROM "+tabla;
            listado = this.manipularDB.executeQuery(consulta);
            listado.next();
            if(listado.getRow()==1){
                return listado;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: "+ex.getMessage());
        }
        return listado;
    }
    
    public boolean editarPersona(String cedula,String nombres,String apellidos,String contrasena,int estado ){
        boolean respuesta = false;
        try {

            String consulta = "UPDATE usuarios SET nombre ='"+nombres+"', apellido ='"+apellidos+"', contrasenia ='"+contrasena+"',estado ='"+estado+"'"+" WHERE cedula='"+cedula+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("--> Error Update: " + ex.getMessage());
        }
        return respuesta;
    }
    
    public ResultSet buscarUsuario(String cedula){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM usuarios WHERE cedula = '"+cedula+"'";
	    registros = manipularDB.executeQuery(consulta);
            registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
    
    public boolean eliminarPersona(String cedula){
        boolean respuesta = false;
        try {
            String consulta = "DELETE FROM usuarios WHERE cedula='"+cedula+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("--> Error Delete: " + ex.getMessage());
        }
        return respuesta;
    }
    
    public ResultSet iniciarSesion(String cedula, String password){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM usuarios WHERE cedula = '"+cedula+"' AND contrasenia = '"+password+"'";
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
    public boolean crearPlato(String nombre,String descripcion,int precio){
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO platos (nombre,descripcion,precio) VALUES ('"+nombre+"','"+descripcion+"',"+precio+")";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if(resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());
        }
        
        return respuesta;
    }
    
    public boolean editarPlato(int id_plato, String nombre,String descripcion,int precio){
        boolean respuesta = false;
        try {

            String consulta = "UPDATE platos SET nombre='"+nombre+"', descripcion='"+descripcion+"', precio="+precio+" WHERE id_plato='"+id_plato+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("--> Error Update: " + ex.getMessage());
        }
        return respuesta;
    }
    
    public ResultSet buscarPlato(int id_plato){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM platos WHERE id_plato = "+id_plato;
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
    
    public boolean crearFactura(int total,int id_mesa,String id_usuario){
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO factura (total,dinero_recibido,cambio,id_mesa,id_usuario,estado) VALUES ("+total+",0,0,"+id_mesa+",'"+id_usuario+"','pendiente')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if(resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());
        }
        
        return respuesta;
    }
    public boolean guardarPedido(int id_factura,int cantidad,int id_plato,int sub_total){
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO pedidos (id_factura,cantidad,id_plato,sub_total) VALUES ("+id_factura+","+cantidad+","+id_plato+","+sub_total+")";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if(resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());
        }
        
        return respuesta;
    }
    
        public String ultimaFatura(){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM factura ORDER BY id_factura DESC LIMIT 1";
	    registros = manipularDB.executeQuery(consulta);
            registros.next();
	    if(registros.getRow()==1){
                return registros.getString("id_factura");
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return null;
    }
    
    public ResultSet bucarItems(int id_factura){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM pedidos JOIN platos ON (pedidos.id_plato = platos.id_plato) JOIN factura ON (pedidos.id_factura = factura.id_factura) WHERE factura.id_factura ="+id_factura;
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
    
    public boolean editarFactura(int dinero_recibido, int cambio,int n_factura){
        boolean respuesta = false;
        try {

            String consulta = "UPDATE factura SET dinero_recibido="+dinero_recibido+", cambio="+cambio+", estado='pago' WHERE id_factura="+n_factura;
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("--> Error Update: " + ex.getMessage());
        }
        return respuesta;
    }
    public boolean editarMesa(int n_mesa,String estado){
        boolean respuesta = false;
        try {
            String consulta = "UPDATE mesa SET estado = '"+estado+"' WHERE id_mesa = "+n_mesa;
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("--> Error Update: " + ex.getMessage());
        }
        return respuesta;
    }
    
     public ResultSet buscarMesa(int id_mesa){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM mesa WHERE id_mesa = "+id_mesa;
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
     
    public ResultSet buscarFactura(int n_factura){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM factura WHERE id_factura = "+n_factura;
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
    
    public ResultSet buscarFacturaDeMesa(int n_mesa ){
        ResultSet registros = null;
	try {
	    String consulta = "SELECT * FROM factura JOIN mesa on(factura.id_mesa = mesa.id_mesa) WHERE mesa.id_mesa = "+n_mesa+" and mesa.estado = 'ocupada'";
	    registros = manipularDB.executeQuery(consulta);
	    registros.next();
	    if(registros.getRow()==1){
                return registros;
	    }else{
	        return null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Error al buscar el cliente: "+ex.getMessage());
	} 
        return registros;
    }
}
