import java.util.List;

public class Helpers {

    public int indexFinder(List<String> response,String key){

        int index = 0;

        for(int i = 0; i<response.size(); i++){
            if(response.get(i).equals(key)){
                index = i;
                System.out.println(index);
            }
        }
        return index;
    }
}
