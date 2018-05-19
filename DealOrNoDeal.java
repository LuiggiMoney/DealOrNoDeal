import java.text.*;
import java.util.*;
/**
 * @author LuiggiFernandez
 */
public class DealOrNoDeal {
    static Scanner K = new Scanner(System.in);
    static boolean SelectedValues[] = new boolean [26];
    public static int SelectInitCase() {
        System.out.println(" /$$$$$$$                      /$$        /$$$$$$                  /$$   /$$           /$$$$$$$                      /$$\n" +
                           "| $$__  $$                    | $$       /$$__  $$                | $$$ | $$          | $$__  $$                    | $$\n" +
                           "| $$  \\ $$  /$$$$$$   /$$$$$$ | $$      | $$  \\ $$  /$$$$$$       | $$$$| $$  /$$$$$$ | $$  \\ $$  /$$$$$$   /$$$$$$ | $$\n" +
                           "| $$  | $$ /$$__  $$ |____  $$| $$      | $$  | $$ /$$__  $$      | $$ $$ $$ /$$__  $$| $$  | $$ /$$__  $$ |____  $$| $$\n" +
                           "| $$  | $$| $$$$$$$$  /$$$$$$$| $$      | $$  | $$| $$  \\__/      | $$  $$$$| $$  \\ $$| $$  | $$| $$$$$$$$  /$$$$$$$| $$\n" +
                           "| $$  | $$| $$_____/ /$$__  $$| $$      | $$  | $$| $$            | $$\\  $$$| $$  | $$| $$  | $$| $$_____/ /$$__  $$| $$\n" +
                           "| $$$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$/| $$            | $$ \\  $$|  $$$$$$/| $$$$$$$/|  $$$$$$$|  $$$$$$$| $$\n" +
                           "|_______/  \\_______/ \\_______/|__/       \\______/ |__/            |__/  \\__/ \\______/ |_______/  \\_______/ \\_______/|__/\n");
        System.out.println("CASES:\n\n"
                + "1\t2\t3\t4\t5\n"
                + "6\t7\t8\t9\t10\n"
                + "11\t12\t13\t14\t15\t16\n"
                + "17\t18\t19\t20\t21\n"
                + "22\t23\t24\t25\t26\n");
        int Case;
        do {
            System.out.println("Select your Case!");
            while (!K.hasNextInt()) K.next();
            Case = K.nextInt();
        } while (Case < 1 || Case > 26);
        System.out.println();
        return Case - 1;
    }
    public static int SelectCase(int UserCase) {
        int Case;
        do {
            while (!K.hasNextInt()) K.next();
            Case = K.nextInt();
        } while (Case < 1 || Case > 26 || Case-1 == UserCase  || SelectedValues[Case-1]);
        SelectedValues[Case-1] = true;
        return Case - 1;
    }
    public static int Random() {
        int Op = (int) (Math.random()*26);
        return Op;
    }
    public static int[] RandomCase() {
        int Cases[] = new int [26];
        int Op;
        int Values[] = {1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
        for (int i = 0; i < Cases.length; i++) {
            do {
            Op = Random();
            } while (Values[Op] == 0);
            if (Values[Op] != 0) {
                Cases[i]=Values[Op];
                Values[Op] = 0;
            }
        }
        return Cases;
    }
    /*public static boolean[] SelectedValues() {
        SelectedValues[SelectCase()] = true;
        return SelectedValues;
    }*/
    public static int[] Values(boolean[] SelectedValues, int[] Cases) {
        int x;
        int Values[] = {1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
        for (int i = 0; i < SelectedValues.length; i++) {
            if (SelectedValues[i]) {
                x = Cases[i];
                for (int j = 0; j < Values.length; j++) {
                    if (x == Values[j]) {
                        Values[j] = 0;
                    }
                }
            }
        }
        return Values;
    }
    public static void CaseMenu(int[] Values) {
        System.out.println("Money in the cases:\n"
            + "$"+NumberFormat.getInstance().format(Values[0])+"\t\t$"+NumberFormat.getInstance().format(Values[13])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[1])+"\t\t$"+NumberFormat.getInstance().format(Values[14])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[2])+"\t\t$"+NumberFormat.getInstance().format(Values[15])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[3])+"\t\t$"+NumberFormat.getInstance().format(Values[16])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[4])+"\t\t$"+NumberFormat.getInstance().format(Values[17])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[5])+"\t\t$"+NumberFormat.getInstance().format(Values[18])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[6])+"\t\t$"+NumberFormat.getInstance().format(Values[19])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[7])+"\t\t$"+NumberFormat.getInstance().format(Values[20])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[8])+"\t\t$"+NumberFormat.getInstance().format(Values[21])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[9])+"\t\t$"+NumberFormat.getInstance().format(Values[22])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[10])+"\t\t$"+NumberFormat.getInstance().format(Values[23])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[11])+"\t\t$"+NumberFormat.getInstance().format(Values[24])+"\n"
            + "$"+NumberFormat.getInstance().format(Values[12])+"\t\t$"+NumberFormat.getInstance().format(Values[25])+"\n");
    }
    public static void main(String[] args) {
        int UserCase = SelectInitCase();
        int Cases[] = RandomCase();
        CaseMenu(Values(SelectedValues, Cases));
        game(UserCase, Cases);
    }
    public static int Banking(int[] Values) {
        int Offer = 0;
        int x=0;
        for (int i = 0; i < Values.length; i++) {
            Offer+=Values[i];
            if (Values[i] != 0) {
                x++;
            }
        }    
        return (int)((Offer/x)*0.70);
    }
    public static void game(int UserCase, int[] Cases) {
        int CountBank = 0;
        boolean Deal = false;
        while (!Deal) {
            System.out.println("Select a case");
            SelectCase(UserCase);
            CaseMenu(Values(SelectedValues, Cases));
            CountBank++;
            switch (CountBank) {
                case 7:
                    System.out.println("The bank offers: "+(int)(Banking(Values(SelectedValues, Cases))*0.50));
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+(int)Banking(Values(SelectedValues, Cases))*0.50);
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 13:
                    System.out.println("The bank offers: "+Banking(Values(SelectedValues, Cases))*0.60);
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Banking(Values(SelectedValues, Cases))*0.60);
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 17:
                    System.out.println("The bank offers: "+(int)Banking(Values(SelectedValues, Cases))*0.70);
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Banking(Values(SelectedValues, Cases))*0.70);
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 20:
                    System.out.println("The bank offers: "+Banking(Values(SelectedValues, Cases))*0.80);
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Banking(Values(SelectedValues, Cases))*0.80);
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 22:
                    System.out.println("The bank offers: "+Banking(Values(SelectedValues, Cases))*0.90);
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Banking(Values(SelectedValues, Cases))*0.90);
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 23:
                    System.out.println("The bank offers: "+Banking(Values(SelectedValues, Cases)));
                    System.out.println("Deal Or NoDeal?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Banking(Values(SelectedValues, Cases)));
                        System.out.println("Your original case had: "+Cases[UserCase]);
                    }
                    break;
                case 24:
                    System.out.println("Do you want to change your case?");
                    while (!K.hasNextBoolean())K.next();
                    Deal = K.nextBoolean();
                    if (Deal) {
                        System.out.println("You won: "+Cases[UserCase]);
                    }
                    break;
                default:
                    break;
            }
        }
    }
