package project.java.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class interconnectingDB {
    
        public static Connection conectar() {
            try {
                String url = "jdbc:mysql://localhost:3306/cadastro_alunos";
                String usuario = "Login";
                String senha = "Senha";
                return DriverManager.getConnection(url, usuario, senha);
            } catch (Exception e) {
                throw new RuntimeException("Erro na conexão: " + e);
            }
        }
    }

