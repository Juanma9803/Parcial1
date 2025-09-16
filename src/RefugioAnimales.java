import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class RefugioAnimales{
    public static void main(String[] args) {
        int ID;
        String nombre;
        String raza;
        int edadMeses;
        char tamano;
        boolean vacunado;
        boolean esterilizado;
        boolean adoptado;
        String adoptante;

        Scanner sc = new Scanner(System.in);
        List<Perro> lista = new ArrayList<Perro>();

        int opcion;
        do{
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar perro");
            System.out.println("2. Buscar perro por ID");
            System.out.println("3. Registrar adopción");
            System.out.println("4. Vacunar perro");
            System.out.println("5. Esterilizar perro");
            System.out.println("6. Listar perros disponibles");
            System.out.println("7. Eliminar perro por ID");
            System.out.println("8. Listar perros");
            System.out.println("0. salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("*** Agregar perro ***");
                    System.out.print("Escriba el nombre: ");
                    nombre = sc.next();
                    System.out.print("Escriba el raza: ");
                    raza = sc.next();
                    System.out.print("Escriba el edad en meses: ");
                    edadMeses = sc.nextInt();
                    System.out.print("Escriba el tamaño 'G' = grande, 'Mediano, 'P' = pequeño: ");
                    tamano = sc.next().charAt(0);  // lee la primera letra
                    System.out.print("Estado de la vacunación: ");
                    vacunado = sc.nextBoolean();
                    System.out.print("Estado de esterilización: ");
                    esterilizado= sc.nextBoolean();

                    Perro perro = new Perro(nombre,raza,edadMeses,tamano,vacunado,esterilizado);
                    lista.add(perro);
                    System.out.println("Perro registrado exitosamente");
                    System.out.println(perro.toString());
                    break;

                case 2:
                    System.out.println("*** Buscar perro por ID ***");
                    System.out.print("Escriba el ID del perro: ");
                    ID = sc.nextInt();

                    boolean encontrado = false;

                    for (Perro p : lista) {
                        if (p.getID() == ID) {
                            System.out.println(p); // imprime usando toString()
                            encontrado = true;
                            break; // ya lo encontró, no sigue buscando
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un perro con el ID " + ID);
                    }

                    break;
                case 3:
                    System.out.println("*** Registrar adopción ***");
                    System.out.print("Escriba el ID del perro: ");
                    ID = sc.nextInt();
                    System.out.print("Escriba el nombre del adoptante: ");
                    adoptante = sc.next();

                    boolean encontrado2 = false;

                    for (Perro p : lista) {
                        if (p.getID() == ID) {
                            p.marcarAdoptado(adoptante);
                            System.out.println(p);
                            encontrado2 = true;
                            break;
                        }
                    }

                    if (!encontrado2) {
                        System.out.println("No se encontró un perro con el ID " + ID);
                    }

                    break;
                case 4:
                    System.out.println("*** Vacunar perro ***");
                    System.out.print("Escriba el ID del perro: ");
                    ID = sc.nextInt();
                    boolean encontrado3 = false;
                    for (Perro p : lista) {
                        if (p.getID() == ID) {
                            p.vacunar();
                            System.out.println(p);
                            encontrado3 = true;
                            break;
                        }
                    }
                    if (!encontrado3) {
                        System.out.println("No se encontró un perro con el ID " + ID);
                    }
                    break;
                case 5:
                    System.out.println("*** Esterilizar perro ***");
                    System.out.print("Escriba el ID del perro: ");
                    ID = sc.nextInt();
                    boolean encontrado4 = false;
                    for (Perro p : lista) {
                        if (p.getID() == ID) {
                            p.esterilizar();
                            System.out.println(p);
                            encontrado4 = true;
                            break;
                        }
                    }
                    if (!encontrado4) {
                        System.out.println("No se encontró un perro con el ID " + ID);
                    }
                    break;
                case 6:
                    boolean hayDisponibles = false;
                    for (Perro p : lista) {
                        if (!p.isAdoptado()) {  //solo muestra los perros no adoptados
                            System.out.println(p);
                            hayDisponibles = true;
                        }
                    }

                    if (!hayDisponibles) {
                        System.out.println("No hay perros disponibles en este momento.");
                    }
                    break;

                case 7:
                    System.out.println("*** Eliminar perro ***");
                    System.out.print("Escriba el ID del perro: ");
                    ID = sc.nextInt();

                    boolean eliminado = false;
                    Iterator<Perro> it = lista.iterator();//permite recorrer una colección (como ArrayList, HashSet, etc.) elemento por elemento,
                    while (it.hasNext()) {
                        Perro p = it.next();
                        if (p.getID() == ID) {
                            it.remove();
                            eliminado = true;
                            break;
                        }
                    }

                    if (eliminado) {
                        System.out.println("Perro eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró un perro con el ID " + ID);
                    }
                    break;
                case 8:
                    System.out.println("*** Mostrar todos los perros ***");
                    for (Perro p : lista){
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        }while (opcion !=0);

    }
}




class Perro {
    static int contadorPerros=0; //Declaración de varible static para almacenar el ID
    private int ID;
    private String nombre;
    private String raza;
    private int edadMeses;
    private char tamano;
    private boolean vacunado;
    private boolean esterilizado;
    private boolean adoptado;
    private String adoptante;

    public Perro() {
    }



    public Perro(String nombre, String raza, int edadMeses, char tamano, boolean vacunado, boolean esterilizado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edadMeses = edadMeses;
        this.tamano = tamano;
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
        this.ID = ++Perro.contadorPerros;// Cada vez que se crea un objeto asigna el ID con incremento de +1
    }

    public void vacunar(){
        this.vacunado=true;
    }

    public void esterilizar(){
        this.esterilizado = true;
    }

    public void marcarAdoptado(String adoptante){

        if (this.adoptado == false){
            this.adoptado= true;
            this.adoptante = adoptante;
        }else{
            System.out.println("El perro ya fue adoptado");

        }
    }

    public int calcularEdadHumana(){
        return ((this.edadMeses/12)*7);
    }

    public boolean aptoParaDepartamento() {
        if (this.tamano == 'P' && this.vacunado) {
            return true;
        } else if (this.tamano == 'M' && this.vacunado) {
            return true;
        } else {
            return false;
        }
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }

    public char getTamaño() {
        return tamano;
    }

    public void setTamaño(char tamaño) {
        this.tamano = tamaño;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(String adoptante) {
        this.adoptante = adoptante;
    }

    @Override
    public String toString() {
        return "\n Perro ID: " + ID +
                "\n   Nombre       : " + nombre +
                "\n   Raza         : " + raza +
                "\n   Edad (meses) : " + edadMeses +
                "\n   Tamaño       : " + tamano +

                // Si vacunado es true → muestra "Sí", si es false → muestra "No"
                "\n   Vacunado     : " + (vacunado ? "Sí" : "No") +

                // Si esterilizado es true → muestra "Sí", si es false → muestra "No"
                "\n   Esterilizado : " + (esterilizado ? "Sí" : "No") +

                // Si adoptado es true → muestra "Sí", si es false → muestra "No"
                "\n   Adoptado     : " + (adoptado ? "Sí" : "No") +

                // Si adoptado es true → imprime el nombre del adoptante
                // Si adoptado es false → no muestra nada (cadena vacía "")
                (adoptado ? "\n   Adoptante    : " + adoptante : "") +

                "\n----------------------------------";
    }


}
