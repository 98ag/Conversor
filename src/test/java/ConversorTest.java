import com.proyectos.Conversor.modelo.Conversor;
import com.proyectos.Conversor.modelo.Moneda;

import java.util.ArrayList;
import java.util.List;

public class ConversorTest {
    public static void main(String[] args) {
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("USD", 400, 0.0010));
        monedas.add(new Moneda("Euro", 500, 0.008));

        System.out.println("1000 pesos son " + Conversor.convertirPesoAMoneda(monedas.get(0), 1000) + "  $USD.");
        System.out.println("100 USD son " + Conversor.convertirMonedaAPeso(monedas.get(0), 100) + " ARS.");
    }
}
