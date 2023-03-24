/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import javax.swing.JOptionPane;
import pckModelos.ListaPacientesDosModel;
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
    ListaPacientesDosModel ModeloPacientesDos;

    public ListaPacientesController(frmVistaPrincipal VistaMain, frmVistaMedicoUno VistaMedUno, frmVistaMedicoDos VistaMedDos,
            ListaPacientesModel ModeloPacientes, ListaPacientesDosModel ModeloPacientesDos) {
        this.VistaMain = VistaMain;
        this.VistaMedUno = VistaMedUno;
        this.VistaMedDos = VistaMedDos;
        this.ModeloPacientes = ModeloPacientes;
        this.ModeloPacientesDos = ModeloPacientesDos;
        
        //PONER A LA ESCUCHA LOS BOTONES
        this.VistaMain.btnMedicoUno.addActionListener(this);
        this.VistaMain.btnMedicoDos.addActionListener(this);
        this.VistaMain.btnListaPacientesUno.addActionListener(this);
        this.VistaMain.btnListaPacientesDos.addActionListener(this);
        
        //LEVANTAR LAS VISTAS
        this.VistaMain.setExtendedState(frmVistaPrincipal.MAXIMIZED_BOTH);
        this.VistaMain.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.VistaMain.btnListaPacientesUno){
            //LEVANTAR LOS BOTONES DEL FORM MEDICO UNO
            this.VistaMedUno.btnAtenderPaciente.addActionListener(this);
            this.VistaMedUno.btnAtenderTodos.addActionListener(this);
            
            this.VistaMedUno.setLocationRelativeTo(null);
            this.VistaMedUno.setVisible(true);
        }
        if(e.getSource()==this.VistaMedUno.btnAtenderTodos){
            this.VistaMedUno.txtListaMedicoUno.setText("");
            JOptionPane.showMessageDialog(null, "¡Pacientes atendidos!");
        }
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
                        +" --- "+MiListaPacientesUno.getEdad()+"\n";
                this.VistaMedUno.txtListaMedicoUno.setText(cadena);
            }
        }
        if(e.getSource()== this.VistaMain.btnListaPacientesDos){
            //LEVANTAR LOS BOTONES DEL FORM MEDICO DOS
            this.VistaMedDos.btnAtenderPaciente.addActionListener(this);
            this.VistaMedDos.btnAtenderTodos.addActionListener(this);
            
            this.VistaMedDos.setLocationRelativeTo(null);
            this.VistaMedDos.setVisible(true);
        }
        if(e.getSource()==this.VistaMedDos.btnAtenderTodos){
            this.VistaMedDos.txtListaMedicoDos.setText("");
            JOptionPane.showMessageDialog(null, "¡Pacientes atendidos!");
        }
        if(e.getSource()== this.VistaMain.btnMedicoDos){
            this.ModeloPacientesDos.EncolarPacienteDos(this.VistaMain.txtNombres.getText(),
                    this.VistaMain.txtApellidos.getText(),
                    this.VistaMain.txtEdad.getText());
            
            //HAY QUE TRAER LA LISTA PACIENTES DESDE EL MODELO
            Queue <Pacientes> ListaLocalDos = this.ModeloPacientesDos.ListarPacientesDos();
            
            //RECORRER LA LISTA Y LA ASIGNA EN EL TEXT AREA
            String cadenaDos = "";
            for(Pacientes MiListaPacientesDos: ListaLocalDos){
                cadenaDos = cadenaDos + MiListaPacientesDos.getNombres()+" "+MiListaPacientesDos.getApellidos()
                        +" --- "+MiListaPacientesDos.getEdad()+"\n";
                this.VistaMedDos.txtListaMedicoDos.setText(cadenaDos);
            }
        }
    }
}
