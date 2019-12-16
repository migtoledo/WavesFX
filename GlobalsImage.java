/**
 *
 */
package application;


import javafx.scene.image.Image;

/**
 * @author mtg
 *
 */
public class GlobalsImage {

    static Image loadImage(String fileName) {
        return new Image("file:" + fileName);
    }

    GlobalsImage() {

    }

}
