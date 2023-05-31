import no.brunostengine.*;
import no.brunostengine.components.Collideable;
import no.brunostengine.components.KeyControls;
import no.brunostengine.components.Spawner;
import no.brunostengine.components.cameras.FollowTargetCamera;
import no.brunostengine.components.debuggingtools.DebugTools;
import no.brunostengine.components.debuggingtools.GridLines;
import no.brunostengine.physics.components.BoxCollider;
import no.brunostengine.physics.components.Rigidbody;
import no.brunostengine.physics.enums.BodyType;
import org.joml.Vector2f;

public class TestSolution extends SceneBuilder {
    @Override
    public String assignTitleToScene() {
        return "hello_world";
    }

    @Override
    public void loadResources(Scene scene) {
        String orbSheet = "assets/images/orb-Sheet.png";
        String ratgirlSheet = "assets/images/RatGirlSpritesheet.png";
        String tileSheet = "assets/images/defaultTiles.png";
        SpriteHandler.add(orbSheet, 64, 64, 3, 0);
        SpriteHandler.add(ratgirlSheet, 70, 75, 8, 0);
        SpriteHandler.add(tileSheet, 64, 64, 4, 1);
    }

    @Override
    public void init(Scene scene) {
        Tilemap tilemap = Tilemap.generateTilemap(60, 60);
        Spritesheet tileSprites = SpriteHandler.getSpritesheet("defaultTiles.png");
        GameObject tile = AssetBuilder.generateSpriteObject(tileSprites.getSprite(1), 0.25f, 0.25f);

        tile.addComponent(new Collideable());
        Rigidbody rb = new Rigidbody();
        rb.setBodyType(BodyType.Static);
        tile.addComponent(rb);
        BoxCollider b2d = new BoxCollider();
        b2d.setHalfSize(new Vector2f(0.25f, 0.25f));
        tile.addComponent(b2d);
        tile.addComponent(new Tile());
        tilemap.setTilemapBackground(tileSprites.getSprite(2));
        tilemap.fillBorder(tile);
        tilemap.addTilemapToScene();


        GameObject debuggingTools = scene.createGameObject("debuggingTools"); //
        debuggingTools.setNoSerialize();
        debuggingTools.addComponent(new DebugTools());
        debuggingTools.addComponent(new KeyControls());
        debuggingTools.addComponent(new GridLines());
        debuggingTools.addComponent(new FollowTargetCamera(scene.camera()));
        scene.addGameObjectToScene(debuggingTools);
        debuggingTools.getComponent(DebugTools.class).gameObjectToPlace = AssetCreator.generateOrb();

        // Ratgirl
        GameObject ratgirl = AssetCreator.generateRatgirl();
        ratgirl.transform.position = new Vector2f(2, 3);
        scene.addGameObjectToScene(ratgirl);

    }
}
