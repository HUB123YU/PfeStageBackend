package ma.zs.stocky.integration.core.stage.stage-pieces-attachement;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class StagePiecesAttachementIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("StagePiecesAttachementHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
