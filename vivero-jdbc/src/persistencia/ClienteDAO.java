package persistencia;

import entidades.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO  {


    public  void  guardarCliente(Cliente cliente) throws Exception{
        if (cliente==null){
            System.out.println("El cliente no puede ser nulo ");
        }
        String sql="INSERT INTO CLIENTE(id_cliente,codigo_Cliente,nombre_cliente,nombre_contacto,apellido_contacto,telefono,fax, ciudad,region,pais,codigo_postal,id_empleado,limite_credito) values ('"+cliente.getIdCliente()+"','"+cliente.getCodigoCliente()+"','"+cliente.getNombreCliente()+"','"+cliente.getNombreContacto()+"','"+cliente.getApellidoContacto()+"','"+cliente.getTelefono()+"','"+cliente.getFax()+"','"+cliente.getCiudad()+"','"+cliente.getRegion()+"','"+cliente.getPais()+"', '"+cliente.getCodigoPostal()+"','"+cliente.getIdEmpleado()+"','"+cliente.getLimiteCredito()+"')";
        insertarModificarEliminarDataBase(sql);
        System.out.println("se inserto el cliente");
    }


    public  List<Cliente> listarTodosLosClientes()  throws  Exception {
        String sql="select id_cliente,nombre_cliente,nombre_contacto from cliente";
        List<Cliente> clientes= new ArrayList<>();
         Cliente cliente=null;
            consultaDataBase(sql);
            if (resultset!=null) System.out.println("Resultset contiene datos :) ");
            while (resultset.next()){
                cliente=new Cliente();
                cliente.setIdCliente(resultset.getInt(1));
                cliente.setNombreCliente(resultset.getString(2));
                cliente.setApellidoContacto(resultset.getString(3));
                clientes.add(cliente);
            }
        return  clientes;
    }



    public  void eliminarClientePorId(int Id) throws Exception{
        String sql="DELETE FROM cliente WHERE id_cliente = "+Id;
        insertarModificarEliminarDataBase(sql);

    }


}
