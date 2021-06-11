import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
         final int MIN_FREQUENCY = 1; //вывод слов с заданным количеством повторений
         final String TEXT = "Eigentlich sind die Hotellobbys " +
                "zu dieser Zeit voll. Touristen stehen am Frühstücksbuffet " +
                "an, vor Museen und Sehenswürdigkeiten bilden sich lange " +
                "Warteschlangen. Das ist heuer – zum zweiten " +
                "Mal in Folge – anders. \"Die internationalen Touristen " +
                "werden wohl noch einige Zeit auf sich warten lassen\", " +
                "sagt Michaela Reitterer, Betreiberin des Boutiquehotels " +
                "Stadthalle und Präsidentin der Österreichischen " +
                "Hoteliervereinigung (ÖHV). Am Wochenende würden immer " +
                "mehr Gäste kommen. Unter der Woche spüre man aber nach " +
                "wie vor den Ausfall bei Geschäftsreisenden und Kongresstouristen.\n";

        //функция высшего порядка
        //детерминированная
        //без побочных эффектов
        //используется монада
         List <String> dictionary = words.apply(TEXT).stream()
                .filter(e -> Collections.frequency(words.apply(TEXT), e) >= MIN_FREQUENCY)
                .collect(Collectors.toList());

        dictionary.stream()
                .forEach(System.out::println);

    }
    public static Function<String, List<String>> words = x -> Arrays.stream(x.split("\\b"))
            .map(String::toUpperCase)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
}
