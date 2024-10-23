package persistencia;

public class clienteDAO extends DAO {

 public  void ListarClientes( ){
     String sql="select * from clientes";

     try {

         consultarDataBase(sql);
         while (resultSet.next()){
             System.out.println(""+resultSet.getInt(1));
             System.out.println(""+resultSet.getString(2));
             System.out.println(resultSet.getString(3));
         }


     }catch (Exception e){
         System.out.println("Error al listar Clientes "+e.getMessage());
         e.getStackTrace();

     }


 }

}
