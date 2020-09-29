/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ASUS
 */
public class Data {
    private String label;
    private String[] attributes;

    public Data(String label) {
        this.label = label;
    }
    
    public Data(String label, String attributes) {
        this.label = label;
        this.attributes = makeArray(attributes);
    }
    
    String[] makeArray(String str) {
        return str.split(", ");
    }
    
    public String getData() {
        String send = this.label + " - ";
        for(int i = 0; i<attributes.length; i++) {
            send += this.attributes[i] + ", ";
        }
        return send;
    }
    
    public String[] getAttributes(){
        return attributes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setAttributes(String[] atr){
        this.attributes = atr;
    }
}
