import java.util.HashMap;
import java.util.Map;

public class PruebaMapas {
    public static void main(String[] args) {
        Map<Integer, String> nombres = new HashMap<>();
        nombres.put(1, "Jhon");
        nombres.put(2, "Pedro");
        nombres.put(3, "Luis");
        System.out.println(nombres);
        System.out.println(nombres.size());
        System.out.println(nombres.remove(1));
        
        
    }
}
