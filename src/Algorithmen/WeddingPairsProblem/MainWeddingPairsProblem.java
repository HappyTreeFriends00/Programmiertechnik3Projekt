package Algorithmen.WeddingPairsProblem;

import Algorithmen.Person;
import Algorithmen.PersonLovesList;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MainWeddingPairsProblem {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        System.out.println("Bitte geben Sie alle Person für die Liebesliste ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMorePerson = true;
        boolean givesMoreWeightBetweenNodes = true;
        int index = 1;
        while (giveMorePerson) {
            if (scanner.hasNext()) {
                String personName = scanner.next();
                if (personName.equals("fertig")) {
                    giveMorePerson = false;
                    break;
                }
                System.out.println("welches Geschelcht hat die Person m für männlich und f für weiblich");
                String geschlecht = scanner.next();
                if (personArrayList.isEmpty()) {
                    Person person;
                    if (geschlecht.equals("f")) {
                        person = new Person(index, false, false, personName, true);
                    } else {
                        person = new Person(index, false, false, personName, false);
                    }
                    personArrayList.add(person);
                    System.out.println("Die nächste Person");
                    index++;
                } else {
                    boolean houseExist = false;
                    for (Person personForControlOfDuplicate : personArrayList) {
                        if (personForControlOfDuplicate.getName().equals(personName)) {
                            System.out.println("Die Person existiert bereits");
                            houseExist = true;
                        }
                    }
                    if (!houseExist) {
                        Person person;
                        if (geschlecht.equals("f")) {
                            person = new Person(index, false, false, personName, true);
                        } else {
                            person = new Person(index, false, false, personName, false);
                        }
                        personArrayList.add(person);
                        System.out.println("Die nächste Person");
                        index++;
                    }
                }
            } else {
                giveMorePerson = false;
            }
        }
        Person source = new Person(0, true, false, "source", false);
        Person trap = new Person(index + 1, false, true, "trap", false);
        PersonLovesList personLovesList = new PersonLovesList(personArrayList, source, trap);

        System.out.println("Als nächstes braucht die Software noch die Angaben wer wen toll findet, dafür bitte als erste Person die angeben die eine andere Person toll findet");

        while (givesMoreWeightBetweenNodes) {
            System.out.println("Die erste Person");
            if (scanner.hasNext()) {
                String firstPerson = scanner.next();
                String secondePerson = null;
                int weight = 1;
                if (firstPerson.equals("fertig")) {
                    givesMoreWeightBetweenNodes = false;
                    break;
                }
                System.out.println("Die zweite Person bitte");
                if (scanner.hasNext()) {
                    secondePerson = scanner.next();
                }
                personLovesList.addWeightForEdgeInDirectedGraph(personLovesList.findPersonWithSurname(firstPerson), personLovesList.findPersonWithSurname(secondePerson), weight);
            }
        }
        WeddingPairsCalculator calculator = new WeddingPairsCalculator();

        for (Map.Entry<Person,Person> entry: calculator.giveListPairMatch(personLovesList).entrySet()) {
            System.out.println(entry.getKey().getPersonName() + " passt zu " + entry.getValue().getPersonName());
        }
    }
}
