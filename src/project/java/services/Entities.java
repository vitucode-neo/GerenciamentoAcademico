package project.java.services;


import project.java.database.InterconnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entities {

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
    public static void adicionaNota(int alunoId, double note) {
        try (Connection conn = InterconnectingDB.conectar()) {
            String sql = "INSERT INTO notas (aluno_id, nota) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, alunoId);
                stmt.setDouble(2, note);
                stmt.executeUpdate();
                System.out.println("Nota cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar nota: " + e.getMessage());
        }
    }



}