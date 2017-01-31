package mr.mcdonlds;

import jdk.nashorn.internal.objects.annotations.Function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nomane on 17/09/2016.
 */
public class Main {

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("F:\\workspace\\intellij\\java8.jose.paudard\\src\\main\\resources", "mcdonalds.csv"))) {

            List<McDonald> mcdos = lines.map( s -> {
                McDonald mc = new McDonald();
                String [] strings = s.split(",");
                mc.setCity(strings[5]);
                //mc.setAddress();
                return mc;
            }).collect(Collectors.toList());


            /** Compter le nombre de villes  */
            long nTowns = mcdos.stream()
                 .map(McDonald::city)
                 .distinct()
                 .collect(Collectors.counting());

     //       System.out.println("nombre Mcdo ==> " + nTowns);

            // le nombre de Mcdo par ville : table de hashage à la group

            Map<String, Long> map = mcdos.stream()
                    .collect(Collectors.groupingBy(
                            McDonald::city,
                            Collectors.counting()
                            )
                    );

            Optional<Map.Entry<String, Long>> max = map.entrySet().stream()
                    .max(
                            Comparator.comparing(
                                    entry -> entry.getValue()
                            )
                    );
            System.out.println("ville ===> "+ max.get().getKey() + ", nombre McDo ==> " +max.get().getValue());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
