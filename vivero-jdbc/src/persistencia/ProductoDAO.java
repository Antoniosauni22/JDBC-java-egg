package persistencia;

public class ProductoDAO extends  DAO {


    public  void eliminarProducto(int codigo ) throws  Exception {

        try {
            String sql="delete from producto where id_producto ="+codigo;
            insertarModificarEliminarDataBase(sql);
            System.out.println("acabamos de eliminar un registro de la tabla producto ;");

        } catch (Exception e) {
            throw e;
        }
        finally {
            desconectarDataBase();
        }
    }
}
