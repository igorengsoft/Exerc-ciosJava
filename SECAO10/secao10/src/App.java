// 1- criar lista V
// 1.1 - importar classes necessárias V  
// 2 - adicionar elementos na lista V
// 2.1 - adicionar elementos na lista com base na posição V
// 3 -  fazer for each com a lista V
// 4 - ver tamanho da lista V
// 5 - remover elementos da lista com base no nome  V
// 5.1 - remover elementos da lista com base na posição V
// 5.2 - remover elementos da lista com base em um predicado V
// 6 - obter posição de um elemento da lista V
// 7 - filtrar elementos da lista V
// 8 - obter um elemento da lista com base em um predicado V

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {

        trainList();
    }

    public static void repetition() {

        int[] vet = {1, 2, 5, 7, 9};

        for(int p = 0; p < vet.length; p++) {

            System.out.printf("%d \n", vet[p]);
        }

        System.out.println("---------");

        for (int num : vet) {

            System.out.println(num);
        }
    }

    public static void trainList() {

        List<String> names = new ArrayList<>();

        names.add("Carlos");
        names.add("João");
        names.add("Jéssica");
        names.add("Hugo");

        System.out.println(names);
        System.out.println("------");

        names.add(0, "Igor");
        System.out.println(names);
        System.out.println("------");

        for(String name : names) {

            System.out.println(name);
        }

        System.out.println("------");

        System.out.println(names.size());
        System.out.println("------");

        names.remove(0);
        System.out.println(names);
        System.out.println("------");

        names.remove("Jéssica");
        System.out.println(names);
        System.out.println("------");

        names.removeIf(x -> x.charAt(0) == 'C');
        System.out.println(names);
        System.out.println("------");

        System.out.println(names.indexOf("João"));
        System.out.println("------");

        List<String> result = names.stream().filter(x -> x.charAt(0) == 'J').collect(Collectors.toList());
        System.out.println(result);
        System.out.println("------");

        String name = names.stream().filter(x -> x.charAt(0) == 'H').findFirst().orElse(null);
        System.out.println(name);
        System.out.println("------");
    }
}
