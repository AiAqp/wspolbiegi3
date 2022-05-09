package com.wspolbiegi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileParallel {

    private List<HWRecord> records;

    public void loadNewList(String file_path, long skip, long lim) {
        Pattern pattern = Pattern.compile(",");
        Path path = Paths.get(file_path);
        try (Stream<String> lines = Files.lines(path).parallel()) {
            records = lines
                .skip(skip)
                .limit(lim)
                .map(line -> {
                    String[] arr = pattern.split(line);
                    return new HWRecord(
                        Integer.parseInt(arr[0]),
                        Double.parseDouble(arr[1]),
                        Double.parseDouble(arr[2])
                    );
                })
                .collect(Collectors.toList());
        } catch (IOException ex) {
            //
        }
    }

    public double getAverageHeight() {
        return records.parallelStream().mapToDouble(HWRecord::getHeight).average().getAsDouble();
    }

    public double getAverageWeight() {
        return records.parallelStream().mapToDouble(HWRecord::getWeight).average().getAsDouble();
    }

    public void printFile() {
        System.out.println("parallelStream()");
        records.forEach(r -> {
            r.toMetric();
            System.out.println(
                r.getID()+" "
                    +r.getWeight()+" "
                    + r.getHeight()+" BMI : "
                    +r.getBMI());
        });
        System.out.println("W avg: "+getAverageWeight()+
            " H avg: "+getAverageHeight());
    }
}

