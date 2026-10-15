import java.util.List;

public class ExportadorAgenciaTributaria extends ExportadorFinanciero {

    public ExportadorAgenciaTributaria() {
        super("Agencia Tributaria");
    }

    @Override
    protected void exportarDatos(List<String> registros) {

        System.out.println("[Agencia Tributaria] Formato: XML firmado digitalmente");
        System.out.println("<declaracion>");

        for (int i = 0; i < registros.size(); i++) {
            System.out.println("  <registro id=\"" + (i + 1) + "\">" + registros.get(i) + "</registro>");
        }

        System.out.println("</declaracion>");
        System.out.println("[Agencia Tributaria] Declaración enviada (" + registros.size() + " registros).");
    }
}