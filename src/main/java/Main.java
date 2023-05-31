import no.brunostengine.*;
import no.brunostengine.components.Collideable;
import no.brunostengine.components.Component;
import no.brunostengine.components.KeyControls;
import no.brunostengine.components.Spawner;
import no.brunostengine.components.cameras.FollowTargetCamera;
import no.brunostengine.components.debuggingtools.DebugTools;
import no.brunostengine.components.debuggingtools.GridLines;
import no.brunostengine.physics.components.BoxCollider;
import no.brunostengine.physics.components.Rigidbody;
import no.brunostengine.physics.enums.BodyType;
import org.joml.Vector2f;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Game game = Game.get();
        game.init("Hello World!");
        Game.changeScene(new SceneBuilder() {
            @Override
            public String assignTitleToScene() {
                // Set the title of the scene to "hello_world"
                return "";
            }

            @Override
            public void loadResources(Scene scene) {
                // Call the add method inside SpriteHandler three times:
                // -    Set the first with the following arguments: "assets/images/orb-Sheet.png", with spriteWidth as 64, spriteHeight as 64, number of sprites as 3, spacing as 0
                // -    Set the first with the following arguments: "assets/images/RatGirlSpritesheet.png", with spriteWidth as 70, spriteHeight as 75, number of sprites as 8, spacing as 0
                // -    Set the first with the following arguments: "assets/images/defaultTiles.png", with spriteWidth as 64, spriteHeight as 64, number of sprites as 3, spacing as 0
            }

            @Override
            public void init(Scene scene) {

                // Create a new Tilemap object by calling on generateTilemap(), set the row and column arguments both to 60
                // Create a new Spritesheet object named "tileSprites" by calling SpriteHandler's getSpritesheet(), set the argument to take the filename "defaultTiles.png"
                // Create a new GameObject named tile through the generateSpriteObject method, set the first argument to take "tileSprites" calling getSprite() with an index of 1, and set argument sizeX and sizeY to 0.25f
                // - Add a Collideable object as a component
                // Create a new Rigidbody object
                // - Set the BodyType to BodyType.Static
                // On object "tile" previously created, add the rigidbody as a new component
                // Create a new BoxCollider object
                // - Set the Half Size to a new Vector2f object with x and y as 0.25f parameter.
                // GameObject "tile":
                // -    add the Rigidbody object as a component
                // -    add the BoxCollider object as a component
                // -    add a new Tile object as a component
                // -    add a new Collideable object as a component
                // On the Tilemap object, set the tilemapBackground to the third
                // On the Tilemap object, fill the border with the Tile object you created
                // On the Tilemap object, add the Tilemap to the scene


                // Create a new GameObject named "debuggingTools"
                // -    Set no serialization
                // -    add a new DebugTools object as a component
                // -    add a new KeyControls object as a component
                // -    add a new GridLines object as a component
                // -    add a new FollowTargetCamera object as a component with the constructor argument taking the scene's camera
                // On the "scene" variable, add the "debuggingTools" as a new GameObject in the scene
                // On the "debugging" variable, get the DebugTools component and set the gameObjectToPlace as the orb created from the AssetCreator class

                // Create a new GameObject named "ratgirl" through the local AssetCreator method
                // -    Get the transform property and set position to a new Vector2f object, with constructor arguments taking x: 2, y:3
                // On "scene" variable, add the "ratgirl" as a new GameObject in the scene
            }
        });
        game.run();
    }
}
