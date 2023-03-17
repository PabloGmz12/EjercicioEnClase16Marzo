/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckModelos;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author umg
 */
public class ListaPacientesModel {
    Queue<Pacientes> ListaPacientes = new LinkedList(); 
    
public void EncolarPaciente(String name, String ape, String age){
    Pacientes nuevoPaciente = new Pacientes(name, ape, age);
    this.ListaPacientes.add(nuevoPaciente);
    JOptionPane.showMessageDialog(null, "PACIENTE AGREGADO A LA LISTA!");
}

public Queue ListarPacientes(){
    return this.ListaPacientes;
}

public void DesencolarPacientes(){
    this.ListaPacientes.poll();
}
}
