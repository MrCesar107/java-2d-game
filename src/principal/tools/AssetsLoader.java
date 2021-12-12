package principal.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoader {
    public static BufferedImage loadCompatibleOpaqueImage(final String path) throws IOException {
        Image image = ImageIO.read(ClassLoader.class.getResource(path));

        GraphicsConfiguration config = GraphicsEnvironment
                                        .getLocalGraphicsEnvironment()
                                        .getDefaultScreenDevice()
                                        .getDefaultConfiguration();

        BufferedImage acceleratedImage = config.createCompatibleImage(image.getWidth(null),
                                                                      image.getHeight(null),
                                                                      Transparency.OPAQUE);

        Graphics g = acceleratedImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return acceleratedImage;
    }

    public static BufferedImage loadCompatibleTranslucentImage(final String path) throws IOException {
        Image image = ImageIO.read(ClassLoader.class.getResource(path));

        GraphicsConfiguration config = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        BufferedImage acceleratedImage = config.createCompatibleImage(image.getWidth(null),
                                                                      image.getHeight(null),
                                                                      Transparency.TRANSLUCENT);

        Graphics g = acceleratedImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return acceleratedImage;
    }
}
