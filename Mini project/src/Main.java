import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentRecordManagementSystemBST list = new StudentRecordManagementSystemBST();

        while (true) {
            System.out.println("(1). Insert Student record. ");
            System.out.println("(2). Delete Student record. ");
            System.out.println("(3). Search Student record. ");
            System.out.println("(4). Show Student record. ");
            System.out.println("(5). Exit! ");
            System.out.print("Enter the Option (1-5) : ");
            int option = sc.nextInt();

            switch (option) {
                case 1 :
                    list.createStudentRecord();
                    break;

                case 2 :
                    System.out.print("Enter the Student Roll : ");
                    int roll = sc.nextInt();
                    list.deleteStudentRecord(list.root, roll);
                    break;

                case 3 :
                    System.out.print("Enter the Student Roll : ");
                    int Roll = sc.nextInt();
                    list.SarchStudentRecord(Roll);
                    break;1

                case  4 :
                    list.showStudentRecord(list.root);
                    System.out.println();
                    break;

                case 5 :
                    System.out.println("Exiting.......");
                    sc.close();
                    return;

                default:
                    System.out.println("Wrong Option!");
            }
        }
    }
}