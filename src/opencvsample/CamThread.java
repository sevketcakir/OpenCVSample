/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opencvsample;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.*;
import org.opencv.utils.*;

/**
 *
 * @author Şevket
 */
public class CamThread extends Thread {
    public VideoCapture capture;
    public volatile boolean running=false;
    public Graphics g;
    public Mat img;
    public Mat imgTotal;
    public CamThread(Graphics graphics)
    {
        this.g=graphics;
    }
    public void run()
    {
        running=true;
        capture= new VideoCapture(0);
        capture.open(0);
        img=new Mat();
        imgTotal=new Mat();
        //int i=0;
        while(running)
        {
            capture.read(img);
            //Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);
           //if(img.size()!=imgTotal.size())
            //    imgTotal=img.clone();
            //else
            //    Core.add(img, imgTotal, imgTotal);
            //Core.subtract(imgTotal, img, img);
            //if((i++)%2==0)
                Imgproc.Canny(img, img, 60, 150);
            
            //Imgproc.threshold(img, img, 127, 255, Imgproc.THRESH_BINARY);
            
            //TODO: Some basic image processing operations like erosion, dilation, grey scale conversion
            MatOfByte matOfByte;
            byte[] byteArray=null;
            BufferedImage bufImage = null;
            try {
            matOfByte = new MatOfByte();
            //TODO: Find another way to show images in components. JPEG encode is not appropriate
            Highgui.imencode(".jpg", img, matOfByte); 
            byteArray = matOfByte.toArray();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try {

                InputStream in = new ByteArrayInputStream(byteArray);
                bufImage = ImageIO.read(in);
            } catch (Exception e) {
                e.printStackTrace();
            }   
            g.drawImage(bufImage , 0, 0, null);
        }
        if(capture!=null && capture.isOpened())
            capture.release();
    }    
    public void stopRunning()
    {
        running = false;
    }
    public void startRunning()
    {
       
    }
    
}
