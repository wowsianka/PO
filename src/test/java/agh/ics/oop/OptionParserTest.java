package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionParserTest {
    @Test
    public void parse(){
        Animal testAnimal = new Animal();
        String[] testDirection = {"f","b","forward","xx","backward","f"};
        OptionsParser parser = new OptionsParser();
        for (MoveDirection par : parser.parse(testDirection)){
            testAnimal.move(par);
        }
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Północ");


    }
}
