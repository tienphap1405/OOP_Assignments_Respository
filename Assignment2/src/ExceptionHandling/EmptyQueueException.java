/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExceptionHandling;
import appDomain.AppDriver;
/**
 *
 * @author tienp
 */
public class EmptyQueueException extends Exception{
    public EmptyQueueException(){
        super("Empty Queue!!");
    }
    
 
}
