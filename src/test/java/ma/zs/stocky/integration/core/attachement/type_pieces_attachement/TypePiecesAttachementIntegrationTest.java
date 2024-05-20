package ma.zs.stocky.integration.core.attachement.type-pieces-attachement;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class TypePiecesAttachementIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("TypePiecesAttachementHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
