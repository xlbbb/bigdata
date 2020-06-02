package com.gxzy.bigdata;

import java.applet.Applet;
import java.awt.*;

/**
 * Description:
 * Created by wwquan on 2019/11/9 10:09
 */
public class MyApplet extends Applet {
    public String s;

    public void init() {
        s = new String("Hello World !");
    }

    public void paint(Graphics g) {
        g.drawString(s, 25, 25);
    }

}
