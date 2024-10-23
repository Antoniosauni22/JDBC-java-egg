package persistencia;
import  java.sql.*;

public  abstract class  DAO {

    protected  Connection conexion=null;
    protected  ResultSet resultset=null;
    protected Statement statement=null;
    private  final String HOST="localhost";
    private  final String PORT="3306";
    private  final  String USER="root";
    private  final  String PASSWORD="admin";
    private  final String DATABASE="vivero";
    private  final String DRIVER="com.mysql.cj.jdbc.Driver";
    private  final String ZONA="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";




    protected   void conectarDataBase() throws ClassNotFoundException {
         try{

             // url = jdbc:mysql://localhost:3306/nombre_bd/;
             Class.forName(DRIVER);
             String url="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+ZONA;
             conexion=DriverManager.getConnection(url,USER,PASSWORD);
             System.out.println("conectado : su objeto conexion es :"+conexion);


         } catch (SQLException  e) {
             System.out.println("Error en la consulta SQL "+e.getMessage());
             e.getStackTrace();
         } catch ( ClassNotFoundException e) {
             System.out.println("Error de Driver"+e.getMessage());
             e.getStackTrace();
         }


    }


    public void desconectarDataBase() throws SQLException,ClassNotFoundException {

     try {
         if (resultset!=null){
             resultset.close();
         }
         if (statement!=null){
             statement.close();
         }
        if (conexion!=null){
            conexion.close();
        }

     }catch (Exception e){
         System.out.println("Error al desconectarDataBase"+e.getMessage());
         throw e;
     }

    }

    protected  void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {
            conectarDataBase();
            statement=conexion.createStatement();
            statement.executeUpdate(sql);
            System.out.println("sentencia ejecutada correctamente en la base de datos");
            // executeUpdate : para insertar,modificar o borrar base de datos
            // realizar actualizaciones que no que no devuelve un ResultSet

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al SQL Excepcion "+e.getMessage());
            e.getStackTrace();
            throw e;
        }
        finally {
            desconectarDataBase();
        }
    }

    protected  void consultaDataBase(String sql )throws Exception {
        try {
            conectarDataBase();
            statement=conexion.createStatement();
            resultset = statement.executeQuery(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



}
