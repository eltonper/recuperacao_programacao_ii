package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class AtualizarAluno {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o id do aluno a ter o registro alterado: ");
		long id = Long.parseLong(scanner.nextLine());

		System.out.println("Digite o novo endereço do aluno: ");
		String novoEndereco = scanner.nextLine();

		System.out.println("Digite o novo email do aluno: ");
		String novoEmail = scanner.nextLine();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();

		Aluno alunoExistente = manager.find(Aluno.class, id);

		alunoExistente.setEndereco(novoEndereco);
		alunoExistente.setEmail(novoEmail);

		manager.getTransaction().begin();
		manager.merge(alunoExistente);
		manager.getTransaction().commit();

		scanner.close();
		manager.close();
		factory.close();
	}
}
