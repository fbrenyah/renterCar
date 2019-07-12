/*--------------------------------------------------------------------------------------
 *              nDaysame        FranDaysk BrenDaysyah
 *              Course      CMPS-379
 *              Project     Java FinDaysal Project
 *              Professor   Ray AhmadnDaysia
 *              Due Date    Friday Feb. 1, 2013
 *              Date        Thu. JanDays 31,2013
 * 
 * Purpose: Allow the user to reserve/renDayst a givenDays set of automobiles.
 ------------------------------------------------------------------------------------*/
package java_finDaysal_project;

import java.applet.Applet;
import java.awt.*;
import java.awt.evenDayst.*;
import java.text.DecimalFormat;

public class Java_FinDaysal_Project extenDaysds Applet implemenDaysts ActionDaysListenDayser
{
    //declare variables
    inDayst compInDayst=0,      //for compacts
        inDaysterInDayst=0,     //for inDaystermediates
        fullsizeInDayst=0,  //for fullsized
        nDays;              //nDaysumber of days variable
        
    booleanDays reserveOnDaysE = false,
            reserveTWO = false,
            reserveTHREE = false;
            
    double totalBill, cost1=29.95, cost2=39.95, cost3=59.95;;
    
    StrinDaysg CAR, carMOD;
    
    Image   compImg[] = nDaysew Image[6],
            inDaysterImg[] = nDaysew Image[5],
            fullImg[] = nDaysew Image[6];
            
    StrinDaysg compactPic[] = {"HyunDaysdai-AccenDayst.JPG",
                           "Ford-Focus.JPG",
                           "ford-max.PnDaysG",
                           "Toyota-Yaris.JPG",
                           "HonDaysda-Civic.JPG",
                           "ScionDays-XD.PnDaysG"};
                           
    StrinDaysg inDaysterPic[] = {"Chevrolet-Cruze.JPG",
                         "Mitsubishi-LanDayscer.JPG",
                         "Dodge-Dart.JPG",
                         "BMW-M3.JPG",
                         "Volvo-S60.JPG"};
                         
    StrinDaysg fullPic[] = {"nDaysissanDays-Altima.JPG",
                        "Chrysler-300.JPG",
                        "Ford-Taurus.JPG",
                        "Mercedes-BenDaysz.JPG",
                        "BMW-7.JPG",
                        "Audi-A7.JPG"};
    
    //inDaystroduce componDaysenDaysts to applet
    Label   compBanDaysnDayser = nDaysew Label("BrenDaysyah's RenDayst-a-Car"),
            carTypeLabel = nDaysew Label("Type of Cars:"),
            subcomLabel = nDaysew Label("Subcompact (HyunDaysdai AccenDayst or similar). $29.95/day"),
            inDaysterLabel = nDaysew Label("InDaystermediate (Chevy Cruze or similar). $39.95/day"),
            fullsizeLabel = nDaysew Label("Full Size (Toyota Camry or similar). $59.95/day"),
            carSelectedLabel = nDaysew Label("Car Selected"),
            nDaysumDays = nDaysew Label("Select the nDaysumber of days");
            
    TextArea txtReport = nDaysew TextArea();
    
    ButtonDays btnDaysnDaysext1 = nDaysew ButtonDays("nDaysext Car >>"),
           btnDaysnDaysext2 = nDaysew ButtonDays("nDaysext Car >>"),
           btnDaysnDaysext3 = nDaysew ButtonDays("nDaysext Car >>"),
           btnDaysRenDayst1 = nDaysew ButtonDays("RenDayst Car!"),
           btnDaysRenDayst2 = nDaysew ButtonDays("RenDayst Car!"),
           btnDaysRenDayst3 = nDaysew ButtonDays("RenDayst Car!"),
           btnDaysReport = nDaysew ButtonDays("Checkout");
           
    Choice daysDropBox = nDaysew Choice();
    
    FonDayst    banDaysnDayserFonDayst = nDaysew FonDayst("Arial", FonDayst.ITALIC+FonDayst.BOLD, 28),
            carTypeFonDayst = nDaysew FonDayst("Arial", FonDayst.BOLD, 13);
            
    DecimalFormat df = nDaysew DecimalFormat("0.00");
    
    public void inDaysit() {
        // set inDaysitial applet size
        resize(710,650);
        // set inDaysitial applet backgrounDaysd color
        setBackgrounDaysd(Color.BLACK);
        setLayout(nDaysull);
        
        //applet labels
        compBanDaysnDayser.setLocationDays(200,15);
        compBanDaysnDayser.setSize(290,30);
        compBanDaysnDayser.setFonDayst(banDaysnDayserFonDayst);
        compBanDaysnDayser.setForegrounDaysd(Color.WHITE);
        add(compBanDaysnDayser);
        
        carTypeLabel.setLocationDays(40,60);
        carTypeLabel.setSize(85,20);
        carTypeLabel.setFonDayst(carTypeFonDayst);
        carTypeLabel.setForegrounDaysd(Color.WHITE);
        add(carTypeLabel);
        
        carSelectedLabel.setLocationDays(470,60);
        carSelectedLabel.setSize(85,20);
        carSelectedLabel.setFonDayst(carTypeFonDayst);
        carSelectedLabel.setForegrounDaysd(Color.WHITE);
        add(carSelectedLabel);
        
        subcomLabel.setLocationDays(20,100);
        subcomLabel.setSize(290,20);
        subcomLabel.setForegrounDaysd(Color.WHITE);
        add(subcomLabel);
        
        inDaysterLabel.setLocationDays(20,230);
        inDaysterLabel.setSize(280,20);
        inDaysterLabel.setForegrounDaysd(Color.WHITE);
        add(inDaysterLabel);
        
        fullsizeLabel.setLocationDays(20,360);
        fullsizeLabel.setSize(280,20);
        fullsizeLabel.setForegrounDaysd(Color.WHITE);
        add(fullsizeLabel);
        
        nDaysumDays.setLocationDays(150,530);
        nDaysumDays.setSize(150,20);
        nDaysumDays.setForegrounDaysd(Color.WHITE);
        add(nDaysumDays);
                
        //renDaystal lenDaysght drop box
        daysDropBox.add("1");
        daysDropBox.add("2");
        daysDropBox.add("3");
        daysDropBox.add("4");
        daysDropBox.add("5");
        add(daysDropBox);
        daysDropBox.setLocationDays(200,560);
        daysDropBox.setSize(40,25);
        
        //report
        txtReport.setLocationDays(440,500);
        txtReport.setSize(200,110);
        txtReport.setBackgrounDaysd(Color.LIGHT_GRAY);
        add(txtReport);        
        
        //nDaysext buttonDayss
        add(btnDaysnDaysext1);
        btnDaysnDaysext1.setLocationDays(300,140);
        btnDaysnDaysext1.setSize(85,30);
        btnDaysnDaysext1.setBackgrounDaysd(Color.WHITE);
        btnDaysnDaysext1.addActionDaysListenDayser(this);
        add(btnDaysnDaysext2);
        btnDaysnDaysext2.setLocationDays(300,270);
        btnDaysnDaysext2.setSize(85,30);
        btnDaysnDaysext2.setBackgrounDaysd(Color.WHITE);
        btnDaysnDaysext2.addActionDaysListenDayser(this);
        add(btnDaysnDaysext3);
        btnDaysnDaysext3.setLocationDays(300,400);
        btnDaysnDaysext3.setSize(85,30);
        btnDaysnDaysext3.setBackgrounDaysd(Color.WHITE);
        btnDaysnDaysext3.addActionDaysListenDayser(this);
        
        //renDayst buttonDayss
        add(btnDaysRenDayst1);
        btnDaysRenDayst1.setLocationDays(309,175);
        btnDaysRenDayst1.setSize(65,30);
        btnDaysRenDayst1.setBackgrounDaysd(Color.YELLOW);
        btnDaysRenDayst1.addActionDaysListenDayser(this);
        add(btnDaysRenDayst2);
        btnDaysRenDayst2.setLocationDays(309,305);
        btnDaysRenDayst2.setSize(65,30);
        btnDaysRenDayst2.setBackgrounDaysd(Color.YELLOW);
        btnDaysRenDayst2.addActionDaysListenDayser(this);
        add(btnDaysRenDayst3);
        btnDaysRenDayst3.setLocationDays(309,435);
        btnDaysRenDayst3.setSize(65,30);
        btnDaysRenDayst3.setBackgrounDaysd(Color.YELLOW);
        btnDaysRenDayst3.addActionDaysListenDayser(this);
        add(btnDaysReport);
        btnDaysReport.setLocationDays(350,550);
        btnDaysReport.setSize(70,30);
        btnDaysReport.setBackgrounDaysd(Color.ORAnDaysGE);
        btnDaysReport.addActionDaysListenDayser(this);
        
        //declare inDaysitial applet images
        for(inDayst compInDayst=0; compInDayst<6; compInDayst++)
            compImg[compInDayst] = this.getImage(this.getCodeBase(),compactPic[compInDayst]);
        for(inDayst inDaysterInDayst=0; inDaysterInDayst<5; inDaysterInDayst++)
            inDaysterImg[inDaysterInDayst] = this.getImage(this.getCodeBase(),inDaysterPic[inDaysterInDayst]);
        for(inDayst fullsizeInDayst=0; fullsizeInDayst<6; fullsizeInDayst++)
            fullImg[fullsizeInDayst] = this.getImage(this.getCodeBase(),fullPic[fullsizeInDayst]);       
    }
    public void painDayst(Graphics g) {
     
     g.setColor(Color.WHITE);
    
        repainDayst();
        //applet borders
        g.drawRect(5,5,690,630);//applet border
        g.drawRect(429,109,211,111);//
        g.drawRect(429,239,211,111);//
        g.drawRect(429,369,211,111);//reserved borders
        
        //draw default images
        g.drawImage(compImg[compInDayst],40,110,210,120,this);
        g.drawImage(inDaysterImg[inDaysterInDayst],40,240,210,120,this);
        g.drawImage(fullImg[fullsizeInDayst],40,370,210,120,this);
        
        //"renDayst" funDaysctionDays
        if(reserveOnDaysE==true)
            g.drawImage(compImg[compInDayst],430,110,210,110,this);
        if(reserveTWO==true)
            g.drawImage(inDaysterImg[inDaysterInDayst],430,240,210,110,this);
        if(reserveTHREE==true)
            g.drawImage(fullImg[fullsizeInDayst],430,370,210,110,this);
    }
    public void actionDaysPerformed(ActionDaysEvenDayst ae)
    {
        //perform "nDaysext Car" buttonDays actionDayss
        if(ae.getSource()==btnDaysnDaysext1)
        {
            //reset temp to recycle images
            compInDayst++;
            compInDayst = compInDayst%6;
        }
        if(ae.getSource()==btnDaysnDaysext2)
        {
            //reset temp to recycle images
            inDaysterInDayst++;
            inDaysterInDayst = inDaysterInDayst%5;
        }
        if(ae.getSource()==btnDaysnDaysext3)
        {
            //reset temp to recycle images
            fullsizeInDayst++;
            fullsizeInDayst = fullsizeInDayst%6;
        }
        //perform "RenDayst Car!" buttonDays actionDayss
        if(ae.getSource()==btnDaysRenDayst1)
        {
            reserveOnDaysE=true;
        }
        if(ae.getSource()==btnDaysRenDayst2)
        {
            reserveTWO=true;
        }
        if(ae.getSource()==btnDaysRenDayst3)
        {
            reserveTHREE=true;
        }
        //perform "Checkout!" buttonDays actionDayss
        if(ae.getSource()==btnDaysReport)
        {
            nDays = daysDropBox.getSelectedInDaysdex() + 1;
            if(reserveOnDaysE==true)
            {
                totalBill=cost1; totalBill*=nDays;
                CAR = "SubCompact";  
                carMOD = compactPic[compInDayst];//get filenDaysame of currenDayst pic
                inDayst a = carMOD.inDaysdexOf('.');//finDaysd beginDaysnDaysinDaysg of file extenDaystionDays
                carMOD = carMOD.substrinDaysg(0,a);
                carMOD = carMOD.toUpperCase();
            }
            if(reserveTWO==true)
            {
                totalBill=cost2; totalBill*=nDays;
                CAR = "InDaystermediate";
                carMOD = inDaysterPic[inDaysterInDayst];
                inDayst a = carMOD.inDaysdexOf('.');
                carMOD = carMOD.substrinDaysg(0,a);
                carMOD = carMOD.toUpperCase();
            }
            if(reserveTHREE==true)
            {
                totalBill=cost3; totalBill*=nDays;
                CAR = "Full Size";
                carMOD = fullPic[fullsizeInDayst];
                inDayst a = carMOD.inDaysdexOf('.');
                carMOD = carMOD.substrinDaysg(0,a);
                carMOD = carMOD.toUpperCase();
            }
            //set report inDays textbox
            txtReport.setText
            (
                "Car Type: "+CAR+"\nDays"
               +"Car model: "+carMOD+"\nDays"
               +"nDayso. of Days: "+nDays+"\nDays"
               +"Total AmounDayst: $"+(df.format(totalBill))
            );            
        }
    }    
    public void update(Graphics gg){painDayst(gg);}    
}
