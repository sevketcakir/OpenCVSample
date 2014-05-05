/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opencvsample;
import org.opencv.core.*;

/**
 *
 * @author Şevket
 */
public class OpenCVSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
   {
      /*System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
      Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
      System.out.println( "mat = " + mat.dump() );
      */
       OpenCVGUI frame=new OpenCVGUI();
       frame.setSize(700, 700);
       frame.setVisible(true);
   }
}
