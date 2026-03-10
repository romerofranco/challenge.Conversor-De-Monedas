import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        Gson gson = new Gson();
        int opcion = 0;

        while (opcion != 7) {

            // Menú principal
            System.out.println("*****************************");
            System.out.println("Sea bienvenido/a al Conversor de Monedas");
            System.out.println("");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("*****************************");
            System.out.print("Elija una opción válida: ");
            opcion = scanner.nextInt();

            // Si elige salir
            if (opcion == 7) {
                System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta luego!");
                break;
            }

            // Verifico que la opcion sea valida
            if (opcion < 1 || opcion > 7) {
                System.out.println("Opción no válida, intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese el valor que desea convertir: ");
            double valor = scanner.nextDouble();

            // Defino las monedas segun la opcion elegida
            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1 -> { monedaOrigen = "USD"; monedaDestino = "ARS"; }
                case 2 -> { monedaOrigen = "ARS"; monedaDestino = "USD"; }
                case 3 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
                case 4 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
                case 5 -> { monedaOrigen = "USD"; monedaDestino = "COP"; }
                case 6 -> { monedaOrigen = "COP"; monedaDestino = "USD"; }
            }

            // Consulto la API y calculo
            String resultado = consulta.buscarMoneda(monedaOrigen, monedaDestino);
            Moneda moneda = gson.fromJson(resultado, Moneda.class);
            double valorConvertido = valor * moneda.getTasaConversion();

            System.out.println("");
            System.out.println("El valor de " + valor + " " + monedaOrigen + " corresponde a " + valorConvertido + " " + monedaDestino);
            System.out.println("");
        }

        scanner.close();
    }
}
