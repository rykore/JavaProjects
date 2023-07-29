// --== CS400 Project One File Header ==--
// Name: Riya Kore
// CSL Username: kore
// Email: rykore@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmEngineerTests {

    @Test
    public void test1() {
            RedBlackTree<Student> treeOne = new RedBlackTree<>();
            Student student1 = new Student("Arjun Malik", 15,1234);
            Student student2 = new Student("Ryan Rumao", 17,2345);
            Student student3 = new Student("Ishan Bhutoria", 12,3456);
            Student student4 = new Student("Riya Kore", 10,4567);

            treeOne.insert(student1);
            treeOne.insert(student2);
            treeOne.insert(student3);
            treeOne.insert(student4);

            assertEquals(12, treeOne.root.data.getCID());
            assertEquals(15, treeOne.root.leftChild.data.getCID());
            assertEquals(1234, treeOne.search(student1).getSOARID());

    }

    @Test
    public void test2() {

        RedBlackTree<Student> treeTwo = new RedBlackTree<>();
        Student student1 = new Student("Arjun Malik", 15,1234);
        Student student2 = new Student("Ryan Rumao", 17,2345);
        Student student3 = new Student("Ishan Bhutoria", 12,3456);
        Student student4 = new Student("Anish Damani", 10,4567);

        treeTwo.insert(student1);
        treeTwo.insert(student2);
        treeTwo.insert(student3);
        treeTwo.insert(student4);

        assertEquals("Ishan Bhutoria", treeTwo.root.data.getName());
        assertEquals("Arjun Malik", treeTwo.root.leftChild.data.getName());
        assertEquals(3456, treeTwo.search(student3).getSOARID());

    }

    @Test
    public void test3() {

        RedBlackTree<Student> treeThree = new RedBlackTree<>();
        Student student1 = new Student("Arjun Malik", 20,1234);
        Student student2 = new Student("Ryan Rumao", 15,2345);
        Student student3 = new Student("Ishan Bhutoria", 19,3456);
        Student student4 = new Student("Anish Damani", 12,4567);

        treeThree.insert(student1);
        treeThree.insert(student2);
        treeThree.insert(student3);
        treeThree.insert(student4);

        assertEquals(19, treeThree.root.data.getCID());
        assertEquals(20, treeThree.root.leftChild.data.getCID());
        assertEquals(4567, treeThree.search(student4).getSOARID());

    }

    @Test
    public void test4() {

        RedBlackTree<Student> treeFour = new RedBlackTree<>();
        Student student1 = new Student("Arjun Malik", 20,1234);
        Student student2 = new Student("Riya Kore", 15,2345);
        Student student3 = new Student("Ishan Bhutoria", 19,3456);
        Student student4 = new Student("Anish Damani", 12,4567);
        Student student5 = new Student("Adi Menon", 10,5678);

        treeFour.insert(student1);
        treeFour.insert(student2);
        treeFour.insert(student3);
        treeFour.insert(student4);
        treeFour.insert(student5);

        assertEquals("Ishan Bhutoria", treeFour.root.data.getName());
        assertEquals("Anish Damani", treeFour.root.leftChild.data.getName());
        assertEquals("Riya Kore",treeFour.root.rightChild.data.getName());
        assertEquals(5678, treeFour.search(student5).getSOARID());

    }

    @Test
    public void test5() {

        RedBlackTree<Student> treeFive = new RedBlackTree<>();
        Student student1 = new Student("Arjun Malik", 20,1234);
        Student student2 = new Student("Riya Kore", 15,2345);
        Student student3 = new Student("Ishan Bhutoria", 19,3456);
        Student student4 = new Student("Anish Damani", 12,4567);
        Student student5 = new Student("Adi Menon", 10,5678);

        treeFive.insert(student1);
        treeFive.insert(student2);
        treeFive.insert(student3);
        treeFive.insert(student4);
        treeFive.insert(student5);

        assertEquals(19, treeFive.root.data.getCID());
        assertEquals(12, treeFive.root.leftChild.data.getCID());
        assertEquals(15,treeFive.root.rightChild.data.getCID());
        assertEquals(4567, treeFive.search(student4).getSOARID());

        System.out.println(treeFive.toInOrderString());

    }

    @Test
    public void IntegrationTest1() {

        RedBlackTree<Student> integrationTree1 = new RedBlackTree<>();
        Student student1 = new Student("Nikita Agarwal", 40,1234);
        Student student2 = new Student("Mrugank Pednekar", 30,2345);
        Student student3 = new Student("Zee Yacoob", 31,3456);
        Student student4 = new Student("Riya Kore", 15,4567);

        integrationTree1.insert(student1);
        integrationTree1.insert(student2);
        integrationTree1.insert(student3);
        integrationTree1.insert(student4);

        assertEquals("Nikita Agarwal", integrationTree1.root.data.getName());
        assertEquals(2345, integrationTree1.root.leftChild.data.getSOARID());
        assertEquals(15, integrationTree1.search(student4).getCID());

    }

    @Test
    public void IntegrationTest2() {

        RedBlackTree<Student> integrationTree2 = new RedBlackTree<>();
        Student student1 = new Student("Arjun Malik", 31,1234);
        Student student2 = new Student("Riya Kore", 10,2345);
        Student student3 = new Student("Anish Damani", 20,3456);
        Student student4 = new Student("Aleena Zehra", 10,4567);
        Student student5 = new Student("Krithika Shetty", 12,5678);
        Student student6 = new Student("Mrugank Pednekar", 30, 9876);

        integrationTree2.insert(student1);
        integrationTree2.insert(student2);
        integrationTree2.insert(student3);
        integrationTree2.insert(student4);
        integrationTree2.insert(student5);
        integrationTree2.insert(student6);

        assertEquals(31, integrationTree2.root.data.getCID());
        assertEquals("Anish Damani", integrationTree2.root.leftChild.data.getName());
        assertEquals(9876,integrationTree2.root.rightChild.data.getSOARID());
        assertEquals(4567, integrationTree2.search(student4).getSOARID());

    }

    @Test
    public void CodeReviewOfBackendDeveloper1() {

        Student student1 = new Student("Aleena Zehra", 45, 12);
        Student student2 = new Student("Sophie Katchmark", 32, 11);
        Student student3 = new Student("Sarah Williams", 36, 17);
        Student student4 = new Student("Zee Yacoob", 81, 20);

        Student[] arr = new Student[4];
        arr[0] = student1;
        arr[1] = student2;
        arr[2] = student3;
        arr[3] = student4;

        RBTMapper test = new RBTMapper(1, arr);
        test.ParseTree();

        assertEquals("Sarah Williams", test.getStudentRBT().root.data.getName());
        assertEquals("Sophie Katchmark", test.getStudentRBT().root.rightChild.data.getName());
        assertEquals("Aleena Zehra", test.getStudentRBT().root.leftChild.data.getName());

    }

    @Test
    public void CodeReviewOfBackendDeveloper2() {

        Student student1 = new Student("Krithika Shetty", 12, 1234);
        Student student2 = new Student("Elanie Hamilton", 10, 2345);
        Student student3 = new Student("Alex Albon", 18, 3456);

        assertEquals(1, student1.compareTo(student2));
        assertEquals(1, student2.compareTo(student3));
        assertEquals(-1, student3.compareTo(student1));

    }
}
