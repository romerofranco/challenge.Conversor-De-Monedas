import com.google.gson.Gson;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaMoneda consulta = new ConsultaMoneda();
        String resultado = consulta.buscarMoneda("USD", "ARS");

        Gson gson = new Gson();
        Moneda moneda = gson.fromJson(resultado, Moneda.class);

        System.out.println(moneda);
    }
}
