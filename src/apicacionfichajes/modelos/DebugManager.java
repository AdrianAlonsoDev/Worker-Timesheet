/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.modelos;

/**
 *
 * @author adria
 */
public class DebugManager {
    public boolean enabled;
    
    public DebugManager(boolean Enabled){
        enabled = Enabled;
    }
    
    
    
    public void debug(String message) {
        if(enabled)
            System.out.println("[DEBUG]\n" + message);
    }
    
    public void error(String message) {
        if(enabled)
            System.out.println("[ERROR]\n" + message);
    }
    
}
