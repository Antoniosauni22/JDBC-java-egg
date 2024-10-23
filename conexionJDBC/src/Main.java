//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Connection conexion=getConection();

         // buscarClientes(conexion);
         // cerrarConexion(conexion);
         // cerrarConexion(conexion);
        //  getProductoParaReponer(20);
         // getProductoParaReponer(20);
         // getProductoParaReponer2(20);
        //  getProductosGama("Herbaceas");
         // getPedidosPorCliente(7,conexion);
         getPedidosPorEstado("Pendiente",conexion);


    }

    public  static Connection getConection(){
        String host="localhost";
        String port="3306";
        String name="root";
        String password="admin";
        String database="vivero";
        String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url="jdbc:mysql://" +host+":"+port+"/"+database+ZONA;

       // añadir a url desues de ZONA &useSSL=false"; //se elimina SSL para que funcione la base de datos

        Connection conexion=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion =DriverManager.getConnection(url,name,password);
            System.out.println("conexion a base de datos exitosa ");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC "+e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error de conexion :"+e.getMessage());;
        }

        return  conexion;
    }

    public  static  void cerrarConexion(Connection conexion){
        if(conexion!=null){
            try {
                conexion.close();
                System.out.println("La conexión a la base de datos fue cerrada de forma correcta ");
            } catch (SQLException e) {
                System.out.println("error al cerrar la conexion "+e.getMessage());

            }
        }

    }


    public static  void buscarClientes(Connection conexion){
        String sql="select nombre_contacto,apellido_contacto,telefono from cliente";
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            int count=0;
            while (rs.next()){
                String nombre=rs.getString("nombre_contacto");
                String apellido=rs.getString("apellido_contacto");
                String telefono=rs.getString("telefono");
                count++;
                System.out.println(" "+nombre+"-"+apellido+"-"+telefono);
            }
            stmt.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(" error al Buscar clientes "+e.getMessage());
            e.getStackTrace(); // traemos toda la pila de error que se generé
        }


    }


    public  static void  getProductoParaReponer(int punto_de_reposicion){
        String sql="select * from producto where producto.cantidad_en_stock  < "+punto_de_reposicion;
        Statement stmt=null;
        try {
            stmt=getConection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                int id_producto=rs.getInt("id_producto");
                String codigo_producto=rs.getString("codigo_producto");
                String nombre_producto=rs.getString("nombre");
                String dimensiones=rs.getString("dimensiones");
                String proveedor=rs.getString("proveedor");
                int cantidad_en_stock= rs.getInt("cantidad_en_stock");
                System.out.println(" "+id_producto+" - "+codigo_producto +" - "+nombre_producto+dimensiones+proveedor+" - "+cantidad_en_stock);
            }
            stmt.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(" Error al ver Producto para reponer "+e.getMessage());
        }


    }


    public  static void  getProductosGama(String gama_producto){

        String sql="select p.id_producto,p.nombre,g.id_gama,g.gama from producto p,gama_producto g where g.gama ='"+gama_producto+"'";

        Statement stmt=null;
        try {
            stmt=getConection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                int id_producto=rs.getInt("id_producto");
                String nombre_producto=rs.getString("nombre");
                String id_gama= rs.getString("id_gama");
                String nombre_gama=rs.getString("gama");
                System.out.println(" id :"+id_producto+  " nombre_producto: "+nombre_producto+" id_gama : "+id_gama+" gama :"+nombre_gama);
            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(" Error al ver Producto para reponer "+e.getMessage());
        } catch (Exception e) {
            System.out.println(" errror general "+e.getMessage());
        }
    }

    public  static  void getPedidosPorCliente(int idCliente ,Connection conexion){
        String sql="select c.id_cliente,c.nombre_cliente,p.codigo_pedido,p.fecha_pedido,p.estado from cliente c,pedido p \n" +
                "where c.id_cliente=p.id_cliente and p.estado = ? and c.id_cliente = "+idCliente;

        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            // aqui voy a especificar los parametros para preapara mi consulta antes de ejecutarla
            ps.setString(1,"Entregado");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id_cliente");
                String nombre=rs.getString(2);// nombre del cliente
                String fecha=rs.getString("fecha_pedido");
                String estado=rs.getString("estado");
                System.out.println(" id :"+id + "  "+nombre+"  "+fecha+"  "+estado );

            }
            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error al lista Pedidos por cliente"+e.getMessage());
            e.getStackTrace();
        }


    }


    public static  void getPedidosPorEstado(String estado,Connection conexion){
        String sql="select c.id_cliente,c.nombre_cliente,p.codigo_pedido,p.fecha_pedido,p.estado from cliente c,pedido p \n" +
                "where c.id_cliente=p.id_cliente and p.estado= ?";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1,estado); // introduciendo el parametro estado antes de ejecutar la sentencia
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String nombre_cliente=rs.getString(2);
                String codigo_pedido=rs.getString(3);
                String fecha_pedido=rs.getString(4);
                String estado_pedido=rs.getString(5);
                System.out.println(id+"  "+nombre_cliente+" "+codigo_pedido+" "+fecha_pedido+" "+estado_pedido);
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Error al listar pedidos por estado"+e.getMessage());
        }

    }

    // complementarios






}