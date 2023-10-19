import java.util.Scanner;
public class Interactive{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      double speed = 0;
      double distance = 0;
      int choice = 0;
      int choice2 = 0;
      System.out.println("Enter your speed: ");
      System.out.print("---->");
      speed = scan.nextDouble();
      System.out.println("Start - Cebu City (EMall)");
      System.out.println("Route 1 - Minglanilla");
      System.out.println("Route 2 - San Fernando");
      System.out.println("Route 3 - Carcar");
      System.out.println("\nIs Route 4.1 (Barili) obstructed?\n[1] Yes | [2] No");
      System.out.print("---->");
      choice = scan.nextInt();
      switch (choice){
         case 1:
            System.out.println("Route 4.2 - Sibonga");
            System.out.println("\nIs Route 4.2.1 (Dumanjug) obstructed?\n[1] Yes | [2] No");
            System.out.print("---->");
            choice2 = scan.nextInt();
            switch (choice2){
               case 1:
                  //LONGEST ROUTE
                  System.out.println("Route 5 - Argao");
                  System.out.println("Route 5.1 - Ronda");
                  System.out.println("Route 5.2 - Alcantara");
                  System.out.println("END - Moalboal");
                  distance = 103;
                  break;
               case 2:
                  //SECOND LONGEST ROUTE
                  System.out.println("Route 4.2.1 - Dumanjug");
                  System.out.println("Route 4.2.2 - Alcantara");
                  System.out.println("END - Moalboal");
                  distance = 96.2; 
                  break;
               default:
                  System.out.println("Invalid Input");
                  break;
            }
            break;
         case 2:
            //SHORTEST ROUTE
            System.out.println("Route 4.1 - Barili");
            System.out.println("Route 4.1.1 - Dumanjug");
            System.out.println("Route 4.1.2 - Alcantara");
            System.out.println("END - Moalboal");
            distance = 84.9;
            break;
      }
      double est = distance/speed;
      int hours = (int)est;
      double minutes = (est*100) % 100 * 60 / 100;
      if (minutes >= 60){
         minutes = minutes - 60;
         hours++;
      }
      System.out.printf("\nSpeed = %.2f km/hr", speed);
      System.out.printf("\nTotal distance = %.2f km", distance);
      System.out.printf("\nEstimated time of arrival = ~%d hour/s and %.0f minute/s", hours, minutes); //WITH MODULO
   }
}