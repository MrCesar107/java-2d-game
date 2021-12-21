package principal.maps;

import principal.sprites.Sprite;

import java.awt.*;

public class Tile {
    private final Sprite sprite;
    private final int ID;
    private boolean solid;

    public Tile(final Sprite sprite, final int id) {
        this.sprite = sprite;
        this.ID = id;
        this.solid = false;
    }

    public Tile(final Sprite sprite, final int id, final boolean solid) {
        this.sprite = sprite;
        this.ID = id;
        this.solid = solid;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getID() {
        return ID;
    }

    public void setSolid(final boolean solid) {
        this.solid = solid;
    }

    public Rectangle getLimits(final int x, final int y) {
        return new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
    }
}
