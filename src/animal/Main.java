package animal;

import java.io.*;

/**
 * Створіть клас Animal.
 * Опишіть у ньому 3 різних поля, створіть конструктор, методи.
 * Створіть файл і виконайте серіалізацію об'єкту Animal, десеріалізацію та виведіть у консоль
 **/

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Raptor", 20, 3);
        File file = new File("src/animal/animal.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            os.writeObject(animal);
            Animal otherAnimal = (Animal) is.readObject();
            System.out.println(otherAnimal);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
