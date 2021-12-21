package principal.sprites;

import principal.tools.AssetsLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    final private int sheetWidth, sheetHeight, sheetWidthInSprites, sheetHeightInSprites;
    final private int spriteWidth, spriteHeight;
    final private Sprite[] sprites;

    // Constructor for sprite sheets with square sprites
    public SpriteSheet(final String path, final int spriteSize, final boolean opaqueSheet) throws IOException {
        final BufferedImage image;

        if(opaqueSheet) {
            image = AssetsLoader.loadCompatibleOpaqueImage(path);
        } else {
            image = AssetsLoader.loadCompatibleTranslucentImage(path);
        }

        sheetWidth = image.getWidth();
        sheetHeight = image.getHeight();

        sheetWidthInSprites = sheetWidth / spriteSize;
        sheetHeightInSprites = sheetHeight / spriteSize;

        this.spriteWidth = spriteSize;
        this.spriteHeight = spriteSize;

        sprites = new Sprite[sheetWidthInSprites * sheetHeightInSprites];

        extractSpritesFromImage(image);
    }

    // Constructor for sprite sheets with no-square sprites
    public SpriteSheet(final String path, final int spriteWidth, final int spriteHeight, final boolean opaqueSheet) throws IOException {
        final BufferedImage image;

        if(opaqueSheet) {
            image = AssetsLoader.loadCompatibleOpaqueImage(path);
        } else {
            image = AssetsLoader.loadCompatibleTranslucentImage(path);
        }

        sheetWidth = image.getWidth();
        sheetHeight = image.getHeight();

        sheetWidthInSprites = sheetWidth / spriteWidth;
        sheetHeightInSprites = sheetHeight / spriteHeight;

        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

        sprites = new Sprite[sheetWidthInSprites * sheetHeightInSprites];

        extractSpritesFromImage(image);
    }

    private void extractSpritesFromImage(final BufferedImage image) {
        for(int i = 0; i < sheetHeightInSprites; i++) {
            for(int j = 0; j < sheetWidthInSprites; j++) {
                final int xPosition = j * spriteWidth;
                final int yPosition = i * spriteHeight;
                sprites[j + i * sheetWidthInSprites] = new Sprite(image.getSubimage(xPosition, yPosition, spriteWidth, spriteHeight));
            }
        }
    }

    public Sprite getSprite(final int index) {
        return sprites[index];
    }

    public Sprite getSprite(final int x, final int y) {
        return sprites[x + y * this.spriteWidth];
    }
}
