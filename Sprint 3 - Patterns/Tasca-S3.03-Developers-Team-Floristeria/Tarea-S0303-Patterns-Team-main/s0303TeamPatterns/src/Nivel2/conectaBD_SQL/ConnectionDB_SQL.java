package Nivel2.conectaBD_SQL;

import java.sql.*;

public class ConnectionDB_SQL {


        final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/floristeria";
        final String USUARIO = "root";
        final String CLAVE = "";

        public Connection conectar () {
            Connection myConnection = null;
            try {
                //crear conexion
                myConnection = DriverManager.getConnection(URL, USUARIO, CLAVE);
                System.out.println("Connectando.....");

        /*    //crear objeto statment
            Statement myStatement = myConnection.createStatement();
            System.out.println("Connectado con éxito");

            String instruccionSql1 = "SELECT * FROM Floristeria ";
            String instruccionSql2 = "SELECT * FROM arboles";


            myStatement.execute(instruccionSql1);

            //ejecutar la instruccion sql
            ResultSet myResulSet = myStatement.executeQuery(instruccionSql2);  //---> aqui dentro va la query SELECT * FROM ARTICULO

            //recorrer el resulset
            while(myResulSet.next()) {
                System.out.println(myResulSet.getString("Nombre") + " "
                        +myResulSet.getString("Precio") + "€ " +myResulSet.getString("Altura")+ " mts" );
                //---> NOMBRE DE LA COLUMNA QUE QUIERAS IMPRIMIR, se puede concatenar


        }*/


            } catch (Exception e) {

                System.out.println("No se puede conectar al servidor.");
                e.printStackTrace();
            }
            return myConnection;
        }

}
