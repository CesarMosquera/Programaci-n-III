import java.util.ArrayList;

public class PruebaArrayList {
   public static void main(String[] args) {
    ArrayList<String> nombres= new ArrayList<>();
    nombres.add("Jhon");
    nombres.add("Juan");
    nombres.add("Luis");
    System.out.println(nombres);
    System.out.println(nombres.size());
    nombres.add(1, "Maria");
    System.out.println(nombres);
    int pos=nombres.indexOf("Jhona");
    System.out.println(pos!=-1? "Encontrado":"No encontrado");
    
   } 
}
