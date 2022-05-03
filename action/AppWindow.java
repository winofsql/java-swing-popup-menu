package action;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AppWindow extends BaseWindow {

    private JPanel jContentPane = null;
    private JButton jButton = null;

    public int mainWidth = 300;
    public int mainHeight = 200;
    public String titleString = "Swing サンプル";

    // *****************************************************
    // ボタン作成とクリックイベント
    // *****************************************************
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            // メインウインドウに対して、100x30 のボタンを追加
            jButton.setBounds(
                new Rectangle(
                    (mainWidth/2)-50, ((mainHeight-40)/2)-15,
                    100, 30
            )
            );
            jButton.setText("実行");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    System.out.println("ボタンがクリックされました");

                    try {
                        // ボタン処理用クラスの呼び出し
                        Object param[] = {AppWindow.this};
                        Check.testProc(param);

                    }
                    catch ( Exception ex ) {
                        ex.printStackTrace();
                    }

                }
            });
        }
        return jButton;
    }

    // *****************************************************
    // コンストラクタ
    // *****************************************************
    public AppWindow() {
        super();
        initialize();
    }

    // *****************************************************
    // 初期処理
    // *****************************************************
    private void initialize() {
        // ウインドウサイズの決定
        this.setSize(mainWidth, mainHeight);

        // ウインドウ位置の変更
        centerWindow(-200);

        // パネルを適用
        this.setContentPane(getJContentPane());

        // タイトルセット
        this.setTitle(titleString);

        // カレントディレクトリの表示
        File cur = new File("");
        System.out.println(cur.getAbsolutePath());

        AppPopup popup = new AppPopup();
        popup.addPopupJFrame( this );
    }

    // *****************************************************
    // 画面( パネル作成 )
    // *****************************************************
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJButton(), null);
        }
        return jContentPane;
    }

}
