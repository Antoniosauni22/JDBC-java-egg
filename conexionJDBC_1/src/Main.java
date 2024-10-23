//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     DAO dao=new DAOimpl(); // implementamos la clase concreta DAOimplem al instanciar un objeto
        // de tipo clase abstracto DAO

        dao.connectarDataBase();
        dao.desconectDatabase();

    }
}