/*--------------------------------------------------------------------------------------
 *              Name        Frank Brenyah
 *              Course      CMPS-379
 *              Project     Java Final Project
 *              Professor   Ray Ahmadnia
 *              Due Date    Friday Feb. 1, 2013
 *              Date        Thu. Jan 31,2013
 *              Updated     Fri. July 12, 2019
 * 
 * Purpose: Allow the user to reserve/rent a given set of automobiles.
 ------------------------------------------------------------------------------------*/
package java_final_project;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Java_Final_Project extends Applet implements ActionListener
{
    //declare variables
    int compInt=0,      //for compacts
        interInt=0,     //for intermediates
        fullsizeInt=0,  //for fullsized
        nDays;          //number of days variable
        
    boolean reserveONE = false,
            reserveTWO = false,
            reserveTHREE = false;
            
    double totalBill, 
            cost1=29.95, 
            cost2=39.95, 
            cost3=59.95;;
    
    String CAR, carMOD;
    
    Image   compImg[] = new Image[6],
            interImg[] = new Image[5],
            fullImg[] = new Image[6];
            
    String compactPic[] = {"Hyundai-Accent.JPG",
                           "Ford-Focus.JPG",
                           "ford-max.PNG",
                           "Toyota-Yaris.JPG",
                           "Honda-Civic.JPG",
                           "Scion-XD.PNG"};
                           
    String interPic[] = {"Chevrolet-Cruze.JPG",
                         "Mitsubishi-Lancer.JPG",
                         "Dodge-Dart.JPG",
                         "BMW-M3.JPG",
                         "Volvo-S60.JPG"};
                         
    String fullPic[] = {"Nissan-Altima.JPG",
                        "Chrysler-300.JPG",
                        "Ford-Taurus.JPG",
                        "Mercedes-Benz.JPG",
                        "BMW-7.JPG",
                        "Audi-A7.JPG"};
    
    //introduce components to applet
    Label   compBanner = new Label("Brenyah's Rent-a-Car"),
            carTypeLabel = new Label("Type of Cars:"),
            subcomLabel = new Label("Subcompact (Hyundai Accent or similar). $29.95/day"),
            interLabel = new Label("Intermediate (Chevy Cruze or similar). $39.95/day"),
            fullsizeLabel = new Label("Full Size (Toyota Camry or similar). $59.95/day"),
            carSelectedLabel = new Label("Car Selected"),
            numDays = new Label("Select the number of days");
            
    TextArea txtReport = new TextArea();
    
    Button btnNext1 = new Button("Next Car >>"),
           btnNext2 = new Button("Next Car >>"),
           btnNext3 = new Button("Next Car >>"),
           btnRent1 = new Button("Rent Car!"),
           btnRent2 = new Button("Rent Car!"),
           btnRent3 = new Button("Rent Car!"),
           btnReport = new Button("Checkout");
           
    Choice daysDropBox = new Choice();
    
    Font    bannerFont = new Font("Arial", Font.ITALIC+Font.BOLD, 28),
            carTypeFont = new Font("Arial", Font.BOLD, 13);
            
    DecimalFormat df = new DecimalFormat("0.00");
    
    public void init() {
        // set initial applet size
        resize(710,650);
        // set initial applet background color
        setBackground(Color.BLACK);
        setLayout(null);
        
        //applet labels
        compBanner.setLocation(200,15);
        compBanner.setSize(290,30);
        compBanner.setFont(bannerFont);
        compBanner.setForeground(Color.WHITE);
        add(compBanner);
        
        carTypeLabel.setLocation(40,60);
        carTypeLabel.setSize(85,20);
        carTypeLabel.setFont(carTypeFont);
        carTypeLabel.setForeground(Color.WHITE);
        add(carTypeLabel);
        
        carSelectedLabel.setLocation(470,60);
        carSelectedLabel.setSize(85,20);
        carSelectedLabel.setFont(carTypeFont);
        carSelectedLabel.setForeground(Color.WHITE);
        add(carSelectedLabel);
        
        subcomLabel.setLocation(20,100);
        subcomLabel.setSize(290,20);
        subcomLabel.setForeground(Color.WHITE);
        add(subcomLabel);
        
        interLabel.setLocation(20,230);
        interLabel.setSize(280,20);
        interLabel.setForeground(Color.WHITE);
        add(interLabel);
        
        fullsizeLabel.setLocation(20,360);
        fullsizeLabel.setSize(280,20);
        fullsizeLabel.setForeground(Color.WHITE);
        add(fullsizeLabel);
        
        numDays.setLocation(150,530);
        numDays.setSize(150,20);
        numDays.setForeground(Color.WHITE);
        add(numDays);
                
        //rental lenght drop box
        daysDropBox.add("1");
        daysDropBox.add("2");
        daysDropBox.add("3");
        daysDropBox.add("4");
        daysDropBox.add("5");
        add(daysDropBox);
        daysDropBox.setLocation(200,560);
        daysDropBox.setSize(40,25);
        
        //report
        txtReport.setLocation(440,500);
        txtReport.setSize(200,110);
        txtReport.setBackground(Color.LIGHT_GRAY);
        add(txtReport);        
        
        //next buttons
        add(btnNext1);
        btnNext1.setLocation(300,140);
        btnNext1.setSize(85,30);
        btnNext1.setBackground(Color.WHITE);
        btnNext1.addActionListener(this);
        add(btnNext2);
        btnNext2.setLocation(300,270);
        btnNext2.setSize(85,30);
        btnNext2.setBackground(Color.WHITE);
        btnNext2.addActionListener(this);
        add(btnNext3);
        btnNext3.setLocation(300,400);
        btnNext3.setSize(85,30);
        btnNext3.setBackground(Color.WHITE);
        btnNext3.addActionListener(this);
        
        //rent buttons
        add(btnRent1);
        btnRent1.setLocation(309,175);
        btnRent1.setSize(65,30);
        btnRent1.setBackground(Color.YELLOW);
        btnRent1.addActionListener(this);
        add(btnRent2);
        btnRent2.setLocation(309,305);
        btnRent2.setSize(65,30);
        btnRent2.setBackground(Color.YELLOW);
        btnRent2.addActionListener(this);
        add(btnRent3);
        btnRent3.setLocation(309,435);
        btnRent3.setSize(65,30);
        btnRent3.setBackground(Color.YELLOW);
        btnRent3.addActionListener(this);
        add(btnReport);
        btnReport.setLocation(350,550);
        btnReport.setSize(70,30);
        btnReport.setBackground(Color.ORANGE);
        btnReport.addActionListener(this);
        
        //declare initial applet images
        for(int compInt=0; compInt<6; compInt++)
            compImg[compInt] = this.getImage(this.getCodeBase(),compactPic[compInt]);
        for(int interInt=0; interInt<5; interInt++)
            interImg[interInt] = this.getImage(this.getCodeBase(),interPic[interInt]);
        for(int fullsizeInt=0; fullsizeInt<6; fullsizeInt++)
            fullImg[fullsizeInt] = this.getImage(this.getCodeBase(),fullPic[fullsizeInt]);       
    }
    public void paint(Graphics g) {
     
     g.setColor(Color.WHITE);
    
        repaint();
        //applet borders
        g.drawRect(5,5,690,630);//applet border
        g.drawRect(429,109,211,111);//
        g.drawRect(429,239,211,111);//
        g.drawRect(429,369,211,111);//reserved borders
        
        //draw default images
        g.drawImage(compImg[compInt],40,110,210,120,this);
        g.drawImage(interImg[interInt],40,240,210,120,this);
        g.drawImage(fullImg[fullsizeInt],40,370,210,120,this);
        
        //"rent" function
        if(reserveONE==true)
            g.drawImage(compImg[compInt],430,110,210,110,this);
        if(reserveTWO==true)
            g.drawImage(interImg[interInt],430,240,210,110,this);
        if(reserveTHREE==true)
            g.drawImage(fullImg[fullsizeInt],430,370,210,110,this);
    }
    public void actionPerformed(ActionEvent ae) {
        //perform "Next Car" button actions
        if(ae.getSource()==btnNext1) {
            //reset temp to recycle images
            compInt++;
            compInt = compInt%6;
        }
        if(ae.getSource()==btnNext2) {
            //reset temp to recycle images
            interInt++;
            interInt = interInt%5;
        }
        if(ae.getSource()==btnNext3) {
            //reset temp to recycle images
            fullsizeInt++;
            fullsizeInt = fullsizeInt%6;
        }
        //perform "Rent Car!" button actions
        if(ae.getSource()==btnRent1) {
            reserveONE=true;
        }
        if(ae.getSource()==btnRent2) {
            reserveTWO=true;
        }
        if(ae.getSource()==btnRent3) {
            reserveTHREE=true;
        }
        //perform "Checkout!" button actions
        if(ae.getSource()==btnReport) {
            nDays = daysDropBox.getSelectedIndex() + 1;
            if(reserveONE==true) {
                totalBill=cost1; totalBill*=n;
                CAR = "SubCompact";  
                carMOD = compactPic[compInt];//get filename of current pic
                int a = carMOD.indexOf('.');//find beginning of file extention
                carMOD = carMOD.substring(0,a);
                carMOD = carMOD.toUpperCase();
            }
            if(reserveTWO==true) {
                totalBill=cost2; totalBill*=n;
                CAR = "Intermediate";
                carMOD = interPic[interInt];
                int a = carMOD.indexOf('.');
                carMOD = carMOD.substring(0,a);
                carMOD = carMOD.toUpperCase();
            }
            if(reserveTHREE==true) {
                totalBill=cost3; totalBill*=n;
                CAR = "Full Size";
                carMOD = fullPic[fullsizeInt];
                int a = carMOD.indexOf('.');
                carMOD = carMOD.substring(0,a);
                carMOD = carMOD.toUpperCase();
            }
            //set report in textbox
            txtReport.setText (
                "Car Type: "+CAR+"\n"
               +"Car model: "+carMOD+"\n"
               +"No. of Days: "+nDays+"\n"
               +"Total Amount: $"+(df.format(totalBill))
            );            
        }
    }    
    public void update(Graphics gg){paint(gg);}    
}
