public class Aplicacion {

    String nombre;
    String categoria;
    double tamaño;
    double precioUnidad;
    int licenciasDisponibles;
    int licenciasVendidas;

    public Aplicacion(String nombre, String categoria, double tamaño, double precioUnidad, int licenciasDisponibles, int licenciasVendidas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tamaño = tamaño;
        this.precioUnidad = precioUnidad;
        this.licenciasDisponibles = licenciasDisponibles;
        this.licenciasVendidas = licenciasVendidas;
    }

    public Aplicacion() {
    }

    /*Metodos de programador*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    // Agregar setter para el main que usa setTamanoKB
    public void setTamanoKB(int tamanoKB) {
        this.tamaño = tamanoKB;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public void setLicenciasDisponibles(int licenciasDisponibles) {
        this.licenciasDisponibles = licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public void setLicenciasVendidas(int licenciasVendidas) {
        this.licenciasVendidas = licenciasVendidas;
    }

    // Método para comprar licencias
    public void comprarLicencias(int cantidad) {
        this.licenciasDisponibles += cantidad;
        System.out.println("Se compraron " + cantidad + " licencias de " + nombre);
        System.out.println("Licencias disponibles ahora: " + licenciasDisponibles);
    }

    // Método para vender licencias
    public void venderLicencias(int cantidad) {
        if (cantidad <= licenciasDisponibles) {
            this.licenciasDisponibles -= cantidad;
            this.licenciasVendidas += cantidad;
            System.out.println("Se vendieron " + cantidad + " licencias de " + nombre);
            System.out.println("Licencias disponibles ahora: " + licenciasDisponibles);
            System.out.println("Total vendidas: " + licenciasVendidas);
        } else {
            System.out.println("No hay suficientes licencias disponibles. Disponibles: " + licenciasDisponibles);
        }
    }

    // Método estático para encontrar el juego más vendido
    public static Aplicacion encontrarMasVendido(Aplicacion juego1, Aplicacion juego2, Aplicacion juego3, Aplicacion juego4) {
        Aplicacion masVendido = juego1;

        if (juego2.getLicenciasVendidas() > masVendido.getLicenciasVendidas()) {
            masVendido = juego2;
        }
        if (juego3.getLicenciasVendidas() > masVendido.getLicenciasVendidas()) {
            masVendido = juego3;
        }
        if (juego4.getLicenciasVendidas() > masVendido.getLicenciasVendidas()) {
            masVendido = juego4;
        }

        return masVendido;
    }

    public double calcularDescuento(int licenciasRompecabezas, int licenciasDeportes, int licenciasAccion) {
        // Verificar promoción 1 (20% descuento)
        if (licenciasRompecabezas >= 25) {
            return 0.20; // 20% de descuento
        }

        // Verificar promoción 2 (15% descuento)
        if (licenciasDeportes >= 20 && licenciasAccion >= 15) {
            return 0.15; // 15% de descuento
        }

        return 0.0; // Sin descuento
    }

    public double aplicarDescuento(double valorTotal, double porcentajeDescuento) {
        double descuento = valorTotal * porcentajeDescuento;
        return valorTotal - descuento;
    }

    // Métodos para imprimir en consola
    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Tamaño: " + tamaño + " KB");
        System.out.println("Precio unidad: $" + precioUnidad);
    }

    public void imprimirLicencias() {
        System.out.println("Licencias disponibles: " + licenciasDisponibles);
        System.out.println("Licencias vendidas: " + licenciasVendidas);
    }

    public void imprimirIngresosTotales() {
        double ingresos = licenciasVendidas * precioUnidad;
        System.out.println("Ingresos totales (vendidas * precio unidad): $" + ingresos);
    }

    // Método para imprimir información del juego más vendido
    public void imprimirMasVendido() {
        System.out.println("=== JUEGO MÁS VENDIDO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Licencias vendidas: " + licenciasVendidas);
        System.out.println("Precio por unidad: $" + precioUnidad);
        double ingresos = licenciasVendidas * precioUnidad;
        System.out.println("Ingresos generados: $" + ingresos);
    }

    public void imprimirPrecioConPromocion(int licenciasRompecabezas, int licenciasDeportes, int licenciasAccion) {
        double porcentaje = calcularDescuento(licenciasRompecabezas, licenciasDeportes, licenciasAccion);
        double total = licenciasVendidas * precioUnidad;
        double totalConDescuento = aplicarDescuento(total, porcentaje);
        System.out.println("Porcentaje de descuento aplicado: " + (porcentaje * 100) + "%");
        System.out.println("Total antes de descuento: $" + total);
        System.out.println("Total después de descuento: $" + totalConDescuento);
    }
}
