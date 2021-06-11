import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("For generating a new language dictionary " +
                "you can put phrases or texts into the system, " +
                "when you are done just tap 'end'");

        List <String> text = new ArrayList<>();

        while(true){
            System.out.println("\nPlease put next phrase/text or tap 'end'");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            text.add(input);
        }

        List <String> words = text.stream()
                .flatMap(x -> Arrays.stream(x.split("\\b")))
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List <String> dublicates = words.stream().filter(e -> Collections.frequency(words, e) > 1)
                .collect(Collectors.toList());

        dublicates.stream()
                .forEach(System.out::println);

        words.stream()
                .distinct()
                .forEach(System.out::println);

        scanner.close();
    }
}
/*
Eigentlich sind die Hotellobbys zu dieser Zeit voll. Touristen stehen am Frühstücksbuffet an, vor Museen und Sehenswürdigkeiten bilden sich lange Warteschlangen. Das ist heuer – zum zweiten Mal in Folge – anders. "Die internationalen Touristen werden wohl noch einige Zeit auf sich warten lassen", sagt Michaela Reitterer, Betreiberin des Boutiquehotels Stadthalle und Präsidentin der Österreichischen Hoteliervereinigung (ÖHV). Am Wochenende würden immer mehr Gäste kommen. Unter der Woche spüre man aber nach wie vor den Ausfall bei Geschäftsreisenden und Kongresstouristen.
*/
