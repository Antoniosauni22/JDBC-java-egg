
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public abstract class DAO {

    protected  Connection conexion;
    protected  ResultSet resultSet=null;
    protected  Statement statement=null;
    private final String HOST="127.0.0.1";
    private final String PORT="3306";
    private final String USER="root";
    private final String PASSWORD="admin";
    private final String DATABASE="vivero";
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String ZONA="?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    protected void connectarDataBase() {
        try{
            Class.forName(DRIVER);
            String url="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+ZONA;
            System.out.println("url :"+url);
            conexion =DriverManager.getConnection(url,USER,PASSWORD);
            System.out.println("Conexion a base de datos exitosa ");

        } catch (SQLException e) {
            System.out.println("Error de sql :"+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Error de Driver "+e.getMessage());

        }


    }


protected void desconectDatabase()  {
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (conexion!=null){
                conexion.close();
            }
            System.out.println("La conexion a la base de datos se ha cerrado de manera correcta ");

        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion ");
        }
}

    public abstract void buscarConexion();
   // SE TIENE QUE DEFINIR ABSTRACT POR SER METODO ABSTRACTO DE UN CLASE ABSTRACTO
    // COSA MUY DISTINTA DE UNA INTERFAZ QUE POR DEFECTO TIENE CLASES ABSTRACTOS
    // CON LA NUEVA VERSION DE JAVA AHORA TIENE TAMBIEN METODOS CONCRETOS ::: OJO!!!

}
