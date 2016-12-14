package FBLT.factories.product.electronics.audio;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.electronics.audio.Audio;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class AudioFactoryImpl implements IAudioFactory {

    private static AudioFactoryImpl factory = null;

    private AudioFactoryImpl() {

    }

    public static AudioFactoryImpl getInstance() {
        if (factory == null)
            factory = new AudioFactoryImpl();

        return factory;
    }

    @Override
    public Audio getAudio(Map<String, String> details) {
        Audio finalProduct = new Audio.Builder().build();

        if (details.containsKey("make")) {
            Audio audioWithMake = new Audio.Builder()
                    .copy(finalProduct)
                    .productMake(details.get("make"))
                    .build();
            finalProduct = audioWithMake;

        }
        if (details.containsKey("model")) {
            Audio audioWithModel = new Audio.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = audioWithModel;
        }
        if (details.containsKey("type")) {
            Audio audioWithType = new Audio.Builder()
                    .copy(finalProduct)
                    .productType(details.get("type"))
                    .build();
            finalProduct = audioWithType;
        }
        if (details.containsKey("watts")) {
            Audio audioWithWatts = new Audio.Builder()
                    .copy(finalProduct)
                    .productWatts(details.get("watts"))
                    .build();
            finalProduct = audioWithWatts;
        }
        if (details.containsKey("category")) {
            Audio bookWithAuthor = new Audio.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("ad-description")) {
            Audio bookWithAuthor = new Audio.Builder()
                    .copy(finalProduct)
                    .productDescription(details.get("ad-description"))
                    .build();
            finalProduct = bookWithAuthor;
        }


        return finalProduct;
    }
}
