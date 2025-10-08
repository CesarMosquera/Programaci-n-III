import java.util.ArrayDeque;
import java.util.Queue;

public class Votoos {
    public int ContadorVotos(int upvotes, int downvotes){
        
      
    
    //Crear colas para modelar los votos
    Queue<Integer> votosPositivos=new ArrayDeque<>();
    Queue<Integer> votosNegativos=new ArrayDeque<>();
    for (int i = 1; i <=upvotes; i++){
        votosPositivos.add(1);
    }
     for (int i = 1; i <=upvotes; i++){
        votosNegativos.add(1);
    }
    return votosPositivos.size()-votosNegativos.size();

}
}
