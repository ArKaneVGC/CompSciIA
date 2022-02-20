package com.danielkyu2004.ibslia.Objects.Display;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GroupPanel extends JPanel {
    private GridBagConstraints gbc;
    private GridBagLayout gbl;

    public GroupPanel(){
        this.setBorder(new LineBorder(Color.BLACK));
        gbc=new GridBagConstraints();
        gbl=new GridBagLayout();
        this.setLayout(gbl);
    }

    public GroupPanel(String title){
        this.setBorder(new TitledBorder(title));
        gbc=new GridBagConstraints();
        gbl=new GridBagLayout();
        this.setLayout(gbl);
    }



    public Component add(Component comp, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.anchor=anchor;
        gbc.fill=fill;
        gbc.insets=insets;
        gbc.ipadx=ipadx;
        gbc.ipady=ipady;
        gbl.setConstraints(comp,gbc);

        return add(comp);
    }
}
