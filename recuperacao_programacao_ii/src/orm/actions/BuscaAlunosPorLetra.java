package orm.actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Aluno;

public class BuscaAlunosPorLetra {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a letra inicial do aluno para localizar: ");
		String letra = scanner.nextLine();
		scanner.close();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select a from Aluno as a where a.nome LIKE :letraBuscada");
		query.setParameter("letraBuscada", letra + "%");

		List<Aluno> lista = query.getResultList();

			
		System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", "Id", "Nome", "E-mail", "CPF", "Data de Nascimento",
				"Naturalidade", "Endereco");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");

		for (Aluno a : lista) {
			System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", a.getId(), a.getNome(), a.getEmail(), a.getCpf(),
					a.getDataDeNascimento(), a.getNaturalidade(), a.getEndereco());
		}
		

		manager.close();
		factory.close();

	}

}
