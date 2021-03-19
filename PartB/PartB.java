// PROJECT TITLE: Midterm PartB
// AUTHOR NAME: GIORGOS-PANAGIOTIS KATSONIS
// PURPOSE OF PROJECT: To simulate ritualistic suicide
// VERSION or DATE: v 1.6  
// AUTHORS: giorgos_katsonis@hotmail.com 
// COPYRIGHT INFORMATION:  Content is copyright © Open Source Guides authors, released under CC-BY-4.0.
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        SuicideSelector select = new SuicideSelector();
        Scanner userIn = new Scanner(System.in);
        int peopleNum = 0;
        int suicideNum = 0;
        int winPos = 0;

        System.out.println(
                "Welcome to the most morbid cs project!\n\nPlease input the number of your soon to be dead peers. (Up to 40)");
        System.out.print("Input: ");
        while (true) {
            try {
                peopleNum = userIn.nextInt();
                while (true) {
                    //CHANGE THE LIMITS BASED ON THE NUMBER OF peopleNumS PROVIDED
                    if (peopleNum >= 1 && peopleNum <= 40) {
                        break;
                    } else {
                        System.out.println("Please input a valid value.");
                        System.out.print("Input: ");
                        peopleNum = userIn.nextInt();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Please input a valid value.");
                userIn.next();
            }
        }

        System.out.println(
                "Great! Now please input the decided upon number, dictating this twisted game of life and death.");
        System.out.print("Input: ");

        while (true) {
            try {
                suicideNum = userIn.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please input a valid value.");
                System.out.print("Input: ");
                userIn.next();
            }
        }

        winPos = select.selector(peopleNum, suicideNum);

        select.analyticalDisplay(peopleNum, suicideNum, winPos);

        System.out.print("Perfect! Here are the results!\n\nTo survive, please move to the ");

        if (winPos%10 == 1 ) 
            System.out.println(winPos + "st. position");
        else if (winPos%10 == 2)
            System.out.println(winPos + "nd. position");
        else if (winPos%10 == 3)
            System.out.println(winPos + "rd. position");
        else 
            System.out.println(winPos + "th. position");
        

    }
}
