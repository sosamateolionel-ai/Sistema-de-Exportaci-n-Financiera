import java.util.List;

public class ExportadorBancoCentral extends ExportadorFinanciero {

    public ExportadorBancoCentral() {
        super("Banco Central");
    }

    @Override
    protected void exportarDatos(List<String> registros) {

        System.out.println("[Banco Central] Formato: archivo plano con campos separados por ';'");

        int total = registros.size();

        for (int i = 0; i < total; i++) {
            int progreso = (i + 1) * 100 / total;
            System.out.println("[Banco Central] Enviando registro " + (i + 1) + "/" + total
                    + " (" + progreso + "%): " + registros.get(i).replace(",", ";"));
        }

        System.out.println("[Banco Central] Transferencia completada.");
    }
}