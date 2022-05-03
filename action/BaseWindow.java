package action;

import javax.swing.*;
import java.awt.*;

public class BaseWindow extends JFrame {

    //*************************************************
    // 単純確認メッセージボックス
    //*************************************************
    public void MsgOk(String Message) {

        JOptionPane.showMessageDialog(this, Message);

    }

    // *****************************************************
    // ウインドウの中央移動
    // *****************************************************
    public void centerWindow() {
        centerWindow( 0, 0 );
    }
    public void centerWindow( int offsetY ) {
        centerWindow( offsetY, 0 );
    }
    public void centerWindow(int offsetY,int offsetX) {

        Toolkit Tool;
        Dimension DesktopSize;
        Dimension WindowSize;
        
        Tool = this.getToolkit();
        DesktopSize = Tool.getScreenSize();
        WindowSize = this.getSize();
        this.setLocation(
            (DesktopSize.width-WindowSize.width)/2+offsetX,
            (DesktopSize.height-WindowSize.height)/2+offsetY
        );
        
    }

}
