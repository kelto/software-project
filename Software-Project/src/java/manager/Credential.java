/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;



/**
 *
 * @author kelto
 */

public class Credential {
    
    private String ccNumber,address,name;

    public Credential(String ccNumber, String address,String name)
    {
        this.ccNumber = ccNumber;
        this.address = address;
        this.name = name;
    }
    
    public String getCcNumber() {
        return ccNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
