import java.util.ArrayDeque;
import java.util.Deque;

public class Pansimilar {

    public boolean pansimilar(String panBlanco, String jamon, String panIntegral) {
        Deque<String> sandwich = new ArrayDeque<>();

        sandwich.offer(panBlanco);
        sandwich.offer(jamon);
        sandwich.offer(panIntegral);

        String primerPan = sandwich.peekFirst();
        String ultimoPan = sandwich.peekLast();

        return primerPan.equals(ultimoPan);
    }
}
