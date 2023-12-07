package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class RemoverAluno {
	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o Id do aluno a ser excluído: ");
		long id = Long.parseLong(scanner.nextLine());
		scanner.close();

		aluno1 = manager.find(Aluno.class, id);
		

		
		manager.getTransaction().begin(); //inicializar a transação
		manager.remove(aluno1); //linha que faz o hibernate excluir um objeto no banco
		manager.getTransaction().commit(); //Encerramento da transação
		
		manager.close();
		factory.close();
	}

}
