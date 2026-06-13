import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * hola profe este es mi index como vera intente abarcar todas las posibles versiones para abrir la terminal vi varios
 * repos y quise hacer mi readme como me la paso instalando para mi linux ahi de los repos ps lo vi bonito y que lo hago
 * y el index se lo copie a un repo la estructura mas que nada pero yo lo adapte a lo que tengo yo ta bonito verda pura 
 * me tarde en hacerlo asi de cabron xd cosa bien echa hermosa 
 * para los archivos que tienen que usar base de datos ahi viene en cada proyecto su base de datos para que lo ejecute
 * me llevo 3 horas ajjajaj
 * necesito acabar lo de quimica espero le haya gustado
 * 
 * profesor usted es el mejor profesor que eh tenido en mucho tiempo
 */
public class Index extends JFrame {
    private final JTextArea descripcion = new JTextArea();
    private final JTextArea salida = new JTextArea();
    private final File raiz = new File(System.getProperty("user.dir"));

    private static class Project {
        String titulo, carpeta, main, descripcion, comando;
        Project(String titulo, String carpeta, String main, String descripcion, String comando) {
            this.titulo = titulo;
            this.carpeta = carpeta;
            this.main = main;
            this.descripcion = descripcion;
            this.comando = comando;
        }
    }

    private final Project[] proyectos = new Project[] {
        new Project("01 - Hola Mundo", "01HolaMundo", "HolaMundo01", "Primer programa en Java. Muestra un mensaje en consola y practica la estructura mínima de una clase con método main.", "cd \"01HolaMundo\" && javac HolaMundo01.java && java HolaMundo01"),
        new Project("02 - Entrada de datos", "02EntradaDatos", "EntradaTexto", "Captura nombre y edad desde consola para practicar entrada de datos, variables y salida formateada.", "cd \"02EntradaDatos\" && javac EntradaTexto.java && java EntradaTexto"),
        new Project("03 - Estructuras de datos y menú de ejercicios", "03EstructuraDatos", "EstructuraDatos", "Menú con ejercicios de descuentos, conversiones, conteos, tienda, áreas, tablas, factorial, figuras y calculadora.", "cd \"03EstructuraDatos\" && javac EstructuraDatos.java && java EstructuraDatos"),
        new Project("04 - Examen: cálculo de instalación de piso", "04EXAMEN", "EXAMEN", "Programa para registrar cliente, mostrar tipos de piso y calcular costo de compra con IVA y descuento.", "cd \"04EXAMEN\" && javac EXAMEN.java && java EXAMEN"),
        new Project("05 - Clases y objetos", "05Clases", "Principal", "Ejercicios organizados con clases, objetos y métodos para separar la lógica del programa principal.", "cd \"05Clases\" && javac *.java && java Principal"),
        new Project("06 - Figuras geométricas", "06Figuras", "FigurasPrincipal", "Calcula áreas y perímetros usando una clase auxiliar para practicar métodos, fórmulas y menú interactivo.", "cd \"06Figuras\" && javac *.java && java FigurasPrincipal"),
        new Project("07 - Arreglos y matrices", "07Arreglos", "Arreglos", "Práctica de arreglos unidimensionales y matrices; captura valores y recorre estructuras con ciclos.", "cd \"07Arreglos\" && javac Arreglos.java && java Arreglos"),
        new Project("08 - Herencia con animales", "08Herencia", "Principal", "Ejemplo de herencia entre Animal y Gato para reutilizar atributos y mostrar información del objeto creado.", "cd \"08Herencia\" && javac *.java && java Principal"),
        new Project("09 - Herencia Persona", "09HerenciasPersona", "herenciaspersona.HerenciaPersona", "Proyecto Maven que aplica herencia con personas/estudiantes y un menú para gestionar datos del estudiante.", "cd \"09HerenciasPersona\" && mvn -q compile exec:java -Dexec.mainClass=herenciaspersona.HerenciaPersona"),
        new Project("10 - Serialización en archivo TXT", "10Serializacion", "Principal", "Guarda y lee datos de una persona en un archivo persona.txt usando lectura y escritura de texto.", "cd \"10Serializacion\" && javac *.java && java Principal"),
        new Project("11 - ArrayList con interfaz", "11ArrayList", "principal.App", "Proyecto Maven con ArrayList y una vista para practicar almacenamiento dinámico y manejo visual de datos.", "cd \"11ArrayList\" && mvn -q compile exec:java -Dexec.mainClass=principal.App"),
        new Project("12 - Examen gestión académica", "12Examen", "examen_4iv9.examen.App", "Sistema con interfaz para manejar estudiantes/profesores y persistencia en archivos de texto.", "cd \"12Examen\" && mvn -q compile exec:java -Dexec.mainClass=examen_4iv9.examen.App"),
        new Project("13 - Ventana Swing", "13Ventana", "Ventana", "Primera ventana con JFrame, JPanel, JLabel y JTextField para practicar interfaces gráficas en Java.", "cd \"13Ventana\" && javac Ventana.java && java Ventana"),
        new Project("14A - CRUD SQL - Maven", "14CRUDSQL/CRUDSQL", "crudsql.CRUDSQL", "CRUD de productos con conexión a MySQL, modelo DAO, vista y controlador. Requiere base de datos configurada.", "cd \"14CRUDSQL/CRUDSQL\" && mvn -q compile exec:java -Dexec.mainClass=crudsql.CRUDSQL"),
        new Project("14B - CRUD SQL - NetBeans/Ant", "14CRUDSQL/NoInternet", "nointernet.NoInternet", "Versión NetBeans del CRUD de productos usando DAO, controlador, vista Swing y conexión a base de datos.", "cd \"14CRUDSQL/NoInternet\" && ant run"),
        new Project("15 - Examen CRUD Boxeo", "15EXAMEN-BOX", "nointernet.NoInternet", "Sistema CRUD para boxeadores con vista Swing, controlador, DAO y conexión a la base de datos box_db.", "cd \"15EXAMEN-BOX\" && mvn -q compile exec:java"),
    };

    public Index() {
        super("Portafolio de evidencias - Vértiz Ángeles José Elías Caleb");
        configurarVentana();
        construirInterfaz();
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 720);
        setLocationRelativeTo(null);
    }

    private void construirInterfaz() {
        JPanel base = new JPanel(new BorderLayout(12, 12));
        base.setBorder(new EmptyBorder(14, 14, 14, 14));
        setContentPane(base);

        JLabel titulo = new JLabel("Portafolio de evidencias - Vértiz Ángeles José Elías Caleb");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        base.add(titulo, BorderLayout.NORTH);

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        for (Project p : proyectos) {
            lista.add(crearTarjeta(p));
            lista.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollLista = new JScrollPane(lista);
        scrollLista.setPreferredSize(new Dimension(590, 0));
        base.add(scrollLista, BorderLayout.CENTER);

        JPanel derecha = new JPanel(new BorderLayout(8, 8));
        descripcion.setEditable(false);
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);
        descripcion.setFont(new Font("Arial", Font.PLAIN, 15));
        descripcion.setText("Selecciona una practica para ver su descripcion. Presiona Ejecutar proyecto para abrirla en una terminal.");
        derecha.add(new JScrollPane(descripcion), BorderLayout.NORTH);

        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setFont(new Font("Monospaced", Font.PLAIN, 13));
        salida.setText("Salida del launcher...\n");
        derecha.add(new JScrollPane(salida), BorderLayout.CENTER);
        base.add(derecha, BorderLayout.EAST);
        derecha.setPreferredSize(new Dimension(410, 0));
    }

    private JPanel crearTarjeta(Project p) {
        JPanel card = new JPanel(new BorderLayout(8, 8));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                new EmptyBorder(10, 10, 10, 10)
        ));

        JLabel nombre = new JLabel(p.titulo);
        nombre.setFont(new Font("Arial", Font.BOLD, 16));
        card.add(nombre, BorderLayout.NORTH);

        JTextArea info = new JTextArea("Main: " + p.main + "\nCarpeta: " + p.carpeta + "\n" + p.descripcion);
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setOpaque(false);
        info.setFont(new Font("Arial", Font.PLAIN, 13));
        card.add(info, BorderLayout.CENTER);

        JButton ejecutar = new JButton("Ejecutar proyecto");
        ejecutar.addActionListener(e -> {
            descripcion.setText(p.titulo + "\n\nMain: " + p.main + "\nCarpeta: " + p.carpeta + "\n\n" + p.descripcion + "\n\nComando:\n" + p.comando);
            ejecutarProyecto(p);
        });
        card.add(ejecutar, BorderLayout.SOUTH);
        return card;
    }

    private void ejecutarProyecto(Project p) {
        File carpeta = new File(raiz, p.carpeta);
        if (!carpeta.exists()) {
            escribir("No se encontro la carpeta: " + carpeta.getAbsolutePath());
            return;
        }
        escribir("Ejecutando: " + p.titulo + "\nComando: " + p.comando + "\n");
        try {
            abrirTerminal(p.comando);
        } catch (Exception ex) {
            escribir("No se pudo abrir una terminal externa. Intentando ejecutar dentro del launcher...\n" + ex.getMessage());
            ejecutarInterno(p.comando);
        }
    }

    private void abrirTerminal(String comando) throws IOException {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("win")) {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", comando).directory(raiz).start();
            return;
        }
        if (os.contains("mac")) {
            String script = "tell application \"Terminal\" to do script " + quoteAppleScript("cd " + shellQuote(raiz.getAbsolutePath()) + " && " + comando);
            new ProcessBuilder("osascript", "-e", script).start();
            return;
        }
        String finalCommand = "cd " + shellQuote(raiz.getAbsolutePath()) + " && " + comando + "; echo; read -p 'Presiona ENTER para cerrar...'";
        String[][] terminales = new String[][] {
                {"konsole", "--workdir", raiz.getAbsolutePath(), "-e", "bash", "-lc", finalCommand},
                {"gnome-terminal", "--", "bash", "-lc", finalCommand},
                {"xfce4-terminal", "--command", "bash -lc " + shellQuote(finalCommand)},
                {"kitty", "bash", "-lc", finalCommand},
                {"xterm", "-e", "bash", "-lc", finalCommand}
        };
        IOException ultima = null;
        for (String[] t : terminales) {
            try {
                new ProcessBuilder(t).directory(raiz).start();
                return;
            } catch (IOException ex) {
                ultima = ex;
            }
        }
        throw ultima == null ? new IOException("No hay terminal disponible") : ultima;
    }

    private void ejecutarInterno(String comando) {
        new Thread(() -> {
            try {
                Process proceso = crearShell(comando).directory(raiz).redirectErrorStream(true).start();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        escribir(linea);
                    }
                }
                escribir("Proceso terminado con codigo: " + proceso.waitFor());
            } catch (Exception ex) {
                escribir("Error al ejecutar: " + ex.getMessage());
            }
        }).start();
    }

    private ProcessBuilder crearShell(String comando) {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("win")) return new ProcessBuilder("cmd", "/c", comando);
        return new ProcessBuilder("bash", "-lc", comando);
    }

    private void escribir(String texto) {
        SwingUtilities.invokeLater(() -> salida.append(texto + "\n"));
    }

    private static String shellQuote(String s) {
        return "'" + s.replace("'", "'\\''") + "'";
    }

    private static String quoteAppleScript(String s) {
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Index().setVisible(true));
    }
}
