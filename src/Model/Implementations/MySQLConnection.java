package Model.Implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;


    private final String URL="jdbc:mysql://localhost:3306/alumnos";
    private final String User="root";
    private final String Password="1234";

    private MySQLConnection()  {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(URL,User,Password);
            System.out.println("Connection to DB Successful");
        }
        catch (SQLException e){
            throw new RuntimeException("error");
        }
    }
    public static MySQLConnection getInstance (){
        if(instance==null)
        {
            instance=new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
