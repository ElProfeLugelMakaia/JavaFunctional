import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.function.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Supplier
        Supplier<LocalDateTime> now = () -> LocalDateTime.now();
        Supplier<LocalDateTime> yesterday = () -> LocalDateTime.of(2023, 11, 13, 14, 0);
        Supplier<LocalDateTime> tomorrow = () -> LocalDateTime.of(2023, 11, 15, 14, 0);
        Supplier<LocalDateTime> nextYear = () -> LocalDateTime.of(2024, 11, 14, 14, 0);


        Supplier<String> lugelSupplier = () -> "lugel";
        System.out.println(template(lugelSupplier));

        // Consumer
        Consumer<String> print = System.out::println;
        print.accept(lugelSupplier.get());

        // Function
        Function<String, Integer> size = String::length;
        int stringSizs = size.apply(lugelSupplier.get());
        System.out.println(stringSizs);

        // BiFunction
        BiFunction<Integer, Integer, Integer> sum = (a,b) -> a+b;
        System.out.println(sum.apply(2, 2));

        // Predicate
        Predicate<String> nameValidator = (name) -> name.equals("Lugel");
        System.out.println(nameValidator.test(lugelSupplier.get()));
    }

    public static void register(Supplier<LocalDateTime> dateSupplier){
        System.out.println("Hola amigo");

        System.out.println("Ingrese su nombre");
        // Obtener el nombre
        LocalDateTime registerTime = dateSupplier.get();
        //LocalDateTime registerTime = getTime();
        System.out.println("El registro se completó a las " + registerTime);
    }

    public static String template(Supplier<String> nameSupplier) {
        return "Hola " + nameSupplier.get() + " template";
    }

    public static String getNombre(String nombre){
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String nombreReal;
        if(sc.next().equals("-1")){
            nombreReal = nombre;
        } else {
            nombreReal = "";
        }
        return nombreReal;
    }

    public static LocalDateTime getTime() {
        return LocalDateTime.of(2023, 11, 14, 14, 0);
    }
}