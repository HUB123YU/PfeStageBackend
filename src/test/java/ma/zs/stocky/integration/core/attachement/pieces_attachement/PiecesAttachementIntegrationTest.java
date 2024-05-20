package ma.zs.stocky.integration.core.attachement.pieces-attachement;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class PiecesAttachementIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("PiecesAttachementHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
