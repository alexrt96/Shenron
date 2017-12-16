/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shenron;

import es.upv.dsic.gti_ia.core.AgentID;
import es.upv.dsic.gti_ia.core.AgentsConnection;
import es.upv.dsic.gti_ia.core.SingleAgent;

/**
 *
 * @author alexr
 */
public class Shenron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        SingleAgent agente;
        AgentsConnection.connect("isg2.ugr.es",6000,"test","Leon","Matute",false);
        agente = new agent(new AgentID("agente"));
        agente.start();
    }
    
}
