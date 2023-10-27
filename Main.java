import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    private static String[] sentences = {
            "Taki mamy klimat",
            "Wszędzie dobrze ale w domu najlepiej",
            "Wyskoczył jak Filip z konopii",
            "Gdzie kucharek sześć tam nie ma co jeść",
            "Nie ma to jak w domu",
            "Konduktorze łaskawy zabierz nas do Warszawy",
            "Jeżeli nie zjesz obiadu to nie dostaniesz deseru",
            "Bez pracy nie ma kołaczy",
            "Kto sieje wiatr ten zbiera burzę",
            "Być szybkim jak wiatr",
            "Kopać pod kimś dołki",
            "Gdzie raki zimują",
            "Gdzie pieprz rośnie",
            "Swoją drogą to gdzie rośnie pieprz?",
            "Mam nadzieję, że poradzisz sobie z tym zadaniem bez problemu",
            "Nie powinno sprawić żadnego problemu, bo Google jest dozwolony"
    };

    public static void main(String[] args) {
        Map <String,Integer> mapCounter = new HashMap<>();

        for(String sentence : sentences){
            String[] words = divideIntoWords(sentence);
            for(String word : words){
                if(!mapCounter.containsKey(word)){
                    mapCounter.put(word,0);
                }
                mapCounter.merge(word,1,Integer::sum);
            }
        }
        Stream<Map.Entry<String, Integer>> sorted = mapCounter.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

        sorted.limit(3)
                .forEach(counter -> System.out.println(counter.getKey() + " - " + counter.getValue()));

    }

    public static String[] divideIntoWords(String sentence){
        return sentence.toLowerCase().replaceAll("[,?]", "").split("\\s+");
    }

}