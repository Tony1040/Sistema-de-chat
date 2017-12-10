
package sistema.de.chat;

import control.ControlAplicacion;
import modelo.Modelo;
import vista.VentanaAplicacion;

public class SistemaDeChat {

    public static void main(String[] args) {
        new VentanaAplicacion(new ControlAplicacion(new Modelo())).init();
    }
    
}
