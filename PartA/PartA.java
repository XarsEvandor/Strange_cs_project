// PROJECT TITLE: Midterm PartA
// AUTHOR NAME: GIORGOS-PANAGIOTIS KATSONIS
// PURPOSE OF PROJECT: To aid in ritualistic suicide
// VERSION or DATE: v 1.5   
// AUTHORS: giorgos_katsonis@hotmail.com 
// COPYRIGHT INFORMATION:  Content is copyright © Open Source Guides authors, released under CC-BY-4.0.
import java.util.Scanner;

public class PartA {
    LinkList2 list = new LinkList2();
    int survivalPos = 0;
    int deleted = 0;
    int count = 0;
    
    public int selector(int peopleNum, int suicideNum) {

        //Create the link list in order.
        for (int i = peopleNum; i > 0; i--) {
            list.insertFirst(i);
        }

        //Make the last item of the list point towards the first one.
        list.linkCircle();

        node temp = list.first;

        //Elimination loop. Repeats as many times as there are people to exterminate.
        for (int i = 0; i < peopleNum; i++) {

            //Move temp to the person that is to be exterminated
            for (int k = 1; k < suicideNum; k++) {
                temp = temp.next;
            }

            //Store the position of the victim for posterity
            survivalPos = temp.key;

            //In case there is no other person left, return the winning position
            if (temp.key == temp.next.key) {
                return survivalPos;
            }

            //EXTERMINATE
            list.delete(temp.key);

            //Move the temp to a non-null position.
            temp = temp.next;
        }

        //This will never execute but it was required by the method.
        return survivalPos;
    }
    
    public static void main(String[] args) {
        PartA select = new PartA();
        Scanner userIn = new Scanner(System.in);
        int peopleNum = 0;
        int suicideNum = 0;
        int survivalPos = 0;


        System.out.println(
                "Welcome to the most morbid cs project!\n\nPlease input the number of your soon to be dead peers.");
        System.out.print("Input: ");

        while (true) {
            try {
                peopleNum = userIn.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please input a valid value.");
                System.out.print("Input: ");
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

        survivalPos = select.selector(peopleNum, suicideNum);

        System.out.print("Perfect! Here are the results!\n\nTo survive, please move to the ");

        if (survivalPos%10 == 1 ) 
            System.out.println(survivalPos + "st. position");
        else if (survivalPos%10 == 2)
            System.out.println(survivalPos + "nd. position");
        else if (survivalPos%10 == 3)
            System.out.println(survivalPos + "rd. position");
        else 
            System.out.println(survivalPos + "th. position");
        

    }
}
