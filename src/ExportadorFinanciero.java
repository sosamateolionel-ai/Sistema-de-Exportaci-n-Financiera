import java.util.List;

public abstract class ExportadorFinanciero {

    protected String destino;

    public ExportadorFinanciero(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    // Método concreto de validación: lo heredan todas las hijas
    protected boolean validarRegistros(List<String> registros) {

        if (registros == null || registros.isEmpty()) {
            System.out.println("[" + destino + "] Error: no hay registros para exportar.");
            return false;
        }

        for (String r : registros) {
            if (r == null || r.trim().isEmpty()) {
                System.out.println("[" + destino + "] Error: se encontró un registro vacío.");
                return false;
            }
        }

        return true;
    }

    // Punto de entrada: valida siempre y luego delega
    public boolean exportar(List<String> registros) {

        System.out.println("\n=== Exportación a " + destino + " ===");

        if (!validarRegistros(registros)) {
            System.out.println("[" + destino + "] Exportación cancelada.");
            return false;
        }

        exportarDatos(registros);
        return true;
    }

    // Cada destino define cómo transforma y envía los datos
    protected abstract void exportarDatos(List<String> registros);
}