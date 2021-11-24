package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionParserTest {
    @Test
    public void parse(){
        Animal testAnimal = new Animal();
        String[] testDirection = {"f","b","forward","xx","backward","f", "sss","l", "r", "r","forward"};
        OptionsParser parser = new OptionsParser();
        for (MoveDirection par : parser.parse(testDirection)){
            testAnimal.move(par);
        }
        Assertions.assertEquals(testAnimal.toString(), "(3,3):Wschód");
    }

}
