package decorators;

import components.ICharacter;

public class StarDecorator extends CharacterDecorator {
    public StarDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with limited star power ";
    }
}