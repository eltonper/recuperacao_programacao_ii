package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class InserirAluno {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do aluno: ");
		String nome = scanner.nextLine();

		System.out.println("Digite o e-mail do aluno: ");
		String email = scanner.nextLine();

		System.out.println("Digite o cpf do aluno: ");
		String cpf = scanner.nextLine();

		System.out.println("Digite a data de nascimento do aluno: ");
		String dataDeNascimento = scanner.nextLine();

		System.out.println("Digite a naturalidade do aluno: ");
		String naturalidade = scanner.nextLine();

		System.out.println("Digite o endereço do aluno: ");
		String endereco = scanner.nextLine();

		scanner.close();

		Aluno aluno1 = new Aluno();
		aluno1.setNome(nome);
		aluno1.setEmail(email);
		aluno1.setCpf(cpf);
		aluno1.setDataDeNascimento(dataDeNascimento);
		aluno1.setNaturalidade(naturalidade);
		aluno1.setEndereco(endereco);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(aluno1);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
