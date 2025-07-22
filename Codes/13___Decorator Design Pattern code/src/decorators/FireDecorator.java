package decorators;

import components.ICharacter;

public class FireDecorator extends CharacterDecorator {
    public FireDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with gun attribute ";
    }
}