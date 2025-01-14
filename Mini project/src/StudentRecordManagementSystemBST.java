import java.util.Scanner;

public class StudentRecordManagementSystemBST {
    Student root;
    int size;

    StudentRecordManagementSystemBST() {
        size = 0;
    }

    public Student getStudent() {
        Scanner sc = new Scanner(System.in);
        Student newStudent = new Student();

        try {
            System.out.print("Student Name: ");
            newStudent.name = sc.nextLine();

            newStudent.roll = (int) (1 + Math.random() * 100); // Random roll number
            System.out.println("Roll Number: " + newStudent.roll);

            System.out.print("Student Course Enrolled: ");
            newStudent.course = sc.nextLine();

            System.out.print("Student Total Marks (0-100): ");
            newStudent.totalMarks = sc.nextFloat();
            if (newStudent.totalMarks < 0 || newStudent.totalMarks > 100) {
                throw new IllegalArgumentException("Marks should be between 0 and 100.");
            }

            System.out.print("Student CGPA (0.0-4.0): ");
            newStudent.cgpa = sc.nextFloat();
            if (newStudent.cgpa < 0.0 || newStudent.cgpa > 4.0) {
                throw new IllegalArgumentException("CGPA should be between 0.0 and 4.0.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

        return newStudent;
    }

    public void createStudentRecord() {
        Student newStudent = getStudent();
        Student tempStudent = root;

        if(root == null) {
            root = newStudent;
        }
        else {
            while(true) {
                if(newStudent.roll < tempStudent.roll) {
                    if(tempStudent.left == null) {
                        tempStudent.left = newStudent;
                        break;
                    }
                    else {
                        tempStudent = tempStudent.left;
                    }
                }
                else if(newStudent.roll > tempStudent.roll) {
                    if(tempStudent.right == null) {
                        tempStudent.right = newStudent;
                        break;
                    }
                    else {
                        tempStudent = tempStudent.right;
                    }
                }
                else {
                    System.out.println("The Student Roll is exists");
                    break;
                }
            }
        }
    }

    public void SarchStudentRecord(int roll) {
        Student tempStudent = root;

        if (root == null) {
            System.out.println("There are no Student records in this System!");
            return;
        }

        while (true) {
            if (roll < tempStudent.roll) {
                if (tempStudent.left == null) {
                    System.out.println("No Student record found with Roll Number: " + roll);
                    break;
                }
                else {
                    tempStudent = tempStudent.left;
                }
            }
            else if (roll > tempStudent.roll) {
                if (tempStudent.right == null) {
                    System.out.println("No Student record found with Roll Number: " + roll);
                    break;
                }
                else {
                    tempStudent = tempStudent.right;
                }
            }
            else {
                System.out.println("Student Found:");
                System.out.println("Student Name: " + tempStudent.name);
                System.out.println("Student Roll: " + tempStudent.roll);
                System.out.println("Student Course: " + tempStudent.course);
                System.out.println("Student Total Marks: " + tempStudent.totalMarks);
                System.out.println("Student CGPA: " + tempStudent.cgpa);
                break;
            }
        }
    }


    public Student deleteStudentRecord(Student tempStudent, int roll) {
        if (tempStudent == null) {
            System.out.println("No student record found with roll number: " + roll);
            return null;
        }

        if (roll < tempStudent.roll) {
            tempStudent.left = deleteStudentRecord(tempStudent.left, roll);
        } else if (roll > tempStudent.roll) {
            tempStudent.right = deleteStudentRecord(tempStudent.right, roll);
        } else {
            // For no child
            if (tempStudent.left == null && tempStudent.right == null) {
                System.out.println("Successfully deleted student record with roll number: " + roll);
                return null;
            }

            // For one child
            if (tempStudent.left == null) {
                System.out.println("Successfully deleted student record with roll number: " + roll);
                return tempStudent.right;
            } else if (tempStudent.right == null) {
                System.out.println("Successfully deleted student record with roll number: " + roll);
                return tempStudent.left;
            }

            // For two children
            else {
                Student temp = tempStudent.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                tempStudent.name = temp.name;
                tempStudent.roll = temp.roll;
                tempStudent.course = temp.course;
                tempStudent.totalMarks = temp.totalMarks;
                tempStudent.cgpa = temp.cgpa;

                tempStudent.right = deleteStudentRecord(tempStudent.right, temp.roll);
            }
        }
        return tempStudent;
    }




    public void showStudentRecord(Student tempStudent) {
        if(root == null) {
            System.out.println("The Record is empty!");
        }
        else {
            if(tempStudent == null) {
                return;
            }
            // InOder
            showStudentRecord(tempStudent.left);
            System.out.println("Student Name : "+ tempStudent.name);
            System.out.println("Student Roll : "+ tempStudent.roll);
            System.out.println("Student Course : "+ tempStudent.course);
            System.out.println("Student Total Marks : "+ tempStudent.totalMarks);
            System.out.println("Student CGPA : "+ tempStudent.cgpa);
            showStudentRecord(tempStudent.right);
        }

    }
}
