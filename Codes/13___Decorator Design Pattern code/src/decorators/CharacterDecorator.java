package decorators;

import components.ICharacter;

public abstract class CharacterDecorator implements ICharacter {
    protected ICharacter character;

    public CharacterDecorator (ICharacter character) {
        this.character = character;
    }

    @Override
    public abstract String getAbilities();
}
