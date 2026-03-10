public class Moneda {
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public String getMonedaBase() { return base_code; }
    public String getMonedaDestino() { return target_code; }
    public double getTasaConversion() { return conversion_rate; }

    @Override
    public String toString() {
        return "De " + base_code + " a " + target_code + " la tasa es: " + conversion_rate;
    }
}
