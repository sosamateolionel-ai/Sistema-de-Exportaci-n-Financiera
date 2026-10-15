import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

void main() {

    List<ExportadorFinanciero> exportadores = new ArrayList<>();
    exportadores.add(new ExportadorBancoCentral());
    exportadores.add(new ExportadorAgenciaTributaria());

    List<String> balance = Arrays.asList(
            "Activo corriente,450000",
            "Pasivo corriente,210000",
            "Patrimonio neto,240000"
    );

    System.out.println("##### Exportación con datos válidos #####");
    for (ExportadorFinanciero e : exportadores) {
        e.exportar(balance);
    }

    System.out.println("\n##### Exportación con lista vacía #####");
    for (ExportadorFinanciero e : exportadores) {
        e.exportar(new ArrayList<>());
    }

}
