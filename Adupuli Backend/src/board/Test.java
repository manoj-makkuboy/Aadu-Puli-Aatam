package board;


public class Test {

	public static void main(String[] args)throws NullPointerException {
		// TODO Auto-generated method stub
     Board p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,
    p19,p20,p21,p22,p23;
     
    p1 = new Board(10,6,"p1");
    p2 = new Board(0,7,"p2");
    p3 = new Board(4,7,"p3");
    p4 = new Board(5,7,"p4");
    p5 = new Board(7,7,"p5");
    p6 = new Board(8,7,"p6");
    p7 = new Board(12,7,"p7");
    p8 = new Board(0,5,"p8");
    p9 = new Board(3,5,"p9");
    p10 = new Board(4.5,5,"p10");
    p11 = new Board(7.5,5,"p11");
    p12 = new Board(9,5,"p12");
    p13 = new Board(12,5,"p13");
    p14 = new Board(0,3,"p14");
    p15 = new Board(2,3,"p15");
    p16 = new Board(4,3,"p16");
    p17 = new Board(8,3,"p17");
    p18 = new Board(10,3,"p18");
    p19 = new Board(12,3,"p19");
    p20 = new Board(1,1,"p20");
    p21 = new Board(3.5,1,"p21");
    p22 = new Board(8.5,1,"p22");
    p23 = new Board(11,1,"p23");    
     
    p2.direction(null, p3, null, p8);  
    p3.direction(p2, p4, p1, p9);
    p4.direction(p3, p5, p1, p10);
    p5.direction(p4, p6, p1, p11);
    p6.direction(p5, p7, p1, p12);
    p7.direction(p6, null, null, p13);
    p8.direction(null, p9, p2, p3);
    p9.direction(p5,p10,p3,p15);
    p10.direction(p9, p11, p4, p16);
    p11.direction(p10, p12, p5, p17);
    p12.direction(p11,p13,p6,p18);
    p13.direction(p12, null, p7, p19);
    p14.direction(null, p15, p8, null);
    p15.direction(p14, p16, p9, p20);
    p16.direction(p15, p17, p10, p21);
    p17.direction(p16, p18, p11, p22);
    p18.direction(p17, p19, p12, p23);
    p19.direction(p18,null,p13,null);
    p20.direction(null,p21,p15,null);
    p21.direction(p20, p22, p16, null);
    p22.direction(p21, p23, p17, null);
    p23.direction(p22,null,p18,null);
    
    p4.add_tiger();   //Default tiger position
    p5.add_tiger(); //Default tiger position 
    p3.add_goat();
    p1.add_goat();
  p4.move_tiger(p4.top);  //moves tiger from p4 to left of p4 i.e. p3 
    
    System.out.println("Tiger at p5 "+p5.tiger+" goat :"+p5.goat);
    System.out.println("Tiger at p4 "+p4.tiger+" goat :"+p4.goat);
    System.out.println("Tiger at p3 "+p3.tiger+" goat :"+p3.goat);
    System.out.println("Tiger at p2 "+p2.tiger+" goat :"+p2.goat);
    System.out.println("Tiger at p1 "+p1.tiger+" goat :"+p1.goat);
    
	}

}
