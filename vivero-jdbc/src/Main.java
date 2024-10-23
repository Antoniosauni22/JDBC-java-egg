import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.DAO;
import persistencia.ProductoDAO;

import java.sql.SQLException;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {


        ClienteDAO clienteDAO1=new ClienteDAO();
        Cliente cliente=new Cliente(90,90,"marcelo arambique","marcos ","perez pezo","945678234","fax23AMD","Puerto bermuedez","jaen","peru","24010",2,230.00);
       //  clienteDAO1.guardarCliente(cliente);
      //   clienteDAO1.listarTodosLosClientes();
       // System.out.println(clienteDAO1.listarTodosLosClientes());
        System.out.println(" ELIMINANDO CLIENTES POR ID ");

        clienteDAO1.eliminarClientePorId(90);
        ProductoDAO P1=new ProductoDAO();
        P1.eliminarProducto(50);




    }
}