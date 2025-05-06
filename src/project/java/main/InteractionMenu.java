package project.java.main;

import project.java.database.InterconnectingDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import static project.java.services.Entities.cadastrarAluno;
import static project.java.services.Entities.listarMedias;


public class InteractionMenu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE ALUNOS E NOTAS ===");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Adicionar nota a um aluno");
            System.out.println("3. Listar médias dos alunos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno(sc);
                    break;
                case 2:
                    adicionarNota(sc);
                    break;
                case 3:
                    listarMedias();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    private static void cadastrarAluno(Scanner scanner) {
        System.out.print("\nDigite o nome do aluno: ");
        String nome = scanner.nextLine();

        try (Connection conn = InterconnectingDB.conectar()) {
            String sql = "INSERT INTO alunos (nome) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.executeUpdate();
                System.out.println("Aluno cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }


