package action;

import java.io.*;

//*****************************************************
// サンプルテストクラス
//*****************************************************
public class Check {

    //*************************************************
    // ●● テキストファイル処理 ●●
    // 
    // 【1】FileInputStream(String name) で
    // ( InputStream => FileInputStream )
    // InputStream を作成し、
    //
    // 【2】InputStreamReader(InputStream in, String charsetName)
    // ( Reader => InputStreamReader )
    // で Reader を作成し
    //
    // 【3】BufferedReader(Reader in) に渡す
    //*************************************************
    public static void testProc(Object[] param) {

        System.out.println("処理開始");
        System.out.println(((AppWindow)param[0]).titleString);

        String targetFile = "readme.txt";
        String resultFile_utf8n = "readme.utf8n.txt";
        String resultFile_utf8 = "readme.utf8.txt";
        String resultFile_ujis = "readme.ujis.txt";

        try {

            // 生のバイトのストリーム
            // キャラクタセットを指定して読み込む為に、使用する
            // ↓【readme.txt】
            FileInputStream fis = new FileInputStream(targetFile);

            // SHIFT_JIS として読み込む為の準備
            // ↓【 FileInputStream】
            InputStreamReader isr = new InputStreamReader(fis, "SJIS");

            // 行単位で読み込む為の準備
            BufferedReader br = new BufferedReader(isr);

            String line_buffer;

            // BufferedReader は、readLine が null を返すと読み込み終了
            while ( null != (line_buffer = br.readLine() ) ) {
                // コマンドプロンプトに表示
                System.out.println(line_buffer);
            }

            // 各々受け持ちクラスを閉じる
            br.close();
            isr.close();
            fis.close();


            // *******************************************************
            // ※ "UTF8" で、UTF8N になります
            // UTF8N に変換の為、再度同じファイルを入力
            // 今度は入力は変数を使わずに書く
            // *******************************************************
            br = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(targetFile), "SJIS"
                    ) 
            );
            // *******************************************************
            // UTF8N 用の書き込み用のインスタンスを同様に作成
            // *******************************************************
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(resultFile_utf8n), "UTF8"
                    ) 
            );

            while ( null != (line_buffer = br.readLine() ) ) {
                // CrLf にするには、その通りに書き込む
                bw.write( line_buffer + "\r\n" );
            }
            bw.close();
            br.close();


            // *******************************************************
            // BOM( EF BB BF ) 付きにするには自分で先に書き出す
            // *******************************************************
            br = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(targetFile), "SJIS"
                    ) 
            );
            FileOutputStream fos = new FileOutputStream(resultFile_utf8);
            fos.write( 0xef );
            fos.write( 0xbb );
            fos.write( 0xbf );
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                        fos, "UTF8"
                    ) 
            );

            while ( null != (line_buffer = br.readLine() ) ) {
                // CrLf にするには、その通りに書き込む
                bw.write( line_buffer + "\r\n" );
            }
            bw.close();
            fos.close();
            br.close();


            // *******************************************************
            // EUC-JP に変換の為、再度同じファイルを入力
            // *******************************************************
            br = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(targetFile), "SJIS"
                    ) 
            );
            // *******************************************************
            // EUC-JP にするには "EUC_JP" でも "EUC-JP" OK
            // *******************************************************
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(resultFile_ujis), "EUC_JP"
                    ) 
            );

            while ( null != (line_buffer = br.readLine() ) ) {
                bw.write( line_buffer + "\r\n" );
            }
            bw.close();
            br.close();

        }
        catch( Exception e  ) {
            System.out.println(e.getMessage());
        }

        System.out.println("処理終了");

        ((AppWindow)param[0]).MsgOk("処理完了");

    }

}
