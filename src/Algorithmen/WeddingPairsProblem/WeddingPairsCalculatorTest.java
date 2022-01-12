package Algorithmen.WeddingPairsProblem;

import Algorithmen.Person;
import Algorithmen.PersonLovesList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WeddingPairsCalculatorTest {

    @Test
    void giveListPairMatch() {
        Person source = new Person(0,true,false,"source",false);
        Person marie = new Person(1,false,false,"marie", true);
        Person susanne = new Person(2,false,false,"susanne", true);
        Person antonie = new Person(3,false,false,"antonie", true);
        Person lena = new Person(4,false,false,"lena", true);
        Person ida = new Person(5,false,false,"ida", true);
        Person anna = new Person(6,false,false,"anna", true);
        Person peter = new Person(7,false,false,"peter", false);
        Person jonas = new Person(8,false,false,"jonas", false);
        Person felix= new Person(9,false,false,"felix", false);
        Person mats = new Person(10,false,false,"mats", false);
        Person aaron = new Person(11,false,false,"aaron", false);
        Person tom = new Person(12,false,false,"tom", false);
        Person trap = new Person(13,false,true,"trap", false);

        ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(marie,susanne,antonie,lena,ida,anna,peter,jonas,felix,mats,aaron,tom));

        PersonLovesList personLovesList = new PersonLovesList(personArrayList,source, trap);
        personLovesList.addWeightForEdgeInDirectedGraph(marie, felix, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(marie, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(peter, lena, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(peter, ida, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(susanne, jonas, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(susanne, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(susanne, peter, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(antonie, aaron, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(antonie, mats, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(lena, peter, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(lena, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(lena, jonas, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(jonas, anna, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(jonas, marie, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(jonas, susanne, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(felix, marie, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(felix, lena, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(felix, anna, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(ida, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(ida, aaron, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(ida, jonas, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(mats, anna, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(mats, antonie, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(anna, peter, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(anna, felix, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(anna, mats, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(aaron, susanne, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(aaron, lena, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(tom, anna, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(tom, ida, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(tom, lena, 1);

        /*personLovesList.addWeightForEdgeInDirectedGraph(marie, felix, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(susanne, jonas, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(antonie, felix, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(antonie, mats, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(lena, peter, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(lena, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(ida, tom, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(anna, felix, 1);
        personLovesList.addWeightForEdgeInDirectedGraph(anna, mats, 1);*/


        WeddingPairsCalculator calculator = new WeddingPairsCalculator();
        personLovesList.printAllPersonsWithTheirPreference(calculator.calculateOptimalListOfWeddingPairs(personLovesList));
        HashMap<Person, Person> controlPersonList = new HashMap<>();
        controlPersonList.put(marie, felix);
        controlPersonList.put(susanne,jonas);
        controlPersonList.put(lena,peter);
        controlPersonList.put(ida,tom);
        controlPersonList.put(antonie,mats);
        Assertions.assertEquals(controlPersonList,calculator.giveListPairMatch(personLovesList));

    }
}