/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shenron;

import es.upv.dsic.gti_ia.core.ACLMessage;
import es.upv.dsic.gti_ia.core.AgentID;
import es.upv.dsic.gti_ia.core.SingleAgent;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author alexr
 */
public class agent extends SingleAgent{
    
    public agent(AgentID aid) throws Exception {
        super(aid);
        JSONObject envio = new JSONObject();
        envio.put("user","Leon");
        envio.put("password","Matute");
        enviar_mensaje(envio.toString(),"Shenron",ACLMessage.REQUEST);
        recibir_mensaje();
        enviar_mensaje(envio.toString(),"Shenron",ACLMessage.QUERY_REF);
        recibir_mensaje();
    }
    
    public void enviar_mensaje(String mensaje, String receptor, int performativa){
        System.out.println("Resucitador envia: " +mensaje + " a "+receptor);
        ACLMessage outbox = new ACLMessage();
        outbox.setSender(getAid());
        //Para contestar con la id de la conversacion
        outbox.setReceiver(new AgentID(receptor));
        outbox.setContent(mensaje);
        outbox.setPerformative(performativa);
        this.send(outbox);
    }
    
    public void recibir_mensaje() throws InterruptedException, JSONException{
        ACLMessage inbox = receiveACLMessage();
        if(!inbox.getContent().equals("OK")){
            JSONObject recepcion = new JSONObject(inbox.getContent());
            String recepcion_plano = recepcion.toString();
            if(inbox.getPerformativeInt()==ACLMessage.FAILURE)
                System.out.println("Resucitador: fallo");
            else if(inbox.getPerformativeInt()==ACLMessage.NOT_UNDERSTOOD)
                System.out.println("Resucitador: No entiende");
            else
                System.out.println("Resucitador: " + recepcion_plano);
        }else
            System.out.println("Resucitador: recibe peticion");
    }
    
}
