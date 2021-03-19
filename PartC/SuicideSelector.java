import javax.swing.JLabel;

public class SuicideSelector {
    LinkList2 list = new LinkList2();
    LinkList2 listAnalyze = new LinkList2();
    JLabel label;
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

    public int stepSelector(int peopleNum, int suicideNum, int survivalPos, int countButton) {
        //Create the link list in order.
        for (int i = peopleNum; i > 0; i--) {
            listAnalyze.insertFirst(i);
        }

        node temp = listAnalyze.first;

        while (temp.key != survivalPos) {
            temp = temp.next;
        }

        temp.key = 0;

        //Make the last item of the list point towards the first one.
        listAnalyze.linkCircle();

        temp = listAnalyze.first;
        node excluded = listAnalyze.first;

        for (int i = 0; i < countButton; i++) {
            //Move temp to the person that is to be exterminated
            for (int k = 1; k < suicideNum; k++) {
                temp = temp.next;
            }

            excluded = temp;

            //EXTERMINATE
            listAnalyze.delete(temp.key);

            //Move the temp to a non-null position.
            temp = temp.next;
        }

        return excluded.key;
    }

    //Creates the label that will be inserted in the GUI
    public JLabel listCreator(int peopleNum, int count, int survivalPos) {

        for (int i = peopleNum; i > 0; i--) {
            listAnalyze.insertFirst(i);
        }

        node temp = listAnalyze.first;

        while (temp.key != survivalPos) {
            temp = temp.next;
        }

        temp.key = 0;

        temp = listAnalyze.first;

        for (int i = 0; i < count; i++) {
            temp = temp.next;
        }

        label = new JLabel(temp.nameArray[temp.key]);
        
        return label;
    }
    
}
