/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;

/**
 * @author root
 */
public class Midlet extends MIDlet implements CommandListener{

    List entreeList;
    private Command mExitCommand;
    private Command mAlertCommand;
    Display mDisplay;
    String[] restaurants = {"Burger King","Pizza Hut","Mc Donalds"};
    
    public void startApp() {
     
        entreeList = new List("Select an entree", List.EXCLUSIVE);
        for(int i=0;i<3;i++){
            entreeList.append(restaurants[i], null);
        }      
        
        mExitCommand = new Command("Exit", Command.EXIT, 0);
        mAlertCommand = new Command("Show alert",Command.SCREEN, 0);
        
        entreeList.addCommand(mExitCommand);
        entreeList.addCommand(mAlertCommand);
        entreeList.setCommandListener(this);
        
        mDisplay = Display.getDisplay(this);
            
        mDisplay.setCurrent(entreeList);

    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}

    public void commandAction(Command c, Displayable d) {
        if(d==entreeList){
            
            mDisplay.setCurrent(
                createAlert(entreeList.getSelectedIndex())
            );
        }
    }
    
    private Alert createAlert(int i) {
        Alert mAlert = new Alert(restaurants[i]);
        mAlert.setTimeout(Alert.FOREVER);
        return mAlert;
    }
}
