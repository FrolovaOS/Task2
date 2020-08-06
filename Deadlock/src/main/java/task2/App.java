package task2;


public class App 
{
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        Thread person1 = new Thread(kitchen, "Ангелина");
        Thread person2 = new Thread(kitchen, "Дарья");
        person1.start();
        person2.start();
    }
}
