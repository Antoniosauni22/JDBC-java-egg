package persistencia;

import java.sql.*;

public class DAO {
    // tipo protected porque tambien va a poder ser usadas por las clases que hereden de
    // esta clase
    // sin embargo las propiedades de tipo privada son las demas porque esos atributos seran propios
    // de este objeto

   protected Connection conexion=null;
   protected ResultSet resultSet=null;
   protected Statement statement=null;
   private final String HOST="localhost";
   private final String PORT="3306";
   private final String USER="root";
   private final  String PASSWORD="admin";
   private final  String DATABASE="estancias_exterior";
   private final  String DRIVER="com.mysql.cj.jdbc.Driver";
   private final String ZONA="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";


   // metodos de tipo protected para que puedan tambien ser usados por la clase de hereda de esta clase abstracta


  protected  void conectarDataBase() throws ClassNotFoundException, SQLException {

      try {
          Class.forName(DRIVER);
           String url="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+ZONA;
           conexion=DriverManager.getConnection(url,USER,PASSWORD);
          System.out.println("usted esta conectado a estancias_exterior DB");

      } catch (Exception e) {
          System.out.println("Error al conectarDataBase"+e.getMessage());
          e.getStackTrace();
      }

   }


   protected  void desconectarDataBase(){

   }

   protected  void insertarEliminarModificarDataBase(String sql){
      try {
          conectarDataBase();
          statement =conexion.createStatement();
          statement.executeUpdate(sql);

      } catch (Exception e) {
          System.out.println("Error al insertar Eliminar Modificar Database "+e.getMessage());
          e.getStackTrace();
      }
   }

    protected  void consultarDataBase(String sql){
        try {
            conectarDataBase();
            statement =conexion.createStatement();
            resultSet=statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Error al insertar Eliminar Modificar Database "+e.getMessage());
            e.getStackTrace();
        }
    }



}
