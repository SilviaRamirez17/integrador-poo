import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Cliente;
import modelo.Entrenamiento;
import modelo.Tutor;
public class App {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaFuerzaPU");
        EntityManager em = emf. createEntityManager();

        Cliente c1 = new Cliente(39222560, "Osvaldo Emanuel", "Zakowicz", "22/03/96", 'M');
        Entrenamiento e1 = new Entrenamiento("4/07/2022", "Piernas");
        Tutor t1 = new Tutor(12345678, "Pepe", "Perez", "3755123456");

        e1.setClientesAlEntrenamiento(c1);
        e1.setTutor(t1);
        
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(t1);
        em.persist(e1);
        em.getTransaction().commit();
    };       
};
