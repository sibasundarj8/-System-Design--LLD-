package decorators;

import components.ICharacter;

public class SuperDecorator extends CharacterDecorator {
    public SuperDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with height up ";
    }
}