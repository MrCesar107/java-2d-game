package principal.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        Graphics2D g = (Graphics2D) acceleratedImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return acceleratedImage;
    }

    public static String readTextFile(final String path) {
        String content = "";

        InputStream inputBytes = ClassLoader.class.getResourceAsStream(path);
        System.out.println(inputBytes);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputBytes));

        String line;

        try {
            while((line = reader.readLine()) != null){
                content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputBytes != null) {
                    inputBytes.close();
                }

                if (reader != null) {
                    reader.close();
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        return content;
    }
}
