package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// *****************************************************
// ポップアップメニューを実装する
// アプリケーション固有のクラス
// *****************************************************
public class AppPopup {

    // *****************************************************
    // コンストラクタ
    // *****************************************************
    public AppPopup() {

    }

    // *****************************************************
    // メインウインドウ用のポップアップメニューの実装
    // *****************************************************
    public void addPopupJFrame( AppWindow target ) {

        JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem;

        // *****************************************************
        // ポップアップメニュー1
        // *****************************************************
        menuItem = new JMenuItem("メニュー項目1");
        menuItem.setFont(new Font("ＭＳ Ｐゴシック", 0, 12));
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

                System.out.println("メニュー1がクリックされました");

                try {

                }
                catch ( Exception ex ) {
                    ex.printStackTrace();
                }

            }
        });
        popup.add(menuItem);

        // *****************************************************
        // セパレータと階層メニュー
        // *****************************************************
        popup.addSeparator();
        JMenu jm = new JMenu("階層メニュー");
        jm.setFont(new Font("ＭＳ Ｐゴシック", 0, 12));
            menuItem = new JMenuItem("階層内のメニュー");
            menuItem.setFont(new Font("ＭＳ Ｐゴシック", 0, 12));
            menuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    System.out.println("階層内のメニューがクリックされました");

                    try {

                    }
                    catch ( Exception ex ) {
                        ex.printStackTrace();
                    }

                }
            });
            jm.add(menuItem);
        popup.add(jm);

        // *****************************************************
        // ポップアップメニュー2
        // *****************************************************
        menuItem = new JMenuItem("メニュー項目2");
        menuItem.setFont(new Font("ＭＳ Ｐゴシック", 0, 12));
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

                System.out.println("メニュー2がクリックされました");

                try {

                }
                catch ( Exception ex ) {
                    ex.printStackTrace();
                }

            }
        });
        popup.add(menuItem);

        // *****************************************************
        // メインウインドウに実装
        // *****************************************************
        target.addMouseListener(new AppPopupListener(popup));


    }

    // *****************************************************
    // ポップアップを表示する為のクラス
    // *****************************************************
    class AppPopupListener extends MouseAdapter {

        JPopupMenu popup;

        AppPopupListener(JPopupMenu popupMenu) {
            this.popup = popupMenu;
        }

        public void mousePressed(MouseEvent e) {
            this.doPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            this.doPopup(e);
        }

        private void doPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                this.popup.show(e.getComponent(),
                    e.getX(), e.getY());
            }
        }
    }
}
