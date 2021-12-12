package principal.sprites;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.awt.image.BufferedImage;

public class Sprite {
    private final BufferedImage image;
    private final int width, height;

    public Sprite(final BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
