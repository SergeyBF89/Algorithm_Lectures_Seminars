package org.Seminar_1.Task_3;

public class Main {
    public static void main(String[] args) {
        Home home = new Home();
        home.setFloor(5);
        home.color = Color.red;
        home.number = 24;
        home.street = "Mendeleeva";

        home.print();
        System.out.println();

        Home home2 = new Home();
        home2.setFloor(2);
        home2.color = Color.white;
        home2.number = 11;
        home2.street = "Mendeleeva";

        home2.print();
    }
    public static class Home {
        private int floor;
        Color color;
        int number;
        String street;

        public void print() {
            System.out.println(floor + " floors");
            System.out.println("Color: " + color);
            System.out.println(street + " " + number);
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }
    }
    enum Color {red, black, white, yellow}


}
