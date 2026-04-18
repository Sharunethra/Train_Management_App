import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainManagement {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("==================================================\n");

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0) {
                bogies.add(new Bogie("Passenger", 100));
            } else {
                bogies.add(new Bogie("Goods", 0));
            }
        }

        long loopStart = System.nanoTime();

        List<Bogie> passengerBogiesLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.type.equals("Passenger")) {
                passengerBogiesLoop.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        long streamStart = System.nanoTime();

        List<Bogie> passengerBogiesStream = bogies.stream()
                .filter(b -> b.type.equals("Passenger"))
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}