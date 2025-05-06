package project.java.services;


import project.java.database.InterconnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class entities {

    public static void cadastrarAluno(String name){

        try (Connection conn = InterconnectingDB.conectar()) {
            String sql = "INSERT INTO alunos (nome) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, name);
                stmt.executeUpdate();
                System.out.println("Aluno cadastrado com sucesso");
            }
            catch (SQLException e) {
                System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}