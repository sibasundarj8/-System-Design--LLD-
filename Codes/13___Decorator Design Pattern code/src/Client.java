import components.ICharacter;
import components.Mario;
import decorators.FireDecorator;
import decorators.StarDecorator;
import decorators.SuperDecorator;

public class Client {
    public static void main(String[] args) {
        ICharacter mario = new Mario();

        System.out.println(mario.getAbilities());

        mario = new SuperDecorator(mario);
        System.out.println(mario.getAbilities());

        mario = new FireDecorator(mario);
        System.out.println(mario.getAbilities());

        mario = new StarDecorator(mario);
        System.out.println(mario.getAbilities());
    }
}
