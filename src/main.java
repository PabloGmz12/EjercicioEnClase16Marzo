
import pckControladores.ListaPacientesController;
import pckModelos.ListaPacientesDosModel;
import pckModelos.ListaPacientesModel;
import pckVistas.frmVistaMedicoDos;
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
        frmVistaPrincipal VistaMain = new frmVistaPrincipal();
        frmVistaMedicoUno VistaMedUno = new frmVistaMedicoUno(VistaMain, true);
        frmVistaMedicoDos VistaMedDos = new frmVistaMedicoDos(VistaMain, true);
        ListaPacientesModel ModeloLista = new ListaPacientesModel();
        ListaPacientesDosModel ModeloListaDos = new ListaPacientesDosModel();
        ListaPacientesController ControladorLista = new ListaPacientesController(VistaMain,
                VistaMedUno,VistaMedDos, ModeloLista, ModeloListaDos);
    }
}
