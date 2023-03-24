/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pckModelos;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author huawei
 */
public class ListaPacientesDosModel {
    Queue<Pacientes> ListaPacientesDos = new LinkedList(); 
    
public void EncolarPacienteDos(String name, String ape, String age){
    Pacientes nuevoPacienteDos = new Pacientes(name, ape, age);
    this.ListaPacientesDos.add(nuevoPacienteDos);
    JOptionPane.showMessageDialog(null, "PACIENTE AGREGADO A LA LISTA!");
}

public Queue ListarPacientesDos(){
    return this.ListaPacientesDos;
}

public void DesencolarPacientesDos(){
    this.ListaPacientesDos.poll();
}
}
