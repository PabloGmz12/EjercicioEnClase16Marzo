
import pckControladores.ListaPacientesController;
import pckModelos.ListaPacientesModel;
import pckVistas.frmVistaMedicoUno;
import pckVistas.frmVistaPrincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umg
 */
public class main {
    
    public static void main(String[] args) {
        frmVistaPrincipal VistaMain = new frmVistaPrincipal(null, true);
        frmVistaMedicoUno VistaMedUno = new frmVistaMedicoUno(null, true);
        ListaPacientesModel ModeloLista = new ListaPacientesModel();
        ListaPacientesController ControladorLista = new ListaPacientesController(VistaMain, VistaMedUno, ModeloLista);
    }
}
