/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import pckModelos.ListaPacientesModel;
import pckModelos.Pacientes;
import pckVistas.frmVistaMedicoDos;
import pckVistas.frmVistaMedicoUno;
import pckVistas.frmVistaPrincipal;

/**
 *
 * @author umg
 */
public class ListaPacientesController implements ActionListener{
    
    frmVistaPrincipal VistaMain;
    frmVistaMedicoUno VistaMedUno;
    frmVistaMedicoDos VistaMedDos;
    ListaPacientesModel ModeloPacientes;

    public ListaPacientesController(frmVistaPrincipal VistaMain, frmVistaMedicoUno VistaMedUno, frmVistaMedicoDos VistaMedDos) {
        this.VistaMain = VistaMain;
        this.VistaMedUno = VistaMedUno;
        this.VistaMedDos = VistaMedDos;
        
        //PONER A LA ESCUCHA LOS BOTONES
        this.VistaMain.btnMedicoUno.addActionListener(this);
        this.VistaMain.btnMedicoDos.addActionListener(this);
        this.VistaMain.btnListaPacientesDos.addActionListener(this);
        
        //LEVANTAR LAS VISTAS
        this.VistaMain.setLocationRelativeTo(null);
        this.VistaMain.setVisible(true);
    }

    public ListaPacientesController(frmVistaPrincipal VistaMain, frmVistaMedicoUno VistaMedUno, ListaPacientesModel ModeloLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.VistaMain.btnMedicoUno){
            this.ModeloPacientes.EncolarPaciente(this.VistaMain.txtNombres.getText(),
                    this.VistaMain.txtApellidos.getText(),
                    this.VistaMain.txtEdad.getText());
            
            //HAY QUE TRAER LA LISTA PACIENTES DESDE EL MODELO
            Queue <Pacientes> ListaLocalUno = this.ModeloPacientes.ListarPacientes();
            
            //RECORRER LA LISTA Y LA ASIGNA EN EL TEXT AREA
            String cadena = "";
            for(Pacientes MiListaPacientesUno: ListaLocalUno){
                cadena = cadena + MiListaPacientesUno.getNombres()+" "+MiListaPacientesUno.getApellidos()
                        +"---"+MiListaPacientesUno.getEdad()+"\n";
                this.VistaMedUno.txtListaMedicoUno.setText(cadena);
            }
        }
        if(e.getSource()== this.VistaMain.btnListaPacientesUno){
            this.VistaMedUno.setLocationRelativeTo(null);
            this.VistaMedUno.setVisible(true);
            
        }
    }
    
}
