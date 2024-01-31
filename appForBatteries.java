import java.util.*;

public class appForBatteries {
    public static void main(String[] args) {

        System.out.println("Please enter the DIAMETER(in mm) of the battery:");
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble();
        System.out.println("Please enter the distance(in mm) between each two batteries:");
        double dist = input.nextDouble();
        System.out.println("Putting in mind that Z should be 5 mm above the battery height please enter ");
        System.out.println("The initial X and Y and Z  (PLZ DO NOT FORGET TO PRESS ENTER BETWEEN EACH VALUE) : ");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double z0 = input.nextDouble();
        System.out.println("Please enter the number of circles in the x direction (Horizontally): ");
        int xnum = input.nextInt();
        System.out.println("Please enter the number of circles in the y direction (Vertically): ");
        int ynum = input.nextInt();
        System.out.println("Please enter the speed (in mm/min ex:400,500): ");
        int speed = input.nextInt();

        double step = radius + dist;
        int length = xnum * ynum;
//        flag for y
        boolean count = true;
//      flag for x
        boolean xFlag = true ;


        System.out.println("G21");
        System.out.println("G00"+ " X" + x0 + " Y" + y0 + " Z" + z0 );
        for (int i = 1; i <= length; i++) {
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            z0 -= 5;
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            z0 += 5;
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            y0 += count ? 5 : -5;
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            z0 -= 5;
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            z0 += 5;
            System.out.println("G01"+ " X" + x0 + " Y" + y0 + " Z" + z0 + " F" + speed);
            x0 += xFlag ? step : -step;
//          flag for y place solution
            count = !count;
//            to go to the next line in y direction
            if (i%xnum==0){
//                if(!count){
//                    y0-=5;
//                    count=!count;
//                }
                y0+=step;
                xFlag=!xFlag;
            }
//            System.out.println(x0 + " " + y0 + " " + z0 );
//            z0+=5;
//            System.out.println(x0 + " " + y0 + " " + z0 );
//            z0-=5;
//            System.out.println(x0 + " " + y0 + " " + z0 );
//            y0-=5;
//            System.out.println(x0 + " " + y0 + " " + z0 );
//            z0+=5;
//            System.out.println(x0 + " " + y0 + " " + z0 );
//            z0-=5;
//            System.out.println(x0 + " " + y0 + " " + z0 );
        }

    }


}
