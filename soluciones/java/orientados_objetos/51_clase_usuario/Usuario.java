/* Clase Usuario para red social con solicitud */
public class Usuario {
    private String nombre;
    private String correo;
    private int edad;
    private int solicitudesEnviadas;
    private int solicitudesRecibidas;

    public Usuario(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSolicitudesEnviadas() {
        return solicitudesEnviadas;
    }

    public int getSolicitudesRecibidas() {
        return solicitudesRecibidas;
    }

    public void setSolicitudesRecibidas(int cantidad) {
        this.solicitudesRecibidas += cantidad;
    }

    public void enviarSolicitud(Usuario destinario) {
        solicitudesEnviadas++;
        destinario.setSolicitudesRecibidas(1);
    }

    public void mostrarPerfil() {
        System.out.printf("Usuario: %s%nCorreo: %s%nEdad: %d%nSolicitudes enviadas: %d%nSolicitudes recibidas: %d%n%n", nombre, correo, edad, solicitudesEnviadas, solicitudesRecibidas);
    }

    public void compararPopularidad(Usuario otro) {
        System.out.printf("Usuario más popular entre %s y %s: ", nombre, otro.getNombre());

        if (solicitudesRecibidas > otro.getSolicitudesRecibidas()) {
            System.out.printf("%s%n", nombre);
        } else if (solicitudesRecibidas > otro.getSolicitudesRecibidas()) {
            System.out.printf("%s%n", otro.getNombre()); 
        } else {
            System.out.println("Ambos tienen la misma popularidad");
        }
    }

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Jeiron23", "jeiron23@gmail.com", 22);
        Usuario u2 = new Usuario("Junior04", "Junior04@gmail.com", 24);
        Usuario u3 = new Usuario("JeyJey03", "jeyjey03@gmail.com", 23);

        u1.enviarSolicitud(u2);
        u2.enviarSolicitud(u1);
        u2.enviarSolicitud(u3);
        u3.enviarSolicitud(u2);

        u1.mostrarPerfil();
        u2.mostrarPerfil();
        u3.mostrarPerfil();

        u1.compararPopularidad(u2);
        u2.compararPopularidad(u3);
        u3.compararPopularidad(u1);
    }
}