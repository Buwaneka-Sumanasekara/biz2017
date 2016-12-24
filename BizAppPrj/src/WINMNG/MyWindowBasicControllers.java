/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WINMNG;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;

/**
 *
 * @author HOME
 */
public interface MyWindowBasicControllers {
    public void SaveProcess();
    public void EditMode();
    public void SearchMode();
    public void Refresh();
    public void setShortCutKeys(JInternalFrame f);
    public void setDisableEnableComponents(JComponent[] EnComlist,JComponent[] DisComlist);
    
    
}
